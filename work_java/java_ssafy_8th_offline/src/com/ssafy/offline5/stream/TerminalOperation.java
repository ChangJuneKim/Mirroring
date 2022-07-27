package com.ssafy.offline5.stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 스트림의 최종 연산
 */
public class TerminalOperation {

	public static void main(String[] args) {

		List<Person> people = new ArrayList<>();
		people.add(new Person("김싸피", 29, "부울경"));
		people.add(new Person("이싸피", 28, "서울"));
		people.add(new Person("박싸피", 27, "대전"));
		people.add(new Person("최싸피", 30, "광주"));
		people.add(new Person("정싸피", 35, "구미"));
		people.add(new Person("김싸피", 35, "서울"));

		/**
		 * 1. forEach()
		 */
		// 앞에서 자주 사용해 봤으므로 생략

		/**
		 * 2. 조건 검사 : allMatch(), anyMatch(), noneMatch(), findFirst(), findAny()
		 */
		// 30살 미만의 사람이 있는지 확인
		boolean isLessThan30 = people.stream().anyMatch(p -> p.getAge() < 30);
		System.out.println(isLessThan30);

		// 30살 미만의 사람 중 첫번째 사람
		Optional<Person> findFirstPerson = people.stream().filter(p -> p.getAge() < 30).findFirst();
		System.out.println(findFirstPerson.get());

		// parallelStream일 경우는 findAny 사용 (데이터 양이 많을 때는 parallelStream 사용)
		Optional<Person> findAnyPerson = people.parallelStream().filter(p -> p.getAge() < 30).findAny();
		System.out.println(findAnyPerson.get());

		/**
		 * 3. 통계 : count(), sum(), average(), max(), min()
		 */
		// IntStream과 같은 기본형 스트림에서 호출 가능
		int count1 = (int) people.stream().count();
		int sum1 = people.stream().mapToInt(Person::getAge).sum();
		double avg1 = people.stream().mapToDouble(Person::getAge).average().getAsDouble();
		int max1 = people.stream().mapToInt(Person::getAge).max().getAsInt();
		int min1 = people.stream().mapToInt(Person::getAge).min().getAsInt();

		System.out.println(count1);
		System.out.println(sum1);
		System.out.println(avg1);
		System.out.println(max1);
		System.out.println(min1);

		/**
		 * 4. 리듀싱 : reduce() 스트림의 요소를 줄여나가면서 연산을 수행하고 최종결과 반환 매개변수가 BinaryOperator<T>인
		 * 이유 (두 요소를 하나의 요소로 리턴) 처음 두 요소를 가지고 연산한 결과를 가지고 그 다음 요소와 연산
		 */
		// 리듀싱을 활용하여 사람들의 수, 총합, 최대값, 최소값 구하기
		// (앞에서 설명한 3. 통계 메서드를 사용하는게 낫다.)
		int count = people.stream().mapToInt(Person::getAge).reduce(0, (a, b) -> a + 1);
		int sum = people.stream().mapToInt(Person::getAge).reduce(0, (a, b) -> a + b);
		int max = people.stream().mapToInt(Person::getAge).reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
		int min = people.stream().mapToInt(Person::getAge).reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
		System.out.println(count + " / " + sum + " / " + max + " / " + min);

		/**
		 * 5. 스트림을 컬렉션과 배열로 변환
		 */
		List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());
		Set<String> set = people.stream().map(Person::getName).collect(Collectors.toSet());
		Map<String, Integer> map = people.stream().distinct()
				.collect(Collectors.toMap(Person::getName, Person::getAge));

		// 특정 컬렉션으로 변환
		LinkedList<String> linkedList = people.stream().map(Person::getName)
				.collect(Collectors.toCollection(LinkedList::new));

		// 배열로 변환
		Person[] pArray = people.stream().toArray(Person[]::new);
	}

}
