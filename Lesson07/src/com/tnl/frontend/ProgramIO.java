package com.tnl.frontend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProgramIO {

	public static void main(String[] args) throws IOException {
	    try {
	        File f = new File("D:\\VTI_Baitap\\File\\Text.txt");
	        FileInputStream fi = new FileInputStream(f);
	        byte[] b = new byte[1024];
	        int length = fi.read(b);
	        
	        while (length > -1) {
	        	String content = new String(b, 0, length);
	            System.out.println("Content: " + content);
	            length = fi.read(b);
	        }
	        
	        fi.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    try {
	        String name = "tang nha linh";
	        File file = new File("D:\\VTI_Baitap\\File\\Text.txt");
	        FileOutputStream fo = new FileOutputStream(file);
	        fo.write(name.getBytes());
	        fo.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
