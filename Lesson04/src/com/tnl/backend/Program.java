package com.tnl.backend;

import com.tnl.entity.Position;

public class Program {

	public static void main (String[] args) {
		
		Position pos1 = new Position(1, "Admin");
		
		Position pos2 = new Position();
		pos2.setId(2);
		pos2.setPositionName("HR");
		
		System.out.println(pos1.toString());
		System.out.println(pos2.toString());
	}
}
