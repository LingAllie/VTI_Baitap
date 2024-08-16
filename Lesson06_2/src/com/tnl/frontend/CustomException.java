package com.tnl.frontend;

import com.tnl.backend.InvalidAgeException;

public class CustomException {

	public static void main(String[] args) {
		try {
			checkAge(15);
		} catch (InvalidAgeException e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
	}

	private static void checkAge(int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException ("Access denied - You must be at least 18 years old.");
		} else {
			System.out.println("Access granted - You are old enough !");
		}
		
	}
}
