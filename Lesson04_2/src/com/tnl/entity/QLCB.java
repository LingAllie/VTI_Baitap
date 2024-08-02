package com.tnl.entity;

import java.util.ArrayList;

public class QLCB {
	
	private ArrayList<CanBo> listCanBo;
	
	public QLCB() {
		this.listCanBo = new ArrayList<>();
	}
	
	
	// a)
	public boolean themCanBo(String hoTen, int tuoi, String gioiTinh, String diaChi) {
		return listCanBo.add(new CanBo(hoTen, tuoi, gioiTinh, diaChi));
	}
	
	
	// b)
	public void timCanBoTheoHoTen(String hoTen) {
		CanBo x = new CanBo();
		for(CanBo c : listCanBo) {
			if (c.getHoTen().equalsIgnoreCase(hoTen)) {
				x = c;
			}
		}
		if (x != null) {
			System.out.print("\nThong tin can bo can tim: " + x);
		} else {
			System.out.print("Khong co thong tin cua can bo trong danh sach quan ly !");
		}
		
	}
	
	
	// c)
	public void thongTinDanhSachCanBo() {
		for(CanBo c : listCanBo) {
			System.out.println(c.toString());
		}
	}
	
	
	// d)
	public void xoaCanBo(String hoTen) {
		for(CanBo c : listCanBo) {
			if(c.getHoTen().equalsIgnoreCase(hoTen)) {
				listCanBo.remove(c);
				System.out.println("\n\nCan bo " + hoTen + " da duoc xoa khoi danh sach !\n");
				break;
			} 
		}
		
	}
	
	// e)
	public void thoatChuongTrinh() {
		System.out.println("\nChuong trinh da ket thuc !");
		return;
	}
}
