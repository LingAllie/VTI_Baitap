package com.tnl.backend;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		
		Department d1 = new Department();
		d1.departmentId = 1;
		d1.departmentName = "Sales";
		Department d2 = new Department (2, "Marketing");
		Department d3 = new Department (3, "IT");
		
		Position p1 = new Position();
		p1.positionId = 1;
		p1.positionName = "Admin";
		Position p2 = new Position(2, "Manager");
		Position p3 = new Position(3, "Member");
		
		Users u1 = new Users();
		u1.userId = 1;
		u1.username = "Allie";
		u1.email = "allie@gmail.com";
		u1.department = d1;
		u1.position = p2;
		u1.gender = Gender.FEMALE;
		u1.dateOfBirth = new Date("2003/02/06");
		
		Users u2 = new Users(2, d2, p1, "Ying", "ying@gmail.com", Gender.UNKNOWN, new Date("1996/06/05"));
		Users u3 = new Users(3, d3, p3, "Bob", "bob@gmail.com", Gender.MALE, new Date("1876/12/10"));
		
		System.out.println("********** Information of user 1 **********");
		System.out.print(	"Username: " + u1.username + "\n" + 
							"Email: " + u1.email + "\n" +
							"User Id: " + u1.userId + "\n" + 
							"Department Id: " + u1.department.departmentId + "\n" + 
							"Position Id: " + u1.position.positionId);
		
		
	}
}
