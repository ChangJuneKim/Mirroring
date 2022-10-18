package com.ssafy.greeting;

public class Test {
	public static void main(String[] args) {
		
		MyBeanFactory context = MyBeanFactory.getInstance();
		
		MessageService messageService = context.getBean("msg");
		messageService.sayHello();
	}
}
