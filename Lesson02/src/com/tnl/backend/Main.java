package com.tnl.backend;

import java.util.*;

public class Main {

	public static void main(String[] args) {

//		DataInitialization.initializeData();

		// Create Departments
		Department sales = new Department(1, "Sales");
		Department marketing = new Department(2, "Marketing");
		Department hr = new Department(3, "HR");
		Department it = new Department(4, "IT");

		// Create Positions
		Position dev = new Position(1, "Dev");
		Position test = new Position(2, "Test");
		Position scrumMaster = new Position(3, "Scrum Master");
		Position pm = new Position(4, "PM");

		// Create Accounts
		Account account1 = new Account(1, "john.doe@example.com", "john_doe", "John Doe", sales, dev, new Date());
		Account account2 = new Account(2, "jane.smith@example.com", "jane_smith", "Jane Smith", marketing, pm,
				new Date());
		Account account3 = new Account(3, "alice.brown@example.com", "alice_brown", "Alice Brown", hr, test,
				new Date());
		Account account4 = new Account(4, "bob.johnson@example.com", "bob_johnson", "Bob Johnson", it, scrumMaster,
				new Date());

		// Create Groups
		Group group1 = new Group(1, "Team A", account1, new Date());
		Group group2 = new Group(2, "Team B", account2, new Date());
		Group group3 = new Group(3, "Team C", account3, new Date());
		Group group4 = new Group(4, "Team D", account4, new Date());

		// Create GroupAccounts

		GroupAccount[] groupAccount1 = { new GroupAccount(group1, account1, new Date()),
				new GroupAccount(group1, account2, new Date()) };

		GroupAccount[] groupAccount2 = { new GroupAccount(group2, account1, new Date()),
				new GroupAccount(group2, account2, new Date()), new GroupAccount(group2, account3, new Date()),
				new GroupAccount(group2, account4, new Date()) };

		GroupAccount[] groupAccount3 = { new GroupAccount(group3, account2, new Date()),
				new GroupAccount(group3, account3, new Date()), new GroupAccount(group3, account4, new Date()) };

		GroupAccount[] groupAccount4 = { new GroupAccount(group4, account4, new Date()) };

		// Create TypeQuestions
		TypeQuestion essay = new TypeQuestion(1, "Essay");
		TypeQuestion multipleChoice = new TypeQuestion(2, "Multiple-Choice");

		// Create CategoryQuestions
		CategoryQuestion java = new CategoryQuestion(1, "Java");
		CategoryQuestion sql = new CategoryQuestion(2, "SQL");
		CategoryQuestion net = new CategoryQuestion(3, ".NET");
		CategoryQuestion python = new CategoryQuestion(4, "Python");

		// Create Questions
		Question question1 = new Question(1, "What is Java?", java, essay, account1.accountId, new Date());
		Question question2 = new Question(2, "What is SQL?", sql, multipleChoice, account2.accountId, new Date());
		Question question3 = new Question(3, "Explain polymorphism in Java.", java, essay, account1.accountId,
				new Date());
		Question question4 = new Question(4, "What are the benefits of using Python?", python, multipleChoice,
				account4.accountId, new Date());

		// Create Answers for Essay Questions
		Answer answer1 = new Answer(1, "Java is a programming language.", question1, true);
		Answer answer3 = new Answer(3,
				"Polymorphism allows methods to do different things based on the object it is acting upon.", question3,
				true);

		// Create Answers for Multiple-Choice Questions
		// Question 2: What is SQL?
		Answer answer2_1 = new Answer(2, "SQL is a database query language.", question2, true);
		Answer answer2_2 = new Answer(3, "SQL stands for Simple Query Language.", question2, false);
		Answer answer2_3 = new Answer(4, "SQL is a type of NoSQL database.", question2, false);
		Answer answer2_4 = new Answer(5, "SQL is a programming language for web development.", question2, false);

		// Question 4: What are the benefits of using Python?
		Answer answer4_1 = new Answer(6, "Python has a simple syntax and a large standard library.", question4, true);
		Answer answer4_2 = new Answer(7, "Python is a low-level programming language.", question4, false);
		Answer answer4_3 = new Answer(8, "Python is primarily used for database management.", question4, false);
		Answer answer4_4 = new Answer(9, "Python lacks support for object-oriented programming.", question4, false);

		// Create Exams
		Exam exam1 = new Exam(1, 101, "Java Basics", java.categoryId, 60, account1, new Date());
		Exam exam2 = new Exam(2, 102, "Python Introduction", python.categoryId, 45, account4, new Date());

		// Create ExamQuestions
		ExamQuestion examQuestion1 = new ExamQuestion(exam1, question1);
		ExamQuestion examQuestion2 = new ExamQuestion(exam1, question3);
		ExamQuestion examQuestion3 = new ExamQuestion(exam2, question4);

		/* -------------------- Exercise 1: ------------------- */
		// Question 1
		System.out.println("Question 1");
		if (account2.department == null) {
			System.out.println("Nhan vien nay chua co phong ban");
		} else {
			System.out.println("Phong ban cua nhan vien nay la " + account2.department.departmentName);
		}

		// Question 2
		System.out.println("\nQuestion 2");
		List<String> new_gacc = new ArrayList<>();

		for (int i = 0; i < groupAccount1.length; i++) {
			if (groupAccount1[i].account.accountId == account2.accountId) {
				new_gacc.add(groupAccount1[i].group.groupName);
			}
			if (i == (groupAccount1.length - 1)) {
				for (int j = 0; j < groupAccount2.length; j++) {
					if (groupAccount2[j].account.accountId == account2.accountId) {
						new_gacc.add(groupAccount2[j].group.groupName);
					}
					if (j == (groupAccount2.length - 1)) {
						for (int k = 0; k < groupAccount3.length; k++) {
							if (groupAccount3[k].account.accountId == account2.accountId) {
								new_gacc.add(groupAccount3[k].group.groupName);
							}
							if (k == (groupAccount3.length - 1)) {
								for (int l = 0; l < groupAccount4.length; l++) {
									if (groupAccount4[l].account.accountId == account2.accountId) {
										new_gacc.add(groupAccount4[l].group.groupName);
									}
								}
							}
						}
					}
				}
			}
		}
		if (new_gacc.isEmpty()) {
			System.out.println("Nhan vien nay chua co group");
		} else if (new_gacc.size() == 1) {
			System.out.println("Group cua nhan vien nay la " + new_gacc.get(0));
		} else if (new_gacc.size() == 2) {
			System.out.println("Group cua nhan vien nay la " + new_gacc.get(0) + ", " + new_gacc.get(1));
		} else if (new_gacc.size() == 3) {
			System.out.println("Nhan vien nay la nguoi quan trong, tham gia nhieu group");
		} else {
			System.out.println("Nhan vien nay la nguoi hong chuyen, tham gia tat ca cac group");
		}

		/*
		 * String[] new_gacc = new String[gacc.length]; int j = 0;
		 * 
		 * for (int i = 0; i < gacc.length; i++) { if
		 * (gacc[i].getAccount().getAccountId() == account2.getAccountId()) {
		 * new_gacc[j] = gacc[i].getGroup().getGroupName(); j++; } }
		 * 
		 * if (j == 0) { System.out.println("Nhân viên này chưa có group"); } else if (j
		 * == 1) { System.out.println("Group của nhân viên này là " + new_gacc[0]); }
		 * else if (j == 2) { System.out.println("Group của nhân viên này là " +
		 * new_gacc[0] + ", " + new_gacc[1]); } else if (j == 3) {
		 * System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group"
		 * ); } else { System.out.
		 * println("Nhân viên này là người hăng say, tham gia tất cả các group"); }
		 */

		// Question 3
		System.out.println("\nQuestion 3");
		System.out.println((account2.department == null) ? "Nhân viên này chưa có phòng ban"
				: "Phòng ban của nhân viên này là " + account2.department.departmentName);

		// Question 4
		System.out.println("\nQuestion 4");
		System.out.println(
				(account1.position.positionName == "Dev") ? "Day la developer" : "Nguoi nay khong phai la Developer");

		// Question 5
		System.out.println("\nQuestion 5");
		switch (groupAccount1.length) {
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
		case 3:
			System.out.println("Nhóm có ba thành viên");
			break;
		default:
			System.out.println("Nhóm có nhiều thành viên");
			break;
		}

		// Question 6
		System.out.println("\nQuestion 6");
		switch (new_gacc.size()) {
		case 0:
			System.out.println("Nhan vien nay chua co group");
			break;
		case 1:
			System.out.println("Group cua nhan vien nay la " + new_gacc.get(0));
			break;
		case 2:
			System.out.println("Group cua nhan vien nay la " + new_gacc.get(0) + ", " + new_gacc.get(1));
			break;
		case 3:
			System.out.println("Nhan vien nay la nguoi quan trong, tham gia nhieu group");
			break;
		default:
			System.out.println("Nhóm có nhiều thành viên");
			break;
		}

		// Question 7
		System.out.println("\nQuestion 7");
		switch (account1.position.positionName) {
		case "Dev":
			System.out.println("Day la developer");
			break;
		default:
			System.out.println("Nguoi nay khong phai la Developer");
			break;
		}

		// Question 8
		System.out.println("\nQuestion 8");
		Account[] accs = { account1, account2, account3, account4 };
		for (Account a : accs) {
			System.out.println(a.email);
			System.out.println(a.fullName);
			System.out.println(a.department.departmentName);
			System.out.println();
		}

		// Question 9
		System.out.println("\nQuestion 9");
		Department[] deps = { sales, marketing, hr, it };
		for (Department d : deps) {
			System.out.println(d.departmentId);
			System.out.println(d.departmentName);
			System.out.println();
		}

		// Question 10
		System.out.println("\nQuestion 10");
		for (int i = 0; i < accs.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accs[i].email);
			System.out.println("Full name: " + accs[i].fullName);
			System.out.println("Phòng ban: " + accs[i].department.departmentName);
			System.out.println();
		}

