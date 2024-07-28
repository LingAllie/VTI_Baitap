package com.tnl.backend;

public class Comparison {
	public static void main(String[] args) {
		Department dept1 = new Department(1, "HR");
        Department dept2 = new Department(2, "HR");
        Department dept3 = new Department(3, "IT");

        
        System.out.println(dept1);
        System.out.println(dept2);
        System.out.println(dept3);

        System.out.println("dept1.equals(dept2): " + dept1.equals(dept2));
        System.out.println("dept1.equals(dept3): " + dept1.equals(dept3));

//        System.out.println("dept1.equals(null): " + dept1.equals(null)); 

	}
}
