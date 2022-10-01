package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ProfessorSolution {
	
	private static int[] data;    // 아홉 난쟁이들의 모자 번호
	private static int[] dwarfs;  // 아홉 난쟁이들 중 뽑힌 일곱 난쟁이들
	private static StringBuilder sb;

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
		// 아홉 난쟁이
		data = new int[9];
		for (int i = 0; i < 9; i++) {
			data[i] = Integer.parseInt(in.readLine());
		}
		
		// 조합으로 뽑은 일곱 난쟁이들의 모자 번호
		dwarfs = new int[7];
		
		/**
		 * 2. 알고리즘 풀기
		 */
		comb(0, 0);

		/**
		 * 3. 정답 출력
		 */

		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {
		// 기저 부분 (종료 조건)
		if (cnt == 7) {  // 아홉 난쟁이 중 일곱 난쟁이를 뽑았다면
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += dwarfs[i];
			}
			
			// 합이 100 이라면 우리가 찾던 일곱 난쟁이일 것이다.
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					// 합이 100인 일곱 난쟁이 모자번호 출력
					sb.append(dwarfs[i]).append("\n");
				}
			}
			return;
		}
		
		// 유도 부분
		for (int i = start; i < 9; i++) {
			dwarfs[cnt] = data[i];
			comb(cnt + 1, i + 1);
		}
		
	}
}

