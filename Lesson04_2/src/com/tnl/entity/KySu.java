package com.tnl.entity;

public class KySu extends CanBo{

	private String nganhDaoTao;
	
	public KySu() {}
	
	public KySu(String hoTen, int tuoi, String gioiTinh, String diaChi, String nganhDaoTao) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.nganhDaoTao = nganhDaoTao;
	}

	@Override
	public String toString() {
		return "KySu [nganhDaoTao=" + nganhDaoTao + ", getHoTen()=" + getHoTen() + ", getTuoi()=" + getTuoi()
				+ ", getGioiTinh()=" + getGioiTinh() + ", getDiaChi()=" + getDiaChi() + "]";
	}
	
	
}
