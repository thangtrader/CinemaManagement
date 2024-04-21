use QuanLyRapChieuPhim
go
--- dang nhap
create proc KiemTraDangNhap
	@TenTaiKhoan varchar(30),
	@MatKhau varchar(32)
as
begin
    if exists (select * from NHAN_VIEN where TenTaiKhoan = @TenTaiKhoan and MatKhau = @MatKhau and MaChucVu = 'CV0002' and TrangThai = '1')	-- admin
        select 2 as code
    else if exists (select * from NHAN_VIEN where TenTaiKhoan = @TenTaiKhoan and MatKhau = @MatKhau and MaChucVu = 'CV0001' and TrangThai = '1') -- phim
        select 1 as code
	else if exists (select * from NHAN_VIEN where TenTaiKhoan = @TenTaiKhoan and MatKhau = @MatKhau and TrangThai = '0')
        select -2 as code
	else if exists (select * from NHAN_VIEN where TenTaiKhoan = @TenTaiKhoan and MatKhau != @MatKhau)
        select 0 as code
    else select -1 as code
end
go
---cap nhat nhan vien
go
create proc CapNhatNhanVien
    @MaNhanVien varchar(6),
    @TenNhanVien nvarchar(30),
    @NgaySinh datetime,
	@GioiTinh bit,
	@DiaChi nvarchar(50),
	@SoDienThoai varchar(15),
	@CCCD varchar(20),
	@TenTaiKhoan varchar(30),
	@MatKhau varchar(32),
	@Anh image,
	@MaChinhSach varchar(6) ,
	@MaChucVu varchar(6) 
	as 
	begin 
	update  NHAN_VIEN set TenNhanVien=@TenNhanVien,GioiTinh=@GioiTinh,NgaySinh=@NgaySinh,DiaChi=@DiaChi,SoDienThoai=@SoDienThoai,CCCD=@CCCD,TenTaiKhoan=@TenTaiKhoan,MatKhau=@MatKhau,Anh=@Anh,MaChinhSach=@MaChinhSach,MaChucVu=@MaChucVu
	where MaNhanVien=@MaNhanVien
end
go
-- Them phong chieu
create proc ThemPhongChieu
	@TenPhong nvarchar(20),
	@MaTinhTrang int,
	@MaLoaiPhongChieu  varchar(6)
as
begin
	insert into PHONG_CHIEU(TenPhong,MaTinhTrang) values (@TenPhong, @MaTinhTrang)
end
go
-- CapNhatPhongChieu
create proc CapNhatPhongChieu
	@MaPhongChieu varchar(6),
	@TenPhong nvarchar(20),
	@MaTinhTrang int
as
begin
	Update PHONG_CHIEU set	TenPhong = @TenPhong,	MaTinhTrang = @MaTinhTrang
	where MaPhongChieu = @MaPhongChieu
end
go
---CapNhatLichChieu
create proc CapNhatLichChieu
	@MaPhim varchar(6), 
	@MaPhongChieu varchar(6),
	@MaKhungGio varchar(8),
	@NgayChieu date,
	@TrangThai varchar(1)
as
begin
	Update LICH_CHIEU set	TrangThai = @TrangThai
	where MaPhim = @MaPhim and 	MaPhongChieu = @MaPhongChieu and MaKhungGioChieu=@MaKhungGio and NgayChieu=@NgayChieu 
end
go
--- Them lich lam viec
go
create proc ThemLichLamViec
	@MaNhanVien varchar(6),
	@MaCa varchar(6),
	@NgayLamViec date
as
begin
	insert into LICH_LAM_VIEC(MaNhanVien,MaCa,NgayLamViec) values (@MaNhanVien, @MaCa, @NgayLamViec)
end
go
----- xoa lich lam viec
go
create proc XoaLichLamViec
	@MaNhanVien varchar(6),
	@MaCa varchar(6),
	@NgayLamViec date
as
begin 
	DELETE FROM LICH_LAM_VIEC
	where MaNhanVien = @MaNhanVien and MaCa = @MaCa and NgayLamViec = @NgayLamViec
