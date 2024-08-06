package com.tnl.entity;

import com.tnl.backend.IVuKhi;

public abstract class DienThoaiDiDong implements IVuKhi{

	public String nghe, goi, guiTinNhan, nhanTinNhan;
	
	public DienThoaiDiDong() {}

	public DienThoaiDiDong(String nghe, String goi, String guiTinNhan, String nhanTinNhan) {
		this.nghe = nghe;
		this.goi = goi;
		this.guiTinNhan = guiTinNhan;
		this.nhanTinNhan = nhanTinNhan;
	}

	public String getNghe() {
		return nghe;
	}

	public void setNghe(String nghe) {
		this.nghe = nghe;
	}

	public String getGoi() {
		return goi;
	}

	public void setGoi(String goi) {
		this.goi = goi;
	}

	public String getGuiTinNhan() {
		return guiTinNhan;
	}

	public void setGuiTinNhan(String guiTinNhan) {
		this.guiTinNhan = guiTinNhan;
	}

	public String getNhanTinNhan() {
		return nhanTinNhan;
	}

	public void setNhanTinNhan(String nhanTinNhan) {
		this.nhanTinNhan = nhanTinNhan;
	}
	
	public abstract void tanCongKeXau();
	
	
}
