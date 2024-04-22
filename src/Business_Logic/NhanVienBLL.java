package Business_Logic;


import java.util.Vector;
import Process_Data.DBHelper;
import Process_Data.NhanVienDAL;

public class NhanVienBLL extends DBHelper {
	private static NhanVienBLL instance;
	NhanVienDAL nvDAL;

	
    public static NhanVienBLL getInstance() {
        if (instance == null) {
            instance = new NhanVienBLL();
        }
        return instance;
    }
    
    public NhanVienBLL() {
    	nvDAL = new NhanVienDAL();
    }
  
    public Vector<ENTITY.CHINHSACH> LoadChinhSach() {
        return nvDAL.ListChinhSach(); 
    }
    
    public Vector<ENTITY.CHUCVU> LoadChucVu() {
    	return nvDAL.ListChucVu();
    }	
    
    public Vector<ENTITY.NhanVienViewDTO> LoadNhanVien() {
        return nvDAL.ListNhanVien(); 
    }
    
    public int KiemTraDangNhap(String tenTaiKhoan, String matKhau) {

        return NhanVienDAL.getInstance().KiemTraDangNhap(tenTaiKhoan, matKhau);
    }
    
    public int addData(ENTITY.NhanVienViewDTO nvviewDTO) {
    	
    	Object[] param = new Object[] {nvviewDTO.getTenNhanVien(), nvviewDTO.getNgaySinh(), nvviewDTO.getGioiTinh(), nvviewDTO.getDiaChi(), nvviewDTO.getSdt(), nvviewDTO.getCccd(), nvviewDTO.getTenTaiKhoan(), nvviewDTO.getMatKhau(), nvviewDTO.getTenChinhSach(), nvviewDTO.getTenChucVu(), nvviewDTO.getTrangThai()};
    	return nvDAL.addData(param);
    }
    
    public int updateData(ENTITY.NhanVienViewDTO nvviewDTO) {   	
    	Object[] param = new Object[] {nvviewDTO.getMaNhanVien() ,nvviewDTO.getTenNhanVien(), nvviewDTO.getNgaySinh(), nvviewDTO.getGioiTinh(), nvviewDTO.getDiaChi(), nvviewDTO.getSdt(), nvviewDTO.getCccd(), nvviewDTO.getTenTaiKhoan(), nvviewDTO.getMatKhau(), nvviewDTO.getTenChinhSach(), nvviewDTO.getTenChucVu(), nvviewDTO.getTrangThai()};
    	return nvDAL.updateData(param);
    }
    
    public int removeData(ENTITY.NhanVienViewDTO nvviewDTO) {
    	Object[] param = new Object[] {nvviewDTO.getMaNhanVien()};
    	return nvDAL.removeData(param);
    }
    
    public ENTITY.NhanVienViewDTO selectData(String manv) {
    	ENTITY.NhanVienViewDTO nvviewDTO = new ENTITY.NhanVienViewDTO();
    	Object[] param = new Object[] {manv};
    	nvviewDTO = nvDAL.GetNhanVienByMa(param);
    	return nvviewDTO;
    }
    
    public ENTITY.NHANVIEN GetNhanVienByTenTaiKhoan(String tentaikhoan) {
    	ENTITY.NHANVIEN nvDTO = new ENTITY.NHANVIEN();
    	Object[] param = new Object[] {tentaikhoan};
    	nvDTO = nvDAL.GetNhanVienByTenTaiKhoan(param);
    	return nvDTO;
    }
    
//    public int updateMK() {
//    	String manv = canhan.textFieldMaNhanVien.getText().trim();
//    	String mk = doimk.textFieldMatKhauMoi.getText().trim();
//    	Object[] param = new Object[] {manv, mk};
//    	return nvDAL.updateData(param);
//    } 
}