end
Go
--Hiển thị tất cả bảng The Loai Phim
Create proc SelectTheLoaiPhim
As
Begin
	Select * From THE_LOAI_PHIM
End
Go
--Hiện thị bảng Phim nhưng lấy TenTheLoai thay MaTheLoai
Create proc SelectPhim
As
Begin
	SELECT p.MaPhim, p.TenPhim, p.ThoiLuong, p.QuocGia, p.DaoDien, p.NamSanXuat, p.DoTuoiXem, t.TenTheLoaiPhim
	FROM PHIM as p INNER JOIN THE_LOAI_PHIM as t ON p.MaTheLoai = t.MaTheLoaiPhim;
End
Go
Create proc GetPhimByMa
	@MaPhim varchar(6)
As
Begin
	SELECT p.MaPhim, p.TenPhim, p.ThoiLuong, p.QuocGia, p.DaoDien, p.NamSanXuat, p.DoTuoiXem, t.TenTheLoaiPhim
	FROM PHIM as p INNER JOIN THE_LOAI_PHIM as t ON p.MaTheLoai = t.MaTheLoaiPhim
	Where @MaPhim = MaPhim
End
Exec GetPhimByMa P00001	
Go
--Thêm Phim
Create proc ThemPhim

	@TenPhim nvarchar(50),
	@ThoiLuong int,
	@QuocGia nvarchar(20),
	@NamSanXuat datetime,
	@DoTuoiXem int,
	@MaTheLoai varchar(6),
	@DaoDien nvarchar(50)
	As 
	Begin 
		INSERT INTO PHIM (TenPhim,ThoiLuong,QuocGia,NamSanXuat,DoTuoiXem,MaTheLoai ,DaoDien)
		Values (@TenPhim,@ThoiLuong,@QuocGia,@NamSanXuat, @DoTuoiXem, @MaTheLoai ,@DaoDien);
	End
Go
--Xóa Phim theo mã
Create proc XoaPhim(@MaPhim varchar(6))
As
Begin
	Delete PHIM Where MaPhim = @MaPhim
End
Go
--Sửa Phim theo mã
Create proc SuaPhim
	@MaPhim varchar(6),
	@TenPhim nvarchar(50),
	@ThoiLuong int,
	@QuocGia nvarchar(20),
	@NamSanXuat datetime,
	@DoTuoiXem int,
	@MaTheLoai varchar(6),
	@DaoDien nvarchar(50)
	As
	Begin
		Update PHIM Set TenPhim = @TenPhim, ThoiLuong = @ThoiLuong, QuocGia = @QuocGia, NamSanXuat = @NamSanXuat, DoTuoiXem = @DoTuoiXem, MaTheLoai = @MaTheLoai, DaoDien = @DaoDien
		Where MaPhim = @MaPhim
	End
Go
Create proc SelectAllTKNV
As
Begin
	Select DISTINCT n.MaNhanVien, n.TenNhanVien, n.GioiTinh, DATEDIFF(HOUR, clv.GioBatDau, clv.GioKetThuc) AS SoGioLam, ROUND((DATEDIFF(HOUR, clv.GioBatDau, clv.GioKetThuc) * cs.HeSoLuong*18000),2) AS TongTien
	FROM NHAN_VIEN n
    INNER JOIN LICH_LAM_VIEC llv ON n.MaNhanVien = llv.MaNhanVien
    INNER JOIN CA_LAM_VIEC clv ON llv.MaCa = clv.MaCa
    INNER JOIN CHINH_SACH cs ON n.MaChinhSach = cs.MaChinhSach
End	
Go
--Hiện thi bảng nhân viên
Create proc SelectNhanVien
As
Begin
	Select n.MaNhanVien, n.TenNhanVien, n.NgaySinh, n.GioiTinh, n.SoDienThoai, c.TenChinhSach, cv.TenChucVu
	From NHAN_VIEN as n INNER JOIN CHINH_SACH as c On n.MaChinhSach = c.MaChinhSach INNER JOIN  CHUC_VU as cv On n.MaChucVu = cv.MaChucVu
