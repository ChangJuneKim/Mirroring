package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ProfessorSolution {
	public void solution() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");

		final int T = 10;
		final int LADDER_SIZE = 100;

		for (int testCase = 1; testCase <= T; testCase++) {
			br.readLine();
			sb.append("#" + testCase + " ");
			int[][] ladder = new int[LADDER_SIZE][LADDER_SIZE];
			// 사다리 입력
			for (int i = 0; i < LADDER_SIZE; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < LADDER_SIZE; j++) {
					ladder[i][j] = Integer.valueOf(st.nextToken());
				}
			}

			// solve 문제에 맞춰서 평소 생각하는 x, y 를 반대로 생각
			// 현재 위치
			int curX = -1;
			int curY = -1;

			// 시작 위치 찾기 (도착 지점 2에서 출발)
			for (int x = 0; x < 100; x++) {
				if (ladder[99][x] == 2) {
					curX = x;
					curY = 99;
					break;
				}
			}

			// 좌, 우, 상 델타 값
			int[] dx = { -1, 1, 0 };
			int[] dy = { 0, 0, -1 };

			while (curY != 0) { // 배열의 첫 행에 도착할 때 까지
				// 현재위치 curX, curY 에서 3방향 탐색
				for (int i = 0; i < 3; i++) {
					// 3방향 중 한 방향 체크
					int nx = curX + dx[i];
					int ny = curY + dy[i];

					// 경계 체크
					if ((0 <= nx && nx < 100) && (0 <= ny && ny < 100)) {
						// 이동 하려는 곳의 값을 가져옴
						int result = ladder[nx][ny];
						
						// 값이 1이면 이동
						if(result == 1) {
							curX = nx;
							curY = ny;
							ladder[curX][curY] = 8;
							break;
						}
					}else continue;
				}
			}
			System.out.println(curX);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution().solution();
	}
}
