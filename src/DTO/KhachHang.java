package DTO;

public class KhachHang {

	private String MaKhachHang;
	private String TenKhachHang;
	private String NgaySinh;
	private String DiaChi;
	private String SoDT;
	
	public KhachHang() {};
	
	public KhachHang(String MaKhachHang, String TenKhachHang,String NgaySinh,String DiaChi,String SoDT ) {
		this.MaKhachHang=MaKhachHang;
		this.TenKhachHang=TenKhachHang;
		this.NgaySinh=NgaySinh;
		this.DiaChi=DiaChi;
		this.SoDT=SoDT;
	}

	public String getMaKhachHang() {
		return MaKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		MaKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return TenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}

	public String getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
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
