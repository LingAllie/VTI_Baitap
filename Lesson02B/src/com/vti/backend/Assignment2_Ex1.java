package com.vti.backend;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Assignment2_Ex1 {
	
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
	/* ************************************************************************************** */
	
	// Ex1.1
	public static void doiDonVi() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào một số thực: ");
		float num = sc.nextFloat();
		
		System.out.printf("%.2f cm = %.2f foot", num, ((1/2.54)/12)); 
		System.out.printf("\n%.2f cm = %.2f inches", num, (1/2.54));
	}
	
	//Ex1.2
	public static void dinhDangGio() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào một giây từ 0 tới 68399: ");
		int n = sc.nextInt();
		
		int h, m, s;
		
		h = n / 3600;
		m = n % 3600 / 60;
		s = n % 3600 % 60;
		if (h < 10 && m < 10 && s < 10) {
			System.out.printf("%ds = %02d:%02d:%02d", n, h, m, s);
		} 
		else if (h > 10 && m < 10 && s < 10) {
			System.out.printf("%ds = %d:%02d:%02d", n, h, m, s);
		} 
		else if (h < 10 && m > 10 && s < 10) {
			System.out.printf("%ds = %02d:%d:%02d", n, h, m, s);
		} 
		else if (h < 10 && m < 10 && s > 10) {
			System.out.printf("%ds = %02d:%02d:%d", n, h, m, s);
		} 
		else if (h > 10 && m < 10 && s > 10) {
			System.out.printf("%ds = %d:%02d:%d", n, h, m, s);
		} 
		else if (h > 10 && m > 10 && s < 10) {
			System.out.printf("%ds = %d:%d:%02d", n, h, m, s);
		} 
		else if (h < 10 && m > 10 && s > 10) {
			System.out.printf("%ds = %02d:%d:%d", n, h, m, s);
		} 
		else {
			System.out.printf("%ds = %d:%d:%d", n, h, m, s);
		}
		
	}
	
	// Ex1.3
	public static void timMinMax () {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào 4 số nguyên: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		int[] arr = {a, b, c, d};
		int min = a;
		int max = a;
		for(int n : arr) {
			if (max < n) {
				max = n;
			}
			if (n < min) {
				min = n;
			}
		}
		System.out.println("Số lớn nhất là: " + max);
		System.out.println("Số nhỏ nhất là: " + min);
	}
	
	// Ex1.4
	public static void tinhHieu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào 2 số tự nhiên: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if ((a - b) > 0) {
			System.out.println("Số thứ nhất lớn hơn số thứ hai");
		} else {
			System.out.println("Số thứ nhất nhỏ hơn số thứ hai");
		}
	}
	
	// Ex1.5
	public static void testPhepChia() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào 2 số tự nhiên: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if (b != 0) {
			if (a % b == 0) {
				System.out.printf("%d chia hết cho %d\n", a, b);
			} else {
				System.out.printf("%d không chia hết cho %d\n", a, b);
			}
		} else {
			System.out.printf("Mẫu số (b) không được phép bằng 0\n");
		}
	}
	
	// Ex1.6
	public static void xepLoaiSinhVien() {
		Scanner sc = new Scanner(System.in);
		
		// a)
		System.out.println("Nhập điểm môn toán: ");
		float t = sc.nextFloat();
		System.out.println("Nhập điểm môn lý: ");
		float l = sc.nextFloat();
		System.out.println("Nhập điểm môn hoá: ");
		float h = sc.nextFloat();
		 
		// b)
		float avg = (t*2 + l + h)/4;
		System.out.printf("Điểm trung bình của sinh viên là: %.2f", avg);
		
		// c)
		String hocLuc = " ";
		if (avg >= 9.0) {
			hocLuc = "Loại xuất sắc";
		} else if (8.0 <= avg && avg < 9.0) {
			hocLuc = "Loại giỏi";
		} else if (7.0 <= avg && avg < 8.0) {
			hocLuc = "Loại khá";
		} else if (6.0 <= avg && avg < 7.0) {
			hocLuc = "Loại trung bình khá";
		} else if (5.0 <= avg && avg < 6.0) {
			hocLuc = "Loại trung bình";
		} else {
			hocLuc = "Loại kém";
		}
		
		// d)
		System.out.println("\nHọc lực của sinh viên thuộc " + hocLuc);
		
	}
	
	public static void main(String[] args) throws ParseException {
		
//		nhapThongTin();
//		nhapNgayThang();
//		tinhTong(3,5);
//		System.out.println("Tong cua 2 so la " + tinhTong2So(3,5));
		
//		printName("Allie");
//		System.out.println("Tich cua 2 so x va y la " + getTich2so(2,4));
		
		// Ex1.1
		doiDonVi();
		
		// Ex1.2
		dinhDangGio();

		// Ex1.3
		timMinMax());

		// Ex1.4
		tinhHieu();
		
		// Ex1.5
		testPhepChia();
		
		// Ex1.6
		xepLoaiSinhVien();
	
	}
	

}
