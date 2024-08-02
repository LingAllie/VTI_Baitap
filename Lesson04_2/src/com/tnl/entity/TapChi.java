package com.tnl.entity;

public class TapChi extends QLTV{
	
	private int soPhatHanh;
	private int thangPhatHanh;
	
	public TapChi() {}
	
	public TapChi(String maTL, String nxb, int soBPH, int soPH, int thangPH) {
		super(maTL, nxb, soBPH);
		this.soPhatHanh = soPH;
		this.thangPhatHanh = thangPH;
	}

	public int getSoPhatHanh() {
		return soPhatHanh;
	}

	public void setSoPhatHanh(int soPhatHanh) {
		this.soPhatHanh = soPhatHanh;
	}

	public int getThangPhatHanh() {
		return thangPhatHanh;
	}

	public void setThangPhatHanh(int thangPhatHanh) {
		this.thangPhatHanh = thangPhatHanh;
	}

	@Override
	public String toString() {
		return "TapChi [soPhatHanh=" + this.getSoPhatHanh() + ", thangPhatHanh=" + this.getThangPhatHanh() + ", getMaTaiLieu()="
				+ super.getMaTaiLieu() + ", getNhaXuatBan()=" + super.getNhaXuatBan() + ", getSoBanPhatHanh()=" + super.getSoBanPhatHanh()
				+ "]";
	}
	
	
	
}
