package com.tnl.frontend;

import java.util.ArrayList;

import com.tnl.entity.Studentt;

public class IMStudent {

	public static void main(String[] args) {
		ArrayList<Studentt> students = new ArrayList<>();

        // Tạo 10 học sinh, chia thành 3 nhóm
        students.add(new Studentt(1, 1, "Student 1"));
        students.add(new Studentt(2, 1, "Student 2"));
        students.add(new Studentt(3, 1, "Student 3"));
        students.add(new Studentt(4, 2, "Student 4"));
        students.add(new Studentt(5, 2, "Student 5"));
        students.add(new Studentt(6, 2, "Student 6"));
        students.add(new Studentt(7, 3, "Student 7"));
        students.add(new Studentt(8, 3, "Student 8"));
        students.add(new Studentt(9, 3, "Student 9"));
        students.add(new Studentt(10, 1, "Student 10"));
        
        // Kêu gọi cả lớp điểm danh.
        for (Studentt student : students) {
            student.điemDanh();
        }
        
        System.out.println("\n\n");
        
        // Gọi nhóm 1 đi học bài
        for (Studentt student : students) {
            if(student.getGroup() == 1) {
            	student.hocBai();
            }
        }
        
        System.out.println("\n\n");
        
        // Gọi nhóm 2 đi dọn vệ sinh
        for (Studentt student : students) {
        	if(student.getGroup() == 2) {
        		student.điDonVeSinh();
            }
        }

	}

}
