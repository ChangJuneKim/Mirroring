package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	ArrayList<ArrayList<Integer>> graph;
	int[] parents;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.valueOf(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

//			graph = new ArrayList<ArrayList<Integer>>();
			parents = new int[N + 1];
			Arrays.fill(parents, 1, N + 1, -1);
//			for (int i = 0; i < N + 1; i++) {
//				graph.add(new ArrayList<Integer>());
//			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				merge(from, to);
//				graph.get(from)
//						.add(to);
//
//				graph.get(to)
//						.add(from);
			}

			int count = 0;
			for (int i = 0; i < parents.length; i++) {
				if (parents[i] < 0) {
					count++;
				}
			}

			sb.append("#")
					.append(t)
					.append(" ")
					.append(count)
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
