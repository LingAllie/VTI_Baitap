package com.tnl.backend;
import java.util.*;
public class Question {
	int questionId;
	String content;
	CategoryQuestion categoryQuestion;
	TypeQuestion typeQuestion;
	int creatorId;
	Date createDate;
	
	public Question () {}

	public Question(int questionId, String content, CategoryQuestion categoryQuestion, TypeQuestion typeQuestion,
			int creatorId, Date createDate) {
		
		this.questionId = questionId;
		this.content = content;
		this.categoryQuestion = categoryQuestion;
		this.typeQuestion = typeQuestion;
		this.creatorId = creatorId;
		this.createDate = createDate;
	}

}
