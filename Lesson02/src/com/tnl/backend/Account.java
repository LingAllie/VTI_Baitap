package com.tnl.backend;

import java.util.*;

public class Account {
	int accountId;
	String email;
	String username;
	String fullName;
	Department department;
	Main.Position position;
	Date createDate;
	
	public Account () {}
	
	public Account(int accountId, String email, String username, String fullName, Department department,
			Main.Position position, Date createDate) {
		
		this.accountId = accountId;
		this.email = email;
		this.username = username;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}

	
}
