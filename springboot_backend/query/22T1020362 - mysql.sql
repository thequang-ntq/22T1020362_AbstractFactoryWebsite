USE mtk_abstractfactory;
CREATE TABLE Nganh(
	MaNganh INT NOT NULL,
	TenNganh VARCHAR(50) CHARSET utf8mb4 NOT NULL,
	CONSTRAINT PK_Nganh PRIMARY KEY (MaNganh)
);

CREATE TABLE SinhVien(
	MaSinhVien VARCHAR(10) CHARSET utf8mb4 NOT NULL,
	HoTen VARCHAR(50) CHARSET utf8mb4 NOT NULL,
	MaNganh INT NOT NULL,
	CONSTRAINT PK_SinhVien PRIMARY KEY (MaSinhVien),
	CONSTRAINT PK_SinhVien_Nganh FOREIGN KEY (MaNganh) REFERENCES Nganh (MaNganh)
);

INSERT INTO Nganh
VALUES	(101, "Điện tử viễn thông"),
		(102, "Công nghệ thông tin"),
        (103, "Toán ứng dụng"),
		(104, "Văn học"),
        (105, "Báo chí & Truyền thông"),
        (109, "Lịch sử"),
        (836, "Quản lý nhà nước")
;

INSERT INTO SinhVien
VALUES 	('T1020111', 'Lê Thị Hồng Hoa', 104),
		('T1020122', 'Trần Văn Quyến', 102),
        ('T1020133', 'Nguyễn Văn Tiến', 105),
        ('T1020234', 'Trần Nguyên Chính', 109),
        ('T1020912', 'Lê Thị Linh', 836)
;