package com.ssafy.reflection.factory;

import java.util.ArrayList;
import java.util.List;

public class MyDao implements UserDao{

	List<User> users = new ArrayList<>();
	
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		users.add(user);
	}

	@Override
	public User select(int id) {
		for(User user : users) {
			if(user != null && user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}

}
