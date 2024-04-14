package Process_Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class LichChieu {
	GUI.frmLICHCHIEUPHIM guiLich;
    DBHelper cnn;
    Object[] obj = null;
    
    public LichChieu() {
        cnn = new DBHelper();
    }
    
    public LichChieu(GUI.frmLICHCHIEUPHIM lich) {
    	guiLich = lich;
        cnn = new DBHelper();
    }
    
    
	public Vector<ENTITY.LICHCHIEU> ListLich() {
        Vector<ENTITY.LICHCHIEU> vector = new Vector<ENTITY.LICHCHIEU>();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("selectAllLich");
            while (rs.next()) {
            	ENTITY.LICHCHIEU lich = new ENTITY.LICHCHIEU();
            	lich.setMaPhim(rs.getString("MaPhim"));
            	lich.setMaPhongChieu(rs.getString("MaPhongChieu"));
            	lich.setMaKhungGioChieu(rs.getString("MaKhungGioChieu"));
            	lich.setNgayChieu(rs.getDate("NgayChieu"));
            	lich.setTrangThai(rs.getString("TrangThai"));
                vector.addElement(lich);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vector;
    }
//	public Vector<ENTITY.THELOAIPHIM> ListTheLoai() {
//        Vector<ENTITY.THELOAIPHIM> vector = new Vector<ENTITY.THELOAIPHIM>();
//        try {
//            ResultSet rs = cnn.getResultSet_StoredProcedures("SelectTheLoaiPhim");
//            while (rs.next()) {
//            	ENTITY.THELOAIPHIM theLoai = new ENTITY.THELOAIPHIM();
//            	theLoai.setMaTheLoaiPhim(rs.getString("MaTheLoaiPhim"));
//            	theLoai.setTenTheLoaiPhim(rs.getString("TenTheLoaiPhim"));
//                vector.addElement(theLoai);
//            }
//        } catch (SQLException e) {
//            if (e.getErrorCode() == 2627) {
//                System.out.println("Lỗi: Vi phạm ràng buộc khoá chính!");
//                return null;
//            } else {
//                e.printStackTrace();
//            }
//        }
//        return vector;
//    }
	
//	public int addData(Object[] param) {
//		int k = cnn.Execute_StoredProcedures("ThemPhim", param);
//		return k;
//	}
	
	public int removeData(Object[] param) {
		int k = cnn.Execute_StoredProcedures("XoaPhim", param);
		return k;
	}
	
	public int updateData(Object[] param) {
		int k = cnn.Execute_StoredProcedures("CapNhapLichChieu", param);
		return k;
	}
}
