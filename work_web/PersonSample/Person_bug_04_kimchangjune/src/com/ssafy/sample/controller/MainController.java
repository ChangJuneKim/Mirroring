package com.ssafy.sample.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.dto.Person;
import com.ssafy.sample.dto.User;
import com.ssafy.sample.model.service.PersonService;

@WebServlet("/main")
public class MainController extends HttpServlet {

	PersonService service = new PersonService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "index":
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			break;

		case "regist_form":
			response.sendRedirect(request.getContextPath() + "/person/regist.jsp");
			break;

		case "regist":
			String personId = request.getParameter("personId");
			String name = request.getParameter("name");
			String departmentName = request.getParameter("departmentName");
			int pay = Integer.parseInt(request.getParameter("pay"));

			Person newPerson = new Person(personId, name, departmentName, pay);

			try {
				int cnt = service.regist(newPerson);

				request.setAttribute("cnt", cnt);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("person/regist_result.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect(request.getContextPath() + "/error/error.jsp");
			}
			break;

		case "list":
			try {
				List<Person> personList = service.findAll();
				request.setAttribute("personList", personList);

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/person/person_list.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect(request.getContextPath() + "/error/error.jsp");
			}
			break;

		case "detail":
			String id = request.getParameter("personId");

			try {
				Person detailPerson = service.detail(id);
				request.setAttribute("person", detailPerson);

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/person/detail.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect(request.getContextPath() + "/error/error.jsp");
			}

			break;

		case "delete":
			String removeId = request.getParameter("personId");

			try {
				int cnt = service.delete(removeId);

				response.sendRedirect(request.getContextPath() + "/main?action=list");
				// 이거 좀 중요한듯
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect(request.getContextPath() + "/error/error.jsp");
			}
			break;

		case "login":
			// 1. 클라이언트의 요청 데이터 받기
			String userId = request.getParameter("id");
			String password = request.getParameter("password");

			User user = service.login(request, userId, password);

			if (user != null) {
				// 로그인 성공
				request.setAttribute("user", user);
			} else {
				request.setAttribute("message", "아이디 또는 패스워드가 다릅니다.");
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "logout":
			boolean isLogout = service.logout(request);

			if (isLogout) {
				request.setAttribute("message", "로그아웃 되었습니다.");
			} else {
				request.setAttribute("message", "로그아웃 실패");
			}
			RequestDispatcher logoutDispatcher = request.getRequestDispatcher("/index.jsp");
			logoutDispatcher.forward(request, response);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
}
