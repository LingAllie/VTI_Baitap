package com.vti.backend;

import java.util.*;


public class Assignment2_Ex3 {
	
	// Ex3.1
	
	// for loop

	public static void forLoopA(String[] arr) {
		
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if(i == count) {
				System.out.println();
			}
			else {
				count++;
			}
			
		}
	}
	
	public static void forLoopB(String[] arr) {
		
	}
	
	public static void forLoopC() {
		
	}
	
	public static void forLoopD() {
		
	}
	
	// while loop
	
	// do-while loop
	
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
		// Ex3.1
		// for loop
		String[] arr = {"#", "#", "#", "#", "#", "#",
						"#", "#", "#", "#", "#", "#",
						"#", "#", "#", "#", "#", "#",
						"#", "#", "#", "#", "#", "#",
						"#", "#", "#", "#", "#", "#",
						"#", "#", "#", "#", "#", "#"};
		forLoopA(arr);
//		forLoopB(arr);
//		forLoopC(arr);
//		forLoopD(arr);
//		
//		// while loop
//		whileLoopA();
//		whileLoopB();
//		whileLoopC();
//		whileLoopD();
//		
//		// do while loop
//		doWhileLoopA();
//		doWhileLoopB();
//		doWhileLoopC();
//		doWhileLoopD();
//		
//		
//		// Ex3.2
//		tinhGiaiThua();

	}

}
