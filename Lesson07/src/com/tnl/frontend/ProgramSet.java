package com.tnl.frontend;

import java.util.*;
import com.tnl.entity.Student;

public class ProgramSet {

	public static void main(String[] args) {
		Set<Student> students = new LinkedHashSet<>();
        for (int i = 0; i < 7; i++) {
            Student s = new Student((i + 1), ("Student " + (i + 1)));
            students.add(s);
        }
        
        students.add(new Student(8, "Student X"));
		students.add(new Student(9, "Student X"));
		students.add(new Student(10, "Student X"));

        // a
        System.out.println("\na) Tong phan tu cua set students: " + students.size() + " phan tu");

        // b
        System.out.print("\nb) Phan tu thu 4 trong set: ");
        int count = 1;
        for(Student s: students) {
        	if (count == 4) {
        		System.out.println(s.toString());
        		break;
        	}
        	++count;
        }
        // c
        System.out.print("\nc) ");
        int idx = 1;
        for(Student s: students) {
        	if (idx == 1) {
        		System.out.println("\nPhan tu dau trong set: " + s.toString());
        	}
        	if (idx == students.size()) {
        		System.out.println("\nPhan tu cuoi trong set: " + s.toString());
        	}
        	++idx;
        }
        
        // d + e
        System.out.println("\nd) + e) Them phan tu vao dau va cuoi set: ");
        Set<Student> newStudents = new LinkedHashSet<>();
        newStudents.add(new Student(11, "Student Y"));
        newStudents.addAll(students);
        newStudents.add(new Student(12, "Student Z"));
        for(Student s: newStudents) {
        	System.out.println(s.toString());
        }
       
        // f
        Stack<Student> stuStack = new Stack<>();
        for(Student s: newStudents) {
        	stuStack.push(s);
        }
        System.out.print("\nf) Sau khi dao nguoc set\n");
        while (!stuStack.isEmpty()) {
        	System.out.println(stuStack.pop().toString());
        }
        // g
        System.out.print("\ng)Tim stu co id = 2\n");
        findStuById(2, newStudents);

        // h
        System.out.print("\nh)Tim stu co name = `Student Z`\n");
        findStuByName("Student Z", newStudents);

        // i
        // Set auto eliminate duplicate values when add in set

        // j
        System.out.print("\nj)Xoa ten student id = 2\n");
        removeNameById(2, newStudents);

        // k
        System.out.print("\nk)Xoa student co id = 5\n");
        removeStuById(5, newStudents);
        System.out.print("\nSau khi xoa:\n");
        for (Student s : newStudents) {
            System.out.println(s.toString());
        }

        // l
        System.out.print("\nl)ArrayList copies\n");
        ArrayList<Student> newStuArray = new ArrayList(newStudents);
        for(Student s: newStuArray) {
        	System.out.println(s.toString());
        }
        

	}
	
	public static void removeNameById(int id, Set<Student> newStudents) {
		for(Student s: newStudents) {
			if (s.getId() == id) {
				s.setName(null);
				break;
			}
		}
	}

	public static void removeStuById(int id, Set<Student> newStudents) {
	   for(Student s: newStudents) {
		   if(s.getId() == id) {
			   newStudents.remove(s);
			   break;
		   }
	   }
	}


	public static void findStuByName(String name, Set<Student> newStudents) {
		for(Student s: newStudents) {
			   if(s.getName() == name) {
				   System.out.println(s.toString());
				   break;
			   }
		   }
	}


	public static void findStuById(int id, Set<Student> newStudents) {
	   for(Student s: newStudents) {
		   if(s.getId() == id) {
			   System.out.println(s.toString());
			   break;
		   }
	   }
	}

}
