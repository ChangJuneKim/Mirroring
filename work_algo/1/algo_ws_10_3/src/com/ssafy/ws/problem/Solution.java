package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	int[] result;
	boolean[] visited;
	int count;
	int[][] synergies;
	int min;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.valueOf(br.readLine());

			synergies = new int[N][];

			// 시너지 입력 완료
			for (int i = 0; i < synergies.length; i++) {
				synergies[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			}

			int[] gradients = new int[N]; // N개의 재료
			visited = new boolean[N];

			for (int i = 1; i <= N; i++) {
				gradients[i - 1] = i;
			}

			min = Integer.MAX_VALUE;
			count = 0;
			combination(gradients, 0, 0, N, N / 2);

			sb.append("#").append(testCase).append(" ").append(min).append(" \n");
		}
		System.out.println(sb);
	}

	private void combination(int[] gradients, int depth, int start, int n, int r) {
		if (depth == r) {
			// 다 뽑았다
			int A = 0;
			int B = 0;
			int result = 0;

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					
					if (visited[i] && visited[j]) {
						A += synergies[i][j] + synergies[j][i];
					} else if (!visited[i] && !visited[j]) {
						B += synergies[i][j] + synergies[j][i];
					}
				}
			}

			result = Math.abs(A - B);
			min = Math.min(result, min);
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(gradients, depth + 1, i + 1, n, r);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}