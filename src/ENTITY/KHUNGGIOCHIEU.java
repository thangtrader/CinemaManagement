package ENTITY;

import java.sql.Time;

public class KHUNGGIOCHIEU {
	private String maKhungGioChieu;
	private String tenKhungGio;
	private Time tgBatDau;
	private Time tgKeuThuc;

	public KHUNGGIOCHIEU(String maKhungGioChieu, String tenKhungGio, Time tgBatDau, Time tgKeuThuc) {
		super();
		this.maKhungGioChieu = maKhungGioChieu;
		this.tenKhungGio = tenKhungGio;
		this.tgBatDau = tgBatDau;
		this.tgKeuThuc = tgKeuThuc;
	}

	public KHUNGGIOCHIEU() {
		super();
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

	public Time getTgKeuThuc() {
		return tgKeuThuc;
	}

	public void setTgKeuThuc(Time tgKeuThuc) {
		this.tgKeuThuc = tgKeuThuc;
	}

}
