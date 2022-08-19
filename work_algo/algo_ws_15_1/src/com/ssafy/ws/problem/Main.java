package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	int N, M, R;
	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	boolean[] visited;
	
	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		R = Integer.valueOf(st.nextToken());
		
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		for (int i = 0; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}
		
		visited = new boolean[N + 1];
		dfs(R);
		
		System.out.println();
		
		visited = new boolean[N + 1];
		bfs(R);
	}


	private void bfs(int current) {
		// 1. 큐 생성
		Queue<Integer> queue = new LinkedList<>();
		// 1. 시작 노드 큐에 담음, 방문했다고 체크
		queue.offer(current);
		visited[current] = true;
		
		// 큐가 빌 때 까지 반복
		while(!queue.isEmpty()) {
			// 2. 큐에서 하나 뽑아서 출력한다
			int cur = queue.poll();
			System.out.print(cur + " ");
			
			// 3. 큐와 인접한 노드들 중에 아직 방문하지 않은 원소들을 큐에 넣는다
			for (int i = 0; i < graph.get(cur).size(); i++) {
				// 인접한 노드들
				int neighbor = graph.get(cur).get(i);
				// 만약 방문하지 않았다면
				if(!visited[neighbor]) {
					// 큐에 넣는다
					queue.offer(neighbor);
					// 방문 처리
					visited[neighbor] = true;
				}
			}
		}
		
	}


	private void dfs(int current) {
		visited[current] = true;
		System.out.print(current + " ");
		
		for (int i = 0; i < graph.get(current).size(); i++) {
			int neighbor = graph.get(current).get(i);
			if(!visited[neighbor]) {
				dfs(neighbor);
			}
		}
		
	}


	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}
