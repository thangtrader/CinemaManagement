package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business_Logic.NhanVienBLL;
import Process_Data.NhanVienDAL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Color;

public class diaCHANGEPASSWORD extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField textFieldMatKhauCu;
	public JTextField textFieldMatKhauMoi;
	public JTextField textFieldMatKhauMoiAgain;
	private JButton btnSave;
	private JButton btnCancel;
	private NhanVienBLL nvBLL;
	private NhanVienDAL nvDAL;
	GUI.frmCANHAN canhan;
	private String tenTaiKhoan;
	
	ENTITY.NHANVIEN nvDTO = new ENTITY.NHANVIEN();
	
	public void init() {
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
				btnSave = new JButton("LƯU");
				btnSave.setBounds(228, 5, 62, 25);
				btnSave.setForeground(new Color(255, 255, 255));
				btnSave.setBackground(new Color(62, 177, 52));
				btnSave.setFont(new Font("Tahoma", Font.BOLD, 10));
				btnSave.setActionCommand("LƯU");
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			{
				btnCancel = new JButton("CANCEL");
				btnCancel.setForeground(new Color(255, 255, 255));
				btnCancel.setBounds(300, 5, 77, 25);
				btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
				btnCancel.setBackground(new Color(210, 28, 32));
				btnCancel.setActionCommand("CANCEL");
				buttonPane.add(btnCancel);
			}
	        nvBLL = new Business_Logic.NhanVienBLL();
	        nvDAL = new Process_Data.NhanVienDAL();
	        btnSave.addActionListener(this);
		}
	}
	
	public diaCHANGEPASSWORD(String tentaikhoan) {
		tenTaiKhoan = tentaikhoan;
		this.init();
		this.DisplayData(tentaikhoan);
	}
	
    public void DisplayData(String tentaikhoan) {
    	tenTaiKhoan = tentaikhoan;
    	ENTITY.NHANVIEN nvDTO = new ENTITY.NHANVIEN();
    	nvDTO =  nvBLL.GetNhanVienByTenTaiKhoan(tentaikhoan);
//    	textFieldMatKhauCu.setText(nvDTO.getMatKhau());
    }
	
    public boolean CheckNull() {
    	if(!textFieldMatKhauMoi.getText().trim().isEmpty() || !textFieldMatKhauMoiAgain.getText().trim().isEmpty()) {
    		return true;
    	}
    	else {
    		JOptionPane.showMessageDialog(null, "Vui lòng không để trống các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    		return false;
    	}
    }
    
    public boolean CheckData() {
    	if(textFieldMatKhauMoi.getText().equals(textFieldMatKhauMoiAgain.getText())) {
    		return true;
    	}
    	else {
    		JOptionPane.showMessageDialog(null, "Mật khẩu mới và xác nhận mật khẩu không được khác nhau!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    		return false;
    	}
    }
    
    public int ChangePass() {
    	nvDTO = new ENTITY.NHANVIEN();
    	String mkmoi = textFieldMatKhauMoiAgain.getText();
    	nvDTO.setTenTaiKhoan(tenTaiKhoan);
    	nvDTO.setMatKhau(mkmoi);
    	return nvBLL.updateMK(nvDTO);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSave) {
			int checkMatKhau = NhanVienBLL.getInstance().KiemTraDangNhap(tenTaiKhoan, textFieldMatKhauCu.getText());
			System.out.println(checkMatKhau);
			if((checkMatKhau == 0)) {
				JOptionPane.showMessageDialog(null, "Sai mật khẩu cũ!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				if ((checkMatKhau != 0)  && (CheckData() == true) && (CheckNull() == true))
	            {
					ChangePass();
					JOptionPane.showMessageDialog(null, "Đã đổi mật khẩu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	                this.dispose();
	            }
//	            else
//	            {
//	            	JOptionPane.showMessageDialog(null, "Đổi mật khẩu không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////	                lblValidatedMatKhauCu.Visible = true;
//	            }
			}
		}
	}
}
