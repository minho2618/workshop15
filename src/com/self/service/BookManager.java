package com.self.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.self.exception.DuplicateIsbnException;
import com.self.exception.InvalidDateException;
import com.self.exception.RecordNotFoundException;
import com.self.vo.Book;
import com.self.vo.Magazine;

public interface BookManager {
	void insertBook(Book book) throws DuplicateIsbnException;
	void deleteBook(int isbn) throws RecordNotFoundException;
	void updateBook(Book book) throws RecordNotFoundException;
	Book getBook(int isbn) throws RecordNotFoundException;
	HashMap<Integer, Book> getAllBook() throws RecordNotFoundException;
	int getNumberOfBooks();
	HashMap<Integer, Book> searchBookByTitle(String title) throws RecordNotFoundException;
	HashMap<Integer, Book> searchBookByPrice(int min, int max) throws RecordNotFoundException;
	double getSumPriceOfBooks();
	double getAvgPriceOfBooks();	
	HashMap<Integer, Magazine> magazineOfThisYearInfo(int year) throws InvalidDateException;
}
