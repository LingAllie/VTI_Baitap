package com.tnl.backend;

import java.time.LocalDate;
import java.util.*;

import com.vti.backend.ScannerUtils;

public class TSAEx3 {

    public static void main(String[] args) {

	    System.out.println("Exercise 1: Datatype Casting");
	    	
	    	System.out.println("Question 1.1");
		    	question1_1();
		    	
		    System.out.println("\nQuestion 1.2");
		    	int randomNumber = question1_2();
		    	System.out.printf("Random 5-digit number: %05d\n", randomNumber);
		    	
		    System.out.println("\nQuestion 1.3");
		    	question1_3();
		    	
		    System.out.println("\nQuestion 1.4");
		    	question1_4();
    	
	    	
	    System.out.println("\n\nExercise 2: Default value");
		    System.out.println("\nQuestion 2.1");
    	    	question2_1();
    	
    	
	    System.out.println("\n\nExercise 3: Boxing & unboxing");
		    System.out.println("\nQuestion 3.1");
		      question3_1();
		    
		    System.out.println("\nQuestion 3.2");
		      question3_2();
		    
		    System.out.println("\nQuestion 3.3");
		      question3_3();
    	
    
        System.out.println("\n\nExercise 4: String");
		    System.out.println("\nQuestion 4.1");
				question4_1();
		    
		    System.out.println("\nQuestion 4.2");
				question4_2();
		    
		    System.out.println("\nQuestion 4.3");
				question4_3();
		    
		    System.out.println("\nQuestion 4.4");
		    	question4_4();
		    
		    System.out.println("\nQuestion 4.5");
		    	question4_5();
		    
		    System.out.println("\nQuestion 4.6");
		    	question4_6();
		    
		    System.out.println("\nQuestion 4.7");
		    	question4_7();
    	
    	Account[] accounts = {
 				new Account("john.doe@example.com", "john_doe", "John Doe", LocalDate.now()),
 				new Account("jane.smith@example.com", "jane_smith", "Jane Smith", LocalDate.now()),
 				new Account("alice.brown@example.com", "alice_brown", "Alice Brown", LocalDate.now()),
 				new Account("bob.johnson@example.com", "bob_johnson", "Bob Johnson", LocalDate.now())
 		};
    	
    	Group[] groups = {
 	            new Group(1, "Team py", accounts[0], LocalDate.now()),
 	            new Group(2, "Java", accounts[1], LocalDate.now()),
 	            new Group(3, "Team Java", accounts[2], LocalDate.now()),
 	            new Group(4, "JavaScript", accounts[3], LocalDate.now())
 	    };
    	
		    System.out.println("\n\nQuestion 4.8");
		   		question4_8(groups);
		    
		    System.out.println("\nQuestion 4.9");
		    	question4_9(groups);
		    
		    System.out.println("\nQuestion 4.10");
		    	question4_10();
		    
		    System.out.println("\nQuestion 4.11");
		    	question4_11('a');
		    
		    System.out.println("\nQuestion 4.12");
		    	question4_12();
		    
		    System.out.println("\nQuestion 4.13");
		    	question4_13();
		    
		    System.out.println("\nQuestion 4.14");
		    	question4_14();
		    
		    System.out.println("\nQuestion 4.15");
		    	question4_15();
		    
		    System.out.println("\n\nQuestion 4.16");
		    	question4_16();
		    
		    System.out.println("\nQuestion 4.17");
    	
    	
        System.out.println("\n\nExercise 5: Object’s Method");
		    	Department[] departments = new Department[5];
		        departments[0] = new Department(1, "Phòng A", "123 ABC Street");
		        departments[1] = new Department(2, "Boss of director", "456 DEF Street");
		        departments[2] = new Department(3, "Marketing", "789 GHI Street");
		        departments[3] = new Department(4, "Sale", "012 JKL Street");
		        departments[4] = new Department(5, "Waiting room", "345 MNO Street");
        
		    System.out.println("\nQuestion 5.1");
            	question5_1(departments);
		    
		    System.out.println("\nQuestion 5.2");
		    	question5_2(departments);
		    
		    System.out.println("\nQuestion 5.3");
		    	question5_3(departments);
		    
		    System.out.println("\nQuestion 5.4");
		    	question5_4(departments);
		    
		    System.out.println("\nQuestion 5.5");
		    	question5_5(departments);
		    
		    System.out.println("\nQuestion 5.6");
		    	question5_6(departments);
    }
    



