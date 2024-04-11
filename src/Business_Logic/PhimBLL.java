package Business_Logic;

import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ENTITY.PHIM;
import Process_Data.DBHelper;
import Process_Data.PhimDAL;
import Process_Data.TheLoaiPhimDAL;

public class PhimBLL extends DBHelper {
    GUI.frmTHONGTINPHIM guiPhim;
    GUI.frmThemThongTinPhim addPhim;
    Process_Data.PhimDAL phimDAL; 
    
    public Vector<ENTITY.PhimViewDTO> ListPhim() {
        Vector<ENTITY.PhimViewDTO> vector = new Vector<ENTITY.PhimViewDTO>();
        try {
        	String sql = "	SELECT p.MaPhim, p.TenPhim, p.ThoiLuong, p.QuocGia, p.NamSanXuat, p.DoTuoiXem, t.TenTheLoaiPhim, p.DaoDien FROM PHIM as p INNER JOIN THE_LOAI_PHIM as t ON p.MaTheLoai = t.MaTheLoaiPhim";
        	PreparedStatement pre = cnn.prepareStatement(sql);
        	ResultSet rs = pre.executeQuery();
            while (rs.next()) {
            	ENTITY.PhimViewDTO phimview = new ENTITY.PhimViewDTO();
            	phimview.setMaPhim(rs.getString("MaPhim"));
            	phimview.setTenPhim(rs.getString("TenPhim"));
            	phimview.setThoiLuong(rs.getInt("ThoiLuong"));
            	phimview.setQuocGia(rs.getString("QuocGia"));
            	phimview.setDaoDien(rs.getString("DaoDien"));
            	phimview.setNamSanXuat(rs.getDate("NamSanXuat"));
            	phimview.setDoTuoiXem(rs.getInt("DoTuoiXem"));
            	phimview.setTenTheLoai(rs.getString("TenTheLoaiPhim"));
            	
                vector.addElement(phimview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }
    public Vector<ENTITY.PHIM> TimKiemByMa(String maPhim){
        Vector<ENTITY.PHIM> vec = new Vector<ENTITY.PHIM>();
        try {

            String sql = "SELECT * FROM PHIM WHERE TenPhim LIKE ?";
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, "%" + maPhim + "%");
            ResultSet rs = pre.executeQuery();	
            while (rs.next()) {
            	PHIM phim = new PHIM();
            	phim.setMaPhim(rs.getString("MaPhim"));
            	phim.setTenPhim(rs.getString("TenPhim"));
            	phim.setThoiLuong(rs.getInt("ThoiLuong"));
            	phim.setQuocGia(rs.getString("QuocGia"));
            	phim.setDaoDien(rs.getString("DaoDien"));
            	phim.setNanSanXuat(rs.getDate("NamSanXuat"));
            	phim.setDoTuoiXem(rs.getInt("DoTuoiXem"));
            	phim.setMaTheLoai(rs.getString("MaTheLoai"));
                vec.add(phim);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    public PhimBLL(GUI.frmTHONGTINPHIM phim) {
    	guiPhim = phim;
    	phimDAL = new PhimDAL();
    	LoadTheLoai();
    	LoadPhim();
    }
    public PhimBLL() {

    }
//
    public void LoadTheLoai() {
        DefaultComboBoxModel<ENTITY.THELOAIPHIM> model = new DefaultComboBoxModel<ENTITY.THELOAIPHIM>(phimDAL.ListTheLoai());
        guiPhim.comboBoxTheLoai.setModel(model);
    }

    public void LoadPhim() {
    	guiPhim.model = (DefaultTableModel) guiPhim.table.getModel();
        for (int i = guiPhim.model.getRowCount() - 1; i >= 0; i--) {
        	guiPhim.model.removeRow(i);
        }
        for (ENTITY.PhimViewDTO phimview : phimDAL.ListPhim()) {
        	guiPhim.model.addRow(new Object[]{phimview.getMaPhim(), phimview.getTenPhim(), phimview.getThoiLuong(), phimview.getQuocGia(), phimview.getDaoDien(), phimview.getNamSanXuat(), phimview.getDoTuoiXem(), phimview.getTenTheLoai()});
        }
    }
    public boolean ValidatedForm() {
    	if(guiPhim.textFieldTenPhim.getText().isEmpty() || guiPhim.textFieldThoiLuong.getText().isEmpty() || guiPhim.textFieldQuocGia.getText().isEmpty() || guiPhim.textFieldDaoDien.getText().isEmpty() || guiPhim.textFieldNamSanXuat.getText().isEmpty() ||guiPhim.textFieldDoTuoi.getText().isEmpty()) {
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
				guiPhim.lbRegexNamSX.setText("Vui lòng nhập đúng định dạng");
			}
			else {
				guiPhim.lbRegexNamSX.setText("");
			}
    	}  	
    public int addData() {
    	String tenphim = guiPhim.textFieldTenPhim.getText().trim();
    	String thoiluong = guiPhim.textFieldThoiLuong.getText().trim();
    	String quocgia = guiPhim.textFieldQuocGia.getText().trim();
    	String daodien = guiPhim.textFieldDaoDien.getText().trim();
    	Date namsanxuat = guiPhim.calendar.getDate();
    	String dotuoixem = guiPhim.textFieldDoTuoi.getText().trim();
    	String maloaiphim = ((ENTITY.THELOAIPHIM) guiPhim.comboBoxTheLoai.getSelectedItem()).getMaTheLoaiPhim();
    	Object[] param = new Object[] {tenphim, thoiluong, quocgia, namsanxuat, dotuoixem, maloaiphim, daodien};
    	return phimDAL.addData(param);
    }
    public int removeData() {
    	String maphim = guiPhim.textFieldMaPhim.getText().trim();
    	Object[] param = new Object[] {maphim};
    	return phimDAL.removeData(param);
    }
    public int updateData() {
    	String maphim = guiPhim.textFieldMaPhim.getText().trim();
    	String tenphim = guiPhim.textFieldTenPhim.getText().trim();
    	String thoiluong = guiPhim.textFieldThoiLuong.getText().trim();
    	String quocgia = guiPhim.textFieldQuocGia.getText().trim();
    	String daodien = guiPhim.textFieldDaoDien.getText().trim();
    	Date namsanxuat = guiPhim.calendar.getDate();
    	String dotuoixem = guiPhim.textFieldDoTuoi.getText().trim();
    	String maloaiphim = ((ENTITY.THELOAIPHIM) guiPhim.comboBoxTheLoai.getSelectedItem()).getMaTheLoaiPhim();
    	Object[] param = new Object[] {maphim,tenphim, thoiluong, quocgia, namsanxuat, dotuoixem, maloaiphim, daodien};
    	return phimDAL.updateData(param);	
    }
    public void ClearData() {
    	guiPhim.textFieldMaPhim.setText("");
    	guiPhim.textFieldTenPhim.setText("");
    	guiPhim.textFieldThoiLuong.setText("");
    	guiPhim.textFieldQuocGia.setText("");
    	guiPhim.textFieldDaoDien.setText("");
    	guiPhim.textFieldNamSanXuat.setText("");
    	guiPhim.textFieldDoTuoi.setText("");
    }
    public boolean ValidatedRegex() {
    	if(!guiPhim.lbRegexTen.getText().isEmpty() || !guiPhim.lbRegexThoiLuong.getText().isEmpty() || !guiPhim.lbRegexQuocGia.getText().isEmpty() || !guiPhim.lbRegexDaoDien.getText().isEmpty() || !guiPhim.lbRegexNamSX.getText().isEmpty() ||!guiPhim.lbRegexTuoi.getText().isEmpty()) {
    		return false;
    	}
    	else {
    		return true;
    	}  		
    }
    public void ClearRegex() {

    	guiPhim.lbRegexTen.setText("");
    	guiPhim.lbRegexThoiLuong.setText("");
    	guiPhim.lbRegexQuocGia.setText("");
    	guiPhim.lbRegexDaoDien.setText("");
    	guiPhim.lbRegexNamSX.setText("");
    	guiPhim.lbRegexTuoi.setText("");
    }
    public int addDataFomr() {
    	String tenphim = addPhim.txtFieldTenPhim.getText().trim();
    	String thoiluong = addPhim.txtFieldThoiLuong.getText().trim();
    	String quocgia = addPhim.txtFieldQuocGia.getText().trim();
    	String daodien = addPhim.txtFieldDaoDien.getText().trim();
    	Date namsanxuat = addPhim.calendar.getDate();
    	String dotuoixem = addPhim.txtDoTuoi.getText().trim();
    	String maloaiphim = ((ENTITY.THELOAIPHIM) addPhim.cbboxTheLoai.getSelectedItem()).getMaTheLoaiPhim();
    	Object[] param = new Object[] {tenphim, thoiluong, quocgia, namsanxuat, dotuoixem, maloaiphim, daodien};
    	return phimDAL.addData(param);
    }
}
