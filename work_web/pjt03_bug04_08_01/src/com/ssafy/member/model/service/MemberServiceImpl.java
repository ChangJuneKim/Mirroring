package com.ssafy.member.model.service;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;
import com.ssafy.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	private static MemberService memberService = new MemberServiceImpl();
	private MemberDao memberDao;
	private BoardDao boardDao = BoardDaoImpl.getBoardDao();
	
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getMemberDao();
	}
	
	public static MemberService getMemberService() {
		return memberService;
	}

	@Override
	public int idCheck(String userId) throws Exception {
		return memberDao.idCheck(userId);
	}

	@Override
	public void joinMember(MemberDto memberDto) throws Exception {
		// TODO validation check
		memberDao.joinMember(memberDto);
	}

	@Override
	public MemberDto loginMember(String userId, String userPwd) throws Exception {
		return memberDao.loginMember(userId, userPwd);
	}

	@Override
	public MemberDto modifyInfo(String userId, Map<String, String> map) throws Exception {
		memberDao.modifyInfo(userId, map); // 업데이트
		return memberDao.refreshSession(userId); // 셀렉트
	}

	@Override
	public void resign(String userId) throws Exception {
		boardDao.deleteAll(userId); // 게시글 부터 모두 삭제
		memberDao.resign(userId); // 삭제
	}
	
	@Override
	public String findUserPwd( String userId, String userName, String phone)throws Exception {
		return memberDao.findUserPwd(userId, userName, phone);
	}
	
	@Override
	public void updatePwd(String newPwd, String primId) throws Exception {
		memberDao.updatePwd(newPwd, primId);
	}

}
