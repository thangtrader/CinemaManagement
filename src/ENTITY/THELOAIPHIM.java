package ENTITY;

public class THELOAIPHIM {
	private String maTheLoaiPhim;
	private String tenTheLoaiPhim;
	public THELOAIPHIM(String maTheLoaiPhim, String tenTheLoaiPhim) {
		super();
		this.maTheLoaiPhim = maTheLoaiPhim;
		this.tenTheLoaiPhim = tenTheLoaiPhim;
	}
	public THELOAIPHIM() {
		super();
	}
	public String getMaTheLoaiPhim() {
		return maTheLoaiPhim;
	}
	public void setMaTheLoaiPhim(String maTheLoaiPhim) {
		this.maTheLoaiPhim = maTheLoaiPhim;
	}
	public String getTenTheLoaiPhim() {
		return tenTheLoaiPhim;
	}
	public void setTenTheLoaiPhim(String tenTheLoaiPhim) {
		this.tenTheLoaiPhim = tenTheLoaiPhim;
	}
	
}
