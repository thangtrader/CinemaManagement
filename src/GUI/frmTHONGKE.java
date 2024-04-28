package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.GridLayout;
import javax.swing.JList;

public class frmTHONGKE extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel monthChooserPanel;
	private JPanel yearChooserPanel;
	private JPanel mainPanel;
	private GUI.panelTHONGKEPHIM panelTHONGKEPHIM;
	private GUI.panelTKNHANVIEN panelTKNHANVIEN;

	/**
	 * Create the panel.
	 */
	public frmTHONGKE() {
		setLayout(null);
		
		mainPanel = new JPanel(new CardLayout());
		mainPanel.setBounds(0, 52, 766, 373);
		add(mainPanel);
		
		panelTHONGKEPHIM = new GUI.panelTHONGKEPHIM();
		panelTKNHANVIEN = new GUI.panelTKNHANVIEN();
		
		
		mainPanel.add(panelTHONGKEPHIM, "panelTHONGKEPHIM");
		mainPanel.add(panelTKNHANVIEN, "panelTKNHANVIEN");
		add(mainPanel);
		
		JButton btnPhim = new JButton("Phim");
		btnPhim.setBackground(new Color(175, 238, 238));
		btnPhim.setForeground(new Color(0, 139, 139));
		btnPhim.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnPhim.setBounds(71, 10, 126, 32);
		btnPhim.setBorder(null);
		add(btnPhim);
		btnPhim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
				cardLayout.show(mainPanel, "panelTHONGKEPHIM");
				GUI.panelTHONGKEPHIM tkp = new panelTHONGKEPHIM();
			}
		});
		
		JButton btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setBackground(new Color(175, 238, 238));
		btnNhanVien.setForeground(new Color(0, 139, 139));
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNhanVien.setBounds(233, 10, 126, 32);
		btnNhanVien.setBorder(null);
		add(btnNhanVien);
		btnNhanVien.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
				cardLayout.show(mainPanel, "panelTKNHANVIEN");
			}
		});
	}
}
