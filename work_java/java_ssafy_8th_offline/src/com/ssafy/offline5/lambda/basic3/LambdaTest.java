package com.ssafy.offline5.lambda.basic3;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java.util.function 패키지 활용
 */
public class LambdaTest {

	public static void main(String[] args) {

		// 1.
		System.out.println(highOrderFunction((x, y) -> x + y, 20, 30));
		System.out.println(sumFunction());

		/**
		 * 매개변수 없는 경우
		 */
		// 매개변수가 없고 반환 값이 없을 때는 Runnable 인터페이스를 사용하고, 함수를 실행시킬때는 .run() 을 사용
		// 매개변수가 없고, 반환 값이 있을 때는 Suppiler<T> 인터페이스를 사용하고, 함수를 실행시킬때는 .get()을 사용
		
		// 2-1. Runnable | void run() | 매개변수 없음. 반환 값 없음.  
		Runnable helloWorld = () -> System.out.println("Hello World!");
		helloWorld.run();

		// 2-2.
		Runnable nested1 = () -> System.out.println("nested1");
		Runnable nestedLambda = () -> nested1.run();
		nestedLambda.run();

		// 3. Supplier<T> | T get() | 매개변수 없음. 반환 값 있음.
		Supplier<String> supplyFood = () -> "스테이크 생성";
		System.out.println(supplyFood.get());

		/**
		 * 매개변수 1개
		 */

		// 4. Consumer<T> | void accept(T t) | 매개변수 1개. 반환 값 없음.
		Consumer<String> consumeFood = (food) -> System.out.println(food + "를 먹었습니다.");
		consumeFood.accept("스테이크");

		// 5. Function<T, R> | R apply(T t) | 매개변수 1개. 반환 값 있음.
		Function<Integer, Integer> ourSelfSum = (a) -> a + a;
		System.out.println(ourSelfSum.apply(10));

		// 6. Predicate<T> | boolean test(T t) | 매개변수 1개. 반환 값 있음(boolean, 조건식을 표현하는데 사용)
		Predicate<Integer> lessThanTen = (number) -> number < 10;
		System.out.println(lessThanTen.test(100));

		/**
		 * 매개변수 2개
		 */

		// 7. BiConsumer<T, U> | void accept(T t, U u) | 매개변수 2개. 반환 값 없음
		BiConsumer<String, Integer> consumeFood2 = (food, quantity) -> System.out.println(food + "를 " + quantity + "개 먹었습니다.");
		consumeFood2.accept("스테이크", 5);

		// 8. BiFunction<T, U, R> | R apply(T t, U u) | 매개변수 2개. 반환 값 있음
		BiFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;
		System.out.println(multiply.apply(8, 8));

		// 9. BiPredicate<T, U> | boolean test(T t, U u) | 매개변수 2개. 반환 값 있음(boolean, 조건식을 표현하는데 사용)
		BiPredicate<Integer, Integer> lessThan = (number, base) -> number < base;
		System.out.println(lessThan.test(9, 10));

	}

	private static int highOrderFunction(BiFunction<Integer, Integer, Integer> sum, int a, int b) {
		return sum.apply(a, b);
	}

	private static int sum(int a, int b) {
		return a + b;
	}

	private static int sumFunction() {
		return sum(40, 2);
	}
}