		// Question 11
		System.out.println("\nQuestion 11");
		for (int i = 0; i < deps.length; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + deps[i].departmentId);
			System.out.println("Name: " + deps[i].departmentName);
			System.out.println();
		}

		// Question 12
		System.out.println("\nQuestion 12");
		for (int i = 0; i < deps.length; i++) {
			if (i < 2) {
				System.out.println("Thông tin department thứ " + (i + 1) + " là:");
				System.out.println("Id: " + deps[i].departmentId);
				System.out.println("Name: " + deps[i].departmentName);
				System.out.println();
			}
		}

		// Question 13
		System.out.println("\nQuestion 13");
		for (int i = 0; i < accs.length; i++) {
			if (i != 1) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accs[i].email);
				System.out.println("Full name: " + accs[i].fullName);
				System.out.println("Phòng ban: " + accs[i].department.departmentName);
				System.out.println();
			}
		}

		// Question 14
		System.out.println("\nQuestion 14");
		for (int i = 0; i < accs.length; i++) {
			if (accs[i].accountId < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accs[i].email);
				System.out.println("Full name: " + accs[i].fullName);
				System.out.println("Phòng ban: " + accs[i].department.departmentName);
				System.out.println();
			}
		}

		// Question 15
		System.out.println("\nQuestion 15");
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}

		// Question 16
		System.out.println("\nQuestion 16");

		System.out.println("\nQuestion 16.10");
		int i = 0;
		while (i < accs.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accs[i].email);
			System.out.println("Full name: " + accs[i].fullName);
			System.out.println("Phòng ban:" + accs[i].department.departmentName);
			System.out.println();
			i++;
		}

		// -----------------------------
		System.out.println("\nQuestion 16.11");
		i = 0;
		while (i < deps.length) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + deps[i].departmentId);
			System.out.println("Name: " + deps[i].departmentName);
			System.out.println();
			i++;
		}

		// -----------------------------
		System.out.println("\nQuestion 16.12");
		i = 0;
		while (i < deps.length) {
			if (i == 2) {
				break;
			}
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + deps[i].departmentId);
			System.out.println("Name: " + deps[i].departmentName);
			System.out.println();
			i++;
		}

		// -----------------------------
		System.out.println("\nQuestion 16.13");
		i = 0;
		while (i < accs.length) {
			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accs[i].email);
			System.out.println("Full name: " + accs[i].fullName);
			System.out.println("Phòng ban:" + accs[i].department.departmentName);
			System.out.println();
			i++;
		}

		// -----------------------------
		System.out.println("\nQuestion 16.14");
		i = 0;
		while (i < accs.length) {
			if (accs[i].accountId < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accs[i].email);
				System.out.println("Full name: " + accs[i].fullName);
				System.out.println("Phòng ban:" + accs[i].department.departmentName);
				System.out.println();
			}
			i++;
		}

		// -----------------------------
		System.out.println("\nQuestion 16.15");
		i = 1;
		while (i <= 20) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}

		// Question 17
		System.out.println("\nQuestion 17");

		System.out.println("\nQuestion 17.10");
		i = 0;
		do {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accs[i].email);
			System.out.println("Full name: " + accs[i].fullName);
			System.out.println("Phòng ban:" + accs[i].department.departmentName);
			System.out.println();
			i++;
		} while (i < accs.length);

		// -----------------------------
		System.out.println("\nQuestion 17.11");
		i = 0;
		do {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + deps[i].departmentId);
			System.out.println("Name: " + deps[i].departmentName);
			System.out.println();
			i++;
		} while (i < deps.length);

		// -----------------------------
		System.out.println("\nQuestion 17.12");
		i = 0;
		do {
			if (i == 2) {
				break;
			}
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + deps[i].departmentId);
			System.out.println("Name: " + deps[i].departmentName);
			System.out.println();
			i++;
		} while (i < deps.length);

		// -----------------------------
		System.out.println("\nQuestion 17.13");
		i = 0;
		do {
			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accs[i].email);
			System.out.println("Full name: " + accs[i].fullName);
			System.out.println("Phòng ban:" + accs[i].department.departmentName);
			System.out.println();
			i++;
		} while (i < accs.length);

		// -----------------------------
		System.out.println("\nQuestion 17.14");
		i = 0;
		do {
			if (accs[i].accountId < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accs[i].email);
				System.out.println("Full name: " + accs[i].fullName);
				System.out.println("Phòng ban:" + accs[i].department.departmentName);
				System.out.println();
			}
			i++;
		} while (i < accs.length);

		// -----------------------------
		System.out.println("\nQuestion 17.15");
		i = 1;
		do {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		} while (i <= 20);

		/* -------------------- Exercise 2: ------------------- */

		// Question 1

	}

}
