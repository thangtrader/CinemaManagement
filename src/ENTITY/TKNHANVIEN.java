package ENTITY;

public class TKNHANVIEN {
	 	private String maNhanVien;
	    private String tenNhanVien;
	    private boolean gioiTinh;
	    private double sogiolam;
	    private double tongtien;
		public TKNHANVIEN(String maNhanVien, String tenNhanVien, boolean gioiTinh, double sogiolam, double tongtien) {
			super();
			this.maNhanVien = maNhanVien;
			this.tenNhanVien = tenNhanVien;
			this.gioiTinh = gioiTinh;
			this.sogiolam = sogiolam;
			this.tongtien = tongtien;
		}
		public TKNHANVIEN() {
			super();
		}
		public String getMaNhanVien() {
			return maNhanVien;
		}
		public void setMaNhanVien(String maNhanVien) {
			this.maNhanVien = maNhanVien;
		}
		public String getTenNhanVien() {
			return tenNhanVien;
		}
		public void setTenNhanVien(String tenNhanVien) {
			this.tenNhanVien = tenNhanVien;
		}
		public boolean isGioiTinh() {
			return gioiTinh;
		}
		public void setGioiTinh(boolean gioiTinh) {
			this.gioiTinh = gioiTinh;
		}
		public double getSogiolam() {
			return sogiolam;
		}
		public void setSogiolam(double sogiolam) {
			this.sogiolam = sogiolam;
		}
		public double getTongtien() {
			return tongtien;
		}
		public void setTongtien(double tongtien) {
			this.tongtien = tongtien;
		}
	    
}
