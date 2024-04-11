package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Business_Logic.PhimBLL;
import Process_Data.PhimDAL;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class frmTHONGTINPHIM extends JPanel implements ItemListener, MouseListener, ActionListener {
	public JTextField textFieldTimKiem;
	private static final long serialVersionUID = 1L;
	public JTable table;
	private JTable table_1;
	public JTextField textFieldMaPhim;
	public JTextField textFieldTenPhim;
	public JTextField textFieldThoiLuong;
	public JTextField textFieldQuocGia;
	public JTextField textFieldDoTuoi;
	public JTextField textFieldDaoDien;
	public JComboBox comboBoxTheLoai;
    public DefaultTableModel model;
    PhimBLL phimBLL;
    PhimDAL phimDAL;
    GUI.frmThemThongTinPhim themPhim;
    
	int current = 0;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
//	private JCalendar calendar;
	public JDateChooser calendar;
	private JLabel lbRegex;
	public JLabel lbRegexTen;
	public JLabel lbRegexNamSX;
	public JLabel lbRegexThoiLuong;
	public JLabel lbRegexQuocGia;
	public JLabel lbRegexDaoDien;
	public JLabel lbRegexTuoi;
	public JTextField textFieldNamSanXuat;
	/**
	 * Create the panel.
	 */
	public frmTHONGTINPHIM() {
		setBackground(new Color(241, 241, 241));
		setLayout(null);
		
		
		JLabel lblNewLabel_6 = new JLabel("Danh sách phim");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(10, 42, 123, 30);
		this.add(lblNewLabel_6);
		
		textFieldTimKiem = new JTextField();
		textFieldTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				TimKiemByTen(textFieldTimKiem.getText());
				System.out.println(textFieldTimKiem.getText());
			}
		});
		textFieldTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTimKiem.setBorder(null);
		textFieldTimKiem.setBackground(new Color(227, 227, 227));
		textFieldTimKiem.setBounds(466, 42, 147, 32);
		this.add(textFieldTimKiem);
		textFieldTimKiem.setColumns(10);
		
		btnThem = new JButton("Thêm phim");
		btnThem.setForeground(new Color(85, 173, 183));
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnThem.setBackground(new Color(240, 240, 240));
		btnThem.setFont(new Font("Roboto", Font.BOLD, 14));
		btnThem.setBounds(99, 388, 108, 39);
		this.add(btnThem);
		
		btnXoa = new JButton("Xóa phim");
		btnXoa.setForeground(new Color(85, 173, 183));
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		btnXoa.setBackground(new Color(240, 240, 240));
		btnXoa.setFont(new Font("Roboto", Font.BOLD, 14));
		btnXoa.setBounds(334, 388, 108, 39);
		this.add(btnXoa);
		
		btnSua = new JButton("Chỉnh sửa");
		btnSua.setForeground(new Color(85, 173, 183));
		btnSua.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSua.setBackground(new Color(240, 240, 240));
		btnSua.setFont(new Font("Roboto", Font.BOLD, 14));
		btnSua.setBounds(550, 388, 108, 39);
		this.add(btnSua);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(194, 254, 224));
		panel.setBounds(0, 0, 816, 29);
		add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("DANH SÁCH PHIM");
		lblNewLabel_5.setBounds(0, 0, 603, 20);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setBackground(new Color(71, 141, 141));
		lblNewLabel_5.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("D:\\eclipse\\DoAnJavaNangCao2\\src\\image\\pngwing.com (14).png")));
		lblNewLabel_5.setForeground(new Color(81, 171, 181));
		lblNewLabel_5.setBorder(null);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);
		table.setBackground(new Color(253, 243, 225));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 phim", "T\u00EAn phim", "Th\u1EDDi l\u01B0\u1EE3ng", "Qu\u1ED1c gia", "\u0110\u1EA1o di\u1EC5n", "N\u0103m s\u1EA3n xu\u1EA5t", "\u0110\u1ED9 tu\u1ED5i xem", "Th\u1EC3 lo\u1EA1i"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(79);
		table.getColumnModel().getColumn(1).setPreferredWidth(119);
		table.getColumnModel().getColumn(2).setPreferredWidth(65);
		table.getColumnModel().getColumn(3).setPreferredWidth(62);
		table.getColumnModel().getColumn(4).setPreferredWidth(93);
		table.getColumnModel().getColumn(5).setPreferredWidth(72);
		table.getColumnModel().getColumn(6).setPreferredWidth(67);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 84, 796, 147);
		this.add(scrollPane);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 237, 769, 2);
		add(separator);
		
		JLabel lblNewLabel_6_1 = new JLabel("Mã phim");
		lblNewLabel_6_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1.setBounds(23, 247, 91, 24);
		add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Quốc gia");
		lblNewLabel_6_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_1.setBounds(23, 339, 91, 24);
		add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("Tên phim");
		lblNewLabel_6_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_2.setBounds(23, 275, 91, 24);
		add(lblNewLabel_6_1_2);
		
		JLabel lblNewLabel_6_1_3 = new JLabel("Thời lượng");
		lblNewLabel_6_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_3.setBounds(23, 309, 91, 24);
		add(lblNewLabel_6_1_3);
		
		textFieldMaPhim = new JTextField();
		textFieldMaPhim.setEditable(false);
		textFieldMaPhim.setBounds(99, 249, 142, 24);
		add(textFieldMaPhim);
		textFieldMaPhim.setColumns(10);
		
		textFieldTenPhim = new JTextField();
		textFieldTenPhim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^(?!\\s+$)[\\p{L}\\d\\s]{1,50}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(textFieldTenPhim.getText());
				if(!match.matches()) {
					lbRegexTen.setText("Vui lòng không nhập đúng định dạng");
				}
				else {
					lbRegexTen.setText("");
				}
			}
		});
		textFieldTenPhim.setColumns(10);
		textFieldTenPhim.setBounds(99, 281, 142, 24);
		add(textFieldTenPhim);
		
		textFieldThoiLuong = new JTextField();
		textFieldThoiLuong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[6-9][0-9]|[1-2][0-9]{2}|300$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(textFieldThoiLuong.getText());
				if(!match.matches()) {
					lbRegexThoiLuong.setText("Vui lòng không nhập đúng định dạng");
				}
				else {
					lbRegexThoiLuong.setText("");
				}
			}
		});
		textFieldThoiLuong.setColumns(10);
		textFieldThoiLuong.setBounds(99, 309, 142, 24);
		add(textFieldThoiLuong);
		
		textFieldQuocGia = new JTextField();
		textFieldQuocGia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^(?!\\s+$)[\\p{L}\\s]{1,20}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(textFieldQuocGia.getText());
				if(!match.matches()) {
					lbRegexQuocGia.setText("Vui lòng không nhập đúng định dạng");
				}
				else {
					lbRegexQuocGia.setText("");
				}
			}
		});
		textFieldQuocGia.setColumns(10);
		textFieldQuocGia.setBounds(99, 341, 142, 24);
		add(textFieldQuocGia);
		
		JLabel lblNewLabel_6_1_4 = new JLabel("Năm sản xuất");
		lblNewLabel_6_1_4.setForeground(Color.BLACK);
		lblNewLabel_6_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_4.setBounds(413, 278, 91, 27);
		add(lblNewLabel_6_1_4);
		
		JLabel lblNewLabel_6_1_2_1 = new JLabel("Độ tuổi");
		lblNewLabel_6_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_6_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_2_1.setBounds(413, 309, 91, 24);
		add(lblNewLabel_6_1_2_1);
		
		JLabel lblNewLabel_6_1_3_1 = new JLabel("Thể loại");
		lblNewLabel_6_1_3_1.setForeground(Color.BLACK);
		lblNewLabel_6_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_3_1.setBounds(413, 338, 91, 26);
		add(lblNewLabel_6_1_3_1);
		
		calendar = new JDateChooser();
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				String namsx;
				 if ("date".equals(evt.getPropertyName())) {
		                Date namsanxuat = ((Date) evt.getNewValue());
		                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
		            		namsx = dateFormat.format(namsanxuat);
			                textFieldNamSanXuat.setText(namsx);
			                System.out.println("form" + textFieldNamSanXuat.getText());
			                phimBLL.ValidateDate(textFieldNamSanXuat.getText());

		            }
			}
		});
		calendar.setToolTipText("");
		calendar.getCalendarButton().setToolTipText("");
