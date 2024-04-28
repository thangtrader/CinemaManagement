package Business_Logic;

import java.util.Vector;
import javax.swing.JLabel;
import Process_Data.DBHelper;
import Process_Data.TKNhanVienDAL;

public class TKNhanVienBBL extends DBHelper {
	 private TKNhanVienDAL tkNhanVien;

	    public TKNhanVienBBL() {
	        this.tkNhanVien = new TKNhanVienDAL();
	    }

	    public Vector<ENTITY.TKNHANVIEN> LoadNhanVien() {
	    	return  tkNhanVien.ListNhanVien();
	    }	
	    public void UpdateTongLuongLabel(JLabel label) {
	        int tongLuong = tkNhanVien.TinhTongLuongNhanVien();
	        label.setText(String.valueOf(tongLuong));
	    }

	    public void UpdateTop5(JLabel[] labels) {
	        String top5 = tkNhanVien.Top5NhanVien();
	        String[] top5Array = top5.split("\n");

	        for (int i = 0; i < labels.length; i++) {
	            if (i < top5Array.length) {
	                labels[i].setText(top5Array[i]);
	            } else {
	                labels[i].setText("");
	            }
	        }
	    }

}