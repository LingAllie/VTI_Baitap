package com.tnl.frontend;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.tnl.entity.Student;

public class ProgramSQ {

	
	public static void main(String[] args) {
		
		List<Student> interviewers = new ArrayList<>();
		
		interviewers.add(new Student(1, "Nguyễn Văn Nam"));
		interviewers.add(new Student(2, "Nguyễn Văn Huyên"));
		interviewers.add(new Student(3, "Trần Văn Nam"));
		interviewers.add(new Student(4, "Nguyễn Văn A"));
		
		System.out.println("Soon to late order: ");
		soonToLateOrder(interviewers);
		System.out.println("\nLate to soon order: ");
		lateToSoonOrder(interviewers);
		
		
	}
	public static void soonToLateOrder(List<Student> interviewers) {
		Queue interviewOrderByQueue = new LinkedList<>();
		
		for(Student s: interviewers) {
			interviewOrderByQueue.add(s);
		}
		
		while (!interviewOrderByQueue.isEmpty()) {
            System.out.println(interviewOrderByQueue.poll());
        }
	}
	public static void lateToSoonOrder(List<Student> interviewers) {
		Stack interviewOrderByStack = new Stack<>();
		
		for(Student s: interviewers) {
			interviewOrderByStack.push(s);
		}
		
		while (!interviewOrderByStack.isEmpty()) {
            System.out.println(interviewOrderByStack.pop());
        }
	}
}
