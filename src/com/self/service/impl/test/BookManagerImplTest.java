package com.self.service.impl.test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import com.self.exception.DuplicateIsbnException;
import com.self.exception.InvalidDateException;
import com.self.exception.RecordNotFoundException;
import com.self.service.impl.BookManagerImpl;
import com.self.util.MyDate;
import com.self.vo.Book;
import com.self.vo.Magazine;
import com.self.vo.Novel;

public class BookManagerImplTest {

	public static void main(String[] args) {
		BookManagerImpl service = BookManagerImpl.getInstance();
		
		try {

			service.insertBook(new Magazine(111, "TIME", "Cheny", "ChenPublisher", 10000.0, new MyDate(2025, 01, 01)));
			service.insertBook(new Magazine(333, "VOGUE", "마이메로", "yeony", 20000.0, new MyDate(2024, 02, 02)));
			service.insertBook(new Magazine(555, "National Geographic", "cheche", "ChenPublisher", 30000.0, new MyDate(2025, 03, 03)));
			service.insertBook(new Magazine(444, "Sanrio", "ChenKwak", "ChenPublisher", 15000.0, new MyDate(2025, 04, 04)));
			service.insertBook(new Novel(222, "로맨스 대표작", "바쿠", "GoodPublisher", 12000.0, "로맨스"));
			service.insertBook(new Novel(999, "쿠로미인생", "쿠로미", "GoodPublisher", 22000.0, "코믹"));
			service.insertBook(new Novel(888, "부탁해! 마이멜로디", "시나모롤", "GoodPublisher", 29000.0, "스릴러"));
			service.insertBook(new Novel(666, "포챠코시나모롤", "포챠코", "TestPblisher", 19000.0, "액션"));
		}catch (DuplicateIsbnException de) {
			System.out.println(de.getMessage());
		}
			
			// 1. 책 추가 및 전체 검색
			System.out.println("==== 책 추가 및 전체 검색 ====");
			
			try {
				HashMap<Integer,Book> books = service.getAllBook();
				ArrayList<Book> booksArrayList = new ArrayList<>(books.values());
				booksArrayList.sort(new Comparator<Book>() {			
					@Override
					public int compare(Book b1, Book b2) {
						return b1.getIsbn() - b2.getIsbn();
					}
				});
				
				for (Book b : booksArrayList) {
					System.out.println(b);
				}
				
				System.out.println();
				
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				
			}
			
		
			
			// 2. 책 삭제
			System.out.println("==== 책 삭제 : 666 ====");
			service.deleteBook(666);
			for (Book b : service.getAllBook().values()) {
				System.out.println(b);
			}
			
			System.out.println();
			
			// 3. 책 수정
			System.out.println("==== 책 수정 ====");
			service.updateBook(new Novel(777, "사라진 목격자", "박현수", "스릴러 하우스", 18000.0, "스릴러"));
			service.updateBook(new Magazine(888, "오늘의 요리", "박지현 셰프", "맛있는 책방", 8800.0, new MyDate(2025, 7, 7)));
			for (Book b : service.getAllBook().values()) {
				System.out.println(b);
			}
			
			System.out.println();
			
			// 4. 책 검색(isbn)
			System.out.println("==== 책 검색(isbn): 444 ====");
			System.out.println(service.getBook(444).toString()); 
			
			System.out.println();
			
			// 5. 전체 책 수량
			System.out.println("==== 전체 책 수량 ====");
			System.out.println(service.getNumberOfBooks() + "권"); 
			
			System.out.println();
			
			// 6. 책 검색(제목)
			System.out.println("==== 책 검색(제목) : 밤의 도서관 ====");
//			for (Book b : service.searchBookByTitle("밤의 도서관").values())
			//	System.out.println(b);
			
			System.out.println();
			
			// 7. 책 가격대
			System.out.println("==== 책 가격대 : 15000원에서 20000원 사이 ====");
					
			for (Book b : service.searchBookByPrice(15000, 20000).values()) {
				System.out.println(b);
			}

			System.out.println();

			// 8. 전체 책 가격 합
			System.out.println("==== 전체 책 가격 합 ====");
			System.out.println(service.getSumPriceOfBooks() + "원"); 
					
			System.out.println();
		
			// 9. 전체 책 가격 평균
			System.out.println("==== 전체 책 가격 평균 ====");
			System.out.println(service.getAvgPriceOfBooks() + "원"); 
					
			System.out.println();
			
			System.out.println("==== 올해 책 정렬 ====");
				
			ArrayList<Magazine> yearsArrayList = new ArrayList<>(service.magazineOfThisYearInfo(2025).values());
			
			yearsArrayList.sort(new Comparator<Magazine>() {			
				@Override
				public int compare(Magazine m1, Magazine m2) {
					return m2.getPublishingMonth() - m1.getPublishingMonth();
				}
			});
			
			for (Book m : yearsArrayList) {
				System.out.println(m);
			}
			
			System.out.println();

		} 
		
		
//		catch (DuplicateIsbnException de) {
//			System.out.println(de.getMessage());
//		} catch (RecordNotFoundException re) {
//			System.out.println(re.getMessage());
//		} catch (InvalidDateException ie) {
//			System.out.println(ie.getMessage());
//		}
	}

}
