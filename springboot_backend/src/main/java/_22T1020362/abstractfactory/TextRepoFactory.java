package _22T1020362.abstractfactory;

import org.springframework.stereotype.Component;
import _22T1020362.repo.nganhrepo.INganhRepo;
import _22T1020362.repo.nganhrepo.TextNganhRepo;
import _22T1020362.repo.sinhvienrepo.ISinhVienRepo;
import _22T1020362.repo.sinhvienrepo.TextSinhVienRepo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class TextRepoFactory extends RepoFactory {
    
	private TextSinhVienRepo textSinhVienRepo;
	private TextNganhRepo textNganhRepo;

    @Override
    public ISinhVienRepo getSinhVienRepo() {
        return this.textSinhVienRepo;
    }

    @Override
    public INganhRepo getNganhRepo() {
        return this.textNganhRepo;
    }
}
