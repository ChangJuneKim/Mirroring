package com.ssafy.live1.oop1.person;

// Person을 사용하는 주체
public class PersonTest {

	public static void main(String[] args) {
		Person person = new Person();
		person.name = "홍길동";
		person.age = 20;
		person.isHungry = true;
		
		person.printInfo();
	}

}
