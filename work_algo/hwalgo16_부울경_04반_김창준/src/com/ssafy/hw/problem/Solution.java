package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	ArrayList<ArrayList<Integer>> graph;
	boolean[] visited;
	int[] depth;

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int t = 1; t < T + 1; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			graph = new ArrayList<ArrayList<Integer>>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 101; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			for (int i = 0; i < N / 2; i++) {
				int index = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				
				if (graph.get(index)
					.contains(value)) {
					continue;
				}
				
				graph.get(index)
					.add(value);
			}

			visited = new boolean[101];
			depth = new int[101];
			
			int max = Integer.MIN_VALUE;
			int result = 0;
			
			bfs(start);
			
//			System.out.println(Arrays.toString(depth));
			for (int i = 0; i < 101; i++) {
				if (max <= depth[i]) {
					max = depth[i];
					if (result < i)
						result = i;
				}
			}

			sb.append("#")
				.append(t)
				.append(" ")
				.append(result)
				.append("\n");
		}
		System.out.println(sb);

	}

	private void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 0; i < graph.get(current).size(); i++) {
				int neighbor = graph.get(current).get(i); 
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
					depth[neighbor] = depth[current] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

}
