package com.ssafy.live1.basic;

public class BP_11 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte b1 = 10;
		byte b2 = 20;
		// TODO: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
		byte b3 = (byte) (b1 + b2);
		System.out.println(b3);

		int i1 = 10;
		long l1 = 20;
		// TODO: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
		int i2 = (int) (i1 + l1);
		System.out.println(i2);

		// TODO: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
		float f1 = 10.0f; 
		float f2 = f1 + 20.0f;
		System.out.println(f2);
	}

}
