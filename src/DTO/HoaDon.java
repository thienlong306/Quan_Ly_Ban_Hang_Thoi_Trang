package DTO;

public class HoaDon {
	
	private String MaHoaDon;
	private String MaKhacHang;
	private String MaNhanVien;
	private String MaSanPham;
	private String NgayLapHoaDon;
	private double TongTien;
	
	public HoaDon() {};
	
	public HoaDon (String MaHoaDon, String MaKhacHang, String MaNhanVien, String MaSanPham, String NgayLapHoaDon, double TongTien) {
		this.MaHoaDon = MaHoaDon;
		this.MaKhacHang = MaKhacHang;
		this.MaNhanVien = MaNhanVien;
		this.MaSanPham = MaSanPham;
		this.NgayLapHoaDon = NgayLapHoaDon;
		this.TongTien = TongTien;
	}

	public String getMaHoaDon() {
		return MaHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}

	public String getMaKhacHang() {
		return MaKhacHang;
	}

	public void setMaKhacHang(String maKhacHang) {
		MaKhacHang = maKhacHang;
	}

	public String getMaNhanVien() {
		return MaNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public String getMaSanPham() {
		return MaSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		MaSanPham = maSanPham;
	}

	public String getNgayLapHoaDon() {
		return NgayLapHoaDon;
	}

	public void setNgayLapHoaDon(String ngayLapHoaDon) {
		NgayLapHoaDon = ngayLapHoaDon;
	}

	public double getTongTien() {
		return TongTien;
	}

	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}
	
	
}
