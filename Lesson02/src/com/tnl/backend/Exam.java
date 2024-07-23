package com.tnl.backend;

import java.util.*;

public class Exam {
	int examId;
	int code;
	String title;
	int categoryId;
	int duration;
	Account creatorExam;
	Date creatDate;
	
	public Exam () {}
	
	public Exam(int examId, int code, String title, int categoryId, int duration, Account creatorExam, Date creatDate) {
		
		this.examId = examId;
		this.code = code;
		this.title = title;
		this.categoryId = categoryId;
		this.duration = duration;
		this.creatorExam = creatorExam;
		this.creatDate = creatDate;
	}
	
}
