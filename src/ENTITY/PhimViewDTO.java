package ENTITY;

import java.util.Date;


public class PhimViewDTO {
	private String maPhim;
	private String tenPhim;
	private int thoiLuong;
	private String quocGia;
	private Date namSanXuat;
	private int doTuoiXem;
	private String tenTheLoai;
	private String daoDien;
	
	
	public PhimViewDTO() {
		super();
	}
	public PhimViewDTO(String maPhim, String tenPhim, int thoiLuong, String quocGia, Date namSanXuat, int doTuoiXem,
			String tenTheLoai, String daoDien) {
		super();
		this.maPhim = maPhim;
		this.tenPhim = tenPhim;
		this.thoiLuong = thoiLuong;
		this.quocGia = quocGia;
		this.namSanXuat = namSanXuat;
		this.doTuoiXem = doTuoiXem;
		this.tenTheLoai = tenTheLoai;
		this.daoDien = daoDien;
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
	public int getThoiLuong() {
		return thoiLuong;
	}
	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}
	public String getQuocGia() {
		return quocGia;
	}
	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}
	public Date getNamSanXuat() {
		return namSanXuat;
	}
	public void setNamSanXuat(Date namSanXuat) {
		this.namSanXuat = namSanXuat;
	}
	public int getDoTuoiXem() {
		return doTuoiXem;
	}
	public void setDoTuoiXem(int doTuoiXem) {
		this.doTuoiXem = doTuoiXem;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
	public String getDaoDien() {
		return daoDien;
	}
	public void setDaoDien(String daoDien) {
		this.daoDien = daoDien;
	}
	
	
}
