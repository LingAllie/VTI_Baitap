package com.tnl.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {
	
	public static final String ERROR_FILE_NOT_EXIST = "Error! File Not Exist";
    public static final String ERROR_FILE_ALREADY_EXIST = "Error! File Already Exists";

	public static void readFile(String filePath) {
		try {
	        File f = new File(filePath);
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
	}
	
	public static void writeFile(String filePath, String content) {
		 try {
		        File f = new File(filePath);
		        FileOutputStream fo = new FileOutputStream(f);
		        fo.write(content.getBytes());
		        fo.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}
	
	public boolean isFileExists(String pathFile) {
		File file = new File(pathFile);
	    return file.exists();
	}
	
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
	
	public void appendFileContent(String pathFile, String content) {
		try {
			File file = new File(pathFile);
			if (!file.exists()) {
				throw new IOException(ERROR_FILE_NOT_EXIST);
			}
			FileOutputStream fo = new FileOutputStream(file, true);
			fo.write(content.getBytes());
			fo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void copyFile(String sourceFilePath, String destFilePath) {
		try {
			File sourceFile = new File(sourceFilePath);
			File destFile = new File(destFilePath);

			if (!sourceFile.exists()) {
				throw new IOException(ERROR_FILE_NOT_EXIST);
			}
			
			FileInputStream sf = new FileInputStream(sourceFile);
			FileOutputStream df = new FileOutputStream(destFile);
			
			byte[] b = new byte[1024];
			int length = sf.read(b);
			
			while(length > -1) {
				String content = new String(b, 0, length);
				df.write(content.getBytes());
			}
			
			sf.close();
			df.close();
			
			System.out.println("Copy file successfully !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listFilesInDirectory(String directoryPath) {
		try {
			File directory = new File(directoryPath);
			if (!directory.exists() || !directory.isDirectory()) {
				throw new IOException("Directory non-exist !");
			}
			File[] files = directory.listFiles();
			if (files != null && files.length > 0) {
				for(File f: files) {
					System.out.println(f);
				}
			} else {
		        System.out.println("No files found in the directory.");
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
