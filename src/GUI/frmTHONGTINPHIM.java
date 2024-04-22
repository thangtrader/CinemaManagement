package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
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
import Business_Logic.PhimBLL;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class frmTHONGTINPHIM extends JPanel implements ActionListener {
	

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private PhimBLL phimBLL;
    GUI.frmThemThongTinPhim themphim;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JLabel lbRegex;
	private JLabel lbRegexTen;
	private JLabel lbRegexThoiLuong;
	private JLabel lbRegexQuocGia;
	private JLabel lbRegexTuoi;
	private JTextField textFieldTimKiem;

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
		btnThem.setBounds(94, 403, 108, 39);
		this.add(btnThem);
		
		btnXoa = new JButton("Xóa phim");
		btnXoa.setForeground(new Color(85, 173, 183));
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		btnXoa.setBackground(new Color(240, 240, 240));
		btnXoa.setFont(new Font("Roboto", Font.BOLD, 14));
		btnXoa.setBounds(329, 403, 108, 39);
		this.add(btnXoa);
		
		btnSua = new JButton("Chỉnh sửa");
		btnSua.setForeground(new Color(85, 173, 183));
		btnSua.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSua.setBackground(new Color(240, 240, 240));
		btnSua.setFont(new Font("Roboto", Font.BOLD, 14));
		btnSua.setBounds(555, 403, 108, 39);
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
		scrollPane.setBounds(10, 84, 796, 294);
		this.add(scrollPane);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 237, 769, 2);
		add(separator);
		
		JLabel lblNewLabel_6_1_2_2 = new JLabel("Tìm kiếm:");
		lblNewLabel_6_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_6_1_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1_2_2.setBounds(388, 43, 72, 30);
		add(lblNewLabel_6_1_2_2);
        
        lbRegex = new JLabel("");
        lbRegex.setBounds(123, 365, 142, 13);
        add(lbRegex);
        
        lbRegexTen = new JLabel("");
        lbRegexTen.setBounds(251, 286, 152, 19);
        add(lbRegexTen);
        
        lbRegexThoiLuong = new JLabel("");
        lbRegexThoiLuong.setBounds(251, 320, 134, 13);
        add(lbRegexThoiLuong);
        
        lbRegexQuocGia = new JLabel("");
        lbRegexQuocGia.setBounds(261, 352, 142, 13);
        add(lbRegexQuocGia);
        
        lbRegexTuoi = new JLabel("");
        lbRegexTuoi.setBounds(672, 316, 117, 13);
        add(lbRegexTuoi);
        
        
        phimBLL = new Business_Logic.PhimBLL();
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);

        LoadPhim();
	}
	
	public void LoadPhim() {
		model =  (DefaultTableModel) table.getModel();
		model.setRowCount(0);
	    
		for (ENTITY.PhimViewDTO phimview : phimBLL.LoadPhim()) {
			model.addRow(new Object[]{phimview.getMaPhim(), phimview.getTenPhim(), phimview.getThoiLuong(), phimview.getQuocGia(), phimview.getDaoDien(), phimview.getNamSanXuat(), phimview.getDoTuoiXem(), phimview.getTenTheLoai()});
		}
	}
	
    public int removeData() {
    	ENTITY.PhimViewDTO phimviewDTO = new ENTITY.PhimViewDTO();
        int selectedRow = table.getSelectedRow();
    	String maphim = table.getValueAt(selectedRow, 0).toString(); 
    	phimviewDTO.setMaPhim(maphim);
    	return phimBLL.removeData(phimviewDTO);
    }
	
    
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
    
	public String getPhim() {
		String maphim = null;
		int selectedRow = table.getSelectedRow();
        if (selectedRow != -1 && selectedRow < table.getRowCount()) {
        	maphim = table.getValueAt(selectedRow, 0).toString(); 
        } else {
        	JOptionPane.showMessageDialog(null, "Không có hàng nào được chọn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        return maphim;
	}
    
	public void actionPerformed(ActionEvent e) {
        	if (e.getSource() == btnThem) {
        		themphim = new frmThemThongTinPhim();
        		themphim.setVisible(true);
        		themphim.addWindowListener(new WindowAdapter() {
        		    @Override
        		    public void windowClosed(WindowEvent e) {
        		        LoadPhim();
        		    }
        		});
        	}
            if (e.getSource() == btnXoa) {
                int k = removeData();
                if(k==1) {
                	JOptionPane.showMessageDialog(null, "Đã xóa thông tin phim thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                	JOptionPane.showMessageDialog(null, "Xóa phim không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                LoadPhim();
            }
            if (e.getSource() == btnSua) {
            	int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {

                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng trước khi sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    themphim = new frmThemThongTinPhim(getPhim());
                    themphim.setVisible(true);
                    themphim.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            LoadPhim();
                        }
                    });
                }
            }
	}
}