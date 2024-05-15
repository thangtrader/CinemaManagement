package GUI;

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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Business_Logic.PhimBLL;
import Process_Data.PhimDAL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmThemThongTinPhim extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtFieldMaPhim;
	private JTextField txtFieldTenPhim;
	private JTextField txtFieldThoiLuong;
	private JTextField txtFieldQuocGia;
	private JTextField txtFieldDaoDien;
	private JTextField txtFieldNamSanXuat;
	private JTextField txtFieldDoTuoi;
	private JDateChooser calendar;
	private JComboBox cbboxTheLoai;
	private PhimBLL phimBLL;
	private PhimDAL phimDAL;
	private JButton btnThem;
	private JButton btnDong;
	private JLabel lbRegexTuoi;
	private JLabel lbRegexNamSX;
	private JLabel lbRegexDaoDien;
	private JLabel lbRegexQuocGia;
	private JLabel lbRegexThoiLuong;
	private JLabel lbRegexTen;
	private JButton btnChinhSua;
	
	public frmThemThongTinPhim() {
		this.init();
		btnChinhSua.setVisible(false);
	}
	public frmThemThongTinPhim(String maPhim) {
		this.init();
		this.SelectData(maPhim);
		btnThem.setVisible(false);
	}
	
	public void init() {
		this.setVisible(true);
		setBounds(100, 100, 616, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(253, 243, 225));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbMaPhim = new JLabel("Mã phim:");
		lbMaPhim.setBounds(45, 78, 58, 13);
		contentPane.add(lbMaPhim);
		
		JLabel lbTenPhim = new JLabel("Tên phim:");
		lbTenPhim.setBounds(45, 128, 71, 13);
		contentPane.add(lbTenPhim);
		
		JLabel lblNewLabel_2 = new JLabel("Thời lượng:");
		lblNewLabel_2.setBounds(45, 188, 71, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel txtField = new JLabel("Quốc gia");
		txtField.setBounds(45, 243, 70, 13);
		contentPane.add(txtField);
		
		JLabel lblNewLabel_4 = new JLabel("Đạo diễn:");
		lblNewLabel_4.setBounds(305, 78, 70, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Năm sản xuất:");
		lblNewLabel_5.setBounds(305, 128, 92, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Độ tuổi:");
		lblNewLabel_6.setBounds(305, 188, 50, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Thể loại:");
		lblNewLabel_7.setBounds(305, 243, 70, 13);
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
				ValidateDate(txtFieldNamSanXuat.getText());
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
			            ValidateDate(txtFieldNamSanXuat.getText());

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
		btnThem.setForeground(new Color(255, 235, 205));
		btnThem.setBackground(new Color(255, 165, 0));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(88, 297, 100, 36);
		btnThem.setIcon(new ImageIcon(getClass().getResource("/image/them.png")));
		contentPane.add(btnThem);
		
		btnDong = new JButton("Đóng");
		btnDong.setForeground(new Color(255, 235, 205));
		btnDong.setIcon(new ImageIcon(getClass().getResource("/image/x.png")));
		btnDong.setBackground(new Color(255, 147, 150));
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDong.setBounds(437, 297, 85, 36);
		contentPane.add(btnDong);
		
		cbboxTheLoai = new JComboBox();
		cbboxTheLoai.setBounds(392, 239, 109, 21);
		contentPane.add(cbboxTheLoai);
		
		lbRegexTen = new JLabel();
		lbRegexTen.setBounds(139, 154, 45, 13);
		contentPane.add(lbRegexTen);
		
		lbRegexThoiLuong = new JLabel();
		lbRegexThoiLuong.setBounds(139, 214, 45, 13);
		contentPane.add(lbRegexThoiLuong);
		
		lbRegexQuocGia = new JLabel();
		lbRegexQuocGia.setBounds(139, 269, 45, 13);
		contentPane.add(lbRegexQuocGia);
		
		lbRegexDaoDien = new JLabel();
		lbRegexDaoDien.setBounds(392, 104, 45, 13);
		contentPane.add(lbRegexDaoDien);
		
		lbRegexNamSX = new JLabel();
		lbRegexNamSX.setBounds(392, 154, 45, 13);
		contentPane.add(lbRegexNamSX);
		
		lbRegexTuoi = new JLabel();
		lbRegexTuoi.setBounds(392, 214, 45, 13);
		contentPane.add(lbRegexTuoi);
		
		
		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setForeground(new Color(255, 235, 205));
		btnChinhSua.setBackground(new Color(255, 165, 0));
		btnChinhSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChinhSua.setIcon(new ImageIcon(getClass().getResource("/image/sua.png.png")));
		btnChinhSua.setBounds(260, 297, 130, 36);
		contentPane.add(btnChinhSua);
		
        phimBLL = new Business_Logic.PhimBLL();
        phimDAL = new Process_Data.PhimDAL();
		btnThem.addActionListener(this);
		btnDong.addActionListener(this);
		btnChinhSua.addActionListener(this);
		LoadTheLoai();
	}
	
	public void LoadTheLoai() {
	  DefaultComboBoxModel<ENTITY.THELOAIPHIM> model = new DefaultComboBoxModel<ENTITY.THELOAIPHIM>(phimBLL.LoadTheLoai());
	  cbboxTheLoai.setModel(model);
	}
	
    public int addData() {
    	ENTITY.PhimViewDTO phimviewDTO = new ENTITY.PhimViewDTO();
    	String tenphim = txtFieldTenPhim.getText().trim();
    	String thoiluong = txtFieldThoiLuong.getText().trim();
    	String quocgia = txtFieldQuocGia.getText().trim();
    	String daodien = txtFieldDaoDien.getText().trim();
    	Date namsanxuat = calendar.getDate();
    	String dotuoixem = txtFieldDoTuoi.getText().trim();
    	String maloaiphim = ((ENTITY.THELOAIPHIM) cbboxTheLoai.getSelectedItem()).getMaTheLoaiPhim();
    	
    	phimviewDTO.setTenPhim(tenphim);
    	phimviewDTO.setThoiLuong(Integer.parseInt(thoiluong));
    	phimviewDTO.setQuocGia(quocgia);
    	phimviewDTO.setNamSanXuat(namsanxuat);
    	phimviewDTO.setDoTuoiXem(Integer.parseInt(dotuoixem));
    	phimviewDTO.setTenTheLoai(maloaiphim);
    	phimviewDTO.setDaoDien(daodien);
    	
    	return phimBLL.addData(phimviewDTO);
    }
	
    public int updateData() {
    	ENTITY.PhimViewDTO phimviewDTO = new ENTITY.PhimViewDTO();
    	String maphim = txtFieldMaPhim.getText().trim();
    	String tenphim = txtFieldTenPhim.getText().trim();
    	String thoiluong = txtFieldThoiLuong.getText().trim();
    	String quocgia = txtFieldQuocGia.getText().trim();
    	String daodien = txtFieldDaoDien.getText().trim();
    	String namsanxuat = txtFieldNamSanXuat.getText();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
        
    	Date namSanXuat = null;
    	try {
    		namSanXuat = dateFormat.parse(namsanxuat);
    	} catch (ParseException e) {
          e.printStackTrace();
    	}
    	calendar.setDate(namSanXuat);
    	calendar.setToolTipText(namsanxuat);
    	String dotuoixem = txtFieldDoTuoi.getText().trim();
    	String maloaiphim = ((ENTITY.THELOAIPHIM) cbboxTheLoai.getSelectedItem()).getMaTheLoaiPhim();
    	
    	phimviewDTO.setMaPhim(maphim);
    	phimviewDTO.setTenPhim(tenphim);
    	phimviewDTO.setThoiLuong(Integer.parseInt(thoiluong));
    	phimviewDTO.setQuocGia(quocgia);
    	phimviewDTO.setNamSanXuat(namSanXuat);
    	phimviewDTO.setDoTuoiXem(Integer.parseInt(dotuoixem));
    	phimviewDTO.setTenTheLoai(maloaiphim);
    	phimviewDTO.setDaoDien(daodien);
    	
    	return phimBLL.updateData(phimviewDTO);	
    }
	
    public void SelectData(String maphim) {
    	ENTITY.PhimViewDTO phimviewDTO = new ENTITY.PhimViewDTO();
    	Object[] param = new Object[] {maphim};
    	phimviewDTO = phimDAL.GetPhimByMa(param);
    	txtFieldMaPhim.setText(phimviewDTO.getMaPhim());
    	txtFieldTenPhim.setText(phimviewDTO.getTenPhim());
    	txtFieldThoiLuong.setText(Integer.toString(phimviewDTO.getThoiLuong()));
    	txtFieldQuocGia.setText(phimviewDTO.getQuocGia());
    	txtFieldDaoDien.setText(phimviewDTO.getDaoDien());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
        Date ngaySinh = phimviewDTO.getNamSanXuat();		
        String ngaySinhString = dateFormat.format(ngaySinh);
        txtFieldNamSanXuat.setText(ngaySinhString);
          	
        txtFieldDoTuoi.setText(Integer.toString(phimviewDTO.getDoTuoiXem()));

    	
        for(int i = 0; i< cbboxTheLoai.getItemCount(); i++) {
        	if(cbboxTheLoai.getItemAt(i).toString().equalsIgnoreCase(phimviewDTO.getTenTheLoai())) {
        		cbboxTheLoai.setSelectedIndex(i);
        	}
        }
    }
    
    public boolean ValidatedRegex() {
    	if(!lbRegexTen.getText().isEmpty() || !lbRegexThoiLuong.getText().isEmpty() || !lbRegexQuocGia.getText().isEmpty() || !lbRegexDaoDien.getText().isEmpty() || !lbRegexNamSX.getText().isEmpty() ||!lbRegexTuoi.getText().isEmpty()) {
    		return false;
    	}
    	else {
    		return true;
    	}  		
    }
    
    public boolean ValidatedForm() {
    	if(txtFieldTenPhim.getText().isEmpty() || txtFieldThoiLuong.getText().isEmpty() || txtFieldQuocGia.getText().isEmpty() || txtFieldDaoDien.getText().isEmpty() || txtFieldNamSanXuat.getText().isEmpty() || txtFieldDoTuoi.getText().isEmpty()) {
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
				lbRegexNamSX.setText("Vui lòng nhập đúng định dạng");
			}
			else {
				lbRegexNamSX.setText("");
			}
    }
	  
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
    			int k = addData();
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
        	if(this.ValidatedForm() == false || this.ValidatedRegex() == false) {
        		if(this.ValidatedForm() == false) {
        			JOptionPane.showMessageDialog(null, "Cần nhập đủ các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "Cần nhập đúng định các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		}
    		}
        	else {
        			int k = updateData();
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

