package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	int count = 0;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.valueOf(br.readLine());
			
			int[] weights = new int[N];
			boolean[] visited = new boolean[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weights[i] = Integer.valueOf(st.nextToken());
			}
			
			count = 0;
			dfs(0, 0, 0, weights, visited, N);

			System.out.println("#" + testCase + " " + count);
		}
	}

	public static void main(String[] args) throws Exception {
		new Solution().solution();
	}

	public void dfs(int depth, int leftSum, int rightSum, int[] weigths, boolean[] visited, int N) {
		// n개 까지 뽑았다는 것은 중간에 멈추지 않고 다 뽑았다는 것이므로 결과 cnt + 1
		if (depth == N) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;

				// 왼쪽만 일단 올리는 경우. 왼쪽 순서대로 올리면, 무조건 오른쪽 보다는 크므로 가능
				dfs(depth + 1, leftSum + weigths[i], rightSum, weigths, visited, N);
				// 오른쪽 저울에 올린 경우, 현재까지의 왼쪽 보다 작으면 오른쪽에 올릴 수 있다.
				if (rightSum + weigths[i] <= leftSum) {
					// 오른쪽에도 하나 올린다
					dfs(depth + 1, leftSum, rightSum + weigths[i], weigths, visited, N);
				}
				visited[i] = false;
			}
		}
	}
}