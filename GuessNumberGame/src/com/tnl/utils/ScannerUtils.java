package com.tnl.utils;

import java.util.Scanner;

public class ScannerUtils {

	private static Scanner sc = new Scanner(System.in);
	
	public static int getNumber(String msg) throws Exception{
		while(true) {
			System.out.print(msg);
			try {
				return Integer.parseInt(sc.nextLine().trim());
			} catch (Exception e) {
				throw new Exception("Vui lòng không để trống !");
			}
		}
	}
}
