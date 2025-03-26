package _22T1020362.repo.nganhrepo;

import org.json.JSONObject;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.StringReader;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;

import _22T1020362.config.TextConfig;
import _22T1020362.exception.NganhException;
//import _22T1020362.exception.SinhVienException;
import _22T1020362.models.Nganh;
//import _22T1020362.models.SinhVien;
import lombok.*;

@AllArgsConstructor
@Repository
public class TextNganhRepo implements INganhRepo{
	
	@Autowired
	private TextConfig textConfig;
	
	@Override
    public List<Nganh> readNDT() {
        List<Nganh> list = new ArrayList<>();
		try {
			WebClient webClient = WebClient.builder()
	                .baseUrl("https://api.github.com/gists/" + textConfig.getGistidndt())
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
	        String content = gistJson.getJSONObject("files").getJSONObject(textConfig.getFilenamendt()).getString("content");

	        // Xử lý từng dòng bằng split("\n")
	        String[] lines = content.split("\n");
	        for (String line : lines) {
	        	System.out.println(line);
	        	String [] lst = line.split(",");
	            Nganh ndt = new Nganh(Integer.valueOf(lst[0]), lst[1]);
	            list.add(ndt);
	        }
		} catch (Exception e) {
			throw new NganhException("Lỗi khi đọc dữ liệu ngành từ file: " + e.getMessage(), e);
		}
        return list;
    }
	
	@Override
    public void insertNDT(Nganh ndt) {
		List<Nganh> lst = readNDT();
		boolean check = false;
		for(Nganh n: lst) {
			if(n.getMaNganh() == ndt.getMaNganh()) {
				check = true;
				throw new NganhException("Mã ngành đã tồn tại trong hệ thống: " + ndt.getMaNganh());
			}
		}
		if(!check) {
			try {
				WebClient webClient = WebClient.builder()
		                .baseUrl("https://api.github.com/gists/" + textConfig.getGistidndt())
		                .defaultHeader(HttpHeaders.AUTHORIZATION, "token " + textConfig.getGittoken())
		                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		                .build();

		        // Lấy nội dung hiện tại của Gist
		        String gistResponse = webClient.get()
		                .retrieve()
		                .bodyToMono(String.class)
		                .block();

		        // Trích xuất nội dung file từ JSON
		        JSONObject gistJson = new JSONObject(gistResponse);
		        String currentContent = gistJson.getJSONObject("files").getJSONObject(textConfig.getFilenamendt()).getString("content");

		        // Thêm dòng mới
		        String newContent = currentContent + ndt.toString() +  "\n";

		        // Cập nhật lại Gist với nội dung mới
		        JSONObject updateJson = new JSONObject();
		        JSONObject fileContent = new JSONObject();
		        fileContent.put("content", newContent);
		        JSONObject files = new JSONObject();
		        files.put(textConfig.getFilenamendt(), fileContent);
		        updateJson.put("files", files);

		        // Gửi request PUT để cập nhật Gist
		        webClient.method(HttpMethod.PATCH)
		                .bodyValue(updateJson.toString())
		                .retrieve()
		                .bodyToMono(String.class)
		                .block();

			} catch (Exception e) {
				throw new NganhException("Lỗi khi thêm dữ liệu ngành vào file: " + e.getMessage(), e);
			}
		}
    }
}
