
use QuanLyRapChieuPhim2
go
--- dang nhap
Create proc KiemTraDangNhap
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
<<<<<<< HEAD

go
-- Them phong chieu
Create proc ThemPhongChieu
	@TenPhong nvarchar(20),
	@MaTinhTrang int,
	@MaLoaiPhongChieu  varchar(6)
as
begin
	insert into PHONG_CHIEU(TenPhong,MaTinhTrang) values (@TenPhong, @MaTinhTrang)
end
go
-- CapNhatPhongChieu
Create proc CapNhatPhongChieu
	@MaPhongChieu varchar(6),
	@TenPhong nvarchar(20),
	@MaTinhTrang int
as
begin
	Update PHONG_CHIEU set	TenPhong = @TenPhong,	MaTinhTrang = @MaTinhTrang
	where MaPhongChieu = @MaPhongChieu
end
go
/*
---CapNhatLichChieu
Create proc CapNhatLichChieu
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
*/
go
--- Them lich lam viec
Create proc ThemLichLamViec
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
Create proc XoaLichLamViec
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


=======
Go
--Hiển thị tất cả bảng The Loai Phim
>>>>>>> 01c2d5e3f0c7818a028f5075238c2a3c1d26de51
Create proc SelectAllPhim
As
Begin
	Select * From PHIM
End
Go

Create proc SelectAllTheLoaiPhim
As
Begin
	Select * From THE_LOAI_PHIM
End
Go

Create proc FindById(@MaPhim nvarchar(6))
As
Begin
	Select * From PHIM where MaPhim = @MaPhim
End
Go
<<<<<<< HEAD


=======
>>>>>>> 01c2d5e3f0c7818a028f5075238c2a3c1d26de51
Create proc SelectTheLoaiPhim
As
Begin
	Select * From THE_LOAI_PHIM
End
<<<<<<< HEAD

=======
>>>>>>> 01c2d5e3f0c7818a028f5075238c2a3c1d26de51
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
<<<<<<< HEAD


go


=======
>>>>>>> 01c2d5e3f0c7818a028f5075238c2a3c1d26de51
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
<<<<<<< HEAD

Go
--Sửa Phim theo mã


go

Create proc XoaPhim(@MaPhim varchar(6))
As
Begin
	Delete PHIM Where MaPhim = @MaPhim
End
Go

=======
Go
--Sửa Phim theo mã
>>>>>>> 01c2d5e3f0c7818a028f5075238c2a3c1d26de51
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

<<<<<<< HEAD
Go

=======
go
Create proc XoaPhim(@MaPhim varchar(6))
As
Begin
	Delete PHIM Where MaPhim = @MaPhim
End
>>>>>>> 01c2d5e3f0c7818a028f5075238c2a3c1d26de51
go
Create proc LoadPhim
As
Begin
	SELECT p.MaPhim, p.TenPhim, p.ThoiLuong, p.QuocGia, p.DaoDien, p.NamSanXuat, p.DoTuoiXem, t.TenTheLoaiPhim
	FROM PHIM as p INNER JOIN THE_LOAI_PHIM as t ON p.MaTheLoai = t.MaTheLoaiPhim;
End	
Go
<<<<<<< HEAD


=======
>>>>>>> 01c2d5e3f0c7818a028f5075238c2a3c1d26de51
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
Go
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
Create PROCEDURE HienThiThongTinNhanVien
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
Create PROCEDURE TinhTongLuongNhanVien
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
Create PROCEDURE HienThiTop5
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
<<<<<<< HEAD

=======
>>>>>>> 01c2d5e3f0c7818a028f5075238c2a3c1d26de51
Create proc GetNhanVienByTenTaiKhoan
	@TenTaiKhoan varchar(30)
	As
	Begin
		Select MaNhanVien, TenNhanVien, NgaySinh, DiaChi, GioiTinh, CCCD, SoDienThoai, TenTaiKhoan, MatKhau From NHAN_VIEN
		Where @TenTaiKhoan = TenTaiKhoan
	End
Go
Create proc SuaMatKhau
	@TenTaiKhoan varchar(30),
	@MatKhau varchar(32)
As
Begin
	Update NHAN_VIEN Set MatKhau = @MatKhau
	Where @TenTaiKhoan = TenTaiKhoan
