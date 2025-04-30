package com.self.vo;

public class Book {

	private int isbn;
	private String title;
	private String author;
	private String publisher;
	private double price;
	
	public Book(int isbn, String title, String author, String publisher, double price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	public int getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void changeTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void changeAuthor(String author) {
		this.author = author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void changePublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void changePrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book 정보 [isbn=" + isbn + ", 제목 : " + title + ", 작가 : " + author 
				+ ", 출판사 : " + publisher + ", 가격 : " + price + "]";
	}
	
	
}
