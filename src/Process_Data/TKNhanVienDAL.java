// Trong lớp DAL:

package Process_Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TKNhanVienDAL {
    DBHelper cnn;
    GUI.panelTKNHANVIEN GUITKNhanVien;

    public TKNhanVienDAL() {
        cnn = new DBHelper();
    }
    
    public TKNhanVienDAL(GUI.panelTKNHANVIEN pnv) {
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
                NhanVien.setGioiTinh(rs.getString("GioiTinh"));
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

    public int TinhTongLuongNhanVien() {
        int result = 0;
        try {
            String sql = "{CALL TinhTongLuongNhanVien()}";
            PreparedStatement statement = cnn.getConnection().prepareStatement(sql);
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
	  public String Top5NhanVien() {
		    String result = "";
		    try {
		        String sql = "{CALL HienThiTop5()}";
		        PreparedStatement statement = cnn.getConnection().prepareStatement(sql);
		        ResultSet rs = statement.executeQuery();
		        while (rs.next()) {
		            result += rs.getString("TenNhanVien") + "\n";
		        }
		        rs.close();
		        statement.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return result;
		}

}
