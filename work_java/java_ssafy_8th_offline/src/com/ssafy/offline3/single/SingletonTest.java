package com.ssafy.offline3.single;

public class SingletonTest {
	public static void main(String[] args) {
		SingletonClass s1 = SingletonClass.getInstance();
		SingletonClass s2 = SingletonClass.getInstance();
		
		System.out.println(s1 == s2);
	}
}

