package com.ssafy.user.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.ssafy.user.dto.User;

public class UserDaoTest {

	// 픽스처(fixture) : 테스트를 수행하는데 필요한 정보나 객체
	// setUp() 메서드에서 만드는 객체를 테스트 메서드에서 사용할 수 있도록 필드로 선언한다.
	private UserDao userDao;
	private User user1;
	private User user2;
	private User user3;

	@Before // JUnit이 제공하는 Annotation. @Test 메서드가 실행되기 전에 먼저 실행되어야 하는 메서드를 정의
	public void setUp() {
		System.out.println("setUp call");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/com/ssafy/user/config/application.xml");

		userDao = applicationContext.getBean(UserDao.class);
		
		user1 = new User("ssafy", "김싸피", "passafy");
		user2 = new User("lee", "이싸피", "1234");
		user3 = new User("three", "삼싸피", "3333");
	}

	@Test
	public void addAndGet() throws SQLException { // junit 테스트 메서드는 반드시 public void

		// 매 테스트 할 때 ,동일한 테스트를 수행하면 동일한 결과를 얻어야 한다.
		// 그래서 deleteAll로 db를 지우고 확인을 해봄
		userDao.deleteAll();
		assertEquals(userDao.getCount(), 0);

		// 1. 사용자 추가 테스트
		User user1 = new User("ssafy", "김싸피", "passafy");
		User user2 = new User("lee", "이싸피", "1234");
		userDao.add(user1);
		userDao.add(user2);

		assertEquals(userDao.getCount(), 2);

		// 2. 사용자 조회 테스트
		User findUser1 = userDao.get(user1.getId());
		User findUser2 = userDao.get(user2.getId());
		// 기대값, 실제값
		assertEquals(findUser1.getName(), user1.getName());
		assertEquals(findUser1.getPassword(), user1.getPassword());
		assertEquals(findUser2.getName(), user2.getName());
		assertEquals(findUser2.getPassword(), user2.getPassword());
	}

	@Test
	public void count() throws SQLException {

		userDao.deleteAll();
		assertEquals(userDao.getCount(), 0);

		userDao.add(user1);
		assertEquals(userDao.getCount(), 1);

		userDao.add(user2);
		assertEquals(userDao.getCount(), 2);

		userDao.add(user3);
		assertEquals(userDao.getCount(), 3);
	}

	/**
	 * 주의할 점 : 두 개의 테스트가 어떤 순서로 실행될지는 알 수 없다. 모든 테스트는 실행 순서에 상관없이 독립적으로 항상 동일한 결과를 낼
	 * 수 있도록 한다.
	 */

	// 테스트 중에 발생할 것으로 기대하는 예외 클래스를 지정해준다.
	@Test(expected = EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException {

		userDao.deleteAll();
		assertEquals(userDao.getCount(), 0);

		userDao.get("asd");
	}
}
