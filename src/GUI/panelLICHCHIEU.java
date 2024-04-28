package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Business_Logic.LichChieuBLL;

import Process_Data.LichChieuDAL;



public class panelLICHCHIEU extends JPanel implements ActionListener,ItemListener, MouseListener {

	private static final long serialVersionUID = 1L;
	public JTable table;
	private JButton btnCapNhat;
	private JButton btnXoa;
	public DefaultTableModel model;
    LichChieuBLL lichBLL;
    LichChieuDAL lichDAL;
	private diaCAPNHATLICHCHIEU capnhatlich;
	/**
	 * Create the panel.
	 */
	public panelLICHCHIEU() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setLayout(null);
		panel.setBounds(0, 0, 798, 415);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 0, 750, 327);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"T\u00EAn phim", "T\u00EAn ph\u00F2ng chi\u1EBFu","Ng\u00E0y chi\u1EBFu","Th\u1EDDi gian b\u1EAFt \u0111\u1EA7u", "Th\u1EDDi gian k\u1EBFt th\u00FAc", "Tr\u1EA1ng th\u00E1i"
				}
			));
		table.setFillsViewportHeight(true);
		table.setRowHeight(25);
//		table.setColumnSelectionAllowed(true);
//		table.setCellSelectionEnabled(true);
		
		scrollPane.setViewportView(table);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setForeground(new Color(32, 178, 170));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhat.setBackground(new Color(248, 248, 255));
		btnCapNhat.setBounds(259, 337, 112, 36);
		btnCapNhat.addActionListener(this);
		panel.add(btnCapNhat);
		
		btnXoa = new JButton("Xóa Lịch");
		btnXoa.setForeground(new Color(32, 178, 170));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBackground(new Color(248, 248, 255));
		btnXoa.setBounds(420, 337, 112, 36);
		btnXoa.addActionListener(this);
		panel.add(btnXoa);
		
		lichBLL = new Business_Logic.LichChieuBLL();
        lichDAL = new Process_Data.LichChieuDAL(this);
        table.addMouseListener(this);
        LoadLichChieu();
 
	}
//  public void LoadLichChieu() {
//	guiLichChieu.model = (DefaultTableModel) guiLichChieu.table.getModel();
//    for (int i = guiLichChieu.model.getRowCount() - 1; i >= 0; i--) {
//    	guiLichChieu.model.removeRow(i);
//    }
//    for (ENTITY.LICHCHIEUDTO lich : lichDAL.ListLichChieu()) {
//    	guiLichChieu.model.addRow(new Object[]{lich.getTenPhim(), lich.getTenPhong(), lich.getNgayChieu(),lich.getThoiGianBatDau(),lich.getThoiGianKetThuc(),lich.getTenTinhTrang()});
//    }
//}
	public void LoadLichChieu() {
		model =  (DefaultTableModel) table.getModel();
		model.setRowCount(0);
	    
		for (ENTITY.LICHCHIEUVIEWDTO lich : lichBLL.LoadLichChieu()) {
			model.addRow(new Object[]{lich.getTenPhim(), lich.getTenPhong(), lich.getNgayChieu(),lich.getThoiGianBatDau(),lich.getThoiGianKetThuc(),lich.getTenTinhTrang()});
		}
	}
    public int removeData() {
    	ENTITY.LICHCHIEUVIEWDTO lichchieuDTO = new ENTITY.LICHCHIEUVIEWDTO();
        int selectedRow = table.getSelectedRow();
        String tenphim = table.getValueAt(selectedRow, 0).toString();
        String tenphongchieu = table.getValueAt(selectedRow, 1).toString();
        String ngaychieuString = table.getValueAt(selectedRow, 2).toString();
        String thoigianbatdauString = table.getValueAt(selectedRow, 3).toString();

        // Chuyển đổi ngày từ chuỗi sang Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaychieu = null;
        try {
            ngaychieu = dateFormat.parse(ngaychieuString);
        } catch (ParseException e) {
            // Xử lý ngoại lệ khi không thể chuyển đổi ngày
            e.printStackTrace();
        }

        // Chuyển đổi thời gian từ chuỗi sang Time
        Time thoigianbatdau = Time.valueOf(thoigianbatdauString);
    	
    	lichchieuDTO.setTenPhim(tenphim);
    	lichchieuDTO.setTenPhong(tenphongchieu);
    	lichchieuDTO.setNgayChieu(ngaychieu);
    	lichchieuDTO.setThoiGianBatDau(thoigianbatdau);
    	return lichBLL.removeData(lichchieuDTO);
    }

	public String gettenphim() {
	String tenphim = null;
	int selectedRow = table.getSelectedRow();
    if (selectedRow != -1 && selectedRow < table.getRowCount()) {
    	tenphim = table.getValueAt(selectedRow, 0).toString(); 
    } else {
    	JOptionPane.showMessageDialog(null, "Không có hàng nào được chọn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    return tenphim;
}

	public String gettenphong() {
	String tenphong = null;
	int selectedRow = table.getSelectedRow();
    if (selectedRow != -1 && selectedRow < table.getRowCount()) {
    	tenphong = table.getValueAt(selectedRow, 1).toString(); 
    } else {
    	JOptionPane.showMessageDialog(null, "Không có hàng nào được chọn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    return tenphong;
}
    public String getLich() {
        String Ngaychieu = null;
        
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1 && selectedRow < table.getRowCount()) {
            Ngaychieu = table.getValueAt(selectedRow, 2).toString();
        } else {
            JOptionPane.showMessageDialog(null, "Không có hàng nào được chọn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        return Ngaychieu;
    }
	public String getTGBD() {
	String TGBD = null;
	int selectedRow = table.getSelectedRow();
    if (selectedRow != -1 && selectedRow < table.getRowCount()) {
    	TGBD = table.getValueAt(selectedRow, 3).toString(); 
    } else {
    	JOptionPane.showMessageDialog(null, "Không có hàng nào được chọn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    return TGBD;
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stubq13
		int selectedRow = table.getSelectedRow();
		
        if (e.getSource() == btnXoa) {
            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng trước khi xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
            int k = removeData();
            if(k==1) {
            	JOptionPane.showMessageDialog(null, "Đã xóa lịch thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
            	JOptionPane.showMessageDialog(null, "Xóa lịch không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            LoadLichChieu();
            }
		}
        if (e.getSource() == btnCapNhat) {
        
            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng trước khi sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
            	capnhatlich = new diaCAPNHATLICHCHIEU(gettenphim(),gettenphong(),getLich(), getTGBD());
            	capnhatlich.setVisible(true);
            	capnhatlich.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                    	LoadLichChieu();
                    }
                });
            }
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}