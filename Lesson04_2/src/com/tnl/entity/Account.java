package com.tnl.entity;

import java.time.LocalDate;

public class Account {

	private int id;
	private String email;
	private String username;
	private String firstName;
	private String lastName;
	private String fullName;
	private Position position;
	private LocalDate createDate;
	
	public Account() {}
	
	public Account(int id, String email, String username, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = firstName + lastName;
	}
	
	public Account(int id, String email, String username, String firstName, String lastName, Position position) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = firstName + lastName;
		this.position = position;
		this.createDate = LocalDate.now();
	}
	
	public Account(int id, String email, String username, String firstName, String lastName, Position position, LocalDate createDate) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = firstName + lastName;
		this.position = position;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", fullName=" + fullName + ", position=" + position + ", createDate="
				+ createDate + "]";
	}
	
	
}
