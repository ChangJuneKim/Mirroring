package com.ssafy.offline5.lambda.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 컬렉션에 람다식 적용 2
 */
public class CollectionLambda2 {

	public static void main(String[] args) {		

		Map<String, Integer> map = new HashMap<>();
		map.put("김싸피", 24);
		map.put("이싸피", 25);
		map.put("박싸피", 26);
		map.put("정싸피", 30);

		// void forEach(BiConsumer<K, V> action) : 모든 요소에 작업 action을 수행
		map.forEach((key, value) -> System.out.print(key + ":" + value + ", "));
		System.out.println();

		// void replaceAll(BiFunction<K, V, V> f) : 모든 요소에 치환작업 f를 수행
		map.replaceAll((key, value) -> value + 1);  // 한 살씩 먹었다고 가정
		System.out.println(map);

		// V compute(K key, BiFunction<K, V, V> f) : 지정된 키의 값에 작업 f를 수행
		int age = map.compute("김싸피", (key, value) -> value + 10);  // 10년 후 김싸피의 나이는?
		System.out.println(age);

		// V computeIfAbsent(K key, Function<K, V> f) : 키가 없으면 작업 f 수행 후 추가
		age = map.computeIfAbsent("홍길동", (key) -> 1);  // 홍길동이 없다면 1살로 추가
		System.out.println(age);
		System.out.println(map);

		// V computeIfPresent(K key, BiFunction<K, V, V> f) : 지정된 키가 있을 때 작업 f를 수행
		age = map.computeIfPresent("홍길동", (key, value) -> value + 20);  // 홍길동이 존재하면 20살 추가
		System.out.println(age);
		System.out.println(map);

		// V merge(K key, V value, BiFunction<V, V, V> f) : 모든 요소에 병합작업 f를 수행
		age = map.merge("홍길동", 10, (original, newValue) -> original + newValue);
		System.out.println(age);
		System.out.println(map);
		
		// merge 응용
		Map<String, Integer> sanghoon = new HashMap<>();
		sanghoon.put("Java", 100);
		sanghoon.put("HTML", 90);
		sanghoon.put("CSS", 80);
		sanghoon.put("JavaScript", 70);
		
		Map<String, Integer> mongryong = new HashMap<>();
		mongryong.put("Java", 61);
		mongryong.put("HTML", 72);
		mongryong.put("CSS", 83);
		mongryong.put("JavaScript", 94);
		
		// 같은 Key끼리의 Value 합을 구한 뒤 sanghoon Map에 저장
		mongryong.forEach((key, value) -> {
			sanghoon.merge(key, value, (mValue, sValue) -> {
				return mValue + sValue;
			});
		});
		System.out.println(sanghoon);
	}
}
