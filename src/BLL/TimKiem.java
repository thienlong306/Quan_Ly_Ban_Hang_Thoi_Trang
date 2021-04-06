package BLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.HoaDon;
import DTO.KhachHang;
import DTO.NhanVien;
import DTO.SanPham;
import UTILS.ConnectionUtil;

public class TimKiem {

	public ArrayList<KhachHang> timkiemKH(int index, String search) {
        ArrayList<KhachHang> LoadDataKh = new ArrayList<>();
        try {
    		ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry=null;
        	System.out.println(index);
        	if (index == 0) {qry = "SELECT * FROM khachhang WHERE `MaKhachHang`=" + search ;}
        	if (index == 1) { qry = "SELECT * FROM khachhang WHERE `TenKhachHang`=\"" + search + "\"";}
        	if (index == 2) { qry = "SELECT * FROM khachhang WHERE `DiaChi`=\"" + search + "\"";}
        	if (index == 3){ qry = "SELECT * FROM khachhang WHERE `SoDT`=\"" + search + "\"" ;}
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
        return LoadDataKh;
    }
	public ArrayList<HoaDon> timkiemHD(int index, String search) {
        ArrayList<HoaDon> LoadDataHd = new ArrayList<>();
        try {
    		ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry=null;
        	System.out.println(index);
        	if (index == 0) {qry = "SELECT * FROM hoadon WHERE `MaHoaDon`=" + search ;}
        	if (index == 1) { qry = "SELECT * FROM hoadon WHERE `MaKhachHang`=" + search ;}
        	if (index == 2) { qry = "SELECT * FROM hoadon WHERE `MaNhanVien`=" + search ;}
        	if (index == 3){ qry = "SELECT * FROM hoadon WHERE `MaSanPham`=" + search ;}
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
        return LoadDataHd;
    }
	public ArrayList<NhanVien> timkiemNV(int index, String search) {
        ArrayList<NhanVien> LoadDataNv = new ArrayList<>();
        try {
    		ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry=null;
        	System.out.println(index);
        	if (index == 0) {qry = "SELECT * FROM nhanvien WHERE `MaNhanVien`=" + search ;}
        	if (index == 1) { qry = "SELECT * FROM nhanvien WHERE `TenDangNhap`=\"" + search + "\"" ;}
        	if (index == 2) { qry = "SELECT * FROM nhanvien WHERE `TenNhanVien`=\"" + search + "\"" ;}
        	if (index == 3){ qry = "SELECT * FROM nhanvien WHERE `DiaChi`=\"" + search + "\"";}
        	if (index == 4){ qry = "SELECT * FROM nhanvien WHERE `SoDT`=\"" + search+"\"" ;}
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
        return LoadDataNv;
    }
	
	public ArrayList<SanPham> timkiemSP(int index, String search) {
        ArrayList<SanPham> LoadDataSp = new ArrayList<>();
        try {
    		ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry=null;
        	System.out.println(index);
        	if (index == 0) {qry = "SELECT * FROM sanpham WHERE `MaSanPham`=" + search ;}
        	if (index == 1) { qry = "SELECT * FROM sanpham WHERE `GiaNhap`=" + search  ;}
        	if (index == 2) { qry = "SELECT * FROM sanpham WHERE `GiaBan`=" + search  ;}
        	if (index == 3){ qry = "SELECT * FROM sanpham WHERE `TenSanPham`=\"" + search + "\"";}
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
        return LoadDataSp;
    }
	
}
