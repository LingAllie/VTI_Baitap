package com.tnl.entity;

import java.time.LocalDate;

public class Bao extends QLTV{

	private LocalDate ngayPhatHanh;
	
	public Bao() {}
	
	public Bao(String maTL, String nxb, int soBPH, LocalDate ngayPH) {
		super(maTL, nxb, soBPH);
		this.ngayPhatHanh = ngayPH;
	}

	public LocalDate getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(LocalDate ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	@Override
	public String toString() {
		return "Bao [ngayPhatHanh=" + this.ngayPhatHanh + ", getNgayPhatHanh()=" + this.getNgayPhatHanh() + ", getMaTaiLieu()="
				+ super.getMaTaiLieu() + ", getNhaXuatBan()=" + super.getNhaXuatBan() + ", getSoBanPhatHanh()=" + super.getSoBanPhatHanh()
				+ "]";
	}
	
	
}
