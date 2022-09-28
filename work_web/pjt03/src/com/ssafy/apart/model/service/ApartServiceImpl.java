package com.ssafy.apart.model.service;

import java.util.Map;

import com.ssafy.apart.model.dao.ApartDao;
import com.ssafy.apart.model.dao.ApartDaoImpl;

public class ApartServiceImpl implements ApartService{

	private static ApartService apartService = new ApartServiceImpl();
	private ApartDao apartDao;
	
	private ApartServiceImpl() {
		apartDao = ApartDaoImpl.getApartDao();
	}

	public static ApartService getApartService() {
		return apartService;
	}
	
	@Override
	public Map<String, String> getSidoNames() throws Exception {
		return apartDao.getSidoNames();
	}

	@Override
	public Map<String, String> getGugunNames(String sidoCode) throws Exception {
		return apartDao.getGugunNames(sidoCode);
	}

	@Override
	public Map<String, String> getDongNames(String gugunCode) throws Exception {
		return apartDao.getDongNames(gugunCode);
	}
	
}
