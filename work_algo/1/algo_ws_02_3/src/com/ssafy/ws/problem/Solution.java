package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public void solution() throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		int T = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.valueOf(br.readLine());
			int[][] farmData = new int[N][];

			// 농장 입력
			for (int i = 0; i < N; i++) {
				farmData[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
			}
			
			int half = N / 2; // 중간지점 
			
			int sum = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 맨하튼 거리 내에 있을 경우
					if (Math.abs(half - r) + Math.abs(half - c) <= half) {
						sum += farmData[r][c];
					}
				}
			}
			sb.append(String.format("#%d %d%n", testCase, sum));
		}
		System.out.print(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution().solution();
	}
}
