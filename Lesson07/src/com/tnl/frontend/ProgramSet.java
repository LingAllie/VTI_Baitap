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
        System.out.print("\ng)Tim stu co id = 2: ");
        findStuById(2, newStudents);

        // h
        System.out.print("\nh)Tim stu co name = `Student Z`: ");
        findStuByName("Student Z", newStudents);

        // i
        System.out.println("\ni) Tim stu trung ten: ");
        findStuDupName(newStudents);

        // j
        System.out.println("\nj)Xoa ten student id = 2");
        removeNameById(2, newStudents);

        // k
        System.out.print("\nk)Xoa student co id = 5");
        removeStuById(5, newStudents);
        System.out.print("\nSau khi xoa:\n");
        for (Student s : newStudents) {
            System.out.println(s.toString());
        }

        // l
        System.out.println("\nl)ArrayList copies");
        List<Student> newStuArray = new ArrayList<>(newStudents);
        for(Student s: newStuArray) {
        	System.out.println(s.toString());
        }
        
        // m
        System.out.println("\nm)Set student khong co ten trung lap");
        Set<Student> newStuNoDupName = delStuDupName(newStudents);
        for(Student s: newStuNoDupName) {
        	System.out.println(s.toString());
        }
        
        // n
        System.out.println("\nn) Sap xep set student khong co ten trung lap");
        Set<Student> sortStudents = new TreeSet<>(Comparator.comparing(Student::getName));
        sortStudents.addAll(newStuNoDupName);
        for(Student s: sortStudents) {
        	System.out.println(s.toString());
        }

	}
	
	public static Set<Student> delStuDupName(Set<Student> students) {
		Set<Student> dupStudents = new LinkedHashSet<>();
		for(Student s1: students) {
			int id = s1.getId();
			for (Student s2: students) {
				if (s2.getId() != id && s2.getId() > id && s1.getName() != null && s2.getName() != null) {
					if(s1.getName().equalsIgnoreCase(s2.getName())) {
						dupStudents.add(s2);
					} 
				} else if (s2.getName() == null) {
					dupStudents.add(s2);
				}
			}
		}
		students.removeAll(dupStudents);
		return students;
	}

	public static void findStuDupName(Set<Student> newStudents) {
		int count = 0;
		for(Student s1: newStudents) {
			int id = s1.getId();
			for (Student s2: newStudents) {
				if (s2.getId() != id && s2.getId() > id) {
					if(s1.getName().equalsIgnoreCase(s2.getName())) {
						System.out.println("\nPair " + count++);
						System.out.println(s1.toString());
						System.out.println(s2.toString());
					}
				}
			}
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
