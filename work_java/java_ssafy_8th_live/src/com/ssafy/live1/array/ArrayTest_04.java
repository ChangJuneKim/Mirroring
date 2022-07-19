package com.ssafy.live1.array;

import java.util.Arrays;

public class ArrayTest_04 {
	public static void main(String[] args) {

		String org = "SSAFY";
		// TODO: char []을 이용해 String org의 각 문자를 저장하고 출력하는 코드를 작성하시오.
		// END:
		
		char[] chars = new char[org.length()];
		
		for(int i = 0; i < chars.length; i++) {
			chars[i] = org.charAt(i);
		}
		
		System.out.println(Arrays.toString(chars));
		
		// 쉬운방법
		char[] useToCharArray = org.toCharArray();
		System.out.println(Arrays.toString(useToCharArray));
	}
}
