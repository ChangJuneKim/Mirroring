package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	int N, M;
	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	boolean[] visited;
	boolean flag;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());

			graph.get(from)
					.add(to);
			graph.get(to)
					.add(from);
		}

		flag = false;
		for (int start = 0; start < N; start++) {
			visited = new boolean[N];
			dfs(start, 0);
			if (flag) {
				System.out.println(1);
				return;
			}
		}

		System.out.println(0);

	}

	private void dfs(int start, int count) {
		visited[start] = true;
		if (count >= 4) {
			flag = true;
			return;
		}

		for (int i = 0; i < graph.get(start)
				.size(); i++) {
			int neighbor = graph.get(start)
					.get(i);

			if (!visited[neighbor]) {
				dfs(neighbor, count + 1);
				visited[neighbor] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}