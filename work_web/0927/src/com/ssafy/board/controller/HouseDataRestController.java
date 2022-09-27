package com.ssafy.board.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.model.service.HouseDataService;

public class HouseDataRestController {

	private HouseDataService service = new HouseDataService();
	
	public Object getSidoNames(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Map<String, String> map = service.selectSidoNames();
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public Object getGugunNames(HttpServletRequest req, HttpServletResponse resp) {
		String sidoCode = req.getParameter("sidoCode").substring(0, 2);
		
		try {
			Map<String, String> map = service.selectGugunNames(sidoCode);
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public Object getDongNames(HttpServletRequest req, HttpServletResponse resp) {
		String gugunCode = req.getParameter("gugunCode").substring(2, 5);
		
		try {
			Map<String, String> map = service.selectDongNames(gugunCode);
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
