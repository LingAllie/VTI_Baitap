package com.tnl.entity;

import com.tnl.backend.InvalidAgeInputingException;
import com.tnl.utils.ScannerUtils;

public class Account {

	private int id, age;
	private String name;
	
	
	public Account() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	public void inputAge() throws InvalidAgeInputingException{
		if (this.getAge() <= 0) {
			throw new InvalidAgeInputingException("The age must be greater than 0 !");
		} else {
			System.out.println("Have a good day !");
		}
	}
	
	public int inputAccountAge() throws InvalidAgeInputingException{
		while(true) {
			try {
				int age = ScannerUtils.inputInt("Enter your age: ");
				if (age < 18) {
					throw new InvalidAgeInputingException("Your age must be greater than 18");
				}
				return age;
			} catch (InvalidAgeInputingException e) {
				System.out.println("Error occured: " + e.getMessage());
			}
		}
		
	}
	
	public Account(int id, String name) throws InvalidAgeInputingException {
		this.id = id;
		this.name = name;
		this.age = inputAccountAge();
	}
}
