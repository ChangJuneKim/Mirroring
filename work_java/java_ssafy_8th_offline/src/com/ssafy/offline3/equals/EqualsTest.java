package com.ssafy.offline3.equals;

public class EqualsTest {
	
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = obj2;
		
		System.out.printf("obj1 == obj2: %b%n", obj1 == obj2);
		System.out.printf("obj1 equals obj2: %b%n", obj1.equals(obj2));
		
		System.out.printf("obj2 == obj3: %b%n", obj2 == obj3);
		System.out.printf("obj2 equals obj3: %b%n", obj2.equals(obj3));
		
		testString();
		testPhone();
		testUser();
		
		Integer a = 10;
	}
	
	private static void testUser() {
		User u1 = new User("ssafy1", "s1111", "김싸피", "ssafy1@ssafy.com", 30);
		User u2 = new User("ssafy1", "s2222", "박싸피", "ssafy2@ssafy.com", 30);
		Phone p1 = new Phone("01012345678");
		System.out.println((u1 == u2) + " : " + u1.equals(null));
	}

	private static void testString() {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println((s1 == s2) + " : " + s1.equals(s2));
	}
	
	private static void testPhone() {
		// 클래스 명에다가 커서를 두고 ctrl + 1
		Phone p1 = new Phone("01000000000");
		Phone p2 = new Phone("01000000000");
		System.out.println((p1 == p2) + " : " + p1.equals(p2));
	}
}
