package com.self.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.self.exception.DuplicateIsbnException;
import com.self.exception.InvalidDateException;
import com.self.exception.RecordNotFountException;
import com.self.vo.Book;
import com.self.vo.Magazine;

public interface BookManager {
	void insertBook(Book book) throws DuplicateIsbnException;
	void deleteBook(int isbn) throws RecordNotFountException;
	void updateBook(Book book) throws RecordNotFountException;
	Book getBook(int isbn) throws RecordNotFountException;
	HashMap<Integer, Book> getAllBook() throws RecordNotFountException;
	int getNumberOfBooks();
	HashMap<Integer, Book> searchBookByTitle(String title) throws RecordNotFountException;
	HashMap<Integer, Book> searchBookByPrice(int min, int max) throws RecordNotFountException;
	double getSumPriceOfBooks();
	double getAvgPriceOfBooks();	
	HashMap<Integer, Book> magazineOfThisYearInfo(int year) throws InvalidDateException;
}
