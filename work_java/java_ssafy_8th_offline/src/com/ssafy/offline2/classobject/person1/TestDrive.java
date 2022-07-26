package com.ssafy.offline2.classobject.person1;

public class TestDrive {
	
	public static void main(String[] args) {
		int a = 10;
		Person sanghoon = new Person();
		sanghoon.name = "정상훈";
		sanghoon.age = 37;
		sanghoon.gender = "남성";
		sanghoon.job = "교수";
		sanghoon.address = "부산 강서구 명지동";
		
		sanghoon.walk();
		sanghoon.run();
		sanghoon.eat();
		
		System.out.println(sanghoon.age + " / " + sanghoon.gender + " / " + sanghoon.address);
		
		Person bokyung = new Person();
		bokyung.name = "김보경";
		bokyung.age = 26;
		bokyung.gender = "남성";
		bokyung.job = "교육생";
		bokyung.address = "하단";
		
		bokyung.walk();
		bokyung.run();
		bokyung.eat();
		
		System.out.println(bokyung.age + " / " + bokyung.gender + " / " + bokyung.address);
	}
}
