package com.ssafy.ws.model.dao;

import com.ssafy.ws.model.dto.User;

public interface UserMapper {
	
	User select(String id);
	
}
