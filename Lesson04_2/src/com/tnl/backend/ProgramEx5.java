package com.tnl.backend;

import com.tnl.entity.CongNhan;
import com.tnl.entity.KySu;
import com.tnl.entity.NhanVien;

public class ProgramEx5 {

	public static void main(String[] args ) {

		CongNhan c1 = new CongNhan("Yin", 26, "Nu", "HCM");
		c1.setLevel(1);
		
		System.out.println(c1.toString());
		
		KySu k1 = new KySu("Young", 22, "Nu", "HCM", "Phan mem");
		
		System.out.println(k1.toString());
		
		NhanVien n1 = new NhanVien("Yang", 30, "Nam", "HCM", "Ke toan");
		
		System.out.println(n1.toString());
	}
}
