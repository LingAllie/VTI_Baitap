package com.tnl.frontend;

public class Program2 {

	public static void main(String[] args) throws Exception {
		float result = devide(7, 0);
		
		System.out.println(result);
	}

	private static float devide(int a, int b) throws Exception {
		
//		return a / b;
		try {
			return a / b;
		} catch (Exception e) {
			throw new Exception("Cannot devide 0");
		}
	}
}
