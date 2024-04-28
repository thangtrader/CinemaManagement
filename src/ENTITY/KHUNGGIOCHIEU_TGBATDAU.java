package ENTITY;

import java.sql.Time;

public class KHUNGGIOCHIEU_TGBATDAU {
	private String maKhungGioChieu;
	private String tenKhungGio;
	private Time tgBatDau;



	public KHUNGGIOCHIEU_TGBATDAU() {
		super();
	}

	
	public KHUNGGIOCHIEU_TGBATDAU(String maKhungGioChieu, String tenKhungGio, Time tgBatDau, Time tgKetThuc) {
		super();
		this.maKhungGioChieu = maKhungGioChieu;
		this.tenKhungGio = tenKhungGio;
		this.tgBatDau = tgBatDau;

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


	public Time getTgBatDau() {
		return tgBatDau;
	}


	public void setTgBatDau(Time tgBatDau) {
		this.tgBatDau = tgBatDau;
	}




	@Override
	public String toString() {
	    return tgBatDau.toString();
	}


}
