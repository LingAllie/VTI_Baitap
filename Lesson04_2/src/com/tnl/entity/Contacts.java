package com.tnl.entity;

public class Contacts {

	private String phone;
	private String name;
	
	public Contacts() {}

	public Contacts(String name, String phone) {
		this.phone = phone;
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Contacts [number=" + phone + ", name=" + name + "]";
	}
	
}
