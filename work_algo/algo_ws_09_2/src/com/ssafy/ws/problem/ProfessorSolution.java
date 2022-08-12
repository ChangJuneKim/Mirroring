package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProfessorSolution {
	int min;
	int N;
	int[] S;
	int[] B;
	boolean[] isSelected;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;

		N = Integer.valueOf(br.readLine());

		S = new int[N]; // 신맛
		B = new int[N]; // 쓴맛

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.valueOf(st.nextToken());
			B[i] = Integer.valueOf(st.nextToken());
		}

		min =Integer.MAX_VALUE;
		isSelected = new boolean[N];
		
		subset(0);
		sb.append(min).append("\n");

		System.out.println(sb);
	}

	public void subset(int depth) {
		if (depth == N) {
			int resultS = 1; // 곱해야해서 초기값 1
			int resultB = 0; // 더해야해서 초기값 0
			
			int selectedCount = 0;
			
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					selectedCount++;
					resultS *= S[i];
					resultB += B[i];
				}
			}
			
			if(selectedCount > 0) {
				int result = Math.abs(resultS - resultB);
				
				if(result < min) {
					min = result;
				}
			}
			
			return;
		}

		isSelected[depth] = true;
		subset(depth + 1);
		
		isSelected[depth] = false;
		subset(depth + 1);
	}
	
	public static void main(String[] args) throws IOException {
		new ProfessorSolution().solution();
	}
}
