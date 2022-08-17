package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String expression = br.readLine();
		
		// - 를 기준으로 나누기
		st = new StringTokenizer(expression, "-");
		String[] divideMinusOp = new String[st.countTokens()];
		int[] divideMinusOpInt = new int[st.countTokens()];
		
		for (int i = 0; i < divideMinusOp.length; i++) {
			divideMinusOp[i] = st.nextToken();
		}
		
		// - 를 기준으로 나눈 것들을 합치기
		for (int i = 0; i < divideMinusOp.length; i++) {
			st = new StringTokenizer(divideMinusOp[i], "+");
			int acc = 0;
			int target = st.countTokens();
			
			for (int j = 0; j < target; j++) {
				acc += Integer.valueOf(st.nextToken());
			}
			divideMinusOpInt[i] = acc;
		}
	
		int answer = divideMinusOpInt[0]; // 첫 원소에	
		// 합해준 것들을 다 빼준다
		for (int i = 1; i < divideMinusOpInt.length; i++) {
			answer -= divideMinusOpInt[i]; 
		}
		
		System.out.println(answer);	
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}