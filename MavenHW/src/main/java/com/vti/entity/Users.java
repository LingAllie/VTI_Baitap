package com.vti.entity;

public class Users {

	private int userId;
	private String username;
	private Department department;
	private Position position;
	
	public Users() {
	}

	public Users(int userId, String username, Department department, Position position) {
		this.userId = userId;
		this.username = username;
		this.department = department;
		this.position = position;
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

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", department=" + department + ", position="
				+ position + "]";
	}
	
	
}
