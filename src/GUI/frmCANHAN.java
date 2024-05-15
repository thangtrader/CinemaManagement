	package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Business_Logic.NhanVienBLL;
import Process_Data.NhanVienDAL;

public class frmCANHAN extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldTen;
	private JTextField textFieldDiaChi;
	private JTextField textFieldDienThoai;
	private JTextField textFieldTenTaiKhoan;
	public JTextField textFieldMatKhau;
	private JButton btnDoiMatKhau;
	private JButton btnLuu;
	private JTextField textFieldGioiTinh;
	private JTextField textFieldCCCD;
	
	private NhanVienBLL nvBLL;
	private NhanVienDAL nvDAL;
	private JTextField textFieldMaNhanVien;
	private String tenTaiKhoan;
	private JButton btnChinhSua;
	private JLabel lbAvatar;
	private JTextField textFieldNgaySinh;
	private JTextField textFieldMaChucVu;

	public void init() {
		setBackground(new Color(253, 243, 225));
		setLayout(null);
		
		lbAvatar = new JLabel("");
		lbAvatar.setBackground(new Color(245, 245, 245));
		lbAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lbAvatar.setBounds(310, 23, 129, 143);
		add(lbAvatar);
		
		// ví dụ cái avatar cho dễ thấy // tự đổi địa chỉ ảnh
		// khi nào code thì xóa đi rồi làm lại
		ImageIcon icon = new ImageIcon("C:\\Users\\nguye\\Downloads\\me.jpg");
		lbAvatar.setIcon(new ImageIcon(frmCANHAN.class.getResource("/image/pngwing.com (9).png")));
		
		//label lấy text từ csdl để đại cho dễ thấy vị trí
		JLabel lbChucVu = new JLabel("Chức Vụ:");
		lbChucVu.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lbChucVu.setHorizontalAlignment(SwingConstants.CENTER);
		lbChucVu.setBounds(513, 320, 76, 27);
		add(lbChucVu);
		 
		JLabel lbTen = new JLabel("Tên:");
		lbTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbTen.setBounds(20, 40, 84, 21);
		add(lbTen);
		
		JLabel lbNgaySinh = new JLabel("Ngày sinh:");
		lbNgaySinh.setBounds(20, 110, 84, 21);
		lbNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lbNgaySinh);
		
		
		JLabel lbDiaChi = new JLabel("Địa chỉ:");
		lbDiaChi.setBounds(20, 180, 84, 21);
		lbDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lbDiaChi);
		
		JLabel lbDienThoai = new JLabel("Điện thoại:");
		lbDienThoai.setBounds(513, 110, 104, 21);
//		lbDienThoai.setForeground(new Color(120, 120, 120));
		lbDienThoai.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lbDienThoai);
		
		JLabel lnTenTaiKhoan = new JLabel("Tên tài khoản:");
		lnTenTaiKhoan.setBounds(513, 180, 104, 21);
//		lnTenTaiKhoan.setForeground(new Color(120, 120, 120));
		lnTenTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lnTenTaiKhoan);
		
		JLabel lbMatKhau = new JLabel("Mật khẩu:");
		lbMatKhau.setBounds(513, 250, 104, 21);
