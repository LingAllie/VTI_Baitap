package com.tnl.entity;

import com.tnl.backend.IStudy;

public class Student implements IStudy{

	private int id;
	private String studentName, address, phone;
	
	public Student() {}
	
	
	public Student(int id, String studentName, String address, String phone) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.address = address;
		this.phone = phone;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setName(String studentName) {
		this.studentName = studentName;
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
		System.out.println("Sinh viên: " + this.studentName + " điểm danh.");
		
	}

	@Override
	public void doHomeWork() {
		System.out.println("Sinh viên: " + this.studentName + " làm btvn.");
		
	}

	@Override
	public void copyHomeWork() {
		System.out.println("Sinh viên: " + this.studentName + " copy btvn.");
		
	}

}
