package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ProfessorSolution {

	private static StringBuilder sb;
	private static int[][] data;  // 영상 정보

	public static void main(String[] args) throws Exception {



		/**
		 * 0. 입력파일 읽어들이기
		 */
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		// 영상의 크기 N
		int N = Integer.parseInt(in.readLine());

		// 영상 정보
		data = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				data[i][j] = line.charAt(j) - '0';
			}
		}

		/**
		 * 2. 알고리즘 풀기
		 */
		cut(0, 0, N);

		/**
		 * 3. 정답 출력
		 */

		System.out.println(sb);
	}

	// r: 시작 행 번호
	// c: 시작 열 번호
	// size: 한 변의 길이
	private static void cut(int r, int c, int size) {
		
		// 해당 영역의 색상 확인
		int sum = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				sum += data[i][j];
			}
		}
		
		if (sum == size * size) {  // 기저 조건
			// 검은 점
			sb.append(1);
		}
		else if (sum == 0) {  // 기저 조건
			// 흰 점
			sb.append(0);
		}
		else {  // 유도 조건: 색상이 섞여 있는 경우
			sb.append("(");
			
			int half = size / 2;
			// 4개로 쪼개기
			// 분할된 각 영역의 공간도 온전한 하나의 공간으로 본다면 동일한 작업 수행해야 하므로 재귀
			cut(r, c, half);  // 좌상
			cut(r, c + half, half);  // 우상
			cut(r + half, c, half);  // 좌하
			cut(r + half, c + half, half);  // 우하
			
			sb.append(")");
		}
	}
}
