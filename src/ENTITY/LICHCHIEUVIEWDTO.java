package ENTITY;


import java.sql.Time;
import java.util.Date;

public class LICHCHIEUVIEWDTO {
	private String tenPhim;
	private String tenPhong;
	private Date ngayChieu;
	private Time thoiGianBatDau;
	private Time thoiGianKetThuc;
	private String tenTinhTrang;
	
	public LICHCHIEUVIEWDTO() {
		super();
	}

	public LICHCHIEUVIEWDTO(String tenPhim, String tenPhong, Date ngayChieu, Time thoiGianBatDau, Time thoiGianKetThuc,
			String tenTinhTrang) {
		super();
		this.tenPhim = tenPhim;
		this.tenPhong = tenPhong;
		this.ngayChieu = ngayChieu;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.tenTinhTrang = tenTinhTrang;
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public Date getNgayChieu() {
		return ngayChieu;
	}

	public void setNgayChieu(Date ngayChieu) {
		this.ngayChieu = ngayChieu;
	}

	public Time getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Time thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Time getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Time thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public String getTenTinhTrang() {
		return tenTinhTrang;
	}

	public void setTenTinhTrang(String tenTinhTrang) {
		this.tenTinhTrang = tenTinhTrang;
	}




}
