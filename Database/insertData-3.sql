go
use QuanLyRapChieuPhim
go
------1. Thể loại phim ----- TLP001
insert into THE_LOAI_PHIM (TenTheLoaiPhim) values (N'Hài');
insert into THE_LOAI_PHIM (TenTheLoaiPhim) values (N'Cổ trang');
insert into THE_LOAI_PHIM (TenTheLoaiPhim) values (N'Tình cảm');
insert into THE_LOAI_PHIM (TenTheLoaiPhim) values (N'Kinh dị');
insert into THE_LOAI_PHIM (TenTheLoaiPhim) values (N'Phiêu lưu mạo hiểm');
insert into THE_LOAI_PHIM (TenTheLoaiPhim) values (N'Khoa học viễn tưởng');
--- Đã xong
-----8. Phim------ P00001
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values (N'Gia đình đức hạnh','https://static2.vieon.vn/vieplay-image/poster_v4/2021/10/21/0aierfw0_660x946-giadinhduchanh.jpg','90',N'Thái Lan','2020-12-22',18,'TLP001',N'Yuthlert Sippapak');
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'Mắt Biếc','https://upload.wikimedia.org/wikipedia/vi/4/42/%C3%81p_ph%C3%ADch_phim_M%E1%BA%AFt_bi%E1%BA%BFc.jpg','97',N'Việt Nam','2020-12-22',18,'TLP003',N'Victor Vũ');
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'Nhà có khách','https://dep.com.vn/wp-content/uploads/2019/04/En_OfficialPoster1_FixNew_01.jpg','90',N'Việt Nam','2021-12-22',18,'TLP001',N'Trấn Thành');
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'Em chưa 18','https://upload.wikimedia.org/wikipedia/vi/1/1f/Em_ch%C6%B0a_18_poster.jpg','90',N'Việt Nam','2019-12-20',18,'TLP003',N'Lê Thanh Sơn');
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'Bố già','https://www.cucdienanh.vn/upload/images/undefined/1/28_06_2021/image001_urah_1624855630.jpg','90',N'Việt Nam','2020-12-22',18,'TLP001',N'Trấn Thành');

insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'Bẫy ngọt ngào','https://thanhnien.mediacdn.vn/Uploaded/caotung/2022_01_17/bnn-red-new-year-poster-4707.jpg','90',N'Thái Lan','2020-09-22',18,'TLP003',N'Đinh Hà Uyên Thư');
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'Em và Trịnh','https://khenphim.com/wp-content/uploads/2022/06/Em-va-Trinh-1-poster.jpg','90',N'Việt Nam','2020-09-22',18,'TLP003',N'Phan Gia Nhật Linh');
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'Chung Cực Bút Ký','https://4.bp.blogspot.com/-xAzjjCQuVqo/X9OKb9MSyrI/AAAAAAAAJW4/5Zr2b7nNM34dDGWGRnSqRdn9o1kEsgwrQCLcBGAsYHQ/s0/poster.jpg','95',N'Trung Quốc','2020-09-22',13,'TLP005',N'Châu Duy');
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'Sa Hải','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3NAr6hW8lOtQAFvxkenTBHOUYxeueLp7waKqvbgYi3w&s','90',N'Trung Quốc','2020-09-22',18,'TLP005',N'Từ Lỗi');
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'Nộ Hải Tiềm Sa','https://image.tmdb.org/t/p/original/m9NPHbnwxxRXlPEzlE5tJ2BeFXO.jpg','90',N'Việt Nam','2020-09-22',18,'TLP003',N'Đức Thắng');
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'Vân Đỉnh Thiên Cung','https://bazaarvietnam.vn/wp-content/uploads/2023/06/harper-bazaar-review-phim-khach-san-vuong-gia-king-the-land-11-e1687070439587.jpg','90',N'Trung Quốc','2020-09-22',18,'TLP003',N'Lưu Quốc Huy');
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'Lão Cữu Môn','https://ss-images.saostar.vn/2015/12/11/140668/trieu-le-dinh-lao-cuu-mon-02.jpg','90',N'Trung Quốc','2020-09-22',18,'TLP003',N'Hoàng Tuấn Văn');
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'30 Chưa Phải Là Tết','https://vnmedia.vn/file/8a10a0d36ccebc89016ce0c6fa3e1b83/8a10a0d36d961641016da40adf3508e0/012020/TruongGiangVietAnh1_20200110145318.jpg','137',N'Việt Nam','2022-01-22',13,'TLP004',N'Quang Huy');
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'Tàng Hải Hoa','https://d19ri4mdy82u9u.cloudfront.net/images/651bbcfc03c3da4c3ae4c060/ZGsN2iFd7GIcj2plTeLI.jpg','120',N'Trung Quốc','2021-12-22',16,'TLP005',N'Trịnh Hiểu Long');
insert into PHIM (TenPhim,AnhPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
values(N'Đại Hồng Thủy','https://icdn.dantri.com.vn/a3HWDOlTcvMNT73KRccc/Image/2014/03/24-72d5b.jpg','125',N'Anh','2020-09-22',16,'TLP004',N'Darren Aronofsky');

-- tinh trang phong chieu
insert into TINH_TRANG_PHONG_CHIEU(TenTinhTrang) values (N'Tốt');
insert into TINH_TRANG_PHONG_CHIEU(TenTinhTrang) values (N'Hỏng');
insert into TINH_TRANG_PHONG_CHIEU(TenTinhTrang) values (N'Bảo trì');
-----11. Phòng chiếu PC0001
insert into PHONG_CHIEU(TenPhong,MaTinhTrang) values (N'Phòng số 1','3');
insert into PHONG_CHIEU(TenPhong,MaTinhTrang) values (N'Phòng số 2','1');
insert into PHONG_CHIEU(TenPhong,MaTinhTrang) values (N'Phòng số 3','1');
insert into PHONG_CHIEU(TenPhong,MaTinhTrang) values (N'Phòng số 4','2');
insert into PHONG_CHIEU(TenPhong,MaTinhTrang) values (N'Phòng số 5','1');
insert into PHONG_CHIEU(TenPhong,MaTinhTrang) values (N'Phòng số 6','1');
---- Đã xong
------12. Khung giờ chiếu -----------KGC00001  
insert into KHUNG_GIO_CHIEU(TenKhungGio,TGBatDau,TGKetThuc) values(N'Khung giờ số 1','08:00:00.0000000','11:00:00.0000000');
insert into KHUNG_GIO_CHIEU(TenKhungGio,TGBatDau,TGKetThuc) values(N'Khung giờ số 2','11:00:00.0000000','14:00:00.0000000');
insert into KHUNG_GIO_CHIEU(TenKhungGio,TGBatDau,TGKetThuc) values(N'Khung giờ số 3','14:00:00.0000000','17:00:00.0000000');
insert into KHUNG_GIO_CHIEU(TenKhungGio,TGBatDau,TGKetThuc) values(N'Khung giờ số 4','17:00:00.0000000','20:00:00.0000000');
insert into KHUNG_GIO_CHIEU(TenKhungGio,TGBatDau,TGKetThuc) values(N'Khung giờ số 5','20:00:00.0000000','23:00:00.0000000');
----Đã xong
------13.Lịch chiếu
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0002','KGC00001','2024-01-02','1');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0002','KGC00002','2024-02-01','0');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0002','KGC00004','2024-01-02','2');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0002','KGC00003','2024-03-01','0');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0003','KGC00001','2024-04-02','2');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0003','KGC00002','2024-01-03','2');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0003','KGC00004','2024-02-03','1');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00002','PC0003','KGC00003','2024-03-03','0');

insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00002','PC0002','KGC00001','2024-02-02','0');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00003','PC0002','KGC00002','2024-03-03','1');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0002','KGC00004','2024-01-04','2');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0002','KGC00003','2024-01-04','0');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0003','KGC00001','2024-03-05','1');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0003','KGC00002','2024-02-02','2');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0003','KGC00004','2024-01-12','1');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00002','PC0003','KGC00003','2024-03-01','0');

insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00004','PC0005','KGC00001','2024-04-12','0');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00005','PC0005','KGC00002','2024-01-05','1');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00005','PC0005','KGC00004','2024-02-03','1');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00005','PC0005','KGC00003','2024-01-06','2');

insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0006','KGC00001','2024-03-07','1');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0006','KGC00002','2024-03-04','2');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00001','PC0006','KGC00004','2024-03-02','1');
insert into LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai) VALUES('P00002','PC0006','KGC00003','2024-01-03','0');

------14.Ca làm việc ----- CLV001
insert into CA_LAM_VIEC(TenCa,GioBatDau,GioKetThuc) values(N'Ca 1','08:00:00.0000000','12:00:00.0000000');
insert into CA_LAM_VIEC(TenCa,GioBatDau,GioKetThuc) values(N'Ca 2','12:00:00.0000000','16:00:00.0000000');
insert into CA_LAM_VIEC(TenCa,GioBatDau,GioKetThuc) values(N'Ca 3','16:00:00.0000000','20:00:00.0000000');
insert into CA_LAM_VIEC(TenCa,GioBatDau,GioKetThuc) values(N'Ca 4','20:00:00.0000000','23:59:59.0000000');
----Đã xong

