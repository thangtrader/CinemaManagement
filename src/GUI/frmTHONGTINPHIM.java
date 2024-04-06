package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class frmTHONGTINPHIM extends JPanel {
	private JTextField textFieldTimKiem;
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTextField textFieldMaPhim;
	private JTextField textFieldTenPhim;
	private JTextField textFieldThoiLuong;
	private JTextField textFieldQuocGia;
	private JTextField textFieldNamSanXuat;
	private JTextField textFieldDoTuoi;
	private JTextField textFieldDaoDien;

	/**
	 * Create the panel.
	 */
	public frmTHONGTINPHIM() {
		setBackground(new Color(241, 241, 241));
		setLayout(null);
		
		
		JLabel lblNewLabel_6 = new JLabel("Danh sách phim");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(23, 45, 123, 30);
		this.add(lblNewLabel_6);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setForeground(new Color(87, 171, 181));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnTimKiem.setBackground(new Color(240, 240, 240));
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnTimKiem.setBounds(629, 41, 72, 34);
		this.add(btnTimKiem);
		
		textFieldTimKiem = new JTextField();
		textFieldTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTimKiem.setBorder(null);
		textFieldTimKiem.setBackground(new Color(227, 227, 227));
		textFieldTimKiem.setBounds(466, 42, 147, 32);
		this.add(textFieldTimKiem);
		textFieldTimKiem.setColumns(10);
		
		JButton btnThem = new JButton("Thêm phim");
		btnThem.setForeground(new Color(85, 173, 183));
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnThem.setBackground(new Color(240, 240, 240));
		btnThem.setFont(new Font("Roboto", Font.BOLD, 14));
		btnThem.setBounds(187, 388, 108, 39);
		this.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa phim");
		btnXoa.setForeground(new Color(85, 173, 183));
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setBackground(new Color(240, 240, 240));
		btnXoa.setFont(new Font("Roboto", Font.BOLD, 14));
		btnXoa.setBounds(352, 388, 108, 39);
		this.add(btnXoa);
		
		JButton btnSua = new JButton("Chỉnh sửa");
		btnSua.setForeground(new Color(85, 173, 183));
		btnSua.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSua.setBackground(new Color(240, 240, 240));
		btnSua.setFont(new Font("Roboto", Font.BOLD, 14));
		btnSua.setBounds(516, 388, 108, 39);
		this.add(btnSua);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(194, 254, 224));
		panel.setBounds(0, 0, 808, 29);
		add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("DANH SÁCH PHIM");
		lblNewLabel_5.setBounds(22, 5, 603, 20);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setBackground(new Color(71, 141, 141));
		lblNewLabel_5.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("D:\\eclipse\\DoAnJavaNangCao2\\src\\image\\pngwing.com (14).png")));
		lblNewLabel_5.setForeground(new Color(81, 171, 181));
		lblNewLabel_5.setBorder(null);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
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
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(79);
		table.getColumnModel().getColumn(1).setPreferredWidth(119);
		table.getColumnModel().getColumn(2).setPreferredWidth(65);
		table.getColumnModel().getColumn(3).setPreferredWidth(62);
		table.getColumnModel().getColumn(4).setPreferredWidth(93);
		table.getColumnModel().getColumn(5).setPreferredWidth(72);
		table.getColumnModel().getColumn(6).setPreferredWidth(67);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 84, 779, 143);
		this.add(scrollPane);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 237, 769, 2);
		add(separator);
		
		JLabel lblNewLabel_6_1 = new JLabel("Mã phim");
		lblNewLabel_6_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1.setBounds(86, 249, 91, 24);
		add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Quốc gia");
		lblNewLabel_6_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_1.setBounds(86, 339, 91, 24);
		add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("Tên phim");
		lblNewLabel_6_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_2.setBounds(86, 279, 91, 24);
		add(lblNewLabel_6_1_2);
		
		JLabel lblNewLabel_6_1_3 = new JLabel("Thời lượng");
		lblNewLabel_6_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_3.setBounds(86, 309, 91, 24);
		add(lblNewLabel_6_1_3);
		
		textFieldMaPhim = new JTextField();
		textFieldMaPhim.setBounds(187, 249, 142, 24);
		add(textFieldMaPhim);
		textFieldMaPhim.setColumns(10);
		
		textFieldTenPhim = new JTextField();
		textFieldTenPhim.setColumns(10);
		textFieldTenPhim.setBounds(187, 279, 142, 24);
		add(textFieldTenPhim);
		
		textFieldThoiLuong = new JTextField();
		textFieldThoiLuong.setColumns(10);
		textFieldThoiLuong.setBounds(187, 309, 142, 24);
		add(textFieldThoiLuong);
		
		textFieldQuocGia = new JTextField();
		textFieldQuocGia.setColumns(10);
		textFieldQuocGia.setBounds(187, 339, 142, 24);
		add(textFieldQuocGia);
		
		JLabel lblNewLabel_6_1_4 = new JLabel("Năm sản xuất");
		lblNewLabel_6_1_4.setForeground(Color.BLACK);
		lblNewLabel_6_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_4.setBounds(413, 276, 91, 27);
		add(lblNewLabel_6_1_4);
		
		JLabel lblNewLabel_6_1_2_1 = new JLabel("Độ tuổi");
		lblNewLabel_6_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_6_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_2_1.setBounds(413, 309, 91, 24);
		add(lblNewLabel_6_1_2_1);
		
		JLabel lblNewLabel_6_1_3_1 = new JLabel("Thể loại");
		lblNewLabel_6_1_3_1.setForeground(Color.BLACK);
		lblNewLabel_6_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_3_1.setBounds(413, 339, 91, 26);
		add(lblNewLabel_6_1_3_1);
		
		textFieldNamSanXuat = new JTextField();
		textFieldNamSanXuat.setColumns(10);
		textFieldNamSanXuat.setBounds(532, 279, 142, 24);
		add(textFieldNamSanXuat);
		
		textFieldDoTuoi = new JTextField();
		textFieldDoTuoi.setColumns(10);
		textFieldDoTuoi.setBounds(532, 309, 142, 24);
		add(textFieldDoTuoi);
		
		textFieldDaoDien = new JTextField();
		textFieldDaoDien.setColumns(10);
		textFieldDaoDien.setBounds(532, 249, 142, 24);
		add(textFieldDaoDien);
		
		JLabel lblNewLabel_6_1_3_1_1 = new JLabel("Đạo diễn");
		lblNewLabel_6_1_3_1_1.setForeground(Color.BLACK);
		lblNewLabel_6_1_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_3_1_1.setBounds(413, 249, 91, 24);
		add(lblNewLabel_6_1_3_1_1);
		
		JButton btnHyTm = new JButton("Hủy tìm");
		btnHyTm.setForeground(new Color(87, 171, 181));
		btnHyTm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnHyTm.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnHyTm.setBackground(new Color(240, 240, 240));
		btnHyTm.setBounds(717, 41, 72, 34);
		add(btnHyTm);
		
		JLabel lblNewLabel_6_1_2_2 = new JLabel("Tên phim:");
		lblNewLabel_6_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_6_1_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_2_2.setBounds(388, 43, 72, 30);
		add(lblNewLabel_6_1_2_2);
		
		JComboBox comboBoxTheLoai = new JComboBox();
		comboBoxTheLoai.setBounds(532, 342, 142, 21);
		add(comboBoxTheLoai);
		
		
		

		
	}
}
