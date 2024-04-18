package ENTITY;



import java.sql.Date;

import javax.swing.Icon;


public class NHANVIEN {
	private String maNhanVien;
	private String tenNhanVien;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String diaChi;
	private String sdt;
	private String cccd;
	private String tenTaiKhoan;
	private String matKhau;
	private Icon anh;
	private String maChinhSach;
	private String maChucVu;
	private String trangThai;

	public NHANVIEN(String maNhanVien, String tenNhanVien, Date ngaySinh, boolean gioiTinh, String diaChi, String sdt,
			String cccd, String tenTaiKhoan, String matKhau, Icon anh, String maChinhSach, String maChucVu,
			String trangThai) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.cccd = cccd;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.anh = anh;
		this.maChinhSach = maChinhSach;
		this.maChucVu = maChucVu;
		this.trangThai = trangThai;
	}


	public NHANVIEN() {
	}


	public String getMaNhanVien() {
		return maNhanVien;
	}


	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}


	public String getTenNhanVien() {
		return tenNhanVien;
	}


	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}


	public Date getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	public boolean isGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getSdt() {
		return sdt;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	public String getCccd() {
		return cccd;
	}


	public void setCccd(String cccd) {
		this.cccd = cccd;
	}


	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}


	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}


	public String getMatKhau() {
		return matKhau;
	}


	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}


	public Icon getAnh() {
		return anh;
	}


	public void setAnh(Icon anh) {
		this.anh = anh;
	}


	public String getMaChinhSach() {
		return maChinhSach;
	}


	public void setMaChinhSach(String maChinhSach) {
		this.maChinhSach = maChinhSach;
	}


	public String getMaChucVu() {
		return maChucVu;
	}


	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}


	public String getTrangThai() {
		return trangThai;
	}


	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	

}
