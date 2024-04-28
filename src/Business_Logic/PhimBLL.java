package Business_Logic;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import ENTITY.PhimViewDTO;
import Process_Data.DBHelper;
import Process_Data.PhimDAL;

public class PhimBLL extends DBHelper {
    Process_Data.PhimDAL phimDAL;

    public PhimBLL() {
    	phimDAL = new PhimDAL();
    }
    
    public Vector<ENTITY.THELOAIPHIM> LoadTheLoai() {
    	return phimDAL.ListTheLoai();
    }	
    
    public Vector<ENTITY.PhimViewDTO> LoadPhim() {
        return phimDAL.ListPhim(); 
    }
    
    public int addData(ENTITY.PhimViewDTO phimviewDTO) {
    	Object[] param = new Object[] {phimviewDTO.getTenPhim(), phimviewDTO.getThoiLuong(), phimviewDTO.getQuocGia(), phimviewDTO.getNamSanXuat(), phimviewDTO.getDoTuoiXem(), phimviewDTO.getTenTheLoai(), phimviewDTO.getDaoDien()};
    	return phimDAL.addData(param);
    }
    
    public int updateData(ENTITY.PhimViewDTO phimviewDTO) {
    	Object[] param = new Object[] {phimviewDTO.getMaPhim(), phimviewDTO.getTenPhim(), phimviewDTO.getThoiLuong(), phimviewDTO.getQuocGia(), phimviewDTO.getNamSanXuat(), phimviewDTO.getDoTuoiXem(), phimviewDTO.getTenTheLoai(), phimviewDTO.getDaoDien()};
    	return phimDAL.updateData(param);	
    }
   
    
    public ENTITY.PhimViewDTO SelectData(String maphim) {
    	ENTITY.PhimViewDTO phimviewDTO = new ENTITY.PhimViewDTO();
    	Object[] param = new Object[] {maphim};
    	phimviewDTO = phimDAL.GetPhimByMa(param);
    	return phimviewDTO;
    }
//    public Vector<PhimViewDTO> TimKiemByTenPhim(String tenPhim) {
//        return phimDAL.TimKiemByTenPhim(tenPhim);
//    }
    public Vector<ENTITY.PhimViewDTO> TimKiemByTenPhim(String tenPhim){
        Vector<ENTITY.PhimViewDTO> vec = new Vector<ENTITY.PhimViewDTO>();
        try {

            String sql = "SELECT p.MaPhim, p.TenPhim, p.ThoiLuong, p.QuocGia, p.DaoDien, p.NamSanXuat, p.DoTuoiXem, t.TenTheLoaiPhim\r\n"
            		+ "FROM PHIM as p Inner Join THE_LOAI_PHIM as t On p.MaTheLoai = t.MaTheLoaiPhim\r\n"
            		+ "WHERE TenPhim LIKE ?";
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, "%" + tenPhim + "%");
            ResultSet rs = pre.executeQuery();	
            while (rs.next()) {
            	PhimViewDTO phimviewDTO = new PhimViewDTO();
            	phimviewDTO.setMaPhim(rs.getString("MaPhim"));
            	phimviewDTO.setTenPhim(rs.getString("TenPhim"));
            	phimviewDTO.setThoiLuong(rs.getInt("ThoiLuong"));
            	phimviewDTO.setQuocGia(rs.getString("QuocGia"));
            	phimviewDTO.setDaoDien(rs.getString("DaoDien"));
            	phimviewDTO.setNamSanXuat(rs.getDate("NamSanXuat"));
            	phimviewDTO.setDoTuoiXem(rs.getInt("DoTuoiXem"));
            	phimviewDTO.setTenTheLoai(rs.getString("TenTheLoaiPhim"));
                vec.add(phimviewDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    public Vector<ENTITY.PhimViewDTO> TimKiemByQuocGia(String quocGia){
    	Vector<ENTITY.PhimViewDTO> vec = new Vector<ENTITY.PhimViewDTO>();
        try {

            String sql = "SELECT p.MaPhim, p.TenPhim, p.ThoiLuong, p.QuocGia, p.DaoDien, p.NamSanXuat, p.DoTuoiXem, t.TenTheLoaiPhim\r\n"
            		+ "FROM PHIM as p Inner Join THE_LOAI_PHIM as t On p.MaTheLoai = t.MaTheLoaiPhim\r\n"
            		+ "WHERE QuocGia LIKE ?";
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, "%" + quocGia + "%");
            ResultSet rs = pre.executeQuery();	
            while (rs.next()) {
            	PhimViewDTO phimviewDTO = new PhimViewDTO();
            	phimviewDTO.setMaPhim(rs.getString("MaPhim"));
            	phimviewDTO.setTenPhim(rs.getString("TenPhim"));
            	phimviewDTO.setThoiLuong(rs.getInt("ThoiLuong"));
            	phimviewDTO.setQuocGia(rs.getString("QuocGia"));
            	phimviewDTO.setDaoDien(rs.getString("DaoDien"));
            	phimviewDTO.setNamSanXuat(rs.getDate("NamSanXuat"));
            	phimviewDTO.setDoTuoiXem(rs.getInt("DoTuoiXem"));
            	phimviewDTO.setTenTheLoai(rs.getString("TenTheLoaiPhim"));
                vec.add(phimviewDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    public Vector<ENTITY.PhimViewDTO> TimKiemByDaoDien(String daoDien){
    	Vector<ENTITY.PhimViewDTO> vec = new Vector<ENTITY.PhimViewDTO>();
        try {

            String sql = "SELECT p.MaPhim, p.TenPhim, p.ThoiLuong, p.QuocGia, p.DaoDien, p.NamSanXuat, p.DoTuoiXem, t.TenTheLoaiPhim\r\n"
            		+ "FROM PHIM as p Inner Join THE_LOAI_PHIM as t On p.MaTheLoai = t.MaTheLoaiPhim\r\n"
            		+ "WHERE DaoDien LIKE ?";
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, "%" + daoDien + "%");
            ResultSet rs = pre.executeQuery();	
            while (rs.next()) {
            	PhimViewDTO phimviewDTO = new PhimViewDTO();
            	phimviewDTO.setMaPhim(rs.getString("MaPhim"));
            	phimviewDTO.setTenPhim(rs.getString("TenPhim"));
            	phimviewDTO.setThoiLuong(rs.getInt("ThoiLuong"));
            	phimviewDTO.setQuocGia(rs.getString("QuocGia"));
            	phimviewDTO.setDaoDien(rs.getString("DaoDien"));
            	phimviewDTO.setNamSanXuat(rs.getDate("NamSanXuat"));
            	phimviewDTO.setDoTuoiXem(rs.getInt("DoTuoiXem"));
            	phimviewDTO.setTenTheLoai(rs.getString("TenTheLoaiPhim"));
                vec.add(phimviewDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    public Vector<ENTITY.PhimViewDTO> TimKiemByNamSanXuat(String namsx){
    	Vector<ENTITY.PhimViewDTO> vec = new Vector<ENTITY.PhimViewDTO>();
        try {

            String sql = "SELECT p.MaPhim, p.TenPhim, p.ThoiLuong, p.QuocGia, p.DaoDien, p.NamSanXuat, p.DoTuoiXem, t.TenTheLoaiPhim\r\n"
            		+ "FROM PHIM as p Inner Join THE_LOAI_PHIM as t On p.MaTheLoai = t.MaTheLoaiPhim\r\n"
            		+ "WHERE NamSanXuat LIKE ?";
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, "%" + namsx + "%");
            ResultSet rs = pre.executeQuery();	
            while (rs.next()) {
            	PhimViewDTO phimviewDTO = new PhimViewDTO();
            	phimviewDTO.setMaPhim(rs.getString("MaPhim"));
            	phimviewDTO.setTenPhim(rs.getString("TenPhim"));
            	phimviewDTO.setThoiLuong(rs.getInt("ThoiLuong"));
            	phimviewDTO.setQuocGia(rs.getString("QuocGia"));
            	phimviewDTO.setDaoDien(rs.getString("DaoDien"));
            	phimviewDTO.setNamSanXuat(rs.getDate("NamSanXuat"));
            	phimviewDTO.setDoTuoiXem(rs.getInt("DoTuoiXem"));
            	phimviewDTO.setTenTheLoai(rs.getString("TenTheLoaiPhim"));
                vec.add(phimviewDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    public Vector<ENTITY.PhimViewDTO> TimKiemByTheLoai(String theLoai){
    	Vector<ENTITY.PhimViewDTO> vec = new Vector<ENTITY.PhimViewDTO>();
        try {

            String sql = "SELECT p.MaPhim, p.TenPhim, p.ThoiLuong, p.QuocGia, p.DaoDien, p.NamSanXuat, p.DoTuoiXem, t.TenTheLoaiPhim\r\n"
            		+ "FROM PHIM as p Inner Join THE_LOAI_PHIM as t On p.MaTheLoai = t.MaTheLoaiPhim\r\n"
            		+ "WHERE TenTheLoaiPhim LIKE ?";
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, "%" + theLoai + "%");
            ResultSet rs = pre.executeQuery();	
            while (rs.next()) {
            	PhimViewDTO phimviewDTO = new PhimViewDTO();
            	phimviewDTO.setMaPhim(rs.getString("MaPhim"));
            	phimviewDTO.setTenPhim(rs.getString("TenPhim"));
            	phimviewDTO.setThoiLuong(rs.getInt("ThoiLuong"));
            	phimviewDTO.setQuocGia(rs.getString("QuocGia"));
            	phimviewDTO.setDaoDien(rs.getString("DaoDien"));
            	phimviewDTO.setNamSanXuat(rs.getDate("NamSanXuat"));
            	phimviewDTO.setDoTuoiXem(rs.getInt("DoTuoiXem"));
            	phimviewDTO.setTenTheLoai(rs.getString("TenTheLoaiPhim"));
                vec.add(phimviewDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
}
