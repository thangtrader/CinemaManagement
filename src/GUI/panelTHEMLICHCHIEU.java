package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class panelTHEMLICHCHIEU extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldTenPhim;
	private JTextField textFieldPhongChieu;
	private JTextField textFieldNgayGioChieu;
	private JTable tableDAPhim;
	private JTable tableDSPhognChieu;

	/**
	 * Create the panel.
	 */
	public panelTHEMLICHCHIEU() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Danh sách phim");
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(62, 10, 136, 20);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Danh sách phòng chiếu");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(251, 10, 185, 20);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Khung giờ chiếu");
		lblNewLabel_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(555, 10, 136, 20);
		add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 40, 165, 146);
		add(scrollPane);

		tableDAPhim = new JTable();
		tableDAPhim.setFillsViewportHeight(true);
		tableDAPhim.setColumnSelectionAllowed(true);
		tableDAPhim.setCellSelectionEnabled(true);
		scrollPane.setRowHeaderView(tableDAPhim);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(251, 40, 165, 146);
		add(scrollPane_1);

		tableDSPhognChieu = new JTable();
		tableDSPhognChieu.setCellSelectionEnabled(true);
		tableDSPhognChieu.setFillsViewportHeight(true);
		tableDSPhognChieu.setColumnSelectionAllowed(true);
		scrollPane_1.setViewportView(tableDSPhognChieu);

		JLabel lblNewLabel_3 = new JLabel("Ngày chiếu");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(517, 37, 72, 20);
		add(lblNewLabel_3);

		JPanel panel = new JPanel();
		panel.setBounds(497, 67, 262, 146);
		add(panel);
		panel.setLayout(null);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(0, 5, 261, 143);
		panel.add(calendar);  

		JLabel lblNewLabel_4 = new JLabel("Lịch chiếu");
		lblNewLabel_4.setForeground(new Color(0, 139, 139));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(44, 196, 72, 20);
		add(lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(34, 226, 392, 132);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Tên phim");
		lblNewLabel_5.setBounds(10, 10, 84, 16);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Phòng chiếu");
		lblNewLabel_6.setBounds(10, 54, 84, 16);
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Ngày giờ chiếu");
		lblNewLabel_7.setBounds(10, 98, 102, 16);
		panel_1.add(lblNewLabel_7);

		textFieldTenPhim = new JTextField();
		textFieldTenPhim.setBounds(113, 7, 127, 19);
		panel_1.add(textFieldTenPhim);
		textFieldTenPhim.setColumns(10);

		textFieldPhongChieu = new JTextField();
		textFieldPhongChieu.setColumns(10);
		textFieldPhongChieu.setBounds(113, 51, 127, 19);
		panel_1.add(textFieldPhongChieu);

		textFieldNgayGioChieu = new JTextField();
		textFieldNgayGioChieu.setColumns(10);
		textFieldNgayGioChieu.setBounds(113, 95, 127, 19);
		panel_1.add(textFieldNgayGioChieu);
		
//		Calendar c = calendar.getCalendar();
//		int ngay = c.get(Calendar.DAY_OF_MONTH);
//		int thang = c.get(Calendar.MONTH);
//		int nam = c.get(Calendar.YEAR);
//		System.out.println(ngay + " "+thang + " "+nam);
//		textFieldNgayGioChieu.setText(ngay + "/"+thang + "/"+nam);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.setForeground(new Color(255, 235, 205));
		btnLuu.setBackground(new Color(32, 178, 170));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuu.setBounds(504, 309, 85, 30);
		add(btnLuu);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.setForeground(new Color(255, 235, 205));
		btnHuy.setBackground(new Color(205, 92, 92));
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHuy.setBounds(640, 309, 85, 30);
		add(btnHuy);

		JLabel lblNewLabel_8 = new JLabel("Khung giờ chiếu:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(497, 242, 120, 18);
		add(lblNewLabel_8);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(651, 242, 108, 21);
		add(comboBox);

	}
}