	// --------------------------------------Exercise 1----------------------------------------------
    
    public static void question1_1() {
    	
    	float salary1 = 5240.5f;
        float salary2 = 10970.055f;

        int roundedSalary1 = Math.round(salary1);
        int roundedSalary2 = Math.round(salary2);

        System.out.printf("Rounded salary of Account 1: %d\n", roundedSalary1);
        System.out.printf("Rounded salary of Account 2: %d\n", roundedSalary2);
	}

    public static int question1_2() {
		
		Random random = new Random();
        int randomNumber = random.nextInt(90000); 

        return randomNumber;
	}

	public static void question1_3() {
		
        int randomNumber = question1_2();

        // Solution 1
        String numberStr = String.valueOf(randomNumber); 
        String lastTwoDigitsStr = numberStr.substring(numberStr.length() - 2);

        // Solution 2
        int lastTwoDigits = randomNumber % 100; 

        System.out.printf("Random 5-digit number: %05d\n", randomNumber);
        System.out.printf("Last two digits (Method 1): %s\n", lastTwoDigitsStr);
        System.out.printf("Last two digits (Method 2): %02d\n", lastTwoDigits);
	}

	public static void question1_4() {
		
		int[] arr = ScannerUtils.inputTwoNumbers();
		
		double a = arr[0];
		double b = arr[1];
		
		if (b != 0) {
			System.out.printf("The result of division a / b is: %.2f\n", (double) (a/b));
		} else {
			System.out.println("Cannot divide by zero.");
		}
	}
	
	// --------------------------------------Exercise 2----------------------------------------------
	
	public static void question2_1() {
		
        Account[] accounts = new Account[5];

        for (int i = 0; i < accounts.length; i++) {
            String email = "Email " + (i + 1);
            String username = "User name " + (i + 1);
            String fullName = "Full name " + (i + 1);
            LocalDate createDate = LocalDate.now();

            accounts[i] = new Account(email, username, fullName, createDate);
        }

        for (Account account : accounts) {
            System.out.println(account);
        }
		
	}
	
	// --------------------------------------Exercise 3----------------------------------------------

	public static void question3_1() {
        
        Integer iSal = 5000;
        float fSal = iSal.floatValue();
        
        System.out.printf("Integer: %d\t\t", iSal);
        System.out.printf("float: %.2f", fSal);
        System.out.println("\n");
    }

    public static void question3_2() {
        
        String sA = "1234567";
        int iA = Integer.valueOf(sA);
        
        System.out.printf("String: %s\t\t", sA);
        System.out.printf("int: %d", iA);
        System.out.println("\n");
    }

    public static void question3_3() {
        
        Integer num1 = new Integer("1234567");
        int num2 = num1.intValue();
        
        System.out.printf("Integer: %d\t", num1);
        System.out.printf("int: %d", num2);
        System.out.println("\n");
    }
    
    // --------------------------------------Exercise 4----------------------------------------------
    
    public static void question4_1() {
    	
		String input = ScannerUtils.inputString("Input a string", "The input is empty, please try again !");
		char[] words = input.toCharArray();
		int count = 0;
		for(char c : words) {
			if (c != ' ') {
				count++;
			}
		}
		System.out.println("The length of input string is " + count);
		
	}


    public static void question4_2() {
    	
    	String s1 = ScannerUtils.inputString("Input first string", "The input is empty, please try again !");
    	String s2 = ScannerUtils.inputString("Input second string", "The input is empty, please try again !");
		
    	System.out.println("\nThe concat of s1 and s2 is " + s1.concat(' ' + s2));
	}


