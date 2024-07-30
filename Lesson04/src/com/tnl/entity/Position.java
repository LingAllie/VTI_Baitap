package com.tnl.entity;

public class Position {
	
	private int id;
	private String positionName;
	
	public Position() {}
	
	public Position(int id, String positionName) {
		this.id = id;
		this.positionName = positionName;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + " " + this.positionName;
	}
}
