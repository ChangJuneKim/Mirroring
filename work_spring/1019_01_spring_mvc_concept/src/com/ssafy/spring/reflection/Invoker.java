package com.ssafy.spring.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.naming.java.javaURLContextFactory;

public class Invoker {
	
	public Object invoke(Object obj, String requestUrl, HttpServletRequest req, HttpServletResponse resp) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		// 클래스 정보 가져오기
		Class clazz = obj.getClass();
		
		// 해당 클래스에 존재하는 모든 메서드 목록 가져오기
		Method[] methods = clazz.getDeclaredMethods();
		
		for (Method method : methods) {
			if (method.isAnnotationPresent(SsafyRequestMapping.class)) {
				
				// SsafyRequestMapping 애노테이션 정보 가져오기
				SsafyRequestMapping anno = method.getAnnotation(SsafyRequestMapping.class);
				
				// 애노테이션의 value와 요청 URL 주소가 같다면 해당 메서드 호출
				if (anno.value().equals(requestUrl)) {
					return method.invoke(obj, req, resp);
				}
			}
		}
		
		return null;
	}
}
