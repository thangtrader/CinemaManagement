package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Business_Logic.NhanVienBLL;
import Process_Data.NhanVienDAL;
import quanlyrapphim.frmQuanLyPhim;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;

public class dialogThemNhanVien extends JDialog implements ActionListener {

	private JPanel contentPane;
	public JTextField txtMaNV;
	public JTextField txtTenNV;
	public JTextField txtDiaChi;
	public JTextField txtSDT;
	public JTextField txtCCCD;
	public JTextField txtTK;
	public JTextField txtMK;
	public JComboBox cbboxChinhSach;
	public JComboBox cbboxChucVu;
	public JButton btnThem;
	public JButton btnDong;
	NhanVienBLL nvBLL;
	NhanVienDAL nvDAL;
	GUI.frmNHANVIEN nv;
	frmQuanLyPhim qlp;
	public JDateChooser calendar;
	public JTextField txtNgaySinh;
	public JRadioButton rbtnNam;
	public JRadioButton rbtnNu;

	String maNhanVienn;
	ENTITY.NHANVIEN nhanVien = new ENTITY.NHANVIEN();
	private JButton btnChinhSua;
	private boolean isEditMode = false;
	public JLabel lbRegexTen;
	public JLabel lbRegexNgaySinh;
	public JLabel lbRegexDiaChi;
	public JLabel lbRegexSDT;
	public JLabel lbRegexCCCD;
	public JRadioButton rbtn0;
	public JRadioButton rbtn1;

