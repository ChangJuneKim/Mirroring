package com.ssafy.ws.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.UserMapper;
import com.ssafy.ws.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User select(String id) {
		// TODO Auto-generated method stub
		return userMapper.select(id);
	}

}
