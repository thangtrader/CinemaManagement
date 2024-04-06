package ENTITY;

public class TINHTRANGPHONGCHIEU {
	private int maTinhTrang;
	private String tenTinhTrang;
	public TINHTRANGPHONGCHIEU(int maTinhTrang, String tenTinhTrang) {
		super();
		this.maTinhTrang = maTinhTrang;
		this.tenTinhTrang = tenTinhTrang;
	}
	public TINHTRANGPHONGCHIEU() {
		super();
	}
	public int getMaTinhTrang() {
		return maTinhTrang;
	}
	public void setMaTinhTrang(int maTinhTrang) {
		this.maTinhTrang = maTinhTrang;
	}
	public String getTenTinhTrang() {
		return tenTinhTrang;
	}
	public void setTenTinhTrang(String tenTinhTrang) {
		this.tenTinhTrang = tenTinhTrang;
	}
	
}
