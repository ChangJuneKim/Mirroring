package com.ssafy.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class BoardServlet extends HttpServlet {

	private BoardService service = new BoardService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시판 글 가져오기
		try {
			List<Board> list = service.list();
			
			request.setAttribute("list", list);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
