package com.ssafy.offline5.lambda.basic4;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * java.util.function 패키지 활용
 * UnaryOperator, BinaryOperator
 */
public class LambdaTest {

	public static void main(String[] args) {

		System.out.println(highOrderFunction((x, y) -> x + y, 20, 30));
		System.out.println(sumFunction());

		/**
		 * 매개변수 없는 경우
		 */

		Runnable helloWorld = () -> System.out.println("Hello World!");
		helloWorld.run();

		Runnable nested1 = () -> System.out.println("nested1");
		Runnable nestedLambda = () -> nested1.run();
		nestedLambda.run();

		Supplier<String> supplyFood = () -> "스테이크 생성";
		System.out.println(supplyFood.get());

		/**
		 * 매개변수 1개
		 */

		Consumer<String> consumeFood = (food) -> System.out.println(food + "를 먹었습니다.");
		consumeFood.accept("스테이크");

		
//		// 5. Function<T, R> | R apply(T t) | 매개변수 1개. 반환 값 있음.
//		Function<Integer, Integer> ourSelfSum = (a) -> a + a;
//		System.out.println(ourSelfSum.apply(10));
		
		// 5. UnaryOperator<T> | T apply(T t) | 매개변수 1개. 반환 값 있음. (매개변수, 반환 값 타입 같음)
		UnaryOperator<Integer> ourSelfSum = (a) -> a + a;
		System.out.println(ourSelfSum.apply(10));

		Predicate<Integer> lessThanTen = (number) -> number < 10;
		System.out.println(lessThanTen.test(100));

		/**
		 * 매개변수 2개
		 */

		BiConsumer<String, Integer> consumeFood2 = (food, quantity) -> System.out.println(food + "를 " + quantity + "개 먹었습니다.");
		consumeFood2.accept("스테이크", 5);

		// 8. BinaryOperator<T> | T apply(T t1, T t2) | 매개변수 2개. 반환 값 있음. (매개변수, 반환 값 타입 같음)
		BinaryOperator<Integer> multiply = (x, y) -> x * y;
		System.out.println(multiply.apply(8, 8));

		BiPredicate<Integer, Integer> lessThan = (number, base) -> number < base;
		System.out.println(lessThan.test(9, 10));

	}

	private static int highOrderFunction(BinaryOperator<Integer> sum, int a, int b) {
		return sum.apply(a, b);
	}

	private static int sum(int a, int b) {
		return a + b;
	}

	private static int sumFunction() {
		return sum(40, 2);
	}
}
