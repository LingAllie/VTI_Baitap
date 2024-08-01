package com.tnl.entity;

public class CongNhan extends CanBo{
	
	private int level;
	
	public CongNhan() {}
	
	public CongNhan(String hoTen, int tuoi, String gioiTinh, String diaChi) {
		super(hoTen, tuoi, gioiTinh, diaChi);
	}
	
	public void setLevel(int level) {
		 if (level >= 1 && level <= 10) {
	            this.level = level;
	        } else {
	            throw new IllegalArgumentException("Level must be between 1 and 10.");
	        }
	}
	
	public int getLevel() {
		return this.level;
	}

	@Override
	public String toString() {
		return "CongNhan [level=" + level + ", getHoTen()=" + super.getHoTen() + ", getTuoi()=" + super.getTuoi()
				+ ", getGioiTinh()=" + super.getGioiTinh() + ", getDiaChi()=" + super.getDiaChi() + "]";
	}
	
	
}
