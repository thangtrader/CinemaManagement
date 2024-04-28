package Process_Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Vector;

import ENTITY.KHUNGGIOCHIEU_TGBATDAU;

public class KhungGioChieuDAL {
    GUI.diaCAPNHATLICHCHIEU capnhatlich;
    DBHelper cnn;
	private static KhungGioChieuDAL instance;

    public static KhungGioChieuDAL getInstance() {
        if (instance == null) {
            instance = new KhungGioChieuDAL();
        }
        return instance;
    }

    private KhungGioChieuDAL() {}

	public Vector<ENTITY.KHUNGGIOCHIEU_TGBATDAU> ListKhungGioChieu() {
		  Vector<ENTITY.KHUNGGIOCHIEU_TGBATDAU> vector = new Vector<ENTITY.KHUNGGIOCHIEU_TGBATDAU>();
		  try {
		      ResultSet rs = cnn.getResultSet_StoredProcedures("SelectKhungGioChieu");
		      while (rs.next()) {
		      	ENTITY.KHUNGGIOCHIEU_TGBATDAU gio = new ENTITY.KHUNGGIOCHIEU_TGBATDAU();
		      	gio.setMaKhungGioChieu(rs.getString("MaKhungGioChieu"));
		      	gio.setTenKhungGio(rs.getString("MaTenKhungGio"));
		      	gio.setTgBatDau(rs.getTime("TGBatDau"));
		      	gio.setTgBatDau(rs.getTime("TGKetThuc"));
		      	vector.addElement(gio);
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


	public static String getTGBDByMaKG(Time thoigianbatdau) {
		// TODO Auto-generated method stub
		return null;
	}


}

