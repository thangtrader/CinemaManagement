
package Business_Logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import ENTITY.TKPhim;
import Process_Data.DBHelper;
import Process_Data.ThongKePhimDAL;

public class ThongKePhimBLL extends DBHelper {
	private static ThongKePhimBLL instance;
	public GUI.panelTHONGKEPHIM GUITKPhim;
	ThongKePhimDAL tkpDAL;

	public static ThongKePhimBLL getInstance() {
		if (instance == null) {
			instance = new ThongKePhimBLL();
		}
		return instance;
	}

	public ThongKePhimBLL(GUI.panelTHONGKEPHIM p) {
		GUITKPhim = p;
		tkpDAL = ThongKePhimDAL.getInstance();
	}

	public ThongKePhimBLL() {

	}

	public int tinhDoanhThu(String dateIsEmpty,Boolean checkBox,int month,int year) {
		
		return tkpDAL.tinhDoanhThuDAL(dateIsEmpty, checkBox, month, year);
		
	}
	
	public Vector<ENTITY.TKPhim> LoadTKPhim(String date, Boolean log, int month, int year) {
		return tkpDAL.LoadTKPhim(date, log, month, year); 
	}

//	public int tinhDoanhThu() {
//		int month = 0;
//		int year = 0;
//		if (GUITKPhim.dateString != null) {
//			month = GUITKPhim.calendar.get(Calendar.MONTH) + 1;
//			year = GUITKPhim.calendar.get(Calendar.YEAR);
//		}
//		return tkpDAL.tinhDoanhThuDAL(GUITKPhim.dateString, GUITKPhim.checkBoxDoanhThu.isSelected(), month, year);
//
//	}
//	
//	public void LoadTKPhim() {
//		GUITKPhim.model = (DefaultTableModel) GUITKPhim.table.getModel();
//		for (int i = GUITKPhim.model.getRowCount() - 1; i >= 0; i--) {
//			GUITKPhim.model.removeRow(i);
//		}
//		Vector<ENTITY.TKPhim> vector = new Vector<ENTITY.TKPhim>();
//		int month = 0;
//		int year = 0;
//		if (GUITKPhim.dateString != null) {
//			month = GUITKPhim.calendar.get(Calendar.MONTH) + 1;
//			year = GUITKPhim.calendar.get(Calendar.YEAR);
//		}
//		vector = tkpDAL.LoadTKPhim(GUITKPhim.dateString, GUITKPhim.checkBoxDoanhThu.isSelected(), month, year);
//		for (ENTITY.TKPhim tkp : vector) {
//			GUITKPhim.model.addRow(new Object[] { tkp.getMaPhim(), tkp.getTenPhim(), tkp.getTheLoai(),
//					tkp.getSoLuongVe(), tkp.getDoanhThu() });
//		}
//	}

//	public void UpdateTongDoanhThuLabel() {
//		int tongDoanhThu = tinhDoanhThu();
//		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
//		format.setCurrency(Currency.getInstance("VND"));
//		String kq = format.format(tongDoanhThu);
//		GUITKPhim.lbDoanhThu.setText(kq);
//	}

}