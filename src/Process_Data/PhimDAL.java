package Process_Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PhimDAL {
    GUI.frmTHONGTINPHIM guiPhim;
    DBHelper cnn;
    Object[] obj = null;
    
    public PhimDAL() {
        cnn = new DBHelper();
    }
    
    public PhimDAL(GUI.frmTHONGTINPHIM phim) {
    	guiPhim = phim;
        cnn = new DBHelper();
    }
    
    
	public Vector<ENTITY.PHIM> ListPhim() {
        Vector<ENTITY.PHIM> vector = new Vector<ENTITY.PHIM>();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("SelectAllPhim");
            while (rs.next()) {
            	ENTITY.PHIM phim = new ENTITY.PHIM();
            	phim.setMaPhim(rs.getString("MaPhim"));
            	phim.setTenPhim(rs.getString("TenPhim"));
            	phim.setThoiLuong(rs.getInt("ThoiLuong"));
            	phim.setQuocGia(rs.getString("QuocGia"));
            	phim.setDaoDien(rs.getString("DaoDien"));
            	phim.setNanSanXuat(rs.getDate("NamSanXuat"));
            	phim.setDoTuoiXem(rs.getInt("DoTuoiXem"));
            	phim.setMaTheLoai(rs.getString("MaTheLoai"));
            	
            	
                vector.addElement(phim);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vector;
    }
	public Vector<ENTITY.THELOAIPHIM> ListTheLoai() {
        Vector<ENTITY.THELOAIPHIM> vector = new Vector<ENTITY.THELOAIPHIM>();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("SelectTheLoaiPhim");
            while (rs.next()) {
            	ENTITY.THELOAIPHIM theLoai = new ENTITY.THELOAIPHIM();
            	theLoai.setMaTheLoaiPhim(rs.getString("MaTheLoaiPhim"));
            	theLoai.setTenTheLoaiPhim(rs.getString("TenTheLoaiPhim"));
                vector.addElement(theLoai);
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 2627) {
                System.out.println("Lỗi: Vi phạm ràng buộc khoá chính!");
                return null;
            } else {
                e.printStackTrace();
            }
        }
        return vector;
    }
	
	public int addData(Object[] param) {
		int k = cnn.Execute_StoredProcedures("ThemPhim", param);
		return k;
	}
	
	public int removeData(Object[] param) {
		int k = cnn.Execute_StoredProcedures("XoaPhim", param);
		return k;
	}
	
	public int updateData(Object[] param) {
		int k = cnn.Execute_StoredProcedures("SuaPhim", param);
		return k;
	}
}
