package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	int max;
	int[][] ingredients;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;

		int T = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.valueOf(st.nextToken()); // 재료의 수
			int L = Integer.valueOf(st.nextToken()); // 제한 칼로리

			ingredients = new int[N][2]; // 점수, 칼로리

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = Integer.valueOf(st.nextToken());
				ingredients[i][1] = Integer.valueOf(st.nextToken());
			}

			max = Integer.MIN_VALUE;
			subset(0, 0, 0, N, L);

			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	public void subset(int depth, int score, int calorie, int N, int L) {
		if (calorie > L) {
			return;
		}

		if (calorie <= L) {
			max = Math.max(max, score);
		}
		
		if (depth == N) {
			return;
		}

		subset(depth + 1, score + ingredients[depth][0], calorie + ingredients[depth][1], N, L);
		subset(depth + 1, score, calorie, N, L);
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}

