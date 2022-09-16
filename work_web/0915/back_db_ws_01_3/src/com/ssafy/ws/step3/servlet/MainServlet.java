package com.ssafy.ws.step3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.ws.step3.dto.Book;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post 요청 시 한글 파라미터의 처리를 위해 encoding을 처리한다.
		req.setCharacterEncoding("utf-8");
		
		// request 객체에서 action 값을 추출해서 실제 비지니스 로직 메서드 호출
		String action = req.getParameter("action");
		switch (action) {
		case "regist":
			doRegist(req, resp);
			break;
		}
	}

	private void doRegist(HttpServletRequest req, HttpServletResponse resp) {
		// request 객체에서 클라이언트로 부터 전달받은 form 데이터를 끄집어 낸다.
		String isbn = req.getParameter("isbn");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		int price = Integer.parseInt(req.getParameter("price"));
		String desc = req.getParameter("desc");
		
		// form 데이터를 이용해서 Book 객체를 생성
		Book book = new Book(isbn, title, author, price, desc);
		
		// 응답할 내용 작성
		resp.setContentType("text/html; charset=UTF-8");
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body>");
		sb.append("<h1>입력 내용</h1>");
		sb.append(book);
		sb.append("</body>");
		sb.append("</html>");
		
		try {
			resp.getWriter().write(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