End
Go
Create proc SuaAnh
	@MaNhanVien varchar(6),
	@Anh varchar(1000)
	As 
	Begin 
		Update NHAN_VIEN Set Anh = @Anh
		Where MaNhanVien = @MaNhanVien
	End
Go
<<<<<<< HEAD

--------- Tong Thong ke Phim
Create proc selectThongKePhim 
	as
	begin
		select p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim,sum(c.SoLuong) as soluong,sum(c.SoLuong) * 60000 as doanhthu
		from Phim p,CHI_TIET_PHIEU_PHIM c,THE_LOAI_PHIM t
		where p.MaTheLoai = t.MaTheLoaiPhim and p.maPhim = c.maPhim
		group by p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim
	end
go
---- doanh thu tong $$$$$$$$$$$$$$$
Create PROCEDURE tinhTongDoanhThu
AS
BEGIN
    DECLARE @TongDoanhThu DECIMAL(18, 2);
    -- Tạo bảng tạm để lưu kết quả từ procedure HienThiThongTinNhanVien
    CREATE TABLE #TempTable (
        MaPhim VARCHAR(6),
        TenPhim NVARCHAR(50),
        TenTheLoaiPhim nvarchar(20),
        soLuongVe int,
        doanhThu float
    );

    -- Thực thi procedure HienThiThongTinNhanVien và lưu kết quả vào bảng tạm
    INSERT INTO #TempTable (MaPhim, TenPhim, TenTheLoaiPhim, soLuongVe, doanhThu)
    EXEC selectThongKePhim;

    -- Tính tổng số lương của tất cả các nhân viên
    SELECT @TongDoanhThu = SUM(doanhThu) FROM #TempTable;

    -- Hiển thị tổng số lương
    SELECT @TongDoanhThu AS tongDoanhThu;

    -- Xóa bảng tạm sau khi sử dụng
    DROP TABLE #TempTable;
END;
go
---- thong ke Doanh thu theo thang 
Create proc selectThongKePhimTheoThangNam
	@thang int,
	@nam int
	as
	begin
		select p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim,sum(c.SoLuong) as soluong,sum(c.SoLuong) * 60000 as doanhthu
		from Phim p,CHI_TIET_PHIEU_PHIM c,THE_LOAI_PHIM t,PHIEU ph
		where p.MaTheLoai = t.MaTheLoaiPhim 
			and p.maPhim = c.maPhim
			and c.MaPhieu = ph.MaPhieu 
			and Month(ph.NgayLapPhieu) = @thang
			and Year(ph.NgayLapPhieu) = @nam
		group by p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim
	end
go
------- Doanh thu theo thang $$$$$$$$$$$$$$$$$$$$
Create PROCEDURE tinhTongDoanhThuTheoThangNam
	@thang int,
	@nam int
AS
BEGIN
    DECLARE @TongDoanhThu DECIMAL(18, 2);
    -- Tạo bảng tạm để lưu kết quả từ procedure HienThiThongTinNhanVien
    CREATE TABLE #TempTable (
        MaPhim VARCHAR(6),
        TenPhim NVARCHAR(50),
        TenTheLoaiPhim nvarchar(20),
        soLuongVe int,
        doanhThu float
    );

    -- Thực thi procedure HienThiThongTinNhanVien và lưu kết quả vào bảng tạm
    INSERT INTO #TempTable (MaPhim, TenPhim, TenTheLoaiPhim, soLuongVe, doanhThu)
    EXEC selectThongKePhimTheoThangNam @thang,@nam;

    -- Tính tổng số lương của tất cả các nhân viên
    SELECT @TongDoanhThu = SUM(doanhThu) FROM #TempTable;

    -- Hiển thị tổng số lương
    SELECT @TongDoanhThu AS tongDoanhThu;

    -- Xóa bảng tạm sau khi sử dụng
    DROP TABLE #TempTable;
END;
go
---- thong ke Doanh thu theo nam 
Create proc selectThongKePhimTheoNam
	@nam int
	as
	begin
		select p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim,sum(c.SoLuong) as soluong,sum(c.SoLuong) * 60000 as doanhthu
		from Phim p,CHI_TIET_PHIEU_PHIM c,THE_LOAI_PHIM t,PHIEU ph
		where p.MaTheLoai = t.MaTheLoaiPhim 
			and p.maPhim = c.maPhim
			and c.MaPhieu = ph.MaPhieu 
			and Year(ph.NgayLapPhieu) = @nam
		group by p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim
	end
