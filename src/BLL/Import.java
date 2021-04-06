package BLL;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DTO.KhachHang;
import UTILS.ConnectionUtil;

public class Import {
	public static String id;
	public void NhapKH() throws IOException {
			
		
			
			File excel = new File ("khachhang.xlsx");
			FileInputStream fis = new FileInputStream(excel);
			
			XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(new PushbackInputStream(fis));
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> rowIt = sheet.iterator();
			int dem=0;
			while(rowIt.hasNext()) {
				if (dem==0) {
					Row row = rowIt.next();
					dem++;
				}
				Row row = rowIt.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				for (int i=0;i<5;i++) {
					Cell cell = cellIterator.next();
					try {
					ConnectionUtil conUtil = new ConnectionUtil();
			        Connection conn = conUtil.getConnection();
					if(i==0) id=cell.toString();
					if(i==1) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `khachhang` SET `TenKhachHang`=\""+ cell.toString()+"\" WHERE `MaKhachHang`=" + id);
						ps.executeUpdate();
					}
					if(i==3) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `khachhang` SET `DiaChi`=\""+ cell.toString()+"\"  WHERE `MaKhachHang`=" + id);
						ps.executeUpdate(); 
					}
					if(i==4) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `khachhang` SET `SoDT`=\""+ cell.toString()+"\" WHERE `MaKhachHang`=" + id);
						ps.executeUpdate(); 
					}
				}
				catch   (Exception e) {
		            e.printStackTrace();
		        }
				}
				
				
				System.out.println();
			}
			
			workbook.close();
			fis.close();
			
	}
	public void NhapHD() throws IOException {
		
		
		
		File excel = new File ("hoadon.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		
		XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(new PushbackInputStream(fis));
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIt = sheet.iterator();
		int dem=0;
		while(rowIt.hasNext()) {
			if (dem==0) {
				Row row = rowIt.next();
				dem++;
			}
			Row row = rowIt.next();
			
			Iterator<Cell> cellIterator = row.cellIterator();
			for (int i=0;i<6;i++) {
				Cell cell = cellIterator.next();
				try {
				ConnectionUtil conUtil = new ConnectionUtil();
		        Connection conn = conUtil.getConnection();
				if(i==0) id=cell.toString();
				if(i==1) {
					PreparedStatement ps = conn.prepareStatement("UPDATE `hoadon` SET `MaKhachHang`="+ cell.toString()+" WHERE `MaHoaDon`=" + id);
					ps.executeUpdate();
				}
				if(i==2) {
					PreparedStatement ps = conn.prepareStatement("UPDATE `hoadon` SET `MaNhanVien`="+ cell.toString()+" WHERE `MaHoaDon`=" + id);
					ps.executeUpdate();
				}
				if(i==3) {
					PreparedStatement ps = conn.prepareStatement("UPDATE `hoadon` SET `MaSanPham`="+ cell.toString()+" WHERE `MaHoaDon`=" + id);
					ps.executeUpdate();
				}
				if(i==5) {
					PreparedStatement ps = conn.prepareStatement("UPDATE `hoadon` SET `TongTien`="+ cell.toString()+" WHERE `MaHoaDon`=" + id);
					ps.executeUpdate();
				}
			}
			catch   (Exception e) {
	            e.printStackTrace();
	        }
			}
			
			
			System.out.println();
		}
		
		workbook.close();
		fis.close();
		
	}
	
public void NhapNV() throws IOException {
		
		
		
		File excel = new File ("nhanvien.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		
		XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(new PushbackInputStream(fis));
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIt = sheet.iterator();
		int dem=0;
		while(rowIt.hasNext()) {
			if (dem==0) {
				Row row = rowIt.next();
				dem++;
			}
			Row row = rowIt.next();
			
			Iterator<Cell> cellIterator = row.cellIterator();
			for (int i=0;i<7;i++) {
				Cell cell = cellIterator.next();
				try {
				ConnectionUtil conUtil = new ConnectionUtil();
		        Connection conn = conUtil.getConnection();
				if(i==0) id=cell.toString();
				if(i==1) {
					PreparedStatement ps = conn.prepareStatement("UPDATE `nhanvien` SET `TenDangNhap`=\""+ cell.toString()+"\" WHERE `MaNhanVien`=" + id);
					ps.executeUpdate();
				}
				if(i==2) {
					PreparedStatement ps = conn.prepareStatement("UPDATE `nhanvien` SET `Password`=\""+ cell.toString()+"\" WHERE `MaNhanVien`=" + id);
					ps.executeUpdate();
				}
				if(i==3) {
					PreparedStatement ps = conn.prepareStatement("UPDATE `nhanvien` SET `TenNhanVien`=\""+ cell.toString()+"\" WHERE `MaNhanVien`=" + id);
					ps.executeUpdate();
				}
				if(i==5) {
					PreparedStatement ps = conn.prepareStatement("UPDATE `nhanvien` SET `DiaChi`=\""+ cell.toString()+"\" WHERE `MaNhanVien`=" + id);
					ps.executeUpdate();
				}
				if(i==6) {
					PreparedStatement ps = conn.prepareStatement("UPDATE `nhanvien` SET `SoDT`=\""+ cell.toString()+"\" WHERE `MaNhanVien`=" + id);
					ps.executeUpdate();
				}
			}
			catch   (Exception e) {
	            e.printStackTrace();
	        }
			}
			
			
			System.out.println();
		}
		
		workbook.close();
		fis.close();
		
}

public void NhapSP() throws IOException {
	
	File excel = new File ("sanpham.xlsx");
	FileInputStream fis = new FileInputStream(excel);
	
	XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(new PushbackInputStream(fis));
	XSSFSheet sheet = workbook.getSheetAt(0);
	
	Iterator<Row> rowIt = sheet.iterator();
	int dem=0;
	while(rowIt.hasNext()) {
		if (dem==0) {
			Row row = rowIt.next();
			dem++;
		}
		Row row = rowIt.next();
		
		Iterator<Cell> cellIterator = row.cellIterator();
		for (int i=0;i<4;i++) {
			Cell cell = cellIterator.next();
			try {
			ConnectionUtil conUtil = new ConnectionUtil();
	        Connection conn = conUtil.getConnection();
			if(i==0) id=cell.toString();
			if(i==1) {
				PreparedStatement ps = conn.prepareStatement("UPDATE `sanpham` SET `GiaNhap`="+ cell.toString()+" WHERE `MaSanPham`=" + id);
				ps.executeUpdate();
			}
			if(i==2) {
				PreparedStatement ps = conn.prepareStatement("UPDATE `sanpham` SET `GiaBan`="+ cell.toString()+" WHERE `MaSanPham`=" + id);
				ps.executeUpdate();
			}
			if(i==3) {
				PreparedStatement ps = conn.prepareStatement("UPDATE `sanpham` SET `TenSanPham`=\""+ cell.toString()+"\" WHERE `MaSanPham`=" + id);
				ps.executeUpdate();
			}
			
		}
		catch   (Exception e) {
            e.printStackTrace();
        }
		}
		
		
		System.out.println();
	}
	
	workbook.close();
	fis.close();
	
}
}
