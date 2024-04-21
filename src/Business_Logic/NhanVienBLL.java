package Business_Logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	GUI.frmCANHAN canhan;

    public static NhanVienBLL getInstance() {
        if (instance == null) {
            instance = new NhanVienBLL();
        }
        return instance;
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
    
    public NhanVienBLL(GUI.frmCANHAN cn) {
    	canhan = cn;
    	nvDAL = new NhanVienDAL();
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
    }
    public int KiemTraDangNhap(String tenTaiKhoan, String matKhau) {

        return NhanVienDAL.getInstance().KiemTraDangNhap(tenTaiKhoan, matKhau);
    }
    public int addData() {
    	String tennv = themnv.txtTenNV.getText().trim();
    	Date ngaysinh = themnv.calendar.getDate();
    	String gioitinh;
    	if(themnv.rbtnNam.isSelected() == true) {
    		gioitinh = themnv.rbtnNam.getText();
    	}
    	else {
    		gioitinh = themnv.rbtnNu.getText();
    	}
    	String diachi = themnv.txtDiaChi.getText().trim();
    	String sdt = themnv.txtSDT.getText().trim();
    	String cccd = themnv.txtCCCD.getText().trim();
    	String tk = themnv.txtTK.getText().trim();
    	String mk = themnv.txtMK.getText().trim();
    	String machinhsach = ((ENTITY.CHINHSACH) themnv.cbboxChinhSach.getSelectedItem()).getMaChinhSach();
    	String machucvu = ((ENTITY.CHUCVU) themnv.cbboxChucVu.getSelectedItem()).getMaChucVu();
    	String trangthai;
    	if(themnv.rbtn1.isSelected() == true) {
    		trangthai = themnv.rbtn1.getText();
    	}
    	else {
    		trangthai = themnv.rbtn0.getText();
    	}
    	Object[] param = new Object[] {tennv, ngaysinh, gioitinh, diachi, sdt, cccd, tk, mk, machinhsach, machucvu, trangthai};
    	return nvDAL.addData(param);
    }
    public int updateData() {
    	String manv = themnv.txtMaNV.getText();
    	String tennv = themnv.txtTenNV.getText().trim();
    	Date ngaysinh = themnv.calendar.getDate();
    	String gioitinh;
    	if(themnv.rbtnNam.isSelected() == true) {
    		gioitinh = themnv.rbtnNam.getText();
    	}
    	else {
    		gioitinh = themnv.rbtnNu.getText();
    	}
    	String diachi = themnv.txtDiaChi.getText().trim();
    	String sdt = themnv.txtSDT.getText().trim();
    	String cccd = themnv.txtCCCD.getText().trim();
    	String tk = themnv.txtTK.getText().trim();
    	String mk = themnv.txtMK.getText().trim();
    	String machinhsach = ((ENTITY.CHINHSACH) themnv.cbboxChinhSach.getSelectedItem()).getMaChinhSach();
    	String machucvu = ((ENTITY.CHUCVU) themnv.cbboxChucVu.getSelectedItem()).getMaChucVu();
    	String trangthai;
    	if(themnv.rbtn1.isSelected() == true) {
    		trangthai = themnv.rbtn1.getText();
    	}
    	else {
    		trangthai = themnv.rbtn0.getText();
    	}
    	Object[] param = new Object[] {manv, tennv, ngaysinh, gioitinh, diachi, sdt, cccd, tk, mk, machinhsach, machucvu, trangthai};
    	return nvDAL.updateData(param);
    }
    public int removeData() {
        int selectedRow = nhanvien.table.getSelectedRow();
    	String manv = nhanvien.table.getValueAt(selectedRow, 0).toString(); 
    	Object[] param = new Object[] {manv};
    	return nvDAL.removeData(param);
    }
    public void selectData(String manv) {
    	ENTITY.NhanVienViewDTO nvviewDTO = new ENTITY.NhanVienViewDTO();
    	Object[] param = new Object[] {manv};
    	nvviewDTO = nvDAL.GetNhanVienByMa(param);
    	themnv.txtMaNV.setText(nvviewDTO.getMaNhanVien());
    	themnv.txtTenNV.setText(nvviewDTO.getTenNhanVien());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
        Date ngaySinh = nvviewDTO.getNgaySinh();		
        String ngaySinhString = dateFormat.format(ngaySinh);
        themnv.txtNgaySinh.setText(ngaySinhString);
        
    	if (nvviewDTO.getGioiTinh().equalsIgnoreCase("Nam")) {
    	    themnv.rbtnNam.setSelected(true);
    	} else {
    	    themnv.rbtnNu.setSelected(true);
    	}
    	
    	themnv.txtDiaChi.setText(nvviewDTO.getDiaChi());
    	themnv.txtSDT.setText(nvviewDTO.getSdt());
    	themnv.txtCCCD.setText(nvviewDTO.getCccd());
    	themnv.txtTK.setText(nvviewDTO.getTenTaiKhoan());
    	themnv.txtMK.setText(nvviewDTO.getMatKhau());
    	
        for(int i = 0; i< themnv.cbboxChinhSach.getItemCount(); i++) {
        	if(themnv.cbboxChinhSach.getItemAt(i).toString().equalsIgnoreCase(nvviewDTO.getTenChinhSach())) {
        		themnv.cbboxChinhSach.setSelectedIndex(i);
        	}
        }
        
        for(int i = 0; i< themnv.cbboxChucVu.getItemCount(); i++) {
        	if(themnv.cbboxChucVu.getItemAt(i).toString().equalsIgnoreCase(nvviewDTO.getTenChucVu())) {
        		themnv.cbboxChucVu.setSelectedIndex(i);
        	}
        }
    	if (nvviewDTO.getTrangThai().equalsIgnoreCase("1")) {
    	    themnv.rbtn1.setSelected(true);
    	} else {
    	    themnv.rbtn0.setSelected(true);
    	}
    }
    
    public void GetNhanVienByTenTaiKhoan(String tentaikhoan) {
    	ENTITY.NHANVIEN nvDTO = new ENTITY.NHANVIEN();
    	Object[] param = new Object[] {tentaikhoan};
    	nvDTO = nvDAL.GetNhanVienByTenTaiKhoan(param);
    	canhan.textFieldTen.setText(nvDTO.getTenNhanVien());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
        Date ngaySinh = nvDTO.getNgaySinh();		
        String ngaySinhString = dateFormat.format(ngaySinh);
        canhan.textFieldNgaySinh.setText(ngaySinhString);
        
    	
        canhan.textFieldDiaChi.setText(nvDTO.getDiaChi());
        canhan.textFieldGioiTinh.setText(nvDTO.getGioiTinh());
        canhan.textFieldCCCD.setText(nvDTO.getCccd());
        canhan.textFieldDienThoai.setText(nvDTO.getSdt());
        canhan.textFieldTenTaiKhoan.setText(nvDTO.getTenTaiKhoan());
        canhan.textFieldMatKhau.setText(nvDTO.getMatKhau());
    }
    
    
    
    
    public boolean ValidatedForm() {
    	if(themnv.txtTenNV.getText().isEmpty() || themnv.txtNgaySinh.getText().isEmpty() || themnv.txtDiaChi.getText().isEmpty() || themnv.txtSDT.getText().isEmpty() ||themnv.txtCCCD.getText().isEmpty() ||themnv.txtTK.getText().isEmpty() ||themnv.txtMK.getText().isEmpty()) {
    		return false;
    	}
    	else {
    		return true;
    	}  		
    }
    public boolean ValidatedRegex() {
    	if(!themnv.lbRegexTen.getText().isEmpty() || !themnv.lbRegexNgaySinh.getText().isEmpty() || !themnv.lbRegexDiaChi.getText().isEmpty() || !themnv.lbRegexSDT.getText().isEmpty() || !themnv.lbRegexCCCD.getText().isEmpty()) {
    		return false;
    	}
    	else {
    		return true;
    	}  		
    }
    public static boolean validateDate(String input) {
        // Tìm vị trí của dấu cách đầu tiên và dấu phẩy
        int firstSpaceIndex = input.indexOf(" ");
        int commaIndex = input.indexOf(",");

        // Kiểm tra xem vị trí của các dấu có hợp lệ không
        if (firstSpaceIndex == -1 || commaIndex == -1) {
            return false; // Định dạng không chính xác
        }

        // Cắt các giá trị "MMM", "d" và "y" ra khỏi chuỗi
        String month = input.substring(0, firstSpaceIndex);
        String day = input.substring(firstSpaceIndex + 1, commaIndex);
        String year = input.substring(commaIndex + 1);

        // Kiểm tra xem các giá trị "MMM", "d" và "y" có hợp lệ không
        if (!isValidMonth(month) || !isValidDay(day) || !isValidYear(year)) {
            return false; // Giá trị không hợp lệ
        }

        // Kiểm tra năm nhuận
        int dayInt = Integer.parseInt(day);
        int yearInt = Integer.parseInt(year);

        if (month.equals("Feb")) {
            if (isLeapYear(yearInt)) {
                return dayInt <= 29;
            } else {
                return dayInt <= 28;
            }
        } else if (month.equals("Apr") || month.equals("Jun") || month.equals("Sep") || month.equals("Nov")) {
            return dayInt <= 30;
        }

        return true; // Các tháng khác có tối đa 31 ngày
    }

    private static boolean isValidMonth(String month) {
        // Kiểm tra tháng có trong danh sách 12 tháng
        return month.equals("Jan") || month.equals("Feb") || month.equals("Mar") || month.equals("Apr") ||
                month.equals("May") || month.equals("Jun") || month.equals("Jul") || month.equals("Aug") ||
                month.equals("Sep") || month.equals("Oct") || month.equals("Nov") || month.equals("Dec");
    }

    private static boolean isValidDay(String day) {
        try {
            int dayInt = Integer.parseInt(day);
            return dayInt >= 1 && dayInt <= 31;
        } catch (NumberFormatException e) {
            return false; // Không thể chuyển đổi sang số nguyên
        }
    }

    private static boolean isValidYear(String year) {
        try {
            int yearInt = Integer.parseInt(year);
            return yearInt >= 0; // Kiểm tra năm không âm
        } catch (NumberFormatException e) {
            return false; // Không thể chuyển đổi sang số nguyên
        }
    }

    private static boolean isLeapYear(int year) {
        // Kiểm tra năm nhuận
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public void ValidateDate(String txt) {
    		String PATTERN = "\\b((Jan|Mar|May|Jul|Aug|Oct|Dec)\\s+(0?[1-9]|[12]\\d|3[01])"
    	               + "|(Feb)\\s+(0?[1-9]|[12]\\d)"
    	               + "|(Apr|Jun|Sep|Nov)\\s+(0?[1-9]|[12]\\d|30)"
    	               + "),((19|20)\\d\\d)\\b";
			Pattern patt = Pattern.compile(PATTERN);
			Matcher match = patt.matcher(txt);
			if(!match.matches() || (validateDate(txt) != true)) {
				themnv.lbRegexNgaySinh.setText("Vui lòng nhập đúng định dạng");
			}
			else {
				themnv.lbRegexNgaySinh.setText("");
			}
    	} 
}
