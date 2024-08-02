package com.tnl.entity;

public class QLTV {

	private String maTaiLieu;
	private String nhaXuatBan;
	private int soBanPhatHanh;
	
	public QLTV() {}
	
	public QLTV(String maTL, String nxb, int soBPH) {
		this.maTaiLieu = maTL;
		this.nhaXuatBan = nxb;
		this.soBanPhatHanh = soBPH;
	}

	public String getMaTaiLieu() {
		return maTaiLieu;
	}

	public void setMaTaiLieu(String maTaiLieu) {
		this.maTaiLieu = maTaiLieu;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public int getSoBanPhatHanh() {
		return soBanPhatHanh;
	}

	public void setSoBanPhatHanh(int soBanPhatHanh) {
		this.soBanPhatHanh = soBanPhatHanh;
	}

	@Override
	public String toString() {
		return "QLTV [maTaiLieu=" + this.maTaiLieu + ", nhaXuatBan=" + this.nhaXuatBan + ", soBanPhatHanh=" + this.soBanPhatHanh + "]";
	}
	
	
}
