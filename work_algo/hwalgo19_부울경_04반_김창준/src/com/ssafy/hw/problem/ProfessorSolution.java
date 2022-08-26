package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ProfessorSolution {

	private static int N;
	private static int[][] W;

	private static int answer;
	private static boolean[] isVisited;  // DFS 풀 때 사용할 방문 체크 배열

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		N = Integer.parseInt(in.readLine());
		
		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(split[j]);
			}
		}

		/**
		 * 2. 알고리즘 풀기
		 */
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			isVisited = new boolean[N];
			isVisited[i] = true;
			dfs(i, 0);
		}

		/**
		 * 3. 정답 출력
		 */
		sb.append(answer);
		System.out.println(sb);
	}

	// current: 현재 정점 번호
	// weight: 가중치 (도시를 방문할 때마다 누적된 가중치가 들어옴)
	private static void dfs(int current, int weight) {
		
		// 기저 부분
		if (isAllVisited()) {  // 모든 도시를 방문 했다면
			
			// 마지막 도시에서 출발지로 돌아가는 길이 있을 경우
			if (W[current][0] != 0) {
				int result = weight + W[current][0];  // 마지막 도시에서 출발지로 돌아가는 비용을 더한다.
				if (result < answer) {
					answer = result;
				}
			}
			
			return;
		}
		
		// 유도 부분
		for (int i = 1; i < N; i++) {
			if (!isVisited[i] && W[current][i] != 0) {
				
				// 방문 처리
				isVisited[i] = true;
				
				dfs(i, weight + W[current][i]);
				
				// 방문 처리 반납
				isVisited[i] = false;
			}
		}
	}

	private static boolean isAllVisited() {
		for (int i = 0; i < N; i++) {
			if (!isVisited[i]) {
				return false;
			}
		}
		return true;
	}

}
