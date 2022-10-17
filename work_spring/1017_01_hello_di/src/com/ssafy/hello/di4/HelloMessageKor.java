package com.ssafy.hello.di4;

public class HelloMessageKor implements HelloMessage{

	public HelloMessageKor() {
		System.out.println("HelloMessageKor 객체 만들었다");
	}
	
	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "안녕 " + name; 
	}
}
