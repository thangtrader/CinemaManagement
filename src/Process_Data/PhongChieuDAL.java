package Process_Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PhongChieuDAL {
    GUI.diaCAPNHATLICHCHIEU capnhatlich;
    DBHelper cnn;
	private static PhongChieuDAL instance;

    public static PhongChieuDAL getInstance() {
        if (instance == null) {
            instance = new PhongChieuDAL();
        }
        return instance;
    }

    private PhongChieuDAL() {}

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
}
