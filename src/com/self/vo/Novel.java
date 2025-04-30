package com.self.vo;

public class Novel extends Book {
	
	private String genre;
	
	public Novel(int isbn, String title, String author, 
				 String publisher, double price,String genre) {
		super(isbn, title, author, publisher, price);
		this.genre = genre;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void changeGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return super.toString() + "Novel [장르 : " + genre + "]";
	}
	
	
}
