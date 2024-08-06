package com.tnl.entity;

public class ThiSinhKhoiC extends ThiSinh{

	public ThiSinhKhoiC(String sbd, String hoTen, String diaChi, int mucUuTien) {
		super(sbd, hoTen, diaChi, mucUuTien);
	}

	@Override
	public String getKhoiThi() {
		return "Khoi C (Van, Su, Dia)";
	}

}
