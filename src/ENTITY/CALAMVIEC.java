package ENTITY;

import java.sql.Time;

public class CALAMVIEC {
	private String maCa;
	private String tenCa;
	private Time gioBatDau;
	private Time gioKetThuc;

	public CALAMVIEC(String maCa, String tenCa, Time gioBatDau, Time gioKetThuc) {
		super();
		this.maCa = maCa;
		this.tenCa = tenCa;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
	}

	public CALAMVIEC() {
		super();
	}

	public String getMaCa() {
		return maCa;
	}

	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}

	public String getTenCa() {
		return tenCa;
	}

	public void setTenCa(String tenCa) {
		this.tenCa = tenCa;
	}

	public Time getGioBatDau() {
		return gioBatDau;
	}

	public void setGioBatDau(Time gioBatDau) {
		this.gioBatDau = gioBatDau;
	}

	public Time getGioKetThuc() {
		return gioKetThuc;
	}

	public void setGioKetThuc(Time gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}

}