//		calendar.setColumns(10);
		calendar.setBounds(635, 281, 23, 24);
		add(calendar);
		
		textFieldDoTuoi = new JTextField();
		textFieldDoTuoi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^(1[5-9]|[2-9][0-9]|100)$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(textFieldDoTuoi.getText());
				if(!match.matches()) {
					lbRegexTuoi.setText("Vui lòng không nhập đúng định dạng");
				}
				else {
					lbRegexTuoi.setText("");
				}
			}
		});
		textFieldDoTuoi.setColumns(10);
		textFieldDoTuoi.setBounds(516, 311, 142, 24);
		add(textFieldDoTuoi);
		
		textFieldDaoDien = new JTextField();
		textFieldDaoDien.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^(?!\\s+$)[\\p{L}\\d\\s]{1,30}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(textFieldDaoDien.getText());
				if(!match.matches()) {
					lbRegexDaoDien.setText("Vui lòng không nhập đúng định dạng");
				}
				else {
					lbRegexDaoDien.setText("");
				}
			}
		});
		textFieldDaoDien.setColumns(10);
		textFieldDaoDien.setBounds(516, 249, 142, 24);
		add(textFieldDaoDien);
		
		JLabel lblNewLabel_6_1_3_1_1 = new JLabel("Đạo diễn");
		lblNewLabel_6_1_3_1_1.setForeground(Color.BLACK);
		lblNewLabel_6_1_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_3_1_1.setBounds(413, 249, 91, 24);
		add(lblNewLabel_6_1_3_1_1);
		
		JLabel lblNewLabel_6_1_2_2 = new JLabel("Tìm kiếm:");
		lblNewLabel_6_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_6_1_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_2_2.setBounds(388, 43, 72, 30);
		add(lblNewLabel_6_1_2_2);
		
		comboBoxTheLoai = new JComboBox();
		comboBoxTheLoai.setBounds(516, 342, 142, 21);
		add(comboBoxTheLoai);
		
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
        table.addMouseListener(this);
        comboBoxTheLoai.addItemListener(this);
        phimBLL = new Business_Logic.PhimBLL(this);
        phimDAL = new Process_Data.PhimDAL(this);
        
        lbRegex = new JLabel("");
        lbRegex.setBounds(123, 365, 142, 13);
        add(lbRegex);
        
        lbRegexTen = new JLabel("");
        lbRegexTen.setBounds(251, 286, 152, 19);
        add(lbRegexTen);
        
        lbRegexNamSX = new JLabel("");
        lbRegexNamSX.setBounds(672, 286, 134, 13);
        add(lbRegexNamSX);
        
        lbRegexThoiLuong = new JLabel("");
        lbRegexThoiLuong.setBounds(251, 320, 134, 13);
        add(lbRegexThoiLuong);
        
        lbRegexQuocGia = new JLabel("");
        lbRegexQuocGia.setBounds(261, 352, 142, 13);
        add(lbRegexQuocGia);
        
        lbRegexDaoDien = new JLabel("");
        lbRegexDaoDien.setBounds(672, 254, 134, 13);
        add(lbRegexDaoDien);
        
        lbRegexTuoi = new JLabel("");
        lbRegexTuoi.setBounds(672, 316, 117, 13);
        add(lbRegexTuoi);
        
        textFieldNamSanXuat = new JTextField();
        textFieldNamSanXuat.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		phimBLL.ValidateDate(textFieldNamSanXuat.getText());
        	}
        });
        textFieldNamSanXuat.setColumns(10);
        textFieldNamSanXuat.setBounds(516, 281, 119, 24);
        add(textFieldNamSanXuat);
