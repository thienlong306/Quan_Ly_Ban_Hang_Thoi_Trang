package DTO;

public class SanPham {
	
	private int MaSanPham;
	private double GiaNhap;
	private double GiaBan;
	private String TenSanPham;
	
	public SanPham () {};
	
	public SanPham (int MaSanPham,double GiaNhap, double GiaBan, String TenSanPham) {
		this.MaSanPham = MaSanPham;
		this.GiaNhap = GiaNhap;
		this.GiaBan = GiaBan;
		this.TenSanPham = TenSanPham;
	}

	
	public int getMaSanPham() {
		return MaSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		MaSanPham = maSanPham;
	}

	public double getGiaNhap() {
		return GiaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		GiaNhap = giaNhap;
	}

	public double getGiaBan() {
		return GiaBan;
	}

	public void setGiaBan(double giaBan) {
		GiaBan = giaBan;
	}

	public String getTenSanPham() {
		return TenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}
	
	
}
