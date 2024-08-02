package com.tnl.backend;

import java.time.LocalDate;
import java.util.ArrayList;

import com.tnl.entity.Bao;
import com.tnl.entity.CanBo;
import com.tnl.entity.CongNhan;
import com.tnl.entity.HighSchoolStudent;
import com.tnl.entity.KySu;
import com.tnl.entity.NhanVien;
import com.tnl.entity.QLCB;
import com.tnl.entity.QuanLySach;
import com.tnl.entity.Sach;
import com.tnl.entity.TapChi;

public class ProgramEx5 {

	public static void main(String[] args ) {
		
		System.out.println("Ex 5: Inheritance");
		System.out.println("\nQuestion 1:");
		

		CongNhan c1 = new CongNhan("Yin", 26, "Nu", "HCM");
		c1.setLevel(1);
		
		System.out.println(c1.toString());
		
		KySu k1 = new KySu("Young", 22, "Nu", "HCM", "Phan mem");
		
		System.out.println("\n" + k1.toString());
		
		NhanVien n1 = new NhanVien("Yang", 30, "Nam", "HCM", "Ke toan");
		
		System.out.println("\n" + n1.toString());
		
		// --------------------------------------------------------------
		
		System.out.println("\nQuestion 2:");
		
		QLCB listCanBo = new QLCB();
		listCanBo.themCanBo("Yin", 20, "Female", "TPHCM");
		listCanBo.themCanBo("Yang", 19, "Male", "HaNoi");
		listCanBo.themCanBo("Ying", 24, "Female", "DaNang");
		listCanBo.themCanBo("Young", 30, "Female", "HaiPhong");
		listCanBo.themCanBo("Yue", 26, "Male", "HaiDuong");
		
		listCanBo.thongTinDanhSachCanBo();
		
		listCanBo.timCanBoTheoHoTen("YAnG");
		
		listCanBo.xoaCanBo("YounG");
		
		listCanBo.thongTinDanhSachCanBo();
		
		listCanBo.thoatChuongTrinh();
		
		// -----------------------------------------------------------
		
		System.out.println("\nQuestion 3:");
		
		HighSchoolStudent hss = new HighSchoolStudent("Nam", 1, "Chuyên Văn", "Đại học công nghệ");
		System.out.println(hss.toString());

		// -----------------------------------------------------------
		
		System.out.println("\nQuestion 4:");
		QuanLySach qls = new QuanLySach();
        
        Sach sach = new Sach("S001", "NXB Kim Dong", 1000, "Nguyen Nhat Anh", 200);
        TapChi tapChi = new TapChi("TC001", "NXB Tre", 500, 10, 7);
        Bao bao = new Bao("B001", "NXB Lao Dong", 200, LocalDate.of(2024, 8, 2));

        qls.themTaiLieu(sach);
        qls.themTaiLieu(tapChi);
        qls.themTaiLieu(bao);
        
        System.out.println("\nTat ca tai lieu:");
        qls.hienThiThongTinTL();

        System.out.println("\nXoa tai lieu ma S001:");
        qls.xoaTLTheoMaTL("S001");
        qls.hienThiThongTinTL();

        
		
	}
}
