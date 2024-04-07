package Process_Data;

public class NhanVienDAL {
	private static NhanVienDAL instance;

    public static NhanVienDAL getInstance() {
        if (instance == null) {
            instance = new NhanVienDAL();
        }
        return instance;
    }

    private NhanVienDAL() {
        // Constructor implementation
    }
    public int KiemTraDangNhap(String tenTaiKhoan, String matKhau) {
        return Integer.parseInt(DBHelper.getInstance().executeScalar(tenTaiKhoan,matKhau).toString());
    }
}
