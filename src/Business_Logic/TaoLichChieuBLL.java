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
import GUI.panelTHEMLICHCHIEU;
import Process_Data.DBHelper;
import Process_Data.PhimDAL;
import Process_Data.TaoLichChieuDAL;

public class TaoLichChieuBLL extends DBHelper{
	GUI.panelTHEMLICHCHIEU themLC;
    Process_Data.TaoLichChieuDAL taoLCDAL;  
   
    
    public TaoLichChieuBLL(GUI.panelTHEMLICHCHIEU LCphim) {
    	themLC = LCphim;
    	taoLCDAL = new TaoLichChieuDAL();
    	LoadKhungGioChieu();
    	LoadTLC();
    	LoadDSPC();
    }
    
    public void LoadTLC() {
    	taoLCDAL = new TaoLichChieuDAL();
        themLC.model = (DefaultTableModel) themLC.tableDAPhim.getModel();
        for (int i = themLC.model.getRowCount() - 1; i >= 0; i--) {
        	themLC.model.removeRow(i);
        }
        for (ENTITY.PHIM tklc : taoLCDAL.ListLCPhim() )                                                                 {
            themLC.model.addRow(new Object[]{tklc.getMaPhim(), tklc.getTenPhim()});
        }
    }
   
    public void LoadDSPC() {
    	taoLCDAL = new TaoLichChieuDAL();
    	themLC.model = (DefaultTableModel) themLC.tableDSPhognChieu.getModel();
        for (int i = themLC.model.getRowCount() - 1; i >= 0; i--) {
        	themLC.model.removeRow(i);
        }
        for (ENTITY.PHONGCHIEU dspc : taoLCDAL.ListDSPC()) {
        	themLC.model.addRow(new Object[] { dspc.getMaPhongChieu(), dspc.getTenPhong() });
        }
    }
    public void LoadKhungGioChieu() {
        DefaultComboBoxModel<ENTITY.KHUNGGIOCHIEU> model = new DefaultComboBoxModel<ENTITY.KHUNGGIOCHIEU>(taoLCDAL.ListKhungGioChieu());
        themLC.comboBoxKhungGioChieu.setModel(model);
    }
    public boolean ValidatedForm() {
    	if(themLC.textFieldMaPhim.getText().isEmpty() || themLC.textFieldPhongChieu.getText().isEmpty() || themLC.textFieldTrangThai.getText().isEmpty()) {
    		return false;
    	}
    	else {
    		return true;
    	}  		
    }
    public void ClearData() {
    	themLC.textFieldMaPhim.setText("");
    	themLC.textFieldPhongChieu.setText("");
    	themLC.comboBoxKhungGioChieu.setToolTipText("");
    	themLC.textFieldNgayChieu.setText("");
    	themLC.textFieldTrangThai.setText("");
    }
    public int addDataLC() {
    	String MaPhim = themLC.textFieldMaPhim.getText().trim();
    	String PhongChieu = themLC.textFieldPhongChieu.getText().trim();
    	Date NgayChieu = themLC.calendar.getDate();
    	String TrangThai = themLC.textFieldTrangThai.getText().trim();
    	String makhunggiochieu = ((ENTITY.KHUNGGIOCHIEU) themLC.comboBoxKhungGioChieu.getSelectedItem()).getMaKhungGioChieu();
    	Object[] param = new Object[] {MaPhim,PhongChieu,makhunggiochieu,NgayChieu,TrangThai};
    	return taoLCDAL.addData(param);
    }
}