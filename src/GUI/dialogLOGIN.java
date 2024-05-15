package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Business_Logic.NhanVienBLL;
import quanlyrapphim.frmQuanLiNV;
import quanlyrapphim.frmQuanLyPhim;

public class dialogLOGIN extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;
    public JTextField textFieldUser;
    public JLabel lbAvatar;
    public JPasswordField textFieldPassword;
    private quanlyrapphim.frmQuanLyPhim mainForm;
    private quanlyrapphim.frmQuanLiNV nvForm;
    private frmCANHAN canhan;
    private NhanVienBLL nvBLL;
    private JButton btnLogin;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            dialogLOGIN dialog = new dialogLOGIN();
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
        setBounds(250, 220, 500, 306);
        getContentPane().setLayout(null);

        lbAvatar = new JLabel("");
        lbAvatar.setBackground(new Color(245, 245, 245));
        lbAvatar.setHorizontalAlignment(SwingConstants.CENTER);
        lbAvatar.setIcon(new ImageIcon(dialogLOGIN.class.getResource("/image/Khoa.png")));
        lbAvatar.setBounds(27, 25, 150, 200);
        add(lbAvatar);

        textFieldUser = new JTextField();
        textFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFieldUser.setHorizontalAlignment(SwingConstants.LEFT);
        textFieldUser.setColumns(10);
        textFieldUser.setBounds(252, 81, 158, 30);
        getContentPane().add(textFieldUser);

        textFieldPassword = new JPasswordField();
        textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFieldPassword.setHorizontalAlignment(SwingConstants.LEFT);
        textFieldPassword.setColumns(10);
        textFieldPassword.setBounds(252, 128, 158, 30);
        getContentPane().add(textFieldPassword);

        btnLogin = new JButton("LOGIN");
        btnLogin.setForeground(new Color(255, 235, 205));
        btnLogin.setBackground(new Color(32, 178, 170));
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnLogin.setBorder(null);
        btnLogin.setBounds(297, 168, 70, 31);
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
        btnNewButton.setBounds(202, 71, 40, 40);
        getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton();
        btnNewButton_1.setIcon(new ImageIcon(dialogLOGIN.class.getResource("/image/lock.png")));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setEnabled(false);
        btnNewButton_1.setBorder(null);
        btnNewButton_1.setBackground(new Color(238, 238, 238));
        btnNewButton_1.setBounds(202, 121, 40, 40);
        getContentPane().add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("LOGIN");
        lblNewLabel.setForeground(new Color(32, 178, 170));
        lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD, 22));
        lblNewLabel.setBounds(295, 36, 91, 25);
        getContentPane().add(lblNewLabel);
        btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            if (!new String(textFieldPassword.getPassword()).equals("") && !textFieldUser.getText().equals("")) {
                int result = NhanVienBLL.getInstance().KiemTraDangNhap(textFieldUser.getText(), new String(textFieldPassword.getPassword()));
                if (result == 0)
                    JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu! Vui lòng kiểm tra lại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                if (result == -1)
                    JOptionPane.showMessageDialog(null, "Tài khoản chưa tồn tại! Vui lòng kiểm tra lại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                if (result == -2)
                    JOptionPane.showMessageDialog(null, "Tài khoản này đã bị khóa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                if (result == 2) {
                    mainForm = new frmQuanLyPhim(textFieldUser.getText());
                    mainForm.setVisible(true);
                    this.dispose();
                }

                if (result == 1) {
                    nvForm = new frmQuanLiNV(textFieldUser.getText());
                    nvForm.setVisible(true);
                    this.dispose();
                }
            }
        }
    }
}