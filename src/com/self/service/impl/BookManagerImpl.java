package com.self.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

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

		if (books.containsKey(book.getIsbn()))
			throw new DuplicateIsbnException("이미 존재하는 책입니다.");
	
		books.put(book.getIsbn(), book);
		

	}

	@Override
	public void deleteBook(int isbn) throws RecordNotFoundException {
		if (!books.containsKey(isbn))
			throw new RecordNotFoundException("해당 책이 없습니다.");
		books.remove(isbn);
	}

	@Override
	public void updateBook(Book book) throws RecordNotFoundException {

		if (!books.containsKey(book.getIsbn()))
			throw new RecordNotFoundException("해당 책이 없습니다.");
			
		books.replace(book.getIsbn(), book);
	}

	@Override
	public Book getBook(int isbn) throws RecordNotFoundException {
		if (books.containsKey(isbn))
			throw new RecordNotFoundException("해당 책이 없습니다.");
		return books.get(isbn);
		
	}

	// test 필요
	@Override
	public ArrayList<Book> getAllBook( ) throws RecordNotFoundException {
		// 책이 존재하지 않을 때 에러처리-> getBook에러와 같음
		if (books.isEmpty())
			throw new RecordNotFoundException("책이 없습니다.");
		
		ArrayList<Book> tmpList = new ArrayList<Book>();
		Set<Integer> set = books.keySet();
		for (int n : set) {
			tmpList.add(books.get(n));
		}

		return tmpList;
	}

	@Override
	public int getNumberOfBooks() {
		// 책의 총 수량
		// 에러처리 불필요
		return books.size();
	}

	@Override
	public ArrayList<Book> searchBookByTitle(String title) throws RecordNotFoundException {
		ArrayList<Book> tempList = new ArrayList<>();
		Set<Integer> set = books.keySet();
		
		for (int n : set) {
			if (books.get(n).getTitle().equals(title)) {
				tempList.add(books.get(n));
			}			
		}
		
		if (tempList.isEmpty()) throw new RecordNotFoundException("검색하려는 책이 없습니다.");

		return tempList;
	}

	@Override
	public ArrayList<Book> searchBookByPrice(int min, int max) throws RecordNotFoundException {
		ArrayList<Book> tempList = new ArrayList<>();
		Set<Integer> set = books.keySet();
		
		for (int n : set) {
			if (books.get(n).getPrice() >= min && books.get(n).getPrice() <= max) {
				tempList.add(books.get(n));
			}
		}
		
		if (tempList.isEmpty()) throw new RecordNotFoundException("검색하려는 책이 없습니다.");

		return tempList;
	}

	@Override
	public double getSumPriceOfBooks() {
		double sum = 0;
		Set<Integer> set = books.keySet();
		
		for (int n : set) {
			sum += books.get(n).getPrice();
		}
		return sum;
	}

	@Override
	public double getAvgPriceOfBooks() {
		return getSumPriceOfBooks() / books.size();
	}

	@Override
	public ArrayList<Magazine> magazineOfThisYearInfo(int year) throws InvalidDateException {
		ArrayList<Magazine> tempList = new ArrayList<>();
		Set<Integer> set = books.keySet();
		
		if (year > 2025) throw new InvalidDateException("존재하지 않는 년도입니다.");

		for (int n : set) {
			if (books.get(n) instanceof Magazine && ((Magazine) books.get(n)).getPublishDate().getYear() == year) {
				tempList.add((Magazine) books.get(n));
			}
		}

		return tempList;
	}

}
