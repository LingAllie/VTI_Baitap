package com.tnl.backend;

import java.util.Date;

import com.tnl.backend.Main.Position;

public class DataInitialization {

    public static void initializeData() {
	        // Create Departments
	        Department sales = new Department(1, "Sales");
	        Department marketing = new Department(2, "Marketing");
	        Department hr = new Department(3, "HR");
	        Department it = new Department(4, "IT");
	
//	        // Create Positions
//	        Position dev = new Position(1, "Dev");
//	        Position test = new Position(2, "Test");
//	        Position scrumMaster = new Position(3, "Scrum Master");
//	        Position pm = new Position(4, "PM");
//
//    

     		// Create Accounts
     		Account[] accounts = {
     				new Account(1, "john.doe@example.com", "john_doe", "John Doe", sales, Position.Dev, new Date()),
     				new Account(2, "jane.smith@example.com", "jane_smith", "Jane Smith", marketing, Position.PM, new Date()),
     				new Account(3, "alice.brown@example.com", "alice_brown", "Alice Brown", hr, Position.Test, new Date()),
     				new Account(4, "bob.johnson@example.com", "bob_johnson", "Bob Johnson", it, Position.ScrumMaster, new Date())
     		};
     		
     		// Create Groups
     		Group[] groups = {
     	            new Group(1, "Team A", accounts[0], new Date()),
     	            new Group(2, "Team B", accounts[1], new Date()),
     	            new Group(3, "Team C", accounts[2], new Date()),
     	            new Group(4, "Team D", accounts[3], new Date())
     	        };

     		// Create GroupAccounts

     		GroupAccount[] groupAccount1 = {
     				new GroupAccount(groups[0], accounts[0], new Date()),
                     new GroupAccount(groups[0], accounts[1], new Date()) };

     		GroupAccount[] groupAccount2 = { 
     				new GroupAccount(groups[1], accounts[0], new Date()),
                     new GroupAccount(groups[1], accounts[1], new Date()),
                     new GroupAccount(groups[1], accounts[2], new Date()),
                     new GroupAccount(groups[1], accounts[3], new Date())
                 };

     		GroupAccount[] groupAccount3 = { 
     				new GroupAccount(groups[2], accounts[1], new Date()),
                     new GroupAccount(groups[2], accounts[2], new Date()),
                     new GroupAccount(groups[2], accounts[3], new Date())
                 };

     		GroupAccount[] groupAccount4 = { new GroupAccount(groups[3], accounts[3], new Date())};

     		// Create TypeQuestions
     		TypeQuestion essay = new TypeQuestion(1, "Essay");
     		TypeQuestion multipleChoice = new TypeQuestion(2, "Multiple-Choice");

     		// Create CategoryQuestions
     		CategoryQuestion java = new CategoryQuestion(1, "Java");
     		CategoryQuestion sql = new CategoryQuestion(2, "SQL");
     		CategoryQuestion net = new CategoryQuestion(3, ".NET");
     		CategoryQuestion python = new CategoryQuestion(4, "Python");

     		// Create Questions
     		Question question1 = new Question(1, "What is Java?", java, essay, accounts[0].accountId, new Date());
     		Question question2 = new Question(2, "What is SQL?", sql, multipleChoice, accounts[1].accountId, new Date());
     		Question question3 = new Question(3, "Explain polymorphism in Java.", java, essay, accounts[0].accountId,
     				new Date());
     		Question question4 = new Question(4, "What are the benefits of using Python?", python, multipleChoice,
     				accounts[3].accountId, new Date());

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
     		Exam exam1 = new Exam(1, 101, "Java Basics", java.categoryId, 60, accounts[0], new Date());
     		Exam exam2 = new Exam(2, 102, "Python Introduction", python.categoryId, 45, accounts[3], new Date());

     		// Create ExamQuestions
     		ExamQuestion examQuestion1 = new ExamQuestion(exam1, question1);
     		ExamQuestion examQuestion2 = new ExamQuestion(exam1, question3);
     		ExamQuestion examQuestion3 = new ExamQuestion(exam2, question4);

}
