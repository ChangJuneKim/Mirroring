package com.ssafy.offline5.lambda.basic1;

public class FunctionalProgramming {
	
	public static void main(String[] args) {
		
		// 1-1. 익명 클래스의 익명 객체 생성
		/*MyFunction f = new MyFunction() {

			@Override
			public int max(int a, int b) {
				return a > b ? a : b;
			}
			
		};*/
		
		// 1-2. 람다식으로 익명 객체 생성
		// max 메서드의 선언부와 람다식의 매개변수의 타입, 개수 그리고 반환 값이 일치하므로 가능
		MyFunction f = (int a, int b) -> a > b ? a : b;
		
		int big = f.max(5, 3);  // 익명 객체의 메서드를 호출
		System.out.println(big);
		
		// 2-1.
		MyFunction2 test = () -> System.out.println("test");
		function(test);
		
		// 2-2.
		function(() -> System.out.println("test"));
		
		// 3-1. 변수명 = 람다식 매개변수 -> { 구현/리턴 내용 };
		Sum sum0 = (int x1, int x2) -> { return x1 + x2; };
		
		// 3-2. 구현 내용이 한 줄일 경우 return 키워드 생략 가능
		Sum sum1 = (int x1, int x2) -> x1 + x2;
		
		// 3-3. 구현 내용이 여러 줄일 경우
		Sum sum2 = (int x1, int x2) -> {
			System.out.println(x1 + x2);
			return x1 + x2;
		};
		
		// 3-4. 데이터 추론 가능 매개변수 데이터타입 생략 가능
		Sum sum3 = (x1, x2) -> x1 + x2;
	}
	
	public static void function(MyFunction2 f) {
		f.invoke();
	}
	
	// 일반함수
	public static int sum(int x1, int x2) {
		return x1 + x2;
	}
}
