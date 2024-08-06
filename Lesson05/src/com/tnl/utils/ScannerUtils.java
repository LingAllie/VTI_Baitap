package com.tnl.utils;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner sc = new Scanner(System.in);

    public static int inputInt() {
        return getOption("Please input option as type integer number!");
    }

    public static int getOption(String errorMessage) {
        while (true) {
            try {
                System.out.print("\nMenu: \n1. Insert news \n2. View list news \n3. Average rate \n4. Exit\nYour option: ");
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println(errorMessage);
            }
        }
    }

    public static String getInfor(String require, String errorMessage) {
        while (true) {
            System.out.print(require);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.err.println(errorMessage);
            }
        }
    }

    public static int[] getRates(String errorMessage) {
        while (true) {
            System.out.print("\n\nPlease enter 3 values for rating (e.g., 2 1 3): ");
            String[] rating = sc.nextLine().trim().split("\\s+");
            if (rating.length == 3) {
                try {
                    return new int[]{Integer.parseInt(rating[0]), Integer.parseInt(rating[1]), Integer.parseInt(rating[2])};
                } catch (NumberFormatException e) {
                    System.err.println(errorMessage);
                }
            } else {
                System.err.println(errorMessage);
            }
        }
    }
    
    public static float getDTB() {
    	while(true) {
    		try {
    			System.out.println("Diem trung binh cua ban: ");
    			return Float.parseFloat(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Diem trung binh khong duoc de trong !");
            }
    	}
    }
    
    public static int getAction(String errorMessage) {
        while (true) {
            try {
                System.out.print("\nMenu: \n1. Thêm mới thí sinh \n2. Hiện thị thông tin của thí sinh và khối thi của thí sinh \n3. Tìm kiếm theo số báo danh \n4. Thoát khỏi chương trình \nLựa chọn của bạn: ");
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println(errorMessage);
            }
        }
    }

}
