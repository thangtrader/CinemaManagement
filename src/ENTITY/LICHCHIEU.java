package ENTITY;

import java.sql.Date;

public class LICHCHIEU {
	private String maPhim;
	private String maPhongChieu;
	private String maKhungGioChieu;
	private Date ngayChieu;
	private String trangThai;
	public String getMaPhim() {
		return maPhim;
	}

	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}

	public String getMaPhongChieu() {
		return maPhongChieu;
	}

	public void setMaPhongChieu(String maPhongChieu) {
		this.maPhongChieu = maPhongChieu;
	}

	public String getMaKhungGioChieu() {
		return maKhungGioChieu;
	}

	public void setMaKhungGioChieu(String maKhungGioChieu) {
		this.maKhungGioChieu = maKhungGioChieu;
	}

	public Date getNgayChieu() {
		return ngayChieu;
	}

	public void setNgayChieu(Date ngayChieu) {
		this.ngayChieu = ngayChieu;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public LICHCHIEU() {
		super();
	}

	public LICHCHIEU(String maPhim, String maPhongChieu, String maKhungGioChieu, Date ngayChieu, String trangThai) {
		super();
		this.maPhim = maPhim;
		this.maPhongChieu = maPhongChieu;
		this.maKhungGioChieu = maKhungGioChieu;
		this.ngayChieu = ngayChieu;
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "LICHCHIEU [maPhim=" + maPhim + ", maPhongChieu=" + maPhongChieu + ", maKhungGioChieu=" + maKhungGioChieu
				+ ", ngayChieu=" + ngayChieu + ", trangThai=" + trangThai + "]";
	}
}
