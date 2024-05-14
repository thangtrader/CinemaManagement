
package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Business_Logic.ThongKePhimBLL;
import Process_Data.ThongKePhimDAL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class panelTHONGKEPHIM extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTable table;
	public JLabel lbDoanhThu;
	public DefaultTableModel model;
	public String dateString;
	ThongKePhimBLL tkpBLL;
	public JDateChooser dateChooser;
	public JCheckBox checkBoxDoanhThu;
	public Calendar calendar;
	private JCheckBox checkBoxTongDoanhThu;

	public panelTHONGKEPHIM() {
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 52, 707, 278);
		add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(253, 243, 225));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 phim", "T\u00EAn phim",
				"Th\u1EC3 lo\u1EA1i", "S\u1ED1 l\u01B0\u1EE3ng v\u00E9", "Doanh thu" }));
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
 
		JLabel lblNewLabel = new JLabel("Doanh thu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel.setBounds(560, 340, 84, 22);
		add(lblNewLabel);

		lbDoanhThu = new JLabel("");
		lbDoanhThu.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbDoanhThu.setBounds(656, 340, 75, 22);
		add(lbDoanhThu);

		JLabel labelDoanhThuTheoNam = new JLabel("Doanh thu phim");
		labelDoanhThuTheoNam.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelDoanhThuTheoNam.setForeground(new Color(255, 0, 0));
		labelDoanhThuTheoNam.setBackground(new Color(255, 255, 255));
		labelDoanhThuTheoNam.setBounds(27, 18, 197, 17);
		add(labelDoanhThuTheoNam);

		JPanel panel = new JPanel();
		panel.setBounds(638, 15, 97, 25);
		add(panel);
		panel.setLayout(null);
		dateChooser = new JDateChooser();
		dateChooser.setBounds(0, 0, 96, 31);
		panel.add(dateChooser);
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("date".equals(evt.getPropertyName())) {
					dateChooser.setDateFormatString("M, y");
					Date selectedDate = (Date) evt.getNewValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("M, y");
					calendar = dateChooser.getCalendar();
					dateString = dateFormat.format(selectedDate);
					labelDoanhThuTheoNam.setText("Doanh thu tháng " + (calendar.get(Calendar.MONTH) + 1) + " năm "
							+ calendar.get(Calendar.YEAR));
					loadAll();
					checkBoxTongDoanhThu.setSelected(false);
				}
			}
		});
		checkBoxDoanhThu = new JCheckBox("");
		checkBoxDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkBoxDoanhThu.setBounds(467, 18, 21, 21);
		add(checkBoxDoanhThu);

		JLabel lblNewLabel_1 = new JLabel("Doanh thu theo năm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(491, 20, 140, 16);
		add(lblNewLabel_1);
		checkBoxDoanhThu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBoxDoanhThu.isSelected() && dateChooser.getDate() == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thời gian trước khi xem", "Doanh thu năm",
							JOptionPane.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
					checkBoxDoanhThu.setSelected(false);
				} else if (checkBoxDoanhThu.isSelected()) {
					labelDoanhThuTheoNam.setText("Doanh thu năm " + calendar.get(Calendar.YEAR));
					loadAll();
				} else {
					labelDoanhThuTheoNam.setText("Doanh thu tháng " + (calendar.get(Calendar.MONTH) + 1) + " năm "
							+ calendar.get(Calendar.YEAR));
					loadAll();
				}
			}
		});

		checkBoxTongDoanhThu = new JCheckBox("Tổng doanh thu");
		checkBoxTongDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkBoxTongDoanhThu.setBounds(26, 342, 134, 21);
		add(checkBoxTongDoanhThu);
		checkBoxTongDoanhThu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBoxTongDoanhThu.isSelected()) {
					labelDoanhThuTheoNam.setText("Doanh thu phim");
					dateString = null;
					dateChooser.setDateFormatString("");
					checkBoxDoanhThu.setSelected(false);
				}
				loadAll();
			}
		});
		tkpBLL = new Business_Logic.ThongKePhimBLL(this);
		loadAll();
		

	}
	public void loadAll() {
		LoadTKPhim();
		UpdateTongDoanhThuLabel();
	}
	
	public void LoadTKPhim() {
		model = (DefaultTableModel) table.getModel();
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		Vector<ENTITY.TKPhim> vector = new Vector<ENTITY.TKPhim>();
		int month = 0;
		int year = 0;
		if (dateString != null) {
			month = calendar.get(Calendar.MONTH) + 1;
			year = calendar.get(Calendar.YEAR);
		}
		vector = tkpBLL.LoadTKPhim(dateString, checkBoxDoanhThu.isSelected(), month, year);
		for (ENTITY.TKPhim tkp : vector) {
			model.addRow(new Object[] { tkp.getMaPhim(), tkp.getTenPhim(), tkp.getTheLoai(),
					tkp.getSoLuongVe(), tkp.getDoanhThu() });
		}
	}
	public void UpdateTongDoanhThuLabel() {
		int month = 0;
		int year = 0;
		if (this.dateString != null) {
			month = this.calendar.get(Calendar.MONTH) + 1;
			year = this.calendar.get(Calendar.YEAR);
		}
		int tongDoanhThu = tkpBLL.tinhDoanhThu(this.dateString, this.checkBoxDoanhThu.isSelected(), month, year);
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		format.setCurrency(Currency.getInstance("VND"));
		String kq = format.format(tongDoanhThu);
		lbDoanhThu.setText(kq);
	}
}