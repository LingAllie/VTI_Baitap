package com.tnl.frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) throws Exception {
		
		try {
			int age = inputAge();
			System.out.println("Your age is " + age);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static int inputAge() throws Exception {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Please input your age: ");
			int age = sc.nextInt();
			
			sc.close();
			
			return age;
		} catch (Exception e) {
			throw new Exception("Please input a number as int");
		}
	}


}
