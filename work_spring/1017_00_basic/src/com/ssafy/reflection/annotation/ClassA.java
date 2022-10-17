package com.ssafy.reflection.annotation;

public class ClassA {
	
	@Order(number = 1)
	public void first() {
		System.out.println("first");
	}
	
	@Order(number = 2)
	public void second() {
		System.out.println("second");
	}
	
	@Order(number = 3)
	public void third() {
		System.out.println("third");
	}
}