go

------- Doanh thu theo thang $$$$$$$$$$$$$$$$$$$$
Create PROCEDURE tinhTongDoanhThuTheoNam
	@nam int
AS
BEGIN
    DECLARE @TongDoanhThu DECIMAL(18, 2);
    CREATE TABLE #TempTable (
        MaPhim VARCHAR(6),
        TenPhim NVARCHAR(50),
        TenTheLoaiPhim nvarchar(20),
        soLuongVe int,
        doanhThu float
    );
    INSERT INTO #TempTable (MaPhim, TenPhim, TenTheLoaiPhim, soLuongVe, doanhThu)
    EXEC selectThongKePhimTheoNam @nam;
    SELECT @TongDoanhThu = SUM(doanhThu) FROM #TempTable;
    SELECT @TongDoanhThu AS tongDoanhThu;
    -- Xóa bảng tạm sau khi sử dụng
    DROP TABLE #TempTable;
END;

go
=======
>>>>>>> 01c2d5e3f0c7818a028f5075238c2a3c1d26de51
Create proc GetLichByMa
	@TenPhim nvarchar(50),
	@TenPhong nvarchar(20),
	@NgayChieu datetime,
	@TGBatDau time(7)
<<<<<<< HEAD

=======
>>>>>>> 01c2d5e3f0c7818a028f5075238c2a3c1d26de51
As
Begin
	SELECT p.TenPhim, ph.TenPhong, l.NgayChieu, g.TGBatDau,g.TGKetThuc, tr.TenTinhTrang
	FROM PHIM as p INNER JOIN LICH_CHIEU as l ON p.MaPhim =l.MaPhim
	INNER JOIN PHONG_CHIEU as ph ON l.MaPhongChieu =ph.MaPhongChieu 
	INNER JOIN KHUNG_GIO_CHIEU as g ON l.MaKhungGioChieu = g.MaKhungGioChieu 
	INNER JOIN TINH_TRANG_PHONG_CHIEU as tr ON l.TrangThai = tr.MaTinhTrang  
	Where 
		  @TenPhim = p.TenPhim and
		  @NgayChieu = NgayChieu and
		  @TenPhong = ph.TenPhong and
		  @TGBatDau = g.TGBatDau

End

Go
Create Proc UpdateLichChieu
    @TenPhim nvarchar(50),
    @TenPhong nvarchar(20),
    @NgayChieu datetime,
    @TGBatDau time(7),
    @TGKetThuc time(7),
    @TenTinhTrang nvarchar(40)
 as 
 begin

-- if @TenPhim = (SELECT TenPhim FROM Phim WHERE TenPhim = @TenPhim )
 UPDATE LICH_CHIEU
 set MaPhim = (SELECT MaPhim FROM Phim WHERE TenPhim = @TenPhim ),
	 MaPhongChieu= ( SELECT MaPhongChieu FROM PHONG_CHIEU WHERE TenPhong = @TenPhong),
	 NgayChieu = @NgayChieu,
	 MaKhungGioChieu=(SELECT MaKhungGioChieu FROM KHUNG_GIO_CHIEU WHERE TGBatDau = @TGBatDau and TGKetThuc= @TGKetThuc),
	 TrangThai=(SELECT MaTinhTrang FROM TINH_TRANG_PHONG_CHIEU WHERE TenTinhTrang = @TenTinhTrang)
 where 
		MaPhim In (SELECT MaPhim FROM Phim WHERE MaPhim = LICH_CHIEU.MaPhim)
    and MaPhongChieu in (SELECT MaPhongChieu FROM PHONG_CHIEU WHERE MaPhongChieu = LICH_CHIEU.MaPhongChieu)
    AND MaKhungGioChieu in (SELECT MaKhungGioChieu FROM KHUNG_GIO_CHIEU WHERE MaKhungGioChieu = LICH_CHIEU.MaKhungGioChieu)
    AND NgayChieu = @NgayChieu
	and TrangThai = (SELECT MaTinhTrang FROM TINH_TRANG_PHONG_CHIEU WHERE MaTinhTrang = LICH_CHIEU.TrangThai)
	end

