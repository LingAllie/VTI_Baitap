package com.tnl.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ScannerUtils {

	private static Scanner sc = new Scanner(System.in);
	
	public static boolean isValidDate(String dateString, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false); // This ensures strict parsing of the date format

        try {
            // Try to parse the date string with the specified format
            sdf.parse(dateString);
            return true;
        } catch (ParseException e) {
            // If parsing raises a ParseException, it's not a valid date
            return false;
        }
    }
	
	public static String nhapNgayQuayThuong() {
		
		String ngayQT;
		while (true) {
            System.out.print("Nhập ngày quay thưởng (vd: 24/07/2024): ");
            ngayQT = sc.nextLine();

            if (!ngayQT.isEmpty() && isValidDate(ngayQT, "dd/MM/yyyy")) {
                return ngayQT;
            } else {
                System.out.println("Ngày không hợp lệ, vui lòng nhập lại.");
            }
        }
	}
	
	public static int[] nhapThongTinDatCuoc() {
        int soDatCuoc = 0;
        int loaiDatCuoc = 0;
        int soTienCuoc = 0;

        while (true) {
            System.out.print("Nhập số muốn đặt cược có 2 chữ số: ");
            if (sc.hasNextInt()) {
                soDatCuoc = sc.nextInt();
                if (soDatCuoc < 99) {
                	break;
                } else {
                	while (soDatCuoc > 99) {
                		System.out.print("Vui lòng nhập số nhỏ hơn 100: ");
                    	soDatCuoc = sc.nextInt();
                	}
                	break;
                }
            } else {
                System.out.println("Vui lòng nhập một số nguyên.");
                sc.next(); 
            }
        }

        while (true) {
            System.out.print("Lựa chọn loại cược... 1: đề | 2: lô: ");
            if (sc.hasNextInt()) {
                loaiDatCuoc = sc.nextInt();
                if (loaiDatCuoc == 1 || loaiDatCuoc == 2) {
                    break;
                } else {
                    while(loaiDatCuoc != 1 && loaiDatCuoc != 2) {
                    	System.out.print("Vui lòng lựa chọn 1 trong 2 loại cược... 1: đề | 2: lô: ");
                    	loaiDatCuoc = sc.nextInt();
                    }
                    break;
                }
            } else {
                System.out.println("Vui lòng nhập một số nguyên.");
                sc.next(); 
            }
        }

        while (true) {
            System.out.print("Nhập số tiền cược (100,000 ...etc): ");
            if (sc.hasNextInt()) {
                soTienCuoc = sc.nextInt();
                break;
            } else {
                System.out.println("Vui lòng nhập một số nguyên.");
                sc.next(); 
            }
        }

        return new int[]{soDatCuoc, loaiDatCuoc, soTienCuoc};
    }
}
