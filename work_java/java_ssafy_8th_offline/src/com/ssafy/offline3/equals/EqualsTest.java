package com.ssafy.offline3.equals;

import java.util.function.*;

public class EqualsTest {
	
	private static void testString() {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		Consumer<Object> print = System.out::println;
		print.accept("hello");
		
//		System.out.println((s1 == s2) + " : " + s1.equals(s2));
	}
	
	private static void testPhone() {
		Phone p1 = new Phone("01000000000");
		Phone p2 = new Phone("01000000000");
		
//		System.out.println((p1 == p2) + " : " + p1.equals(p2));
	}
	
	private static void testUser() {
		User user1 = new User("user2", "user2", "박싸피", "ssafy2@ssafy.com", 28);
		User user2 = new User("user2", "user2", "박싸피", "ssafy2@ssafy.com", 28);
		Phone phone1 = new Phone("01012345678");
		System.out.println((user1 == user2) + " : " + user1.equals(user2));
//		System.out.println(user1.equals(phone1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = obj2;
		
//		System.out.printf("obj1 == obj2 : %b%n", obj1==obj2);
//		System.out.printf("obj1 equals obj2 : %b%n", obj1.equals(obj2));
//		System.out.printf("obj2 == obj3 : %b%n", obj2==obj3);
//		System.out.printf("obj2 equals obj3 : %b%n", obj2.equals(obj3));
//		
		testString();
		testPhone();
		testUser();
	}

	

}
