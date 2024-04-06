package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class panelTKNHANVIEN extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public panelTKNHANVIEN() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 10, 526, 323);
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
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("TOP");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(648, 34, 49, 46);
		add(lblNewLabel);
		
		JLabel top1 = new JLabel("Nguyễn Văn Toàn");
		top1.setForeground(new Color(0, 0, 0));
		top1.setFont(new Font("Tahoma", Font.BOLD, 12));
		top1.setBounds(622, 90, 132, 22);
		add(top1);
		
		JLabel top2 = new JLabel("New label");
		top2.setForeground(Color.BLACK);
		top2.setFont(new Font("Tahoma", Font.BOLD, 12));
		top2.setBounds(622, 120, 132, 22);
		add(top2);
		
		JLabel top3 = new JLabel("New label");
		top3.setForeground(Color.BLACK);
		top3.setFont(new Font("Tahoma", Font.BOLD, 12));
		top3.setBounds(622, 150, 132, 22);
		add(top3);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng lương:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(367, 343, 80, 22);
		add(lblNewLabel_1);
		
		JLabel lbLuong = new JLabel("tổng cột lương");
		lbLuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbLuong.setBounds(468, 343, 101, 22);
		add(lbLuong);
		
		JLabel top2_1 = new JLabel("New label");
		top2_1.setForeground(Color.BLACK);
		top2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		top2_1.setBounds(618, 180, 132, 22);
		add(top2_1);
		
		JLabel top2_2 = new JLabel("New label");
		top2_2.setForeground(Color.BLACK);
		top2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		top2_2.setBounds(618, 210, 132, 22);
		add(top2_2);

	}
}
