package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business_Logic.LichChieuBLL;
import Process_Data.LichChieuDAL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Time;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;

public class diaCAPNHATLICHCHIEU extends JDialog implements ActionListener ,ItemListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField textFieldTenPhim;
	public JTextField textFieldNgayChieu;
	public JTextField textFieldTrangThai;
	public JDateChooser calendar;
	private JButton btnLuu;
	private JButton btnHuy;
    LichChieuBLL lichBLL;
    LichChieuDAL lichDAL;
    
    GUI.panelLICHCHIEU lich;
	private Component textFieldMaPhim;
	private JTextField textField;
	public JComboBox comboBoxTgbd;
	public JComboBox comboBoxTgkt;
	public JComboBox comboBoxPhong;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JLabel lblNewLabel_5;
	public JLabel lblNewLabel_6;
	public JLabel lblRegexTT;
	public JLabel lbRegexNgay;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			diaCAPNHATLICHCHIEU dialog = new diaCAPNHATLICHCHIEU();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	public diaCAPNHATLICHCHIEU(String tenphim) {
//		this.init();
//		this.SelectData(tenphim);
//
//	}
	public diaCAPNHATLICHCHIEU(String TPhim,String TPhong, String Ngaychieu,String TGBD ) {
		this.init();
		this.SelectData(TPhim,TPhong,Ngaychieu,TGBD);

	}

	/**
	 * Create the dialog.
	 */
	public void init() {
		getContentPane().setBackground(new Color(253, 245, 230));
		setBackground(new Color(250, 240, 230));
		setBounds(250, 220, 592, 312);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(230, 243, 240));
		contentPanel.setBounds(0, 0, 578, 275);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Tên Phim");
			lblNewLabel_1.setBounds(31, 80, 72, 13);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Tên phòng chiếu");
			lblNewLabel_2.setBounds(31, 138, 103, 13);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Ngày chiếu");
			lblNewLabel_3.setBounds(31, 195, 128, 13);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Thời gian bắt đầu");
			lblNewLabel_4.setBounds(308, 80, 113, 13);
			contentPanel.add(lblNewLabel_4);
		}
		{	
			lblNewLabel_6 = new JLabel("Thời gian kết thúc");
			lblNewLabel_6.setBounds(307, 138, 113, 13);
			contentPanel.add(lblNewLabel_6);
		}
		
		{
			JLabel lblNewLabel_5 = new JLabel("Trạng thái");
			lblNewLabel_5.setBounds(307, 198, 72, 13);
			contentPanel.add(lblNewLabel_5);
		}
		
		textFieldTenPhim = new JTextField();
	//	textFieldTenPhim.setEditable(false);
		textFieldTenPhim.setBounds(145, 77, 96, 19);
		 ((JTextField) textFieldTenPhim).setColumns(10);
		contentPanel.add(textFieldTenPhim);
		
		textFieldNgayChieu = new JTextField();
		textFieldNgayChieu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ValidateDate(textFieldNgayChieu.getText());
			}
		});

		textFieldNgayChieu.setBounds(145, 195, 96, 19);
		textFieldNgayChieu.setColumns(10);
		contentPanel.add(textFieldNgayChieu);
		
		calendar = new JDateChooser();
		
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				String namsx;
				 if ("date".equals(evt.getPropertyName())) {
		                Date namsanxuat = ((Date) evt.getNewValue());
		                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
		                namsx = dateFormat.format(namsanxuat);
		                textFieldNgayChieu.setText(namsx);
			            ValidateDate(textFieldNgayChieu.getText());

				 }
			}
		});
		calendar.getCalendarButton().setBounds(0, 0, 21, 19);
	//	calendar.setEnabled(false);
