package _22T1020362.repo.sinhvienrepo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

import org.springframework.stereotype.Repository;

import _22T1020362.config.TextConfig;
import _22T1020362.exception.SinhVienException;
//import _22T1020362.models.Nganh;
import _22T1020362.models.SinhVien;
import lombok.*;

@AllArgsConstructor
@Repository
public class TextSinhVienRepo implements ISinhVienRepo{
	
	private final TextConfig textConfig;
	
	@Override
    public List<SinhVien> readSV() {
        List<SinhVien> list = new ArrayList<>();
        try {
			FileReader fr = new FileReader(textConfig.txtPathSV());
			BufferedReader br = new BufferedReader(fr);
	        String line;
	        while((line = br.readLine()) != null) {
	        	if(line.isEmpty()) break;
	        	String [] lst = line.split(",");
	        	SinhVien sv = new SinhVien(lst[0], lst[1] , Integer.valueOf(lst[2]));
	        	list.add(sv);
	        }
	        br.close();
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
			FileWriter fw;
			try {
				fw = new FileWriter(textConfig.txtPathSV(), false);
				BufferedWriter bw = new BufferedWriter(fw);
				for(SinhVien sv: lst) {
					bw.write(sv.toString());
					bw.newLine();
				}
				bw.close();
			} catch (IOException e) {
				throw new SinhVienException("Lỗi khi xóa dữ liệu sinh viên khỏi file: " + e.getMessage(), e);
			}
	        
//			System.out.println("Hệ thống đã xóa sinh viên có mã: " + msv);
		}
		else {
			throw new SinhVienException("Hệ thống không tìm thấy sinh viên có mã: " + msv);
        }
    }
}
