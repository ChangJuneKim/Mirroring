package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import com.ssafy.board.util.DBUtil;

public class HouseDataDao {

	public Map<String, String> selectSidoNames(Connection conn) throws SQLException {
		String sql = "select dongCode, sidoName from dongcode where dongcode like ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, "__00000000");
		
		ResultSet result = pstmt.executeQuery();
		
		Map<String, String> map = new TreeMap<>(); // TreeMap을 사용하는 이유는 키 값 기준 오름차순 정렬을 위해
		
		while(result.next()) {
			map.put(result.getString("dongCode"), result.getString("sidoName"));
		}
		
		DBUtil.close(result);
		DBUtil.close(pstmt);
		
		return map;
	}

	public Map<String, String> selectGugunNames(Connection conn, String sidoCode) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("select dongCode, gugunName \n");
		sb.append("from dongcode \n");
		sb.append("where dongcode like ? \n");
		sb.append("and gugunName is not null \n");
		
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		
		pstmt.setString(1, sidoCode + "___00000");
		
		ResultSet result = pstmt.executeQuery();
		
		Map<String, String> map = new TreeMap<>(); // TreeMap을 사용하는 이유는 키 값 기준 오름차순 정렬을 위해
		
		while(result.next()) {
			map.put(result.getString("dongCode"), result.getString("gugunName"));
		}
		
		DBUtil.close(result);
		DBUtil.close(pstmt);
		
		return map;
	}

	public Map<String, String> selectDongNames(Connection conn, String gugunCode) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("select dongCode, dongName \n");
		sb.append("from dongcode \n");
		sb.append("where dongcode like ? \n");
		sb.append("and dongName is not null \n");
		
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		
		pstmt.setString(1, gugunCode + "___00000");
		
		ResultSet result = pstmt.executeQuery();
		
		Map<String, String> map = new TreeMap<>(); // TreeMap을 사용하는 이유는 키 값 기준 오름차순 정렬을 위해
		
		while(result.next()) {
			map.put(result.getString("dongCode"), result.getString("dongName"));
		}
		
		DBUtil.close(result);
		DBUtil.close(pstmt);
		
		return map;
	}

}
