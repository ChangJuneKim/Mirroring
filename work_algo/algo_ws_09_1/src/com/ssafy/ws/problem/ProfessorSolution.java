package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProfessorSolution {
	int max;
	int[][] TK;
	boolean[] isSelected;
	int N;
	int L;
	
	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;

		int T = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {		
			st = new StringTokenizer(br.readLine());
			N = Integer.valueOf(st.nextToken()); // 재료의 수
			L = Integer.valueOf(st.nextToken()); // 제한 칼로리

			TK = new int[N][2]; // 점수, 칼로리
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				TK[i][0] = Integer.valueOf(st.nextToken());
				TK[i][1] = Integer.valueOf(st.nextToken());
			}

			max = Integer.MIN_VALUE;
			isSelected = new boolean[N];
			subset(0);

			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	public void subset(int index) {
		// 기저 조건 (종료조건)
		if(index == N) { // 더 이상 고려할 원소가 없다면 부분집합의 구성이 완성
			int sumT = 0;
			int sumK = 0;
			
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sumT += TK[i][0];
					sumK += TK[i][1];
				}
			}
			
			// 만약 제한 칼로리 이하이면
			
			if(sumK <= L) {
				// 맛에 대한 점수 최대값 갱신
				if(sumT > max) {
					max = sumT;
				}
			}
			
			return;
		}
		
		// 유도 부분
		// 원소 선택
		isSelected[index] = true;
		subset(index + 1);
		
		// 원소 미선택
		isSelected[index] = false;
		subset(index + 1);
	}

	public static void main(String[] args) throws IOException {
		new ProfessorSolution().solution();
	}
}
