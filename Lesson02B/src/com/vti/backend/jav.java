package com.vti.backend;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class jav {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
    //     boolean ketqua = true;

    //    while(ketqua) {
    //     System.out.println("Nhap so: ");
    //     int a = sc.nextInt();
        // if(a < 10) {
        //     System.out.println(a + " la so co 1 chu so");
        // } else {
        //     System.out.println(a + " la so co 2 chu so");
        //     break;
        // }
    //     ketqua = a < 10 ? ketQuaMot(a) : ketQuaHai(a);
    //    }
    // Random r = new Random();
    // while(true) {
    //     int a = r.nextInt(20);
    //     if (a >= 5 && a <=20) {
    //         System.out.println(a);
    //         break;
    //     }
    // }


        //   // Lấy ngày đầu năm và ngày cuối năm
        // LocalDate startOfYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        // System.out.println(startOfYear);
        // LocalDate endOfYear = LocalDate.of(LocalDate.now().getYear(), 12, 31);
        // System.out.println(endOfYear);
        
        // // Tính số ngày trong năm
        // long totalDays = ChronoUnit.DAYS.between(startOfYear, endOfYear) + 1; // Thêm 1 để bao gồm ngày cuối cùng
        // System.out.println(totalDays);

        // // Sinh số ngẫu nhiên từ 0 đến totalDays - 1
        // Random random = new Random();
        // long randomDays = random.nextLong(totalDays);
        // System.out.println(randomDays);
        
        // // Tạo ngày ngẫu nhiên trong năm
        // LocalDate randomDate = startOfYear.plusDays(randomDays);
        // System.out.println(randomDate);
        
        // // In ra ngày ngẫu nhiên
        // System.out.println("Ngày ngẫu nhiên trong năm nay: " + randomDate);

        // System.out.println("//look like cmt");

LinkedList list = new LinkedList();
        list.add(new Integer(2));
        list.add(new Integer(5));
        list.add(new Integer(8));
        Iterator i = list.iterator();
        Collections.reverse(list);
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
    }

    private static boolean ketQuaMot(int a) {
        System.out.println(a + " la so co 1 chu so");
        System.out.println("Tiep tuc nhap ? 1: co | 2: khong");
        int opt = sc.nextInt();
        boolean res = true;
        switch(opt) {
            case 1:
                res = true;
                break;
            case 2: 
                res = false;
                break;
        }
        return res;
    }

    private static boolean ketQuaHai(int a) {
        System.out.println(a + " la so co 2 chu so");
        System.out.println("Tiep tuc nhap ? 1: co | 2: khong");
        int opt = sc.nextInt();
        boolean res = false;
        switch(opt) {
            case 1:
                res = true;
                break;
            case 2: 
                res = false;
                break;
        }
        return res;
    }
}
