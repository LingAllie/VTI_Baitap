package com.tnl.frontend;

import java.io.File;
import java.io.IOException;

import com.tnl.backend.Service;
import com.tnl.entity.Department;

public class Program {

	public static void main(String[] args) throws IOException {
//		Department d1 = new Department(1, "IT");
//		
//		System.out.println(d1.toString());
//		
//		int tong = Service.getTong(1, 2);
//		System.out.println(tong);
//		
//		Service sv = new Service();
//		System.out.println(sv.getHieu(tong, 0));
//
//		System.out.println(sv.getDepartment().toString());
//		
//		//-------------------------------------------------
//		
//		File file = new File("D:\\VTI_Baitap\\File");
//		File file = new File("D:\\VTI_Baitap\\File\\Test.txt");
//		if (file.exists()) {
//			System.out.println("File ton tai");
//			file.delete();
//		} else {
//			file.createNewFile();
//			// tao file trong o cung da het cho 
//		}
		
//		if (file.isDirectory()) {
//			System.out.println("File la thu muc");
//			File[] lst = file.listFiles();
//			System.out.println(lst.length);
//		} else {
//
//			System.out.println("File ton tai");
//		}
		
		//----------------------------------------------------
		
		Service sv = new Service();
		String filePath = "D:\\VTI_Baitap\\File\\Text1.txt";
        String directory = "D:\\VTI_Baitap\\File";
        String fileName = "Text2.txt";

//        // Kiểm tra file có tồn tại không
//        if (sv.isFileExists(filePath)) {
//            System.out.println("File exists at " + filePath);
//        } else {
//            System.out.println("File does not exist at " + filePath);
//        }

        // Tạo file mới
//        sv.createNewFile(directory, fileName);

        // Xóa file
        sv.deleteFile(filePath);
		
	}
	

}
