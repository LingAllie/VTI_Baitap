package com.tnl.entity;

import com.tnl.utils.ScannerUtils;

public class Person {

	private String ten, gioiTinh, ngaySinh, diachi;
	
	public Person() {}

	public Person(String ten, String gioiTinh, String ngaySinh, String diachi) {
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diachi = diachi;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	public Person inputInfo() {
		String ten = ScannerUtils.getInfor("Ten cua ban: ", "Ten khong duoc de trong !");
		String gTinh = ScannerUtils.getInfor("Gioi tinh cua ban: ", "Gioi tinh khong duoc de trong !");
		String nSinh = ScannerUtils.getInfor("Ngay sinh cua ban: ", "Ngay sinh khong duoc de trong !");
		String dChi = ScannerUtils.getInfor("Dia chi cua ban: ", "Dia chi khong duoc de trong !");
		
		return new Person(ten, gTinh, nSinh, dChi);
	}
	
	public String showInfo() {
		return "Person [ten=" + ten + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diachi=" + diachi + "]";
	}
	
	
}
