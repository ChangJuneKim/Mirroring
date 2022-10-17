package com.ssafy.hello.di2;

public class HelloMain {
	public static void main(String[] args) {
		HelloMessage kor = new HelloMessageKor();
		String greetKor = kor.hello("안효인");
		System.out.println(greetKor);
		
		HelloMessage eng = new HelloMessageEng();
		String greetEng = eng.hello("Ahn");
		System.out.println(greetEng);
	}
}
