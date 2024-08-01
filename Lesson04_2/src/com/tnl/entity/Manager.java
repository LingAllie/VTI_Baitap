package com.tnl.entity;

public class Manager extends User{

	public Manager() {
		super();
	}
	
	
	@Override
	public double calculatePay() {
		return super.getSalaryRatio() * 520;
	}

}
