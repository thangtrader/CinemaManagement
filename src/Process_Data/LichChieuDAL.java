package Process_Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class LichChieuDAL {
    GUI.panelLICHCHIEU guiLichChieu;
    GUI.diaCAPNHATLICHCHIEU updateLich;
    DBHelper cnn;
    Object[] obj = null;
    
    public LichChieuDAL() {
        cnn = new DBHelper();
    }
    
    public LichChieuDAL(GUI.panelLICHCHIEU lich) {
    	guiLichChieu = lich;
        cnn = new DBHelper();
    }
    public LichChieuDAL(GUI.diaCAPNHATLICHCHIEU upLich) {
    	updateLich = upLich;
        cnn = new DBHelper();
    }
	public Vector<ENTITY.LICHCHIEUVIEWDTO> ListLichChieu() {
        Vector<ENTITY.LICHCHIEUVIEWDTO> vector = new Vector<ENTITY.LICHCHIEUVIEWDTO>();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("LoadLichChieu");
            while (rs.next()) {
            	ENTITY.LICHCHIEUVIEWDTO lich = new ENTITY.LICHCHIEUVIEWDTO();
            	lich.setTenPhim(rs.getString("TenPhim"));
            	lich.setTenPhong(rs.getString("TenPhong"));
            	lich.setNgayChieu(rs.getDate("NgayChieu"));
             	lich.setThoiGianBatDau(rs.getTime("TGBatDau"));
            	lich.setThoiGianKetThuc(rs.getTime("TGKetThuc"));
            	lich.setTenTinhTrang(rs.getString("TenTinhTrang"));
            	
            	
                vector.addElement(lich);
                                          
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vector;
    }
	public ENTITY.LICHCHIEUVIEWDTO GetLichByMa(Object[] param) {
        ENTITY.LICHCHIEUVIEWDTO lich = new ENTITY.LICHCHIEUVIEWDTO();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("GetLichByMa", param);
            while (rs.next()) {
            	lich.setTenPhim(rs.getString("TenPhim"));
            	lich.setTenPhong(rs.getString("TenPhong"));
            	lich.setNgayChieu(rs.getDate("NgayChieu"));
             	lich.setThoiGianBatDau(rs.getTime("TGBatDau"));
            	lich.setThoiGianKetThuc(rs.getTime("TGKetThuc"));
            	lich.setTenTinhTrang(rs.getString("TenTinhTrang"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lich;
    }
	public Vector<ENTITY.KHUNGGIOCHIEU_TGBATDAU> ListTGBatDau() {
  Vector<ENTITY.KHUNGGIOCHIEU_TGBATDAU> vector = new Vector<ENTITY.KHUNGGIOCHIEU_TGBATDAU>();
  try {
      ResultSet rs = cnn.getResultSet_StoredProcedures("SelectTGBD");
      while (rs.next()) {
      	ENTITY.KHUNGGIOCHIEU_TGBATDAU thoigian = new ENTITY.KHUNGGIOCHIEU_TGBATDAU();
      	thoigian.setMaKhungGioChieu(rs.getString("MaKhungGioChieu"));
      	thoigian.setTenKhungGio(rs.getString("TenKhungGio"));
      	thoigian.setTgBatDau(rs.getTime("TGBatDau"));
      //	thoigian.setTgKetThuc(rs.getTime("TGKetThuc"));
          vector.addElement(thoigian);
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
	public Vector<ENTITY.KHUNGGIOCHIEU_TGKETTHUC> ListTGKetThuc() {
		  Vector<ENTITY.KHUNGGIOCHIEU_TGKETTHUC> vector = new Vector<ENTITY.KHUNGGIOCHIEU_TGKETTHUC>();
		  try {
		      ResultSet rs = cnn.getResultSet_StoredProcedures("SelectTGKT");
		      while (rs.next()) {
		      	ENTITY.KHUNGGIOCHIEU_TGKETTHUC thoigian = new ENTITY.KHUNGGIOCHIEU_TGKETTHUC();
		      	thoigian.setMaKhungGioChieu(rs.getString("MaKhungGioChieu"));
		      	thoigian.setTenKhungGio(rs.getString("TenKhungGio"));
		   //   	thoigian.setTgBatDau(rs.getTime("TGBatDau"));
		      	thoigian.setTgKetThuc(rs.getTime("TGKetThuc"));
		          vector.addElement(thoigian);
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
	public Vector<ENTITY.PHONGCHIEU> ListPhongChieu() {
		  Vector<ENTITY.PHONGCHIEU> vector = new Vector<ENTITY.PHONGCHIEU>();
		  try {
		      ResultSet rs = cnn.getResultSet_StoredProcedures("SelectPhongChieu");
		      while (rs.next()) {
		      	ENTITY.PHONGCHIEU phong = new ENTITY.PHONGCHIEU();
		      	phong.setMaPhongChieu(rs.getString("MaPhongChieu"));
		      	phong.setTenPhong(rs.getString("TenPhong"));
		      	phong.setMaTinhTrang(rs.getInt("MaTinhTrang"));
		      	vector.addElement(phong);
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

	public int removeData(Object[] param) {
		int k = cnn.Execute_StoredProcedures("XoaLich", param);
		return k;
	}

	public int updateData(Object[] param) {
		int k = cnn.Execute_StoredProcedures("UpdateLichChieu", param);
		return k;
	}

}