Go
Create PROCEDURE XoaLich
	@TenPhim nvarchar(50),
	@TenPhong nvarchar(20),
	@NgayChieu datetime,
	@TGBatDau time(7)
AS
BEGIN
    DELETE FROM LICH_CHIEU
    WHERE MaPhim = (SELECT MaPhim FROM Phim WHERE TenPhim = @TenPhim)
    AND MaPhongChieu = (SELECT MaPhongChieu FROM PHONG_CHIEU WHERE TenPhong = @TenPhong)
    AND MaKhungGioChieu in (SELECT MaKhungGioChieu FROM KHUNG_GIO_CHIEU WHERE TGBatDau = @TGBatDau)
    AND NgayChieu = @NgayChieu;
END
Go
Create proc LoadLichChieu
As
Begin
	SELECT p.TenPhim, ph.TenPhong, l.NgayChieu, g.TGBatDau,g.TGKetThuc, tr.TenTinhTrang
	FROM PHIM as p INNER JOIN LICH_CHIEU as l ON p.MaPhim =l.MaPhim INNER JOIN PHONG_CHIEU as ph ON l.MaPhongChieu =ph.MaPhongChieu INNER JOIN KHUNG_GIO_CHIEU as g ON l.MaKhungGioChieu = g.MaKhungGioChieu INNER JOIN TINH_TRANG_PHONG_CHIEU as tr ON l.TrangThai = tr.MaTinhTrang  
End	
Go
Create proc SelectTGBD
As
Begin
	Select MaKhungGioChieu, TenKhungGio,TGBatDau
	From KHUNG_GIO_CHIEU
End

Go
Create proc SelectTGKT
As
Begin
	Select MaKhungGioChieu, TenKhungGio,TGKetThuc
	From KHUNG_GIO_CHIEU
End

Go
Create proc SelectPhongChieu
As
Begin
	Select * From PHONG_CHIEU
End
Go
Create proc SelectKhungGioChieu
As
Begin
	Select MaKhungGioChieu, TenKhungGio From KHUNG_GIO_CHIEU
End

go
Create proc LuuLC
	@MaPhim nvarchar(50),
	@MaPhongChieu nvarchar(20),
	@MaKhungGioChieu nvarchar(30),
	@NgayChieu datetime,
	@TrangThai varchar(1)
	As 
	Begin 
		INSERT INTO LICH_CHIEU(MaPhim,MaPhongChieu,MaKhungGioChieu,NgayChieu,TrangThai)
		Values (@MaPhim,@MaPhongChieu,@MaKhungGioChieu,@NgayChieu,@TrangThai);
	End
<<<<<<< HEAD
	go
	Create PROCEDURE ThemMoiLichChieu
    @TenPhim NVARCHAR(50),
    @TenPhong NVARCHAR(20),
    @NgayChieu DATE,
    @TGBatDau TIME(7),
    @TGKetThuc TIME(7),
    @TenTinhTrang NVARCHAR(40)
AS
BEGIN
    DECLARE @MaPhim VARCHAR(6), @MaPhongChieu VARCHAR(6), @MaKhungGioChieu VARCHAR(8), @MaTinhTrang CHAR(1);

    -- Lấy MaPhim từ bảng Phim dựa trên TenPhim
    SELECT @MaPhim = MaPhim FROM Phim WHERE TenPhim = @TenPhim;

    -- Lấy MaPhongChieu từ bảng PhongChieu dựa trên TenPhong
    SELECT @MaPhongChieu = MaPhongChieu FROM PHONG_CHIEU WHERE TenPhong = @TenPhong;

    -- Lấy MaKhungGioChieu từ bảng KhungGioChieu dựa trên TGBatDau
    SELECT @MaKhungGioChieu = MaKhungGioChieu FROM KHUNG_GIO_CHIEU WHERE TGBatDau = @TGBatDau;

    -- Lấy MaTinhTrang từ bảng TinhTrangPhongChieu dựa trên TenTinhTrang
    SELECT @MaTinhTrang = MaTinhTrang FROM TINH_TRANG_PHONG_CHIEU WHERE TenTinhTrang = @TenTinhTrang;

    -- Thêm mới dữ liệu vào bảng LICH_CHIEU
    INSERT INTO LICH_CHIEU (MaPhim, MaPhongChieu, MaKhungGioChieu, NgayChieu, TrangThai)
    VALUES (@MaPhim, @MaPhongChieu, @MaKhungGioChieu, @NgayChieu, @MaTinhTrang);
