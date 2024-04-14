package Process_Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class NhanVienDAL {
	private static NhanVienDAL instance;
	DBHelper cnn;
	GUI.frmNHANVIEN nhanvien;
	GUI.dialogThemNhanVien themnv;

    public static NhanVienDAL getInstance() {
        if (instance == null) {
            instance = new NhanVienDAL();
        }
        return instance;
    }
    public NhanVienDAL() {
        cnn = new DBHelper();
    }
    
    public NhanVienDAL(GUI.frmNHANVIEN nv) {
    	nhanvien = nv;
        cnn = new DBHelper();
    }
    public NhanVienDAL(GUI.dialogThemNhanVien nv) {
    	themnv = nv;
        cnn = new DBHelper();
    }
	public Vector<ENTITY.NhanVienViewDTO> ListNhanVien() {
        Vector<ENTITY.NhanVienViewDTO> vector = new Vector<ENTITY.NhanVienViewDTO>();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("LoadNhanVien");
            while (rs.next()) {
            	ENTITY.NhanVienViewDTO nvview = new ENTITY.NhanVienViewDTO();
            	nvview.setMaNhanVien(rs.getString("MaNhanVien"));
            	nvview.setTenNhanVien(rs.getString("TenNhanVien"));
            	nvview.setNgaySinh(rs.getDate("NgaySinh"));
            	nvview.setGioiTinh(rs.getString("GioiTinh"));
            	nvview.setSdt(rs.getString("SoDienThoai"));
            	nvview.setTenChinhSach(rs.getString("TenChinhSach"));
            	nvview.setTenChucVu(rs.getString("TenChucVu"));

            	
                vector.addElement(nvview);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vector;
    }
	public Vector<ENTITY.CHINHSACH> ListChinhSach() {
        Vector<ENTITY.CHINHSACH> vector = new Vector<ENTITY.CHINHSACH>();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("SelectChinhSach");
            while (rs.next()) {
            	ENTITY.CHINHSACH chinhsach = new ENTITY.CHINHSACH();
            	chinhsach.setMaChinhSach(rs.getString("MaChinhSach"));
            	chinhsach.setTenChinhSach(rs.getString("TenChinhSach"));
            	
                vector.addElement(chinhsach);
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
	public Vector<ENTITY.CHUCVU> ListChucVu() {
        Vector<ENTITY.CHUCVU> vector = new Vector<ENTITY.CHUCVU>();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("SelectChucVu");
            while (rs.next()) {
            	ENTITY.CHUCVU chucvu = new ENTITY.CHUCVU();
            	chucvu.setMaChucVu(rs.getString("MaChucVu"));
            	chucvu.setTenChucVu(rs.getString("TenChucVu"));
                vector.addElement(chucvu);
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
    public int KiemTraDangNhap(String tenTaiKhoan, String matKhau) {
        return Integer.parseInt(DBHelper.getInstance().executeScalar(tenTaiKhoan,matKhau).toString());
    }
	public int addData(Object[] param) {
		int k = cnn.Execute_StoredProcedures("ThemNhanVien", param);
		return k;
	}
	public int removeData(Object[] param) {
		int k = cnn.Execute_StoredProcedures("XoaNhanVien", param);
		return k;
	}
}
