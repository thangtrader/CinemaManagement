//package GUI;
//
//import javax.swing.JPanel;
//
//public class panelTHONGKEPHIM1 extends JPanel {
//
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * Create the panel.
//	 */
//	public panelTHONGKEPHIM1() {
//
//	}
//
//}
package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Business_Logic.ThongKePhimBLL;
import Process_Data.ThongKePhimDAL;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class panelTHONGKEPHIM extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTable table;
	public JLabel lbDoanhThu;
	public DefaultTableModel model;
	public String dateString;
	ThongKePhimDAL tkpDAL;
	ThongKePhimBLL tkpBLL;
	public JDateChooser calendar;
	public JCheckBox checkBoxDoanhThu;
	/**
	 * Create the panel.
	 */
	public panelTHONGKEPHIM() {
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 52, 707, 278);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 phim", "T\u00EAn phim", "Th\u1EC3 lo\u1EA1i", "S\u1ED1 l\u01B0\u1EE3ng v\u00E9", "Doanh thu"
			}
		));
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Tổng doanh thu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(518, 340, 113, 22);
		add(lblNewLabel);
		
		lbDoanhThu = new JLabel("");
		lbDoanhThu.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbDoanhThu.setBounds(634, 340, 97, 22);
		add(lbDoanhThu);
		
		JLabel labelDoanhThuTheoNam = new JLabel("Doanh thu phim");
		labelDoanhThuTheoNam.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelDoanhThuTheoNam.setForeground(new Color(255, 0, 0));
		labelDoanhThuTheoNam.setBackground(new Color(255, 255, 255));
		labelDoanhThuTheoNam.setBounds(27, 18, 197, 17);
		add(labelDoanhThuTheoNam);
		
		JPanel panel = new JPanel();
		panel.setBounds(638, 10, 97, 32);
		add(panel);
		panel.setLayout(null);
		calendar = new JDateChooser();
		calendar.setBounds(0, 0, 96, 31);
		panel.add(calendar);
//		calendar.setDate(null);
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
		    

			@Override
		    public void propertyChange(PropertyChangeEvent evt) {
		        if ("date".equals(evt.getPropertyName())) {
		            Date selectedDate = (Date) evt.getNewValue();
		            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		            dateString = dateFormat.format(selectedDate);
		            labelDoanhThuTheoNam.setText("Doanh thu tháng " + dateString.substring(3,5) +  " năm " + dateString.substring(6));
		            tkpBLL.LoadTKPhim();
		            tkpBLL.UpdateTongDoanhThuLabel();
		        }
		    }
		});
		checkBoxDoanhThu = new JCheckBox("");
		checkBoxDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkBoxDoanhThu.setBounds(420, 16, 21, 21);
		add(checkBoxDoanhThu);
		
		JLabel lblNewLabel_1 = new JLabel("Chỉ tính doanh thu theo năm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(444, 18, 197, 16);
		add(lblNewLabel_1);
		checkBoxDoanhThu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(checkBoxDoanhThu.isSelected()) {
					
					labelDoanhThuTheoNam.setText("Doanh thu năm " + dateString.substring(6));
					tkpBLL.LoadTKPhim();
		            tkpBLL.UpdateTongDoanhThuLabel();
				}
				
				else
				{
					
					labelDoanhThuTheoNam.setText("Doanh thu tháng " + dateString.substring(3,5) + " năm " + dateString.substring(6));
					tkpBLL.LoadTKPhim();
		            tkpBLL.UpdateTongDoanhThuLabel();
				}
			}
		});
//		tkpDAL = new Process_Data.ThongKePhimDAL(this);
		tkpBLL = new Business_Logic.ThongKePhimBLL(this);
		

	}
}