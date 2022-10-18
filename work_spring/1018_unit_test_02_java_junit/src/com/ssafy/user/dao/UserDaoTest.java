package com.ssafy.user.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.ssafy.user.dto.User;

public class UserDaoTest {
	
	

	@Test
	public void addAndGet() throws SQLException { // junit 테스트 메서드는 반드시 public void
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/com/ssafy/user/config/application.xml");

		UserDao userDao = applicationContext.getBean(UserDao.class);

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
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/com/ssafy/user/config/application.xml");

		UserDao userDao = applicationContext.getBean(UserDao.class);
		
		userDao.deleteAll();
		assertEquals(userDao.getCount(), 0);
		
		User user1 = new User("ssafy", "김싸피", "passafy");
		User user2 = new User("lee", "이싸피", "1234");
		User user3 = new User("three", "삼싸피", "3333");
		
		userDao.add(user1);
		assertEquals(userDao.getCount(), 1);
		
		userDao.add(user2);
		assertEquals(userDao.getCount(), 2);
		
		userDao.add(user3);
		assertEquals(userDao.getCount(), 3);
	}

	/**
	 * 주의할 점 : 두 개의 테스트가 어떤 순서로 실행될지는 알 수 없다.
	 * 모든 테스트는 실행 순서에 상관없이 독립적으로 항상 동일한 결과를 낼 수 있도록 한다.
	 */
	
	// 테스트 중에 발생할 것으로 기대하는 예외 클래스를 지정해준다.
	@Test(expected = EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/com/ssafy/user/config/application.xml");

		UserDao userDao = applicationContext.getBean(UserDao.class);
		
		userDao.deleteAll();
		assertEquals(userDao.getCount(), 0);
		
		
		User findUser = userDao.get("asd");
		
		System.out.println(findUser);
	}
	
	/**
	 * 기능 설계, 코드 구현, 테스트 세 가지 작업을 동시에 할 수 있다.
	 * 
	 * 테스트 주도 개발(TDD : Test Driven Development)
	 * TDD의 기본 원칙 : 실패한 테스트를 성공시키기 위한 목적이 아닌 코드는 만들지 않는다. (실패한 테스트를 성공시키도록 코드를 작성한다.)
	 * TDD는 테스트를 먼저 만들고 그 테스트가 성공하도록 하는 코드만 만드는 식으로 진행하기 때문에
	 * 테스트를 빼먹지않고 꼼곰하게 만들어낼 수 있다.
	 */
}
