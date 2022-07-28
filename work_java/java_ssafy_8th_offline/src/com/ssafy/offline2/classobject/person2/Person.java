package com.ssafy.offline2.classobject.person2;

public class Person {

	// 필드 (멤버 변수) : 속성
	int age;
	String name;
	String job;
	String address;
	String gender;

	// 기본 생성자 : 다른 생성자가 존재하지 않으면, 컴파일러가 자동으로 생성
	// 다른 생성자가 존재하면 기본 생성자는 생성이 되지않는다.
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

	// 메서드 : 행동
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
		System.out.println("이름" + name);
		System.out.println("나이" + age);
		System.out.println("직업" + job);
		System.out.println("주소" + address);
		System.out.println("성별" + gender);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [age=").append(age).append(", name=").append(name).append(", job=").append(job)
				.append(", address=").append(address).append(", gender=").append(gender).append("]");
		return builder.toString();
	}

}
