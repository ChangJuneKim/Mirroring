package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDao memberDao = new MemberDaoImpl();
	private DBUtil dbUtil;
	
	private MemberDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}
	
	// 아이디 중복 체크
	@Override
	public int idCheck(String userId) throws SQLException {
		int cnt = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(user_id) \n");
			sql.append("from members \n");
			sql.append("where user_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return cnt;
	}
	
	// 회원가입
	@Override
	public void joinMember(MemberDto memberDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into members (user_id, user_name, user_password, email_id, email_domain, phone_number, address, join_date) \n");
			sql.append("values (?, ?, ?, ?, ?, ?, ?, now())");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, memberDto.getUserId());
			pstmt.setString(++idx, memberDto.getUserName());
			pstmt.setString(++idx, memberDto.getUserPwd());
			pstmt.setString(++idx, memberDto.getEmailId());
			pstmt.setString(++idx, memberDto.getEmailDomain());
			pstmt.setString(++idx, memberDto.getPhoneNumber());
			pstmt.setString(++idx, memberDto.getAddress());
			
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
	}

	// 로그인
	@Override
	public MemberDto loginMember(String userId, String userPwd) throws SQLException {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select user_id, user_name, address, phone_number  \n");
			sql.append("from members \n");
			sql.append("where user_id = ? and user_password = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserId(userId);
				memberDto.setUserName(rs.getString("user_name"));
				memberDto.setPhoneNumber(rs.getString("phone_number"));
				memberDto.setAddress(rs.getString("address"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return memberDto;
	}

	// 회원수정
	@Override
	public void modifyInfo(String userId, Map<String, String> map) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(userId);
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update members \n");
			sql.append("set user_name = ?, address = ?, phone_number = ? \n");
			sql.append("where user_id = ?\n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, map.get("newName"));
			pstmt.setString(2, map.get("newAddress"));
			pstmt.setString(3, map.get("newPhoneNumber"));
			pstmt.setString(4, userId);

			pstmt.executeUpdate();
			
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public MemberDto refreshSession(String userId) throws SQLException {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select user_name, address, phone_number  \n");
			sql.append("from members \n");
			sql.append("where user_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserId(userId);
				memberDto.setUserName(rs.getString("user_name"));
				memberDto.setPhoneNumber(rs.getString("phone_number"));
				memberDto.setAddress(rs.getString("address"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return memberDto;
	}

	@Override
	public void resign(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from members \n");
			sql.append("where user_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
	@Override
	public String findUserPwd(String userId, String userName,String phone) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String primId = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select user_password \n");
			sql.append("from members \n");
			sql.append("where user_id = ? and user_name = ? and phone_number = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, userName);
			pstmt.setString(3, phone);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				primId = rs.getString("user_password");
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return primId;
	}

	@Override
	public void updatePwd(String newPwd, String primId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update members \n");
			sql.append("set user_password = ? \n");
			sql.append("where user_id = ?\n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, newPwd);
			pstmt.setString(2, primId);

			pstmt.executeUpdate();
			
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

}
