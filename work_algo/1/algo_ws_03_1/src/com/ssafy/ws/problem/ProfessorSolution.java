package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProfessorSolution {
	private static final char GROUND = '.';
	private static final char BRICK = '*';
	private static final char STEEL = '#';
	private static final char WATER = '-';

	// 시계방향 (상 우 하 좌)
	private static final char[] TANK = { '^', '>', 'v', '<' };
	private static final int[] dx = { -1, 0, 1, 0 };
	private static final int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		int T = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#" + testCase + " ");

			String[] split = br.readLine().split(" ");
			int H = Integer.valueOf(split[0]);
			int W = Integer.valueOf(split[1]);

			// 게임 맵 입력
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
				}
			}

			// 명령어 개수
			int N = Integer.valueOf(br.readLine());

			// 명령어(유저입력)
			char[] userInput = new char[N];
			String line = br.readLine();

			for (int i = 0; i < N; i++) {
				userInput[i] = line.charAt(i);
			}

			int curX = -1;
			int curY = -1;
			int dir = -1;

			// 1. 전차 위치 찾기
			loop: for (int x = 0; x < H; x++) {
				for (int y = 0; y < W; y++) {
					// 전차의 위치와 방향 확인
					for (int i = 0; i < 4; i++) {
						if (map[x][y] == TANK[i]) {
							curX = x;
							curY = y;
							dir = i;
							break loop;
						}
					}
				}
			}

			// 2. 사용자 입력에 따라 전차 조작
			for (int i = 0; i < N; i++) {
				// 슈팅
				if (userInput[i] == 'S') {
					// 포탄이 이동할 좌표 구하기
					int testX = curX + dx[dir];
					int testY = curY + dy[dir];

					loop: while (true) {
						if (0 <= testX && testX < H && 0 <= testY && testY < W) {
							switch (map[testX][testY]) {
							case GROUND:
							case WATER:
								testX = testX + dx[dir];
								testY = testY + dy[dir];
								break;
							case BRICK:
								map[testX][testY] = GROUND;
								break loop;
							case STEEL:
								break loop;
							}
						} else {
							break loop;
						}
					}
				} else {
					// 이동 명령
					switch (userInput[i]) {
					case 'U':
						dir = 0;
						break;
					case 'R':
						dir = 1;
						break;
					case 'D':
						dir = 2;
						break;
					case 'L':
						dir = 3;
						break;
					}

					// 전차가 바라보는 방향 변경
					map[curX][curY] = TANK[dir];

					// 이동하려는 좌표 구하기
					int testX = curX + dx[dir];
					int testY = curY + dy[dir];

					if (0 <= testX && testX < H && 0 <= testY && testY < W) {
						if (map[testX][testY] == GROUND) {
							map[curX][curY] = GROUND; //전차가 있던 자리는 평지로 변경
							curX = testX;
							curY = testY;
							map[curX][curY] = TANK[dir]; // 이동한 (도착)좌표를 전차로 변경
						}
					}
				}
			}
			for (int j = 0; j < H; j++) {
				for (int k = 0; k < H; k++) {
					sb.append(map[j][k]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