//		lbMatKhau.setForeground(new Color(120, 120, 120));
		lbMatKhau.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lbMatKhau);
		
		Font textFieldFont = new Font("Roboto", Font.PLAIN, 12);
		
		textFieldTen = new JTextField();
		textFieldTen.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTen.setBounds(110, 40, 129, 25);
		textFieldTen.setColumns(15);
		textFieldTen.setFont(textFieldFont);
		
		textFieldMaChucVu = new JTextField();
		textFieldMaChucVu.setColumns(15);
		textFieldMaChucVu.setBounds(627, 320, 122, 25);
		textFieldMaChucVu.setFont(new Font("Roboto", Font.PLAIN, 12));
		add(textFieldMaChucVu);
		
		textFieldDiaChi = new JTextField();
		textFieldDiaChi.setColumns(15);
		textFieldDiaChi.setBounds(110, 180, 129, 25);
		textFieldDiaChi.setFont(textFieldFont);
		
		textFieldDienThoai = new JTextField();
		textFieldDienThoai.setColumns(15);
		textFieldDienThoai.setBounds(627, 110, 122, 25);
		textFieldDienThoai.setFont(new Font("Roboto", Font.PLAIN, 12));
		
		
		textFieldTenTaiKhoan = new JTextField();
		textFieldTenTaiKhoan.setColumns(15);
		textFieldTenTaiKhoan.setBounds(627, 180, 122, 25);
		textFieldTenTaiKhoan.setFont(new Font("Roboto", Font.PLAIN, 12));

		
		textFieldMatKhau = new JTextField();
		textFieldMatKhau.setColumns(15);
		textFieldMatKhau.setBounds(627, 250, 122, 25);
		textFieldMatKhau.setFont(new Font("Roboto", Font.PLAIN, 12));
		
		add(textFieldTen);
		add(textFieldDiaChi);
		add(textFieldDienThoai);
		add(textFieldTenTaiKhoan);
		add(textFieldMatKhau);
		
		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setForeground(new Color(255, 235, 205));
		btnDoiMatKhau.setBackground(new Color(0, 128, 0));
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDoiMatKhau.setIcon(new ImageIcon(getClass().getResource("/image/change.png")));
		btnDoiMatKhau.setBounds(208, 399, 160, 27);
		btnDoiMatKhau.addActionListener(this);
		add(btnDoiMatKhau);
		
		btnLuu = new JButton("Lưu");// thêm một JOptionPane khi bấm vào 
		btnLuu.setIcon(new ImageIcon(getClass().getResource("/image/them.png")));
		btnLuu.setForeground(new Color(255, 235, 205));
		btnLuu.setBackground(new Color(32, 178, 170));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuu.setBounds(392, 399, 60, 27);
		btnLuu.setBorder(null);
		add(btnLuu);
		
		textFieldGioiTinh = new JTextField();
		textFieldGioiTinh.setFont(new Font("Roboto", Font.PLAIN, 12));
		textFieldGioiTinh.setColumns(15);
		textFieldGioiTinh.setBounds(110, 250, 129, 25);
		add(textFieldGioiTinh);
		
		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGiiTnh.setBounds(20, 250, 84, 21);
		add(lblGiiTnh);
		
		textFieldCCCD = new JTextField();
		textFieldCCCD.setFont(new Font("Roboto", Font.PLAIN, 12));
		textFieldCCCD.setColumns(15);
		textFieldCCCD.setBounds(620, 40, 129, 25);
		add(textFieldCCCD);
		
		JLabel lblSCccd = new JLabel("SỐ CCCD:");
		lblSCccd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSCccd.setBounds(513, 37, 84, 21);
		add(lblSCccd);
		
        btnChinhSua = new JButton("Chỉnh sửa");
        btnChinhSua.setForeground(new Color(255, 235, 205));
		btnChinhSua.setBackground(new Color(255, 165, 0));
		btnChinhSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChinhSua.setIcon(new ImageIcon(getClass().getResource("/image/sua.png.png")));
        btnChinhSua.setBounds(484, 399, 130, 25);
        add(btnChinhSua);
        
        JLabel lblNewLabel = new JLabel("Mã nhân viên:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(20, 320, 100, 21);
        add(lblNewLabel);
        
        textFieldMaNhanVien = new JTextField();
        textFieldMaNhanVien.setBounds(110, 320,129, 25);
        add(textFieldMaNhanVien);
        textFieldMaNhanVien.setColumns(10);
        
        JButton btnThemAnh = new JButton("Upload");
        btnThemAnh.setBackground(new Color(173, 216, 230));
        btnThemAnh.setIcon(new ImageIcon(frmTHONGTINPHIM.class.getResource("/image/sapxep.png")));
		btnThemAnh.setForeground(new Color(255, 235, 205));
		btnThemAnh.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnThemAnh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ENTITY.NHANVIEN nvDTO = new ENTITY.NHANVIEN();
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String imagePath = selectedFile.getAbsolutePath();

                    try {
                        byte[] imageBytes = nvBLL.readImageBytes(imagePath);
                      
                        
                        Image image = nvBLL.ChuyenMangByteSangAnh(imageBytes);

                        displayImage(image);
                        
                        nvDTO.setAnh(imageBytes);
                        nvDTO.setMaNhanVien(textFieldMaNhanVien.getText());
                        nvBLL.updateAnh(nvDTO);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
        	}
        });
        btnThemAnh.setBounds(320, 176, 110, 21);
        add(btnThemAnh);
        
        textFieldNgaySinh = new JTextField();
        textFieldNgaySinh.setBounds(110, 110, 129, 25);
        add(textFieldNgaySinh);
        textFieldNgaySinh.setColumns(10);
        
        
        nvBLL = new Business_Logic.NhanVienBLL();
        nvDAL = new Process_Data.NhanVienDAL();
	}
	
	public frmCANHAN(String tentaikhoan) {
		tenTaiKhoan = tentaikhoan;
		this.init();
		this.DisplayDataTest(tentaikhoan);
//        String imagePath = "C:\\Users\\acer\\Pictures\\anh.png";
//
//        try {
//            byte[] imageBytes = nvBLL.readImageBytes(imagePath);
//
//            Image image = nvBLL.ChuyenMangByteSangAnh(imageBytes);
//
//            displayImage(image);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
	}
	
	
    public void DisplayData(String tentaikhoan) {
    	ENTITY.NHANVIEN nvDTO = new ENTITY.NHANVIEN();
    	nvDTO =  nvBLL.GetNhanVienByTenTaiKhoan(tentaikhoan);
    	textFieldMaNhanVien.setText(nvDTO.getMaNhanVien());
    	textFieldTen.setText(nvDTO.getTenNhanVien());
    	textFieldMaChucVu.setText(nvDTO.getMaChucVu());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
        Date ngaySinh = nvDTO.getNgaySinh();		
        String ngaySinhString = dateFormat.format(ngaySinh);
        
    	textFieldNgaySinh.setText(ngaySinhString);
        textFieldDiaChi.setText(nvDTO.getDiaChi());
        textFieldGioiTinh.setText(nvDTO.getGioiTinh());
        textFieldCCCD.setText(nvDTO.getCccd());
        textFieldDienThoai.setText(nvDTO.getSdt());
        textFieldTenTaiKhoan.setText(nvDTO.getTenTaiKhoan());
        textFieldMatKhau.setText(nvDTO.getMatKhau());
        
    }
    
    
    public void DisplayDataTest(String tentaikhoan) {
    	ENTITY.NHANVIEN nvDTO = new ENTITY.NHANVIEN();
    	nvDTO =  nvBLL.GetNhanVienByTest(tentaikhoan);
    	textFieldMaNhanVien.setText(nvDTO.getMaNhanVien());
    	textFieldTen.setText(nvDTO.getTenNhanVien());
    	textFieldMaChucVu.setText(nvDTO.getMaChucVu());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,y");
        Date ngaySinh = nvDTO.getNgaySinh();		
        String ngaySinhString = dateFormat.format(ngaySinh);
        
    	textFieldNgaySinh.setText(ngaySinhString);
        textFieldDiaChi.setText(nvDTO.getDiaChi());
        textFieldGioiTinh.setText(nvDTO.getGioiTinh());
        textFieldCCCD.setText(nvDTO.getCccd());
        textFieldDienThoai.setText(nvDTO.getSdt());
        textFieldTenTaiKhoan.setText(nvDTO.getTenTaiKhoan());
        textFieldMatKhau.setText(nvDTO.getMatKhau());
        byte[] imageData = nvDTO.getAnh();
        if (imageData != null && imageData.length > 0) {
            ImageIcon imageIcon = new ImageIcon(imageData);
            lbAvatar.setIcon(imageIcon);
        } else {

        }
        
    }
    
    private void displayImage(Image image) {
        ImageIcon icon = new ImageIcon(image);
        lbAvatar.setIcon(icon);
    }
	//thangadmin
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnDoiMatKhau) {
			diaCHANGEPASSWORD fm = new diaCHANGEPASSWORD(tenTaiKhoan);
			fm.addWindowListener(new WindowAdapter() {
    		    @Override
    		    public void windowClosed(WindowEvent e) {
    		        textFieldMatKhau.setText(fm.textFieldMatKhauMoiAgain.getText());
    		    }
    		});
			fm.setVisible(true);
		}else if(e.getSource() == btnLuu) {
			
		}
	}
}
