package com.tnl.entity;

import com.tnl.backend.INews;

public class News implements INews{

	private int id;
	private String title, publishDate, author, content;
	private float averageRate;
	
	public News() {}
	
	public News(int id, String title, String publishDate, String author, String content, float averageRate) {
		super();
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
		this.averageRate = averageRate;
	}
	
	public News(String title, String publishDate, String author, String content) {
		super();
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getAverageRate() {
		return averageRate;
	}
	
	
	@Override
	public void Display() {
		System.out.println("\n\nNews: " + this.getId() +
							"\nTitle: " + this.getTitle() + 
							"\nPublish date: " + this.getPublishDate() + 
							"\nAuthor: " + this.getAuthor() +
							"\nContent: " + this.getContent() +
							"\nAverage rate: " + this.getAverageRate() +
							"\n\n");
		
	}
	@Override
	public float Calculate(int[] rates) {
		int sum = 0;
		for(int n: rates ) {
			sum += n;
		}
		this.averageRate = (float)(sum/rates.length);
		return this.averageRate;
	}
	
	
}
