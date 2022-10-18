package com.ssafy.greeting;

import java.lang.reflect.InvocationTargetException;

public class Test {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		MyBeanFactory context = MyBeanFactory.getInstance();
		
		MessageService messageService = context.getBean("msg");
		
		messageService.sayHello();
	}
}
