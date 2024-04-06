package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class panelTHONGKEPHIM extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public panelTHONGKEPHIM() {
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 10, 707, 300);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 phim", "T\u00EAn phim", "Th\u1EC3 lo\u1EA1i", "S\u1ED1 l\u01B0\u1EE3ng v\u00E9", "Doanh thu"
			}
		));
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Tổng doanh thu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(427, 320, 123, 22);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tháng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(70, 321, 55, 20);
		add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(135, 320, 38, 21);
		add(comboBox);
		
		JLabel lbDoanhThu = new JLabel("tổng cột doanh thu");
		lbDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbDoanhThu.setBounds(561, 320, 144, 22);
		add(lbDoanhThu);
		for(int i =1;i<=12;i++) {
			comboBox.addItem(i);
		}
	}
}
