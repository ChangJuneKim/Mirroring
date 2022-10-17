package com.ssafy.hello.di4;

public class HelloMessageEng implements HelloMessage{
	
	
	public HelloMessageEng() {
		System.out.println("HelloMessageEng 객체 만들었다");
	}
	
	public void init() {
		System.out.println("Eng 객체를 초기화");
	}
	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "Hello " + name;
	}
}
