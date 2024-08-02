package com.tnl.entity;

public class Sach extends QLTV{

	private String tacGia;
	private int soTrang;
	
	public Sach() {}
	
	public Sach(String maTL, String nxb, int soBPH, String tacGia, int soTrang) {
		super(maTL, nxb, soBPH);
		this.tacGia = tacGia;
		this.soTrang = soTrang;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	@Override
	public String toString() {
		return "Sach [tacGia=" + this.tacGia + ", soTrang=" + this.soTrang + ", getMaTaiLieu()=" + super.getMaTaiLieu()
				+ ", getNhaXuatBan()=" + super.getNhaXuatBan() + ", getSoBanPhatHanh()=" + super.getSoBanPhatHanh() + "]";
	}
	
	
}
