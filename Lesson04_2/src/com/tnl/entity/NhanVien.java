package com.tnl.entity;

public class NhanVien extends CanBo{

	private String congViec;
	
	public NhanVien() {}
	
	public NhanVien(String hoTen, int tuoi, String gioiTinh, String diaChi, String congViec) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.congViec = congViec;
	}

	@Override
	public String toString() {
		return "NhanVien [congViec=" + congViec + ", getHoTen()=" + getHoTen() + ", getTuoi()=" + getTuoi()
				+ ", getGioiTinh()=" + getGioiTinh() + ", getDiaChi()=" + getDiaChi() + "]";
	}
	
	
}

