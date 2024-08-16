package com.tnl.backend;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.tnl.entity.Department;
import com.tnl.entity.Student;

public class Service {

	public static boolean isRunning = false;
	
	public static int getTong(int a, int b) {
		return a + b;
	}
	
	public int getHieu(int a, int b) {
		return a - b;
	}
	
	public Department getDepartment() {
		Department dp = new Department(2, "Sale");
		return dp;
	}
	
	public Department getDepartment(Department dp) {
		dp.setId(3);
		dp.setDepartmentName("CNTT");
		return dp;
		
	}
	
	//-----------------------------------------------------------------
	
	public void getStudent(ArrayList<Student> stuList) {
		for(Student s: stuList) {
			System.out.println(s.toString());
		}
	}
	
	//------------------------------------------------------------------
	
	public static final String ERROR_FILE_NOT_EXIST = "Error! File Not Exist";
    public static final String ERROR_FILE_ALREADY_EXIST = "Error! File Already Exists";
    
    // question 1
	public boolean isFileExists(String pathFile) {
		File file = new File(pathFile);
	    return file.exists();
	}
	
	// question 2
	public void createNewFile(String pathFile) {
		try {
			File file = new File(pathFile);
			if (file.exists()) {
				throw new IOException(ERROR_FILE_ALREADY_EXIST);
			} else {
				file.createNewFile();
				System.out.println("File was created at " + pathFile);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// question 3
	public void createNewFile(String pathFile, String fileName) {
		try {
			File file = new File(pathFile + File.separator + fileName);
			if (file.exists()) {
				throw new IOException(ERROR_FILE_ALREADY_EXIST);
			} else {
				file.createNewFile();
				System.out.println("File `" + fileName + "` has been created at " + pathFile);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// question 4
	public void deleteFile(String pathFile) {
		try {
			File file = new File(pathFile);
			if (!file.exists()) {
				throw new IOException(ERROR_FILE_NOT_EXIST);
			} else {
				file.delete();
				System.out.println("File has been deleted !");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
