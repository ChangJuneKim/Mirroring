package com.ssafy.offline2.classobject.person2;

public class Person {
	
	// 필드 (멤버변수) : 속성
	String name;
	int age;
	String job;
	String address;
	String gender;
	
	// 기본생성자 (다른 생성자가 존재하지 않으면, 컴파일러가 자동으로 생성)
	// 다른 생성자가 존재하면 기본생성자는 생성이 안됩니다.
	public Person() {
		
	}
	
	public Person(String name, int age, String job, String address, String gender) {
		this.name = name;
		this.age = age;
		this.job = job;
		this.address = address;
		this.gender = gender;
		
		System.out.println(this.name + "이(가) 탄생!!");
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
	
	void introduce() {
		System.out.println("이름: " + this.name + " / " + "나이: " + this.age + " / " + "주소: " + this.address);
	}
	
	// Alt + shift + S
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=").append(name).append(", age=").append(age).append(", job=").append(job)
				.append(", address=").append(address).append(", gender=").append(gender).append("]");
		return builder.toString();
	}
}
