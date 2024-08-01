package com.tnl.entity;

public class Student {

	private int id;
	private String name;
	private String homeTown;
	private double diemHocLuc;
	
	public Student() {}
	
	public Student(int id, String name, String homeTown) {
		this.id = id;
		this.name = name;
		this.homeTown = homeTown;
		this.diemHocLuc = 0.0;
	}
	
	public double setDiemHocLuc(double diemHocLuc) {
		return this.diemHocLuc = diemHocLuc;
	}
	
	public double addDiemHocLuc(double addDiem) {
		return this.diemHocLuc += addDiem;
	}
	

	@Override
	public String toString() {
		String hocLuc;
		if (this.diemHocLuc < 4.0) {
			hocLuc = "Yeu";
		} else if (this.diemHocLuc > 4.0 && this.diemHocLuc < 6.0) {
			hocLuc = "Trung binh";
		} else if (this.diemHocLuc > 6.0 && this.diemHocLuc < 8.0) {
			hocLuc = "Kha";
		} else {
			hocLuc = "Gioi";
		}
		return "Student" + this.id + ":\n name: " + this.name + "\n hometown: " + this.homeTown + "\n diem hoc luc: " + this.diemHocLuc + "( loai " + hocLuc + " )";
	}
}
