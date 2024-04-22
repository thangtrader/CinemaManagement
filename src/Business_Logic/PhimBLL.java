package Business_Logic;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import ENTITY.PHIM;
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
    
    public int removeData(ENTITY.PhimViewDTO phimviewDTO) {
    	Object[] param = new Object[] {phimviewDTO.getMaPhim()};
    	return phimDAL.removeData(param);
    }
    
    public ENTITY.PhimViewDTO SelectData(String maphim) {
    	ENTITY.PhimViewDTO phimviewDTO = new ENTITY.PhimViewDTO();
    	Object[] param = new Object[] {maphim};
    	phimviewDTO = phimDAL.GetPhimByMa(param);
    	return phimviewDTO;
    }
    
    public Vector<ENTITY.PHIM> TimKiemByMa(String maPhim){
        Vector<ENTITY.PHIM> vec = new Vector<ENTITY.PHIM>();
        try {

            String sql = "SELECT * FROM PHIM WHERE TenPhim LIKE ?";
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, "%" + maPhim + "%");
            ResultSet rs = pre.executeQuery();	
            while (rs.next()) {
            	PHIM phim = new PHIM();
            	phim.setMaPhim(rs.getString("MaPhim"));
            	phim.setTenPhim(rs.getString("TenPhim"));
            	phim.setThoiLuong(rs.getInt("ThoiLuong"));
            	phim.setQuocGia(rs.getString("QuocGia"));
            	phim.setDaoDien(rs.getString("DaoDien"));
            	phim.setNanSanXuat(rs.getDate("NamSanXuat"));
            	phim.setDoTuoiXem(rs.getInt("DoTuoiXem"));
            	phim.setMaTheLoai(rs.getString("MaTheLoai"));
                vec.add(phim);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
}
