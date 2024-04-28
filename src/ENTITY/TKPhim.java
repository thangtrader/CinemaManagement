package ENTITY;

import javax.swing.JLabel;

public class TKPhim {
	private String maPhim;
	private String tenPhim;
	private String theLoai;
	private int soLuongVe;
	private Double doanhThu;
	public TKPhim(String maPhim, String tenPhim, String theLoai, int soLuongVe, Double doanhThu) {
		super();
		this.maPhim = maPhim;
		this.tenPhim = tenPhim;
		this.theLoai = theLoai;
		this.soLuongVe = soLuongVe;
		this.doanhThu = doanhThu;
	}
	public TKPhim() {
		super();
	}
	public String getMaPhim() {
		return maPhim;
	}
	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}
	public String getTenPhim() {
		return tenPhim;
	}
	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public int getSoLuongVe() {
		return soLuongVe;
	}
	public void setSoLuongVe(int soLuongVe) {
		this.soLuongVe = soLuongVe;
	}
	public Double getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(Double doanhThu) {
		this.doanhThu = doanhThu;
	}
	

	
	
}
