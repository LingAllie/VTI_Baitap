package com.tnl.entity;

public class Accountt {

	private String id;
	private String name;
	private int balance;
	
	public Accountt(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	public String getID() {
		return this.id;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void Credit(int amount) {
		if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Amount to credit should be positive.");
        }
	}
	
	public void Debit(int amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Amount to debit should be positive.");
        }
    }
	
	 public void transferTo(Accountt account, int amount) {
	    if (amount > 0) {
	        if (balance >= amount) {
	            this.Debit(amount);
	            account.Credit(amount);;
	        } else {
	            System.out.println("Insufficient balance.");
	        }
	    } else {
	        System.out.println("Amount to transfer should be positive.");
	    }
	 }
	 
	 @Override
	 public String toString() {
	     return "Account{id='" + id + "', name='" + name + "', balance=" + balance + '}';
	 }
	 
	 
}
