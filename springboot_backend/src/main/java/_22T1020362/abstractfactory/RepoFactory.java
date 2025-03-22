package _22T1020362.abstractfactory;

import _22T1020362.repo.nganhrepo.INganhRepo;
import _22T1020362.repo.sinhvienrepo.ISinhVienRepo;

public abstract class RepoFactory {
	public abstract ISinhVienRepo getSinhVienRepo();
	public abstract INganhRepo getNganhRepo();
}
