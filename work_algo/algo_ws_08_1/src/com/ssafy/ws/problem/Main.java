package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 아직 못풀었음
public class Main {
	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		String[] NMR = br.readLine().split(" ");

		int N = Integer.valueOf(NMR[0]);
		int M = Integer.valueOf(NMR[1]);
		int R = Integer.valueOf(NMR[2]);

		int[][] matrix = new int[N][];
		int[][] answer = new int[N][M];
		for (int i = 0; i < N; i++) {
			matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
		}

//		for (int i = 0; i < matrix.length; i++) {
//			System.out.println(Arrays.toString(matrix[i]));
//		}

		// 하 우 상 좌
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				int startX = x;
				int startY = y;

				for (int i = 0; i < Math.min(N, M) / 2; i++) {
					int testX = startX;
					int testY = startY;
					int dir = 0;
					System.out.println("i : " + i);
					for (int j = 0; j < R; j++) {
						testX += dx[dir];
						testY += dy[dir];
						if (0 + i <= testX && testX < N - i && 0 + i <= testY && testY < M - i) {
						} else {
							dir++;
							if (dir == 4) {
								dir = 0;
							}
							if (dir == 0) {
								testX++;
								testY++;
//								System.out.println(matrix[testX][testY]);
							} else if (dir == 1) {
								testX--;
								testY++;
//								System.out.println(matrix[testX][testY]);
							} else if (dir == 2) {
								testX--;
								testY--;
//								System.out.println(matrix[testX][testY]);
							} else if (dir == 3) {
								testX++;
								testY--;
//								System.out.println(matrix[testX][testY]);
							}
						}
					}
					answer[testX][testY] = matrix[startX][startY];
					for (int j = 0; j < answer.length; j++) {
						System.out.println(Arrays.toString(answer[j]));
					}

					startX += 1;
					startY += 1;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}
