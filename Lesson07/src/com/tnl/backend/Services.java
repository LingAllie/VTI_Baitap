package com.tnl.backend;

import java.util.ArrayList;

import com.tnl.entity.NhanVien;
import com.tnl.utils.ScannerUtils;

public class Services {

	public static NhanVien taoNhanVien() {
		int id = ScannerUtils.inputInt("Nhap id cua nhan vien: ");
		int age = ScannerUtils.inputInt("Nhap tuoi nhan vien: ");
		String name = ScannerUtils.getInfor("Nhap ten nhan vien: ", "Ten nhan vien khong duoc de trong !");
		
		return new NhanVien(id, age, name);
	}
	
	public static void timKiemNhanVien(ArrayList<NhanVien> listNv) {
		int id = ScannerUtils.inputInt("Nhap id cua nhan vien can tim: ");
		NhanVien i = new NhanVien();
		for(NhanVien n: listNv) {
			if(n.getId() == id) {
				i = n;
				break;
			}
		}
		if (i.getName() != null) {
			System.out.println(i.toString());
		} else {
			System.out.println("Khong tim thay nhan vien co id = " + id);
		}
	}
}
