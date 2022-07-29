package com.ssafy.rent.model.dao;

import com.ssafy.rent.model.dto.HomeDeal;

public interface EnvironmentDao {
	public void loadData();
	
	public HomeDeal search(int no);
}
