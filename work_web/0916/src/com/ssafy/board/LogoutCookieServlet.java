package com.ssafy.board;

import com.ssafy.was.SsafyCookie;
import com.ssafy.was.SsafyRequest;
import com.ssafy.was.SsafyResponse;

public class LogoutCookieServlet {

	public void doGet(SsafyRequest request, SsafyResponse response) {
		SsafyCookie[] cookies = request.getCookies();
		SsafyCookie userId = null;
		for (SsafyCookie cookie : cookies) {
			if (cookie.getName().equals("userId")) {
				userId = cookie;
				break;
			}
		}

		if (userId == null) {
			StringBuilder sb = new StringBuilder();
			sb.append("<h1>로그아웃 실패</h1>");
			sb.append("<a href='/index.html'>홈으로 이동</a>");

			response.print(sb.toString());
			return;
		}

		// 쿠키 소멸시간 설정
		userId.setMaxAge(-1);

		userId.setDomain("127.0.0.1");

		userId.setPath("/");

		response.addCookie(userId);

		StringBuilder sb = new StringBuilder();
		sb.append("<h1>로그아웃  성공</h1>");
		sb.append("<a href='/index.html'>홈으로 이동</a>");

		response.print(sb.toString());
	}

}
