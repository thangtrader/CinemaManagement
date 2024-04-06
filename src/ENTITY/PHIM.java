package ENTITY;

import java.util.Date;

import javax.swing.Icon;

public class PHIM {
	private String maPhim;
	private String tenPhim;
	private Icon anhPhim;
	private int thoiLuong;
	private String quocGia;
	private Date namSanXuat;
	private int doTuoiXem;
	private String maTheLoai;
	private String daoDien;

	public PHIM(String maPhim, String tenPhim, Icon anhPhim, int thoiLuong, String quocGia, Date namSanXuat,
			int doTuoiXem, String maTheLoai, String daoDien) {
		this.tenPhim = tenPhim;
		this.anhPhim = anhPhim;
		this.thoiLuong = thoiLuong;
		this.quocGia = quocGia;
		this.namSanXuat = namSanXuat;
		this.doTuoiXem = doTuoiXem;
		this.maTheLoai = maTheLoai;
		this.daoDien = daoDien;
	}

	public PHIM() {
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

	public Icon getAnhPhim() {
		return anhPhim;
	}

	public void setAnhPhim(Icon anhPhim) {
		this.anhPhim = anhPhim;
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

	public Date getNanSanXuat() {
		return namSanXuat;
	}

	public void setNanSanXuat(Date namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public int getDoTuoiXem() {
		return doTuoiXem;
	}

	public void setDoTuoiXem(int doTuoiXem) {
		this.doTuoiXem = doTuoiXem;
	}

	public String getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getNoiDung() {
		return daoDien;
	}

	public void setNoiDung(String daoDien) {
		this.daoDien = daoDien;
	}

	@Override
	public String toString() {
		return "PHIM [maPhim=" + maPhim + ", tenPhim=" + tenPhim + ", anhPhim=" + anhPhim + ", thoiLuong=" + thoiLuong
				+ ", quocGia=" + quocGia + ", nanSanXuat=" + namSanXuat + ", doTuoiXem=" + doTuoiXem + ", maTheLoai="
				+ maTheLoai + ", noiDung=" + daoDien + "]";
	}

}
