package com.self.vo;

import com.self.util.MyDate;

public class Magazine extends Book{
	
	/*
	 	기존 작성했던 UML에는 String 으로 month를 받아오기로 했으나 
	 	내가 서점을 지나가면서 보았던 매거진들은 항상 그 년도의 그 달의 최신 것만 진열되어 있었다.
	 	물론 관심이 없어서 그 전달 것도 있냐고 물어보지는 않았다.
	 	
	 	기존 생각했던 기능은 String으로 달을 입력하면 equals()를 통해 같은 월의 매거진들이 나오면 되겠지
	 	라는 생각으로 작성했으나 가현이가 이렇게 작성하면 이게 최신 연도의 월 것인지 작년의 것인지 구분은 어떻게 하냐 해서
	 	구조적 문제가 있다고 판단.
	 	
	 	(이야기를 나누지 못해서 혼자 생각하는 중)
	 	매거진의 연도를 검색하면 그 해에 출판된 책만 나오도록 하기.
	 	매거진의 월만 검색하면 연도를 올해랑 비교해서 올해 것만 나오도록 하기.
	 */
	
	private MyDate date;
	private int publishingYear;
	private int publishingMonth;
	
	public Magazine(int isbn, String title, String author, String publisher, double price
					, MyDate date) {
		super(isbn, title, author, publisher, price);
		this.date = date;
	}
	
	public MyDate getPublishDate() {
		return date;
	}
	
	public void changePublishDate(MyDate date) {
		this.date = date;
	}
	
	/*
	 	Publishing Date는 해당 클래스에서 수정하도록 함
	 	여기는 그저 값만 받아오기
	 */
	
	public int getPublishingMonth() {
		publishingMonth = date.getMonth();
		return publishingMonth;
	}
	
	public int getPublishingYear() {
		publishingYear = date.getYear();
		return publishingYear;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "Magazine [출판 날짜=" + date.toString() + "]";
	}
	
	
}
