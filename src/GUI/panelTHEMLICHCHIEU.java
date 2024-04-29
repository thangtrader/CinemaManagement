package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Business_Logic.TaoLichChieuBLL;
import Process_Data.TaoLichChieuDAL;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class panelTHEMLICHCHIEU extends JPanel implements MouseListener,  ActionListener{

	private static final long serialVersionUID = 1L;
	public JTextField textFieldMaPhim;
	public JTextField textFieldPhongChieu;
	public JTextField textFieldTrangThai;
	public JTable tableDAPhim;
	public JTable tableDSPhognChieu;
	public JComboBox comboBoxKhungGioChieu;
	TaoLichChieuDAL TLCDAL;
	TaoLichChieuBLL TLCBLL;
	public DefaultTableModel model;
	int current = 0;
	public JButton btnLuu;
	public JButton btnHuy;
	public JDateChooser calendar;
	public JLabel lbRegexMaPhim;
	public JLabel lbRegexPhongChieu;
	public JLabel lbRegexNgayChieu;
	public JLabel lbRegexTrangThai;
	public JTextField textFieldNgayChieu;
	GUI.panelLICHCHIEU pnLC;

	/**
	 * Create the panel.
	 */
	public panelTHEMLICHCHIEU() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Danh sách phim");
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(75, 10, 150, 20);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Danh sách phòng chiếu");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(265, 10, 250, 20);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Khung giờ chiếu");
		lblNewLabel_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(555, 10, 136, 20);
		add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 40, 190, 146);
		add(scrollPane);

		tableDAPhim = new JTable();
		scrollPane.setViewportView(tableDAPhim);
		tableDAPhim.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"M\u00E3 phim","T\u00EAn phim"
			}
		));
		
		tableDAPhim.setFillsViewportHeight(true);
		tableDAPhim.setColumnSelectionAllowed(true);
		tableDAPhim.setCellSelectionEnabled(true);
		scrollPane.setViewportView(tableDAPhim);
	

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(251, 40, 190, 146);
		add(scrollPane_1);

		tableDSPhognChieu = new JTable();
//		scrollPane.setViewportView(tableDSPhognChieu);
		tableDSPhognChieu.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã phòng chiếu","Tên phòng chiếu"
				}
			));
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

		calendar = new JDateChooser();
		calendar.setToolTipText("");
		calendar.getCalendarButton().setToolTipText("");
		calendar.setBounds(0, 5, 100, 19);
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

		JLabel lblNewLabel_5 = new JLabel("Mã phim");
		lblNewLabel_5.setBounds(10, 10, 84, 16);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Phòng chiếu");
		lblNewLabel_6.setBounds(10, 54, 84, 16);
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Trạng thái");
		lblNewLabel_7.setBounds(10, 98, 102, 16);
		panel_1.add(lblNewLabel_7);

		textFieldMaPhim = new JTextField();
		textFieldMaPhim.setBounds(113, 7, 127, 19);
		panel_1.add(textFieldMaPhim);
		textFieldMaPhim.setColumns(10);

		textFieldPhongChieu = new JTextField();
		textFieldPhongChieu.setColumns(10);
		textFieldPhongChieu.setBounds(113, 51, 127, 19);
		panel_1.add(textFieldPhongChieu);

		textFieldTrangThai = new JTextField();
		textFieldTrangThai.setColumns(10);
		textFieldTrangThai.setBounds(113, 95, 127, 19);
		panel_1.add(textFieldTrangThai);
		

		btnLuu = new JButton("Lưu");
		btnLuu.setForeground(new Color(255, 235, 205));
		btnLuu.setBackground(new Color(32, 178, 170));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuu.setBounds(504, 309, 85, 30);
		this.add(btnLuu);

		btnHuy = new JButton("Hủy");
		btnHuy.setForeground(new Color(255, 235, 205));
		btnHuy.setBackground(new Color(205, 92, 92));
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHuy.setBounds(640, 309, 85, 30);
		this.add(btnHuy);

		JLabel lblNewLabel_8 = new JLabel("Khung giờ chiếu:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(497, 242, 120, 18);
		add(lblNewLabel_8);

		comboBoxKhungGioChieu = new JComboBox();
		comboBoxKhungGioChieu.setBounds(651, 242, 115, 23);
		add(comboBoxKhungGioChieu);
	    
	    lbRegexMaPhim = new JLabel("");
	    lbRegexMaPhim.setBounds(251, 286, 152, 19);
	    add(lbRegexMaPhim);
	    
	    lbRegexPhongChieu = new JLabel("");
	    lbRegexPhongChieu.setBounds(672, 286, 134, 13);
	    add(lbRegexPhongChieu);
	    
	    lbRegexNgayChieu = new JLabel("");
	    lbRegexNgayChieu.setBounds(261, 352, 142, 13);
	    add(lbRegexNgayChieu);
	    
	    lbRegexTrangThai = new JLabel("");
	    lbRegexTrangThai.setBounds(261, 352, 142, 13);
	    add(lbRegexTrangThai);
	    
	    
		tableDAPhim.addMouseListener(this);
		tableDSPhognChieu.addMouseListener(this);
		TLCDAL = new TaoLichChieuDAL(this);
		TLCBLL = new TaoLichChieuBLL(this);	
		btnLuu.addActionListener(this);
	}
		
	public void getRowDataPhim() {
	    int selectedRow = tableDAPhim.getSelectedRow();
	    if (selectedRow != -1 && selectedRow < tableDAPhim.getRowCount()) {
	        String maphim = tableDAPhim.getValueAt(selectedRow, 0).toString();

	        textFieldMaPhim.setText(maphim);
	    }
	}
	
	public void getRowDataPhongChieu() {
	    int selectedRow = tableDSPhognChieu.getSelectedRow();
	    if (selectedRow != -1 && selectedRow < tableDSPhognChieu.getRowCount()) {
	        String maphongchieu = tableDSPhognChieu.getValueAt(selectedRow, 0).toString();

	        textFieldPhongChieu.setText(maphongchieu);
	    }
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	    if (e.getSource() == tableDAPhim) {
	        if (tableDAPhim.getSelectedRow() >= 0) {
	            getRowDataPhim(); 
	        }
	    }
	    if (e.getSource() == tableDSPhognChieu) {
	        if (tableDSPhognChieu.getSelectedRow() >= 0) {
	            getRowDataPhongChieu();
	        }
	    }
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == btnLuu) {
			int result = TLCBLL.addDataLC();
			if (result == 1) { 
//				pnLC = new GUI.panelLICHCHIEU();
//				pnLC.LoadLichChieu();
//				System.out.println(pnLC);
			    JOptionPane.showMessageDialog(null, "Thêm lịch thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
			} else {
			                
			   JOptionPane.showMessageDialog(null, "không thêm lịch thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

			}
	    }
	}
}