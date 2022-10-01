package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProfessorSolution {

	private static int N;  // N개의 무게 추
	private static int[] input;  // 순열을 이용해 N개의 무게 추를 줄세운 하나의 경우
	private static int answer;  // 오른쪽 위에 올라가있는 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 커지지 않는 경우의 수

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
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			// N개의 무게 추
			N = Integer.parseInt(in.readLine());
			
			// 무게 추를 input 배열에 담기
			String[] split = in.readLine().split(" ");
			input = new int[N];
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(split[i]);
			}
			
			// 정답 초기화
			answer = 0;

			/**
			 * 2. 알고리즘 풀기
			 */
			// 전처리: 순열에 쓰일 수들을 오름차순 정렬
			Arrays.sort(input);

			do {
				//System.out.println(Arrays.toString(input));  // 순열 완성
				
				put(0, 0, 0);

			} while(np(input));

			/**
			 * 3. 정답 출력
			 */
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

	// index: input 배열의 인덱스 번호
	// sumOfLeft: 왼쪽 저울의 무게 추 총합
	// sumOfRight: 오른쪽 저울의 무게 추 총합
	private static void put(int index, int sumOfLeft, int sumOfRight) {
		
		// 기저 부분
		if (index == N) {
			// 여기까지 온 경우는 왼쪽에 올라가 있는 무게의 총합이
			// 오른쪽보다 크거나 같은 경우이므로 정답 카운트 1 증가
			answer++;
			return;
		}
		
		// 유도 부분
		
		// index에 해당하는 무게 추를 왼쪽 저울에 올리고
		// 다음 무게 추를 처리하러 가기
		put(index + 1, sumOfLeft + input[index], sumOfRight);
		
		// 왼쪽에 있는 무게 추를 하나씩 오른쪽으로 옮기는데
		// 왼쪽에 올려진 추들의 무게 합이 오른쪽보다 크거나 같은 경우만 오른쪽 저울에 무게 추를 올린다.
		if (sumOfLeft >= sumOfRight + input[index]) {
			put(index + 1, sumOfLeft, sumOfRight + input[index]);
		}
	}

	// numbers 배열의 상태를 근거로 다음 순열 생성, 다음 순열 존재하면 true, 아니면 false
	public static boolean np(int[] numbers) {

		int N = numbers.length;

		// 1. 꼭대기 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) {
			--i;
		}

		if (i == 0) {
			// 다음 순열을 만들 수 없는 이미 가장 큰 순열의 상태!
			return false;
		}

		// 2. 꼭대기의 바로 앞자리(i - 1)의 값을 크게 만들 교환값을 뒤쪽에서 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) {
			--j;
		}

		// 3. i - 1 위치값과 j 위치값 교환
		swap(numbers, i - 1, j);

		// 4. i 위치부터 맨 뒤까지의 수열을 가장 작은 형태의 오름차순으로 변경
		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}

		return true;
	}

	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
