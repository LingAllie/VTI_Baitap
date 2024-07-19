package com.tnl.backend;

import java.util.*;

public class Account {
	int accountId;
	String email;
	String username;
	String fullName;
	Department department;
	Position position;
	Date createDate;
	
	public Account () {}
	
	public Account(int accountId, String email, String username, String fullName, Department department,
			Position position, Date createDate) {
		
		this.accountId = accountId;
		this.email = email;
		this.username = username;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
