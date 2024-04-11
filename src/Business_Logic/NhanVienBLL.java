package Business_Logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import Process_Data.DBHelper;
import Process_Data.NhanVienDAL;
import Process_Data.PhimDAL;

public class NhanVienBLL extends DBHelper {
	private static NhanVienBLL instance;
	GUI.frmNHANVIEN nhanvien;
	GUI.dialogThemNhanVien themnv;
	NhanVienDAL nvDAL;

    public static NhanVienBLL getInstance() {
        if (instance == null) {
            instance = new NhanVienBLL();
        }
        return instance;
    }

    public Vector<ENTITY.NhanVienViewDTO> ListPhim() {
        Vector<ENTITY.NhanVienViewDTO> vector = new Vector<ENTITY.NhanVienViewDTO>();
        try {
        	String sql = "	Select n.MaNhanVien, n.TenNhanVien, n.NgaySinh, n.GioiTinh, n.SoDienThoai, c.TenChinhSach, cv.TenChucVu From NHAN_VIEN as n INNER JOIN CHINH_SACH as c On n.MaChinhSach = c.MaChinhSach INNER JOIN  CHUC_VU as cv On n.MaChucVu = cv.MaChucVu";
        	PreparedStatement pre = cnn.prepareStatement(sql);
        	ResultSet rs = pre.executeQuery();
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
        }
        return vector;
    }
    public NhanVienBLL(GUI.frmNHANVIEN nv) {
    	nhanvien = nv;
    	nvDAL = new NhanVienDAL();
    	LoadNhanVien();
    }
    public NhanVienBLL(GUI.dialogThemNhanVien nv) {
    	themnv = nv;
    	nvDAL = new NhanVienDAL();
    	LoadChinhSach();
    	LoadChucVu();
    }
    public NhanVienBLL() {

    }
    public void LoadChinhSach() {
        DefaultComboBoxModel<ENTITY.CHINHSACH> model = new DefaultComboBoxModel<ENTITY.CHINHSACH>(nvDAL.ListChinhSach());
        themnv.cbboxChinhSach.setModel(model);
    }
    public void LoadChucVu() {
        DefaultComboBoxModel<ENTITY.CHUCVU> model = new DefaultComboBoxModel<ENTITY.CHUCVU>(nvDAL.ListChucVu());
        themnv.cbboxChucVu.setModel(model);
    }	
    public void LoadNhanVien() {
    	nhanvien.model = (DefaultTableModel) nhanvien.table.getModel();
        for (int i = nhanvien.model.getRowCount() - 1; i >= 0; i--) {
        	nhanvien.model.removeRow(i);
        }
        for (ENTITY.NhanVienViewDTO nvview : nvDAL.ListNhanVien()) {
        	nhanvien.model.addRow(new Object[]{nvview.getMaNhanVien(), nvview.getTenNhanVien(), nvview.getNgaySinh(), nvview.getGioiTinh(), nvview.getSdt(), nvview.getTenChinhSach(), nvview.getTenChucVu()});
        }
        System.out.println("ok");
    }
    public int KiemTraDangNhap(String tenTaiKhoan, String matKhau) {

        return NhanVienDAL.getInstance().KiemTraDangNhap(tenTaiKhoan, matKhau);
    }
    public int addData() {
    	String tennv = themnv.txtTenNV.getText().trim();
    	String ngaysinh = themnv.txtNgaySinh.getText().trim();
    	String gioitinh = themnv.txtGioiTinh.getText().trim();
    	String diachi = themnv.txtDiaChi.getText().trim();
    	String sdt = themnv.txtSDT.getText().trim();
    	String cccd = themnv.txtCCCD.getText().trim();
    	String tk = themnv.txtTK.getText().trim();
    	String mk = themnv.txtMK.getText().trim();
    	String machinhsach = ((ENTITY.CHINHSACH) themnv.cbboxChinhSach.getSelectedItem()).getMaChinhSach();
    	String machucvu = ((ENTITY.CHUCVU) themnv.cbboxChucVu.getSelectedItem()).getMaChucVu();
    	String trangthai = themnv.txtTrangThai.getText().trim();
    	Object[] param = new Object[] {tennv, ngaysinh, gioitinh, diachi, sdt, cccd, tk, mk, machinhsach, machucvu, trangthai};
    	return nvDAL.addData(param);
    }
    public int removeData() {
        int selectedRow = nhanvien.table.getSelectedRow();
    	String manv = nhanvien.table.getValueAt(selectedRow, 0).toString(); 
    	Object[] param = new Object[] {manv};
    	return nvDAL.removeData(param);
    }
}
