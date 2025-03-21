package _22T1020362.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _22T1020362.abstractfactory.TextRepoFactory;
import _22T1020362.models.Nganh;
import _22T1020362.models.SinhVien;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class TextService {
	private TextRepoFactory textRepoFactory;
	
	public List<SinhVien> readSV(){
		return textRepoFactory.getSinhVienRepo().readSV();
	}
	public void deleteSV(String msv){
		textRepoFactory.getSinhVienRepo().deleteSV(msv);
	}
	
	public List<Nganh> readNDT(){
		return textRepoFactory.getNganhRepo().readNDT();
	}
	public void insertNDT(Nganh ndt){
		textRepoFactory.getNganhRepo().insertNDT(ndt);
	}
}
