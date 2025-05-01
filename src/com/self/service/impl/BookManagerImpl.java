package com.self.service.impl;

import java.util.HashMap;

import com.self.exception.DuplicateIsbnException;
import com.self.exception.InvalidDateException;
import com.self.exception.RecordNotFoundException;
import com.self.service.BookManager;
import com.self.vo.Book;
import com.self.vo.Magazine;

public class BookManagerImpl implements BookManager {

	HashMap<Integer, Book> books = null;

	private static BookManagerImpl service = new BookManagerImpl();

	private BookManagerImpl() {
		books = new HashMap<>();
	}

	public static BookManagerImpl getInstance() {
		return service;
	}

	@Override
	public void insertBook(Book book) throws DuplicateIsbnException {

		if (books.containsKey(book.getIsbn())) {
			throw new DuplicateIsbnException("이미 존재하는 책입니다.");
		} else {
			books.put(book.getIsbn(), book);
		}

	}

	@Override
	public void deleteBook(int isbn) throws RecordNotFoundException {
		if (books.containsKey(isbn)) {
			books.remove(isbn);
		} else {
			System.out.println("해당 책이 없습니다.");
			throw new RecordNotFoundException("해당 책이 없습니다.");
		}

	}

	@Override
	public void updateBook(Book book) throws RecordNotFoundException {

		if (books.containsKey(book.getIsbn())) {
			books.replace(book.getIsbn(), book);
		} else {
			throw new RecordNotFoundException("해당 책이 없습니다.");
		}
	}

	@Override
	public Book getBook(int isbn) throws RecordNotFoundException {
		if (books.containsKey(isbn)) {
			return books.get(isbn);
		} else {
			throw new RecordNotFoundException("해당 책이 없습니다.");
		}
	}

	// test 필요
	@Override
	public HashMap<Integer, Book> getAllBook( ) throws RecordNotFoundException {
		// 책이 존재하지 않을 때 에러처리-> getBook에러와 같음
		if (books.isEmpty())
			throw new RecordNotFoundException("책이 없습니다.");

		return books;
	}

	@Override
	public int getNumberOfBooks() {
		// 책의 총 수량
		// 에러처리 불필요
		return books.size();
	}

	@Override
	public HashMap<Integer, Book> searchBookByTitle(String title) throws RecordNotFoundException {
		HashMap<Integer, Book> tempMap = new HashMap<>();
		
		for (Book b : books.values()) {
			if (b.getTitle().equals(title)) {
				tempMap.put(b.getIsbn(), b);
			}
			
		}
		
		if (tempMap.isEmpty()) throw new RecordNotFoundException("검색하려는 책이 없습니다.");

		// 존재하지않을때 오류 에러처리
		return tempMap;
	}

	@Override
	public HashMap<Integer, Book> searchBookByPrice(int min, int max) throws RecordNotFoundException {
		HashMap<Integer, Book> tempMap = new HashMap<>();
		for (Book b : books.values()) {
			if (b.getPrice() >= min && b.getPrice() <= max) {
				tempMap.put(b.getIsbn(), b);
			}

		}
		
		if (tempMap.isEmpty()) throw new RecordNotFoundException("검색하려는 책이 없습니다.");

		// 존재하지않을때 오류 에러처리
		return tempMap;
	}

	@Override
	public double getSumPriceOfBooks() {
		double sum = 0;
		for (Book b : books.values()) {
			sum += b.getPrice();
		}
		// 에러처리 필요 없음
		return sum;
	}

	@Override
	public double getAvgPriceOfBooks() {
		return getSumPriceOfBooks() / books.size();
	}

	@Override
	public HashMap<Integer, Magazine> magazineOfThisYearInfo(int year) throws InvalidDateException {
		HashMap<Integer, Magazine> tempMap = new HashMap<>();
		
		if (year > 2025) throw new InvalidDateException("존재하지 않는 년도입니다.");

		for (Book b : books.values()) {
			if (b instanceof Magazine && ((Magazine) b).getPublishDate().getYear() == year) {
				tempMap.put(b.getIsbn(), (Magazine) b);
			}
		}

		return tempMap;
	}

}
