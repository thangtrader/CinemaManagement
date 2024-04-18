package Process_Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;

import ENTITY.TKPhim;

public class ThongKePhimDAL {
    private static ThongKePhimDAL instance;
	GUI.panelTHONGKEPHIM guiThongKePhim;
    DBHelper cnn;
    Object[] obj = null;
    
    public static ThongKePhimDAL getInstance() {
        if (instance == null) {
            instance = new ThongKePhimDAL();
        }
        return instance;
    }
    public ThongKePhimDAL() {
        cnn = new DBHelper();
    }
    
    public ThongKePhimDAL(GUI.panelTHONGKEPHIM phim) {
    	guiThongKePhim = phim;
        cnn = new DBHelper();
    }
    
    
	public Vector<ENTITY.TKPhim> ListPhim() {
        Vector<ENTITY.TKPhim> vector = new Vector<ENTITY.TKPhim>();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("SelectAllPhim");
            while (rs.next()) {
            	ENTITY.TKPhim TKphim = new ENTITY.TKPhim();
            	TKphim.setMaPhim(rs.getString("MaPhim"));
            	TKphim.setTenPhim(rs.getString("TenPhim"));
            	TKphim.setTheLoai(rs.getString("theLoai"));
            	TKphim.setSoLuongVe(rs.getInt("soLuongVe"));
            	TKphim.setDoanhThu(rs.getDouble("doanhThu"));
            	

                vector.addElement(TKphim);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vector;
    }
	public void UpdateTongDoanhThuLabel(String string) {
        int tongDoanhThu = tinhTongDoanhThu(); // Gọi phương thức để lấy tổng lương từ procedure
        string = String.valueOf(tongDoanhThu); // Cập nhật label với kết quả
    }
    public int tinhTongDoanhThu() {
        int result = 0;
        try {
            // Chuẩn bị câu lệnh gọi stored procedure
            String sql = "{CALL tinhTongDoanhThu()}";
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
	

		
   
}
