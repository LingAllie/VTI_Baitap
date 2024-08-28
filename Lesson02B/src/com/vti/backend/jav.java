package com.vti.backend;

import java.util.Scanner;

public class jav {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        boolean ketqua = true;

       while(ketqua) {
        System.out.println("Nhap so: ");
        int a = sc.nextInt();
        // if(a < 10) {
        //     System.out.println(a + " la so co 1 chu so");
        // } else {
        //     System.out.println(a + " la so co 2 chu so");
        //     break;
        // }
        ketqua = a < 10 ? ketQuaMot(a) : ketQuaHai(a);
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
