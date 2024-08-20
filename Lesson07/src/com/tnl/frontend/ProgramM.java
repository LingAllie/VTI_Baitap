package com.tnl.frontend;

import java.util.*;

public class ProgramM {

	public static void main(String[] args) {
		Map students = new HashMap();
		char[] chars = {'C', 'M', 'A', 'B', 'F'};
		for(int i = 0; i < 5; i++) {
			students.put(i, ("Student " + chars[i]));
		}
		
		Set set = students.keySet();
		for(Object key: set) {
			System.out.println(key + " " + students.get(key));
		}
		
		Hashtable<Integer, String> stus = new Hashtable<>();
		for(int i = 0; i < 5; i++) {
			stus.put(i, ("Student " + chars[i]));
		}
		
		Set set2 = stus.keySet();
		for(Object key: set2) {
			System.out.println(key + " " + stus.get(key));
		}
	}
}
