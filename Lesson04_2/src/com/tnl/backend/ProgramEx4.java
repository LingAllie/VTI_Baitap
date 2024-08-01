package com.tnl.backend;

import com.tnl.entity.Accountt;
import com.tnl.entity.Circle;
import com.tnl.entity.CongNhan;
import com.tnl.entity.Date;
import com.tnl.entity.KySu;
import com.tnl.entity.NhanVien;
import com.tnl.entity.Student;
import com.tnl.entity.VietnamesePhone;

public class ProgramEx4 {
	
	public static void main(String[] args) {
		
		System.out.println("\nEx 4: Encapsulation");
		System.out.println("\nQuestion 1:");
		Student s1 = new Student(1, "Allie", "Tp.HCM");
		System.out.println("\nInitial state:");
		System.out.println(s1.toString());
		
		s1.setDiemHocLuc(5.5);
		System.out.println("\nSet diem hoc luc:");
		System.out.println(s1.toString());
		
		s1.addDiemHocLuc(2.0);
		System.out.println("\nCong diem hoc luc:");
		System.out.println(s1.toString());
		
		// ----------------
		
		System.out.println("\nQuestion 2b");
		
        Circle defaultCircle = new Circle();
        Circle circleWithRadius = new Circle(5.0);
        Circle circleWithRadiusAndColor = new Circle(10.0, "blue");
        
        // Print details of each circle
        System.out.println("\nDefault Circle:");
        System.out.println(defaultCircle);
        System.out.println("Perimeter: " + defaultCircle.getPerimeter());
        System.out.println("Area: " + defaultCircle.getArea());

        System.out.println("\nCircle with radius 5.0:");
        System.out.println(circleWithRadius);
        System.out.println("Perimeter: " + circleWithRadius.getPerimeter());
        System.out.println("Area: " + circleWithRadius.getArea());

        System.out.println("\nCircle with radius 10.0 and color blue:");
        System.out.println(circleWithRadiusAndColor);
        System.out.println("Perimeter: " + circleWithRadiusAndColor.getPerimeter());
        System.out.println("Area: " + circleWithRadiusAndColor.getArea());
		
		
		System.out.println("\nQuestion 2b");
		
		Accountt account1 = new Accountt("A001", "John Doe", 500);
	    Accountt account2 = new Accountt("A002", "Jane Smith", 300);

	    // Print initial state
	    System.out.println("\nInitial state:");
        System.out.println(account1);
        System.out.println(account2);

	    // Test credit method
	    account1.Credit(200);
	    System.out.println("\nAfter crediting 200 to account1:");
	    System.out.println(account1);

	    // Test debit method
	    account2.Debit(100);
	    System.out.println("\nAfter debiting 100 from account2:");
	    System.out.println(account2);

	    // Test transferTo method
	    account1.transferTo(account2, 150);
        System.out.println("\nAfter transferring 150 from account1 to account2:");
	    System.out.println(account1);
	    System.out.println(account2);
	     
	    // ------------------
	    
	    System.out.println("\nQuestion 2c");
	    Date date1 = new Date(15, 8, 2024);
	    System.out.println("Date1: " + date1);

	    date1.setDay(16);
        date1.setMonth(9);
        date1.setYear(2025);
        System.out.println("\nUpdated Date1: " + date1);
        
	    // Test leap year
	    System.out.println("\nIs 2025 a leap year? " + date1.isLeapYear());
	        
	    // Create another Date object for a leap year
	    Date date2 = new Date(30, 1, 2024);
	    System.out.println("\nDate2: " + date2);
	    System.out.println("Is 2024 a leap year? " + date2.isLeapYear());
	        
	    // Create another Date object for a non-leap year
	    Date date3 = new Date(05, 9, 2023);
	    System.out.println("\nDate3: " + date3);
        System.out.println("Is 2023 a leap year? " + date3.isLeapYear());
	  
	}
	
}
