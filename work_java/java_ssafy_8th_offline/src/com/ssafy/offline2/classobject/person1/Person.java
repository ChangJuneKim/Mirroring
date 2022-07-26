package com.ssafy.offline2.classobject.person1;

public class Person {
	
	// 필드 (멤버변수) : 속성
	String name;
	int age;
	String job;
	String address;
	String gender;
	
	public Person() {
		System.out.println(name + "이(가) 탄생!!");
	}
	
	// 메서드 (멤버함수) : 행동
	void walk() {
		System.out.println(name + "이(가) 걷는다.");
	}
	
	void run() {
		System.out.println(name + "이(가) 달린다.");
	}
	
	void eat() {
		System.out.println(name + "이(가) 먹는다.");
	}
	
}
