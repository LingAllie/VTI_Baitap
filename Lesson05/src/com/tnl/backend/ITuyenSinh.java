package com.tnl.backend;

import com.tnl.entity.ThiSinh;

public interface ITuyenSinh {

	public abstract void themThiSinh(ThiSinh thiSinh);
	public abstract void thongTinThiSinh();
	public abstract ThiSinh timThiSinhTheoSBD(String sbd);
	public abstract void thoatChuongTrinh();
}
