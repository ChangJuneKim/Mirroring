package com.ssafy.ws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.ws.config.ApplicationConfig;
import com.ssafy.ws.model.repo.BookRepo;
import com.ssafy.ws.model.repo.UserRepo;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.BookServiceImpl;
import com.ssafy.ws.model.service.UserService;

public class WS_02_BeanCreationTest extends AbstractTest {

	// 로깅 처리를 위한 로거 추가
	private static Logger logger = LoggerFactory.getLogger(WS_02_BeanCreationTest.class);

	// 필요한 빈들을 @Autowired를 이용하여 주입받기
	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private BookService bookService;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserService userService;
	
	@Autowired
	private DataSource dataSource;

	// 1. BookRepo, UserRepo, BookService, UserService가 잘 생성되었는지 테스트
	@Test
	public void testBeanCreation() {
		assertNotNull(bookRepo);
		assertNotNull(bookService);
		assertNotNull(userRepo);
		assertNotNull(userService);
	}

	// 2. 컨텍스트에서 직접 얻어온 BookRepo 와 BookService 가 가지는 repo 가 동일한가?
	@Test
	public void testSingleton() {
		logger.debug("bookRepo : {}", bookRepo);
		
		logger.debug("bookService : {}", bookService);
		
		logger.debug("bookService class : {}", bookService.getClass().getName());
		logger.debug("bookService bookRepo 클래스 이름 : {}", bookService.getClass().getName());
		
		assertEquals(bookRepo, ((BookServiceImpl) bookService).getBookRepo());
	}

	// 3. DataSource 객체가 잘 생성되었는지 테스트
	@Test
	public void testDataSouceCreation() {
		logger.debug("datasource 확인 : {}", dataSource);
		assertNotNull(dataSource);
	}
}
