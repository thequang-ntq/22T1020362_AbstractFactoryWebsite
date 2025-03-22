package _22T1020362.abstractfactory;

import org.springframework.stereotype.Component;

import _22T1020362.repo.nganhrepo.INganhRepo;
import _22T1020362.repo.nganhrepo.MongoDBNganhRepo;
import _22T1020362.repo.sinhvienrepo.ISinhVienRepo;
import _22T1020362.repo.sinhvienrepo.MongoDBSinhVienRepo;
import lombok.*;

@AllArgsConstructor
@Component
public class MongoDBRepoFactory extends RepoFactory{
	private MongoDBSinhVienRepo mongoDBSinhVienRepo;
	private MongoDBNganhRepo mongoDBNganhRepo;
	
	@Override
	public ISinhVienRepo getSinhVienRepo() {
		return this.mongoDBSinhVienRepo;
	}
	
	@Override
	public INganhRepo getNganhRepo() {
		return this.mongoDBNganhRepo;
	}
}
