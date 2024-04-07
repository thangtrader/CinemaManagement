package Business_Logic;

import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class PhimBLL extends DBHelper {
    GUI.frmTHONGTINPHIM guiPhim;
    Process_Data.PhimDAL phimDAL; 
    
    public Vector<ENTITY.PHIM> ListPhim() {
        Vector<ENTITY.PHIM> vector = new Vector<ENTITY.PHIM>();
        try {
        	String sql = "Select * From PHIM";
        	PreparedStatement pre = cnn.prepareStatement(sql);
        	ResultSet rs = pre.executeQuery();
            while (rs.next()) {
            	ENTITY.PHIM phim = new ENTITY.PHIM();
            	phim.setMaPhim(rs.getString("MaPhim"));
            	phim.setTenPhim(rs.getString("TenPhim"));
            	phim.setThoiLuong(rs.getInt("ThoiLuong"));
            	phim.setQuocGia(rs.getString("QuocGia"));
            	phim.setDaoDien(rs.getString("DaoDien"));
            	phim.setNanSanXuat(rs.getDate("NamSanXuat"));
            	phim.setDoTuoiXem(rs.getInt("DoTuoiXem"));
            	phim.setMaTheLoai(rs.getString("MaTheLoai"));
            	
            	
                vector.addElement(phim);
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
        for (ENTITY.PHIM phim : phimDAL.ListPhim()) {
        	guiPhim.model.addRow(new Object[]{phim.getMaPhim(), phim.getTenPhim(), phim.getThoiLuong(), phim.getQuocGia(), phim.getDaoDien(), phim.getNanSanXuat(), phim.getDoTuoiXem(), phim.getMaTheLoai()});
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
    public void ValidateDate(String txt) {
    		String PATTERN = "\\b(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\s+\\d{1,2},\\d{4}\\b";
			Pattern patt = Pattern.compile(PATTERN);
			Matcher match = patt.matcher(txt);
			if(!match.matches()) {
				guiPhim.lbRegexNamSX.setText("Vui lòng nhập đúng định dạng");
			}
			else {
				guiPhim.lbRegexNamSX.setText("");
			}
    	}  	
    //Hàm trim() loại bỏ khoảng trống đầu cuối
    public int addData() {
    	Date namsanxuatDate = null;
    	String tenphim = guiPhim.textFieldTenPhim.getText().trim();
    	String thoiluong = guiPhim.textFieldThoiLuong.getText().trim();
    	String quocgia = guiPhim.textFieldQuocGia.getText().trim();
    	String daodien = guiPhim.textFieldDaoDien.getText().trim();
    	Date namsanxuat = guiPhim.calendar.getDate();
//    	try {
//    	   namsanxuatDate = dateFormat.parse(namsanxuat);
//    	   System.out.println(namsanxuatDate);
//    	} catch (ParseException e) {
//    	    e.printStackTrace();
//    	}
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
//    	Date namsanxuatDate;
    	String maphim = guiPhim.textFieldMaPhim.getText().trim();
    	String tenphim = guiPhim.textFieldTenPhim.getText().trim();
    	String thoiluong = guiPhim.textFieldThoiLuong.getText().trim();
    	String quocgia = guiPhim.textFieldQuocGia.getText().trim();
    	String daodien = guiPhim.textFieldDaoDien.getText().trim();
    	Date namsanxuat = guiPhim.calendar.getDate();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    	try {
//    	   namsanxuatDate = dateFormat.parse(namsanxuat);
//    	   System.out.println(namsanxuatDate);
//    	} catch (ParseException e) {
//    	    e.printStackTrace();
//    	}
    	String dotuoixem = guiPhim.textFieldDoTuoi.getText().trim();
    	String maloaiphim = ((ENTITY.THELOAIPHIM) guiPhim.comboBoxTheLoai.getSelectedItem()).getMaTheLoaiPhim();
//    	System.out.println(namsanxuatDate);
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
}
