package com.tnl.entity;

public class HinhChuNhat {

	private float cDai, cRong;
	
	public HinhChuNhat() {}

	public HinhChuNhat(float cDai, float cRong) {
		this.cDai = cDai;
		this.cRong = cRong;
	}
	
	public float tinhChuVi() {
		System.out.println("Tinh chu vi theo hinh chu nhat: ");
		return (this.cDai + this.cRong) * 2;
	}
	
	public float tinhDienTich() {
		System.out.println("Tinh dien tich theo hinh chu nhat: ");
		return this.cDai * this.cRong;
	}
}
