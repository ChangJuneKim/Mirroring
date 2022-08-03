package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProfessorSolution {

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		String[] split = br.readLine().split(" ");
		int N = Integer.valueOf(split[0]);
		int M = Integer.valueOf(split[1]);

		int[][] numbers = new int[N + 1][N + 1];
		int[][] acc = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			split = br.readLine().split(" ");
			for (int j = 1; j < N + 1; j++) {
				numbers[i][j] = Integer.valueOf(split[j - 1]);
			}
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				acc[i][j] = acc[i][j - 1] + acc[i - 1][j] - acc[i - 1][j - 1] + numbers[i][j];
			}
		}

//		for (int i = 0; i < acc.length; i++) {
//			System.out.println(Arrays.toString(acc[i]));
//		}

		for (int i = 0; i < M; i++) {
			// 네 개의 정수 x1, y1, x2, y2
			split = br.readLine().split(" ");
			int x1 = Integer.valueOf(split[0]);
			int y1 = Integer.valueOf(split[1]);
			int x2 = Integer.valueOf(split[2]);
			int y2 = Integer.valueOf(split[3]);

			// (x2, y2) - (x1 - 1, y2) - (x2, y1 -1) + (x1 - 1, y1 - 1)

			int answer = acc[x2][y2] - acc[x1 - 1][y2] - acc[x2][y1 - 1] + acc[x1 - 1][y1 - 1];
			sb.append(answer + "\n");
		}
		System.out.println(sb);

	}

	public static void main(String[] args) throws IOException {
		new ProfessorSolution().solution();
	}
}