package com.tnl.backend;

import java.util.*;
import com.tnl.entity.Student;


public class Program {

	public static void main(String[] args) {
		List<Student> stuList = new ArrayList<>();
		Random rand = new Random();
		char[] chars = {'C', 'D', 'A', 'B', 'F', 'G', 'H', 'I', 'J', 'E'};
		int[] id = {5,2,6,4,8,1,9,3,0,7};
		for(int i = 0; i < 10; i++) {
			stuList.add(new Student(id[i], (rand.nextInt(10) + 10), rand.nextInt(10), ("Nguyen Van " + chars[i])));
		}
		
		for(Student s: stuList) {
			System.out.println(s.toString());
		}
		
		Collections.sort(stuList);
		
		System.out.println("\nAfter sorting: ");
		
		for(Student s: stuList) {
			System.out.println(s.toString());
		}
		
	}
}
