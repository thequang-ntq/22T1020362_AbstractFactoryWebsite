package _22T1020362.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _22T1020362.abstractfactory.MySQLRepoFactory;
import _22T1020362.models.Nganh;
import _22T1020362.models.SinhVien;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class MySQLService {
	private MySQLRepoFactory mySQLRepoFactory;
	
	public List<SinhVien> readSV(){
		return mySQLRepoFactory.getSinhVienRepo().readSV();
	}
	public void deleteSV(String msv){
		mySQLRepoFactory.getSinhVienRepo().deleteSV(msv);
	}
	
	public List<Nganh> readNDT(){
		return mySQLRepoFactory.getNganhRepo().readNDT();
	}
	public void insertNDT(Nganh ndt){
		mySQLRepoFactory.getNganhRepo().insertNDT(ndt);
	}
}
