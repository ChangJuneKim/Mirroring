package com.ssafy.ws.problem;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	public void solution() throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		int[] numbers = new int[N];
		int[] acc = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.valueOf(st.nextToken());
		}
		
		int sum = 0;
		for (int i = 1; i < acc.length; i++) {
			sum += numbers[i - 1];
			acc[i] = sum;
		}
		
		// solve
		for (int input = 0; input < M; input++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.valueOf(st.nextToken());
			int j = Integer.valueOf(st.nextToken());
			
			sb.append(acc[j] - acc[i - 1] + "\n");
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}