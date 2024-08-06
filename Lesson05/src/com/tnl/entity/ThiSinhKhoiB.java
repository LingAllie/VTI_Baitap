package com.tnl.entity;

public class ThiSinhKhoiB extends ThiSinh{

	public ThiSinhKhoiB(String sbd, String hoTen, String diaChi, int mucUuTien) {
		super(sbd, hoTen, diaChi, mucUuTien);
	}

	@Override
	public String getKhoiThi() {
		return "Khoi B (Toan, Hoa, Sinh)";
	}

}
