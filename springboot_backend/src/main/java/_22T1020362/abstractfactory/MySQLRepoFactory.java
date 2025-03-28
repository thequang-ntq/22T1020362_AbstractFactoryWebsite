package _22T1020362.abstractfactory;

import org.springframework.stereotype.Component;

import _22T1020362.repo.nganhrepo.INganhRepo;
import _22T1020362.repo.nganhrepo.MySQLNganhRepo;
import _22T1020362.repo.sinhvienrepo.ISinhVienRepo;
import _22T1020362.repo.sinhvienrepo.MySQLSinhVienRepo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class MySQLRepoFactory extends RepoFactory {
	private MySQLSinhVienRepo mySQLSinhVienRepo;
	private MySQLNganhRepo mySQLNganhRepo;
	
	@Override
	public ISinhVienRepo getSinhVienRepo() {
		return this.mySQLSinhVienRepo;
	}
	
	@Override
	public INganhRepo getNganhRepo() {
		return this.mySQLNganhRepo;
	}
}
