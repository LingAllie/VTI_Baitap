package com.tnl.entity;

public class DienThoaiCoDien extends DienThoaiDiDong{

	public String ngheRadio;
	
	public DienThoaiCoDien() {}
	
	public DienThoaiCoDien(String nghe, String goi, String guiTinNhan, String nhanTinNhan, String ngheRadio) {
		super(nghe, goi, guiTinNhan, nhanTinNhan);
		this.ngheRadio = ngheRadio;
	}

	@Override
	public void tanCongKeXau() {
		System.out.println("Dien thoai co dien duoc su dung lam vu khi tan cong !");
		
	}
}
