package com.tnl.backend;

import java.util.*;

public class DataInitialization {
	
	public static void InitializeData() {
		// Create Departments
        Department sales = new Department(1, "Sales");
        Department marketing = new Department(2, "Marketing");

        // Create Positions
        Position dev = new Position(1, "Dev");
        Position test = new Position(2, "Test");
        Position scrumMaster = new Position(3, "Scrum Master");
        Position pm = new Position(4, "PM");

        // Create Accounts
        Account account1 = new Account(1, "john.doe@example.com", "john_doe", "John Doe", sales, dev, new Date());
        Account account2 = new Account(2, "jane.smith@example.com", "jane_smith", "Jane Smith", marketing, pm, new Date());

        // Create Groups
        Group group1 = new Group(1, "Team A", account1, new Date());

        // Create GroupAccounts
        GroupAccount groupAccount1 = new GroupAccount(group1, account1, new Date());
        GroupAccount groupAccount2 = new GroupAccount(group1, account2, new Date());

        // Create TypeQuestions
        TypeQuestion essay = new TypeQuestion(1, "Essay");
        TypeQuestion multipleChoice = new TypeQuestion(2, "Multiple-Choice");

        // Create CategoryQuestions
        CategoryQuestion java = new CategoryQuestion(1, "Java");
        CategoryQuestion sql = new CategoryQuestion(2, "SQL");

        // Create Questions
        Question question1 = new Question(1, "What is Java?", java, essay, account1.getAccountId(), new Date());
        Question question2 = new Question(2, "What is SQL?", sql, multipleChoice, account2.getAccountId(), new Date());

        // Create Answers
        Answer answer1 = new Answer(1, "Java is a programming language.", question1, true);
        Answer answer2 = new Answer(2, "SQL is a database query language.", question2, true);

        // Create Exams
        Exam exam1 = new Exam(1, 101, "Java Basics", java.getCategoryId(), 60, account1, new Date());

        // Create ExamQuestions
        ExamQuestion examQuestion1 = new ExamQuestion(exam1, question1);
        
     // Display some data to verify the structure
        System.out.println("Account 1: " + account1.getFullName() + ", Department: " + account1.getDepartment().getDepartmentName());
        System.out.println("Account 2: " + account2.getFullName() + ", Department: " + account2.getDepartment().getDepartmentName());
        System.out.println("Group 1: " + group1.getGroupName() + ", Created by: " + group1.getCreator().getFullName());
        System.out.println("Question 1: " + question1.getContent() + ", Created by: Account " + question1.getCreatorId());
        System.out.println("Answer 1: " + answer1.getContent() + ", Is Correct: " + answer1.isCorrect());
        System.out.println("Exam 1: " + exam1.getTitle() + ", Duration: " + exam1.getDuration() + " minutes");
   
	}
}
