package _22T1020362.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _22T1020362.abstractfactory.MongoDBRepoFactory;
import _22T1020362.models.Nganh;
import _22T1020362.models.SinhVien;
import lombok.*;

@AllArgsConstructor
@Service
@Transactional
public class MongoDBService {
	private MongoDBRepoFactory mongoDBRepoFactory;

	public List<SinhVien> readSV(){
		return mongoDBRepoFactory.getSinhVienRepo().readSV();
	}
	public void deleteSV(String msv){
		mongoDBRepoFactory.getSinhVienRepo().deleteSV(msv);
	}
	
	public List<Nganh> readNDT(){
		return mongoDBRepoFactory.getNganhRepo().readNDT();
	}
	public void insertNDT(Nganh ndt){
		mongoDBRepoFactory.getNganhRepo().insertNDT(ndt);
	}
}
