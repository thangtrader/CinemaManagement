package Business_Logic;

import java.util.Vector;
import ENTITY.THELOAIPHIM;
import Process_Data.TheLoaiPhimDAL;

public class TheLoaiPhimBLL {
	private static TheLoaiPhimBLL instance;

    public static TheLoaiPhimBLL getInstance() {
        if (instance == null) {
            instance = new TheLoaiPhimBLL();
        }
        return instance;
    }

    public THELOAIPHIM getTheLoaiByMaTL(String MaTheLoaiPhim) {
    	THELOAIPHIM data = new THELOAIPHIM();
        for (THELOAIPHIM i : TheLoaiPhimDAL.getInstance().ListTheLoai()) {
            if (i.getMaTheLoaiPhim().equals(MaTheLoaiPhim)) {
                data.setMaTheLoaiPhim(i.getMaTheLoaiPhim());
                data.setTenTheLoaiPhim(i.getTenTheLoaiPhim());
            }
        }
        return data;
    }

    public Vector<THELOAIPHIM> getAllTheLoaiPhim() {
    	Vector<THELOAIPHIM> data = new Vector<ENTITY.THELOAIPHIM>();
        for (THELOAIPHIM i : TheLoaiPhimDAL.getInstance().ListTheLoai()) {
            data.add(i);
        }
        return data;
    }

    public String getTenTLByMaTL(String MaTheLoai) {
        for (THELOAIPHIM i : TheLoaiPhimDAL.getInstance().ListTheLoai()) {
            if (i.getMaTheLoaiPhim().equals(MaTheLoai)) {
                return i.getTenTheLoaiPhim();
            }
        }
        return null;
    }
}
