package com.ssafy.apart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.apart.model.service.ApartService;
import com.ssafy.apart.model.service.ApartServiceImpl;

@WebServlet("/apart")
public class ApartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ApartService apartService;
	
	public void init() {
		apartService = ApartServiceImpl.getApartService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		
		System.out.println("apart/" + act);
		String path = "/index.jsp";
		Object object = null;
		
		switch (act) {
			case "mvapt":{
				path = "/apt.jsp";
				redirect(request, response, path);
				break;
			}
			
			case "mvapt2":{
				path = "/apt2.jsp";
				redirect(request, response, path);
				break;
			}
			
			case "mvland":{
				path = "/land.jsp";
				redirect(request, response, path);
				break;
			}
			
			case "getsido":{
				object = getSidoNames(request, response);
				break;
			}
			
			case "getgugun":{
				object = getGugunNames(request, response);
				break;
			}
			
			case "getdong":{
				object = getDongNames(request, response);
				break;
			}
			
			default :{
				redirect(request, response, path);
			}
		}
		
		if(object != null) {
			response.addHeader("Content-Type", "application/json; charset=UTF-8");
			
			// 응답 Payload 작성
			// 1. 객체를 JSON 문자열으로 직렬화
			ObjectMapper mapper = new ObjectMapper(); 
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
						
						// 2. 직렬화 한 문자열을 응답
			PrintWriter writer = response.getWriter();
			writer.write(json);
		}
	}

	private Object getDongNames(HttpServletRequest request, HttpServletResponse response) {
		String gugunCode = request.getParameter("gugunCode").substring(0, 5);
		
		try {
			Map<String, String> map = apartService.getDongNames(gugunCode);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private Object getGugunNames(HttpServletRequest request, HttpServletResponse response) {
		String sidoCode = request.getParameter("sidoCode").substring(0, 2);
		
		try {
			Map<String, String> map = apartService.getGugunNames(sidoCode);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private Object getSidoNames(HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, String> map = apartService.getSidoNames();
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
