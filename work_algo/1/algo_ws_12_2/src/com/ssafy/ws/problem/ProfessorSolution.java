package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ProfessorSolution {
	
	private static int answer;

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
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int r = Integer.parseInt(split[1]);
		int c = Integer.parseInt(split[2]);
		answer = 0;

		/**
		 * 2. 알고리즘 풀기
		 */
		int size = power(N);
		
		cut(r, c, size);

		/**
		 * 3. 정답 출력
		 */
		sb.append(answer).append("\n");
		System.out.println(sb);
	}

	// row: 도착지점 행 번호
	// col: 도착지점 열 번호
	// size: 한 변의 길이
	private static void cut(int row, int col, int size) {
		
		// 기저 부분
		if (size == 1) {
			return;
		}
		
		// 유도 부분
		int half = size / 2;
		
		if (row < half && col < half) {  // 좌상
			cut(row, col, half);
		}
		else if (row < half && half <= col) {  // 우상
			answer += size * size / 4;
			cut(row, col - half, half);
		}
		else if (half <= row && col < half) {  // 좌하
			answer += (size * size / 4) * 2;
			cut(row - half, col, half);
		}
		else if (half <= row && half <= col) {  // 우하
			answer += (size * size / 4) * 3;
			cut(row - half, col - half, half);
		}
	}

	private static int power(int N) {
		
		int result = 1;
		for (int i = 0; i < N; i++) {
			result *= 2;
		}
		
		return result;
	}
}
