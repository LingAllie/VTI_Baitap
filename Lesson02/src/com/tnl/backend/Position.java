package com.tnl.backend;

public enum Position {
	Dev(1, "Dev"),
    Test(2, "Test"),
    ScrumMaster(3, "Scrum Master"),
    PM(4, "PM");
	
	int positionId;
	String positionName;
	
	private Position () {}

	private Position(int positionId, String positionName) {
		
		this.positionId = positionId;
		this.positionName = positionName;
	}
	
}