//		
//		calendar.addPropertyChangeListener(new PropertyChangeListener() {
//			public void propertyChange(PropertyChangeEvent evt) {
//				String ngaych;
//				 if ("date".equals(evt.getPropertyName())) {
//		                Date ngaychieu = ((Date) evt.getNewValue());
//		                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
//		                ngaych = dateFormat.format(ngaychieu);
//		            		textFieldNgayChieu.setText(ngaych);
//			                System.out.println("form" + textFieldNgayChieu.getText());
//			            //    lichBLL.ValidateDate(textFieldNgayChieu.getText());
//
//		            }
//			}
//		});
//		calendar = new JDateChooser();

		calendar.setBounds(242, 195, 21, 19);
		calendar.setToolTipText("");
		calendar.getCalendarButton().setToolTipText("");
		contentPanel.add(calendar);
		calendar.setLayout(null);
		 
		comboBoxTgbd = new JComboBox();
		comboBoxTgbd.setBounds(431, 77, 97, 19);
	//	comboBoxTgbd.setEnabled(false);
		contentPanel.add(comboBoxTgbd);
	
		
		comboBoxTgkt = new JComboBox();
		comboBoxTgkt.setBounds(431, 134, 97, 19);
	//	comboBoxTgkt.setEnabled(false);
		contentPanel.add(comboBoxTgkt);
		
		comboBoxPhong = new JComboBox();
		comboBoxPhong.setBounds(144, 134, 97, 21);
	//	comboBoxPhong.setEnabled(false);
		contentPanel.add(comboBoxPhong);
		
		comboBoxTgbd.addItemListener(this);
		comboBoxTgkt.addItemListener(this);
		comboBoxPhong.addItemListener(this);
	
		textFieldTrangThai = new JTextField();

		textFieldTrangThai.setBounds(431, 195, 96, 19);
		textFieldTrangThai.setColumns(10);
		contentPanel.add(textFieldTrangThai);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setBounds(339, 244, 66, 21);
		btnLuu.setForeground(new Color(255, 255, 255));
		btnLuu.setBackground(new Color(32, 178, 170));
		contentPanel.add(btnLuu);		
		getRootPane().setDefaultButton(btnLuu);
		
		btnHuy = new JButton("Hủy");
		btnHuy.setBounds(428, 243, 84, 21);
		btnHuy.setForeground(new Color(255, 255, 255));
		btnHuy.setBackground(new Color(255, 99, 71));
		contentPanel.add(btnHuy);

		JLabel lblNewLabel = new JLabel("Thông tin lịch chiếu");
		lblNewLabel.setBounds(192, 3, 194, 43);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		contentPanel.add(lblNewLabel);
		
		lbRegexNgay = new JLabel("New label");
		lbRegexNgay.setBounds(145, 220, 45, 13);
		contentPanel.add(lbRegexNgay);
		lbRegexNgay.setVisible(false);
		
		lblRegexTT = new JLabel("New label");
		lblRegexTT.setBounds(431, 220, 45, 13);
		contentPanel.add(lblRegexTT);
		lblRegexTT.setVisible(false);	
	

		btnLuu.addActionListener(this);
		btnHuy.addActionListener(this);
//        lichBLL = new Business_Logic.LichChieuBLL(this);
//        lichDAL = new Process_Data.LichChieuDAL(this);
		lichBLL = new Business_Logic.LichChieuBLL();
		lichDAL = new Process_Data.LichChieuDAL();
	   	 LoadTGBatDau() ;
	   	 LoadTGKetThuc() ;
	   	 LoadPhongChieu();
	
	}
	  public void LoadPhongChieu() {
	  DefaultComboBoxModel<ENTITY.PHONGCHIEU> model = new DefaultComboBoxModel<ENTITY.PHONGCHIEU>(lichDAL.ListPhongChieu());
	  comboBoxPhong.setModel(model);
	 
	}
	  public void LoadTGKetThuc() {
	  DefaultComboBoxModel<ENTITY.KHUNGGIOCHIEU_TGKETTHUC> model = new DefaultComboBoxModel<ENTITY.KHUNGGIOCHIEU_TGKETTHUC>(lichDAL.ListTGKetThuc());
	  comboBoxTgkt.setModel(model);
	
	}
	  public void LoadTGBatDau() {
	  DefaultComboBoxModel<ENTITY.KHUNGGIOCHIEU_TGBATDAU> model = new DefaultComboBoxModel<ENTITY.KHUNGGIOCHIEU_TGBATDAU>(lichDAL.ListTGBatDau());
	  comboBoxTgbd.setModel(model);
	
	}
	  
