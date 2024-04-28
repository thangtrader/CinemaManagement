package Business_Logic;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.imageio.ImageIO;

import ENTITY.PhimViewDTO;
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
    
    public int updateMK(ENTITY.NHANVIEN nvDTO) {
    	Object[] param = new Object[] {nvDTO.getTenTaiKhoan(), nvDTO.getMatKhau()};
    	return nvDAL.updateMK(param);
    }
    
    public static byte[] readImageBytes(String imagePath) throws IOException {
        return Files.readAllBytes(Paths.get(imagePath));
    }

    public static byte[] ChuyenAnhThanhMangByte(BufferedImage bufferedImage) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpeg", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Image ChuyenMangByteSangAnh(byte[] byteArray) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        return ImageIO.read(byteArrayInputStream);
    }
    
    public int updateAnh(ENTITY.NHANVIEN nvDTO) {
    	Object[] param = new Object[] {nvDTO.getMaNhanVien(), nvDTO.getAnh()};
    	return nvDAL.updateAnh(param);
    }
    
    
    public ENTITY.NHANVIEN GetNhanVienByTest(String tentaikhoan) {
    	ENTITY.NHANVIEN nvDTO = new ENTITY.NHANVIEN();
    	Object[] param = new Object[] {tentaikhoan};
    	nvDTO = nvDAL.GetNhanVienByTenTaiKhoan(param);
    	return nvDTO;
    }
    
    public Vector<ENTITY.NhanVienViewDTO> TimKiemByTenNhanVien(String tenNV){
        Vector<ENTITY.NhanVienViewDTO> vec = new Vector<ENTITY.NhanVienViewDTO>();
        try {

            String sql = "Select n.MaNhanVien, n.TenNhanVien, n.NgaySinh, n.GioiTinh, n.SoDienThoai, c.TenChinhSach, cv.TenChucVu\r\n"
            		+ "From NHAN_VIEN as n Inner Join CHINH_SACH as c On n.MaChinhSach = c.MaChinhSach Inner Join CHUC_VU as cv On n.MaChucVu = cv.MaChucVu\r\n"
            		+ "Where n.TenNhanVien LIKE ?";
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, "%" + tenNV + "%");
            ResultSet rs = pre.executeQuery();	
            while (rs.next()) {
            	ENTITY.NhanVienViewDTO nvviewDTO = new ENTITY.NhanVienViewDTO();
            	nvviewDTO.setMaNhanVien(rs.getString("MaNhanVien"));
            	nvviewDTO.setTenNhanVien(rs.getString("TenNhanVien"));
            	nvviewDTO.setNgaySinh(rs.getDate("NgaySinh"));
            	nvviewDTO.setGioiTinh(rs.getString("GioiTinh"));
            	nvviewDTO.setSdt(rs.getString("SoDienThoai"));
            	nvviewDTO.setTenChinhSach(rs.getString("TenChinhSach"));
            	nvviewDTO.setTenChucVu(rs.getString("TenChucVu"));
                vec.add(nvviewDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    public Vector<ENTITY.NhanVienViewDTO> TimKiemByGioiTinh(String gioiTinh){
        Vector<ENTITY.NhanVienViewDTO> vec = new Vector<ENTITY.NhanVienViewDTO>();
        try {

            String sql = "Select n.MaNhanVien, n.TenNhanVien, n.NgaySinh, n.GioiTinh, n.SoDienThoai, c.TenChinhSach, cv.TenChucVu\r\n"
            		+ "From NHAN_VIEN as n Inner Join CHINH_SACH as c On n.MaChinhSach = c.MaChinhSach Inner Join CHUC_VU as cv On n.MaChucVu = cv.MaChucVu\r\n"
            		+ "Where n.GioiTinh LIKE ?";
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, "%" + gioiTinh + "%");
            ResultSet rs = pre.executeQuery();	
            while (rs.next()) {
            	ENTITY.NhanVienViewDTO nvviewDTO = new ENTITY.NhanVienViewDTO();
            	nvviewDTO.setMaNhanVien(rs.getString("MaNhanVien"));
            	nvviewDTO.setTenNhanVien(rs.getString("TenNhanVien"));
            	nvviewDTO.setNgaySinh(rs.getDate("NgaySinh"));
            	nvviewDTO.setGioiTinh(rs.getString("GioiTinh"));
            	nvviewDTO.setSdt(rs.getString("SoDienThoai"));
            	nvviewDTO.setTenChinhSach(rs.getString("TenChinhSach"));
            	nvviewDTO.setTenChucVu(rs.getString("TenChucVu"));
                vec.add(nvviewDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    public Vector<ENTITY.NhanVienViewDTO> TimKiemByTenChinhSach(String tenChinhSach){
        Vector<ENTITY.NhanVienViewDTO> vec = new Vector<ENTITY.NhanVienViewDTO>();
        try {

            String sql = "Select n.MaNhanVien, n.TenNhanVien, n.NgaySinh, n.GioiTinh, n.SoDienThoai, c.TenChinhSach, cv.TenChucVu\r\n"
            		+ "From NHAN_VIEN as n Inner Join CHINH_SACH as c On n.MaChinhSach = c.MaChinhSach Inner Join CHUC_VU as cv On n.MaChucVu = cv.MaChucVu\r\n"
            		+ "Where c.TenChinhSach LIKE ?";
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, "%" + tenChinhSach + "%");
            ResultSet rs = pre.executeQuery();	
            while (rs.next()) {
            	ENTITY.NhanVienViewDTO nvviewDTO = new ENTITY.NhanVienViewDTO();
            	nvviewDTO.setMaNhanVien(rs.getString("MaNhanVien"));
            	nvviewDTO.setTenNhanVien(rs.getString("TenNhanVien"));
            	nvviewDTO.setNgaySinh(rs.getDate("NgaySinh"));
            	nvviewDTO.setGioiTinh(rs.getString("GioiTinh"));
            	nvviewDTO.setSdt(rs.getString("SoDienThoai"));
            	nvviewDTO.setTenChinhSach(rs.getString("TenChinhSach"));
            	nvviewDTO.setTenChucVu(rs.getString("TenChucVu"));
                vec.add(nvviewDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    public Vector<ENTITY.NhanVienViewDTO> TimKiemByTenChucVu(String tenChucVu){
        Vector<ENTITY.NhanVienViewDTO> vec = new Vector<ENTITY.NhanVienViewDTO>();
        try {

            String sql = "Select n.MaNhanVien, n.TenNhanVien, n.NgaySinh, n.GioiTinh, n.SoDienThoai, c.TenChinhSach, cv.TenChucVu\r\n"
            		+ "From NHAN_VIEN as n Inner Join CHINH_SACH as c On n.MaChinhSach = c.MaChinhSach Inner Join CHUC_VU as cv On n.MaChucVu = cv.MaChucVu\r\n"
            		+ "Where cv.TenChucVu LIKE ?";
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, "%" + tenChucVu + "%");
            ResultSet rs = pre.executeQuery();	
            while (rs.next()) {
            	ENTITY.NhanVienViewDTO nvviewDTO = new ENTITY.NhanVienViewDTO();
            	nvviewDTO.setMaNhanVien(rs.getString("MaNhanVien"));
            	nvviewDTO.setTenNhanVien(rs.getString("TenNhanVien"));
            	nvviewDTO.setNgaySinh(rs.getDate("NgaySinh"));
            	nvviewDTO.setGioiTinh(rs.getString("GioiTinh"));
            	nvviewDTO.setSdt(rs.getString("SoDienThoai"));
            	nvviewDTO.setTenChinhSach(rs.getString("TenChinhSach"));
            	nvviewDTO.setTenChucVu(rs.getString("TenChucVu"));
                vec.add(nvviewDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
}
