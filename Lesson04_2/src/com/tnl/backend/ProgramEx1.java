package com.tnl.backend;

import java.time.LocalDate;
import java.util.ArrayList;

import com.tnl.entity.Account;
import com.tnl.entity.Department;
import com.tnl.entity.Group;
import com.tnl.entity.Position;

public class ProgramEx1 {

	public static void main(String[] args) {
		
		System.out.println("Ex 1 : Constructor");
		System.out.println("\nQuestion 1:");
		
		Department d1 = new Department();
		
		Department d2 = new Department("Sales");
		
		System.out.println("d1: " + d1.toString());
		System.out.println("d2 (default id): " + d2.toString());
		
		d2.setIdDepartment(1);
		
		System.out.println("d2 (after set id): " + d2.toString());
		
		// ----------------------------------------------------------
		
		System.out.println("\nQuestion 2:");
		 // Test the no-argument constructor
        Account account1 = new Account();
        System.out.println("Account1 created with no-argument constructor:");
        System.out.println(account1.toString());

        // Test the constructor with id, email, username, firstName, lastName
        Account account2 = new Account(1, "test@example.com", "testuser", "John", "Doe");
        System.out.println("\nAccount2 created with constructor 2:");
        System.out.println(account2.toString());

        // Test the constructor with id, email, username, firstName, lastName, position
        Position position = new Position(1, "Developer");
        Account account3 = new Account(2, "test2@example.com", "testuser2", "Jane", "Smith", position);
        System.out.println("\nAccount3 created with constructor 3:");
        System.out.println(account3.toString());

        // Test the constructor with id, email, username, firstName, lastName, position, createDate
        LocalDate createDate = LocalDate.of(2023, 1, 1);
        Account account4 = new Account(3, "test3@example.com", "testuser3", "Alice", "Brown", position, createDate);
        System.out.println("\nAccount4 created with constructor 4:");
        System.out.println(account4.toString());
        
        //--------------------------------------------------------------
        
        System.out.println("\nQuestion 3:");
        Group group1 = new Group();
        System.out.println("Group1 created with no-argument constructor:");
        System.out.println(group1);

        // Test constructor with GroupName, Creator, List<Account> accounts, and CreateDate
        Account creator = new Account(1, "creator@example.com", "creatorUser", "John", "Doe");
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account(2, "user1@example.com", "user1", "Alice", "Smith"));
        accounts.add(new Account(3, "user2@example.com", "user2", "Bob", "Brown"));
        
        Group group2 = new Group("GroupName1", creator, accounts, LocalDate.now());
        System.out.println("\nGroup2 created with constructor 2:");
        System.out.println(group2);

        // Test constructor with GroupName, Creator, String[] usernames, and CreateDate
        String[] usernames = {"user3", "user4", "user5"};
        Group group3 = new Group("GroupName2", creator, usernames, LocalDate.now());
        System.out.println("\nGroup3 created with constructor 3:");
        System.out.println(group3);
        
        
        
        
        
        
        
        
        
        
        
        
	}
}
