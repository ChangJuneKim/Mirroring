package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ProfessorSolution {
	
	// 우상, 우, 우하
	private static final int[] dr = { -1, 0, 1 };
	private static final int[] dc = { 1, 1, 1 };
	
	private static final char BLANK = '.';  // 빈 칸
	private static final char PIPE = 'P';  // 파이프
	
	private static int R;  // 빵집 근처의 모습 행 수
	private static int C;  // 빵집 근처의 모습 열 수
	private static char[][] data;  // 빵집 근처의 모습
	private static int answer;  // 파이프라인의 최대 개수

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */
		System.setIn(new FileInputStream("input1.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		String[] split = in.readLine().split(" ");
		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);
		
		// 빵집 근처의 모습
		data = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = in.readLine();
			for (int j = 0; j < C; j++) {
				data[i][j] = line.charAt(j);
			}
		}
		
		// 답 초기화
		answer = 0;

		/**
		 * 2. 알고리즘 풀기
		 */
		
		for (int r = 0; r < R; r++) {
			// 파이프 건설 시작
			dfs(r, 0);
		}

		/**
		 * 3. 정답 출력
		 */
		sb.append(answer);
		System.out.println(sb);
	}

	private static boolean dfs(int r, int c) {
		
		/**
		 * 기저 부분
		 */
		// 빵집에 도착했다면
		if (c == (C - 1)) {
			answer++;  // 놓을 수 있는 파이프라인 개수 1 증가
			return true;
		}
		
		/**
		 * 유도 부분
		 */
		// 진입 지점에 파이프 설치
		data[r][c] = PIPE;
		
		// 우상, 우, 우하 순으로 3방향 탐색
		for (int i = 0; i < 3; i++) {
			
			// 이동할 좌표 구하기
			int testR = r + dr[i];
			int testC = c + dc[i];
			
			// 경계 안이고 빈 칸이면 이동
			if ((0 <= testR && testR < R) && (0 <= testC && testC < C) && data[testR][testC] == BLANK) {
				if (dfs(testR, testC)) {  // 빵집까지 도착했다면 true이기 때문에 다른 방향 탐색을 멈춘다. (가지치기)
					return true;
				}
			}
		}
		return false;
	}
}






