package GUI;

import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class test {
    public static void main(String[] args) {
    	JFrame j = new JFrame();
    	JPanel panel = new JPanel();
		panel.setBounds(379, 71, 240, 160);
		
        // Lấy thời gian hiện tại
        Calendar calendar = Calendar.getInstance();
        
        // Trích xuất ngày, tháng và năm
        int ngay = calendar.get(Calendar.DAY_OF_MONTH);
        int thang = calendar.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0 (tháng 0 là tháng 1)
        int nam = calendar.get(Calendar.YEAR);
        
        System.out.println("Ngày: " + ngay);
        System.out.println("Tháng: " + thang);
        System.out.println("Năm: " + nam);
        j.add(panel);
        j.show();
       
    }

	
	
}