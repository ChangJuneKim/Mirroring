package com.ssafy.reflection.factory;

import java.util.HashMap;
import java.util.Map;

public class OraDao implements UserDao{
	Map<Integer, User> usersMap = new HashMap<Integer, User>();

	@Override
	public void insert(User user) {
		usersMap.put(user.getId(), user);
		
	}

	@Override
	public User select(int id) {
		return usersMap.get(id);
	}
	
	
}
