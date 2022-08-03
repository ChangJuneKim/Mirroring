package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	 //못풀었음!
	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");

		st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());

		int[][] numbers = new int[N][N];
		int[][] acc = new int[N][N];

		int sum = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				numbers[i][j] = Integer.valueOf(st.nextToken());
				sum += numbers[i][j];
				acc[i][j] = sum;
			}

		}


		// solve
		for (int input = 0; input < M; input++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.valueOf(st.nextToken()) - 1;
			int y1 = Integer.valueOf(st.nextToken()) - 1;
			int x2 = Integer.valueOf(st.nextToken()) - 1;
			int y2 = Integer.valueOf(st.nextToken()) - 1;

			if (x1 == x2 && y1 == y2) {
				sb.append(numbers[x1][y1] + "\n");
			} else if (x1 == 0 && y1 == 0) {
				sb.append(acc[x2][y2] + "\n");
			} else {
				sb.append(acc[x2][y2] - acc[x1][y1] + "\n");
			}

		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}