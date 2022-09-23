package com.ssafy;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Decoder.Text;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");

		System.out.println("main/" + act);
		String path = "/index.jsp";

		if ("mvapt".equals(act)) {
			path = "/apt.jsp";
			redirect(request, response, path);
		} else if ("mvapt2".equals(act)) {
			path = "/apt2.jsp";
			redirect(request, response, path);
		} else if ("mvland".equals(act)) {
			path = "/land.jsp";
			redirect(request, response, path);
		} else if ("setprefer".equals(act)) {
			path = setPrefer(request, response);
			forward(request, response, path);
		} else {
			redirect(request, response, path);
		}
	}

	private String setPrefer(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String sido = request.getParameter("sido");
		String gugun = request.getParameter("gugun");
		String dong = request.getParameter("dong");
		
		ObjectMapper mapper = new ObjectMapper();
		PreferDto preferDto = new PreferDto();
		preferDto.setSido(sido);
		preferDto.setGugun(gugun);
		preferDto.setDong(dong);
		
		
		
		try {
			String preferJson = mapper.writeValueAsString(preferDto);
			
			preferJson = URLEncoder.encode(preferJson, "utf-8").replaceAll("\\+", "%20");
			Cookie cookie = new Cookie("prefer", preferJson);
			cookie.setMaxAge(60*60*24*400);	
			response.addCookie(cookie);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/index.jsp";
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
}
