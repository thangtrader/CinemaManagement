package ENTITY;

import java.sql.Date;

import javax.swing.Icon;

public class NhanVienViewDTO {
	private String maNhanVien;
	private String tenNhanVien;
	private Date ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private String sdt;
	private String cccd;
	private String tenTaiKhoan;
	private String matKhau;
	private Icon anh;
	private String tenChinhSach;
	private String tenChucVu;
	private String trangThai;
	
	public NhanVienViewDTO(String maNhanVien, String tenNhanVien, Date ngaySinh, String gioiTinh, String diaChi,
			String sdt, String cccd, String tenTaiKhoan, String matKhau, Icon anh, String tenChinhSach,
			String tenChucVu, String trangThai) {
		super();
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
		this.tenChinhSach = tenChinhSach;
		this.tenChucVu = tenChucVu;
		this.trangThai = trangThai;
	}

	public NhanVienViewDTO() {
		super();
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

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
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

	public String getTenChinhSach() {
		return tenChinhSach;
	}

	public void setTenChinhSach(String tenChinhSach) {
		this.tenChinhSach = tenChinhSach;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
}
