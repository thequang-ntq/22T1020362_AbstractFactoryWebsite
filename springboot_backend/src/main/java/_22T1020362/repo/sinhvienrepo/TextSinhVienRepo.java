package _22T1020362.repo.sinhvienrepo;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Scanner;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import _22T1020362.config.TextConfig;
import _22T1020362.exception.SinhVienException;
//import _22T1020362.models.Nganh;
//import _22T1020362.models.Nganh;
import _22T1020362.models.SinhVien;
import lombok.*;

@AllArgsConstructor
@Repository
public class TextSinhVienRepo implements ISinhVienRepo{
	
	@Autowired
	private TextConfig textConfig;
	
	@Override
    public List<SinhVien> readSV() {
        List<SinhVien> list = new ArrayList<>();
        try {
			WebClient webClient = WebClient.builder()
	                .baseUrl("https://api.github.com/gists/" + textConfig.getGistidsv())
	                .defaultHeader(HttpHeaders.AUTHORIZATION, "token " + textConfig.getGittoken())
	                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	                .build();

	        // Gửi request GET để lấy nội dung Gist
	        String gistResponse = webClient.get()
	                .retrieve()
	                .bodyToMono(String.class)
	                .block();

	        // Trích xuất nội dung file từ JSON
	        JSONObject gistJson = new JSONObject(gistResponse);
	        String content = gistJson.getJSONObject("files").getJSONObject(textConfig.getFilenamesv()).getString("content");

	        // Xử lý từng dòng bằng split("\n")
	        String[] lines = content.split("\n");
	        for (String line : lines) {
	        	String [] lst = line.split(",");
	            SinhVien sv = new SinhVien(lst[0], lst[1], Integer.valueOf(lst[2]));
	            list.add(sv);
	        }
		} catch (Exception e) {
			throw new SinhVienException("Lỗi khi đọc dữ liệu sinh viên từ file: " + e.getMessage(), e);
		}
        return list;
    }
	
	@Override
    public void deleteSV(String msv) {
		List<SinhVien> lst = readSV();
		boolean removed = lst.removeIf(sv -> sv.getMaSinhVien().equals(msv));
		if(removed) {
			try {
				WebClient webClient = WebClient.builder()
		                .baseUrl("https://api.github.com/gists/" + textConfig.getGistidsv())
		                .defaultHeader(HttpHeaders.AUTHORIZATION, "token " + textConfig.getGittoken())
		                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		                .build();

		        // Lấy nội dung Gist hiện tại
		        String gistResponse = webClient.get()
		                .retrieve()
		                .bodyToMono(String.class)
		                .block();

		        // Trích xuất nội dung file từ JSON
		        JSONObject gistJson = new JSONObject(gistResponse);
		        String currentContent = gistJson.getJSONObject("files").getJSONObject(textConfig.getFilenamesv()).getString("content");

		        // Xóa dòng có chứa mã sinh viên
		        List<String> updatedLines = Arrays.stream(currentContent.split("\n"))
		                .filter(line -> !line.contains(msv))
		                .collect(Collectors.toList());

		        // Chuyển danh sách về chuỗi
		        String newContent = String.join("\n", updatedLines);

		        // Cập nhật lại Gist với nội dung mới
		        JSONObject updateJson = new JSONObject();
		        JSONObject fileContent = new JSONObject();
		        fileContent.put("content", newContent);
		        JSONObject files = new JSONObject();
		        files.put(textConfig.getFilenamesv(), fileContent);
		        updateJson.put("files", files);

		        // Gửi request PATCH để cập nhật Gist
		        webClient.method(HttpMethod.PATCH)
		                .bodyValue(updateJson.toString())
		                .retrieve()
		                .bodyToMono(String.class)
		                .block();
			} catch (Exception e) {
				throw new SinhVienException("Lỗi khi xóa dữ liệu sinh viên khỏi file: " + e.getMessage(), e);
			}
	        
		}
		else {
			throw new SinhVienException("Hệ thống không tìm thấy sinh viên có mã: " + msv);
        }
    }
}
