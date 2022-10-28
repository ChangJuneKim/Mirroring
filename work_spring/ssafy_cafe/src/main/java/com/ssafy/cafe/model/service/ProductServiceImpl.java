package com.ssafy.cafe.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.model.Product;
import com.ssafy.cafe.model.User;
import com.ssafy.cafe.model.mapper.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	private final ProductDao productDao;
	
	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void deleteAll() throws Exception {
		productDao.deleteAll();
	}

	@Override
	public int getCount() throws Exception {
		return productDao.getCount();
	}

	@Override
	public int insert(Product product) throws Exception {
		// TODO Auto-generated method stub
		return productDao.insert(product);
	}

	@Override
	public int update(Product product) throws Exception {
		// TODO Auto-generated method stub
		return productDao.update(product);
	}

	@Override
	public int delete(Integer productId) throws Exception {
		// TODO Auto-generated method stub
		return productDao.delete(productId);
	}

	@Override
	public Product select(Integer productId) throws Exception {
		// TODO Auto-generated method stub
		return productDao.select(productId);
	}

	@Override
	public List<Product> selectAll(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return productDao.selectAll(map);
	}

}
