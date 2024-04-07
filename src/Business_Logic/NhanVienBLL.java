package Business_Logic;

import Process_Data.NhanVienDAL;

public class NhanVienBLL {
	private static NhanVienBLL instance;

    public static NhanVienBLL getInstance() {
        if (instance == null) {
            instance = new NhanVienBLL();
        }
        return instance;
    }

    private NhanVienBLL() {
        // Constructor implementation
    }
    public int KiemTraDangNhap(String tenTaiKhoan, String matKhau) {

        return NhanVienDAL.getInstance().KiemTraDangNhap(tenTaiKhoan, matKhau);
    }
}
