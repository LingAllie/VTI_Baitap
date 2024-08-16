package com.tnl.frontend;

import java.util.ArrayList;

import com.tnl.backend.Service;
import com.tnl.entity.Student;

public class ProgramEx1 {

	public static void main(String[] args) {
		
		ArrayList<Student> stuList = new ArrayList<>();
		
		Student st1 = new Student(1, "Nguyễn Văn A");
		Student st2 = new Student(2, "Nguyễn Văn B");
		Student st3 = new Student(3, "Nguyễn Văn C");
		
		stuList.add(st1);
		stuList.add(st2);
		stuList.add(st3);
		
		Service sv = new Service();
		sv.getStudent(stuList);

		System.out.println("\n");
		
		Student.college = "Đại học công nghệ";
		sv.getStudent(stuList);
		
		
	}
}
