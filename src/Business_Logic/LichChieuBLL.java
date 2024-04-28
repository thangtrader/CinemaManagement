package Business_Logic;

import java.util.Vector;
import Process_Data.DBHelper;
import Process_Data.LichChieuDAL;


public class LichChieuBLL extends DBHelper {
	GUI.panelLICHCHIEU guiLichChieu;
	GUI.diaCAPNHATLICHCHIEU updateLich;
    Process_Data.LichChieuDAL lichDAL; 
 
    public LichChieuBLL() {
    	lichDAL = new LichChieuDAL();
    }
    public Vector<ENTITY.LICHCHIEUVIEWDTO> LoadLichChieu() {
        return lichDAL.ListLichChieu(); 
    }

    public Vector<ENTITY.KHUNGGIOCHIEU_TGBATDAU> LoadTGBatDau() {
    	return lichDAL.ListTGBatDau();
    }

    public Vector<ENTITY.KHUNGGIOCHIEU_TGKETTHUC> LoadTGKetThuc() {
    	return lichDAL.ListTGKetThuc();
    }

    public Vector<ENTITY.PHONGCHIEU> LoadPhongChieu() {
    	return lichDAL.ListPhongChieu();
    }
    public int updateData(ENTITY.LICHCHIEUVIEWDTO lichchieuDTO) {
    	Object[] param = new Object[] {lichchieuDTO.getTenPhim(), lichchieuDTO.getTenPhong(), lichchieuDTO.getNgayChieu(), lichchieuDTO.getThoiGianBatDau(), lichchieuDTO.getThoiGianKetThuc(), lichchieuDTO.getTenTinhTrang()};
    	return lichDAL.updateData(param);	
    }
    public int removeData(ENTITY.LICHCHIEUVIEWDTO lichchieuDTO) {
    	Object[] param = new Object[] {lichchieuDTO.getTenPhim(), lichchieuDTO.getTenPhong(),lichchieuDTO.getNgayChieu(),lichchieuDTO.getThoiGianBatDau()};
    	return lichDAL.removeData(param);
    }

}