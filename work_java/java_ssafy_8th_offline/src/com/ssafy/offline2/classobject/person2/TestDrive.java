package com.ssafy.offline2.classobject.person2;

public class TestDrive {
	
	public static void main(String[] args) {
		int a = 10;
		Person sanghoon = new Person("정상훈", 37, "부산 강서구 명지동", "교수", "남성");
		
		sanghoon.walk();
		sanghoon.run();
		sanghoon.eat();
		
		sanghoon.introduce();
		System.out.println(sanghoon.toString());
		
		Person bokyung = new Person("김보경", 26, "하단", "교육생", "남성");
		
		bokyung.walk();
		bokyung.run();
		bokyung.eat();
		
		bokyung.introduce();
		System.out.println(bokyung);
	}
}
