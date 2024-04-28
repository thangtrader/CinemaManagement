
package Business_Logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
<<<<<<< HEAD
=======
import java.util.Calendar;
>>>>>>> DucThang
import java.util.Currency;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import ENTITY.TKPhim;
import Process_Data.DBHelper;
import Process_Data.ThongKePhimDAL;

public class ThongKePhimBLL extends DBHelper {
	private static ThongKePhimBLL instance;
<<<<<<< HEAD
	GUI.panelTHONGKEPHIM GUITKPhim;
	ThongKePhimDAL tkpDAL;
	JLabel lbDoanhThu;
=======
	public GUI.panelTHONGKEPHIM GUITKPhim;
	ThongKePhimDAL tkpDAL;
>>>>>>> DucThang

	public static ThongKePhimBLL getInstance() {
		if (instance == null) {
			instance = new ThongKePhimBLL();
		}
		return instance;
	}

	public ThongKePhimBLL(GUI.panelTHONGKEPHIM p) {
		GUITKPhim = p;
<<<<<<< HEAD
		lbDoanhThu = p.lbDoanhThu; // Lưu trữ tham chiếu đến label tổng lương
		tkpDAL = ThongKePhimDAL.getInstance();
		UpdateTongDoanhThuLabel();
		LoadTKPhim();
=======
		tkpDAL = ThongKePhimDAL.getInstance();
>>>>>>> DucThang
	}

