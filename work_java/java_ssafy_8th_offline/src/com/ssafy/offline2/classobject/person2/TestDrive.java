package com.ssafy.offline2.classobject.person2;

public class TestDrive {
	public static void main(String[] args) {
		Person changjune = new Person("김창준", 29, "무직", "그린코아", "M");

//		changjune.walk();
//		changjune.run();
//		changjune.eat();
//		changjune.introduce();
		System.out.println(changjune);
//		System.out.println(changjune.toString());
		Person bokyung = new Person("보경", 26, "부반장", "하단", "M");

		bokyung.walk();
		bokyung.run();
		bokyung.eat();
		bokyung.introduce();
	}

}
