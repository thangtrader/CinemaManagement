package ENTITY;

public class PHONGCHIEU {
	private String maPhongChieu;
	private String tenPhong;
	private int maTinhTrang;
	public String getMaPhongChieu() {
		return maPhongChieu;
	}
	public void setMaPhongChieu(String maPhongChieu) {
		this.maPhongChieu = maPhongChieu;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public int getMaTinhTrang() {
		return maTinhTrang;
	}
	public void setMaTinhTrang(int maTinhTrang) {
		this.maTinhTrang = maTinhTrang;
	}
	public PHONGCHIEU(String maPhongChieu, String tenPhong, int maTinhTrang) {
		this.maPhongChieu = maPhongChieu;
		this.tenPhong = tenPhong;
		this.maTinhTrang = maTinhTrang;
	}
	public PHONGCHIEU() {
	}
	
}
