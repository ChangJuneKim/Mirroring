package com.saffy.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.Name;


@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	
	public void init() {
		name = "안효인";
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. data get
		
		// 2. logic
		
		// 3. response page => html
		response.setContentType("text/html;charset=utf-8"); // 한글 처리
		PrintWriter out = response.getWriter(); // writer를 지정하기 전에 먼저 한글처리를 해줘야함
		
		out.println("<html>");
		out.println("	<body>");
		out.println("		<h2>HelloServlet Servlet!!!!</h2>");
		out.println("		<h2>" + name + "님 안녕하세요!!!</h2>");
		out.println("	</body>");
		out.println("</html>");
	}

}