    public static void question4_3() {
    	
    	String name = ScannerUtils.inputString("Input your name", "The input is empty, please try again !");
    	char[] words = name.toCharArray();
    	if (words[0] >= 'a' && words[0] <= 'z') {
    		words[0] = (char) (words[0] + 'A' - 'a');
        }
    	
    	for (int i = 1; i < words.length; i++) {
            if (words[i - 1] == ' ' && words[i] >= 'a' && words[i] <= 'z') {
                words[i] = (char) (words[i] + 'A' - 'a');
            }
        }
    	
    	String new_string = new String(words);
        
        System.out.println("Result: " + new_string);
	}


    public static void question4_4() {
    	
    	String name = ScannerUtils.inputString("Input your name", "The input is empty, please try again !");
    	char[] words = name.toCharArray();
    	
    	for(int i = 0; i < words.length; i++) {
    		 if (words[i] >= 'a' && words[i] <= 'z') {
                 System.out.println("Ký tự thứ 1 là: " + (char) (words[i] - 'a' + 'A'));
             } else {
                 System.out.println("Ký tự thứ 1 là: " + words[i]);
             }
    	}
	}


    public static void question4_5() {
    	
    	String[] fullName = ScannerUtils.inputFullName("The input is empty, please try again !");
    	System.out.println("Your full name is " + fullName[0].concat(' ' + fullName[1]));	
	}


    public static void question4_6() {
    	
    	String fullName = ScannerUtils.inputString("Input your full name", "The input is empty, please try again !");
    	String[] splitFullName = fullName.split("\\s+");
    	System.out.println("Họ là: " + splitFullName[0]);    	
    	System.out.print("Tên đệm là: ");
    	for (int i = 1; i < splitFullName.length - 1; i++) {
    		System.out.print(splitFullName[i] + ' ');
    	}
    	System.out.println("\nTên là: " + splitFullName[splitFullName.length - 1]);
		
	}
    
    
    public static void question4_7() {
    	
    	String fullName = ScannerUtils.inputFullNameWithoutTrim("The input is empty, please try again !").trim();
    	String splitFullName[] = fullName.split("\\s+");
    	System.out.print("Full name: ");
    	for(String s : splitFullName ) {
    		s.trim();
    		char[] c = s.toCharArray();
    		if (c[0] >= 'a' && c[0] <= 'z') {
    			c[0] = (char) (c[0] + 'A' - 'a');
    		}
    		System.out.print(new String(c) + ' ');
    	}	
	}
    

    public static void question4_8(Group[] groups) {
    	
    	for(Group g : groups) {
    		if (g.groupName.contains("Java")) {
    			System.out.println(g.toString());
    		}
    	}
	}


    public static void question4_9(Group[] groups) {
    	
    	for(Group g : groups) {
    		if (g.groupName.equals("Java")) {
    			System.out.println(g.toString());
    		}
    	}
	}


    public static void question4_10() {
    	
    	String input = ScannerUtils.inputString("Input a string to check if it has equal inverse", "Input is empty, please enter again !");
    	char[] in = input.toCharArray();
    	char[] out = new char[in.length];
    	
    	int count = 0;
    	for(int i = in.length - 1; i >= 0; i--) {
    		out[count] = in[i];
    		count++;
    	}
    	
    	String output = new String(out);
    	
    	if (input.equalsIgnoreCase(output)) {
    		System.out.println("OK");
    	} else {
    		System.out.println("KO");
    	}
		
	}
    
    public static void question4_11(char specialCharacter) {
    	
		String input = ScannerUtils.inputString("Input a string", "Input is empty, please enter again !");
		char[] cout = input.toCharArray();
		int count = 0;
		for(char c : cout) {
			if (c == specialCharacter) {
				count++;
			}
		}
		
		System.out.println("The frequent character '" + specialCharacter + "' appears is " + count);
	}


