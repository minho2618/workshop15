package com.self.service.impl;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

import com.self.service.BookManager;
import com.self.vo.Book;
import com.self.vo.Magazine;

public class BookManagerImpl implements BookManager {
	
	HashMap<Integer,java.awt.print.Book> books = null;

	private static BookManagerImpl service = new BookManagerImpl();

	private BookManagerImpl() {
		books = new HashMap<>();
	}

	public static BookManagerImpl getInstance() {
		return service;
	}


	@Override
	public void insertBook(Book book) {

		if(books.containsKey(book.getIsbn())){
			System.out.println("이미 존재하는 책입니다");
			//DuplicateIsbnException
		}else {
			books.put(book.getIsbn(), book);
		}
		
	}

	@Override
	public void deleteBook(int isbn) {
		if(books.containsKey(isbn)) {
			books.remove(isbn);
		}else {
			System.out.println("해당 책이 없습니다.");
			//RecordNotFoundException
		}
		
	}

	
	@Override
	public void updateBook(Book book) {
		
		if(books.containsKey(book.getIsbn())) {
			books.replace(book.getIsbn(), book);
		}else {
			//에러 처리
		}
	}

	@Override
	public Book getBook(int isbn) {
		if(books.containsKey(isbn)) {
			return books.get(isbn);
		}else {
			//에러처리
			return null;
		}
	}

	//test 필요 
	@Override
	public HashMap<Integer,Book> getAllBook() {		
		//책이 존재하지 않을 때 에러처리-> getBook에러와 같음
		return books;
	}

	@Override
	public int getNumberOfBooks() {
		//책의 총 수량 
		// 에러처리 불필요
		return books.size();
	}

	@Override
	public HashMap<Integer,Book> searchBookByTitle(String title) {
		HashMap<Integer, java.awt.print.Book> tempMap = new HashMap<>();
		for(Book b : books.values()) {
			if(b.getTitle().equals(title)) {
				tempMap.put(b.getIsbn(), b);
			}
			
		}
		
		//존재하지않을때 오류 에러처리
		return tempMap;
	}

	@Override
	public HashMap<Integer,Book> searchBookByPrice(int min, int max) {
		HashMap<Integer, java.awt.print.Book> tempMap = new HashMap<>();
		for(Book b : books.values()) {
			if(b.getPrice() >= min && b.getPrice() <= max) {
				tempMap.put(b.getIsbn(), b);
			}
			
		}
		
		//존재하지않을때 오류 에러처리
		return tempMap;
	}

	@Override
	public double getSumPriceOfBooks() {
		double sum = 0;
		for(Book b : books.values()) {
			sum += b.getPrice();
		}
		//에러처리 필요 없음
		return sum;
	}

	@Override
	public double getAvgPriceOfBooks() {
		return getSumPriceOfBooks() / books.size();
	}

	@Override
	public HashMap<Integer, Book> magazineOfThisYearInfo(int year) {
		HashMap<Integer, Book> tempMap = new HashMap<>();
		
		for (Book b : books.values()) {
			if (b instanceof Magazine && ((Magazine)b).getPublishDate().getYear() == year) {
				tempMap.put(b.getIsbn(),b);
			}
		}
		
		return tempMap;
	}

}
