package com.ssafy.cafe.model.mapper;

import java.util.List;

import com.ssafy.cafe.model.Product;

public interface ProductDao {
	
	void deleteAll();
	
	int getCount();

	int insert(Product product);

	int update(Product product);

	int delete(Integer productId);

	Product select(Integer productId);

	List<Product> selectAll();

	

}
