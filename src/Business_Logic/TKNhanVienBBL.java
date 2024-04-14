// Trong lớp BLL:

package Business_Logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import Process_Data.DBHelper;
import Process_Data.TKNhanVien;
import ENTITY.TKNHANVIEN;

public class TKNhanVienBBL extends DBHelper {
	private static TKNhanVienBBL instance;
    GUI.panelTKNHANVIEN GUITKNhanVien;
    TKNhanVien tknvDAL;
    JLabel lbLuong, lblTop1,lblTop2,lblTop3,lblTop4,lblTop5;
    public static TKNhanVienBBL getInstance() {
    	if(instance == null) {
    		instance = new TKNhanVienBBL();
    	}
    	return instance;
    }
    
    public TKNhanVienBBL(GUI.panelTKNHANVIEN pnv) {
    	GUITKNhanVien = pnv;
    	 lbLuong = pnv.lbLuong; // Lưu trữ tham chiếu đến label tổng lương
    	 lblTop1=pnv.top1;
    	 lblTop2=pnv.top2;
    	 lblTop3=pnv.top3;
    	 lblTop4=pnv.top4;
    	 lblTop5=pnv.top5;
    	 tknvDAL = TKNhanVien.getInstance();
         tknvDAL.UpdateTongLuongLabel(lbLuong);
         JLabel[] topLabels = {lblTop1, lblTop2, lblTop3, lblTop4, lblTop5};
         // Gọi phương thức UpdateTop5 chỉ một lần và truyền vào mảng label
         UpdateTop5(topLabels);
    	LoadNhanVien();
    }
     public TKNhanVienBBL() {
    	
     }

    
    public Vector<ENTITY.TKNHANVIEN> ListTKNhanVien() {
    	System.out.println("ok");
        Vector<ENTITY.TKNHANVIEN> vector = new Vector<ENTITY.TKNHANVIEN>();
        try {
        	String sql = "   SELECT DISTINCT NV.MaNhanVien, NV.TenNhanVien, NV.GioiTinh,\r\n"
        			+ "           CASE \r\n"
        			+ "               WHEN CLV.GioBatDau IS NOT NULL AND CLV.GioKetThuc IS NOT NULL THEN DATEDIFF(HOUR, CLV.GioBatDau, CLV.GioKetThuc)\r\n"
        			+ "               ELSE 0\r\n"
        			+ "           END AS SoGioLam,\r\n"
        			+ "           CS.HeSoLuong * CASE \r\n"
        			+ "                             WHEN CLV.GioBatDau IS NOT NULL AND CLV.GioKetThuc IS NOT NULL THEN DATEDIFF(HOUR, CLV.GioBatDau, CLV.GioKetThuc)\r\n"
        			+ "                             ELSE 0\r\n"
        			+ "                         END AS TongLuong\r\n"
        			+ "    FROM NHAN_VIEN NV\r\n"
        			+ "    LEFT JOIN LICH_LAM_VIEC LLV ON NV.MaNhanVien = LLV.MaNhanVien\r\n"
        			+ "    LEFT JOIN CA_LAM_VIEC CLV ON LLV.MaCa = CLV.MaCa\r\n"
        			+ "    LEFT JOIN CHINH_SACH CS ON NV.MaChinhSach = CS.MaChinhSach";
        	PreparedStatement pre = cnn.prepareStatement(sql);
        	ResultSet rs = pre.executeQuery();
            while (rs.next()) {
            	ENTITY.TKNHANVIEN NhanVien = new ENTITY.TKNHANVIEN();
                NhanVien.setMaNhanVien(rs.getString("MaNhanVien"));
                NhanVien.setTenNhanVien(rs.getString("TenNhanVien"));
                NhanVien.setGioiTinh(rs.getBoolean("GioiTinh"));
                NhanVien.setSogiolam(rs.getDouble("SoGioLam"));
                NhanVien.setTongtien(rs.getDouble("TongLuong")); // Sửa đổi thành setTongTien
                vector.addElement(NhanVien);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }
    public int TinhTongLuongNhanVien() {
        int result = 0;
        try {
            // Chuẩn bị câu lệnh gọi stored procedure
            String sql = "{CALL TinhTongLuongNhanVien()}";
            // Tạo đối tượng PreparedStatement
            PreparedStatement statement = ((Statement) cnn).getConnection().prepareStatement(sql);
            // Thực thi câu lệnh
            ResultSet rs = statement.executeQuery();
            // Lấy kết quả
            if (rs.next()) {
                result = rs.getInt(1); // Giả sử stored procedure trả về một số nguyên
            }
            // Đóng kết nối và các tài nguyên
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public String Top5NhanVien() {
        String result = "";
        try {
            // Chuẩn bị câu lệnh gọi stored procedure
            String sql = "{CALL HienThiTop5()}";
            // Tạo đối tượng PreparedStatement
            PreparedStatement statement = ((Statement) cnn).getConnection().prepareStatement(sql);
            // Thực thi câu lệnh
            ResultSet rs = statement.executeQuery();
            // Lấy kết quả
            if (rs.next()) {
                result = rs.getString("TenNhanVien") + "\n"; // Giả sử stored procedure trả về một số nguyên
            }
            // Đóng kết nối và các tài nguyên
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public void LoadNhanVien() {
        // Khởi tạo đối tượng tknvDAL
        tknvDAL = new TKNhanVien();
        GUITKNhanVien.model = (DefaultTableModel) GUITKNhanVien.table.getModel();
        for (int i = GUITKNhanVien.model.getRowCount() - 1; i >= 0; i--) {
            GUITKNhanVien.model.removeRow(i);
        }
        // Gọi phương thức ListTKNhanVien() thay vì ListNhanVien()
        for (ENTITY.TKNHANVIEN tknv : tknvDAL.ListNhanVien()) {
            GUITKNhanVien.model.addRow(new Object[]{tknv.getMaNhanVien(), tknv.getTenNhanVien(), tknv.isGioiTinh(), tknv.getSogiolam(), tknv.getTongtien()});
        }
    }
    public void UpdateTongLuongLabel(JLabel label) {
        int tongLuong = TinhTongLuongNhanVien(); // Gọi phương thức để lấy tổng lương từ procedure
        label.setText(String.valueOf(tongLuong)); // Cập nhật label với kết quả
    }
    public void UpdateTop5(JLabel[] labels) {
        String top5 = tknvDAL.Top5NhanVien(); // Lấy danh sách top 5 nhân viên
        String[] top5Array = top5.split("\n"); // Chia chuỗi thành mảng các nhân viên
        
        // Cập nhật từng label trong mảng với thông tin top 5 nhân viên
        for (int i = 0; i < labels.length; i++) {
            if (i < top5Array.length) {
                labels[i].setText(top5Array[i]);
            } else {
                // Nếu không có đủ nhân viên trong top 5, đặt label thành rỗng
                labels[i].setText("");
            }
        }
    }
}
