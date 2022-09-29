package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	int N;
	int[][] array;
	boolean visited[];
	int answer = Integer.MAX_VALUE;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.valueOf(br.readLine());

		array = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				array[i][j] = Integer.valueOf(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			DFS(i, i, 0, 0);
			visited[i] = false;
		}

		System.out.println(answer);
	}

	private void DFS(int start, int now, int sum, int cnt) {
		if (cnt == N - 1) {
			if (array[now][start] != 0) {
				sum += array[now][start];
				if (sum < answer)
					answer = sum;
			}
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i] == false && array[now][i] != 0) {
				visited[i] = true;
				DFS(start, i, sum + array[now][i], cnt + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
