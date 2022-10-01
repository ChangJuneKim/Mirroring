package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

	}

	int[] parents;
	Edge[] edgeList;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.valueOf(st.nextToken());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#")
					.append(testCase)
					.append(" ");
			st = new StringTokenizer(br.readLine());
			int V = Integer.valueOf(st.nextToken());
			int E = Integer.valueOf(st.nextToken());

			parents = new int[V + 1];
			Arrays.fill(parents, 1, V + 1, -1);
			edgeList = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.valueOf(st.nextToken());
				int to = Integer.valueOf(st.nextToken());
				int weight = Integer.valueOf(st.nextToken());

				edgeList[i] = new Edge(from, to, weight);
			}

			Arrays.sort(edgeList);

			long result = 0;
			int count = 0;

			for (Edge edge : edgeList) {
				if (merge(edge.from, edge.to)) {
					count++;
					result += edge.weight;
					if (count == V - 1)
						break;
				}
			}

			sb.append(result)
					.append("\n");
		}
		System.out.println(sb);
	}

	private boolean merge(int a, int b) {
		int pA = find(a);
		int pB = find(b);

		if (pA == pB) { // 부모가 같다면 union 할 수 없다
			return false;
		}

		int temp = parents[pA] + parents[pB]; // 합친 가족 수 temp

		if (parents[pA] > parents[pB]) {
			parents[pA] = pB;
			parents[pB] = temp;
		} else {
			parents[pB] = pA;
			parents[pA] = temp;
		}

		return true;
	}

	private int find(int i) {
		if (parents[i] < 0) { // 음수이면 그게 대장
			return i;
		}
		return parents[i] = find(parents[i]);
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

}