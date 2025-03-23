package _22T1020362.repo.nganhrepo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import _22T1020362.config.MongoDBConfig;
import _22T1020362.exception.NganhException;
//import _22T1020362.exception.SinhVienException;
import _22T1020362.models.Nganh;
import lombok.*;

@AllArgsConstructor
@Repository
public class MongoDBNganhRepo implements INganhRepo{
	
	private MongoDBConfig mongoDBConfig;

	@Override
	public List<Nganh> readNDT(){
		List<Nganh> lst = new ArrayList<>();
		try {
            MongoDatabase db = this.mongoDBConfig.mongoDatabase(this.mongoDBConfig.mongoClient());
            MongoCollection<Document> collection = db.getCollection("nganh");
            FindIterable<Document> documents = collection.find();
            // Chuyển đổi Document thành Student
            for (Document doc : documents) {
            	int maNganh = doc.getInteger("MaNganh");
                String tenNganh = doc.getString("TenNganh");

                Nganh ndt = new Nganh(maNganh, tenNganh);
                lst.add(ndt);
            }
        } catch (Exception e) {
        	throw new NganhException("Lỗi khi đọc dữ liệu ngành từ CSDL MongoDB: " + e.getMessage(), e);
        }
		return lst;

	}
	
	@Override
	public void insertNDT(Nganh ndt){
		
		try {
			MongoDatabase db = this.mongoDBConfig.mongoDatabase(this.mongoDBConfig.mongoClient());
            MongoCollection<Document> collection = db.getCollection("nganh");

            Document found = collection.find(Filters.eq("MaNganh", ndt.getMaNganh())).first();
            if(found != null) {
            	throw new NganhException("Mã ngành đã tồn tại trong hệ thống");
            }
            else {
            	Document newNDT = new Document("MaNganh", ndt.getMaNganh()).append("TenNganh", ndt.getTenNganh());
                collection.insertOne(newNDT);

//                System.out.println("Đã chèn thành công ngành: " + newNDT.toJson());
            }
            
        } catch (Exception e) {
        	throw new NganhException("Lỗi khi thêm dữ liệu ngành vào CSDL MongoDB: " + e.getMessage(), e);
        }
		
	}
}
