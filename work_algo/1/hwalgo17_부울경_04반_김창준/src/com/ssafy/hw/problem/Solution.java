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

			parents = new int[N + 1];
			Arrays.fill(parents, 1, N + 1, -1);

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				merge(from, to);
			}

			int count = 0;
//			System.out.println(Arrays.toString(parents));

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

	private boolean merge(int num1, int num2) { // 유니온 Union
		// 각각 번호의 대표를 찾는다.
		int rootA = find(num1);
		int rootB = find(num2);
		// 대표가 같으면 유니온 하지 않는다.
		if (rootA == rootB) {
			return false;
		}

		int temp = parents[rootA] + parents[rootB]; // union 됐을 때 두 그룹 구성원의 합
		// rootA의 구성원 수가 더 작으면
		if (parents[rootA] > parents[rootB]) {
			parents[rootB] = temp; // 구성원이 더 많은 B에 구성원을 합치고
			parents[rootA] = rootB; // A는 B를 가리킨다
		} else { // rootA의 구성원 수가 같거나 더 크면
			parents[rootA] = temp; // 구성원이 더 많은 A에 구성원을 합치고
			parents[rootB] = rootA; // B는 A를 가리킨다
		}
		return true;
	}

	private int find(int number) { // Find
		if (parents[number] < 0) { // 음수이면 그게 대장
			return number;
		}
		return parents[number] = find(parents[number]);
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

}
