package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	int N;
	int K;
	int visited[] = new int[100001];

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());

		int result = bfs(N);
		System.out.println(result);
	}

	private int bfs(int current) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(current);
		
		int index = current;
		int n = 0;
		
		visited[index] = 1;
		
		while (!queue.isEmpty()) {
			n = queue.poll();
//			System.out.println(Arrays.toString(visited));
			if (n == K) {
				return visited[n] - 1;
			}
			
			// 걷기 X - 1
			if (n - 1 >= 0 && visited[n - 1] == 0) {
				visited[n - 1] = visited[n] + 1;
				queue.add(n - 1);
			}
			
			// 걷기 X + 1
			if (n + 1 <= 100000 && visited[n + 1] == 0) {
				visited[n + 1] = visited[n] + 1;
				queue.add(n + 1);
			}
			
			// 순간이동 2 * X
			if (2 * n <= 100000 && visited[2 * n] == 0) {
				visited[2 * n] = visited[n] + 1;
				queue.add(2 * n);
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
