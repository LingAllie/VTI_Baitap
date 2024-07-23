package com.tnl.backend;

public class ExamQuestion {
     Exam exam;
     Question question;
     
     public ExamQuestion () {}
     
     public ExamQuestion (Exam exam, Question question) {
    	 this.exam = exam;
    	 this.question = question;
     }
  
}