END
=======
>>>>>>> 01c2d5e3f0c7818a028f5075238c2a3c1d26de51
Go
Create proc HT_DanhSachPhongChieu
as
begin
     select MaPhongChieu,TenPhong
	 from PHONG_CHIEU
end
GO
Create proc HienThiDanhSachPhim
AS
BEGIN
    SELECT MaPhim, TenPhim
    FROM PHIM
END
Go
--------- Tong Thong ke Phim
Create proc selectThongKePhim 
	as
	begin
		select p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim,sum(c.SoLuong) as soluong,sum(c.SoLuong) * 60000 as doanhthu
		from Phim p,CHI_TIET_PHIEU_PHIM c,THE_LOAI_PHIM t
		where p.MaTheLoai = t.MaTheLoaiPhim and p.MaPhim = c.MaPhim
		group by p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim
	end
go

go
---- thong ke Doanh thu theo thang 
Create proc selectThongKePhimTheoThangNam
	@thang int,
	@nam int
	as
	begin
		select p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim,sum(c.SoLuong) as soluong,sum(c.SoLuong) * 60000 as doanhthu
		from Phim p,CHI_TIET_PHIEU_PHIM c,THE_LOAI_PHIM t,PHIEU ph
		where p.MaTheLoai = t.MaTheLoaiPhim 
			and p.MaPhim = c.MaPhim
			and c.MaPhieu = ph.MaPhieu 
			and Month(ph.NgayLapPhieu) = @thang
			and Year(ph.NgayLapPhieu) = @nam
		group by p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim
	end
go


<<<<<<< HEAD
=======
    -- Tính tổng số lương của tất cả các nhân viên
    SELECT @TongDoanhThu = SUM(doanhThu) FROM #TempTable;

    -- Hiển thị tổng số lương
    SELECT @TongDoanhThu AS tongDoanhThu;

    -- Xóa bảng tạm sau khi sử dụng
    DROP TABLE #TempTable;
END;
go
---- thong ke Doanh thu theo nam 
create proc selectThongKePhimTheoNam
	@nam int
	as
	begin
		select p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim,sum(c.SoLuong) as soluong,sum(c.SoLuong) * 60000 as doanhthu
		from Phim p,CHI_TIET_PHIEU_PHIM c,THE_LOAI_PHIM t,PHIEU ph
		where p.MaTheLoai = t.MaTheLoaiPhim
<<<<<<< HEAD
		and p.maPhim = c.maPhim
=======
and p.MaPhim = c.MaPhim
>>>>>>> a7233d192d57dbdc14f72bbe0f4415a8cf386427
			and c.MaPhieu = ph.MaPhieu 
			and Year(ph.NgayLapPhieu) = @nam
		group by p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim
	end
go
------- Doanh thu theo thang $$$$$$$$$$$$$$$$$$$$
CREATE PROCEDURE tinhTongDoanhThuTheoNam
	@nam int
AS
BEGIN
    DECLARE @TongDoanhThu DECIMAL(18, 2);
    -- Tạo bảng tạm để lưu kết quả từ procedure HienThiThongTinNhanVien
    CREATE TABLE #TempTable (
        MaPhim VARCHAR(6),
        TenPhim NVARCHAR(50),
        TenTheLoaiPhim nvarchar(20),
        soLuongVe int,
        doanhThu float
    );

    -- Thực thi procedure HienThiThongTinNhanVien và lưu kết quả vào bảng tạm
    INSERT INTO #TempTable (MaPhim, TenPhim, TenTheLoaiPhim, soLuongVe, doanhThu)
    EXEC selectThongKePhimTheoNam @nam;

    -- Tính tổng số lương của tất cả các nhân viên
    SELECT @TongDoanhThu = SUM(doanhThu) FROM #TempTable;

    -- Hiển thị tổng số lương
    SELECT @TongDoanhThu AS tongDoanhThu;

    -- Xóa bảng tạm sau khi sử dụng
    DROP TABLE #TempTable;
END;
>>>>>>> 01c2d5e3f0c7818a028f5075238c2a3c1d26de51
