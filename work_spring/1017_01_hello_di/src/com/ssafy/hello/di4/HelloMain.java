package com.ssafy.hello.di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
	public static void main(String[] args) {
		System.out.println("프로그램 시작===========");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/hello/di4/applicationContext.xml");
		System.out.println("xml 읽기 끝");
		HelloMessage message = (HelloMessage) context.getBean("kor");
		String greetKor = message.hello("안효인");
		System.out.println(greetKor);
		
		
		HelloMessage message2 = (HelloMessage) context.getBean("kor");
		
		HelloMessage message3 = (HelloMessage) context.getBean("kor");
	}
}
