package com.tnl.frontend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.tnl.entity.Department;

public class ProgramO {

	public static void main(String[] args) throws IOException{
		 try {
//	            Department dp = new Department(1, "HR");
//	            FileOutputStream fileOuput = new FileOutputStream("D:\\VTI_Baitap\\File\\Department.ser");
//	            ObjectOutputStream obt = new ObjectOutputStream(fileOuput);
//	            obt.writeObject(dp);
//	            obt.close();

	            FileInputStream fileInpt = new FileInputStream("D:\\VTI_Baitap\\File\\Department.ser");
	            ObjectInputStream ibt = new ObjectInputStream(fileInpt);
	            Object obj = ibt.readObject();
	            ibt.close();

	            Department dp2 = (Department) obj;
	            System.out.println(dp2.getDepartmentName());

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
