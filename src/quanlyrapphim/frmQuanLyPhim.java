package quanlyrapphim;



import GUI.frmCANHAN;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.diaCHANGEPASSWORD;
import GUI.dialogLOGIN;



public class frmQuanLyPhim extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel mainPanel;
	private JPanel panelTHONGTINPHIM;
	private JPanel panelLICHCHIEUPHIM;
	private JPanel panelCANHAN;
	private JPanel panelTHONGKE;
	private JPanel panelNHANVIEN;
	private JPanel panel6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmQuanLyRapPhim frame = new frmQuanLyRapPhim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmQuanLyPhim() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setTitle("QUẢN LÝ RẠP PHIM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(938, 664);
        
        mainPanel = new JPanel(new CardLayout());
        mainPanel.setBounds(121, 60, 800, 441);
//        mainPanel.setBorder(null);

        panelTHONGTINPHIM = new GUI.frmTHONGTINPHIM();

        panelLICHCHIEUPHIM = new GUI.frmLICHCHIEUPHIM();
        
        panelCANHAN = new GUI.frmCANHAN();
//        
        panelTHONGKE = new GUI.frmTHONGKE();
        
        panelNHANVIEN = new GUI.frmNHANVIEN();
//
//        panel5 = new GUI.home();
//
//        panel6 = new GUI.doiMatKhau();
        
        mainPanel.add(panelTHONGTINPHIM, "panelTHONGTINPHIM");
        mainPanel.add(panelLICHCHIEUPHIM, "panelLICHCHIEUPHIM");
        mainPanel.add(panelTHONGKE, "panelTHONGKE");
        mainPanel.add(panelNHANVIEN, "panelNHANVIEN");
        mainPanel.add(panelCANHAN, "panelCANHAN");

        
        contentPane.setLayout(null);
        getContentPane().add(createMenuPanel());
        getContentPane().add(mainPanel);
        
        ImageIcon icon = new ImageIcon("image\\pngwing.com (1).png");
        JButton btnNewButton = new JButton(new ImageIcon(frmQuanLyRapPhim.class.getResource("/image/pngwing.com (1).png")));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setText("VIP CINEMA");
        btnNewButton.setBounds(0, 0, 921, 62);
        contentPane.add(btnNewButton);
        btnNewButton.setEnabled(false);
        //        btnNewButton.setBorder(null);
                btnNewButton.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 25));
                btnNewButton.setBackground(new Color(89, 89, 89));
        
	}
	private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel();
        menuPanel.setBorder(null);
        menuPanel.setBounds(0, 60, 121, 444);
        menuPanel.setForeground(new Color(255, 255, 255));
        menuPanel.setBackground(new Color(60, 123, 119));

        JButton button1 = new JButton("THÔNG TIN PHIM");
        button1.setForeground(new Color(255, 255, 255));
        button1.setBorder(null);
        button1.setBackground(new Color(60, 123, 119));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "panelTHONGTINPHIM");
            }
        });

        JButton button2 = new JButton("LỊCH CHIẾU PHIM");
        button2.setForeground(new Color(255, 255, 255));
        button2.setBackground(new Color(60, 123, 119));
        button2.setBorder(null);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "panelLICHCHIEUPHIM");
            }
        });
//        button2.setBackground(Color RED);

        JButton button3 = new JButton("CÁ NHÂN");
        button3.setForeground(new Color(255, 255, 255));
        button3.setBackground(new Color(60, 123, 119));
        button3.setBorder(null);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "panelCANHAN");
            }
        });
        JButton button4 = new JButton("THỐNG KÊ");
        button4.setForeground(new Color(255, 255, 255));
        button4.setBackground(new Color(60, 123, 119));
        button4.setBorder(null);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "panelTHONGKE");
            }
        });
        JButton button5 = new JButton("NHÂN VIÊN");
        button5.setForeground(new Color(255, 255, 255));
        button5.setBackground(new Color(60, 123, 119));
        button5.setBorder(null);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "panelNHANVIEN");
            }
        });

        JButton button7 = new JButton("ĐĂNG XUẤT");
        button7.setForeground(new Color(255, 255, 255));
        button7.setBackground(new Color(60, 123, 119));
        button7.setBorder(null);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	GUI.dialogLOGIN newFrame = new GUI.dialogLOGIN();
            	newFrame.show();
            }
        });
        
        menuPanel.setLayout(new GridLayout(0, 1, 0, 0));
        menuPanel.add(button1);
        menuPanel.add(button2);
        menuPanel.add(button4);
        menuPanel.add(button5);
        menuPanel.add(button3);
        menuPanel.add(button7);
        

        return menuPanel;
	}

}
