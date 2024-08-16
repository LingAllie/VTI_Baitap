package com.tnl.frontend;

import java.util.ArrayList;
import java.util.List;

import com.tnl.entity.Student;

public class ProgramAL {

	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		
		
		for(int i = 0; i < 7; i++) {
			Student s = new Student((i + 1), ("Student " + (i + 1)));
			students.add(s);
		}
		
		students.add(new Student(8, "Student X"));
		students.add(new Student(9, "Student X"));
		students.add(new Student(10, "Student X"));
		
		// a
		System.out.println("\nTong phan tu cua list students: " + students.size() + " phan tu");
		
		// b
		System.out.println("\nPhan tu thu 4 cua list students: " + students.get(3));
		
		// c
//		System.out.println("Phan tu dau: " + students.get(0));
//		System.out.println("Phan tu cuoi: " + students.get(students.size() - 1));
		System.out.println("\nPhan tu dau: " + students.getFirst());
		System.out.println("Phan tu cuoi: " + students.getLast());
		
		// d
		System.out.print("\nThem vao dau list");
		students.addFirst(new Student(11, "Student Y"));
		
		// e
		System.out.print("\nThem vao cuoi list");
		students.add(new Student(12, "Student Z"));
//		students.addLast(new Student(12, "Student Z"));
		
		// f
		System.out.print("\n\nTruoc khi dao nguoc list\n");
		for(Student s: students) {
			System.out.println(s);
		}
		students.reversed();
		System.out.print("\nSau khi dao nguoc list\n");
		for(Student s: students.reversed()) {
			System.out.println(s);
		}
		
		// g
		System.out.print("\nTim stu co id = 2\n");
		findStuById(2, students);
		
		// h
		System.out.print("\nTim stu co name = `Student Z` \n");
		findStuByName("Student Z", students);
		
		// i
		System.out.print("\nTim stu co name duplicate\n");
		findStuDupName(students);
		
		// j
		System.out.print("\nXoa ten student id = 2\n");
		for(Student s: students) {
			if (s.getId() == 2) {
				s.setName(null);
				System.out.print(s.toString());
				break;
			}
		}
		
		// k
		System.out.print("\n\nXoa student co id = 5\n");
		System.out.print("truoc khi xoa: size =" + students.size());
		for(Student s: students) {
			if (s.getId() == 5) {
				students.remove(s);
				break;
			}
		}
		System.out.print("\nSau khi xoa: size =" + students.size());
		for(Student s: students) {
			System.out.println(s.toString());
		}
		
		// l
		System.out.print("\n\nArrayList copies\n");
		ArrayList<Student> studentCopies = new ArrayList<>();
//		studentCopies = (ArrayList<Student>) students;
		
		for(Student s: students) {
			studentCopies.add(s);
		}
		for(Student sc: studentCopies) {
			System.out.println(sc.toString());
		}
	}

	public static void findStuDupName(List<Student> students) {
		int count = 0;
		for(int i = 0; i < students.size(); i++) {
			Student s1 = students.get(i);
			for(int j = i+1; j < students.size(); j++) {
				Student s2 = students.get(j);
				if (s1.getName().equalsIgnoreCase(s2.getName())) {
					System.out.println("\nPair " + count++);
					System.out.println(students.get(i).toString());
					System.out.println(students.get(j).toString());
				}
			}
		}
	}

	public static void findStuByName(String name, List<Student> students) {
		for(Student s : students) {
			if (s.getName().equalsIgnoreCase(name)) {
				System.out.println(s.toString());
			}
		}
	}

	public static void findStuById(int id, List<Student> students) {
		for(Student s : students) {
			if (s.getId() == id) {
				System.out.println(s.toString());
			}
		}
	}
	
	
}
