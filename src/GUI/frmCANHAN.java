package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmCANHAN extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldTen;
	private JTextField textFieldNgaySinh;
	private JTextField textFieldDiaChi;
	private JTextField textFieldDienThoai;
	private JTextField textFieldTenTaiKhoan;
	private JTextField textFieldMatKhau;
	private JButton btnDoiMatKhau;
	private JButton btnLuu;
	private JTextField textFieldGioiTinh;
	private JTextField textFieldCCCD;
	/**
	 * Create the panel.
	 */
	public frmCANHAN() {
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JLabel lbAvatar = new JLabel("");
		lbAvatar.setBackground(new Color(245, 245, 245));
		lbAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lbAvatar.setBounds(311, 68, 129, 143);
		add(lbAvatar);
		
		// ví dụ cái avatar cho dễ thấy // tự đổi địa chỉ ảnh
		// khi nào code thì xóa đi rồi làm lại
		ImageIcon icon = new ImageIcon("C:\\Users\\nguye\\Downloads\\me.jpg");
		lbAvatar.setIcon(new ImageIcon(frmCANHAN.class.getResource("/image/pngwing.com (9).png")));
		
		//label lấy text từ csdl để đại cho dễ thấy vị trí
		JLabel lbChucVu = new JLabel("Chức VỤ");
		lbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbChucVu.setForeground(new Color(0, 0, 0));
		lbChucVu.setHorizontalAlignment(SwingConstants.CENTER);
		lbChucVu.setBackground(new Color(64, 128, 128));
		lbChucVu.setBounds(327, 233, 76, 27);
		add(lbChucVu);
		
		Font font = new Font("Tahoma", Font.PLAIN, 14);
		JLabel lbTen = new JLabel("TÊN");
		lbTen.setForeground(new Color(120, 120, 120));
		lbTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbTen.setBounds(10, 37, 84, 21);
		add(lbTen);
		
		JLabel lbNgaySinh = new JLabel("NGÀY SINH");
		lbNgaySinh.setBounds(10, 137, 84, 21);
		lbNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbNgaySinh.setForeground(new Color(120, 120, 120));
		add(lbNgaySinh);
		
		
		JLabel lbDiaChi = new JLabel("ĐỊA CHỈ");
		lbDiaChi.setBounds(10, 237, 84, 21);
		lbDiaChi.setForeground(new Color(120, 120, 120));
		lbDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lbDiaChi);
		
		JLabel lbDienThoai = new JLabel("ĐIỆN THOẠI");
		lbDienThoai.setBounds(513, 137, 104, 21);
		lbDienThoai.setForeground(new Color(120, 120, 120));
		lbDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lbDienThoai);
		
		JLabel lnTenTaiKhoan = new JLabel("TÊN TÀI KHOẢN");
		lnTenTaiKhoan.setBounds(513, 237, 104, 21);
		lnTenTaiKhoan.setForeground(new Color(120, 120, 120));
		lnTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lnTenTaiKhoan);
		
		JLabel lbMatKhau = new JLabel("MẬT KHẨU");
		lbMatKhau.setBounds(513, 337, 104, 21);
		lbMatKhau.setForeground(new Color(120, 120, 120));
		lbMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lbMatKhau);
		
		Font textFieldFont = new Font("Roboto", Font.PLAIN, 16);
		
		textFieldTen = new JTextField();
		textFieldTen.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTen.setBounds(91, 37, 129, 25);
		textFieldTen.setColumns(15);
		textFieldTen.setFont(textFieldFont);
		textFieldTen.setBorder(null);
		
		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setColumns(15);
		textFieldNgaySinh.setBounds(91, 137, 129, 25);
		textFieldNgaySinh.setFont(textFieldFont);
		textFieldNgaySinh.setBorder(null);
		
		textFieldDiaChi = new JTextField();
		textFieldDiaChi.setColumns(15);
		textFieldDiaChi.setBounds(91, 238, 129, 25);
		textFieldDiaChi.setFont(textFieldFont);
		textFieldDiaChi.setBorder(null);
		
		textFieldDienThoai = new JTextField();
		textFieldDienThoai.setColumns(15);
		textFieldDienThoai.setBounds(627, 137, 122, 25);
		textFieldDienThoai.setFont(new Font("Roboto", Font.PLAIN, 12));
		textFieldDienThoai.setBorder(null);
		
		
		textFieldTenTaiKhoan = new JTextField();
		textFieldTenTaiKhoan.setColumns(15);
		textFieldTenTaiKhoan.setBounds(627, 237, 122, 25);
		textFieldTenTaiKhoan.setFont(new Font("Roboto", Font.PLAIN, 12));
		textFieldTenTaiKhoan.setBorder(null);
		
		textFieldMatKhau = new JTextField();
		textFieldMatKhau.setColumns(15);
		textFieldMatKhau.setBounds(627, 337, 122, 25);
		textFieldMatKhau.setFont(new Font("Roboto", Font.PLAIN, 12));
		textFieldMatKhau.setBorder(null);
		
		add(textFieldTen);
		add(textFieldNgaySinh);
		add(textFieldDiaChi);
		add(textFieldDienThoai);
		add(textFieldTenTaiKhoan);
		add(textFieldMatKhau);
		
		btnDoiMatKhau = new JButton("ĐỔI MẬT KHẨU");
		btnDoiMatKhau.setBackground(new Color(207, 208, 218));
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDoiMatKhau.setForeground(new Color(0, 128, 192));
		btnDoiMatKhau.setBounds(250, 388, 115, 27);
		btnDoiMatKhau.setBorder(null);
		btnDoiMatKhau.addActionListener(this);
		add(btnDoiMatKhau);
		
		btnLuu = new JButton("LƯU");// thêm một JOptionPane khi bấm vào 
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setForeground(new Color(255, 255, 255));
		btnLuu.setBackground(new Color(64, 128, 128));
		btnLuu.setBounds(403, 388, 60, 27);
		btnLuu.setBorder(null);
		add(btnLuu);
		
		textFieldGioiTinh = new JTextField();
		textFieldGioiTinh.setFont(new Font("Roboto", Font.PLAIN, 16));
		textFieldGioiTinh.setColumns(15);
		textFieldGioiTinh.setBorder(null);
		textFieldGioiTinh.setBounds(91, 337, 129, 25);
		add(textFieldGioiTinh);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setForeground(new Color(120, 120, 120));
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGiiTnh.setBounds(10, 337, 84, 21);
		add(lblGiiTnh);
		
		textFieldCCCD = new JTextField();
		textFieldCCCD.setFont(new Font("Roboto", Font.PLAIN, 16));
		textFieldCCCD.setColumns(15);
		textFieldCCCD.setBorder(null);
		textFieldCCCD.setBounds(620, 37, 129, 25);
		add(textFieldCCCD);
		
		JLabel lblSCccd = new JLabel("SỐ CCCD");
		lblSCccd.setForeground(new Color(120, 120, 120));
		lblSCccd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSCccd.setBounds(513, 37, 84, 21);
		add(lblSCccd);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnDoiMatKhau) {
			diaCHANGEPASSWORD fm = new diaCHANGEPASSWORD();
			fm.show();
		}else if(e.getSource() == btnLuu) {
			
		}
	}
	
}
