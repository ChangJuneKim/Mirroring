package com.ssafy.reflection.factory;

public class UserService {
	private UserDao userDao;
	
	public UserService() {
		
	}
	
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	// 사용자 등록
	public void add(User user) {
		userDao.insert(user);
	}
	
	// 사용자 조회
	public User get(int id) {
		User user = userDao.select(id);
		return user;
	}
}
