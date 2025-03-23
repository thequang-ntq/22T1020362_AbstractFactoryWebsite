package _22T1020362.repo.nganhrepo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

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
	
	private final TextConfig textConfig;
	
	@Override
    public List<Nganh> readNDT() {
        List<Nganh> list = new ArrayList<>();
		try {
			FileReader fr = new FileReader(textConfig.txtPathNDT());
			BufferedReader br = new BufferedReader(fr);
	        String line;
	        while((line = br.readLine()) != null) {
	        	if(line.isEmpty()) break;
	        	String [] lst = line.split(",");
	        	Nganh ndt = new Nganh(Integer.valueOf(lst[0]), lst[1]);
	        	list.add(ndt);
	        }
	        br.close();
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
				FileWriter fw;
				fw = new FileWriter(textConfig.txtPathNDT(), true);
				BufferedWriter bw = new BufferedWriter(fw);
		        bw.write(ndt.toString());
		        bw.newLine();
		        bw.close();
//		        System.out.println("Thêm mới ngành đào tạo có mã: " + ndt.getMaNganh() + " thành công");
			} catch (IOException e) {
				throw new NganhException("Lỗi khi thêm dữ liệu ngành vào file: " + e.getMessage(), e);
			}
		}
    }
}
