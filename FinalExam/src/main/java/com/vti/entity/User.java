/**
 * @author: Linh
 * @date: Aug 30, 2024
 * 
 */
package com.vti.entity;

public class User {

	private int id;
	private String fullName;
	private String email;
	private String password;
	
	public User() {}
	
	public User(int id, String fullName, String email, String password) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id: " + this.id + ", fullName: " + this.fullName + ", email: " + this.email + ", password: " + this.password + "]";
	}
	
	
	
	
}
