package _22T1020362.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	private int maNganh;
	
	public String toString() {
        return maSinhVien + "," + hoTen + "," + maNganh;
    }
}
