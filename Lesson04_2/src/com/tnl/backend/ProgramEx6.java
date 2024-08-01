package com.tnl.backend;

import com.tnl.entity.Employee;
import com.tnl.entity.Manager;
import com.tnl.entity.VietnamesePhone;
import com.tnl.entity.Waiter;

public class ProgramEx6 {

	public static void main(String[] args) {
		
		System.out.println("Ex 6: Abstraction");
		System.out.println("\nQuestion 1:");
		
		VietnamesePhone phone = new VietnamesePhone();

        // Inserting contacts
        phone.insertContact("Nguyen Van A", "0123456789");
        phone.insertContact("Le Thi B", "0987654321");

        // Searching contacts
        phone.searchContact("Nguyen Van A");

        // Updating contact
        phone.updateContact("Nguyen Van A", "111222333");

        // Searching updated contact
        phone.searchContact("Nguyen Van A");

        // Removing contact
        phone.removeContact("Nguyen Van A");

        // Trying to search removed contact
        phone.searchContact("Nguyen Van A");
        
        // ------------------------------------------
        
        System.out.println("\nQuestion 2:");
        
        Employee employee = new Employee();
        Manager manager = new Manager();
        Waiter waiter = new Waiter();

        // Set names and salary ratios
        employee.setName("John Doe");
        employee.setSalaryRatio(2.5);

        manager.setName("Jane Smith");
        manager.setSalaryRatio(3.0);

        waiter.setName("Alice Johnson");
        waiter.setSalaryRatio(1.8);

        // Display information and calculated pay for each user
        System.out.println("\nEmployee Information:");
        System.out.println(employee.displayInfor());
        System.out.println("Calculated Pay: " + employee.calculatePay());

        System.out.println("\nManager Information:");
        System.out.println(manager.displayInfor());
        System.out.println("Calculated Pay: " + manager.calculatePay());

        System.out.println("\nWaiter Information:");
        System.out.println(waiter.displayInfor());
        System.out.println("Calculated Pay: " + waiter.calculatePay());
	}
}
