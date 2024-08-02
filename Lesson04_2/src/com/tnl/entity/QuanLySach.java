package com.tnl.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class QuanLySach {

	private ArrayList<QLTV> listThuVien;
	
	public QuanLySach() {
		this.listThuVien = new ArrayList<>();
	}
	
	public void themTaiLieu(QLTV qltv) {
        if (qltv != null) {
            listThuVien.add(qltv);
            System.out.println("Them tai lieu thanh cong!");
        } else {
            System.out.println("Them tai lieu that bai!");
        }
    }

    public void xoaTLTheoMaTL(String maTL) {
        QLTV toRemove = null;
        for (QLTV q : listThuVien) {
            if (q.getMaTaiLieu().equalsIgnoreCase(maTL)) {
                toRemove = q;
                break;
            }
        }
        if (toRemove != null) {
            listThuVien.remove(toRemove);
            System.out.println("Xoa tai lieu thanh cong!");
        } else {
            System.out.println("Khong tim thay tai lieu voi ma: " + maTL);
        }
    }

    public void hienThiThongTinTL() {
        for (QLTV q : listThuVien) {
            System.out.println(q.toString());
        }
    }

 

}
