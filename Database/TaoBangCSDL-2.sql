go
use QuanLyRapChieuPhim
go
--Bang The Loai Phim
Create table THE_LOAI_PHIM
(
	MaTheLoaiPhim varchar(6) primary key not null constraint IDTLP default dbo.AUTO_IDTLP(),
	TenTheLoaiPhim nvarchar(20)
)
go
--Bang Phim

Create table PHIM(
	MaPhim varchar(6) primary key not null constraint IDP default dbo.AUTO_IDP(),
	TenPhim nvarchar(50),
	AnhPhim varchar(1000),
	ThoiLuong int,
	QuocGia nvarchar(20),
	NamSanXuat date,
	DoTuoiXem int,
	MaTheLoai varchar(6) foreign key(MaTheLoai) references THE_LOAI_PHIM,
	DaoDien nvarchar(50)
)
-- Bang Phong Chieu
create table TINH_TRANG_PHONG_CHIEU
(
	MaTinhTrang  int identity(1,1) primary key not null,
	TenTinhTrang nvarchar(40) 
)
Create table PHONG_CHIEU(
	MaPhongChieu varchar(6) primary key not null constraint IDPC default dbo.AUTO_IDPC(),
	TenPhong nvarchar(20),
	MaTinhTrang int foreign key(MaTinhTrang) references TINH_TRANG_PHONG_CHIEU,
)
go
--Bang Khung Gio Chieu

Create table KHUNG_GIO_CHIEU(
	MaKhungGioChieu varchar(8) primary key not null constraint IDKGC default dbo.AUTO_IDKGC(),
	TenKhungGio nvarchar(30),
	TGBatDau time,
	TGKetThuc time
)
go
--Bang Lich Chieu
Create table LICH_CHIEU(
	MaPhim varchar(6) foreign key(MaPhim) references PHIM,
	MaPhongChieu varchar(6) foreign key(MaPhongChieu) references PHONG_CHIEU,
	MaKhungGioChieu varchar(8) foreign key(MaKhungGioChieu) references KHUNG_GIO_CHIEU,
	NgayChieu date,
	TrangThai varchar(1),	-- 0(Ko chap nhan), 1(du kien), 2(chinh thuc),
	constraint pk_LichChieu primary key(MaPhim,MaPhongChieu,MaKhungGioChieu, NgayChieu)
)
go
--Bang Ca Lam Viec

Create table CA_LAM_VIEC(
	MaCa varchar(6) primary key not null constraint IDCLV default dbo.AUTO_IDCLV(),
	TenCa nvarchar(40),
	GioBatDau time,
	GioKetThuc time
)
go
-- Bang Ngay Lam Viec

go
--Bang Chinh Sach

Create table CHINH_SACH(
	MaChinhSach varchar(6) primary key not null constraint IDCS default dbo.AUTO_IDCS(),
	TenChinhSach nvarchar(30),
	HeSoLuong Float(4),
	BHXH varchar(20),
	TienThuong int
)
go
-- Bang Chuc Vu

Create table CHUC_VU(
	MaChucVu varchar(6) primary key not null constraint IDCV default dbo.AUTO_IDCV(),
	TenChucVu nvarchar(20)
)
go
--Bang Nhan Vien

Create table NHAN_VIEN(
	MaNhanVien varchar(6) primary key not null constraint IDNV default dbo.AUTO_IDNV(),
	TenNhanVien nvarchar(30),
	NgaySinh date,
	GioiTinh nvarchar(3),
	DiaChi nvarchar(50),
	SoDienThoai varchar(15),
	CCCD varchar(20),
	TenTaiKhoan varchar(30),
	MatKhau varchar(32),
	Anh varchar(1000),
	MaChinhSach varchar(6) foreign key(MaChinhSach) references CHINH_SACH,
	MaChucVu varchar(6) foreign key(MaChucVu) references CHUC_VU,
	TrangThai varchar(1)---0(tat),1(bat)
)
go
--Bang Chi Tiet Ca Lam

Create table LICH_LAM_VIEC(
	MaNhanVien varchar(6) foreign key(MaNhanVien) references NHAN_VIEN,
	MaCa varchar(6) foreign key(MaCa) references CA_LAM_VIEC,
	NgayLamViec date ,
	constraint pk_CTCaLamViec primary key(MaNhanVien,MaCa,NgayLamViec)
)
go
-- Bang Loai Phieu

Create table LOAI_PHIEU(
	MaLoaiPhieu varchar(5) primary key not null constraint IDLP default dbo.AUTO_IDLP(),
	TenLoaiPhieu nvarchar(30)
)
go
--Bang Phieu

Create table PHIEU(
	MaPhieu varchar(6) primary key not null constraint IDPH default dbo.AUTO_IDPH(), 
	MaLoaiPhieu varchar(5) foreign key(MaLoaiPhieu) references LOAI_PHIEU,
	MaNhanVien varchar(6) foreign key(MaNhanVien) references NHAN_VIEN,
	NgayLapPhieu date
)
go
--Bang Chi Tiet Phieu Phim
Create table CHI_TIET_PHIEU_PHIM(
	MaPhieu varchar(6) foreign key(MaPhieu) references PHIEU,
	MaPhim varchar(6) foreign key(MaPhim) references PHIM,
	DonViTinh nvarchar(20),
	SoLuong int,
	constraint pk_CTPhieuPhim primary key(MaPhieu,MaPhim)
)

ALTER TABLE NHAN_VIEN
ALTER COLUMN MatKhau varchar(100);