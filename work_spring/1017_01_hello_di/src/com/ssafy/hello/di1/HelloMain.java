package com.ssafy.hello.di1;

public class HelloMain {
	public static void main(String[] args) {
		HelloMessageKor kor = new HelloMessageKor();
		String greetKor = kor.helloKor("안효인");
		System.out.println(greetKor);
		
		HelloMessageEng eng = new HelloMessageEng();
		String greetEng = eng.helloEng("Ahn");
		System.out.println(greetEng);
	}
}
