package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProfessorSolution {
	int N;
	StringBuilder sb = new StringBuilder("");
	
	private boolean isPrime(int number) {
		if(number < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private void appendNumber(int seed) {
		if(String.valueOf(seed).length() == N) {
			sb.append(seed).append("\n");
		}
		
		for (int i = 0; i < 10; i++) {
			int testNum = seed * 10 + i;
			if(isPrime(testNum)) {
				appendNumber(testNum);
			}
		}
	}
	
	public void solution() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// 맨 앞 첫자리는 소수로 고정
		int[] prime = {2, 3, 5, 7};
		for (int i = 0; i < prime.length; i++) {
			appendNumber(prime[i]);
		}
		
		System.out.println(sb);
	}

	

	public static void main(String[] args) throws NumberFormatException, IOException {
		new ProfessorSolution().solution();
	}
}
