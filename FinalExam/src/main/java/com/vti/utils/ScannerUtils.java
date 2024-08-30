/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.utils;

import java.util.*;

/**
 * 
 */
public class ScannerUtils {

	private static Scanner sc = new Scanner(System.in);
	
	public static String inputString(String msg) {
		while (true) {
            try {
                System.out.print(msg);
                String input = sc.nextLine().trim();
                if (!input.isEmpty()) {
                    return input;
                } else {
                    System.err.println("Input is empty, please enter data !");
                }
            } catch (Exception e) {
                System.err.println("Unexpected error occurred: " + e.getMessage());
            }
        }
	}
	
	public static int inputNumInt(String msg) {
		while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
            	System.err.println("Invalid number format: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error occurred: " + e.getMessage());
            }
        }
	}
	
	public static float inputNumFloat(String msg) {
		while (true) {
            try {
                System.out.print(msg);
                return Float.parseFloat(sc.nextLine().trim());
            } catch (NumberFormatException e) {
            	System.err.println("Invalid number format: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error occurred: " + e.getMessage());
            }
        }
	}
	
	public static double inputNumDouble(String msg) {
		while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
            	System.err.println("Invalid number format: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error occurred: " + e.getMessage());
            }
        }
	}

}
