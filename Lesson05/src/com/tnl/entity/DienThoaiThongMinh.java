package com.tnl.entity;

public class DienThoaiThongMinh extends DienThoaiDiDong{

	public String suDung3G, chupHinh;
	
	public DienThoaiThongMinh() {}
	
	public DienThoaiThongMinh(String nghe, String goi, String guiTinNhan, String nhanTinNhan, String suDung3G, String chupHinh) {
		super(nghe, goi, guiTinNhan, nhanTinNhan);
		this.suDung3G = suDung3G;
		this.chupHinh = chupHinh;
	}

	@Override
	public void tanCongKeXau() {
		System.out.println("Dien thoai thong minh duoc su dung lam vu khi tan cong !");
		
	}
}