---- Đã xong
------16. Chính sách ------- CS0001
insert into CHINH_SACH(TenChinhSach,HeSoLuong,BHXH,TienThuong) values ('Chính sách 1','2.4','2 năm','700000');
insert into CHINH_SACH(TenChinhSach,HeSoLuong,BHXH,TienThuong) values ('Chính sách 2','2.2','1 năm','500000');
insert into CHINH_SACH(TenChinhSach,HeSoLuong,BHXH,TienThuong) values ('Chính sách 3','2','6 tháng','300000');
----- Đã xong
-----17.Chức vụ ------ CV0001
insert into CHUC_VU(TenChucVu) values (N'Nhân viên');
insert into CHUC_VU(TenChucVu) values (N'Quản trị viên');
----- Đã xong
------18.Nhân viên -----
insert into NHAN_VIEN(TenNhanVien,NgaySinh,GioiTinh,DiaChi,SoDienThoai,CCCD,TenTaiKhoan,MatKhau,MaChinhSach,MaChucVu,TrangThai)--123456789
Values (N'Nguyễn Đức Thắng','2004-08-30',N'Nam',N'Quảng Trị','0325043590','045204000730','thangadmin','123456','CS0002','CV0002','1');
insert into NHAN_VIEN(TenNhanVien,NgaySinh,GioiTinh,DiaChi,SoDienThoai,CCCD,TenTaiKhoan,MatKhau,MaChinhSach,MaChucVu,TrangThai)--123456789
Values (N'Nguyễn Văn Toàn','2004-06-15',N'Nam',N'Quảng Nam','0325045456','0452041234674','toanadmin','123456','CS0002','CV0002','1');
insert into NHAN_VIEN(TenNhanVien,NgaySinh,GioiTinh,DiaChi,SoDienThoai,CCCD,TenTaiKhoan,MatKhau,MaChinhSach,MaChucVu,TrangThai)--123456789
Values (N'Lê Thành Ý','2004-07-24',N'Nam',N'Bình Định','0325041234','045204999808','ynhanvien','123456','CS0001','CV0001','1');
insert into NHAN_VIEN(TenNhanVien,NgaySinh,GioiTinh,DiaChi,SoDienThoai,CCCD,TenTaiKhoan,MatKhau,MaChinhSach,MaChucVu,TrangThai)--123456
Values (N'Hồ Văn Thanh','2004-07-30',N'Nam',N'Quảng Trị','0325011234','04520401252','thanhnhanvien','123456','CS0001','CV0001','1');
insert into NHAN_VIEN(TenNhanVien,NgaySinh,GioiTinh,DiaChi,SoDienThoai,CCCD,TenTaiKhoan,MatKhau,MaChinhSach,MaChucVu,TrangThai)--987654321
Values (N'Nguyễn Thị Huyền Thương','2004-05-12',N'Nữ',N'Hà Tĩnh','031452342','0452041111235','thuongnhanvien','123456','CS0002','CV0001','1');
insert into NHAN_VIEN(TenNhanVien,NgaySinh,GioiTinh,DiaChi,SoDienThoai,CCCD,TenTaiKhoan,MatKhau,MaChinhSach,MaChucVu,TrangThai)--123456
Values (N'Phan Thị Kim Ngân','2004-08-03',N'Nữ',N'Quảng Trị','0325041236','04520430078242','ngannhanvien','123456','CS0001','CV0001','1');
insert into NHAN_VIEN(TenNhanVien,NgaySinh,GioiTinh,DiaChi,SoDienThoai,CCCD,TenTaiKhoan,MatKhau,MaChinhSach,MaChucVu,TrangThai)--123456
Values (N'Nguyễn Văn Thắng','2004-10-30',N'Nam',N'Đà Nẵng','097860007','045201234567','thangnhanvien','123456','CS0002','CV0001','1');
insert into NHAN_VIEN(TenNhanVien,NgaySinh,GioiTinh,DiaChi,SoDienThoai,CCCD,TenTaiKhoan,MatKhau,MaChinhSach,MaChucVu,TrangThai)--123456
Values (N'Trần Trung Hiếu','2004-01-30',N'Nam',N'Quảng Trị','0325049999','045204550730','hieuadmin','123456','CS0002','CV0002','1');
insert into NHAN_VIEN(TenNhanVien,NgaySinh,GioiTinh,DiaChi,SoDienThoai,CCCD,TenTaiKhoan,MatKhau,MaChinhSach,MaChucVu,TrangThai)--123456
Values (N'Nguyễn Thị Yến Nhi','2004-04-30',N'Nữ',N'Hà Nội','0325048888','045204099990','nhinhanvien','123456','CS0001','CV0001','1');
insert into NHAN_VIEN(TenNhanVien,NgaySinh,GioiTinh,DiaChi,SoDienThoai,CCCD,TenTaiKhoan,MatKhau,MaChinhSach,MaChucVu,TrangThai)--123456
Values (N'Nguyễn Phan Hà','2004-11-30',N'Nữ',N'Cà Mau','0943754517','045204700898','hanhanvien','123456','CS0001','CV0001','1');

