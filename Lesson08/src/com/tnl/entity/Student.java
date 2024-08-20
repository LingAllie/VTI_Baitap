package com.tnl.entity;

public class Student implements Comparable<Student>{

	private int id, age, score;
	private String name;
	
	public Student() {}

	public Student(int id, int age, int score, String name) {
		this.id = id;
		this.age = age;
		this.score = score;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", score=" + score + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Student o) {
//		return o.age - this.age; //sap xep giam dan theo age
//		return this.id - o.id; //sap xep tang dan theo id
		return this.score - o.score;//sap xep tang dan theo score
	}
	
	
	
}
