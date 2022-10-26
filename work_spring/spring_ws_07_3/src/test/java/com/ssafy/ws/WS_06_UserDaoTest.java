package com.ssafy.ws;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.ws.model.dao.UserDao;
import com.ssafy.ws.model.dto.User;

public class WS_06_UserDaoTest extends AbstractTest {
	
	private static final Logger logger = LoggerFactory.getLogger(WS_06_UserDaoTest.class);
	
	// 픽스처(fixture): 테스트를 수행하는데 필요한 정보나 객체
	@Autowired
	private UserDao userDao;
	
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
	public void addAndGetOne() {
		
		userDao.deleteAll();
		assertEquals(0, userDao.getCount());
		
		// 1. 사용자 추가 테스트
		assertEquals(1, userDao.insert(user1));
		
		userDao.insert(user2);
		userDao.insert(user3);
		assertEquals(3, userDao.getCount());
		
		// 2. 사용자 조회 테스트
		User findedUser1 = userDao.select("ssafy1");
		User findedUser2 = userDao.select("ssafy2");
		
		assertEquals(user1.getId(), findedUser1.getId());
		assertEquals(user1.getRecId(), findedUser1.getRecId());
		assertEquals(user2.getId(), findedUser2.getId());
		assertEquals(user2.getRecId(), findedUser2.getRecId());
		
	}
}
