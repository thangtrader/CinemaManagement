package Process_Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import Process_Data.DBHelper;

import ENTITY.PhimViewDTO;

public class PhimDAL extends DBHelper {
    GUI.frmTHONGTINPHIM guiPhim;
    GUI.frmThemThongTinPhim themphim;
    DBHelper cnn;
    Object[] obj = null;

    
    public PhimDAL() {
        cnn = new DBHelper();
    }
       
	public Vector<ENTITY.PhimViewDTO> ListPhim() {
        Vector<ENTITY.PhimViewDTO> vector = new Vector<ENTITY.PhimViewDTO>();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("SelectPhim");
            while (rs.next()) {
            	ENTITY.PhimViewDTO phimview = new ENTITY.PhimViewDTO();
            	phimview.setMaPhim(rs.getString("MaPhim"));
            	phimview.setTenPhim(rs.getString("TenPhim"));
            	phimview.setThoiLuong(rs.getInt("ThoiLuong"));
            	phimview.setQuocGia(rs.getString("QuocGia"));
            	phimview.setDaoDien(rs.getString("DaoDien"));
            	phimview.setNamSanXuat(rs.getDate("NamSanXuat"));
            	phimview.setDoTuoiXem(rs.getInt("DoTuoiXem"));
            	phimview.setTenTheLoai(rs.getString("TenTheLoaiPhim"));
            	
            	
                vector.addElement(phimview);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vector;
    }
	public ENTITY.PhimViewDTO GetPhimByMa(Object[] param) {
        ENTITY.PhimViewDTO phimview = new ENTITY.PhimViewDTO();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("GetPhimByMa", param);
            while (rs.next()) {
            	phimview.setMaPhim(rs.getString("MaPhim"));
            	phimview.setTenPhim(rs.getString("TenPhim"));
            	phimview.setThoiLuong(rs.getInt("ThoiLuong"));
            	phimview.setQuocGia(rs.getString("QuocGia"));
            	phimview.setDaoDien(rs.getString("DaoDien"));
            	phimview.setNamSanXuat(rs.getDate("NamSanXuat"));
            	phimview.setDoTuoiXem(rs.getInt("DoTuoiXem"));
            	phimview.setTenTheLoai(rs.getString("TenTheLoaiPhim"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return phimview;
    }
	public Vector<ENTITY.THELOAIPHIM> ListTheLoai() {
        Vector<ENTITY.THELOAIPHIM> vector = new Vector<ENTITY.THELOAIPHIM>();
        try {
            ResultSet rs = cnn.getResultSet_StoredProcedures("SelectTheLoaiPhim");
            while (rs.next()) {
            	ENTITY.THELOAIPHIM theLoai = new ENTITY.THELOAIPHIM();
            	theLoai.setMaTheLoaiPhim(rs.getString("MaTheLoaiPhim"));
            	theLoai.setTenTheLoaiPhim(rs.getString("TenTheLoaiPhim"));
                vector.addElement(theLoai);
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 2627) {
                System.out.println("Lỗi: Vi phạm ràng buộc khoá chính!");
                return null;
            } else {
                e.printStackTrace();
            }
        }
        return vector;
    }
	
	public int addData(Object[] param) {
		int k = cnn.Execute_StoredProcedures("ThemPhim", param);
		return k;
	}
	
	public int updateData(Object[] param) {
		int k = cnn.Execute_StoredProcedures("SuaPhim", param);
		return k;
	}
	
//    public Vector<ENTITY.PhimViewDTO> TimKiemByTenPhim(String tenPhim){
//        Vector<ENTITY.PhimViewDTO> vec = new Vector<ENTITY.PhimViewDTO>();
//        try {
//
//            String sql = "SELECT p.MaPhim, p.TenPhim, p.ThoiLuong, p.QuocGia, p.DaoDien, p.NamSanXuat, p.DoTuoiXem, t.TenTheLoaiPhim\r\n"
//            		+ "FROM PHIM as p Inner Join THE_LOAI_PHIM as t On p.MaTheLoai = t.MaTheLoaiPhim\r\n"
//            		+ "WHERE TenPhim LIKE ?";
//            PreparedStatement pre = cnn.prepareStatement(sql);
//            pre.setString(1, "%" + tenPhim + "%");
//            ResultSet rs = pre.executeQuery();	
//            while (rs.next()) {
//            	PhimViewDTO phimviewDTO = new PhimViewDTO();
//            	phimviewDTO.setMaPhim(rs.getString("MaPhim"));
//            	phimviewDTO.setTenPhim(rs.getString("TenPhim"));
//            	phimviewDTO.setThoiLuong(rs.getInt("ThoiLuong"));
//            	phimviewDTO.setQuocGia(rs.getString("QuocGia"));
//            	phimviewDTO.setDaoDien(rs.getString("DaoDien"));
//            	phimviewDTO.setNamSanXuat(rs.getDate("NamSanXuat"));
//            	phimviewDTO.setDoTuoiXem(rs.getInt("DoTuoiXem"));
//            	phimviewDTO.setTenTheLoai(rs.getString("TenTheLoaiPhim"));
//                vec.add(phimviewDTO);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return vec;
//    }
}
