package com.ssafy.offline5.lambda.composition;

import java.util.function.Function;
import java.util.function.Predicate;

public class CompositionLambda {
	
	/**
	 * Composition(합성, 결합)
	 */
	public static void main(String[] args) {
		
		/**
		 * Function Composition
		 */
		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);  // 16진수 문자열을 정수로 변환
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);  // 정수를 이진수 문자열로 변환
		
		// andThen : f 수행 후 g 수행
		Function<String, String> h = f.andThen(g);
		System.out.println(h.apply("A"));
		
		// compose : g 수행 후 f 수행
		Function<Integer, Integer> i = f.compose(g);
		System.out.println(i.apply(2));
		
		// identity : 항등 함수 (거의 사용되지 않는다.)
		Function<String, String> j = Function.identity();
		System.out.println(j.apply("안녕하세요."));
		
		/**
		 * Predicate Composition
		 */
		Predicate<Integer> overZero = (number) -> 0 <= number;
		Predicate<Integer> lessThanTen = (number) -> number < 10;
		Predicate<Integer> even = (number) -> number % 2 == 0;
		
		// and
		Predicate<Integer> and = overZero.and(lessThanTen);
		System.out.println(and.test(6));
		
		// or
		System.out.println(lessThanTen.or(even).test(12));
		System.out.println(lessThanTen.or(even).test(3));
		
		// negate (부정하다)
		System.out.println(lessThanTen.negate().test(20));
		
		// isEqual
		String name1 = "김싸피";
		String name2 = "김싸피";
		boolean isEqual = Predicate.isEqual(name1).test(name2);
		System.out.println(isEqual);
	}
	
}
