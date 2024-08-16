package com.tnl.frontend;

import com.tnl.backend.InvalidAgeInputingException;
import com.tnl.entity.Account;

public class Question11 {

	public static void main(String[] args) throws InvalidAgeInputingException {
		Account acc = new Account(1, "yin");
		System.out.println(acc.toString());
//		try {
//			acc.inputAge();
//		} catch (InvalidAgeInputingException e) {
//			System.out.println("Error occured: " + e.getMessage());
//		}
	}
}

