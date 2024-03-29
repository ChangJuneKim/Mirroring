package com.ssafy.spring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/servlet/*"})
public class DispatcherServlet extends HttpServlet {

	private ObjectMapper mapper = new ObjectMapper();
	
	// Spring MVC를 직접 만들기 위한 변수들
	private HandlerMapping handlerMapping;
	private HandlerAdapter handlerAdapter;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		handlerMapping = new HandlerMapping(getServletContext());
		handlerAdapter = new HandlerAdapter();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("getPathInfo: " + req.getPathInfo());
		System.out.println("getServletPath: " + req.getServletPath());

		SsafyInterceptor interceptor = new SsafyInterceptor();
		boolean isPass = interceptor.preHandle(req, resp);
		
		String path = null;  // 경로
		Object obj = null;  // REST 방식 응답을 위한 객체
		
		if (req.getPathInfo() == null || req.getPathInfo().equals("/") || isPass == false) {
			path = "/index.jsp";
			resp.sendRedirect(req.getContextPath() + path);
			return;
		}
		
		Object modelAndView = null;
		
		try {
//			Invoker invoker = new Invoker();
//			if (req.getPathInfo().startsWith("/board")) {
//				returnObj = invoker.invoke(boardController, req.getPathInfo(), req, resp);
//			}
//			else if (req.getPathInfo().startsWith("/user")) {
//				returnObj = invoker.invoke(userController, req.getPathInfo(), req, resp);
//			}
//			else if (req.getPathInfo().startsWith("/house") || req.getPathInfo().startsWith("/rest/house")) {
//				returnObj = invoker.invoke(houseDataRestController, req.getPathInfo(), req, resp);
//			}
			
			/**
			 * 1. URL과 매칭되는 컨트롤러 검색
			 */
			Object controller = handlerMapping.getController(req.getPathInfo());
			
			/**
			 * 2. HandlerAdapter에게 처리 요청
			 */
			modelAndView = handlerAdapter.process(controller, req.getPathInfo(), req, resp);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		// 각 Controller의 리턴 타입이 String이면 주소에 해당하는 페이지 응답
		if (modelAndView != null && modelAndView instanceof String) {
			path = (String) modelAndView;
		}
		else {  // 그 외에는 객체를 직렬화하여 응답
			obj = modelAndView;
		}

		if (path != null && path.startsWith("redirect:")) {
			resp.sendRedirect(path.split(":")[1]);
		}
		else if (path != null) {
			RequestDispatcher disp = req.getRequestDispatcher(path);
			disp.forward(req, resp);
		}
		else if (obj != null) {

			// 응답 헤더 작성 (Header)
			resp.addHeader("Content-Type", "application/json; charset=UTF-8");
			
			// Map을 JSON 문자열로 직렬화
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

			// 직렬화 한 문자열을 응답 (Payload)
			PrintWriter writer = resp.getWriter();
			writer.write(json);
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
}
