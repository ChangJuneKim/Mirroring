package com.ssafy.cafe.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.model.User;
import com.ssafy.cafe.model.mapper.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void removeAll() throws Exception {
		userDao.deleteAll();
		
	}

	@Override
	public int getCount() throws Exception {
		// TODO Auto-generated method stub
		return userDao.getCount();
	}

	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.insert(user);
	}

	@Override
	public int modifyUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	@Override
	public int deleteUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.delete(userId);
	}

	@Override
	public User getUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.select(userId);
	}

	@Override
	public List<User> getUsers(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return userDao.selectAll(map);
	}

	


}
