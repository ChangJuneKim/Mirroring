package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProfessorSolve {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");

		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		split = br.readLine().split(" ");
		int[] sums = new int[N + 1];
		for (int i = 0; i < N; i++) {
			sums[i + 1] = sums[i] + Integer.parseInt(split[i]);
		}
		
		// solve
		for (int input = 0; input < M; input++) {
			split = br.readLine().split(" ");
			int start = Integer.valueOf(split[0]) - 1;
			int end = Integer.valueOf(split[1]);

			sb.append(sums[end] - sums[start] + "\n");
		}
		System.out.println(sb);
	}
}
