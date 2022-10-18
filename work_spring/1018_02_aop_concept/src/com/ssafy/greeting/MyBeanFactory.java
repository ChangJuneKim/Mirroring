package com.ssafy.greeting;

import com.ssafy.greeting.aop.LogAspect;
import com.ssafy.greeting.aop.MessageProxy;

public class MyBeanFactory {
	
	private MyBeanFactory() {}
	
	private static MyBeanFactory instance;
	
	public static MyBeanFactory getInstance() {
		if(instance == null) {
			instance = new MyBeanFactory();
		}
		return instance;
	}
	
	public MessageService getBean(String name) {
		if("msg".contentEquals(name)) {
			MessageService service = new MessageServiceImpl();
			service = new MessageProxy(service, new LogAspect());
			return service;
		}
		
		return null;
	}
}
