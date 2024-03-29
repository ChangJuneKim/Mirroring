package com.ssafy.board.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import com.ssafy.board.model.dao.HouseDataDao;
import com.ssafy.board.util.DBUtil;

public class HouseDataService {
	
	private static final String DB_NAME = "housedata2";

	private HouseDataDao dao = new HouseDataDao();
	
	public Map<String, String> selectSidoNames() throws SQLException {
		Connection conn = null;
		Map<String, String> map = null;
		
		try {
			conn = DBUtil.getConnection(DB_NAME);
			map = dao.selectSidoNames(conn);
		} finally {
			DBUtil.close(conn);
		}
		return map;
	}

	public Map<String, String> selectGugunNames(String sidoCode) throws SQLException {
		Connection conn = null;
		Map<String, String> map = null;
		
		try {
			conn = DBUtil.getConnection(DB_NAME);
			map = dao.selectGugunNames(conn, sidoCode);
		} finally {
			DBUtil.close(conn);
		}
		return map;
	}

	public Map<String, Object> getRowHouseTrade(String regionCode, String dealYmd) {
		Map<String, Object> response = dao.requestRowHouseTrade(regionCode, dealYmd);
		return response;
	}

//	public Map<String, String> selectDongNames(String gugunCode) {
//		Connection conn = null;
//		Map<String, String> map = null;
//		
//		try {
//			conn = DBUtil.getConnection(DB_NAME);
//			map = dao.selectDongNames(conn, gugunCode);
//		} finally {
//			DBUtil.close(conn);
//		}
//		return map;
//	}

}
