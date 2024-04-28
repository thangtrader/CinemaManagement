package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Business_Logic.TKNhanVienBBL;
import Process_Data.TKNhanVienDAL;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class panelTKNHANVIEN extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTable table;
    public DefaultTableModel model;
    TKNhanVienDAL tknvDAL;
    TKNhanVienBBL tknvBLL;
	public JLabel lbLuong,top1,top2,top3,top4,top5;

	public panelTKNHANVIEN() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 10, 526, 323);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "Gi\u1EDBi t\u00EDnh", "S\u1ED1 gi\u1EDD l\u00E0m", "L\u01B0\u01A1ng"
			}
		));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("TOP NHÂN VIÊN XUẤT SẮC");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(570,34,320, 46);
		add(lblNewLabel);
		
		top1 = new JLabel("");
		top1.setForeground(new Color(0, 0, 0));
		top1.setFont(new Font("Tahoma", Font.BOLD, 12));
		top1.setBounds(622, 90, 132, 22);
		add(top1);
		
		top2 = new JLabel("New label");
		top2.setForeground(Color.BLACK);
		top2.setFont(new Font("Tahoma", Font.BOLD, 12));
		top2.setBounds(622, 120, 132, 22);
		add(top2);
		
		top3 = new JLabel("New label");
		top3.setForeground(Color.BLACK);
		top3.setFont(new Font("Tahoma", Font.BOLD, 12));
		top3.setBounds(622, 150, 132, 22);
		add(top3);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng lương:");
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(367, 343, 80, 22);
		add(lblNewLabel_1);
		
		lbLuong = new JLabel("");
		lbLuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbLuong.setBounds(468, 343, 101, 22);
		add(lbLuong);
		
		top4 = new JLabel("New label");
		top4.setForeground(Color.BLACK);
		top4.setFont(new Font("Tahoma", Font.BOLD, 12));
		top4.setBounds(622, 180, 132, 22);
		add(top4);
		
		top5 = new JLabel("New label");
		top5.setForeground(Color.BLACK);
		top5.setFont(new Font("Tahoma", Font.BOLD, 12));
		top5.setBounds(622, 210, 132, 22);
		add(top5);
	
		tknvBLL = new Business_Logic.TKNhanVienBBL();
		loadTableData();
        updateTotalSalaryLabel();
        updateTopEmployees();
	}
	private void loadTableData() {
		model =  (DefaultTableModel) table.getModel();
		model.setRowCount(0);
	    
		for (ENTITY.TKNHANVIEN tknv : tknvBLL.LoadNhanVien()) {
			model.addRow(new Object[]{tknv.getMaNhanVien(), tknv.getTenNhanVien(), tknv.getGioiTinh(), tknv.getSogiolam(), tknv.getTongtien()});
		}
    }
    private void updateTotalSalaryLabel() {
        TKNhanVienBBL bbl = new TKNhanVienBBL();
        bbl.UpdateTongLuongLabel(lbLuong);
    }
    private void updateTopEmployees() {
        TKNhanVienBBL bbl = new TKNhanVienBBL();
        JLabel[] topLabels = {top1, top2, top3, top4, top5};
        bbl.UpdateTop5(topLabels);
    }
}
