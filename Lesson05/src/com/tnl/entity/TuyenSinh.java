package com.tnl.entity;

import java.util.ArrayList;

import com.tnl.backend.ITuyenSinh;

public class TuyenSinh implements ITuyenSinh{
	private ArrayList<ThiSinh> listThiSinh;
	
	public TuyenSinh() {
		this.listThiSinh = new ArrayList<>();
	}
	
	public TuyenSinh(ArrayList<ThiSinh> listThiSinh) {
		this.listThiSinh = listThiSinh;
	}

	@Override
	public void themThiSinh(ThiSinh thiSinh) {
		this.listThiSinh.add(thiSinh);
	}

	@Override
	public void thongTinThiSinh() {
		for(ThiSinh thiSinh: this.listThiSinh) {
			System.out.println("\nThiSinh [So bao danh: " + thiSinh.getSbd() + 
					"\nHo Ten: " + thiSinh.getHoTen() + 
					"\nDia Chi: " + thiSinh.getDiaChi() + 
					"\nMuc Uu Tien: " + thiSinh.getMucUuTien() + 
					"\nKhoi thi: " + thiSinh.getKhoiThi() + "]\n");
		}
		
	}

	@Override
	public ThiSinh timThiSinhTheoSBD(String sbd) {
		for(ThiSinh ts : this.listThiSinh) {
			if(ts.getSbd().equalsIgnoreCase(sbd))  {
				return ts;
			}
		}
		return null;
	}

	@Override
	public void thoatChuongTrinh() {
		System.out.println("Thoat chuong trinh...");
		System.exit(0);
	}

	

}
