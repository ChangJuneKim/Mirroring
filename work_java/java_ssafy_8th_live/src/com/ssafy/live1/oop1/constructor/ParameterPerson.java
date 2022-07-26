package com.ssafy.live1.oop1.constructor;

public class ParameterPerson {
	
	String name;
	int age;
	boolean isHungry;
	
	// 생성자의 역할 : member 변수의 초기화 ..
	public ParameterPerson(String name, int age, boolean isHungry) {
		this.name = name;
		this.age = age;
		this.isHungry = isHungry;
	}
	
	public static void main(String[] args) {
		ParameterPerson person  = new ParameterPerson("홍길동", 10, true);
		ParameterPerson p2 = new ParameterPerson();
	}
	
}
