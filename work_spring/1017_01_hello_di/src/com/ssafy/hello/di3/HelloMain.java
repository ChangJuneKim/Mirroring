package com.ssafy.hello.di3;

public class HelloMain {
	public static void main(String[] args) {
		HelloMessage message = HelloMessageFactory.getHelloMessage("kor");
		String greetKor = message.hello("안효인");
		System.out.println(greetKor);
		
	}
}