	public ThongKePhimBLL() {

	}

<<<<<<< HEAD
//	public Vector<ENTITY.TKPhim> ListTKPhim(String proc) {
//		Vector<ENTITY.TKPhim> vector = new Vector<ENTITY.TKPhim>();
//		try {
//			String sql = "{CALL " + proc + "()}";
//			PreparedStatement pre = cnn.prepareStatement(sql);
//			ResultSet rs = pre.executeQuery();
//			while (rs.next()) {
//				ENTITY.TKPhim tkPhim = new ENTITY.TKPhim();
//				tkPhim.setMaPhim(rs.getString("MaPhim"));
//				tkPhim.setTenPhim(rs.getString("TenPhim"));
//				tkPhim.setTheLoai(rs.getString("TenTheLoaiPhim"));
//				tkPhim.setSoLuongVe(rs.getInt("soluong"));
//				tkPhim.setDoanhThu(rs.getDouble("doanhthu")); // Sửa đổi thành setTongTien
//				vector.addElement(tkPhim);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return vector;
//	}
//	public String listPhim(String sql) {
//		int result = 0;
//		if (GUITKPhim.calendar.getDate() == null) {
//			result = tinhDoanhThu("selectThongKePhim");
//		} else if (GUITKPhim.checkBoxDoanhThu.isSelected()) {
//			result = tinhDoanhThu("selectThongKePhimTheoThangNam");
//		} else {
//			result = tinhDoanhThu("tinhTongDoanhThuTheoThang");
//		}
//
//		return result;
//		return sql;
//	}
//	public Vector<ENTITY.TKPhim> ListTKPhim() {
//		Vector<ENTITY.TKPhim> vector = new Vector<ENTITY.TKPhim>();
//		try {
//			String sql = "select p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim,sum(c.SoLuong) as soluong,sum(c.SoLuong) * 60 as doanhthu\r\n"
//					+ "from Phim p,CHI_TIET_PHIEU_PHIM c,THE_LOAI_PHIM t\r\n"
//					+ "where p.MaTheLoai = t.MaTheLoaiPhim and p.maPhim = c.maPhim\r\n"
//					+ "group by p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim\r\n" + "";
//			PreparedStatement pre = cnn.prepareStatement(sql);
//			ResultSet rs = pre.executeQuery();
//			while (rs.next()) {
//				ENTITY.TKPhim tkPhim = new ENTITY.TKPhim();
//				tkPhim.setMaPhim(rs.getString("MaPhim"));
//				tkPhim.setTenPhim(rs.getString("TenPhim"));
//				tkPhim.setTheLoai(rs.getString("TenTheLoaiPhim"));
//				tkPhim.setSoLuongVe(rs.getInt("soluong"));
//				tkPhim.setDoanhThu(rs.getDouble("doanhthu")); // Sửa đổi thành setTongTien
//				vector.addElement(tkPhim);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return vector;
//	}

//	public Vector<ENTITY.TKPhim> ListTKPhimTheoThangNam() {
//		Vector<ENTITY.TKPhim> vector = new Vector<ENTITY.TKPhim>();
//		try {
//			String sql = "select p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim,sum(c.SoLuong) as N'Số lượng',sum(c.SoLuong) * 60000 as doanhthu\r\n"
//					+ "		from Phim p,CHI_TIET_PHIEU_PHIM c,THE_LOAI_PHIM t,PHIEU ph\r\n"
//					+ "		where p.MaTheLoai = t.MaTheLoaiPhim \r\n" + "			and p.maPhim = c.maPhim\r\n"
//					+ "			and c.MaPhieu = ph.MaPhieu \r\n" + "			and Month(ph.NgayLapPhieu) = "
//					+ GUITKPhim.dateString.substring(3, 5) + "\r\n" + "			and Year(ph.NgayLapPhieu) = "
//					+ GUITKPhim.dateString.substring(6) + "\r\n"
//					+ "		group by p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim" + "";
//			PreparedStatement pre = cnn.prepareStatement(sql);
//			ResultSet rs = pre.executeQuery();
//			while (rs.next()) {
//				ENTITY.TKPhim tkPhim = new ENTITY.TKPhim();
//				tkPhim.setMaPhim(rs.getString("MaPhim"));
//				tkPhim.setTenPhim(rs.getString("TenPhim"));
//				tkPhim.setTheLoai(rs.getString("TenTheLoaiPhim"));
//				tkPhim.setSoLuongVe(rs.getInt("soluong"));
//				tkPhim.setDoanhThu(rs.getDouble("doanhthu")); // Sửa đổi thành setTongTien
//				vector.addElement(tkPhim);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return vector;
//	}
//
//	public Vector<ENTITY.TKPhim> ListTKPhimTheoNam() {
//		Vector<ENTITY.TKPhim> vector = new Vector<ENTITY.TKPhim>();
//		try {
//			String sql = "select p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim,sum(c.SoLuong) as N'Số lượng',sum(c.SoLuong) * 60000 as doanhthu\r\n"
//					+ "		from Phim p,CHI_TIET_PHIEU_PHIM c,THE_LOAI_PHIM t,PHIEU ph\r\n"
//					+ "		where p.MaTheLoai = t.MaTheLoaiPhim \r\n" + "			and p.maPhim = c.maPhim\r\n"
//					+ "			and c.MaPhieu = ph.MaPhieu \r\n" + "			and Year(ph.NgayLapPhieu) = "
//					+ GUITKPhim.dateString.substring(6) + "\r\n"
//					+ "		group by p.MaPhim,p.TenPhim ,t.TenTheLoaiPhim" + "";
//			PreparedStatement pre = cnn.prepareStatement(sql);
//			ResultSet rs = pre.executeQuery();
//			while (rs.next()) {
//				ENTITY.TKPhim tkPhim = new ENTITY.TKPhim();
//				tkPhim.setMaPhim(rs.getString("MaPhim"));
//				tkPhim.setTenPhim(rs.getString("TenPhim"));
//				tkPhim.setTheLoai(rs.getString("TenTheLoaiPhim"));
//				tkPhim.setSoLuongVe(rs.getInt("soluong"));
//				tkPhim.setDoanhThu(rs.getDouble("doanhthu")); // Sửa đổi thành setTongTien
//				vector.addElement(tkPhim);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return vector;
//	}

