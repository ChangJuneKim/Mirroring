package com.ssafy.live4.exception;


public class SimpleException {
	
	static boolean isDebug = true;
	
	public static void main(String[] args) {
		int[] intArray = {10};
		try {
			System.out.println(intArray[2]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("예외가 발생한 인덱스 번호: " + e.getMessage());
			System.out.println(intArray[intArray.length - 1]);

			if (isDebug == true) {
				e.printStackTrace();
			}
			System.out.println("프로그램 종료합니다.");
		}
	}
}
