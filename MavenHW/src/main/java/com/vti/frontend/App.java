package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Services;
import com.vti.utils.ScannerUtils;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, SQLException, IOException
    {
    	
    	while(true) {
    		menu();
    		System.out.print("Please choose a service: ");
    		int req = ScannerUtils.inputInt();
    		while (req != 1 && req != 2 && req != 3 && req != 4 && req != 5) {
    			System.out.print("Please choose a service: ");
        		req = ScannerUtils.inputInt();
    		}
    		switch(req) {
    		case 1:
    			Services.insertDepartment();
    			break;
    		case 2:
    			Services.insertPosition();
    			break;
    		case 3:
    			Services.insertUser();
    			break;
    		case 4:
    			Services.viewUsers();
    			break;
    		case 5:
    			System.out.println("Exit program...");
    			return;
    		}
    	}
    	
    }

	public static void menu() {
		System.out.println("\n\n //---------- Menu -----------//");
		System.out.println("1. Insert Department");
		System.out.println("2. Insert Position");
		System.out.println("3. Insert User");
		System.out.println("4. View User");
		System.out.println("5. Exit");
		System.out.println("\n //---------- ~.~ -----------//");
		
	}
}
