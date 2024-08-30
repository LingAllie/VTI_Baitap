package com.vti.backend;

import java.util.*;


public class Assignment2_Ex3 {
	
	
	// Ex3.2
	public static void tinhGiaiThua() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số tự nhiên n là số không âm: ");
		int n = sc.nextInt();
		int tich = 1;
		for(int i = 1; i <= n; i++) {
			tich *= i;
		}
		System.out.printf("%d! = %d", n, tich);
	}
	
	
	public static void main(String[] args) {
		

//		// Ex3.2
//		tinhGiaiThua();
		String a = "I'm a boss";

	    String b = "I'm a boss.";

	    if (a == b) {
	        System.out.println("a = b");
	    } else {
	        System.out.println("a khac b");
	    }

	}

}
