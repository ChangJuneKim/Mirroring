package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ProfessorSolution {
	
	private static int N;  // 배달해야 할 설탕 무게 (킬로그램)
	private static int[] bags;  // 봉지의 종류
	private static int answer;  // 봉지의 최소 개수
	
	private static int[] numbers;  // 각 봉지 종류마다 봉지 개수 저장 (중복순열에서 사용)

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
		// 배달해야 할 설탕 무게 (킬로그램)
		N = Integer.parseInt(in.readLine());

		/**
		 * 2. 알고리즘 풀기
		 */
		// 봉지 종류
		bags = new int[] { 5, 3 };
		numbers = new int[bags.length];
		
		// 봉지의 최소 개수 초기화
		answer = Integer.MAX_VALUE;
		
		// 중복 순열로 풀기
		perm(0);

		/**
		 * 3. 정답 출력
		 */
		// 정확하게 N 킬로그램을 만들 수 없다면
		if (answer == Integer.MAX_VALUE) {
			sb.append(-1).append("\n");
		}
		else {
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

	// cnt: 현재까지 고려한 원소 수
	private static void perm(int cnt) {
		
		// 기저 부분
		if (cnt == bags.length) {
			
			// 원본 손실을 막기 위해 값 복사
			int sugar = N;
			for (int i = 0; i < bags.length; i++) {
				// 남은 설탕 = 현재 남은 설탕 - (봉지의 종류 * 중복순열로 뽑은 봉지 수)
				sugar = sugar - (bags[i] * numbers[i]);
			}
			
			// 정확하게 N킬로그램을 만들 수 있는 경우
			if (sugar == 0) {
				
				// 사용한 봉지 개수
				int bagCnt = 0;
				for (int i = 0; i < bags.length; i++) {
					bagCnt += numbers[i];
				}
				
				if (bagCnt < answer) {
					answer = bagCnt;
				}
			}
			
			return;
		}
		
		
		// 유도 부분
		// 1667 = 최대 5000킬로그램 / 3킬로그램 봉지
		// 최악의 경우 경우의 수가 1667 * 1667 = 2,778,889 이므로 1초 안에 충분히 수행 가능
		for (int i = 0; i <= 1667; i++) {
			numbers[cnt] = i;
			perm(cnt + 1);  // 중복순열
		}
	}
}









