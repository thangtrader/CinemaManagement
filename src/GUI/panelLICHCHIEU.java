package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelLICHCHIEU extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnCapNhat;
	private JButton btnXoa;

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
					"M\u00E3 phim", "M\u00E3 ph\u00F2ng chi\u1EBFu", "M\u00E3 khung gi\u1EDD chi\u1EBFu", "Ng\u00E0y chi\u1EBFu", "Tr\u1EA1ng th\u00E1i"
				}
			));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setForeground(new Color(32, 178, 170));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhat.setBackground(new Color(248, 248, 255));
		btnCapNhat.setBounds(259, 337, 112, 36);
		btnCapNhat.addActionListener(this);
		panel.add(btnCapNhat);
		
		btnXoa = new JButton("Xóa phim");
		btnXoa.setForeground(new Color(32, 178, 170));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBackground(new Color(248, 248, 255));
		btnXoa.setBounds(420, 337, 112, 36);
		btnXoa.addActionListener(this);
		panel.add(btnXoa);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnCapNhat) {
			diaCAPNHATLICHCHIEU fm = new diaCAPNHATLICHCHIEU();
			fm.show();
		}else if(e.getSource() == btnXoa) {

		}
	}

}
