package com.self.service;

import java.util.ArrayList;

import com.self.vo.Book;
import com.self.vo.Magazine;

public interface BookManager {
	void insertBook(Book book);
	void deleteBook(int isbn);
	void updateBook(Book book);
	Book getBook(int isbn);
	ArrayList<Book> getAllBook();
	int getNumberOfBooks();
	ArrayList<Book> searchBookByTitle(String title);
	ArrayList<Book> searchBookByPrice(int min, int max);
	double getSumPriceOfBooks();
	double getAvgPriceOfBooks();	
	
	ArrayList<Magazine> magazineOfThisYearInfo(int year);
}