    public static void question4_12() {
    	
    	String input = ScannerUtils.inputString("Input a string to see its reverse", "Input is empty, please enter again !");
    	char[] in = input.toCharArray();
    	char[] out = new char[in.length];
    	
    	int count = 0;
    	for(int i = in.length - 1; i >= 0; i--) {
    		out[count] = in[i];
    		count++;
    	}
    	
    	String output = new String(out);
    	System.out.println("The reverse string of " + input + " is " + output);
		
	}


    public static void question4_13() {
    	
    	String input = ScannerUtils.inputStringWithoutCheck("Input a string");
    	if (input == null || input.isEmpty()) {
            System.out.println("False");
        }

    	for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
            	System.out.println("False");
            	return;
            }
    	}
    	System.out.println("True"); 
	}


    public static void question4_14() {
    	
    	String input = ScannerUtils.inputString("Input a string", "Input is empty, please enter again !");
    	String input2 = ScannerUtils.inputString("The character replace: ", "Input is empty, please enter again !");
    	String input3 = ScannerUtils.inputString("The character want to be replaced in string: ", "Input is empty, please enter again !");
    	
    	System.out.println("Before: " + input);
    	
    	char[] str = input.toCharArray();
    	
    	for(int i = 0; i < str.length; i++) {
    		if (str[i] == input3.toCharArray()[0] || str[i] == (input3.toCharArray()[0] + 'A' - 'a')) {
    			str[i] = input2.toCharArray()[0];
    		}
    	}
    	
    	System.out.println("After: " + new String(str));
		
	}


    public static void question4_15() {
    	
    	String input = ScannerUtils.inputString("Input a sentence", "Input is empty, please enter again !");
    	String[] inputArray = input.split("\\s+");
    	for (String s : inputArray) {
    		s.trim();
    	}
    	for(int i = inputArray.length - 1; i >= 0; i--) {
    		System.out.print(inputArray[i] + ' ');
    	}
	}


    public static void question4_16() {
    	
    	int n = 0;
    	String input = ScannerUtils.inputStringWithoutSpace("Input string without space: ", "The input still has space !!!");
    	System.out.println("Input number to devide string: ");
    	n = ScannerUtils.inputInt();
		while (n <= 0) {
			input = ScannerUtils.inputStringWithoutSpace("Input string without space: ", "The input still has space !!!");
			System.out.println("Input number to devide string: ");
			n = ScannerUtils.inputInt();
		}
		
		if (input.length() % n != 0) {
	           System.out.println("KO");
	           return;
	    }
		
		for (int i = 0; i < input.length(); i += n) {
            System.out.println(input.substring(i, i + n));
        }
	}
    
 // --------------------------------------Exercise 5----------------------------------------------
    public static void question5_1(Department[] deps) {
    	
    	deps[0].toString();
	}
    
    
    public static void question5_2(Department[] deps) {
    	
    	for(Department d : deps) {
    		System.out.println(d.toString());
    	}
	}
    
    
    public static void question5_3(Department[] deps) {
    	
    	System.out.println(deps[0].address);
    	
	}
    
    
    public static void question5_4(Department[] deps) {
    	
    	String name = ScannerUtils.inputString("Input department name want to check with department 1", "The input is empty, please try again !");
    	
    	System.out.println("Phòng ban thứ 1 có tên là '" + name + "' không ? -> " + deps[0].equalsByName(name));
    	
	}
    
    
    public static void question5_5(Department[] deps) {
    	
    	System.out.println("Phòng ban thứ 1 và phòng ban thứ 2 có bằng nhau ? -> " + deps[0].equals(deps[1]));
    	
	}
    
    
    public static void question5_6(Department[] deps) {
    	
    	Department temp = new Department(0, null, null);
    	
    	for (int i = 0 ; i < deps.length - 1; i++) {
            for (int j = i + 1; j < deps.length; j++) {
                if (deps[i].name.toCharArray()[0] > deps[j].name.toCharArray()[0]) {
                    temp = deps[j];
                    deps[j] = deps[i];
                    deps[i] = temp;
                }
            }
        }
    	
    	for (Department d : deps) {
    		System.out.println(d.name);
    	}
    	
    }
    
}
