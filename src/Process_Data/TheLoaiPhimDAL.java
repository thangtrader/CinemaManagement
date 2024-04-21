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

}
