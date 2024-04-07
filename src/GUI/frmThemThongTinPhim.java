package GUI;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Business_Logic.PhimBLL;
import Process_Data.PhimDAL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class frmThemThongTinPhim extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField txtFieldTenPhim;
	public JTextField txtFieldThoiLuong;
	public JTextField txtFieldQuocGia;
	public JTextField txtFieldDaoDien;
	public JTextField txtNamSanXuat;
	public JTextField txtDoTuoi;
	public JDateChooser calendar;
	public JComboBox cbboxTheLoai;
    PhimBLL phimBLL;
    PhimDAL phimDAL;
	private JButton btnSave;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThemThongTinPhim frame = new frmThemThongTinPhim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmThemThongTinPhim() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbMaPhim = new JLabel("Mã phim:");
		lbMaPhim.setBounds(45, 78, 58, 13);
		contentPane.add(lbMaPhim);
		
		JLabel lbTenPhim = new JLabel("Tên phim:");
		lbTenPhim.setBounds(45, 128, 45, 13);
		contentPane.add(lbTenPhim);
		
		JLabel lblNewLabel_2 = new JLabel("Thời lượng:");
		lblNewLabel_2.setBounds(45, 188, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel txtField = new JLabel("Quốc gia");
		txtField.setBounds(45, 243, 45, 13);
		contentPane.add(txtField);
		
		JLabel lblNewLabel_4 = new JLabel("Đạo diễn");
		lblNewLabel_4.setBounds(328, 78, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Năm sản xuất");
		lblNewLabel_5.setBounds(328, 128, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Độ tuổi");
		lblNewLabel_6.setBounds(328, 188, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Thể loại");
		lblNewLabel_7.setBounds(328, 243, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(113, 75, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtFieldTenPhim = new JTextField();
		txtFieldTenPhim.setBounds(113, 125, 96, 19);
		contentPane.add(txtFieldTenPhim);
		txtFieldTenPhim.setColumns(10);
		
		txtFieldThoiLuong = new JTextField();
		txtFieldThoiLuong.setBounds(113, 185, 96, 19);
		contentPane.add(txtFieldThoiLuong);
		txtFieldThoiLuong.setColumns(10);
		
		txtFieldQuocGia = new JTextField();
		txtFieldQuocGia.setBounds(113, 240, 96, 19);
		contentPane.add(txtFieldQuocGia);
		txtFieldQuocGia.setColumns(10);
		
		txtFieldDaoDien = new JTextField();
		txtFieldDaoDien.setBounds(405, 75, 96, 19);
		contentPane.add(txtFieldDaoDien);
		txtFieldDaoDien.setColumns(10);
		
		txtNamSanXuat = new JTextField();
		txtNamSanXuat.setBounds(405, 125, 74, 19);
		contentPane.add(txtNamSanXuat);
		txtNamSanXuat.setColumns(10);

		calendar = new JDateChooser();
		calendar.setToolTipText("");
		calendar.getCalendarButton().setToolTipText("");
		calendar.setBounds(478, 125, 23, 19);
		getContentPane().add(calendar);
		
		txtDoTuoi = new JTextField();
		txtDoTuoi.setBounds(405, 185, 96, 19);
		contentPane.add(txtDoTuoi);
		txtDoTuoi.setColumns(10);
		
		btnSave = new JButton("Lưu");
		btnSave.setBounds(113, 284, 85, 36);
		contentPane.add(btnSave);
		
		btnExit = new JButton("Đóng");
		btnExit.setBounds(405, 284, 85, 36);
		contentPane.add(btnExit);
		
		cbboxTheLoai = new JComboBox();
		cbboxTheLoai.setBounds(405, 239, 96, 21);
		contentPane.add(cbboxTheLoai);
		
		btnSave.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnSave) {
            int k = phimBLL.addDataFomr();
            if(k==1) {
            	JOptionPane.showMessageDialog(null, "Đã xóa thông tin phim thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
            	JOptionPane.showMessageDialog(null, "Xóa phim không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            phimBLL.LoadPhim();
        }
	}
}

