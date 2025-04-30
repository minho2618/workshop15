package com.self.service.impl;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

import com.self.service.BookManager;
import com.self.vo.Book;
import com.self.vo.Magazine;

public class BookManagerImpl implements BookManager {
	//Vector v = new Vector();
	
	ArrayList<Book> books = null;
	//public static final int MAX_SIZE = 100;

	private static BookManagerImpl service = new BookManagerImpl();

	private BookManagerImpl() {
		books = new ArrayList<>();
	}

	public static BookManagerImpl getInstance() {
		return service;
	}


	@Override
	public void insertBook(Book book) {
		boolean find = false;
		
		for (Book b : books) {
			if (b.getIsbn() == book.getIsbn()) {
				find = true;
				System.out.println("이미 등록되어진 책입니다.");				
				return;
			}
		}
		
		if (!find) {			
			books.add(book);
			System.out.println(book.getTitle() +"이 등록되었습니다 ");
		}
		
	}

	@Override
	public void deleteBook(int isbn) {
		boolean find = false;
		
		for (Book b : books) {
			if (b.getIsbn() == isbn) {
				find = true;
				break;
			}
		}
		
		if (!find) {
			System.out.println("해당하는 책이 존재하지 않습니다.");
			return;
		} else {
			for(int i=0; i<books.size(); i++) {
				if(books.get(i).getIsbn() == isbn) {
					System.out.println(books.remove(i)+"가 삭제되었습니다.");
					break;
				}
			}
		}
	}

	//test 필요
	@Override
	public void updateBook(Book book) {
		boolean find = false;
		
		for (Book b : books) {
			if (b.getIsbn() == book.getIsbn()) {
				find = true;
				break;
			}
		}
		
		if (!find) {
			System.out.println("해당하는 책이 존재하지 않습니다.");
			return;
		} else {
			for(int i=0; i<books.size(); i++) {
				if (books.get(i).getIsbn() == book.getIsbn()) {
					books.set(i, book);
				}
			}
		}	
		
	}

	@Override
	public Book getBook(int isbn) {
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getIsbn() == isbn) {
				return books.get(i);
			}
		}
		return null;
	}

	//test 필요 
	@Override
	public ArrayList<Book> getAllBook() {		
		return books;
	}

	@Override
	public int getNumberOfBooks() {
		//책의 총 수량 
		
		return books.size();
	}

	@Override
	public ArrayList<Book> searchBookByTitle(String title) {
		ArrayList<Book> tempArrayList = new ArrayList<>();
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getTitle().equals(title)) {
				tempArrayList.add(books.get(i));
			}
		}
		return tempArrayList;
	}

	@Override
	public ArrayList<Book> searchBookByPrice(int min, int max) {
		ArrayList<Book> tempArrayList = new ArrayList<>();
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getPrice() >= min && books.get(i).getPrice()<=max){
				tempArrayList.add(books.get(i));
			}
		}
		return tempArrayList;
	}

	@Override
	public double getSumPriceOfBooks() {
		double sum = 0;
		for(Book b : books) {
			sum += b.getPrice();
		}
		return sum;
	}

	@Override
	public double getAvgPriceOfBooks() {
		return getSumPriceOfBooks() / books.size();
	}

	@Override
	public ArrayList<Magazine> magazineOfThisYearInfo(int year) {
		ArrayList<Magazine> temp = new ArrayList<>();
		
		for (Book b : books) {
			if (b instanceof Magazine && ((Magazine)b).getPublishDate().getYear() == year) {
				temp.add((Magazine)b);
			}
		}
		
		return temp;
	}

}
