package _22T1020362.repo.nganhrepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import _22T1020362.config.MySQLConfig;
import _22T1020362.exception.NganhException;
//import _22T1020362.exception.SinhVienException;
import _22T1020362.models.Nganh;
import lombok.*;

@AllArgsConstructor
@Repository
public class MySQLNganhRepo implements INganhRepo{
	
	private final MySQLConfig mySQLConfig;
	
	@Override
	public List<Nganh> readNDT(){
	
		List<Nganh> lst = new ArrayList<>();
		String sql = "SELECT * FROM Nganh;";
		try {
			Connection cn = mySQLConfig.dataSource().getConnection();
			PreparedStatement pr = cn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				Nganh ndt = new Nganh(rs.getInt(1), rs.getString(2));
				lst.add(ndt);
			}
			rs.close(); pr.close();
		}
		catch(Exception e) {
			throw new NganhException("Lỗi khi đọc dữ liệu ngành từ CSDL MySQL: " + e.getMessage(), e);
		}
	
		return lst;

	}
	
	@Override
	public void insertNDT(Nganh ndt){
	
		String sql1 = "SELECT * FROM Nganh WHERE MaNganh LIKE " + "'" + ndt.getMaNganh() + "'";
		String sql2 = "INSERT INTO Nganh (MaNganh, TenNganh) VALUES (?, ?)";
		try {
			Connection cn = mySQLConfig.dataSource().getConnection();
			PreparedStatement pr = cn.prepareStatement(sql1);
			ResultSet rs = pr.executeQuery();
			if(rs.isBeforeFirst()) {
				throw new NganhException("Mã ngành đã tồn tại trong hệ thống");
			}
			else {
				pr = cn.prepareStatement(sql2);
				pr.setInt(1, ndt.getMaNganh());
	            pr.setString(2, ndt.getTenNganh());
	            int rowInserted = pr.executeUpdate();
	            if(rowInserted > 0) {
//	            	System.out.println("Thêm mới ngành đào tạo có mã: " + ndt.getMaNganh() + " thành công");
	            }
	            else {
	            	throw new NganhException("Lỗi không xác định khi thêm dữ liệu ngành vào CSDL MySQL");
	            }
			}
			rs.close();
			pr.close();
		}
		catch(Exception e) {
			throw new NganhException("Lỗi khi thêm dữ liệu ngành vào CSDL MySQL: " + e.getMessage(), e);
		}

	}
	
	
}
