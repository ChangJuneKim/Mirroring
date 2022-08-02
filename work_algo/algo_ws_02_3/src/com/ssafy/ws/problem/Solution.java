package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public void solution() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.valueOf(br.readLine());
			int[][] farmData = new int[n][];

			// 농장 입력
			for (int i = 0; i < n; i++) {
				farmData[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
			}

			int sum = 0;
			
			for (int i = n / 2; i < n; i++) {
				
			}
			
			for (int i = n / 2; i >= 0; i--) {
				System.out.println(Arrays.toString(farmData[i]));
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution().solution();
	}
}
