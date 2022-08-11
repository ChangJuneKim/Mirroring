package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	int min = Integer.MAX_VALUE;
	int N;
	int[][] ingredients;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;

		N = Integer.valueOf(br.readLine());

		ingredients = new int[N][2]; // 신맛, 쓴맛

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ingredients[i][0] = Integer.valueOf(st.nextToken());
			ingredients[i][1] = Integer.valueOf(st.nextToken());
		}

		subset(0, 0, 1, 0);
		sb.append(min).append("\n");

		System.out.println(sb);
	}

	public void subset(int depth, int count, int totalCitrus, int totalBitter) {
		if (depth == N) {
			if (count != 0) {
				min = Math.min(min, Math.abs(totalCitrus - totalBitter));
			}
			return;
		}

		subset(depth + 1, count, totalCitrus, totalBitter);
		subset(depth + 1, count + 1, totalCitrus * ingredients[depth][0], totalBitter + ingredients[depth][1]);
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}
