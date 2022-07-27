package com.ssafy.offline5.lambda.basic1;

// 함수형 인터페이스 (람다식을 다루기 위한 인터페이스)
// 제약조건: 오직 하나의 추상 메서드만 정의되어 있어야 한다.
// static 메서드와 default 메서드의 개수에는 제약이 없다.

@FunctionalInterface
public interface MyFunction {
	public abstract int max(int a, int b);
}
