package com.ssafy.cafe.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.cafe.model.Product;
import com.ssafy.cafe.model.User;

public interface ProductService {
	
	void deleteAll() throws Exception;

	int getCount() throws Exception;

	int insert(Product product) throws Exception;

	int update(Product product) throws Exception;

	int delete(Integer productId) throws Exception;

	Product select(Integer productId) throws Exception;

	List<Product> selectAll(Map<String, Object> map) throws Exception;

}
