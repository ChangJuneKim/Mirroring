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
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;
		
		int T = Integer.valueOf(br.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.valueOf(st.nextToken());
			int n = Integer.valueOf(st.nextToken());
			
			double num1 = 1;
			double num2 = 1;
			
			for (int i = n; i > n - r; i--) {
				num1 = (num1 * i);
			}
			
			for (int i = r; i > 0; i--) {
				num2 = (num2 * i);
			}
			System.out.printf("%.0f%n", num1 / num2);
			
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}
