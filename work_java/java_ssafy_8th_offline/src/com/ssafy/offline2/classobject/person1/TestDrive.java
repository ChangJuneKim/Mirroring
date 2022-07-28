package com.ssafy.offline2.classobject.person1;

public class TestDrive {
	public static void main(String[] args) {
		Person changjune = new Person();
		changjune.name = "김창준";
		changjune.age = 29;
		changjune.job = "무직";
		changjune.gender = "M";
		changjune.address = "그린코아";

		changjune.walk();
		changjune.run();
		changjune.eat();

		System.out.printf("%s %d %s %s %s \n", changjune.name, changjune.age, changjune.job, changjune.gender,
				changjune.address);

		Person bokyung = new Person();
		bokyung.name = "보경";
		bokyung.age = 26;
		bokyung.gender = "남성";
		bokyung.job = "4반 부반장";
		bokyung.address = "부산시";

		bokyung.walk();
		bokyung.run();
		bokyung.eat();

		System.out.printf("%s %d %s %s %s \n", bokyung.name, bokyung.age, bokyung.job, bokyung.gender, bokyung.address);
	}
	
}

