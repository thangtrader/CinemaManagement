package GUI;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmThemThongTinPhim extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JTextField txtFieldMaPhim;
	public JTextField txtFieldTenPhim;
	public JTextField txtFieldThoiLuong;
	public JTextField txtFieldQuocGia;
	public JTextField txtFieldDaoDien;
	public JTextField txtFieldNamSanXuat;
	public JTextField txtFieldDoTuoi;
	public JDateChooser calendar;
	public JComboBox cbboxTheLoai;
    PhimBLL phimBLL;
    PhimDAL phimDAL;
	private JButton btnThem;
	private JButton btnDong;
	public JLabel lbRegexTuoi;
	public JLabel lbRegexNamSX;
	public JLabel lbRegexDaoDien;
	public JLabel lbRegexQuocGia;
	public JLabel lbRegexThoiLuong;
	public JLabel lbRegexTen;
	String maPhim;
	private JButton btnChinhSua;
	
	public frmThemThongTinPhim() {
		this.init();
		btnChinhSua.setVisible(false);
	}
	public frmThemThongTinPhim(String maPhim) {
		this.init();
		phimBLL.selectData(maPhim);
		btnThem.setVisible(false);
	}
	
	public void init() {
		this.setVisible(true);
		setBounds(100, 100, 616, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbMaPhim = new JLabel("Mã phim:");
		lbMaPhim.setBounds(45, 78, 58, 13);
		contentPane.add(lbMaPhim);
		
		JLabel lbTenPhim = new JLabel("Tên phim:");
		lbTenPhim.setBounds(45, 128, 71, 13);
		contentPane.add(lbTenPhim);
		
		JLabel lblNewLabel_2 = new JLabel("Thời lượng:");
		lblNewLabel_2.setBounds(45, 188, 71, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel txtField = new JLabel("Quốc gia");
		txtField.setBounds(45, 243, 45, 13);
		contentPane.add(txtField);
		
		JLabel lblNewLabel_4 = new JLabel("Đạo diễn");
		lblNewLabel_4.setBounds(308, 78, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Năm sản xuất");
		lblNewLabel_5.setBounds(308, 128, 87, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Độ tuổi");
		lblNewLabel_6.setBounds(308, 188, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Thể loại");
		lblNewLabel_7.setBounds(308, 243, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		txtFieldMaPhim = new JTextField();
		txtFieldMaPhim.setEditable(false);
		txtFieldMaPhim.setBounds(139, 75, 116, 19);
		contentPane.add(txtFieldMaPhim);
		txtFieldMaPhim.setColumns(10);
		
		txtFieldTenPhim = new JTextField();
		txtFieldTenPhim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^(?!\\s+$)[\\p{L}\\d\\s]{1,50}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txtFieldTenPhim.getText());
				if(!match.matches()) {
					lbRegexTen.setText("Vui lòng không nhập đúng định dạng");
				}
				else {
					lbRegexTen.setText("");
				}
			}
		});
		txtFieldTenPhim.setBounds(139, 125, 116, 19);
		contentPane.add(txtFieldTenPhim);
		txtFieldTenPhim.setColumns(10);
		
		txtFieldThoiLuong = new JTextField();
		txtFieldThoiLuong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[6-9][0-9]|[1-2][0-9]{2}|300$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txtFieldThoiLuong.getText());
				if(!match.matches()) {
					lbRegexThoiLuong.setText("Vui lòng không nhập đúng định dạng");
				}
				else {
					lbRegexThoiLuong.setText("");
				}
			}
		});
		txtFieldThoiLuong.setBounds(139, 185, 116, 19);
		contentPane.add(txtFieldThoiLuong);
		txtFieldThoiLuong.setColumns(10);
		
		txtFieldQuocGia = new JTextField();
		txtFieldQuocGia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^(?!\\s+$)[\\p{L}\\s]{1,20}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txtFieldQuocGia.getText());
				if(!match.matches()) {
					lbRegexQuocGia.setText("Vui lòng không nhập đúng định dạng");
				}
				else {
					lbRegexQuocGia.setText("");
				}
			}
		});
		txtFieldQuocGia.setBounds(139, 240, 116, 19);
		contentPane.add(txtFieldQuocGia);
		txtFieldQuocGia.setColumns(10);
		
		txtFieldDaoDien = new JTextField();
		txtFieldDaoDien.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^(?!\\s+$)[\\p{L}\\d\\s]{1,30}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txtFieldDaoDien.getText());
				if(!match.matches()) {
					lbRegexDaoDien.setText("Vui lòng không nhập đúng định dạng");
				}
				else {
					lbRegexDaoDien.setText("");
				}
			}
		});
		txtFieldDaoDien.setBounds(392, 75, 109, 19);
		contentPane.add(txtFieldDaoDien);
		txtFieldDaoDien.setColumns(10);
		
		txtFieldNamSanXuat = new JTextField();
		txtFieldNamSanXuat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				phimBLL.ValidateDate(txtFieldNamSanXuat.getText());
			}
		});
		txtFieldNamSanXuat.setBounds(392, 125, 87, 19);
		contentPane.add(txtFieldNamSanXuat);
		txtFieldNamSanXuat.setColumns(10);

		calendar = new JDateChooser();
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				String namsx;
				 if ("date".equals(evt.getPropertyName())) {
		                Date namsanxuat = ((Date) evt.getNewValue());
		                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
		                namsx = dateFormat.format(namsanxuat);
			            txtFieldNamSanXuat.setText(namsx);
			            phimBLL.ValidateDate(txtFieldNamSanXuat.getText());

				 }
			}
		});
		calendar.setToolTipText("");
		calendar.getCalendarButton().setToolTipText("");
		calendar.setBounds(478, 125, 23, 19);
		getContentPane().add(calendar);
		
		txtFieldDoTuoi = new JTextField();
		txtFieldDoTuoi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^(1[5-9]|[2-9][0-9]|100)$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txtFieldDoTuoi.getText());
				if(!match.matches()) {
					lbRegexTuoi.setText("Vui lòng không nhập đúng định dạng");
				}
				else {
					lbRegexTuoi.setText("");
				}
			}
		});
		txtFieldDoTuoi.setBounds(392, 185, 109, 19);
		contentPane.add(txtFieldDoTuoi);
		txtFieldDoTuoi.setColumns(10);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(88, 297, 85, 36);
		contentPane.add(btnThem);
		
		btnDong = new JButton("Đóng");
		btnDong.setBounds(437, 297, 85, 36);
		contentPane.add(btnDong);
		
		cbboxTheLoai = new JComboBox();
		cbboxTheLoai.setBounds(392, 239, 109, 21);
		contentPane.add(cbboxTheLoai);
		
		lbRegexTen = new JLabel("New label");
		lbRegexTen.setBounds(139, 154, 45, 13);
		contentPane.add(lbRegexTen);
		
		lbRegexThoiLuong = new JLabel("New label");
		lbRegexThoiLuong.setBounds(139, 214, 45, 13);
		contentPane.add(lbRegexThoiLuong);
		
		lbRegexQuocGia = new JLabel("New label");
		lbRegexQuocGia.setBounds(139, 269, 45, 13);
		contentPane.add(lbRegexQuocGia);
		
		lbRegexDaoDien = new JLabel("New label");
		lbRegexDaoDien.setBounds(392, 104, 45, 13);
		contentPane.add(lbRegexDaoDien);
		
		lbRegexNamSX = new JLabel("New label");
		lbRegexNamSX.setBounds(392, 154, 45, 13);
		contentPane.add(lbRegexNamSX);
		
		lbRegexTuoi = new JLabel("New label");
		lbRegexTuoi.setBounds(392, 214, 45, 13);
		contentPane.add(lbRegexTuoi);
		
		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setBounds(268, 297, 85, 36);
		contentPane.add(btnChinhSua);
		
        phimBLL = new Business_Logic.PhimBLL(this);
        phimDAL = new Process_Data.PhimDAL(this);
		btnThem.addActionListener(this);
		btnDong.addActionListener(this);
		btnChinhSua.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnThem){
    		if(phimBLL.ValidatedForm() == false || phimBLL.ValidatedRegex() == false) {
        		if(phimBLL.ValidatedForm() == false) {
        			JOptionPane.showMessageDialog(null, "Cần nhập đủ các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "Cần nhập đúng định các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		}
    		}
    		else {
    			int k = phimBLL.addData();
    			if(k==1) {
    				JOptionPane.showMessageDialog(null, "Đã thêm thông tin nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "Thêm thông tin không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    			}
    			this.dispose();
    		}
		}
		if(e.getSource() == btnChinhSua){
        	if(phimBLL.ValidatedForm() == false || phimBLL.ValidatedRegex() == false) {
        		if(phimBLL.ValidatedForm() == false) {
        			JOptionPane.showMessageDialog(null, "Cần nhập đủ các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "Cần nhập đúng định các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		}
    		}
        	else {
        			int k = phimBLL.updateData();
        			if(k==1) {
        				JOptionPane.showMessageDialog(null, "Đã sửa thông tin phim thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        			}
        			else {
        				JOptionPane.showMessageDialog(null, "Sửa phim không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        			}
        			this.dispose();
    		}
		}
		if(e.getSource() == btnDong){
            this.dispose();
		}
	}
}

