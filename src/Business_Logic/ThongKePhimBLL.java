
package Business_Logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import ENTITY.TKPhim;
import Process_Data.DBHelper;
import Process_Data.ThongKePhimDAL;

public class ThongKePhimBLL extends DBHelper {
	private static ThongKePhimBLL instance;
	GUI.panelTHONGKEPHIM GUITKPhim;
	ThongKePhimDAL tkpDAL;
	JLabel lbDoanhThu;

	

	public ThongKePhimBLL(GUI.panelTHONGKEPHIM p) {
		GUITKPhim = p;
		lbDoanhThu = p.lbDoanhThu; // Lưu trữ tham chiếu đến label tổng lương
		tkpDAL = ThongKePhimDAL.getInstance();
		tkpDAL.UpdateTongDoanhThuLabel(lbDoanhThu.getText());
		LoadNhanVien();
	}

	public ThongKePhimBLL() {

	}

	public Vector<ENTITY.TKPhim> ListTKNhanVien() {
		System.out.println("ok");
		Vector<ENTITY.TKPhim> vector = new Vector<ENTITY.TKPhim>();
		try {
			String sql = "   SELECT DISTINCT NV.MaNhanVien, NV.TenNhanVien, NV.GioiTinh,\r\n" + "           CASE \r\n"
					+ "               WHEN CLV.GioBatDau IS NOT NULL AND CLV.GioKetThuc IS NOT NULL THEN DATEDIFF(HOUR, CLV.GioBatDau, CLV.GioKetThuc)\r\n"
					+ "               ELSE 0\r\n" + "           END AS SoGioLam,\r\n"
					+ "           CS.HeSoLuong * CASE \r\n"
					+ "                             WHEN CLV.GioBatDau IS NOT NULL AND CLV.GioKetThuc IS NOT NULL THEN DATEDIFF(HOUR, CLV.GioBatDau, CLV.GioKetThuc)\r\n"
					+ "                             ELSE 0\r\n" + "                         END AS TongLuong\r\n"
					+ "    FROM NHAN_VIEN NV\r\n"
					+ "    LEFT JOIN LICH_LAM_VIEC LLV ON NV.MaNhanVien = LLV.MaNhanVien\r\n"
					+ "    LEFT JOIN CA_LAM_VIEC CLV ON LLV.MaCa = CLV.MaCa\r\n"
					+ "    LEFT JOIN CHINH_SACH CS ON NV.MaChinhSach = CS.MaChinhSach";
			PreparedStatement pre = cnn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				ENTITY.TKPhim tkPhim = new ENTITY.TKPhim();
				tkPhim.setMaPhim(rs.getString("maPhim"));
				tkPhim.setTenPhim(rs.getString("tenPhim"));
				tkPhim.setTheLoai(rs.getString("theLoai"));
				tkPhim.setSoLuongVe(rs.getInt("soLuongVe"));
				tkPhim.setDoanhThu(rs.getDouble("doanhThu")); // Sửa đổi thành setTongTien
				vector.addElement(tkPhim);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vector;
	}

	public int tinhDoanhThuPhim() {
		int result = 0;
		try {
			// Chuẩn bị câu lệnh gọi stored procedure
			String sql = "{CALL tinhTongDoanhThu()}";
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

	public void LoadNhanVien() {
		// Khởi tạo đối tượng tknvDAL
		tkpDAL = new ThongKePhimDAL();
		GUITKPhim.model = (DefaultTableModel) GUITKPhim.table.getModel();
		for (int i = GUITKPhim.model.getRowCount() - 1; i >= 0; i--) {
			GUITKPhim.model.removeRow(i);
		}
		// Gọi phương thức ListTKNhanVien() thay vì ListNhanVien()
		for (ENTITY.TKPhim tknv : tkpDAL.ListPhim()) {
			GUITKPhim.model.addRow(new Object[] { tknv.getMaPhim(), tknv.getTenPhim(), tknv.getTheLoai(),
					tknv.getSoLuongVe(), tknv.getDoanhThu() });
		}
	}

	public void UpdateTongDoanhThuLabel(String label) {
		int tongLuong = tinhDoanhThuPhim(); // Gọi phương thức để lấy tổng lương từ procedure
		label = (String.valueOf(tongLuong)); // Cập nhật label với kết quả
	}

}