package com.ssafy.live1.oop1.person;

// 클래스: 타입, 붕어빵 틀
public class Person {
	
	// 클래스 멤버 변수
	static String org = "SSAFY";
	
	// 인스턴스 멤버 변수 - 속성, 데이터
	String name;
	int age;
	boolean isHungry;
	
	// Alt + shift + s
	private Person(String name, int age, boolean isHungry) {
		this.name = name;
		this.age = age;
		this.isHungry = isHungry;
	}
	
	
	// 멤버 메서드 - 동작
	void eat() {
		System.out.println("냠냠");
		isHungry = false;
	}

	void work() {
		System.out.println("열심히...");
		isHungry = true;
	}
	
	void printInfo() {
		System.out.println(name + " : " + age + " : " + isHungry);
	}
}
