package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProfessorSolution {

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;

		// 메모이제이션으로 조합 경우의 수 구하기
		int[][] combinationMemo = new int[30][30];

		for (int i = 0; i < 30; i++) {
			combinationMemo[i][i] = 1;
			combinationMemo[i][0] = 1;
		}

		for (int i = 2; i < 30; i++) {
			for (int j = 1; j < 30; j++) {
				combinationMemo[i][j] = combinationMemo[i - 1][j - 1] + combinationMemo[i - 1][j];
			}
		}

		int T = Integer.valueOf(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.valueOf(st.nextToken()); // n
			int M = Integer.valueOf(st.nextToken()); // r
			
			int answer = combinationMemo[M][N];
			
			sb.append(answer).append("\n");

		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		new ProfessorSolution().solution();
	}
}
