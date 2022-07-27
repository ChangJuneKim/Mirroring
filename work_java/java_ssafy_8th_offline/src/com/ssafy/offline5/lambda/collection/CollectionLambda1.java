package com.ssafy.offline5.lambda.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 컬렉션에 람다식 적용 1
 */
public class CollectionLambda1 {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("김싸피");
		list.add("이싸피");
		list.add("박싸피");
		list.add("정싸피");
		
		// void forEach(Consumer<T> action) : 모든 요소에 작업 action을 수행
		list.forEach(name -> System.out.print(name + ", "));
		System.out.println();
		
		// boolean removeIf(Predicate<E> filter) : 조건에 맞는 요소를 삭제
		list.removeIf(name -> name.contains("이") || name.contains("박"));
		System.out.println(list);
		
		// void replaceAll(UnaryOperator<E> operator) : 모든 요소를 변환하여 대체
		list.replaceAll(name -> name + " 교육생");
		System.out.println(list);
	}
}
