package com.ssafy.member.model.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.member.model.MemberDto;

public interface MemberDao {

	int idCheck(String userId) throws SQLException;
	void joinMember(MemberDto memberDto) throws SQLException;
	MemberDto loginMember(String userId, String userPwd) throws SQLException;
	void modifyInfo(String userId, Map<String, String> map) throws SQLException;
	MemberDto refreshSession(String userId) throws SQLException;
	void resign(String userId) throws SQLException;
	String findUserPwd(String userId, String userName, String phone) throws SQLException;
	void updatePwd(String newPwd, String primId) throws SQLException;
	
}
