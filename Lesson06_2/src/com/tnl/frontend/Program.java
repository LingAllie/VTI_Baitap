package com.tnl.frontend;

import java.util.ArrayList;

import com.tnl.backend.Services;
import com.tnl.entity.NhanVien;
import com.tnl.utils.ScannerUtils;

public class Program {

	public static void main(String[] args) {
		ArrayList<NhanVien> listNv = new ArrayList<>();
		menu();
		while (true) {
			int choice = ScannerUtils.inputInt("\nMoi ban chon chuc nang tuong ung: ");
			switch(choice) {
			case 1:
				listNv.add(Services.taoNhanVien());
				System.out.println("Da tao xong nhan vien");
				break;
			case 2:
				Services.timKiemNhanVien(listNv);
				break;
			case 3: 
				System.out.println("Thoat chuong trinh...");
				return;
			default:
				System.out.println("Lua chon khong ton tai !");
				break;
			}
		}
	}

	public static void menu() {
		System.out.println("Quan ly nhan vien");
		System.out.println("1: Tao nhan vien");
		System.out.println("2: Tim kiem nhan vien");
		System.out.println("3. Thoat");
	}
}
