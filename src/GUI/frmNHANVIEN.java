package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Business_Logic.NhanVienBLL;
import Process_Data.NhanVienDAL;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class frmNHANVIEN extends JPanel implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldTimKiem;
	public JTable table;
    public DefaultTableModel model;
    NhanVienBLL nvBLL;
    NhanVienDAL nvDAL;
	public JButton btnThem;
	public JButton btnXemChiTiet;
	private JButton btnTimKiem;
	private JButton btnXoa;
	GUI.frmThemNhanVien themnv;
	private JComboBox comboBoxSapXep;
	/**
	 * Create the panel.
	 */
	public frmNHANVIEN() {
		
		setLayout(null);
		
		comboBoxSapXep = new JComboBox();
		comboBoxSapXep.setBounds(472, 22, 101, 21);
		add(comboBoxSapXep);
		
		textFieldTimKiem = new JTextField();
		textFieldTimKiem.setBackground(new Color(240, 240, 240));
		textFieldTimKiem.setBounds(596, 23, 101, 19);
		add(textFieldTimKiem);
		textFieldTimKiem.setColumns(10);
		
		JLabel lblDanhSchNhn = new JLabel("Danh sách nhân viên");
		lblDanhSchNhn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDanhSchNhn.setBounds(21, 21, 117, 21);
		add(lblDanhSchNhn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 54, 767, 299);
		add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "T\u00EAn ch\u00EDnh s\u00E1ch", "T\u00EAn ch\u1EE9c v\u1EE5"
			}
			) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(84);
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		table.getColumnModel().getColumn(2).setPreferredWidth(81);
		table.getColumnModel().getColumn(3).setPreferredWidth(61);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setPreferredWidth(114);
		table.getColumnModel().getColumn(6).setPreferredWidth(119);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setBackground(new Color(255, 165, 0));
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXemChiTiet.setIcon(new ImageIcon(frmNHANVIEN.class.getResource("/image/find.png")));
		btnXemChiTiet.setBounds(104, 376, 135, 34);
		add(btnXemChiTiet);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(255, 147, 150));
		btnXoa.setIcon(new ImageIcon(frmNHANVIEN.class.getResource("/image/x.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setBounds(338, 376, 85, 34);
		add(btnXoa);
		
		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(192, 192, 192));
		btnThem.setIcon(new ImageIcon(frmNHANVIEN.class.getResource("/image/them.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBounds(516, 376, 85, 34);
		add(btnThem);
		
		btnTimKiem = new JButton("");
		btnTimKiem.setIcon(new ImageIcon(frmNHANVIEN.class.getResource("/image/find.png")));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTimKiem.setBackground(Color.CYAN);
		btnTimKiem.setBounds(697, 22, 27, 21);
		add(btnTimKiem);
		
        nvBLL = new Business_Logic.NhanVienBLL();
        nvDAL = new Process_Data.NhanVienDAL();
        btnThem.addActionListener(this);
        btnXoa.addActionListener(this);
        btnXemChiTiet.addActionListener(this);
        LoadNhanVien();
	}
	
	
    public int removeData() {
    	ENTITY.NhanVienViewDTO nvviewDTO = new ENTITY.NhanVienViewDTO();
        int selectedRow = table.getSelectedRow();
    	String manv = table.getValueAt(selectedRow, 0).toString(); 
    	nvviewDTO.setMaNhanVien(manv);
    	return nvBLL.removeData(nvviewDTO);
    }
	
	public String getMaNhanVien() {
		String manv = null;
		int selectedRow = table.getSelectedRow();
        if (selectedRow != -1 && selectedRow < table.getRowCount()) {
            manv = table.getValueAt(selectedRow, 0).toString(); 
        } else {
            System.out.println("Không có hàng nào được chọn.");
        }
        return manv;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
    		themnv = new frmThemNhanVien(getMaNhanVien());
    		themnv.setVisible(true);
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
	
	public void LoadNhanVien() {
	    model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);

	    for (ENTITY.NhanVienViewDTO nvview : nvBLL.LoadNhanVien()) { 
	        model.addRow(new Object[]{nvview.getMaNhanVien(), nvview.getTenNhanVien(), nvview.getNgaySinh(), nvview.getGioiTinh(), nvview.getSdt(), nvview.getTenChinhSach(), nvview.getTenChucVu()});
	    }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnThem) {
    		themnv = new frmThemNhanVien();
    		themnv.setVisible(true);
    		themnv.addWindowListener(new WindowAdapter() {
    		    @Override
    		    public void windowClosed(WindowEvent e) {
    		        LoadNhanVien();
    		    }
    		});
    	}
        if (e.getSource() == btnXoa) {
            int k = this.removeData();
            if(k==1) {
            	JOptionPane.showMessageDialog(null, "Đã xóa thông tin phim thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
            	JOptionPane.showMessageDialog(null, "Xóa phim không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            	LoadNhanVien();
        }
        if (e.getSource() == btnXemChiTiet) {
        	if (table.getSelectedRowCount() == 1) {
                themnv = new frmThemNhanVien(getMaNhanVien());
        		themnv.addWindowListener(new WindowAdapter() {
        		    @Override
        		    public void windowClosed(WindowEvent e) {
        		        LoadNhanVien();
        		    }
        		});
                themnv.setVisible(true);
            } else if (table.getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên muốn xem chi tiết", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else if (table.getSelectedRowCount() > 1) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhân viên muốn xem chi tiết", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
	}
}
