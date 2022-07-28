package com.ssafy.live1.oop1.constructor;

public class ParameterPerson {
	
	// 필드 (멤버변수)
	String name;
	int age;
	boolean isHungry;
	
	// 기본 생성자
	public ParameterPerson() {}
	
	// alt + shift + s 생성자 만드는 단축키
	public ParameterPerson(String name, int age, boolean isHungry) {
		this.name = name;
		this.age = age;
		this.isHungry = isHungry;
	}

	public static void main(String[] args) {
		ParameterPerson person = new ParameterPerson("홍길동", 29,true);
		ParameterPerson p2 = new ParameterPerson();
	}
}
