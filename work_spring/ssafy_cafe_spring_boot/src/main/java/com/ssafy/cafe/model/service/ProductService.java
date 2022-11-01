package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.Product;

public interface ProductService {

	void removeAll();

	int getCount();

	int addProduct(Product product);

	int modifyProduct(Product product);

	int removeProduct(Integer productId);

	Product getProduct(Integer productId);

	List<Product> getProducts();
	
}
