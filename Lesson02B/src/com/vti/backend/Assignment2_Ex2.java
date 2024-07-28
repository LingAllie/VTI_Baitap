package com.vti.backend;

import java.util.*;

public class Assignment2_Ex2 {

	// Ex2.4
	public static void tinhTong(int n) {
		int temp = n;
		int tong = 0;
		while (n > 0) {
			tong += n % 10;
			n = n / 10;
		}
		System.out.printf("Tổng các chữ số của số nguyên %d là %d\n", temp, tong);
	}

	// Ex2.5
	public static void thuaSoPrimes(int n) {
		int temp = n;
		for (int i = 2; i < n; i++) {

			int count = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					count++;
				}
			}
			if (count <= 2 && n % i == 0) {
				while (temp % i == 0) {
					System.out.print(i);
					temp /= i;
					if (temp != 1) {
						System.out.print(" x ");
					}
				}
			}
		}
	}

	// Ex2.6
	public static void lietKePrimesByN(int n) {
		for (int i = 2; i < n; i++) {
			int count = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					count++;
				}
			}
			if (count <= 2 && i < n) {
				System.out.print(i + " ");
			}
		}
	}

	// Ex2.7
	public static void lietKeFirstPrimes(int n) {
		int freq = 0;
		for (int i = 2; i < n * 5; i++) {
			int count = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					count++;
				}
			}
			if (count <= 2 && freq != n) {
				System.out.print(i + " ");
				freq++;
			} else if (freq == n) {
				break;
			}
		}
	}

	// Ex2.8
	public static void timUclnBcnn(int a, int b) {
		int ucln = 0;

		for (int i = 1; i <= a * b; i++) {
			if (a % i == 0 && b % i == 0) {
				if (ucln < i) {
					ucln = i;
				}
			}
		}
		System.out.printf("UCLN của %d và %d là %d\n", a, b, ucln);
		System.out.printf("BCNN của %d và %d là %d\n", a, b, (a * b) / ucln);
	}

	// Ex2.15
	public static void tongVaPhantich() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập một số nguyên dương n: ");
		int n = sc.nextInt();
		// a)
		tinhTong(n);

		// b)
		thuaSoPrimes(n);
	}

	public static boolean checkPrime(int n) {

		if (n == 2) {
			return true;
		}

		if (n < 2) {
			return false;
		}

		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				count++;
			}
		}

		if (count <= 2) {
			return true;
		} else {
			return false;
		}

	}

	// Ex2.16
	public static void ex2_16() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập một số nguyên dương n: ");
		int n = sc.nextInt();

		// a
		int count = 0;

		System.out.print("a) Các ước số của " + n + ": { ");
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				count++;
				System.out.print(i + " ");
			}
			if (i == n) {
				System.out.print("}");
				System.out.printf("\nCó %d ước số", count);
			}
		}

		// b
		System.out.printf("\nb) Các ước số là nguyên tố của %d: { ", n);
		for (int i = 1; i <= n; i++) {
			if (n % i == 0 && checkPrime(i) == true) {
				System.out.print(i + " ");
			}
			if (i == n) {
				System.out.print("}");
			}
		}

	}

	public static void main(String[] args) {

		// Ex2.4
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số nguyên bất kỳ");
		int n = sc.nextInt();
		tinhTong(n);

		// Ex2.5
		thuaSoPrimes(100000);

		// Ex2.6
		lietKePrimesByN(17);

		// Ex2.7
		lietKeFirstPrimes(15);

		// Ex2.8
		timUclnBcnn(20, 54);

		// Ex2.15
		tongVaPhantich();

		// Ex2.16
		ex2_16();

	}

}
