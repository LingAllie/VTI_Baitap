package com.tnl.entity;

public class Employee extends User{

	public Employee() {
		super();
	}
	
	@Override
	public double calculatePay() {
		return super.getSalaryRatio() * 420;
	}

}
