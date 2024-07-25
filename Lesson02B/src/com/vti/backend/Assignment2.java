package com.vti.backend;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Assignment2 {
	
	public static void nhapThongTin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input your name: ");
		String name = sc.nextLine();
		System.out.println(name);
		System.out.println("Please input your age: ");
		int age = sc.nextInt();
		System.out.println(age);
		System.out.println("Please input your score: ");
		if (sc.hasNextInt()) {
			int diem = sc.nextInt();
			System.out.println(diem);
		} else {
			System.out.println("Please input your score as number: ");
		}
		sc.close();
	}
	
	public static void nhapNgayThang() throws ParseException {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter date as dd-MM-yyyy: ");
		String date = sc.nextLine();
		
		Date dateFormat = simpleDateFormat.parse(date);
		System.out.println(dateFormat);
		
		
		sc.close();
	}
	
	public static void tinhTong(int x, int y) {
		int tong = 0;
		tong = x + y;
		System.out.println(tong);
	}
	
	public static int tinhTong2So(int x, int y) {
		return x + y;
	}
	
	public static void printName(String name) {
		System.out.println("Ten cua nguoi dung la " + name);
	}
	
	public static int getTich2so(int x, int y) {
		return x * y;
	}
	
	// Ex1.1
	
	
	public static void main(String[] args) throws ParseException {
		
//		nhapThongTin();
		nhapNgayThang();
//		tinhTong(3,5);
//		System.out.println("Tong cua 2 so la " + tinhTong2So(3,5));
		
//		printName("Allie");
//		System.out.println("Tich cua 2 so x va y la " + getTich2so(2,4));
		
		
	}
	

}
