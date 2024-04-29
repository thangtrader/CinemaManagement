package Process_Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import ENTITY.KHUNGGIOCHIEU;
import GUI.panelTHEMLICHCHIEU;

public class TaoLichChieuDAL {
	    GUI.panelTHEMLICHCHIEU guiPhim;
	    DBHelper cnn;
	    Object[] obj = null;
	    
	    public TaoLichChieuDAL() {
	        cnn = new DBHelper();
	    }
	    
	    public TaoLichChieuDAL(GUI.panelTHEMLICHCHIEU phim) {
	    	guiPhim = phim;
	        cnn = new DBHelper();
	    }  
		public Vector<ENTITY.PHIM> ListLCPhim() {
	        Vector<ENTITY.PHIM> vector = new Vector<ENTITY.PHIM>();
	        try {
	            ResultSet rs = cnn.getResultSet_StoredProcedures("HienThiDanhSachPhim");
	            while (rs.next()) {
	            	ENTITY.PHIM phim = new ENTITY.PHIM();
	            	phim.setMaPhim(rs.getString("MaPhim")); 
	            	phim.setTenPhim(rs.getString("TenPhim"));  
	                vector.addElement(phim);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	        return vector;
	    }
		public Vector<ENTITY.PHONGCHIEU> ListDSPC() {
		    Vector<ENTITY.PHONGCHIEU> vector = new Vector<ENTITY.PHONGCHIEU>();
		    try {
		        ResultSet rs = cnn.getResultSet_StoredProcedures("HT_DanhSachPhongChieu");
		        while (rs.next()) {
		            ENTITY.PHONGCHIEU dspchieu = new ENTITY.PHONGCHIEU();
		            dspchieu.setMaPhongChieu(rs.getString("MaPhongChieu"));
		            dspchieu.setTenPhong(rs.getString("TenPhong"));
		            vector.addElement(dspchieu);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    }
		    return vector;
		}
		public int addData(Object[] param) {
			int k = cnn.Execute_StoredProcedures("LuuLC", param);
			return k;
		}

		public Vector<ENTITY.KHUNGGIOCHIEU> ListKhungGioChieu() {
        Vector<ENTITY.KHUNGGIOCHIEU> vector = new Vector<ENTITY.KHUNGGIOCHIEU>();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("SelectKhungGioChieu");
            while (rs.next()) {
            	ENTITY.KHUNGGIOCHIEU khunggio = new ENTITY.KHUNGGIOCHIEU();
            	khunggio.setMaKhungGioChieu(rs.getString("MaKhungGioChieu"));
            	khunggio.setTenKhungGio(rs.getString("TenKhungGio"));
                vector.addElement(khunggio);
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
}


