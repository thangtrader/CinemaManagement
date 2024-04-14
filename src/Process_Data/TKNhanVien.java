// Trong lớp DAL:

package Process_Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.Duration;
import java.util.Vector;

import javax.swing.JLabel;

public class TKNhanVien {
    DBHelper cnn;
    GUI.panelTKNHANVIEN GUITKNhanVien;
    private static TKNhanVien instance;

    public static TKNhanVien getInstance() {
        if (instance == null) {
            instance = new TKNhanVien();
        }
        return instance;
    }

    public TKNhanVien() {
        cnn = new DBHelper();
    }
    
    public TKNhanVien(GUI.panelTKNHANVIEN pnv) {
    	GUITKNhanVien = pnv;
    	cnn = new DBHelper();
    }
    public Vector<ENTITY.TKNHANVIEN> ListNhanVien() {
        Vector<ENTITY.TKNHANVIEN> vector = new Vector<ENTITY.TKNHANVIEN>();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("HienThiThongTinNhanVien");
            while (rs.next()) {
                ENTITY.TKNHANVIEN NhanVien = new ENTITY.TKNHANVIEN();
                NhanVien.setMaNhanVien(rs.getString("MaNhanVien"));
                NhanVien.setTenNhanVien(rs.getString("TenNhanVien"));
                NhanVien.setGioiTinh(rs.getBoolean("GioiTinh"));
                NhanVien.setSogiolam(rs.getDouble("SoGioLam"));
                NhanVien.setTongtien(rs.getDouble("TongLuong")); 

                vector.addElement(NhanVien);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vector;
    }
    public void UpdateTongLuongLabel(JLabel label) {
        int tongLuong = TinhTongLuongNhanVien(); // Gọi phương thức để lấy tổng lương từ procedure
        label.setText(String.valueOf(tongLuong)); // Cập nhật label với kết quả
    }
    public int TinhTongLuongNhanVien() {
        int result = 0;
        try {
            // Chuẩn bị câu lệnh gọi stored procedure
            String sql = "{CALL TinhTongLuongNhanVien()}";
            // Tạo đối tượng PreparedStatement
            PreparedStatement statement = cnn.getConnection().prepareStatement(sql);
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

	  public void UpdateTop5(JLabel label) {
		  String top5 = Top5NhanVien(); // Gọi phương thức để lấy tổng lương từ procedure
	      label.setText(String.valueOf(top5));// Cập nhật label với kết quả
    }
	  public String Top5NhanVien() {
		    String result = "";
		    try {
		        // Chuẩn bị câu lệnh gọi stored procedure
		        String sql = "{CALL HienThiTop5()}";
		        // Tạo đối tượng PreparedStatement
		        PreparedStatement statement = cnn.getConnection().prepareStatement(sql);
		        // Thực thi câu lệnh
		        ResultSet rs = statement.executeQuery();
		        // Lặp qua tất cả các nhân viên trả về từ stored procedure
		        while (rs.next()) {
		            result += rs.getString("TenNhanVien") + "\n"; // Thêm tên của nhân viên vào chuỗi kết quả
		        }
		        // Đóng kết nối và các tài nguyên
		        rs.close();
		        statement.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return result;
		}

}
