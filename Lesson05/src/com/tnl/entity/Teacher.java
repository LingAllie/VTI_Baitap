package com.tnl.entity;

import com.tnl.backend.IStudy;

public class Teacher implements IStudy{
	
	private int id;
	private String teacherName, address, phone;
	
	public Teacher() {}

	public Teacher(int id, String teacherName, String address, String phone) {
		super();
		this.id = id;
		this.teacherName = teacherName;
		this.address = address;
		this.phone = phone;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTeacherName() {
		return teacherName;
	}



	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	@Override
	public void rollUp() {
		System.out.println("Giáo viên: " + this.teacherName + " điểm danh.");
		
	}

	@Override
	public void doHomeWork() {
		System.out.println("Giáo viên: " + this.teacherName + " không phải làm btvn.");
		
	}

	@Override
	public void copyHomeWork() {
		System.out.println("Giáo viên: " + this.teacherName + " không copy btvn.");
		
	}

}
