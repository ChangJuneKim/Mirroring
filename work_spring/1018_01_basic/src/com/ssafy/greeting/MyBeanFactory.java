package com.ssafy.greeting;

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
			return service;
		}
		
		return null;
	}
}
