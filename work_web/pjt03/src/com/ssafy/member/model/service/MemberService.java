package com.ssafy.member.model.service;

import java.util.Map;

import com.ssafy.member.model.MemberDto;

public interface MemberService {

	int idCheck(String userId) throws Exception; // 아이디 중복검사
	void joinMember(MemberDto memberDto) throws Exception; // 회원가입
	MemberDto loginMember(String userId, String userPwd) throws Exception; // 로그인
	MemberDto modifyInfo(String userId, Map<String, String> map) throws Exception; // 회원수정
	void resign(String userId) throws Exception; // 회원 탈퇴
	String findUserPwd(String userName, String userId, String phone) throws Exception;
	void updatePwd(String newPwd, String primId) throws Exception;
}
