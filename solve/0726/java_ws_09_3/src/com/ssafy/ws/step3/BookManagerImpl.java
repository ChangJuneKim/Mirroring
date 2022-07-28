package com.ssafy.ws.step3;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {
	
	// 4. getInstance 메서드 내부에서 사용할 수 있도록 static 키워드 사용
	static private BookManagerImpl instance;
	
	// 1. 외부에서 객체 생성을 막자!
	private BookManagerImpl() {}
	
	// 2. 객체를 리턴하는 getter를 만들자!
	static public BookManagerImpl getInstance() {
		
		// 3. 객체 하나만 생성하도록 조건문을 추가!
		if (instance == null) {
			instance = new BookManagerImpl();
		}
		
		return instance;
	}
	
//	private Book[] books = new Book[MAX_SIZE]; // 리스트로 변경 하기
	private List<Book> books = new ArrayList<>();
	
	public void add(Book book) {
			books.add(book);
	}
	
	public void remove(String isbn) {
		for (int i = 0; i < books.size(); ++i) {
//			if (books[i].getIsbn().equals(isbn)) {
//				books[i] = books[size - 1];
//				books[size - 1] = null;
//				--size;
//				break;
//			}
			
			if(books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				return;
			}
		}
	}
	
	public Book[] getList() {
//		return Arrays.copyOfRange(books, 0, size);
		return books.toArray(new Book[books.size()]);
	}
	
	public Book searchByIsbn(String isbn) {
//		for (int i = 0; i < size; i++) {
//			if (books[i].getIsbn().equals(isbn)) {
//				return books[i];
//			}
//		}
		
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				return books.get(i);
			}
		}
		return null;
	}
	
	// 제목으로 검색 결과를 리턴하는 메서드
	public Book[] searchByTitle(String title) {
		int count = 0;
//		for (int i = 0; i < size; i++) {
//			if (books[i].getTitle().contains(title)) {  // 제목을 포함하는 도서의 개수를 카운트
//				count++;
//			}
//		}
		
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().contains(title)) {  // 제목을 포함하는 도서의 개수를 카운트
				count++;
			}
		}
		
		Book[] result = new Book[count];  // 결과 카운트 만큼 배열 생성
		
		int idx = 0;  // 리턴하려는 배열의 인덱스 번호
//		for (int i = 0; i < size; i++) {
//			if (books[i].getTitle().contains(title)) {
//				result[idx++] = books[i];
//			}
//		}
		
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().contains(title)) {
				result[idx++] = books.get(i);
			}
		}
		
		return result;
	}
	
	// books 배열 중 Magazine 객체가 담긴 배열을 리턴하는 메서드
	public Magazine[] getMagazines() {
		int count = 0;
		for (int i = 0; i < books.size(); i++) {  // books 배열에서 잡지 개수만큼 카운트
			if (books.get(i) instanceof Magazine) {
				count++;
			}
		}
		
		Magazine[] result = new Magazine[count];
		
		int idx = 0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) instanceof Magazine) {  // 잡지만 배열에 담기
				result[idx++] = (Magazine) books.get(i);
			}
		}
		
		return result;
	}
	
	public Book[] getBooks() {
		int count = 0;
		for (int i = 0; i < books.size(); i++) {  // books 배열에서 일반 책 개수만큼 카운트
			if (!(books.get(i) instanceof Magazine)) {
				count++;
			}
		}
		
		Book[] result = new Book[count];
		
		int idx = 0;
		for (int i = 0; i < books.size(); i++) {
			if (!(books.get(i) instanceof Magazine)) {  // 일반 책만 배열에 담기
				result[idx++] = books.get(i);
			}
		}
		
		return result;
	}
	
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < books.size(); i++) {
			total += books.get(i).getPrice();
		}
		
		return total;
	}
	
	public double getPriceAvg() {
		return (double) getTotalPrice() / books.size();
	}

	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException{
		Book searchedBook = searchByIsbn(isbn);
		
		if(searchedBook == null) {
			throw new ISBNNotFoundException(isbn);
		}
		
		if(searchedBook.getQuantity() < quantity) {
			throw new QuantityException();
		}
		
		int remainedBookCount = searchedBook.getQuantity() - quantity;
		searchedBook.setQuantity(remainedBookCount);
		System.out.println(searchedBook);
	}

	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book searchedBook = searchByIsbn(isbn);
		
		if(searchedBook == null) {
			throw new ISBNNotFoundException(isbn);
		}
		
		searchedBook.setQuantity(searchedBook.getQuantity() + quantity);
		System.out.println(searchedBook);
		
	}
}
