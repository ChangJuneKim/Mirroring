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

		String[] NMR = br.readLine().split(" ");

		int N = Integer.valueOf(NMR[0]);
		int M = Integer.valueOf(NMR[1]);
		int R = Integer.valueOf(NMR[2]);

		int[][] matrix = new int[N][];
		for (int i = 0; i < N; i++) {
			matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
		}

//		for (int i = 0; i < matrix.length; i++) {
//			System.out.println(Arrays.toString(matrix[i]));
//		}

		// 하 우 상 좌
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int i, j, d = 0, nr;

		for (int idx = 0; idx < Math.min(N, M) / 2; idx++) {
			nr = R % ((N - idx * 2) * 2 + (M - idx * 2) * 2 - 4); // 새롭게 추가한 코드. 해당하는 테두리의 크기를 modulo 해주어, 반복 횟수를 줄인다.
			while (nr-- != 0) {
				i = idx;
				j = idx;
				d = 0;
				int tmp = matrix[i][j];

				while (d != 4) {
					if (i + dy[d] < idx || i + dy[d] >= N - idx || j + dx[d] < idx || j + dx[d] >= M - idx) {
						d++;
						continue;
					}
					matrix[i][j] = matrix[i + dy[d]][j + dx[d]];
					i += dy[d];
					j += dx[d];
				}
				matrix[idx + 1][idx] = tmp;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int[] row : matrix) {
			for (int v : row) {
				sb.append(v).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}
