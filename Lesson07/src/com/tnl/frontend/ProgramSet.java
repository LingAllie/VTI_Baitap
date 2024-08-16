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
        for (int i = 0; i < 3; i++) {
            Student s = new Student((i + 1), ("Student " + (i + 1)));
            students.add(s);
        }

        // a
        System.out.println("\nTong phan tu cua set students: " + students.size() + " phan tu");

        // b
        Iterator<Student> iterator = students.iterator();
        int index = 0;
        Student fourthStudent = null;
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (index == 3) { // 4th element (0-based index)
                fourthStudent = s;
                break;
            }
            index++;
        }
        System.out.println("\nPhan tu thu 4 cua set students: " + (fourthStudent != null ? fourthStudent : "No such element"));

        // c
        Iterator<Student> iteratorForFirst = students.iterator();
        Student firstStudent = iteratorForFirst.hasNext() ? iteratorForFirst.next() : null;

        Student lastStudent = null;
        while (iteratorForFirst.hasNext()) {
            lastStudent = iteratorForFirst.next();
        }

        System.out.println("\nPhan tu dau: " + (firstStudent != null ? firstStudent : "No elements"));
        System.out.println("Phan tu cuoi: " + (lastStudent != null ? lastStudent : "No elements"));

        // d
        students = new LinkedHashSet<>(students); // Maintain insertion order
        students.add(new Student(11, "Student Y"));

        // e
        students.add(new Student(12, "Student Z"));

        // f
        List<Student> studentList = new ArrayList<>(students);
        Collections.reverse(studentList);
        System.out.println("\nSau khi dao nguoc set\n");
        for (Student s : studentList) {
            System.out.println(s);
        }

        // g
        System.out.print("\nTim stu co id = 2\n");
        findStuById(2, students);

        // h
        System.out.print("\nTim stu co name = `Student Z`\n");
        findStuByName("Student Z", students);

        // i
        System.out.print("\nTim stu co name duplicate\n");
        findStuDupName(students);

        // j
        System.out.print("\nXoa ten student id = 2\n");
        for (Student s : students) {
            if (s.getId() == 2) {
                s.setName(null);
                System.out.println(s.toString());
                break;
            }
        }

        // k
        System.out.print("\n\nXoa student co id = 5\n");
        System.out.print("truoc khi xoa: size =" + students.size());
        removeStuById(5, students);
        System.out.print("\nSau khi xoa: size =" + students.size() + "\n");
        for (Student s : students) {
            System.out.println(s.toString());
        }

        // l
        System.out.print("\n\nArrayList copies\n");
        ArrayList<Student> studentCopies = new ArrayList<>(students);
        for (Student sc : studentCopies) {
            System.out.println(sc.toString());
        }

	}
	
	public static void removeStuById(int id, Set<Student> students) {
	    Iterator<Student> iterator = students.iterator();
	    while (iterator.hasNext()) {
	        Student s = iterator.next();
	        if (s.getId() == id) {
	            iterator.remove();
	            break;
	        }
	    }
	}


	public static void findStuDupName(Set<Student> students) {
	    Set<String> names = new HashSet<>();
	    Set<String> duplicateNames = new HashSet<>();
	    for (Student s : students) {
	        if (!names.add(s.getName().toLowerCase())) {
	            duplicateNames.add(s.getName().toLowerCase());
	        }
	    }
	    for (String name : duplicateNames) {
	        System.out.println("\nDuplicate name: " + name);
	        for (Student s : students) {
	            if (s.getName().equalsIgnoreCase(name)) {
	                System.out.println(s);
	            }
	        }
	    }
	}


	public static void findStuByName(String name, Set<Student> students) {
	    for (Student s : students) {
	        if (s.getName().equalsIgnoreCase(name)) {
	            System.out.println(s);
	        }
	    }
	}


	public static void findStuById(int id, Set<Student> students) {
	    for (Student s : students) {
	        if (s.getId() == id) {
	            System.out.println(s);
	            return; // Exit after finding the first match
	        }
	    }
	}

}
