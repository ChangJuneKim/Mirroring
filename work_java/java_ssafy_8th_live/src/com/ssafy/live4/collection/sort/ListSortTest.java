package com.ssafy.live4.collection.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.management.relation.RoleUnresolvedList;

public class ListSortTest {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Hi", "Java", "World", "Welcome");
		
		Collections.sort(names);
		
		System.out.println(names);
		
		List<SmartPhone> phones = new ArrayList<>();
		phones.add(new SmartPhone("010-2112-2223"));
		phones.add(new SmartPhone("010-1111-2222"));
		phones.add(new SmartPhone("010-2111-2224"));
		phones.add(new SmartPhone("010-2111-2223"));
		
		Collections.sort(phones); // 정렬
		System.out.println(phones);
		
		Collections.reverse(phones); // 역순
		System.out.println(phones);
		
//		Collections.sort(names, new StringLengthComparator());
		
		// new 와 Comparator 사이에 class명 implements 가 생략되어 있다고 봄 (익명 클래스)
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		
		
		// 람다식 (o1, o2) 메서드의 파라메터 부분 (타입은 어디갔나?)
		// sort -> Comparator -> compare에 가보면 T o1, T o2로 명시되어 있기 때문에 타입추론? 비슷하게 되는듯
		// -> 화살표 뒤는 리턴문
		Collections.sort(names, (o1, o2)->{
			return Integer.compare(o1.length(), o2.length());
		});
		System.out.println(names);
		
		Calculator c = new Calculator() {
			@Override
			public Integer calc(Integer a, Integer b) {
				return a + b;
			}
		};
		
		Calculator c2 = new Calculator() {
			@Override
			public Integer calc(Integer a, Integer b) {
				return a - b;
			}
		};
		
		Integer result = c.calc(100, 50);
		System.out.println(result);
		
//		run(c);
		run((num1, num2) -> {
			return num1 + num2;
		});
		
//		run(c2);
		run((num1, num2) -> {
			return num1 - num2;
		});
		
	}
	
	public static void run(Calculator c) {
		System.out.println("계산하는 중...");
		Integer result = c.calc(200, 55);
		System.out.println("계산 결과 : " + result);
	}
}
