package com.ssafy.offline5.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 스트림의 중간연산
 */
public class IntermediateOperation {
	
	public static void main(String[] args) {
		
		List<Person> people = new ArrayList<>();
		people.add(new Person("김싸피", 29, "부울경"));
		people.add(new Person("이싸피", 28, "서울"));
		people.add(new Person("박싸피", 27, "대전"));
		people.add(new Person("최싸피", 30, "광주"));
		people.add(new Person("정싸피", 35, "구미"));
		people.add(new Person("김싸피", 35, "서울"));
		
		/**
		 *  1. 스트림 자르기
		 */
		people.stream()
			.skip(1) // 김싸피 스킵하고
			.limit(3) // 이싸피부터 3개만 (이싸피 박싸피 최싸피)
			.forEach(p -> System.out.print(p + ", "));  // 1개의 요소를 건너뛰고, 3개로 제한
		System.out.println();
		
		/**
		 *  2. 스트림 요소 걸러내기
		 */
		// distinct는 equals, hashcode 재정의 필요 !!
		people.stream()
			.distinct() // 중복을 허용하지 않음 (김싸피 중복 걸러냄)
			.forEach(person -> System.out.print(person + ", "));
		System.out.println();
		
		// filter : 나이가 30 이상인 사람
		people.stream()
			.filter(person -> person.getAge() >= 30)
			.forEach(person -> System.out.print(person + ", "));
		System.out.println();
		
		// filter : 나이가 30 이상이고 이름에 "정"이 포함된 사람
		people.stream()
			.filter(person -> person.getAge() >= 30)
			.filter(person -> person.getName().contains("정"))
			.forEach(person -> System.out.print(person + ", "));
		System.out.println();
		
		/**
		 *  3. 정렬
		 */
		// 사람을 나이순 정렬 후 이름순 정렬
		people.stream()
			.sorted(Comparator.comparing(Person::getAge) // 나이순 정렬 후
					.thenComparing(Person::getName)) // 이름 정렬
			.forEach(person -> System.out.print(person + ", "));
		System.out.println();
		
		/**
		 * 4. 변환
		 */
		// 사람의 이름에서 사용된 성씨만 출력
		people.stream()
			.map(Person::getName)  // 사람의 이름만 추출
			.map(name -> name.substring(0, 1))  // 이름에서 성씨만 추출
			.distinct()  // 중복 제거
			.forEach(person -> System.out.print(person + ", "));
		System.out.println();
		
		/**
		 * 5. 조회
		 */
		// 연산과 연산 사이에 사용하여 중간 결과를 확인할 때 사용
		people.stream()
			.map(Person::getName)  // 사람의 이름만 추출
			.peek(s -> System.out.print(s + " | "))
			.map(name -> name.substring(0, 1))  // 이름에서 성씨만 추출
			.peek(s -> System.out.print(s + " | "))
			.distinct()  // 중복 제거
			.forEach(person -> System.out.println(person));
		System.out.println();
		
		/**
		 * 6. mapToInt(), mapToLong(), mapToDouble()
		 */
		// 나이의 총합, 평균, 최대값, 최소값 구하기
		IntSummaryStatistics stat = people.stream().mapToInt(Person::getAge).summaryStatistics();
		long sum = stat.getSum();
		double avg = stat.getAverage();
		int max = stat.getMax();
		int min = stat.getMin();
		System.out.println(sum + " / " + avg + " / " + max + " / " + min);
	}
}
