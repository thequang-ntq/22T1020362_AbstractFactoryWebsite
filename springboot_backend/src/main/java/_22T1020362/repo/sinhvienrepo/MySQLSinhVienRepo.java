package _22T1020362.repo.sinhvienrepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import _22T1020362.config.MySQLConfig;
import _22T1020362.exception.SinhVienException;
import _22T1020362.models.SinhVien;
import lombok.*;

@AllArgsConstructor
@Repository
public class MySQLSinhVienRepo implements ISinhVienRepo{
	
	private final MySQLConfig mySQLConfig;
	
	@Override
	public List<SinhVien> readSV(){
	
		List<SinhVien> lst = new ArrayList<>();
		String sql = "SELECT * FROM SinhVien;";
		try {
			Connection cn = mySQLConfig.dataSource().getConnection();
			PreparedStatement pr = cn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				SinhVien s = new SinhVien(rs.getString(1), rs.getString(2), rs.getInt(3));
				lst.add(s);
			}
			rs.close(); pr.close();
		}
		catch(Exception e) {
			throw new SinhVienException("Lỗi khi đọc dữ liệu sinh viên từ CSDL MySQL: " + e.getMessage(), e);
		}
	
		return lst;

	}
	
	@Override
	public void deleteSV(String msv){
	
		String sql1 = "SELECT * FROM SinhVien WHERE MaSinhVien LIKE " + "'" + msv + "'";
		String sql2 = "DELETE FROM SinhVien WHERE MaSinhVien LIKE ?";
		try {
			Connection cn = mySQLConfig.dataSource().getConnection();
			PreparedStatement pr = cn.prepareStatement(sql1);
			ResultSet rs = pr.executeQuery();
			if(!rs.isBeforeFirst()) {
				throw new SinhVienException("Mã sinh viên không tồn tại trong hệ thống");
			}
			else {
				pr = cn.prepareStatement(sql2);
				pr.setString(1, msv);
	            int rowInserted = pr.executeUpdate();
	            if(rowInserted > 0) {
	            	//
	            }
	            else {
	            	throw new SinhVienException("Lỗi không xác định khi xóa dữ liệu sinh viên khỏi CSDL MySQL");
	            }
			}
			rs.close();
			pr.close();
		}
		catch(Exception e) {
			throw new SinhVienException("Lỗi khi xóa dữ liệu sinh viên khỏi CSDL MySQL: " + e.getMessage(), e);
		}

	}
	
	
}