-----Đã xong
------19. lịch làm việc
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0002','CLV001','2022-07-26');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0006','CLV001','2022-07-26');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0008','CLV001','2022-07-26');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0009','CLV001','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0004','CLV002','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0001','CLV002','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0007','CLV002','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0009','CLV002','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0001','CLV003','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0002','CLV003','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0003','CLV003','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0006','CLV003','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0010','CLV001','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0002','CLV004','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0008','CLV004','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0001','CLV004','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0004','CLV004','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0007','CLV004','2022-07-02');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0010','CLV004','2022-07-02');

insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0001','CLV001','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0005','CLV001','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0006','CLV001','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0009','CLV001','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0002','CLV002','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0003','CLV002','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0007','CLV002','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0009','CLV002','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0001','CLV003','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0004','CLV003','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0003','CLV003','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0002','CLV003','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0008','CLV003','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0010','CLV003','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0002','CLV004','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0006','CLV004','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0001','CLV004','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0004','CLV004','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0007','CLV004','2022-07-01');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0009','CLV004','2022-07-01');

insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0003','CLV001','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0005','CLV001','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0008','CLV001','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0010','CLV001','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0004','CLV002','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0001','CLV002','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0007','CLV002','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0009','CLV002','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0001','CLV003','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0002','CLV003','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0003','CLV003','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0006','CLV003','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0009','CLV001','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0002','CLV004','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0008','CLV004','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0001','CLV004','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0004','CLV004','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0007','CLV004','2022-07-03');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0010','CLV004','2022-07-03');

insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0003','CLV001','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0005','CLV001','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0008','CLV001','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0010','CLV001','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0004','CLV002','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0001','CLV002','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0007','CLV002','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0009','CLV002','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0001','CLV003','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0002','CLV003','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0003','CLV003','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0008','CLV003','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0009','CLV001','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0002','CLV004','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0006','CLV004','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0003','CLV004','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0004','CLV004','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0007','CLV004','2022-07-04');
insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values ('NV0010','CLV004','2022-07-04');
----- Đã xong
-----30. Loại phiếu--------LP0001
insert into LOAI_PHIEU(TenLoaiPhieu) values (N'Phiếu nhập');
insert into LOAI_PHIEU(TenLoaiPhieu) values (N'Phiếu xuất');
----- Đã xong
-----31. Phiếu--------PH0001	12phieu

insert into PHIEU(MaLoaiPhieu,NgayLapPhieu,MaNhanVien)	
values ('LP002','2022-05-26','NV0005');
insert into PHIEU(MaLoaiPhieu,NgayLapPhieu,MaNhanVien)	
values ('LP001','2022-05-27','NV0006');

insert into PHIEU(MaLoaiPhieu,NgayLapPhieu,MaNhanVien)
values ('LP001','2023-05-27','NV0001');					
insert into PHIEU(MaLoaiPhieu,NgayLapPhieu,MaNhanVien)
values ('LP001','2023-05-28','NV0002');
insert into PHIEU(MaLoaiPhieu,NgayLapPhieu,MaNhanVien)
values ('LP002','2023-05-26','NV0002');		

insert into PHIEU(MaLoaiPhieu,NgayLapPhieu,MaNhanVien)
values ('LP001','2023-06-29','NV0006');
insert into PHIEU(MaLoaiPhieu,NgayLapPhieu,MaNhanVien)
values ('LP001','2022-04-29','NV0007');
insert into PHIEU(MaLoaiPhieu,NgayLapPhieu,MaNhanVien)
values ('LP002','2022-04-30','NV0008');
insert into PHIEU(MaLoaiPhieu,NgayLapPhieu,MaNhanVien)
values ('LP002','2022-04-20','NV0006');

---- Đã xong
-----32. Chi tiết phiếu phim
insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0005','P00001',N'Đĩa','3');
insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0005','P00002',N'Đĩa','3');
insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0005','P00003',N'Đĩa','10');

insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0006','P00001',N'Đĩa','3');
insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0006','P00002',N'Đĩa','3');
insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0006','P00004',N'Đĩa','5');

insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0007','P00001',N'Đĩa','2');
insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0007','P00002',N'Đĩa','2');
insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0007','P00004',N'Đĩa','5');

insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0008','P00001',N'Đĩa','2');
insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0008','P00002',N'Đĩa','2');
insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0008','P00005',N'Đĩa','10');

insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0009','P00005',N'Đĩa','2');
insert into CHI_TIET_PHIEU_PHIM(MaPhieu,MaPhim,DonViTinh,SoLuong) values('PH0009','P00003',N'Đĩa','1');