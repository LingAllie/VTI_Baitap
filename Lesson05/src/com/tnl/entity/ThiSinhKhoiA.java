package com.tnl.entity;

public class ThiSinhKhoiA extends ThiSinh {

	public ThiSinhKhoiA(String sbd, String hoTen, String diaChi, int mucUuTien) {
		super(sbd, hoTen, diaChi, mucUuTien);
	}

	@Override
	public String getKhoiThi() {
		return "Khoi A (Toan, Ly, Hoa)";
	}
	
	
}