	public void init() {
		setBounds(100, 100, 625, 447);
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Nhân viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(50, 37, 78, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(50, 85, 78, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày sinh:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(50, 136, 66, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(50, 183, 66, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Địa chỉ:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(50, 232, 66, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Số điện thoại:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(50, 290, 78, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Số CCCD:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(335, 37, 66, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tên tài khoản:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(335, 85, 84, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Mật khẩu:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(335, 136, 66, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Chính sách");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(335, 183, 84, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Chức vụ: ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(335, 232, 84, 13);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Trạng thái: ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(335, 290, 66, 13);
		contentPane.add(lblNewLabel_11);
		
		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setBounds(151, 34, 142, 19);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtTenNV = new JTextField();
		txtTenNV.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[^\\s][\\p{L}\\s]{0,29}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txtTenNV.getText());
				if(!match.matches()) {
				    lbRegexTen.setText("Vui lòng chỉ nhập chữ");
				}
				else {
				    lbRegexTen.setText("");
				}
			}
		});
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(151, 82, 142, 19);
		contentPane.add(txtTenNV);
		
		calendar = new JDateChooser();
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				String ngaysinh;
				 if ("date".equals(evt.getPropertyName())) {
		                Date ns = ((Date) evt.getNewValue());
		                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
		                ngaysinh = dateFormat.format(ns);
			            txtNgaySinh.setText(ngaysinh);
			            nvBLL.ValidateDate(txtNgaySinh.getText());

		         }
			}
		});
		calendar.setToolTipText("");
		calendar.getCalendarButton().setToolTipText("");
//		calendar.setColumns(10);
		calendar.setBounds(271, 133, 22, 19);
		getContentPane().add(calendar);
		
		txtDiaChi = new JTextField();
		txtDiaChi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^(?!\\s+$)[\\p{L}\\d\\s]{1,50}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txtDiaChi.getText());
				if(!match.matches()) {
					lbRegexDiaChi.setText("Vui lòng không nhập đúng định dạng");
				}
				else {
					lbRegexDiaChi.setText("");
				}
			}
		});
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(151, 232, 142, 19);
		contentPane.add(txtDiaChi);
		
		txtSDT = new JTextField();
		txtSDT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "\\d{10}";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txtSDT.getText());
				if(!match.matches()) {
					lbRegexSDT.setText("Vui lòng không nhập đúng định dạng số điện thoại");
				}
				else {
					lbRegexSDT.setText("");
				}
			}
		});
		txtSDT.setColumns(10);
		txtSDT.setBounds(151, 288, 142, 19);
		contentPane.add(txtSDT);
		
		txtCCCD = new JTextField();
		txtCCCD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "\\d{1,20}";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(txtCCCD.getText());
				if(!match.matches()) {
					lbRegexCCCD.setText("Vui lòng nhập đúng định dạng");
				}
				else {
					lbRegexCCCD.setText("");
				}
			}
		});
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(429, 34, 142, 19);
		contentPane.add(txtCCCD);
		
		txtTK = new JTextField();
		txtTK.setColumns(10);
		txtTK.setBounds(429, 82, 142, 19);
		contentPane.add(txtTK);
		
		txtMK = new JTextField();
		txtMK.setColumns(10);
		txtMK.setBounds(429, 133, 142, 19);
		contentPane.add(txtMK);
		
		cbboxChinhSach = new JComboBox();
		cbboxChinhSach.setBounds(429, 180, 142, 21);
		contentPane.add(cbboxChinhSach);
		
		cbboxChucVu = new JComboBox();
		cbboxChucVu.setBounds(429, 229, 142, 21);
		contentPane.add(cbboxChucVu);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(132, 359, 85, 21);
		contentPane.add(btnThem);
		
		btnDong = new JButton("Đóng");
		btnDong.setBounds(271, 359, 85, 21);
		contentPane.add(btnDong);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nvBLL.ValidateDate(txtNgaySinh.getText());
			}
		});
		txtNgaySinh.setBounds(151, 133, 122, 19);
		contentPane.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		rbtnNam = new JRadioButton("Nam");
		rbtnNam.setSelected(true);
		rbtnNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtnNam.isSelected() == true) {
					rbtnNu.setSelected(false);
				}
			}
		});
		rbtnNam.setBounds(151, 180, 59, 21);
		contentPane.add(rbtnNam);
		
		rbtnNu = new JRadioButton("Nữ");
		rbtnNu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtnNu.isSelected() == true) {
					rbtnNam.setSelected(false);
				}
			}
		});
		rbtnNu.setBounds(227, 180, 66, 21);
		contentPane.add(rbtnNu);
		
		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setBounds(429, 359, 103, 21);
		contentPane.add(btnChinhSua);
		
		lbRegexTen = new JLabel("");
		lbRegexTen.setBounds(151, 111, 142, 13);
		contentPane.add(lbRegexTen);
		
		lbRegexNgaySinh = new JLabel("");
		lbRegexNgaySinh.setBounds(151, 162, 142, 13);
		contentPane.add(lbRegexNgaySinh);
		
		lbRegexDiaChi = new JLabel("");
		lbRegexDiaChi.setBounds(151, 265, 142, 13);
		contentPane.add(lbRegexDiaChi);
		
		lbRegexSDT = new JLabel("");
		lbRegexSDT.setBounds(151, 317, 142, 13);
		contentPane.add(lbRegexSDT);
		
		lbRegexCCCD = new JLabel("");
		lbRegexCCCD.setBounds(429, 63, 142, 13);
		contentPane.add(lbRegexCCCD);
		
		rbtn0 = new JRadioButton("0");
		rbtn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtn0.isSelected() == true) {
					rbtn1.setSelected(false);
				}
			}
		});
		rbtn0.setBounds(520, 287, 51, 21);
		contentPane.add(rbtn0);
		
		rbtn1 = new JRadioButton("1");
		rbtn1.setSelected(true);
		rbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtn1.isSelected() == true) {
					rbtn0.setSelected(false);
				}
			}
		});
		rbtn1.setBounds(429, 287, 66, 21);
		contentPane.add(rbtn1);
		
        nvBLL = new Business_Logic.NhanVienBLL(this);
        nvDAL = new Process_Data.NhanVienDAL(this);
        btnThem.addActionListener(this);
        btnDong.addActionListener(this);
        btnChinhSua.addActionListener(this);
        
	}

	public dialogThemNhanVien() {
		this.init();
		btnChinhSua.setVisible(false);
	}
	public dialogThemNhanVien(String maNV) {
		this.init();
        nvBLL.selectData(maNV);
        btnThem.setVisible(false);
		txtTenNV.setEditable(false);
		calendar.setEnabled(false);
		txtNgaySinh.setEditable(false);
		rbtnNam.setEnabled(false);
		rbtnNu.setEnabled(false);
		txtSDT.setEditable(false);
		txtDiaChi.setEditable(false);
		txtCCCD.setEditable(false);
		rbtn1.setEnabled(false);
		rbtn0.setEnabled(false);
		txtTK.setEditable(false);
		txtMK.setEditable(false);
		cbboxChinhSach.enable(false);
		cbboxChucVu.enable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnThem){
    		if(nvBLL.ValidatedForm() == false || nvBLL.ValidatedRegex() == false) {
        		if(nvBLL.ValidatedForm() == false) {
        			JOptionPane.showMessageDialog(null, "Cần nhập đủ các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "Cần nhập đúng định các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		}
    		}
    		else {
    			int k = nvBLL.addData();
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
		    if (!isEditMode) {
		        // Đang không ở chế độ chỉnh sửa, bật chế độ chỉnh sửa
		        btnThem.setVisible(true);
		        txtTenNV.setEditable(true);
		        calendar.setEnabled(true);
		        txtNgaySinh.setEditable(true);
		        rbtnNam.setEnabled(true);
		        rbtnNu.setEnabled(true);
		        txtSDT.setEditable(true);
		        txtDiaChi.setEditable(true);
		        txtCCCD.setEditable(true);
				rbtn1.setEnabled(true);
				rbtn0.setEnabled(true);
		        txtTK.setEditable(true);
		        txtMK.setEditable(true);
		        cbboxChinhSach.setEnabled(true);
		        cbboxChucVu.setEnabled(true);
		        isEditMode = true;
		        btnThem.setVisible(false);
		    } else {
		        // Đang ở chế độ chỉnh sửa, thực hiện cập nhật dữ liệu
		        int k = nvBLL.updateData();
		        if (k == 1) {
		            JOptionPane.showMessageDialog(null, "Đã chỉnh sửa thông tin nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            JOptionPane.showMessageDialog(null, "Chỉnh sửa thông tin không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        }
		        // Tắt chế độ chỉnh sửa và đóng form
		        isEditMode = false;
		        this.dispose();
		    }
		}
		if(e.getSource() == btnDong){
            this.dispose();
		}
	}
}
