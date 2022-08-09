package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public boolean isOperator(char token) {
		return token == '+' || token == '-' ||token == '/' ||token == '*';
	}
	
	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			
			int N = Integer.valueOf(br.readLine());
			
			int answer = 0;
			int count = 0;
			for (int i = 0; i < N; i++) {
				String[] split = br.readLine().split(" ");
				count++;
				if(split.length >= 3) {
					if(!(isOperator(split[1].charAt(0)))){
						answer = 0;
						sb.append(answer + "\n");
						break;
					}
				}else {
					if(isOperator(split[1].charAt(0))){
						answer = 0;
						sb.append(answer + "\n");
						break;
					}else {
						answer = 1;
						sb.append(answer + "\n");
						break;
					}
				}
			}
			
			for (int i = 0; i < N - count; i++) {
				br.readLine();
			}
			
		}
		
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}
