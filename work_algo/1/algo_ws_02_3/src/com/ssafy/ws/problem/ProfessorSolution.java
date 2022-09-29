package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProfessorSolution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		int T = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			// 농장의 크기
			int N = Integer.valueOf(br.readLine());
			int[][] farmData = new int[N][];

			// 농장 입력
			for (int i = 0; i < N; i++) {
				farmData[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
			}

			// solve
			int centerIndex = N / 2; // 2
			int blankCount = N / 2; // 2

			int answer = 0; // 수익
			for (int i = 0; i < N; i++) {
				for (int j = blankCount; j < N - blankCount; j++) {
					answer += farmData[i][j];
				}
				
				// 중앙을 기준으로 건너 뛸 숫자가 늘었다 줄었다
				if (i < centerIndex) {
					blankCount--;
				} else {
					blankCount++;
				}
			}
			sb.append(String.format("#%d %d%n", testCase, answer));
		}
		System.out.print(sb);
	}
}