End
Go
--Thêm  nhân viên
Create proc ThemNhanVien

	@TenNhanVien nvarchar(30),
	@NgaySinh date,
	@GioiTinh nvarchar(3),
	@DiaChi nvarchar(50),
	@SoDienThoai varchar(15),
	@CCCD varchar(20),
	@TenTaiKhoan varchar(30),
	@MatKhau varchar(32),
	@MaChinhSach varchar(6),
	@MaChucVu varchar(6),
	@TrangThai varchar(1)
	As 
	Begin 
		INSERT INTO NHAN_VIEN(TenNhanVien,NgaySinh,GioiTinh,DiaChi,SoDienThoai,CCCD,TenTaiKhoan,MatKhau,MaChinhSach,MaChucVu,TrangThai)
		Values (@TenNhanVien,@NgaySinh,@GioiTinh,@DiaChi,@SoDienThoai,@CCCD,@TenTaiKhoan,@MatKhau,@MaChinhSach,@MaChucVu,@TrangThai);
	End
Go
--Cập nhật bảng nhân viên theo mã
Create proc SuaNhanVien
	@MaNhanVien varchar(6),
	@TenNhanVien nvarchar(30),
	@NgaySinh date,
	@GioiTinh nvarchar(3),
	@DiaChi nvarchar(50),
	@SoDienThoai varchar(15),
	@CCCD varchar(20),
	@TenTaiKhoan varchar(30),
	@MatKhau varchar(32),
	@MaChinhSach varchar(6),
	@MaChucVu varchar(6),
	@TrangThai varchar(1)
	As
	Begin
		Update NHAN_VIEN Set TenNhanVien = @TenNhanVien, NgaySinh = @NgaySinh, GioiTinh = @GioiTinh, DiaChi = @DiaChi, SoDienThoai = @SoDienThoai, CCCD = @CCCD, TenTaiKhoan = @TenTaiKhoan, MatKhau = @MatKhau, MaChinhSach = @MaChinhSach, MaChucVu = @MaChucVu, TrangThai = @TrangThai
		Where MaNhanVien = @MaNhanVien
		
	End
Go
--Xóa nhân viên theo mã
Create proc XoaNhanVien(@MaNhanVien varchar(6))
As
Begin
	Delete NHAN_VIEN Where MaNhanVien = @MaNhanVien
End
--Lấy bảng nhân viên theo mã nhân viên
Create proc GetNhanVien
	@MaNhanVien varchar(6)
As
Begin
	Select n.MaNhanVien, n.TenNhanVien, n.NgaySinh, n.GioiTinh, n.DiaChi, n.SoDienThoai, n.CCCD, n.TenTaiKhoan, n.MatKhau, c.TenChinhSach, cv.TenChucVu, n.TrangThai
	From NHAN_VIEN as n INNER JOIN CHINH_SACH as c On n.MaChinhSach = c.MaChinhSach INNER JOIN  CHUC_VU as cv On n.MaChucVu = cv.MaChucVu
	Where @MaNhanVien = MaNhanVien
End
Go
--Hiện thị bảng chính sách
Create proc SelectChinhSach
As
Begin
	Select MaChinhSach, TenChinhSach From CHINH_SACH
End
Go
--Hiện thị bảng chức vụ
Create proc SelectChucVu
As
Begin
	Select * From CHUC_VU
End
Go
create PROCEDURE HienThiThongTinNhanVien
AS
BEGIN
    SELECT DISTINCT NV.MaNhanVien, NV.TenNhanVien, NV.GioiTinh,
           SUM(CASE 
               WHEN CLV.GioBatDau IS NOT NULL AND CLV.GioKetThuc IS NOT NULL THEN DATEDIFF(HOUR, CLV.GioBatDau, CLV.GioKetThuc)
               ELSE 0
           END) OVER(PARTITION BY NV.MaNhanVien) AS SoGioLam,
           ROUND(SUM(CS.HeSoLuong * 18000 * CASE 
                             WHEN CLV.GioBatDau IS NOT NULL AND CLV.GioKetThuc IS NOT NULL THEN DATEDIFF(HOUR, CLV.GioBatDau, CLV.GioKetThuc)
                             ELSE 0
                         END) OVER(PARTITION BY NV.MaNhanVien), 2) AS TongLuong
    FROM NHAN_VIEN NV
    LEFT JOIN LICH_LAM_VIEC LLV ON NV.MaNhanVien = LLV.MaNhanVien
    LEFT JOIN CA_LAM_VIEC CLV ON LLV.MaCa = CLV.MaCa
    LEFT JOIN CHINH_SACH CS ON NV.MaChinhSach = CS.MaChinhSach
