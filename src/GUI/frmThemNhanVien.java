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

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class frmThemNhanVien extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtCCCD;
	private JTextField txtTK;
	private JTextField txtMK;
	private JComboBox cbboxChinhSach;
	private JComboBox cbboxChucVu;
	private JButton btnThem;
	private JButton btnDong;
	private NhanVienBLL nvBLL;
	GUI.frmNHANVIEN nv;
	private JDateChooser calendar;
	private JTextField txtNgaySinh;
	private JRadioButton rbtnNam;
	private JRadioButton rbtnNu;

	String maNhanVienn;
	ENTITY.NHANVIEN nhanVien = new ENTITY.NHANVIEN();
	private JButton btnChinhSua;
	private boolean isEditMode = false;
	private JLabel lbRegexTen;
	private JLabel lbRegexNgaySinh;
	private JLabel lbRegexDiaChi;
	private JLabel lbRegexSDT;
	private JLabel lbRegexCCCD;
	private JRadioButton rbtn0;
	private JRadioButton rbtn1;

	public void init() {
		setBounds(100, 100, 625, 447);
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(253, 243, 225));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblNewLabel = new JLabel("Mã Nhân viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(35, 37, 90, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(35, 85, 110, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày sinh:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(35, 136, 66, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(35, 183, 66, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Địa chỉ:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(35, 232, 66, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Số điện thoại:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(35, 290, 110, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Số CCCD:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(335, 37, 66, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tên tài khoản:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(335, 85, 100, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Mật khẩu:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(335, 136, 66, 16);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Chính sách");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(335, 183, 84, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Chức vụ: ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setBounds(335, 232, 84, 16);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Trạng thái: ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(335, 290, 70, 16);
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
			            ValidateDate(txtNgaySinh.getText());

		         }
			}
		});
		calendar.setToolTipText("");
		calendar.getCalendarButton().setToolTipText("");
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
		btnThem.setForeground(new Color(255, 235, 205));
		btnThem.setBackground(new Color(255, 165, 0));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setIcon(new ImageIcon(getClass().getResource("/image/them.png")));
		btnThem.setBounds(132, 359, 120, 28);
		contentPane.add(btnThem);
		
		btnDong = new JButton("Đóng");
		btnDong.setForeground(new Color(255, 235, 205));
		btnDong.setIcon(new ImageIcon(getClass().getResource("/image/x.png")));
		btnDong.setBackground(new Color(255, 147, 150));
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDong.setBounds(271, 359, 85, 28);
		contentPane.add(btnDong);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ValidateDate(txtNgaySinh.getText());
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
		btnChinhSua.setForeground(new Color(255, 235, 205));
		btnChinhSua.setBackground(new Color(255, 165, 0));
		btnChinhSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChinhSua.setIcon(new ImageIcon(getClass().getResource("/image/sua.png.png")));
		btnChinhSua.setBounds(429, 359, 130, 28);
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
		
        nvBLL = new Business_Logic.NhanVienBLL();
        btnThem.addActionListener(this);
        btnDong.addActionListener(this);
        btnChinhSua.addActionListener(this);
        
	}
	public int addData() {
    	ENTITY.NhanVienViewDTO nvviewDTO = new ENTITY.NhanVienViewDTO();
    	String tennv = txtTenNV.getText().trim();
    	Date ngaysinh = calendar.getDate();
    	String gioitinh;
    	if(rbtnNam.isSelected() == true) {
    		gioitinh = rbtnNam.getText();
    	}
    	else {
    		gioitinh = rbtnNu.getText();
    	}
    	String diachi = txtDiaChi.getText().trim();
    	String sdt = txtSDT.getText().trim();
    	String cccd = txtCCCD.getText().trim();
    	String tk = txtTK.getText().trim();
    	String mk = txtMK.getText().trim();
    	String machinhsach = ((ENTITY.CHINHSACH) cbboxChinhSach.getSelectedItem()).getMaChinhSach();
    	String machucvu = ((ENTITY.CHUCVU) cbboxChucVu.getSelectedItem()).getMaChucVu();
    	String trangthai;
    	if(rbtn1.isSelected() == true) {
    		trangthai = rbtn1.getText();
    	}
    	else {
    		trangthai = rbtn0.getText();
    	}
    	nvviewDTO.setTenNhanVien(tennv);
    	nvviewDTO.setNgaySinh(ngaysinh);
    	nvviewDTO.setGioiTinh(gioitinh);
    	nvviewDTO.setDiaChi(diachi);
    	nvviewDTO.setSdt(sdt);
    	nvviewDTO.setCccd(cccd);
    	nvviewDTO.setTenTaiKhoan(tk);
    	nvviewDTO.setMatKhau(mk);
    	nvviewDTO.setTenChinhSach(machinhsach);
    	nvviewDTO.setTenChucVu(machucvu);
    	nvviewDTO.setTrangThai(trangthai);
    	return nvBLL.addData(nvviewDTO);
	}
	
	public int updateData() {
    	ENTITY.NhanVienViewDTO nvviewDTO = new ENTITY.NhanVienViewDTO();
    	String manv = txtMaNV.getText();
    	String tennv = txtTenNV.getText().trim();
    	String ngaysinh = txtNgaySinh.getText();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
      
    	Date ngaySanXuat = null;
    	try {
          ngaySanXuat = dateFormat.parse(ngaysinh);
    	} catch (ParseException e) {
          e.printStackTrace();
    	}
    	calendar.setDate(ngaySanXuat);
    	calendar.setToolTipText(ngaysinh);
    	String gioitinh;
    	if(rbtnNam.isSelected() == true) {
    		gioitinh = rbtnNam.getText();
    	}
    	else {
    		gioitinh = rbtnNu.getText();
    	}
    	String diachi = txtDiaChi.getText().trim();
    	String sdt = txtSDT.getText().trim();
    	String cccd = txtCCCD.getText().trim();
    	String tk = txtTK.getText().trim();
    	String mk = txtMK.getText().trim();
    	String machinhsach = ((ENTITY.CHINHSACH) cbboxChinhSach.getSelectedItem()).getMaChinhSach();
    	String machucvu = ((ENTITY.CHUCVU) cbboxChucVu.getSelectedItem()).getMaChucVu();
    	String trangthai;
    	if(rbtn1.isSelected() == true) {
    		trangthai = rbtn1.getText();
    	}
    	else {
    		trangthai = rbtn0.getText();
    	}
    	nvviewDTO.setMaNhanVien(manv);
    	nvviewDTO.setTenNhanVien(tennv);
    	nvviewDTO.setNgaySinh(ngaySanXuat);
    	nvviewDTO.setGioiTinh(gioitinh);
    	nvviewDTO.setDiaChi(diachi);
    	nvviewDTO.setSdt(sdt);
    	nvviewDTO.setCccd(cccd);
    	nvviewDTO.setTenTaiKhoan(tk);
    	nvviewDTO.setMatKhau(mk);
    	nvviewDTO.setTenChinhSach(machinhsach);
    	nvviewDTO.setTenChucVu(machucvu);
    	nvviewDTO.setTrangThai(trangthai);
    	return nvBLL.updateData(nvviewDTO);
	}
	public void SelectData(String manhanvien) {
		maNhanVienn = manhanvien;
		ENTITY.NhanVienViewDTO nvviewDTO = new ENTITY.NhanVienViewDTO();
		nvviewDTO = nvBLL.selectData(maNhanVienn);
    	txtMaNV.setText(nvviewDTO.getMaNhanVien());
    	txtTenNV.setText(nvviewDTO.getTenNhanVien());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
        Date ngaySinh = nvviewDTO.getNgaySinh();		
        String ngaySinhString = dateFormat.format(ngaySinh);
        txtNgaySinh.setText(ngaySinhString);
        
    	if (nvviewDTO.getGioiTinh().equalsIgnoreCase("Nam")) {
    	    rbtnNam.setSelected(true);
    	    rbtnNu.setSelected(false);
    	} else {
    	    rbtnNu.setSelected(true);
    	    rbtnNam.setSelected(false);
    	}
    	
    	txtDiaChi.setText(nvviewDTO.getDiaChi());
    	txtSDT.setText(nvviewDTO.getSdt());
    	txtCCCD.setText(nvviewDTO.getCccd());
    	txtTK.setText(nvviewDTO.getTenTaiKhoan());
    	txtMK.setText(nvviewDTO.getMatKhau());
    	
        for(int i = 0; i< cbboxChinhSach.getItemCount(); i++) {
        	if(cbboxChinhSach.getItemAt(i).toString().equalsIgnoreCase(nvviewDTO.getTenChinhSach())) {
        		cbboxChinhSach.setSelectedIndex(i);
        	}
        }
        
        for(int i = 0; i< cbboxChucVu.getItemCount(); i++) {
        	if(cbboxChucVu.getItemAt(i).toString().equalsIgnoreCase(nvviewDTO.getTenChucVu())) {
        		cbboxChucVu.setSelectedIndex(i);
        	}
        }
    	if (nvviewDTO.getTrangThai().equalsIgnoreCase("1")) {
    	    rbtn1.setSelected(true);
    	} else {
    	    rbtn0.setSelected(true);
    	}
	}

	public frmThemNhanVien() {
		this.init();
		LoadChinhSach();
		LoadChucVu();
		btnChinhSua.setVisible(false);
	}
	public frmThemNhanVien(String maNV) {
		this.init();
		LoadChinhSach();
		LoadChucVu();
		this.SelectData(maNV);
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
	
    public void LoadChinhSach() {
        DefaultComboBoxModel<ENTITY.CHINHSACH> model = new DefaultComboBoxModel<ENTITY.CHINHSACH>(nvBLL.LoadChinhSach());
        cbboxChinhSach.setModel(model);
    }
	public void LoadChucVu() {
	    DefaultComboBoxModel<ENTITY.CHUCVU> model = new DefaultComboBoxModel<ENTITY.CHUCVU>(nvBLL.LoadChucVu());
	    cbboxChucVu.setModel(model);
	}

	
	
	
    public boolean ValidatedForm() {
    	if(txtTenNV.getText().isEmpty() || txtNgaySinh.getText().isEmpty() || txtDiaChi.getText().isEmpty() || txtSDT.getText().isEmpty() ||txtCCCD.getText().isEmpty() || txtTK.getText().isEmpty() ||txtMK.getText().isEmpty()) {
    		return false;
    	}
    	else {
    		return true;
    	}  		
    }
    public boolean ValidatedRegex() {
    	if(!lbRegexTen.getText().isEmpty() || !lbRegexNgaySinh.getText().isEmpty() || !lbRegexDiaChi.getText().isEmpty() || !lbRegexSDT.getText().isEmpty() || !lbRegexCCCD.getText().isEmpty()) {
    		return false;
    	}
    	else {
    		return true;
    	}  		
    }
    public static boolean validateDate(String input) {
        // Tìm vị trí của dấu cách đầu tiên và dấu phẩy
        int firstSpaceIndex = input.indexOf(" ");
        int commaIndex = input.indexOf(",");

        // Kiểm tra xem vị trí của các dấu có hợp lệ không
        if (firstSpaceIndex == -1 || commaIndex == -1) {
            return false; // Định dạng không chính xác
        }

        // Cắt các giá trị "MMM", "d" và "y" ra khỏi chuỗi
        String month = input.substring(0, firstSpaceIndex);
        String day = input.substring(firstSpaceIndex + 1, commaIndex);
        String year = input.substring(commaIndex + 1);

        // Kiểm tra xem các giá trị "MMM", "d" và "y" có hợp lệ không
        if (!isValidMonth(month) || !isValidDay(day) || !isValidYear(year)) {
            return false; // Giá trị không hợp lệ
        }

        // Kiểm tra năm nhuận
        int dayInt = Integer.parseInt(day);
        int yearInt = Integer.parseInt(year);

        if (month.equals("Feb")) {
            if (isLeapYear(yearInt)) {
                return dayInt <= 29;
            } else {
                return dayInt <= 28;
            }
        } else if (month.equals("Apr") || month.equals("Jun") || month.equals("Sep") || month.equals("Nov")) {
            return dayInt <= 30;
        }

        return true; // Các tháng khác có tối đa 31 ngày
    }

    private static boolean isValidMonth(String month) {
        // Kiểm tra tháng có trong danh sách 12 tháng
        return month.equals("Jan") || month.equals("Feb") || month.equals("Mar") || month.equals("Apr") ||
                month.equals("May") || month.equals("Jun") || month.equals("Jul") || month.equals("Aug") ||
                month.equals("Sep") || month.equals("Oct") || month.equals("Nov") || month.equals("Dec");
    }

    private static boolean isValidDay(String day) {
        try {
            int dayInt = Integer.parseInt(day);
            return dayInt >= 1 && dayInt <= 31;
        } catch (NumberFormatException e) {
            return false; // Không thể chuyển đổi sang số nguyên
        }
    }

    private static boolean isValidYear(String year) {
        try {
            int yearInt = Integer.parseInt(year);
            return yearInt >= 0; // Kiểm tra năm không âm
        } catch (NumberFormatException e) {
            return false; // Không thể chuyển đổi sang số nguyên
        }
    }

    private static boolean isLeapYear(int year) {
        // Kiểm tra năm nhuận
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public void ValidateDate(String txt) {
    		String PATTERN = "\\b((Jan|Mar|May|Jul|Aug|Oct|Dec)\\s+(0?[1-9]|[12]\\d|3[01])"
    	               + "|(Feb)\\s+(0?[1-9]|[12]\\d)"
    	               + "|(Apr|Jun|Sep|Nov)\\s+(0?[1-9]|[12]\\d|30)"
    	               + "),((19|20)\\d\\d)\\b";
			Pattern patt = Pattern.compile(PATTERN);
			Matcher match = patt.matcher(txt);
			if(!match.matches() || (validateDate(txt) != true)) {
				lbRegexNgaySinh.setText("Vui lòng nhập đúng định dạng");
			}
			else {
				lbRegexNgaySinh.setText("");
			}
    	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnThem){
    		if(this.ValidatedForm() == false || this.ValidatedRegex() == false) {
        		if(this.ValidatedForm() == false) {
        			JOptionPane.showMessageDialog(null, "Cần nhập đủ các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "Cần nhập đúng định các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		}
    		}
    		else {
    			int k = this.addData();
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
		        int k = this.updateData();
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
