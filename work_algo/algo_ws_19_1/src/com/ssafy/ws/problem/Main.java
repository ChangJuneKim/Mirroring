package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	class Vertex implements Comparable<Vertex> {

		int num;
		int minDistance;

		public Vertex(int num, int minDistance) {
			super();
			this.num = num;
			this.minDistance = minDistance;
		}

		@Override
		public String toString() {
			return "Edge <num=" + num + ", minDistance=" + minDistance + ">";
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}

	}

	ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
	int[] distances;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.valueOf(st.nextToken()) + 1;
		int E = Integer.valueOf(st.nextToken());

		int start = Integer.valueOf(br.readLine());

		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int weight = Integer.valueOf(st.nextToken());

			graph.get(from)
				.add(new Vertex(to, weight));
		}

		distances = new int[V];
		Arrays.fill(distances, Integer.MAX_VALUE);

		distances[start] = 0;

		dijkstra(start);
		
		for (int i = 1; i < distances.length; i++) {
			if(distances[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(distances[i]);
			}
		}
	}

	private void dijkstra(int start) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start, 0));
		
		while(!pq.isEmpty()) {
			Vertex now = pq.poll();
			
			for (Vertex next : graph.get(now.num)) {
				if(distances[next.num] > now.minDistance + next.minDistance) {
					distances[next.num] = now.minDistance + next.minDistance;
					pq.offer(new Vertex(next.num, distances[next.num]));
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}