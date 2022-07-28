package com.ssafy.live2.extend.person;

public class Person {
	public String name = "피터 파커";

	public Person(String name){
		this.name = name;
	}
	
	public void eat() {
		System.out.println("냠냠");
	}

	public void jump() {
		System.out.println("두 다리로 폴짝!");
	}

	// 오버로딩
	public void jump(String option) {
		System.out.println("두 다리로 " + option + "점프");
	}
	
	public String toString() {
		return "person :, name: " + this.name;
	}
}
