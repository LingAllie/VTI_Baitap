package com.tnl.backend;

import java.util.Scanner;

public class Program {

	
	public static boolean isViettel (String phoneNumber) {
		String[] viettelPrefixes = {"098", "097", "096", "086", "032", "033", "034", "035", "036", "037", "038", "039"};
        
        String prefix = phoneNumber.substring(0, 3);
        
        for (String viettelPrefix : viettelPrefixes) {
            if (prefix.equals(viettelPrefix)) {
                return true;
            }
        }

        return false;
	}
	
	
	public static void main (String[] args) {
		
		// ép kiểu ngầm định
		// int nhỏ hơn long về mặt kích thước nên có thể chuyển
		// "nới rộng khoảng cách"
		int num1 = 1000000000;
		long num2 = num1;
		
//		System.out.println(num1 + "\n" + num2);
		
		// double - float - long - int - short - byte
		
		// "thu hẹp khoảng cách"
		long num3 = 400000001;
//		int num4 = num3; -> không thể ép kiểu lớn sang bé bằng kiểu ngầm định
		int num4 = (int) num3;
		// nếu dữ liệu kích thước lớn ép về kích thước nhỏ không đủ chứa thì sẽ trả về kết quả sai
//		System.out.println(num3 + "\n" + num4);
		
	
		float salary1 = 5240.5f;
		float salary2 = 10970.055f;
		
		int sal1 = (int) salary1;
		int sal2 = (int) salary2;
		
//		System.out.println(salary1 + "\n" + sal1);
//		System.out.println("\n------");
//		System.out.println(salary2 + "\n" + sal2);
		
		String name1 = "Allie";
		String name2 = new String("Allie");
		if (name1.equals(name2)) { // -> equals ép name1 từ primitive sang object
			System.out.println("Name1 == name2");
		} else {
			System.out.println("Name1 != name2");
		}
		
		// liên quan đến kiểu string cần check null
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input phone number: ");
		String phoneNumber = sc.nextLine();
		
        if (phoneNumber.startsWith("0") && phoneNumber.length() == 10) {
            System.out.println("Số điện thoại có độ dài hợp lệ.");

            if (isViettel(phoneNumber)) {
                System.out.println("Số điện thoại thuộc mạng VIETTEL.");
            } else {
                System.out.println("Số điện thoại không thuộc mạng VIETTEL.");
            }
        } else {
            System.out.println("Số điện thoại không hợp lệ.");
        }
		
		sc.close();
		
	}
}
