package com.tnl.backend;

import java.util.Arrays;
import java.util.Date;

public class Main {
	public static void main(String[] args) {

		Department d1 = new Department();
		d1.departmentId = 1;
		d1.departmentName = "Sales";
		Department d2 = new Department(2, "Marketing");
		Department d3 = new Department(3, "IT");

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

//		System.out.println("********** Information of user 1 **********");
//		System.out.print(	"Username: " + u1.username + "\n" + 
//							"Email: " + u1.email + "\n" +
//							"User Id: " + u1.userId + "\n" + 
//							"Department Id: " + u1.department.departmentId + "\n" + 
//							"Position Id: " + u1.position.positionId + "\n");
//		
//		
//		// Switch case
//		int phongban = u1.department.departmentId;
//		switch(phongban) {
//			case 1:
//				System.out.println("Phong ban 1");
//				break;
//			case 2:
//				System.out.println("Phong ban 2");
//				break;
//			default:
//				break;
//		}

		int[] num = { 1, 2, 3 };
		Department[] dep = new Department[2];
		Department dep1 = new Department(1, "IT");
		Department dep2 = new Department(2, "Sales");
		dep[0] = dep1;
		dep[1] = dep2;
		
//		// in tu 1- 99
		System.out.println("in tu 1- 99");
		for(int i = 1; i <= 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.println(i);
		}
		
		for(int i = 1; i <= 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.println(i);
		}
		
		for(int i = 1; i <= 10; ++i) {
			if (i == 5) {
				return;
			}
			System.out.println(i);
		}
		
//		//in tung phan tu mang int bang for each
		System.out.println("in tung phan tu mang int bang for each");
		for (int n : num) {
			System.out.println(n);
		}
	
//		// in phan tu department bang for each
		System.out.println("in tung phan tu mang department bang for each");
		for (Department d : dep) {
			System.out.println(d.departmentId);
			System.out.println(d.departmentName);
		}
//		
//		// in phan tu department bang for thuong
		System.out.println("in tung phan tu mang department bang for thuong");
		for (int j = 0; j < dep.length; j++) {
			System.out.println(dep[j].departmentId);
			System.out.println(dep[j].departmentName);
		}
		
		int i = 0;
		while (i < dep.length) {
			System.out.println(dep[i].departmentId);
			System.out.println(dep[i].departmentName);
			i += 1;
		}

		int j = 0;
		do {
			System.out.println(dep[j].departmentId);
			System.out.println(dep[j].departmentName);
			j++;
		} while (j < dep.length);
	}
}
