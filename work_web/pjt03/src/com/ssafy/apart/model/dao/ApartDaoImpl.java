package com.ssafy.apart.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;

public class ApartDaoImpl implements ApartDao {
	private static ApartDao apartDao = new ApartDaoImpl();
	private DBUtil dbUtil;

	private ApartDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static ApartDao getApartDao() {
		return apartDao;
	}

	@Override
	public Map<String, String> getSidoNames() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection("housedata2");

			StringBuilder sql = new StringBuilder();
			sql.append("select dongCode, sidoName\n");
			sql.append("from dongcode \n");
			sql.append("where dongcode like ?");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, "__00000000");

			rs = pstmt.executeQuery();

			Map<String, String> map = new TreeMap<>(); // TreeMap을 사용하는 이유는 키 값 기준 오름차순 정렬을 위해

			while (rs.next()) {
				map.put(rs.getString("dongCode"), rs.getString("sidoName"));
			}
			
			return map;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}

	}

	@Override
	public Map<String, String> getGugunNames(String sidoCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection("housedata2");

			StringBuilder sql = new StringBuilder();
			sql.append("select dongCode, gugunName \n");
			sql.append("from dongcode \n");
			sql.append("where dongcode like ? \n");
			sql.append("and gugunName is not null \n");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, sidoCode + "___00000");

			rs = pstmt.executeQuery();

			Map<String, String> map = new TreeMap<>(); // TreeMap을 사용하는 이유는 키 값 기준 오름차순 정렬을 위해

			while (rs.next()) {
				map.put(rs.getString("dongCode"), rs.getString("gugunName"));
			}
			
			return map;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public Map<String, String> getDongNames(String gugunCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection("housedata2");

			StringBuilder sql = new StringBuilder();
			sql.append("select dongCode, dongName \n");
			sql.append("from dongcode \n");
			sql.append("where dongcode like ? \n");
			sql.append("and dongName  is not null \n");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, gugunCode + "_____");

			rs = pstmt.executeQuery();

			Map<String, String> map = new TreeMap<>(); // TreeMap을 사용하는 이유는 키 값 기준 오름차순 정렬을 위해

			while (rs.next()) {
				map.put(rs.getString("dongCode"), rs.getString("dongName"));
			}
			
			return map;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}
}
