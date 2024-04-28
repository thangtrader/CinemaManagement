package ENTITY;

import java.sql.Time;

public class KHUNGGIOCHIEU_TGKETTHUC {
	private String maKhungGioChieu;
	private String tenKhungGio;
	private Time tgKetThuc;


	public KHUNGGIOCHIEU_TGKETTHUC() {
		super();
	}

	
	public KHUNGGIOCHIEU_TGKETTHUC(String maKhungGioChieu, String tenKhungGio, Time tgKetThuc) {
		super();
		this.maKhungGioChieu = maKhungGioChieu;
		this.tenKhungGio = tenKhungGio;
		this.tgKetThuc = tgKetThuc;
	}
	

	public String getMaKhungGioChieu() {
		return maKhungGioChieu;
	}


	public void setMaKhungGioChieu(String maKhungGioChieu) {
		this.maKhungGioChieu = maKhungGioChieu;
	}


	public String getTenKhungGio() {
		return tenKhungGio;
	}


	public void setTenKhungGio(String tenKhungGio) {
		this.tenKhungGio = tenKhungGio;
	}



	public Time getTgKetThuc() {
		return tgKetThuc;
	}


	public void setTgKetThuc(Time tgKetThuc) {
		this.tgKetThuc = tgKetThuc;
	}




	public String toString() {
	    return tgKetThuc.toString();
	}
}
