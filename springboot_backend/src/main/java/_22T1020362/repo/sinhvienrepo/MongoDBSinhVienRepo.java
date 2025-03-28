package _22T1020362.repo.sinhvienrepo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import _22T1020362.config.MongoDBConfig;
import _22T1020362.exception.SinhVienException;
import _22T1020362.models.SinhVien;
import lombok.*;

@AllArgsConstructor
@Repository
public class MongoDBSinhVienRepo implements ISinhVienRepo{
	
	private MongoDBConfig mongoDBConfig;
	
	@Override
	public List<SinhVien> readSV(){
		List<SinhVien> lst = new ArrayList<>();
		try {
			MongoDatabase db = this.mongoDBConfig.mongoDatabase(this.mongoDBConfig.mongoClient());
            MongoCollection<Document> collection = db.getCollection("sinhvien");
            FindIterable<Document> documents = collection.find();
            // Chuyển đổi Document thành Student
            for (Document doc : documents) {
                String maSinhVien = doc.getString("MaSinhVien");
                String hoTen = doc.getString("HoTen");
                int maNganh = doc.getInteger("MaNganh");

                SinhVien sv = new SinhVien(maSinhVien, hoTen, maNganh);
                lst.add(sv);
            }
        } catch (Exception e) {
        	throw new SinhVienException("Lỗi khi đọc dữ liệu sinh viên từ CSDL MongoDB: " + e.getMessage(), e);
        }
		return lst;

	}
	
	@Override
	public void deleteSV(String msv){
		
		try {
			MongoDatabase db = this.mongoDBConfig.mongoDatabase(this.mongoDBConfig.mongoClient());
            MongoCollection<Document> collection = db.getCollection("sinhvien");
            //Tìm có SV không
            Document found = collection.find(Filters.eq("MaSinhVien", msv)).first();
            if(found != null) {
            	collection.deleteOne(Filters.eq("MaSinhVien", msv));
//                System.out.println("Đã xóa sinh viên có MaSinhVien: " + msv);
            }
            else {
            	throw new SinhVienException("Mã sinh viên không tồn tại trong hệ thống");
            }
            
        } catch (Exception e) {
        	throw new SinhVienException("Lỗi khi xóa dữ liệu sinh viên khỏi CSDL MongoDB: " + e.getMessage(), e);
        }
		
	}
}
