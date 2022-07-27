package com.ssafy.offline5.lambda.methodref;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 람다식이 하나의 메서드만 호출하는 경우에는 메서드 참조 사용 가능
 * 메서드 참조는 람다식을 더욱 간결하게 표현하는 방법
 */
public class MethodReference {
	
	public static void main(String[] args) {
		
		// 1.
		Function<String, Integer> f1 = (s) -> Integer.parseInt(s);  // 람다식
		Function<String, Integer> f2 = Integer::parseInt;  // 메서드 참조
		System.out.println(f1.apply("100") + f2.apply("200"));
		
		// 2.
		Person p1 = new Person("김싸피", 30);
		Person p2 = new Person("김싸피", 35);
		BiFunction<Person, Person, Boolean> g1 = (s1, s2) -> s1.equals(s2);  // 람다식
		BiFunction<Person, Person, Boolean> g2 = Person::equals;  // 메서드 참조
		System.out.println(g1.apply(p1, p2) + ", " + g2.apply(p1, p2));
		
		// 3.
		Function<Person, Boolean> h1 = (x) -> p1.equals(x);  // 람다식
		Function<Person, Boolean> h2 = p1::equals;  // 메서드 참조
		System.out.println(h2.apply(p2));
		
		// 4.
		BiFunction<String, Integer, Person> i1 = (name, age) -> new Person(name, age);  // 람다식
		BiFunction<String, Integer, Person> i2 = Person::new;  // 메서드 참조
		Person p3 = i2.apply("이싸피", 27);
		System.out.println(p3);
		
		// 5.
		Function<Integer, int[]> j1 = length -> new int[length];  // 람다식
		Function<Integer, int[]> j2 = int[]::new;  // 메서드 참조
		int[] arr = j2.apply(5);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i * 10;
		}
		System.out.println(Arrays.toString(arr));
	}
	
}

class Person {
	String name;
	Integer age;
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Person) {
			Person p = (Person) obj;
			if (this.name.equals(p.name)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
	
}
