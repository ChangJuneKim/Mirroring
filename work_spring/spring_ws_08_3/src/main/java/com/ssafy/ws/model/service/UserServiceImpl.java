package com.ssafy.ws.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.UserDao;
import com.ssafy.ws.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User select(String id) {
		return userDao.select(id);
	}

	@Override
	public void deleteAll() {
		userDao.deleteAll();
	}

	@Override
	public int getCount() {
		return userDao.getCount();
	}

	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

}
