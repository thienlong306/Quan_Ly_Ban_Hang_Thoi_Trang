package DTO;

public class NhanVien {
	
	private int MaNhanVien;
	private String TenDangNhap;
	private String Password;
	private String TenNhanVien;
	private String NgayDK;
	private String DiaChi;
	private String SoDT;
	
	public NhanVien() {};
	
	public NhanVien(int MaNhanVien, String TenDangNhap, String Password, String TenNhanVien, String NgayDK, String DiaChi, String SoDT) {
	this.MaNhanVien = MaNhanVien; 
	this.TenDangNhap = TenDangNhap;
	this.Password = Password;
	this.TenNhanVien = TenNhanVien;
	this.NgayDK = NgayDK;
	this.SoDT = SoDT;
	}

	
	public int getMaNhanVien() {
		return MaNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public String getTenDangNhap() {
		return TenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getTenNhanVien() {
		return TenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
	}

	public String getNgayDK() {
		return NgayDK;
	}

	public void setNgayDK(String ngayDk) {
		NgayDK = ngayDk;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSoDT() {
		return SoDT;
	}

	public void setSoDT(String soDT) {
		SoDT = soDT;
	}
	
	
}
