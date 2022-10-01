package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 상호의 배틀필드 D3 
public class Solution {

	int dir = 0;
	int H = 0;
	int W = 0;

	public boolean isTank(String token) {
		if (token.equals("^") || token.equals("v") || token.equals("<") || token.equals(">")) {
			if (token.equals("^")) {
				dir = 0;
			} else if (token.equals("v")) {
				dir = 1;
			} else if (token.equals("<")) {
				dir = 2;
			} else if (token.equals(">")) {
				dir = 3;
			}
			return true;
		}
		return false;
	}

	public boolean isValidCoords(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}

	public void solution() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		int T = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#" + testCase + " ");
			
			String[] input = br.readLine().split(" ");
			H = Integer.valueOf(input[0]);
			W = Integer.valueOf(input[1]);

			String[][] map = new String[H][W];
			int x = -1;
			int y = -1;

			for (int i = 0; i < H; i++) {
				String[] line = br.readLine().split("");
				for (int j = 0; j < W; j++) {
					if (isTank(line[j])) {
						x = i; // 탱크의 x좌표
						y = j; // 탱크의 y좌표
					}
					map[i][j] = line[j];
				}
			}

			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };
			int N = Integer.valueOf(br.readLine()); // 명령어 수

			String commands = br.readLine();
			for (int i = 0; i < N; i++) {
				char command = commands.charAt(i);

				int k = 1;
				int testX = 0;
				int testY = 0;
				switch (command) {
				// 발사 명령
				case 'S':
					while (true) {
						testX = x + (dx[dir] * k);
						testY = y + (dy[dir] * k);

						if (isValidCoords(testX, testY)) {
							if (map[testX][testY].equals("#"))
								break;
							else if (map[testX][testY].equals("*")) {
								map[testX][testY] = ".";
								break;
							}
						}
						else {
							break;
						}
						k++;

					}
					break;
				// 여기서부터 이동 명령
				case 'U':
					dir = 0;
					testX = x + dx[dir];
					testY = y + dy[dir];
					map[x][y] = "^";
					
					if (isValidCoords(testX, testY) && map[testX][testY].equals(".")) {
						map[testX][testY] = "^";
						map[x][y] = ".";

						x = testX;
						y = testY;
					}
					break;
				case 'D':
					dir = 1;
					testX = x + dx[dir];
					testY = y + dy[dir];
					map[x][y] = "v";
					if (isValidCoords(testX, testY) && map[testX][testY].equals(".")) {
						map[testX][testY] = "v";
						map[x][y] = ".";

						x = testX;
						y = testY;
					}
					break;
				case 'L':
					dir = 2;
					testX = x + dx[dir];
					testY = y + dy[dir];
					map[x][y] = "<";
					if (isValidCoords(testX, testY) && map[testX][testY].equals(".")) {
						map[testX][testY] = "<";
						map[x][y] = ".";

						x = testX;
						y = testY;
					}
					break;
				case 'R':
					dir = 3;
					testX = x + dx[dir];
					testY = y + dy[dir];
					map[x][y] = ">";
					if (isValidCoords(testX, testY) && map[testX][testY].equals(".")) {
						map[testX][testY] = ">";
						map[x][y] = ".";

						x = testX;
						y = testY;
					}
					break;
				}

			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution().solution();
	}
}
