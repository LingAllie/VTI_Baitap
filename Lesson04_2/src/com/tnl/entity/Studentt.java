package com.tnl.entity;

public abstract class Studentt extends Person{
	
	private int id;

	public Studentt(String name, int id) {
		super(name);
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
	
}
