package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class ProfessorSolution {

	private static final char BLANK = '.'; // 빈 칸
	private static final char WATER = '*'; // 물
	private static final char S = 'S'; // 고슴도치 시작점
	private static final char D = 'D'; // 도착점

	// 우, 하, 좌, 상
	private static final int[] dr = { 0, 1, 0, -1 };
	private static final int[] dc = { 1, 0, -1, 0 };

	private static char[][] map; // 지도
	private static Queue<Node> sQueue; // 고슴도치 BFS를 위한 큐
	private static Queue<Node> wQueue; // 물 BFS를 위한 큐

	private static int R; // 행
	private static int C; // 열
	private static int answer; // 가장 짧은 거리 (짧은 시간)

	private static class Node {
		public int r; // 행
		public int c; // 열
		public int depth; // 거리 (경과시간)

		public Node(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", depth=" + depth + "]";
		}
	}

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */
		System.setIn(new FileInputStream("input4.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		// 변수 초기화
		sQueue = new ArrayDeque<>();
		wQueue = new ArrayDeque<>();

		String[] split = in.readLine()
				.split(" ");
		R = Integer.parseInt(split[0]); // 행
		C = Integer.parseInt(split[1]); // 열
		answer = 0; // 고슴도치-도착점 최단거리

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);

				switch (map[i][j]) {
				case S: // 고슴도치 시작 위치
					sQueue.offer(new Node(i, j, 0));
					break;

				case WATER: // 물
					wQueue.offer(new Node(i, j, 0));
					break;
				}
			}
		}

		/**
		 * 2. 알고리즘 풀기
		 */
		do {
			bfsWater(); // 매 분마다 물이 참
			bfs(); // 매 분마다 물이 찬 후 고슴도치 이동

		} while (!sQueue.isEmpty() && answer == 0);

		/**
		 * 3. 정답 출력
		 */
		// 답을 찾을 수 없는 경우
		if (answer == 0) {
			sb.append("KAKTUS");
		} else {
			sb.append(answer);
		}
		System.out.println(sb);
	}

	private static void bfs() {

		// 큐 크기 확인 (동일 너비 대상 개수)
		int size = sQueue.size();

		while (--size >= 0) {
			// 현재 물 꺼내기
			Node curNode = sQueue.poll();

			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int testR = curNode.r + dr[i];
				int testC = curNode.c + dc[i];

				// 경계 체크
				if ((0 <= testR && testR < R) && (0 <= testC && testC < C)) {

					// 도착하면 (기저 부분)
					if (map[testR][testC] == D) {
						answer = curNode.depth + 1;
						return;
					}

					// 빈 칸이면
					if (map[testR][testC] == BLANK) {
						map[testR][testC] = S; // 고슴도치 이동경로 표시
						sQueue.offer(new Node(testR, testC, curNode.depth + 1)); // 다음 칸 이동
					}
				}
			}
		}
	}

	private static void bfsWater() {

		// 큐 크기 확인 (동일 너비 대상 개수)
		int size = wQueue.size();

		while (--size >= 0) {
			// 현재 물 꺼내기
			Node curNode = wQueue.poll();

			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int testR = curNode.r + dr[i];
				int testC = curNode.c + dc[i];

				// 경계 체크
				if ((0 <= testR && testR < R) && (0 <= testC && testC < C)) {

					// 빈 칸이거나 고슴도치면
					if (map[testR][testC] == BLANK || map[testR][testC] == S) {
						map[testR][testC] = WATER; // 물 채우고
						wQueue.offer(new Node(testR, testC, curNode.depth + 1)); // 다음 칸 이동
					}
				}
			}
		}

	}

}
