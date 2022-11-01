package com.ssafy.ws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.UserService;

/*
 * 현재 아래의 Test들은 WS_06_DaoTest가 모두 통과되었다는 가정 하에 진행되는 테스트 코드이다.
 * 정확하게 Service 단위의 테스트를 진행하기 위해서는 Mockup을 활용해야 한다.
 */
public class WS_07_UserServiceTest extends AbstractTest {
	
	private static final Logger logger = LoggerFactory.getLogger(WS_07_UserServiceTest.class);
	
	// 픽스처
	@Autowired
	private UserService userService;
	
	private User user1;
	// 픽스처 끝
	
	@Before
	public void setUp() {
		
		this.user1 = new User("ssafy", "김싸피", "1234", null);
		
	}
	
	@Test
	public void addAndGetOne() {
		
		userService.deleteAll();
		assertEquals(0, userService.getCount());
		
		// 1. 사용자 추가 테스트
		assertEquals(1, userService.insert(user1));
		assertEquals(1, userService.getCount());
		
		// 2. 사용자 조회 테스트
		User userget1 = userService.select(user1.getId());
		assertEquals(user1.getId(), userget1.getId());
		assertEquals(user1.getName(), userget1.getName());
		assertEquals(user1.getPass(), userget1.getPass());
		assertEquals(user1.getRecId(), userget1.getRecId());
		
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

		// 3. 사용자 조회 테스트
		assertEquals(user1.getId(), user.getId());
		assertEquals(user1.getName(), user.getName());
		assertEquals(user1.getRecId(), user.getRecId());
	}

}
