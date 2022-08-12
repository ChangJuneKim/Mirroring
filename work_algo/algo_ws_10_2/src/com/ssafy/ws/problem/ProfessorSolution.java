package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProfessorSolution {
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

		// 연산의 개수 N
		int N = Integer.parseInt(in.readLine());

		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// 1. 절댓값 기준 오름차순 정렬
				if (Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				}
				// 2. 절댓값이 같다면 값 기준 오름차순 정렬
				else if (Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}

				// 그 외에는 기본 오름차순 정렬
				return -1;
			}

		});

		/**
		 * 2. 알고리즘 풀기
		 */
		for (int i = 0; i < N; i++) {

			// 숫자 하나를 읽는다.
			int num = Integer.parseInt(in.readLine());

			switch (num) {
			case 0:  // 큐에서 절댓값이 가장 작은 값 출력
				if (!queue.isEmpty()) {
					sb.append(queue.poll()).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
				break;

			default:
				queue.offer(num);
			}
		}

		/**
		 * 3. 정답 출력
		 */
		System.out.println(sb);
	}
}
