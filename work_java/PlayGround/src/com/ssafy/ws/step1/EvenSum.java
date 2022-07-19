package com.ssafy.ws.step1;

import java.util.Scanner;

public class EvenSum {

	public static void main(String[] args) {

		System.out.print("숫자 입력 >> ");
		
		Scanner scanner = new Scanner(System.in);
		
		int inputNumber = scanner.nextInt();
		
		int answer = 0;
		for(int i = 1; i <= inputNumber; i++) {
			if(i % 2 == 0) {
				answer += i;
			}
		}
		
		System.out.printf("1부터 %d까지 수 중 짝수의 합 = %d", inputNumber, answer);
	}

}