END

go 
CREATE PROCEDURE TinhTongLuongNhanVien
AS
BEGIN
    DECLARE @TongLuong DECIMAL(18, 2);

    -- Tạo bảng tạm để lưu kết quả từ procedure HienThiThongTinNhanVien
    CREATE TABLE #TempTable (
        MaNhanVien NVARCHAR(50),
        TenNhanVien NVARCHAR(100),
        GioiTinh nvarchar(3),
        SoGioLam DECIMAL(18, 2),
        TongLuong DECIMAL(18, 2)
    );

    -- Thực thi procedure HienThiThongTinNhanVien và lưu kết quả vào bảng tạm
    INSERT INTO #TempTable (MaNhanVien, TenNhanVien, GioiTinh, SoGioLam, TongLuong)
    EXEC HienThiThongTinNhanVien;

    -- Tính tổng số lương của tất cả các nhân viên
    SELECT @TongLuong = SUM(TongLuong) FROM #TempTable;

    -- Hiển thị tổng số lương
    SELECT @TongLuong AS TongLuong;

    -- Xóa bảng tạm sau khi sử dụng
    DROP TABLE #TempTable;
END;
go
create PROCEDURE HienThiTop5
AS
BEGIN
    WITH EmployeeSalary AS (
        SELECT DISTINCT 
            NV.MaNhanVien, 
            NV.TenNhanVien, 
            NV.GioiTinh,
            SUM(CASE 
                WHEN CLV.GioBatDau IS NOT NULL AND CLV.GioKetThuc IS NOT NULL THEN DATEDIFF(HOUR, CLV.GioBatDau, CLV.GioKetThuc)
                ELSE 0
            END) AS SoGioLam,
            ROUND(SUM(CS.HeSoLuong * 18000 * CASE 
                WHEN CLV.GioBatDau IS NOT NULL AND CLV.GioKetThuc IS NOT NULL THEN DATEDIFF(HOUR, CLV.GioBatDau, CLV.GioKetThuc)
                ELSE 0
            END), 2) AS TongLuong
        FROM 
            NHAN_VIEN NV
        LEFT JOIN 
            LICH_LAM_VIEC LLV ON NV.MaNhanVien = LLV.MaNhanVien
        LEFT JOIN 
            CA_LAM_VIEC CLV ON LLV.MaCa = CLV.MaCa
        LEFT JOIN 
            CHINH_SACH CS ON NV.MaChinhSach = CS.MaChinhSach
        GROUP BY 
            NV.MaNhanVien, 
            NV.TenNhanVien, 
            NV.GioiTinh
    )
    SELECT 
        TenNhanVien,
        Hang
    FROM (
        SELECT 
            *,
            ROW_NUMBER() OVER (ORDER BY TongLuong DESC) AS Hang
        FROM 
            EmployeeSalary
    ) AS RankedEmployees
    WHERE 
        Hang <= 5
    ORDER BY 
        TongLuong DESC;
END
go 
Create proc GetNhanVienByTenTaiKhoan
	@TenTaiKhoan varchar(30)
	As
	Begin
		Select TenNhanVien, NgaySinh, DiaChi, GioiTinh, CCCD, SoDienThoai, TenTaiKhoan, MatKhau From NHAN_VIEN
		Where @TenTaiKhoan = TenTaiKhoan
	End
Go
	Drop proc GetNhanVienByTenTaiKhoan
	Exec GetNhanVienByTenTaiKhoan thangadmin
