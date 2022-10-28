package com.ssafy.cafe.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.cafe.model.User;

public interface UserService {
	void removeAll() throws Exception;

	int getCount() throws Exception;

	int addUser(User user) throws Exception;

	int modifyUser(User user) throws Exception;

	int deleteUser(String userId) throws Exception;

	User getUser(String userId) throws Exception;

	List<User> getUsers(Map<String, Object> map) throws Exception;
}
