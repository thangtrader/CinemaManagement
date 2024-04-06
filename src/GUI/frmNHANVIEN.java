package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import quanlyrapphim.frmQuanLyRapPhim;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class frmNHANVIEN extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldTimKiem;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public frmNHANVIEN() {
		setLayout(null);
		
		JComboBox comboBoxTrangThai = new JComboBox();
		comboBoxTrangThai.setBounds(132, 22, 107, 21);
		add(comboBoxTrangThai);
		
		JComboBox comboBoxSapXep = new JComboBox();
		comboBoxSapXep.setBounds(516, 22, 117, 21);
		add(comboBoxSapXep);
		
		JComboBox comboBoxTimKiem = new JComboBox();
		comboBoxTimKiem.setBounds(614, 56, 112, 21);
		add(comboBoxTimKiem);
		
		textFieldTimKiem = new JTextField();
		textFieldTimKiem.setBackground(new Color(240, 240, 240));
		textFieldTimKiem.setBounds(396, 23, 101, 19);
		add(textFieldTimKiem);
		textFieldTimKiem.setColumns(10);
		
		JLabel lblDanhSchNhn = new JLabel("Danh sách nhân viên");
		lblDanhSchNhn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDanhSchNhn.setBounds(21, 55, 117, 21);
		add(lblDanhSchNhn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 86, 767, 267);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "T\u00EAn ch\u00EDnh s\u00E1ch", "T\u00EAn ch\u1EE9c v\u1EE5"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(84);
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		table.getColumnModel().getColumn(2).setPreferredWidth(81);
		table.getColumnModel().getColumn(3).setPreferredWidth(61);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setPreferredWidth(114);
		table.getColumnModel().getColumn(6).setPreferredWidth(119);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JButton btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setBackground(new Color(255, 165, 0));
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXemChiTiet.setIcon(new ImageIcon(frmNHANVIEN.class.getResource("/image/find.png")));
		btnXemChiTiet.setBounds(104, 376, 135, 34);
		add(btnXemChiTiet);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(255, 147, 150));
		btnXoa.setIcon(new ImageIcon(frmNHANVIEN.class.getResource("/image/x.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setBounds(338, 376, 85, 34);
		add(btnXoa);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(192, 192, 192));
		btnThem.setIcon(new ImageIcon(frmNHANVIEN.class.getResource("/image/them.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBounds(516, 376, 85, 34);
		add(btnThem);
		
		JButton btnTrangThai = new JButton("Trạng thái");
		btnTrangThai.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTrangThai.setBackground(new Color(0, 255, 255));
		btnTrangThai.setBounds(21, 19, 93, 24);
		add(btnTrangThai);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(frmNHANVIEN.class.getResource("/image/find.png")));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTimKiem.setBackground(Color.CYAN);
		btnTimKiem.setBounds(269, 20, 107, 24);
		add(btnTimKiem);
		
		JButton btnSapXep = new JButton("Sắp xếp");
		btnSapXep.setIcon(new ImageIcon(frmNHANVIEN.class.getResource("/image/sapxep.png")));
		btnSapXep.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSapXep.setBackground(Color.CYAN);
		btnSapXep.setBounds(490, 53, 103, 24);
		add(btnSapXep);

	}
}
