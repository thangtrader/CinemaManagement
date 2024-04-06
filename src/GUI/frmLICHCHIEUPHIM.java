package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class frmLICHCHIEUPHIM extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	public JButton btnTaoLichChieu;
	public JButton btnLichChieu;
	public JPanel panelMain;
	public panelLICHCHIEU panelLICHCHIEU;
	private panelTHEMLICHCHIEU panelTAOLICH;
	private JPanel mainPanel;

	/**
	 * Create the panel.
	 */
	public frmLICHCHIEUPHIM() {
		setBackground(new Color(230, 243, 240));
		setLayout(null);

		mainPanel = new JPanel(new CardLayout());
		mainPanel.setBounds(0, 46, 804, 414);
		add(mainPanel);
		
		panelLICHCHIEU = new GUI.panelLICHCHIEU();
		panelLICHCHIEU.setBackground(new Color(240, 240, 240));
		panelTAOLICH = new GUI.panelTHEMLICHCHIEU();
		
		
		mainPanel.add(panelLICHCHIEU, "panelLICHCHIEU");
		mainPanel.add(panelTAOLICH, "panelTAOLICH");

		btnLichChieu = new JButton("Lịch chiếu phim");
		btnLichChieu.setBackground(new Color(248, 248, 255));
		btnLichChieu.setForeground(new Color(32, 178, 170));
		btnLichChieu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnLichChieu.setBounds(28, 8, 141, 28);
		btnLichChieu.setBorder(null);
		btnLichChieu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
				cardLayout.show(mainPanel, "panelLICHCHIEU");
			}
		});
		
		btnTaoLichChieu = new JButton("Tạo lịch chiếu");
		btnTaoLichChieu.setBackground(new Color(248, 248, 255));
		btnTaoLichChieu.setForeground(new Color(32, 178, 170));
		btnTaoLichChieu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnTaoLichChieu.setBounds(198, 8, 115, 28);
		btnTaoLichChieu.setBorder(null);
		btnTaoLichChieu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
				cardLayout.show(mainPanel, "panelTAOLICH");
			}
		});
		
		add(btnTaoLichChieu);
		add(btnLichChieu);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
