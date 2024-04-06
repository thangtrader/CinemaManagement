package ENTITY;

public class CHINHSACH {
	private String maChinhSach;
	private String tenChinhSach;
	private float heSoLuong;
	private String bhxh;
	private int tienThuong;

	public CHINHSACH(String maChinhSach, String tenChinhSach, float heSoLuong, String bhxh, int tienThuong) {
		super();
		this.maChinhSach = maChinhSach;
		this.tenChinhSach = tenChinhSach;
		this.heSoLuong = heSoLuong;
		this.bhxh = bhxh;
		this.tienThuong = tienThuong;
	}

	public CHINHSACH() {
		super();
	}

	public String getMaChinhSach() {
		return maChinhSach;
	}

	public void setMaChinhSach(String maChinhSach) {
		this.maChinhSach = maChinhSach;
	}

	public String getTenChinhSach() {
		return tenChinhSach;
	}

	public void setTenChinhSach(String tenChinhSach) {
		this.tenChinhSach = tenChinhSach;
	}

	public float getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public String getBhxh() {
		return bhxh;
	}

	public void setBhxh(String bhxh) {
		this.bhxh = bhxh;
	}

	public int getTienThuong() {
		return tienThuong;
	}

	public void setTienThuong(int tienThuong) {
		this.tienThuong = tienThuong;
	}

}
