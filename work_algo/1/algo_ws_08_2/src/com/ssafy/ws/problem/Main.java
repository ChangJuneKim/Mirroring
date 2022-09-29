package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	int[][] originMatrix;
	int N, M, R;

	public void solve1() {
		int[][] resultMatrix = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				resultMatrix[N - i - 1][j] = originMatrix[i][j];
			}
		}

		originMatrix = resultMatrix;
	}

	public void solve2() {
		int[][] resultMatrix = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				resultMatrix[i][M - j - 1] = originMatrix[i][j];
			}
		}

		originMatrix = resultMatrix;
	}

	public void solve3() {
		int[][] resultMatrix = new int[M][N];
		int C = N - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				resultMatrix[j][C] = originMatrix[i][j];
			}
			C--;
		}
		
		int temp = N;
		N = M;
		M = temp;
		
		originMatrix = resultMatrix;
	}

	public void solve4() {
		int[][] resultMatrix = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				resultMatrix[M - 1 - j][i] = originMatrix[i][j];
			}
		}
		originMatrix = resultMatrix;
		
		int temp = N;
		N = M;
		M = temp;
	}

	public void solve5() {
		int[][] resultMatrix = new int[N][M];
		int halfN = N / 2;
		int halfM = M / 2;

		// 1에서 2로
		for (int i = 0; i < halfN; i++) {
			for (int j = 0; j < halfM; j++) {
				resultMatrix[i][halfM + j] = originMatrix[i][j];
			}
		}

		// 2에서 3으로
		for (int i = 0; i < halfN; i++) {
			for (int j = halfM; j < M; j++) {
				resultMatrix[halfN + i][j] = originMatrix[i][j];
			}
		}
		// 3에서 4로
		for (int i = halfN; i < N; i++) {
			for (int j = halfM; j < M; j++) {
				resultMatrix[i][j - halfM] = originMatrix[i][j];
			}
		}

		// 4에서 1로
		for (int i = halfN; i < N; i++) {
			for (int j = 0; j < halfM; j++) {
				resultMatrix[i - halfN][j] = originMatrix[i][j];
			}
		}
		originMatrix = resultMatrix;
	}

	public void solve6() {
		int[][] resultMatrix = new int[N][M];
		int halfN = N / 2;
		int halfM = M / 2;

		// 1에서 4로
		for (int i = 0; i < halfN; i++) {
			for (int j = 0; j < halfM; j++) {
				resultMatrix[i + halfN][j] = originMatrix[i][j];
			}
		}

		// 4에서 3으로
		for (int i = halfN; i < N; i++) {
			for (int j = 0; j < halfM; j++) {
				resultMatrix[i][j + halfM] = originMatrix[i][j];
			}
		}
		// 3에서 2로
		for (int i = halfN; i < N; i++) {
			for (int j = halfM; j < M; j++) {
				resultMatrix[i - halfN][j] = originMatrix[i][j];
			}
		}

		// 2에서 1로
		for (int i = 0; i < halfN; i++) {
			for (int j = halfM; j < M; j++) {
				resultMatrix[i][j -halfM] = originMatrix[i][j];	
			}
		}
		originMatrix = resultMatrix;
	}

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		String[] NMR = br.readLine().split(" ");

		N = Integer.valueOf(NMR[0]);
		M = Integer.valueOf(NMR[1]);
		R = Integer.valueOf(NMR[2]);

		originMatrix = new int[N][];

		for (int i = 0; i < N; i++) {
			originMatrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
		}

		int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

		for (int command : commands) {
			switch (command) {
			case 1:
				solve1();
				break;
			case 2:
				solve2();
				break;
			case 3:
				solve3();
				break;
			case 4:
				solve4();
				break;
			case 5:
				solve5();
				break;
			case 6:
				solve6();
				break;
			}
		}

		for (int i = 0; i < originMatrix.length; i++) {
			for (int j = 0; j < originMatrix[i].length; j++) {
				System.out.print(originMatrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}
