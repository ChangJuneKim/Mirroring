package com.ssafy.live1.oop1.person;

// Person을 사용하는 주체
public class PersonTest {
	
	public static void main(String[] args) {
		Person.org = "SSAFY2";
		
		// 붕어빵틀 -> 붕어빵
		Person p = new Person("홍길동", 30, true);
		p.name = "홍길동";
		p.age = 30;
		p.isHungry = true;
		p.eat();
		System.out.println(p.name + " : " + p.isHungry + " : " + Person.org);
		
		Person p2 = new Person("장길산", 0, false);
		p2.name = "장길산";
		System.out.println(p2.name + " : " + p2.isHungry + " : " + p2.org);
		
		p2.printInfo();
		p.printInfo();
	}
}
