package com.ssafy.ws;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.ws.model.dao.BookMapper;
import com.ssafy.ws.model.dto.Book;

public class WS_06_BookDaoTest extends AbstractTest {

	private static final Logger logger = LoggerFactory.getLogger(WS_06_BookDaoTest.class);

	// 픽스쳐(fixture): 테스트를 수행하는데 필요한 정보나 객체
	@Autowired
	private BookMapper bookMapper;

	private Book book1;
	private Book book2;
	private Book book3;
	// 픽스쳐 끝
	
	@Before
	public void setUp() {
		this.book1 = new Book("111-222-3333", "홍길동", "책제목1", 10000, "좋은 책 1", null, "abc1.png");
		this.book2 = new Book("111-222-4444", "임꺽정", "책제목2", 20000, "좋은 책 2", null, "abc2.png");
		this.book3 = new Book("111-333-4444", "장길산", "책제목3", 30000, "좋은 책 3", null, "abc3.png");
		
	}

	@Test
	public void addAndGet() {  // 추가, 조회 테스트
		
		bookMapper.deleteAll();
		assertEquals(0, bookMapper.getCount());
		
		// 1. 도서 추가 테스트
		assertEquals(1, bookMapper.insert(book1));
		assertEquals(1, bookMapper.insert(book2));
		assertEquals(2, bookMapper.getCount());
		
		// 2. 도서 조회 테스트
		Book bookget1 = bookMapper.select(book1.getIsbn());
		
		// 대표적으로 도서 제목과 가격으로 비교
		assertEquals(book1.getTitle(), bookget1.getTitle());
		assertEquals(book1.getPrice(), bookget1.getPrice());
		assertEquals(book1.getOrgImg(), bookget1.getOrgImg());
		
		Book bookget2 = bookMapper.select(book2.getIsbn());
		
		// 대표적으로 도서 제목과 가격으로 비교
		assertEquals(book2.getTitle(), bookget2.getTitle());
		assertEquals(book2.getPrice(), bookget2.getPrice());
		assertEquals(book2.getOrgImg(), bookget2.getOrgImg());
	}


	@Test
	public void count() {

	}

	@Test
	public void addAndUpdate() {

	}

	@Test
	public void addAndDelete() {

	}

	@Test
	public void selectAll() {

	}

}
