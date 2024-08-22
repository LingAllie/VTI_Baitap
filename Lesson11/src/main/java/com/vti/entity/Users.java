package com.vti.entity;

public class Users {

	private int userId;
	private String username;
	private String password;
	private Department department;
	
	public Users() {
	}

	public Users(int userId, String username, String password, Department department) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.department = department;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", password=" + password + ", department="
				+ department + "]";
	}

	
	
	
}
