package com.ssafy.offline3.single;

public class SingletonTest {
	
	public static void main(String[] args) {
		SingletonClass s1 = SingletonClass.getInstance();
		SingletonClass s2 = SingletonClass.getInstance();
		
		if (s1 == s2) {
			System.out.println("s1 객체와 s2 객체는 같다.");
		}
		else {
			System.out.println("s1 객체와 s2 객체는 다르다.");
		}
	}
}
