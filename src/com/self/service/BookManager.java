package com.self.service;

import java.util.ArrayList;
import java.util.HashMap;
import com.self.vo.Book;

public interface BookManager {
	void insertBook(Book book);
	void deleteBook(int isbn);
	void updateBook(Book book);
	Book getBook(int isbn);
	HashMap<Integer, Book> getAllBook();
	int getNumberOfBooks();
	HashMap<Integer, Book> searchBookByTitle(String title);
	HashMap<Integer, Book>searchBookByPrice(int min, int max);
	double getSumPriceOfBooks();
	double getAvgPriceOfBooks();	
	HashMap<Integer, Book> magazineOfThisYearInfo(int year);
}
