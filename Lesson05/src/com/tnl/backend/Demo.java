package com.tnl.backend;

import com.tnl.entity.MyMath;

public class Demo {

	public static void main (String[] args) {
		MyMath myMath = new MyMath();
		
		// Test sum with int
        int intResult = myMath.sum(5, 10);
        System.out.println("Sum of 5 and 10 (int): " + intResult);

        // Test sum with byte
        byte byte1 = 2;
        byte byte2 = 3;
        int byteResult = myMath.sum(byte1, byte2);
        System.out.println("Sum of 2 and 3 (byte): " + byteResult);

        // Test sum with float
        float floatResult = myMath.sum(1.5f, 2.5f);
        System.out.println("Sum of 1.5 and 2.5 (float): " + floatResult);
;	}
}
