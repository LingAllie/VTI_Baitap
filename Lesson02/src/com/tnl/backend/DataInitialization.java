package com.tnl.backend;

import java.util.Date;

public class DataInitialization {

    public static void initializeData() {
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
        Account account2 = new Account(2, "jane.smith@example.com", "jane_smith", "Jane Smith", null, pm, new Date());
        Account account3 = new Account(3, "alice.brown@example.com", "alice_brown", "Alice Brown", hr, test, new Date());
        Account account4 = new Account(4, "bob.johnson@example.com", "bob_johnson", "Bob Johnson", it, scrumMaster, new Date());

        // Create Groups
        Group group1 = new Group(1, "Team A", account1, new Date());
        Group group2 = new Group(2, "Team B", account2, new Date());

        // Create GroupAccounts
        GroupAccount groupAccount1 = new GroupAccount(group1, account1, new Date());
        GroupAccount groupAccount2 = new GroupAccount(group1, account2, new Date());
        GroupAccount groupAccount3 = new GroupAccount(group2, account3, new Date());
        GroupAccount groupAccount4 = new GroupAccount(group2, account4, new Date());

        // Create TypeQuestions
        TypeQuestion essay = new TypeQuestion(1, "Essay");
        TypeQuestion multipleChoice = new TypeQuestion(2, "Multiple-Choice");

        // Create CategoryQuestions
        CategoryQuestion java = new CategoryQuestion(1, "Java");
        CategoryQuestion sql = new CategoryQuestion(2, "SQL");
        CategoryQuestion net = new CategoryQuestion(3, ".NET");
        CategoryQuestion python = new CategoryQuestion(4, "Python");

        // Create Questions
        Question question1 = new Question(1, "What is Java?", java, essay, account1.getAccountId(), new Date());
        Question question2 = new Question(2, "What is SQL?", sql, multipleChoice, account2.getAccountId(), new Date());
        Question question3 = new Question(3, "Explain polymorphism in Java.", java, essay, account1.getAccountId(), new Date());
        Question question4 = new Question(4, "What are the benefits of using Python?", python, multipleChoice, account4.getAccountId(), new Date());

        // Create Answers for Essay Questions
        Answer answer1 = new Answer(1, "Java is a programming language.", question1, true);
        Answer answer3 = new Answer(3, "Polymorphism allows methods to do different things based on the object it is acting upon.", question3, true);

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
        Exam exam1 = new Exam(1, 101, "Java Basics", java.getCategoryId(), 60, account1, new Date());
        Exam exam2 = new Exam(2, 102, "Python Introduction", python.getCategoryId(), 45, account4, new Date());

        // Create ExamQuestions
        ExamQuestion examQuestion1 = new ExamQuestion(exam1, question1);
        ExamQuestion examQuestion2 = new ExamQuestion(exam1, question3);
        ExamQuestion examQuestion3 = new ExamQuestion(exam2, question4);

        // Display some data to verify the structure
        System.out.println("Account 1: " + account1.getFullName() + ", Department: " + account1.getDepartment().getDepartmentName());
        System.out.println("Account 2: " + account2.getFullName() + ", Department: " + account2.getDepartment().getDepartmentName());
        System.out.println("Account 3: " + account3.getFullName() + ", Department: " + account3.getDepartment().getDepartmentName());
        System.out.println("Account 4: " + account4.getFullName() + ", Department: " + account4.getDepartment().getDepartmentName());

        System.out.println("Group 1: " + group1.getGroupName() + ", Created by: " + group1.getCreator().getFullName());
        System.out.println("Group 2: " + group2.getGroupName() + ", Created by: " + group2.getCreator().getFullName());

        System.out.println("Question 1: " + question1.getContent() + ", Created by: Account " + question1.getCreatorId());
        System.out.println("Answer 1: " + answer1.getContent() + ", Is Correct: " + answer1.isCorrect());
        System.out.println("Question 2: " + question2.getContent() + ", Answers: ");
        System.out.println("    Answer: " + answer2_1.getContent() + ", Is Correct: " + answer2_1.isCorrect());
        System.out.println("    Answer: " + answer2_2.getContent() + ", Is Correct: " + answer2_2.isCorrect());
        System.out.println("    Answer: " + answer2_3.getContent() + ", Is Correct: " + answer2_3.isCorrect());
        System.out.println("    Answer: " + answer2_4.getContent() + ", Is Correct: " + answer2_4.isCorrect());
        System.out.println("Exam 1: " + exam1.getTitle() + ", Duration: " + exam1.getDuration() + " minutes");
    }
}