//	    public int updateData() {
//	    	ENTITY.LICHCHIEUDTO lichchieuDTO = new ENTITY.LICHCHIEUDTO();
//	    	String tenphim = textFieldTenPhim.getText().trim();
//	    	String tenphongchieu = ((ENTITY.PHONGCHIEU) comboBoxPhong.getSelectedItem()).getTenPhong();
//	    	String ngaychieu = textFieldNgayChieu.getText();
//	    	Time thoigianbatdau = ((ENTITY.KHUNGGIOCHIEU) comboBoxTgbd.getSelectedItem()).getTgBatDau();
//	    	Time thoigianketthuc = ((ENTITY.KHUNGGIOCHIEU) comboBoxTgkt.getSelectedItem()).getTgKetThuc();
//	    	String tentinhtrang = textFieldTrangThai.getText().trim();
//	    	SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
//	        
//	    	Date NgayCh = null;
//	    	try {
//	    		NgayCh = dateFormat.parse(ngaychieu);
//	    	} catch (ParseException e) {
//	          e.printStackTrace();
//	    	}
//	    	calendar.setDate(NgayCh);
//	    	calendar.setToolTipText(ngaychieu);
//	    	
//	    	lichchieuDTO.setTenPhim(tenphim);
//	    	lichchieuDTO.setTenPhong(tenphongchieu);
//	    	lichchieuDTO.setNgayChieu(NgayCh);
//	    	lichchieuDTO.setThoiGianBatDau(thoigianbatdau);
//	    	lichchieuDTO.setThoiGianBatDau(thoigianketthuc);
//	    	lichchieuDTO.setTenTinhTrang(tentinhtrang);
//	    	
//	    	return lichBLL.updateData(lichchieuDTO);	
//	    }
//	    
	  
	  public int updateData() {
		    ENTITY.LICHCHIEUVIEWDTO lichchieuDTO = new ENTITY.LICHCHIEUVIEWDTO();
		    String tenphim = textFieldTenPhim.getText().trim();
		    String tenphongchieu = ((ENTITY.PHONGCHIEU) comboBoxPhong.getSelectedItem()).getTenPhong();
		    String ngaychieu = textFieldNgayChieu.getText();
		    Time thoigianbatdau = ((ENTITY.KHUNGGIOCHIEU_TGBATDAU) comboBoxTgbd.getSelectedItem()).getTgBatDau();
		    Time thoigianketthuc = ((ENTITY.KHUNGGIOCHIEU_TGKETTHUC) comboBoxTgkt.getSelectedItem()).getTgKetThuc();
		    String tentinhtrang = textFieldTrangThai.getText().trim();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM d,y");
            
            Date ngaych = null;
            try {
            	ngaych = dateFormat2.parse(ngaychieu);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            textFieldNgayChieu.setText(dateFormat.format(ngaych));
            calendar.setDate(ngaych);
            calendar.setToolTipText(ngaychieu);
            
   
		    lichchieuDTO.setTenPhim(tenphim);
		    lichchieuDTO.setTenPhong(tenphongchieu);
		    lichchieuDTO.setNgayChieu(ngaych);
		    lichchieuDTO.setThoiGianBatDau(thoigianbatdau);
		    lichchieuDTO.setThoiGianKetThuc(thoigianketthuc); 
		    lichchieuDTO.setTenTinhTrang(tentinhtrang);

		    return lichBLL.updateData(lichchieuDTO); 
		}

	    public void SelectData(String TPhim,String TPhong, String Ngaychieu,String TGBD) {
	    	ENTITY.LICHCHIEUVIEWDTO lichchieuDTO = new ENTITY.LICHCHIEUVIEWDTO();
	    	Object[] param = new Object[] {TPhim,TPhong,Ngaychieu,TGBD};
	    	lichchieuDTO = lichDAL.GetLichByMa(param);
	    	textFieldTenPhim.setText(lichchieuDTO.getTenPhim());
          	textFieldTrangThai.setText(lichchieuDTO.getTenTinhTrang());
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
	        Date ngaychieu = lichchieuDTO.getNgayChieu();		
	        String ngaych = dateFormat.format(ngaychieu);
	        textFieldNgayChieu.setText(ngaych);
	          	

            for(int i = 0; i<comboBoxPhong.getItemCount(); i++) {
        	if(comboBoxPhong.getItemAt(i).toString().equalsIgnoreCase(lichchieuDTO.getTenPhong())) {
        	  comboBoxPhong.setSelectedIndex(i);
        	}
            }
            for(int i = 0; i<comboBoxTgbd.getItemCount(); i++) {
        	if(comboBoxTgbd.getItemAt(i).toString().equalsIgnoreCase(lichchieuDTO.getThoiGianBatDau().toString())) {
        		comboBoxTgbd.setSelectedIndex(i);
        	}
        }
        for(int i = 0; i<comboBoxTgkt.getItemCount(); i++) {
        	if(comboBoxTgkt.getItemAt(i).toString().equalsIgnoreCase(lichchieuDTO.getThoiGianKetThuc().toString())) {
        		comboBoxTgkt.setSelectedIndex(i);
        	}
        }
	    }
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//        if (e.getSource() == btnLuu) {
//        	int k = lichBLL.updateData();
//        	if(k==1)
//        		JOptionPane.showMessageDialog(null, "Đã thêm thông tin lịch thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//        	else
//        		JOptionPane.showMessageDialog(null, "Thêm lịch không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//        	this.dispose();
//    	}
//        if(e.getSource() == btnHuy) {
//        	this.dispose();
//        }
//	}
//    if (e.getSource() == btnLuu) {
//    	if(lichBLL.ValidatedForm() == false ) {
//    		if(lichBLL.ValidatedForm() == false) {
//    			JOptionPane.showMessageDialog(null, "Cần nhập đủ các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//    		}
//    		else {
//    			JOptionPane.showMessageDialog(null, "Cần nhập đúng định các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//    		}
//		}
//    	else {
//    			int k = lichBLL.updateData();
//    			if(k==1)
//    				JOptionPane.showMessageDialog(null, "Đã sửa thông tin phim thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//    			else
//    				JOptionPane.showMessageDialog(null, "Sửa phim không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//    			
//    			
////    		}
//		}
//    } }
//	



	@Override
	public void mouseClicked(MouseEvent e) {
//        if (e.getSource() == lich.table) {
//            if (lich.table.getSelectedRow() >= 0) {
//            	lich.getRowDatafrm();
//            }
//      
//        }
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
    public boolean ValidatedRegex() {
    	if(!lbRegexNgay.getText().isEmpty() || !lblRegexTT.getText().isEmpty()) {
    		return false;
    	}
    	else {
    		return true;
    	}  		
    }
    
  public boolean ValidatedForm() {
	if(textFieldTenPhim.getText().isEmpty() || textFieldNgayChieu.getText().isEmpty() ||textFieldTrangThai.getText().isEmpty()) {
		return false;    	}
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
				lbRegexNgay.setText("Vui lòng nhập đúng định dạng");
			}
			else {
				lbRegexNgay.setText("");
			}
  }

@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource() == btnLuu){
//    	if(this.ValidatedForm() == false || this.ValidatedRegex() == false) {
//    		if(this.ValidatedForm() == false) {
//    			JOptionPane.showMessageDialog(null, "Cần nhập đủ các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//    		}
//    		else {
//    			JOptionPane.showMessageDialog(null, "Cần nhập đúng định dạng các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//    		}
//		}
//    	else {
    			int k = updateData();
    			if(k==1) {
    				JOptionPane.showMessageDialog(null, "Đã sửa lịch thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "Sửa lịch không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    			}
    			this.dispose();
    			
		}
//	}
	if(e.getSource() == btnHuy){
        this.dispose();
	}
}
}