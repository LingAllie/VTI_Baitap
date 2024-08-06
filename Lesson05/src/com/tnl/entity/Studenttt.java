package com.tnl.entity;

import com.tnl.utils.ScannerUtils;

public class Studenttt extends Person{

	private String maSV, email;
	private float dtb;
	
	public Studenttt() {
		super();
	}
	
	public Studenttt(String ten, String gioiTinh, String ngaySinh, String diachi, String maSV, String email, float dtb) {
		super(ten, gioiTinh, ngaySinh, diachi);
		this.maSV = maSV;
		this.email = email;
		this.dtb = dtb;
	}

	@Override
	public Person inputInfo() {
		String maSV = ScannerUtils.getInfor("Ma so sinh vien cua ban: ", "MSSV khong duoc de trong !");
		String email = ScannerUtils.getInfor("Email cua ban: ", "Email khong duoc de trong !");
		float dtb = ScannerUtils.getDTB();
		return new Studenttt(super.getTen(), super.getGioiTinh(), super.getNgaySinh(), super.getDiachi(), maSV, email, dtb);
	}
	
	@Override
	public String showInfo() {
		return "Sinh vien [maSV=" + maSV + ", email=" + email + ", dtb=" + dtb + "]";
	}
	
	public void xetHocBong(float dtb) {
		if(this.dtb >= 8.0) {
			System.out.println("Sinh vien DUOC NHAN HOC BONG !");
		} else {
			System.out.println("Sinh vien KHONG DUOC NHAN HOC BONG !");
		}
	}
}
