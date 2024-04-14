package Process_Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import ENTITY.THELOAIPHIM;

public class TheLoaiPhimDAL {
    GUI.frmTHONGTINPHIM guiPhim;
    DBHelper cnn;
	private static TheLoaiPhimDAL instance;

    public static TheLoaiPhimDAL getInstance() {
        if (instance == null) {
            instance = new TheLoaiPhimDAL();
        }
        return instance;
    }

    private TheLoaiPhimDAL() {}

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
}
