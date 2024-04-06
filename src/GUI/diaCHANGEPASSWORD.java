package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Color;

public class diaCHANGEPASSWORD extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMatKhauCu;
	private JTextField textFieldMatKhauMoi;
	private JTextField textFieldMatKhauMoiAgain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			diaCHANGEPASSWORD dialog = new diaCHANGEPASSWORD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public diaCHANGEPASSWORD() {
		setBounds(250, 200, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbMatKhauCu = new JLabel("MẬT KHẨU CŨ");
		lbMatKhauCu.setHorizontalAlignment(SwingConstants.LEFT);
		lbMatKhauCu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbMatKhauCu.setBounds(52, 81, 108, 22);
		contentPanel.add(lbMatKhauCu);
		
		JLabel lbMatKhauMoi = new JLabel("MẬT KHẨU MỚI");
		lbMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbMatKhauMoi.setBounds(52, 121, 108, 22);
		contentPanel.add(lbMatKhauMoi);
		
		JLabel lbMatKhauMoiAgain = new JLabel("XÁC NHẬN LẠI MẬT KHẨU");
		lbMatKhauMoiAgain.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbMatKhauMoiAgain.setBounds(52, 161, 150, 22);
		contentPanel.add(lbMatKhauMoiAgain);
		
		textFieldMatKhauCu = new JTextField();
		textFieldMatKhauCu.setToolTipText("");
		textFieldMatKhauCu.setBounds(228, 80, 150, 28);
		contentPanel.add(textFieldMatKhauCu);
		textFieldMatKhauCu.setColumns(10);
		
		textFieldMatKhauMoi = new JTextField();
		textFieldMatKhauMoi.setColumns(10);
		textFieldMatKhauMoi.setBounds(228, 120, 150, 28);
		contentPanel.add(textFieldMatKhauMoi);
		
		textFieldMatKhauMoiAgain = new JTextField();
		textFieldMatKhauMoiAgain.setColumns(10);
		textFieldMatKhauMoiAgain.setBounds(228, 160, 150, 28);
		contentPanel.add(textFieldMatKhauMoiAgain);
		
		JLabel lbDoiMatKhau = new JLabel("ĐỔI MẬT KHẨU");
		lbDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbDoiMatKhau.setForeground(new Color(0, 0, 0));
		lbDoiMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lbDoiMatKhau.setBounds(115, 22, 184, 28);
		contentPanel.add(lbDoiMatKhau);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 209, 436, 31);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton btnSave = new JButton("LƯU");
				btnSave.setBounds(228, 5, 62, 25);
				btnSave.setForeground(new Color(255, 255, 255));
				btnSave.setBackground(new Color(62, 177, 52));
				btnSave.setFont(new Font("Tahoma", Font.BOLD, 10));
				btnSave.setActionCommand("LƯU");
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			{
				JButton btnCancel = new JButton("CANCEL");
				btnCancel.setForeground(new Color(255, 255, 255));
				btnCancel.setBounds(300, 5, 77, 25);
				btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
				btnCancel.setBackground(new Color(210, 28, 32));
				btnCancel.setActionCommand("CANCEL");
				buttonPane.add(btnCancel);
			}
		}
	}
}
