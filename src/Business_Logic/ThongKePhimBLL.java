
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

}