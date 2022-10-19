package com.ssafy.spring;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

public class HandlerMapping {
	
	// handler.prop 파일 내용을 저장할 자료구조
	private Map<String, Object> controllerMap = new HashMap<>();
	
	public HandlerMapping(ServletContext context) {
		
		String config = context.getInitParameter("contextConfigLocation");
		String configPath = context.getRealPath(config);
		
		try (FileReader fr = new FileReader(configPath)) {
			
			Properties prop = new Properties();
			prop.load(fr);
			
			for (Object obj : prop.keySet()) {
				String path = (String) obj;
				String controllerName = prop.getProperty(path);
				
				//new BoardController();
				Class<?> controllerClass = Class.forName(controllerName);
				Object instance = controllerClass.newInstance();
				controllerMap.put(path, instance);  // 원래는 스프링 컨테이너에 컨트롤러 빈이 존재하지만, 여기서는 간략하게 만들기 위해 이렇게 저장
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getController(String pathInfo) {
		
		for (String key : controllerMap.keySet()) {
			if (pathInfo.startsWith(key)) {
				Object controller = controllerMap.get(key);
				return controller;
			}
		}
		
		return null;
	}
}
