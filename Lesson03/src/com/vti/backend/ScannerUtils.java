package com.vti.backend;

import java.util.Scanner;

public class ScannerUtils {

	private static Scanner scanner = new Scanner(System.in);

	

	public static String[] inputFullName(String errorMessage) {
		while (true) {
			System.out.println("Nhập họ của bạn:");
			String input1 = scanner.nextLine().trim();
			System.out.println("Nhập tên của bạn:");
			String input2 = scanner.nextLine().trim();
			if (!input1.isEmpty()) {
				if (!input2.isEmpty()) {
					return new String[] {input1, input2};
				}
			} else {
				System.err.println(errorMessage);
			}
		}
	}

	public static int inputInt() {
		return inputInt("Please input a number as int, please input again");
	}

	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static String inputString(String require, String errorMessage) {
		while (true) {
			System.out.println(require);
			String input = scanner.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			} else {
				System.err.println(errorMessage);
			}
		}
	}
	
	public static String inputStringWithoutCheck(String require) {
		System.out.println(require);
		String input = scanner.nextLine().trim();
		return input;
	}
	
	
	public static String inputStringWithoutSpace(String require, String errorMessage) {
        while (true) {
            System.out.println(require);
            String input = scanner.nextLine().trim();
            
            if (!input.isEmpty()) {
                boolean hasSpace = false;
                char[] in = input.toCharArray();
                for (char c : in) {
                    if (c == ' ') {
                        hasSpace = true;
                        break;
                    }
                }
                
                if (hasSpace) {
                    System.err.println(errorMessage);
                } else {
                    return input;
                }
            } else {
                System.err.println("Input is empty, please enter again !");
            }
        }
    }
	

	// ---------------------------------------------
	
	public static int[] inputTwoNumbers() {
		System.out.println("Please enter the first integer (a):");
		int a = inputInt("Please input a valid integer for a, please input again.");
		
		System.out.println("Please enter the second integer (b):");
		int b = inputInt("Please input a valid integer for b, please input again.");
		
		return new int[] {a, b};
	}
	
	public static String inputFullNameWithoutTrim(String errorMessage) {
		while (true) {
			System.out.println("Nhập họ và tên của bạn:");
			String input = scanner.nextLine();
			if (!input.isEmpty()) {
				return input;
			} else {
				System.err.println(errorMessage);
			}
		}
	}
	

}
