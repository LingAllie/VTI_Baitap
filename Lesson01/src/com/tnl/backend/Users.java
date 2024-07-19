package com.tnl.backend;

import java.util.Date;

public class Users {
	int userId;
	Department department;
	Position position;
	String username, email;
	Gender gender;
	Date dateOfBirth;
	
	public Users () {}
	public Users (int userId, Department department, Position position, String username, String email, Gender gender, Date dateOfBirth) {
		this.userId = userId;
		this.department = department;
		this.position = position;
		this.username = username;
		this.email = email;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}
}
