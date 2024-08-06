package com.tnl.entity;

public abstract class ThiSinh {

	private String sbd;
	private String hoTen;
	private String diaChi;
	private int mucUuTien;
	
	public ThiSinh() {}

	public ThiSinh(String sbd, String hoTen, String diaChi, int mucUuTien) {
		this.sbd = sbd;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.mucUuTien = mucUuTien;
	}

	public String getSbd() {
		return sbd;
	}

	public void setSbd(String sbd) {
		this.sbd = sbd;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getMucUuTien() {
		return mucUuTien;
	}

	public void setMucUuTien(int mucUuTien) {
		this.mucUuTien = mucUuTien;
	}
	
	public abstract String getKhoiThi();

	@Override
	public String toString() {
		return "ThiSinh [sbd=" + sbd + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", mucUuTien=" + mucUuTien + ", khoiThi=" + this.getKhoiThi() + "]";
	}
	
	
}
