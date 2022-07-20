package com.ssafy.ws.step3;
/**
 * 도서 정보를 나타내는 클래스
 */
public class Book {
	//코드를 작성하세요.
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	
	public Book() {}
	
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return this.isbn + "\t| " + this.title + "\t| " + this.author + "  | " + this.publisher + "\t| " + this.price +" | " + this.desc;
	}
}

