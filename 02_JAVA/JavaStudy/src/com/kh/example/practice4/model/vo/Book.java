package com.kh.example.practice4.model.vo;

public class Book {
	String title;
	String publisher;
	String author;
	int price;
	double discountRate;
	public Book() {
		super();
	}
	
	public Book(String title, String publisher, String author) {
		this.title = title;
		this.publisher = publisher;
		this.author = author;
	}
	
	public Book(String title, String publisher, String author, int price, double discountRate) {
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.discountRate = discountRate;
	}
	
	public void inform() {
		System.out.println(this.title+ " "+this.publisher+ " "+this.author+ " "+this.price+ " "+this.discountRate);
	}
	public double discountRate(double rate) {
		return discountRate++;
	}
		
}
