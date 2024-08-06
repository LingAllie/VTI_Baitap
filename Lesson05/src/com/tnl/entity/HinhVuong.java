package com.tnl.entity;

public class HinhVuong extends HinhChuNhat{

	private float canh;
	
	public HinhVuong() {}
	
	public HinhVuong(float canh) {
		super(canh, canh);
	}
	
	@Override
	public float tinhChuVi() {
		System.out.println("Tinh chu vi theo hinh vuong: ");
		return super.tinhChuVi();
	}
	
	@Override
	public float tinhDienTich() {
		System.out.println("Tinh dien tich theo hinh vuong: ");
		return super.tinhDienTich();
	}
}
