package com.tnl.backend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Date;
import java.util.Locale;
//import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		
//		// Date format by country using Locale
//		Locale locale = new Locale("vn", "VN");
//		Locale locale2 = new Locale("fr", "FR");
//		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
//		DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.DEFAULT, locale2);
//		
//		String today = dateFormat.format(new Date());
//		String today2 = dateFormat2.format(new Date());
//		System.out.println(today);
//		System.out.println(today2);
//		
//		// Date format by pattern using SimpleDateFormat with defined pattern
//		String pattern = "YYYY-MM-dd"; //"dd/MM/YYYY"...
//		SimpleDateFormat spdf = new SimpleDateFormat(pattern);
//		String today3 = spdf.format(new Date());
//		System.out.println(today3);
//		
//		
//		//Question 2
//		System.out.printf("%,d%n", 100000000);
//		
//		//Question 3
//		System.out.printf("%.4f%n", 5.567098);
//		
//		
//		int n = 1000000;
//        int negative = -1000000;
//
//        // Comma flag for grouping separator
//        System.out.printf("With commas: %,d%n", n);
//
//        // Left-justify within 15 spaces
//        System.out.printf("Left-justified: %-15d%n", n);
//
//        // Pad with leading zeros to width 10
//        System.out.printf("Leading zeros: %010d%n", n);
//
//        // Enclose negative numbers in parentheses
//        System.out.printf("Negative with parentheses: %(d%n", negative);
//
//        // Include a plus sign for positive numbers
//        System.out.printf("Positive with plus sign: %+d%n", n);
//        
//        // Add a leading space for positive numbers
//        System.out.printf("Positive with leading space: % d%n", n);
        
        Random rd = new Random();
        int songuyen2 = rd.nextInt(10); 
        System.out.print(songuyen2 * -1);

	}

}
