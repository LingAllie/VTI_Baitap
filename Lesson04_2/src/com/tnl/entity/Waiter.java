package com.tnl.entity;

public class Waiter extends User{

	public Waiter() {
		super();
	}
	
	@Override
	public double calculatePay() {
		return super.getSalaryRatio() * 220;
	}

}
