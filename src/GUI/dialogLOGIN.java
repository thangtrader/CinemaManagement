package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Business_Logic.NhanVienBLL;
import quanlyrapphim.frmQuanLyPhim;
import quanlyrapphim.frmQuanLyRapPhim;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dialogLOGIN extends JDialog {

	private static final long serialVersionUID = 1L;
	public JTextField textFieldUser;
	public JTextField  textFieldPassword;
	public quanlyrapphim.frmQuanLyPhim mainForm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialogLOGIN dialog = new dialogLOGIN();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dialogLOGIN() {
		setTitle("Đăng nhập");
		setAutoRequestFocus(false);
		setBounds(250, 220, 368, 251);
		getContentPane().setLayout(null);
		
		textFieldUser = new JTextField();
		textFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldUser.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldUser.setColumns(10);
		textFieldUser.setBounds(117, 71, 158, 30);
		getContentPane().add(textFieldUser);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(117, 118, 158, 30);
		getContentPane().add(textFieldPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(159, 184, 185));
		btnLogin.setBorder(null);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!textFieldPassword.getText().equals("") && !textFieldUser.getText().equals("")) {
				    int result = NhanVienBLL.getInstance().KiemTraDangNhap(textFieldUser.getText(), textFieldPassword.getText());
				    System.out.println(result);
				    if (result == 0)
				        JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu! Vui lòng kiểm tra lại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				    if (result == -1)
				        JOptionPane.showMessageDialog(null, "Tài khoản chưa tồn tại! Vui lòng kiểm tra lại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				    if (result == -2)
				        JOptionPane.showMessageDialog(null, "Tài khoản này đã bị khóa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//				    if (result == 3) {
//				        FrmDashboardAD frmDashboardAD = new FrmDashboardAD(NhanVienBLL.getInstance().GetNhanVienByTenTaiKhoan(txtTenTaiKhoan.getText()));
//				        frmDashboardAD.setVisible(true);
//				    }
				    if (result == 2) {
				    	
				    	mainForm= new frmQuanLyPhim();
				    	mainForm.setVisible(true);
				    	
				    }
//				    if (result > 0) {
//				        this.setVisible(false);
//				    }
				}
	        }
		});
//		btnLogin.setActionCommand("OK");
		btnLogin.setBounds(153, 158, 70, 31);
		getContentPane().add(btnLogin);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon(dialogLOGIN.class.getResource("/image/pngwing.com (9).png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setEnabled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(238, 238, 238));
		btnNewButton.setBounds(67, 61, 40, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setIcon(new ImageIcon(dialogLOGIN.class.getResource("/image/lock.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(238, 238, 238));
		btnNewButton_1.setBounds(67, 111, 40, 40);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 22));
		lblNewLabel.setBounds(145, 26, 91, 25);
		getContentPane().add(lblNewLabel);
	}
}
