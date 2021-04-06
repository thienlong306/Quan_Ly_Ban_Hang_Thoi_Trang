package BLL;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DTO.HoaDon;
import DTO.KhachHang;
import DTO.NhanVien;
import DTO.SanPham;
import UTILS.ConnectionUtil;
	
public class Export {
	public void XuatKH() throws IOException {
		ArrayList<KhachHang> LoadDataKh = new ArrayList<>();
        try {
    		ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry = "SELECT * FROM khachhang";
        	PreparedStatement ps = conn.prepareStatement(qry);
        	ResultSet rs = ps.executeQuery();
        	KhachHang khachhang;
            while (rs.next()) {
            	khachhang = new KhachHang();
            	khachhang.setMaKhachHang(rs.getString(1));
            	khachhang.setTenKhachHang(rs.getString(2));
            	khachhang.setNgaySinh(rs.getString(3));
            	khachhang.setDiaChi(rs.getString(4));
            	khachhang.setSoDT(rs.getString(5));
            	LoadDataKh.add(khachhang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

	String[] columns = { "Mã Khách Hàng", "Tên Khách Hàng", "Ngày Sinh",
    "Địa Chỉ","Số Điện Thoại" };


    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet();

    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 14);
    headerFont.setColor(IndexedColors.RED.getIndex());

    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);

    // Create a Row
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
      cell.setCellStyle(headerCellStyle);
    }

    // Create Other rows and cells with contacts data
    int rowNum = 1;

    for (KhachHang contact : LoadDataKh) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(contact.getMaKhachHang());
        row.createCell(1).setCellValue(contact.getTenKhachHang());
        row.createCell(2).setCellValue(contact.getNgaySinh());
        row.createCell(3).setCellValue(contact.getDiaChi());
        row.createCell(4).setCellValue(contact.getSoDT());
      }

    // Resize all columns to fit the content size
    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }

    // Write the output to a file
    FileOutputStream fileOut = new FileOutputStream("khachhang.xlsx");
    workbook.write(fileOut);
    fileOut.close();
	}
	
	public void XuatHD() throws IOException {
		ArrayList<HoaDon> LoadDataHd = new ArrayList<>();
        try {
    		ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry = "SELECT * FROM hoadon";
        	PreparedStatement ps = conn.prepareStatement(qry);
        	ResultSet rs = ps.executeQuery();
        	HoaDon hoadon;
            while (rs.next()) {
            	hoadon = new HoaDon();
            	hoadon.setMaHoaDon(rs.getString(1));
            	hoadon.setMaKhacHang(rs.getString(2));
            	hoadon.setMaNhanVien(rs.getString(3));
            	hoadon.setMaSanPham(rs.getString(4));
            	hoadon.setNgayLapHoaDon(rs.getString(5));
            	hoadon.setTongTien(rs.getDouble(6));
            	LoadDataHd.add(hoadon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] columns= {"Mã Hoá Đơn","Mã Khách Hàng","Mã Nhân Viên","Mã Sản Phẩm","Ngày Sửa Lần Cuối","Tổng Tiền"};


    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet();

    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 14);
    headerFont.setColor(IndexedColors.RED.getIndex());

    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);

    // Create a Row
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
      cell.setCellStyle(headerCellStyle);
    }

    // Create Other rows and cells with contacts data
    int rowNum = 1;

    for (HoaDon contact : LoadDataHd) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(contact.getMaHoaDon());
        row.createCell(1).setCellValue(contact.getMaKhacHang());
        row.createCell(2).setCellValue(contact.getMaNhanVien());
        row.createCell(3).setCellValue(contact.getMaSanPham());
        row.createCell(4).setCellValue(contact.getNgayLapHoaDon());
        row.createCell(5).setCellValue(contact.getTongTien());
      }

    // Resize all columns to fit the content size
    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }

    // Write the output to a file
    FileOutputStream fileOut = new FileOutputStream("hoadon.xlsx");
    workbook.write(fileOut);
    fileOut.close();
	}
	
	public void XuatNV() throws IOException {
		ArrayList<NhanVien> LoadDataNv = new ArrayList<>();
        try {
    		ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry = "SELECT * FROM nhanvien";
        	PreparedStatement ps = conn.prepareStatement(qry);
        	ResultSet rs = ps.executeQuery();
        	NhanVien nhanvien;
            while (rs.next()) {
            	nhanvien = new NhanVien();
            	nhanvien.setMaNhanVien(rs.getInt(1));
            	nhanvien.setTenDangNhap(rs.getString(2));
            	nhanvien.setPassword(rs.getString(3));
            	nhanvien.setTenNhanVien(rs.getString(4));
            	nhanvien.setNgayDK(rs.getString(5));
            	nhanvien.setDiaChi(rs.getString(6));
            	nhanvien.setSoDT(rs.getString(7));
                LoadDataNv.add(nhanvien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] columns= {"Mã Nhân Viên","Tên Đăng Nhập","Password","Tên Nhân Viên","Ngày Đăng Ký","Địa Chỉ","Số Điện Thoại"};


    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet();

    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 14);
    headerFont.setColor(IndexedColors.RED.getIndex());

    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);

    // Create a Row
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
      cell.setCellStyle(headerCellStyle);
    }

    // Create Other rows and cells with contacts data
    int rowNum = 1;

    for (NhanVien contact : LoadDataNv) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(contact.getMaNhanVien());
        row.createCell(1).setCellValue(contact.getTenDangNhap());
        row.createCell(2).setCellValue(contact.getPassword());
        row.createCell(3).setCellValue(contact.getTenNhanVien());
        row.createCell(4).setCellValue(contact.getNgayDK());
        row.createCell(5).setCellValue(contact.getDiaChi());
        row.createCell(6).setCellValue(contact.getSoDT());
      }

    // Resize all columns to fit the content size
    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }

    // Write the output to a file
    FileOutputStream fileOut = new FileOutputStream("nhanvien.xlsx");
    workbook.write(fileOut);
    fileOut.close();
	}
	
	public void XuatSP() throws IOException {
		ArrayList<SanPham> LoadDataSp = new ArrayList<>();
        try {
    		ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry = "SELECT * FROM sanpham";
        	PreparedStatement ps = conn.prepareStatement(qry);
        	ResultSet rs = ps.executeQuery();
        	SanPham sanpham;
            while (rs.next()) {
                sanpham = new SanPham();
                sanpham.setMaSanPham(rs.getInt(1));
                sanpham.setGiaNhap(rs.getDouble(2));
                sanpham.setGiaBan(rs.getDouble(3));
                sanpham.setTenSanPham(rs.getString(4));
                LoadDataSp.add(sanpham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] columns= {"Mã Sản Phẩm","Giá Nhập","Giá Bán","Tên Sản Phẩm"};


    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet();

    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 14);
    headerFont.setColor(IndexedColors.RED.getIndex());

    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);

    // Create a Row
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
      cell.setCellStyle(headerCellStyle);
    }

    // Create Other rows and cells with contacts data
    int rowNum = 1;

    for (SanPham contact : LoadDataSp) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(contact.getMaSanPham());
        row.createCell(1).setCellValue(contact.getGiaNhap());
        row.createCell(2).setCellValue(contact.getGiaBan());
        row.createCell(3).setCellValue(contact.getTenSanPham());
      }

    // Resize all columns to fit the content size
    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }

    // Write the output to a file
    FileOutputStream fileOut = new FileOutputStream("sanpham.xlsx");
    workbook.write(fileOut);
    fileOut.close();
	}
}