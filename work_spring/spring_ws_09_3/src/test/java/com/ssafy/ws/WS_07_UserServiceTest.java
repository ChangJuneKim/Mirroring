package com.ssafy.ws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.ws.model.dao.UserDao;
import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.UserService;

/*
 * 현재 아래의 Test들은 WS_06_DaoTest가 모두 통과되었다는 가정 하에 진행되는 테스트 코드이다.
 * 정확하게 Service 단위의 테스트를 진행하기 위해서는 Mockup을 활용해야 한다.
 */
public class WS_07_UserServiceTest extends AbstractTest {

	private static final Logger logger = LoggerFactory.getLogger(WS_07_UserServiceTest.class);

	// 픽스처
	// 픽스처(fixture): 테스트를 수행하는데 필요한 정보나 객체
	@Autowired
	private UserService userService;

	private User user1;
	private User user2;
	private User user3;
	// 픽스처 끝

	@Before
	public void setUp() {

		this.user1 = new User("ssafy1", "김싸피", "1234", null);
		this.user2 = new User("ssafy2", "이싸피", "1111", null);
		this.user3 = new User("ssafy3", "박싸피", "2222", null);

	}

	@Test
	public void addAndGet() { // 추가, 조회 테스트

		userService.deleteAll();
		assertEquals(0, userService.getCount());
		
		// 1. 사용자 추가 테스트
		assertEquals(1, userService.insert(user1));
		
		userService.insert(user2);
		userService.insert(user3);
		assertEquals(3, userService.getCount());
		
		// 2. 사용자 조회 테스트
		User findedUser1 = userService.select("ssafy1");
		User findedUser2 = userService.select("ssafy2");
		
		assertEquals(user1.getId(), findedUser1.getId());
		assertEquals(user1.getRecId(), findedUser1.getRecId());
		assertEquals(user2.getId(), findedUser2.getId());
		assertEquals(user2.getRecId(), findedUser2.getRecId());
		
	}
	

	@Test
	public void login() {
		userService.deleteAll();
		assertEquals(0, userService.getCount());

		// 1. 사용자 추가 테스트
		assertEquals(1, userService.insert(user1));
		assertEquals(1, userService.getCount());
		
		User user = userService.login(user1);

		assertNotNull(user);
		assertNull(user.getPass());
		
		assertEquals(user1.getId(), user.getId());
		assertEquals(user1.getName(), user.getName());
		assertEquals(user1.getRecId(), user.getRecId());
	}
	
}
