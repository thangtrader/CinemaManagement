package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class diaCAPNHATLICHCHIEU extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMaPhim;
	private JTextField textFieldPhongChieu;
	private JTextField textFieldMaKhungGioChieu;
	private JTextField textFieldNgayChieu;
	private JTextField textFieldTrangThai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			diaCAPNHATLICHCHIEU dialog = new diaCAPNHATLICHCHIEU();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public diaCAPNHATLICHCHIEU() {
		getContentPane().setBackground(new Color(253, 245, 230));
		setBackground(new Color(250, 240, 230));
		setBounds(250, 220, 571, 279);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(230, 243, 240));
		contentPanel.setBounds(0, 0, 557, 242);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Mã Phim");
			lblNewLabel_1.setBounds(42, 81, 72, 13);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Mã phòng chiếu");
			lblNewLabel_2.setBounds(42, 127, 93, 13);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Mã khung giờ chiếu");
			lblNewLabel_3.setBounds(42, 170, 128, 13);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Ngày chiếu");
			lblNewLabel_4.setBounds(318, 81, 72, 13);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Trạng thái");
			lblNewLabel_5.setBounds(318, 127, 72, 13);
			contentPanel.add(lblNewLabel_5);
		}
		
		textFieldMaPhim = new JTextField();
		textFieldMaPhim.setBounds(183, 75, 96, 19);
		contentPanel.add(textFieldMaPhim);
		textFieldMaPhim.setColumns(10);
		
		textFieldPhongChieu = new JTextField();
		textFieldPhongChieu.setColumns(10);
		textFieldPhongChieu.setBounds(183, 124, 96, 19);
		contentPanel.add(textFieldPhongChieu);
		
		textFieldMaKhungGioChieu = new JTextField();
		textFieldMaKhungGioChieu.setColumns(10);
		textFieldMaKhungGioChieu.setBounds(183, 167, 96, 19);
		contentPanel.add(textFieldMaKhungGioChieu);
		
		textFieldNgayChieu = new JTextField();
		textFieldNgayChieu.setColumns(10);
		textFieldNgayChieu.setBounds(399, 78, 97, 19);
		contentPanel.add(textFieldNgayChieu);
		
		textFieldTrangThai = new JTextField();
		textFieldTrangThai.setColumns(10);
		textFieldTrangThai.setBounds(400, 124, 96, 19);
		contentPanel.add(textFieldTrangThai);
		{
			JButton btnLuu = new JButton("Lưu");
			btnLuu.setForeground(new Color(255, 255, 255));
			btnLuu.setBackground(new Color(32, 178, 170));
			btnLuu.setBounds(324, 176, 66, 21);
			contentPanel.add(btnLuu);
			btnLuu.setActionCommand("OK");
			getRootPane().setDefaultButton(btnLuu);
		}
		{
			JButton btnHuy = new JButton("Hủy");
			btnHuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btnHuy.setForeground(new Color(255, 255, 255));
			btnHuy.setBackground(new Color(255, 99, 71));
			btnHuy.setBounds(412, 176, 84, 21);
			contentPanel.add(btnHuy);
			btnHuy.setActionCommand("Cancel");
		}
		{
			JLabel lblNewLabel = new JLabel("Thông tin lịch chiếu");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			lblNewLabel.setBounds(192, 3, 194, 43);
			contentPanel.add(lblNewLabel);
		}
	}
}
