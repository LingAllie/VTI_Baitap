package com.tnl.frontend;

import com.tnl.backend.IStudy;
import com.tnl.entity.Student;
import com.tnl.entity.Teacher;

public class Program {

	public static void main(String[] args) {
		IStudy isStudent1 = new Student(1, "Allie", "HCM", "0777477");
		IStudy isTeacher1 = new Teacher(1, "Ying", "BJ", "0777599");
		
		isStudent1.rollUp();
		isTeacher1.rollUp();
		
		isStudent1.doHomeWork();
		isTeacher1.doHomeWork();
		
		isStudent1.copyHomeWork();
		isTeacher1.copyHomeWork();
	}

}
