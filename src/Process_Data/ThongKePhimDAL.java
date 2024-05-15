package Process_Data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JLabel;

import ENTITY.TKPhim;

public class ThongKePhimDAL
{
	DBHelper cnn;
//	GUI.panelTHONGKEPHIM guiThongKePhim;
	private static ThongKePhimDAL instance;
//    Object[] obj = null;
    
    public static ThongKePhimDAL getInstance() {
        if (instance == null) {
            instance = new ThongKePhimDAL();
        }
        return instance;
    }
    public ThongKePhimDAL() {
        cnn = new DBHelper();
    }
    
//    public ThongKePhimDAL(GUI.panelTHONGKEPHIM phim) {
//    	guiThongKePhim = phim;
//        cnn = new DBHelper();
//    }
    
    
	public Vector<ENTITY.TKPhim> ListTKPhim(String proc) {
        Vector<ENTITY.TKPhim> vector = new Vector<ENTITY.TKPhim>();
        try {
           String sql = proc; //"{CALL tinhTongDoanhThu()}";
//          // Tạo đối tượng PreparedStatement
//          PreparedStatement statement = cnn.getConnection().prepareStatement(sql);
//          // Thực thi câu lệnh
//          ResultSet rs = statement.executeQuery();
//        	ResultSet rs = cnn.getResultSet_StoredProcedures(proc);
        	ResultSet rs = cnn.getResultSet(sql); 
            while (rs.next()) {
            	ENTITY.TKPhim TKphim = new ENTITY.TKPhim();
            	TKphim.setMaPhim(rs.getString("MaPhim"));
            	TKphim.setTenPhim(rs.getString("TenPhim"));
            	TKphim.setTheLoai(rs.getString("TenTheLoaiPhim"));
            	TKphim.setSoLuongVe(rs.getInt("soluong"));
            	TKphim.setDoanhThu(rs.getDouble("doanhthu"));

                vector.addElement(TKphim);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vector;
    }

//    public int tinhTongDoanhThu() {
//        int result = 0;
//        try {
//            // Chuẩn bị câu lệnh gọi stored procedure
//            String sql = "{CALL tinhTongDoanhThu()}";
//            // Tạo đối tượng PreparedStatement
//            PreparedStatement statement = cnn.getConnection().prepareStatement(sql);
//            // Thực thi câu lệnh
//            ResultSet rs = statement.executeQuery();
//            // Lấy kết quả
//            if (rs.next()) {
//                result = rs.getInt(1); // Giả sử stored procedure trả về một số nguyên
//            }
//            // Đóng kết nối và các tài nguyên
//            rs.close();
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
	public int tinhDoanhThu(String proc) {
		int result = 0;
		try {
			// Chuẩn bị câu lệnh gọi stored procedure
//			String sql = "{CALL " + proc + "()}";
			String sql = proc;
			// Tạo đối tượng PreparedStatement
			PreparedStatement statement = cnn.getConnection().prepareStatement(sql);
			// Thực thi câu lệnh
	
			ResultSet rs = statement.executeQuery();
			// Lấy kết quả
			if (rs.next()) {
				result = rs.getInt(1); // Giả sử stored procedure trả về một số nguyên
			}
			// Đóng kết nối và các tài nguyên
public class ThongKePhimDAL extends DBHelper {
	DBHelper cnn;
	private static ThongKePhimDAL instance;

	public static ThongKePhimDAL getInstance() {
		if (instance == null) {
			instance = new ThongKePhimDAL();
		}
		return instance;
	}

	public ThongKePhimDAL() {
		cnn = new DBHelper();
	}

	public int tinhDoanhThuSQL(String proc) {
		int result = 0;
		try {
			PreparedStatement statement = cnn.getConnection().prepareStatement(proc);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
//	public int tongDoanhThu() {
//		return tinhDoanhThu();
//	}



		
   

	public int tinhDoanhThuDAL(String date, Boolean log, int month, int year) {
		int result = 0;
		if (date == null) {
			result = tinhDoanhThuSQL("{CALL tinhTongDoanhThu()}");
		} else if (log) {
			result = tinhDoanhThuSQL("{CALL tinhTongDoanhThuTheoNam(" + year + ")}");
		} else {
			result = tinhDoanhThuSQL("{CALL tinhTongDoanhThuTheoThangNam(" + month + ", " + year + ")}");
		}
		return result;

	}

	public Vector<ENTITY.TKPhim> LoadTKPhim(String date, Boolean log, int month, int year) {
		Vector<ENTITY.TKPhim> vector = new Vector<ENTITY.TKPhim>();
		if (date == null) {
		} else if (log) {
			vector = ListTKPhim("selectThongKePhimTheoNam " + year);
		} else {
			vector = ListTKPhim("selectThongKePhimTheoThangNam " + month + ", " + year);
		}
		return vector;
	}

	public Vector<ENTITY.TKPhim> ListTKPhim(String proc) {
		Vector<ENTITY.TKPhim> vector = new Vector<ENTITY.TKPhim>();
		try {
			ResultSet rs = cnn.getResultSet(proc);
			while (rs.next()) {
				ENTITY.TKPhim TKphim = new ENTITY.TKPhim();
				TKphim.setMaPhim(rs.getString("MaPhim"));
				TKphim.setTenPhim(rs.getString("TenPhim"));
				TKphim.setTheLoai(rs.getString("TenTheLoaiPhim"));
				TKphim.setSoLuongVe(rs.getInt("soluong"));
				TKphim.setDoanhThu(rs.getDouble("doanhthu"));

				vector.addElement(TKphim);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return vector;
	}

}