	public int tinhDoanhThu(String proc) {
		int result = 0;
		try {
			// Chuẩn bị câu lệnh gọi stored procedure
			String sql = "{CALL " + proc + "()}";
			// Tạo đối tượng PreparedStatement
			PreparedStatement statement = ((Statement) cnn).getConnection().prepareStatement(sql);
			// Thực thi câu lệnh
	
			ResultSet rs = statement.executeQuery();
			// Lấy kết quả
			if (rs.next()) {
				result = rs.getInt(1); // Giả sử stored procedure trả về một số nguyên
			}
			// Đóng kết nối và các tài nguyên
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
//
	public int tinhDoanhThuPhim() {
		int result = 0;
//		System.out.println();
		if(GUITKPhim.dateString == null){
			result = tkpDAL.tinhDoanhThu("{CALL tinhTongDoanhThu()}");
		}
		else if (GUITKPhim.checkBoxDoanhThu.isSelected()) {
			result = tkpDAL.tinhDoanhThu("{CALL tinhTongDoanhThuTheoNam("+GUITKPhim.dateString.substring(6)+")}");
		} else {
			result = tkpDAL.tinhDoanhThu("{CALL tinhTongDoanhThuTheoThangNam("+GUITKPhim.dateString.substring(3,5)+", "+GUITKPhim.dateString.substring(6)+")}");
		}
		return result;

	}

	public void LoadTKPhim() {
		// Khởi tạo đối tượng tknvDAL
		tkpDAL = new ThongKePhimDAL();
		GUITKPhim.model = (DefaultTableModel) GUITKPhim.table.getModel();
		for (int i = GUITKPhim.model.getRowCount() - 1; i >= 0; i--) {
			GUITKPhim.model.removeRow(i);
		}
		Vector<ENTITY.TKPhim> vector = new Vector<ENTITY.TKPhim>();
		if(GUITKPhim.dateString == null){
//			vector = tkpDAL.ListTKPhim("{CALL selectThongKePhim()}");
			vector = tkpDAL.ListTKPhim("selectThongKePhim");
		}
		else if (GUITKPhim.checkBoxDoanhThu.isSelected()) {
//			vector = tkpDAL.ListTKPhim("{CALL selectThongKePhimTheoNam("+GUITKPhim.dateString.substring(6)+")}");
			vector = tkpDAL.ListTKPhim("selectThongKePhimTheoNam "+GUITKPhim.dateString.substring(6));
		} else {
//			vector = tkpDAL.ListTKPhim("{CALL selectThongKePhimTheoThangNam("+GUITKPhim.dateString.substring(3,5)+", "+GUITKPhim.dateString.substring(6) +")}");
			vector = tkpDAL.ListTKPhim("selectThongKePhimTheoThangNam "+GUITKPhim.dateString.substring(3,5)+", "+GUITKPhim.dateString.substring(6) );
		}
		if(vector == null)
			System.out.println("dmm");
		for (ENTITY.TKPhim tkp : vector) {
			GUITKPhim.model.addRow(new Object[] { tkp.getMaPhim(), tkp.getTenPhim(), tkp.getTheLoai(),
					tkp.getSoLuongVe(), tkp.getDoanhThu() });
		}
	}

	public void UpdateTongDoanhThuLabel() {
		int tongDoanhThu = tinhDoanhThuPhim(); // Gọi phương thức để lấy tổng lương từ procedure
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		format.setCurrency(Currency.getInstance("VND"));
		String kq = format.format(tongDoanhThu);
		GUITKPhim.lbDoanhThu.setText(kq); // Cập nhật label với kết quả
=======
	public int tinhDoanhThu(String dateIsEmpty,Boolean checkBox,int month,int year) {
		
		return tkpDAL.tinhDoanhThuDAL(dateIsEmpty, checkBox, month, year);
		
	}
	
	public Vector<ENTITY.TKPhim> LoadTKPhim(String date, Boolean log, int month, int year) {
		return tkpDAL.LoadTKPhim(date, log, month, year); 
>>>>>>> DucThang
	}

}