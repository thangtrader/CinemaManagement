package GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business_Logic.NhanVienBLL;
import Process_Data.NhanVienDAL;
import quanlyrapphim.frmQuanLyPhim;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;

public class dialogThemNhanVien extends JDialog implements ActionListener {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField txtTenNV;
	public JTextField txtNgaySinh;
	public JTextField txtGioiTinh;
	public JTextField txtDiaChi;
	public JTextField txtSDT;
	public JTextField txtCCCD;
	public JTextField txtTK;
	public JTextField txtMK;
	public JTextField txtTrangThai;
	public JComboBox cbboxChinhSach;
	public JComboBox cbboxChucVu;
	public JButton btnLuu;
	public JButton btnDong;
	NhanVienBLL nvBLL;
	NhanVienDAL nvDAL;
	GUI.frmNHANVIEN nv;
	frmQuanLyPhim qlp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialogThemNhanVien frame = new dialogThemNhanVien();
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
	public dialogThemNhanVien() {
//		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 447);
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Nhân viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(50, 37, 78, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(50, 85, 78, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày sinh:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(50, 136, 66, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(50, 183, 66, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Địa chỉ:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(50, 232, 66, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Số điện thoại:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(50, 277, 78, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Số CCCD:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(335, 37, 66, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tên tài khoản:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(335, 85, 84, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Mật khẩu:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(335, 136, 66, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Chính sách");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(335, 183, 84, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Chức vụ: ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(335, 232, 84, 13);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Trạng thái: ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(335, 277, 66, 13);
		contentPane.add(lblNewLabel_11);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(151, 34, 142, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(151, 82, 142, 19);
		contentPane.add(txtTenNV);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(151, 133, 142, 19);
		contentPane.add(txtNgaySinh);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(151, 180, 142, 19);
		contentPane.add(txtGioiTinh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(151, 232, 142, 19);
		contentPane.add(txtDiaChi);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(151, 274, 142, 19);
		contentPane.add(txtSDT);
		
		txtCCCD = new JTextField();
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(429, 34, 142, 19);
		contentPane.add(txtCCCD);
		
		txtTK = new JTextField();
		txtTK.setColumns(10);
		txtTK.setBounds(429, 82, 142, 19);
		contentPane.add(txtTK);
		
		txtMK = new JTextField();
		txtMK.setColumns(10);
		txtMK.setBounds(429, 133, 142, 19);
		contentPane.add(txtMK);
		
		txtTrangThai = new JTextField();
		txtTrangThai.setColumns(10);
		txtTrangThai.setBounds(429, 274, 142, 19);
		contentPane.add(txtTrangThai);
		
		cbboxChinhSach = new JComboBox();
		cbboxChinhSach.setBounds(429, 180, 142, 21);
		contentPane.add(cbboxChinhSach);
		
		cbboxChucVu = new JComboBox();
		cbboxChucVu.setBounds(429, 229, 142, 21);
		contentPane.add(cbboxChucVu);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setBounds(190, 345, 85, 21);
		contentPane.add(btnLuu);
		
		btnDong = new JButton("Đóng");
		btnDong.setBounds(335, 345, 85, 21);
		contentPane.add(btnDong);
		
        nvBLL = new Business_Logic.NhanVienBLL(this);
        nvDAL = new Process_Data.NhanVienDAL(this);
        btnLuu.addActionListener(this);
        btnDong.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLuu){
			int k = nvBLL.addData();
            if(k==1) {
            	JOptionPane.showMessageDialog(null, "Đã thêm thông tin nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
            	JOptionPane.showMessageDialog(null, "Thêm thông tin không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            this.dispose();
		}
		if(e.getSource() == btnDong){
			this.setVisible(false);
		    dispose();
		    qlp = new frmQuanLyPhim();
		    qlp.panelNHANVIEN = new frmNHANVIEN();
		    qlp.setVisible(true);
		}
		
	}
}
