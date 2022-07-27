package com.ssafy.offline5.lambda.basic2;

/**
 * 함수형 인터페이스를 작성하여 람다식 활용
 */
public class LambdaTest {

	public static void main(String[] args) {
		// 1.
		System.out.println(highOrderFunction((x, y) -> x + y, 20, 30));
		System.out.println(sumFunction());

		/**
		 * 매개변수 없는 경우
		 */

		// 2-1. 매개변수 없음. 반환 값 없음.
		NoParam helloWorld = () -> System.out.println("Hello World!");
		helloWorld.invoke();

		// 2-2.
		NoParam nested1 = () -> System.out.println("nested1");
		NoParam nestedLambda = () -> nested1.invoke();
		nestedLambda.invoke();

		// 3. 매개변수 없음. 반환 값 있음.
		NoParamReturn supplyFood = () -> "스테이크 생성";
		System.out.println(supplyFood.invoke());

		/**
		 * 매개변수 1개
		 */

		// 4. 매개변수 1개. 반환 값 없음.
		OneParam consumeFood = (food) -> System.out.println(food + "를 먹었습니다.");
		consumeFood.invoke("스테이크");

		// 5. 매개변수 1개. 반환 값 있음.
		OneParamReturn ourSelfSum = (a) -> a + a;
		System.out.println(ourSelfSum.invoke(10));

		// 6. 매개변수 1개. 반환 값 있음(boolean, 조건식을 표현하는데 사용)
		OneParamBooleanReturn lessThanTen = (number) -> number < 10;
		System.out.println(lessThanTen.invoke(100));

		/**
		 * 매개변수 2개
		 */

		// 7. 매개변수 2개. 반환 값 없음
		TwoParam consumeFood2 = (food, quantity) -> System.out.println(food + "를 " + quantity + "개 먹었습니다.");
		consumeFood2.invoke("스테이크", 5);

		// 8. 매개변수 2개. 반환 값 있음
		TwoParamReturn multiply = (x, y) -> x * y;
		System.out.println(multiply.invoke(8, 8));

		// 9. 매개변수 2개. 반환 값 있음(boolean, 조건식을 표현하는데 사용)
		TwoParamBooleanReturn lessThan = (number, base) -> number < base;
		System.out.println(lessThan.invoke(9, 10));

	}

	private static int highOrderFunction(TwoParamReturn sum, int a, int b) {
		return sum.invoke(a, b);
	}

	private static int sum(int a, int b) {
		return a + b;
	}

	private static int sumFunction() {
		return sum(40, 2);
	}
}
