package com.ssafy.ws.step3.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.ws.step3.dto.Book;
import com.ssafy.ws.step3.dto.User;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// request 객체에서 action 값을 추출해서 실제 비지니스 로직 메서드 호출

		String action = req.getParameter("action");
		switch (action) {
		case "regist":
			doRegist(req, resp);
			break;
		case "login":
			doLogin(req, resp);
			break;
		case "logout":
			doLogout(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post 요청 시 한글 파라미터의 처리를 위해 encoding을 처리한다.
		req.setCharacterEncoding("utf-8");

		doGet(req, resp);

	}

	private void doLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect(req.getContextPath() + "/index.jsp");
	}

	private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");

		if ("ssafy".equals(id) && "1234".equals(pass)) {
			User user = new User(id, pass, "김싸피");

			System.out.println(user);
			// 로그인 성공시 세션에 사용자 정보 저장
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", user);

			// 새로운 url 설정을 위해 리다이렉트로 index로 이동
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		} else {
			// 로그인 실패에 대한 메세지 request에 설정
			req.setAttribute("msg", "로그인 실패");

			// 기존의 url을 유지하기 위해 포워드로 이동
			RequestDispatcher disp = req.getRequestDispatcher("/index.jsp");
			disp.forward(req, resp);
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

		// book 객체를 request 영역에 book이라는 이름으로 등록한다.
		req.setAttribute("book", book);

		// JSP 화면 호출을 위해 RequestDispatcher의 forward를 사용한다.
		// 이때 연결할 jsp의 이름을 넘겨준다. forward에서 /는 context root를 나타낸다.
		RequestDispatcher disp = req.getRequestDispatcher("/regist_result.jsp");
		try {
			disp.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}
}
