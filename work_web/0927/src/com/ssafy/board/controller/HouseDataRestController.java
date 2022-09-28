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

//	public Object getDongNames(HttpServletRequest req, HttpServletResponse resp) {
//		String gugunCode = req.getParameter("gugunCode").substring(2, 5);
//		
//		try {
//			Map<String, String> map = service.selectDongNames(gugunCode);
//			return map;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}

	public Object getRowHouseTrade(HttpServletRequest req, HttpServletResponse resp) {
		// 클라이언트로부터 전달받은 지역코드 (동코드 5자리) 거래년월을 받는다.
		String regionCode = req.getParameter("regionCode");
		String dealYmd = req.getParameter("dealYmd");
		
		Map<String, Object> response = service.getRowHouseTrade(regionCode, dealYmd);
		
		return response;
	}
}
