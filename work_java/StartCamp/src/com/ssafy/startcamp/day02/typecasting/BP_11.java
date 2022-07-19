package com.ssafy.startcamp.day02.typecasting;

public class BP_11 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte b1 = 10;
		byte b2 = 20;
		// @@TODOINLINE: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
		// int를 byte로 수정할 수 없습니다.
//        byte b3 = b1 + b2;
//        byte b3 = (byte) (b1 + b2);
//        int b3 = b1 + b2;

		int i1 = 10;
		long l1 = 20;
		// @@TODOINLINE: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
		// long은 int로 수정할 수 없습니다
//        int i2 = i1 + l1;
		int i2 = i1 + (int) l1;

		// @@TODOINLINE: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
		// 기본이 더블이기때문에 발생하는 문제
//        float f = 10.0;
		float f1 = 10.0f;
		float f2 = f1 + 20.0f;
		
		
	}

	// 큰 타입은 작은 타입에 넣으면 손실이 발생하기 때문에 명시적으로 캐스팅을 해줘야한다.
}
