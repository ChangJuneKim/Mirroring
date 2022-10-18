package com.ssafy.user.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.user.dto.User;

public class UserDaoTest {
	public static void main(String[] args) throws SQLException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/com/ssafy/user/config/application.xml");
		
		UserDao userDao = applicationContext.getBean(UserDao.class);
		
		// 1. 사용자 추가 테스트
		User user = new User("ssafy1", "김싸피", "passafy");
		userDao.add(user);
		
		System.out.println(user.getId() + " 등록 성공");
		
		// 2. 사용자 조회 테스트
		User user2 = userDao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " 조회 성공");
	}
}