//		String text = textFieldTenPhim.getText().trim(); // Lấy văn bản từ textField và loại bỏ khoảng trắng thừa
//		if(text.isEmpty()){
//		    lbRegex.setText("Vui lòng nhập tên phim!");
//		}
//		else {
//			lbRegex.setText(null);
//		}

		
	}          
//	public void hienThiTable(){
//        PhimBLL phimBLL = new PhimBLL();
//        Vector<ENTITY.PHIM> vec = phimBLL.ListPhim();
//        DefaultTableModel dftbl = (DefaultTableModel)table.getModel();
//        dftbl.setRowCount(0);
//        for(ENTITY.PHIM phim : vec){
//            Object[] row = new Object[]{phim.getMaPhim(), phim.getTenPhim(), phim.getThoiLuong(), phim.getQuocGia(), phim.getDaoDien(), phim.getNanSanXuat(), phim.getDoTuoiXem(), phim.getMaTheLoai()};
//            dftbl.addRow(row);
//        }
//    }
    public void TimKiemByTen(String maPhim){
    	PhimBLL phimBLL = new PhimBLL();
        Vector<ENTITY.PHIM> vec = phimBLL.TimKiemByMa(maPhim);
        DefaultTableModel dftbl = (DefaultTableModel)table.getModel();
        dftbl.setRowCount(0);
        for(ENTITY.PHIM phim : vec){
            Object[] row = new Object[]{phim.getMaPhim(), phim.getTenPhim(), phim.getThoiLuong(), phim.getQuocGia(), phim.getDaoDien(), phim.getNanSanXuat(), phim.getDoTuoiXem(), phim.getMaTheLoai()};
            dftbl.addRow(row);
        }
    }

    public void getRowData() {
        int selectedRow = table.getSelectedRow();
        System.out.println(selectedRow);
        if (selectedRow != -1 && selectedRow < table.getRowCount()) {
            String maphim = table.getValueAt(selectedRow, 0).toString();
            String tenphim = table.getValueAt(selectedRow, 1).toString();
            String thoiluong = table.getValueAt(selectedRow, 2).toString();
            String quocgia = table.getValueAt(selectedRow, 3).toString();
            String daodien = table.getValueAt(selectedRow, 4).toString();
            String namsanxuat = table.getValueAt(selectedRow, 5).toString();
            String dotuoixem = table.getValueAt(selectedRow, 6).toString();
            String tentheloai = table.getValueAt(selectedRow, 7).toString();
            
            textFieldMaPhim.setText(maphim);
            textFieldTenPhim.setText(tenphim);
            textFieldThoiLuong.setText(thoiluong);
            textFieldQuocGia.setText(quocgia);
            textFieldDaoDien.setText(daodien);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM d,y");
            
            Date ngaySanXuat = null;
            try {
                ngaySanXuat = dateFormat.parse(namsanxuat);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            textFieldNamSanXuat.setText(dateFormat2.format(ngaySanXuat));
            calendar.setDate(ngaySanXuat);
            calendar.setToolTipText(namsanxuat);
            System.out.println(namsanxuat);
            textFieldDoTuoi.setText(dotuoixem);
            for(int i = 0; i<comboBoxTheLoai.getItemCount(); i++) {
            	if(comboBoxTheLoai.getItemAt(i).toString().equalsIgnoreCase(tentheloai)) {
                    comboBoxTheLoai.setSelectedIndex(i);
            	}
            }
        } else {
            // Xử lý khi không có hàng nào được chọn
            // Ví dụ: Hiển thị thông báo cho người dùng
            System.out.println("Không có hàng nào được chọn.");
        }
    }
    public void getRowDatafrm() {
        int selectedRow = table.getSelectedRow();
        System.out.println(selectedRow);
        if (selectedRow != -1 && selectedRow < table.getRowCount()) {
            String maphim = table.getValueAt(selectedRow, 0).toString();
            String tenphim = table.getValueAt(selectedRow, 1).toString();
            String thoiluong = table.getValueAt(selectedRow, 2).toString();
            String quocgia = table.getValueAt(selectedRow, 3).toString();
            String daodien = table.getValueAt(selectedRow, 4).toString();
            String namsanxuat = table.getValueAt(selectedRow, 5).toString();
            String dotuoixem = table.getValueAt(selectedRow, 6).toString();
            String matheloai = table.getValueAt(selectedRow, 7).toString();
            
//            themPhim.textField.setText(maphim);
            themPhim.txtFieldTenPhim.setText(tenphim);
            themPhim.txtFieldThoiLuong.setText(thoiluong);
            themPhim.txtFieldQuocGia.setText(quocgia);
            themPhim.txtFieldDaoDien.setText(daodien);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date ngaySanXuat = null;
            try {
                ngaySanXuat = dateFormat.parse(namsanxuat);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            themPhim.calendar.setDate(ngaySanXuat);
            themPhim.calendar.setToolTipText(namsanxuat);
            System.out.println(namsanxuat);
            themPhim.txtDoTuoi.setText(dotuoixem);
//            comboBoxTheLoai.setToolTipText(matheloai);
        } else {
            // Xử lý khi không có hàng nào được chọn
            // Ví dụ: Hiển thị thông báo cho người dùng
            System.out.println("Không có hàng nào được chọn.");
        }
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
        if (e.getSource() == table) {
            if (table.getSelectedRow() >= 0) {
                getRowData();
            }
            phimBLL.ClearRegex();
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
        	if (e.getSource() == btnThem) {
//        		themPhim = new frmThemThongTinPhim();
//        		themPhim.main(null);
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
        			if(k==1)
                    	JOptionPane.showMessageDialog(null, "Đã thêm thông tin phim thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    else
                    	JOptionPane.showMessageDialog(null, "Thêm phim không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    phimBLL.LoadPhim();
            		phimBLL.ClearData();
        		}
            }
            if (e.getSource() == btnXoa) {
                int k = phimBLL.removeData();
                if(k==1) {
                	JOptionPane.showMessageDialog(null, "Đã xóa thông tin phim thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                	JOptionPane.showMessageDialog(null, "Xóa phim không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                phimBLL.LoadPhim();
                phimBLL.ClearData();
            }
            if (e.getSource() == btnSua) {
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
            			if(k==1)
            				JOptionPane.showMessageDialog(null, "Đã sửa thông tin phim thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            			else
            				JOptionPane.showMessageDialog(null, "Sửa phim không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            			phimBLL.LoadPhim();
            			phimBLL.ClearData();
//            		}
        		}
            }
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}