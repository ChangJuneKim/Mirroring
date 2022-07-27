package com.ssafy.offline5.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Overview {
	
	public static void main(String[] args) {
		
		// 1. 스트림을 사용하지 않고 데이터 정렬 (스트림 이전 방식)
		String[] sArray = { "박싸피", "김싸피", "이싸피" };
		List<String> sList = Arrays.asList(sArray);
		
		Arrays.sort(sArray);
		Collections.sort(sList);
		
		for (String s : sArray) {
			System.out.print(s + ", ");
		}
		System.out.println();
		
		for (String s : sList) {
			System.out.print(s + ", ");
		}
		System.out.println();
		
		// 2. 스트림을 활용하여 데이터 정렬
		// 스트림을 사용한 코드가 간결하고 이해하기 쉽다.
		sArray = new String[] { "박싸피", "김싸피", "이싸피" };
		sList = Arrays.asList(sArray);
		
		Stream<String> sStream1 = Arrays.stream(sArray);
		Stream<String> sStream2 = sList.stream();
		
		sStream1.sorted().forEach(item -> System.out.print(item + ", "));
		System.out.println();
		
		sStream2.sorted().forEach(item -> System.out.print(item + ", "));
		System.out.println();
		
		// 데이터 원본을 변경하지 않는다.
		System.out.println(Arrays.toString(sArray));
		System.out.println(sList);
		
		// 정렬된 결과를 새로운 List에 담고 싶을 때
		List<String> sortedList = sList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		
		// 스트림은 일회용이다.
//		System.out.println(sStream1.count());
		
	}
}
