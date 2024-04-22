package Process_Data;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class NhanVienDAL {
	private static NhanVienDAL instance;
	DBHelper cnn;

    public static NhanVienDAL getInstance() {
        if (instance == null) {
            instance = new NhanVienDAL();
        }
        return instance;
    }
    public NhanVienDAL() {
        cnn = new DBHelper();
    }

    public ENTITY.NhanVienViewDTO GetNhanVienByMa(Object[] param) {
        ENTITY.NhanVienViewDTO nvviewDTO = new ENTITY.NhanVienViewDTO();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("GetNhanVien", param);
            while(rs.next()) {
            	nvviewDTO.setMaNhanVien(rs.getString("MaNhanVien"));
            	nvviewDTO.setTenNhanVien(rs.getString("TenNhanVien"));
            	nvviewDTO.setNgaySinh(rs.getDate("NgaySinh"));
            	nvviewDTO.setGioiTinh(rs.getString("GioiTinh"));
            	nvviewDTO.setDiaChi(rs.getString("DiaChi"));
            	nvviewDTO.setSdt(rs.getString("SoDienThoai"));
            	nvviewDTO.setCccd(rs.getString("CCCD"));
            	nvviewDTO.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
            	nvviewDTO.setMatKhau(rs.getString("MatKhau"));
            	nvviewDTO.setTenChinhSach(rs.getString("TenChinhSach"));
            	nvviewDTO.setTenChucVu(rs.getString("TenChucVu"));
            	nvviewDTO.setTrangThai(rs.getString("TrangThai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return nvviewDTO;
    }
	public Vector<ENTITY.NhanVienViewDTO> ListNhanVien() {
        Vector<ENTITY.NhanVienViewDTO> vector = new Vector<ENTITY.NhanVienViewDTO>();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("SelectNhanVien");
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
	public int updateData(Object[] param) {
		int k = cnn.Execute_StoredProcedures("SuaNhanVien", param);
		return k;
	}
	public int removeData(Object[] param) {
		int k = cnn.Execute_StoredProcedures("XoaNhanVien", param);
		return k;
	}
//	public int updateMK(Object[] param) {
//		int k = cnn.Execute_StoredProcedures("SuaMatKhau", param);
//		return k;
//	}
    public ENTITY.NHANVIEN GetNhanVienByTenTaiKhoan(Object[] param) {
        ENTITY.NHANVIEN nvDTO = new ENTITY.NHANVIEN();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("GetNhanVienByTenTaiKhoan", param);
            while(rs.next()) {
            	nvDTO.setMaNhanVien(rs.getString("MaNhanVien"));
            	nvDTO.setTenNhanVien(rs.getString("TenNhanVien"));
            	nvDTO.setNgaySinh(rs.getDate("NgaySinh"));
            	nvDTO.setGioiTinh(rs.getString("GioiTinh"));
            	nvDTO.setDiaChi(rs.getString("DiaChi"));
            	nvDTO.setSdt(rs.getString("SoDienThoai"));
            	nvDTO.setCccd(rs.getString("CCCD"));
            	nvDTO.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
            	nvDTO.setMatKhau(rs.getString("MatKhau"));

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return nvDTO;
    }
}
