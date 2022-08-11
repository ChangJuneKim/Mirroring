package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ProfessorSolution {

	private static int N;
	private static int M;
	private static int[][] data;

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
		// 배열의 크기 N, M, 회전 수 R
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		int R = Integer.parseInt(split[2]);

		// 2차원 배열 생성
		data = new int[N][M];
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(split[j]);
			}
		}

		// 연산
		split = in.readLine().split(" ");
		int[] oper = new int[R];
		for (int i = 0; i < R; i++) {
			oper[i] = Integer.parseInt(split[i]);
		}

		/**
		 * 2. 알고리즘 풀기
		 */
		for (int i = 0; i < R; i++) {
			switch (oper[i]) {
			case 1:
				// 상하 반전
				rotate1();
				break;
				
			case 2:
				rotate2();
				break;
				
			case 3:
				rotate3();
				break;
				
			case 4:
				rotate4();
				break;
				
			case 5:
				rotate5();
				break;
				
			case 6:
				rotate6();
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}

		/**
		 * 3. 정답 출력
		 */

		System.out.println(sb);
	}

	// 상하 반전
	private static void rotate1() {
		int[][] result = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[N - 1 - i][j] = data[i][j];
			}
		}

		data = result;
	}
	
	// 좌우 반전
	private static void rotate2() {
		int[][] result = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][M - 1 - j] = data[i][j];
			}
		}
		
		data = result;
	}
	
	// 오른쪽 90도 회전
	private static void rotate3() {
		int[][] result = new int[M][N];
		
		int col = N - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[j][col] = data[i][j];
			}
			col--;
		}
		
		int temp = N;
		N = M;
		M = temp;
		
		data = result;
	}
	
	// 왼쪽 90도 회전
	private static void rotate4() {
		int[][] result = new int[M][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[M - 1 - j][i] = data[i][j];
			}
		}
		
		int temp = N;
		N = M;
		M = temp;
		
		data = result;
	}
	
	// 1 > 2, 2 > 3 ... 순으로 이동
	private static void rotate5() {
		int[][] result = new int[N][M];
		
		int midN = N / 2;
		int midM = M / 2;
		
		// 1 > 2
		for (int i = 0; i < midN; i++) {
			for (int j = 0; j < midM; j++) {
				result[i][midM + j] = data[i][j];
			}
		}
		
		// 2 > 3
		for (int i = 0; i < midN; i++) {
			for (int j = midM; j < M; j++) {
				result[midN + i][j] = data[i][j];
			}
		}
		
		// 3 > 4
		for (int i = midN; i < N; i++) {
			int col = 0;
			for (int j = midM; j < M; j++, col++) {
				result[i][col] = data[i][j];
			}
		}
		
		// 4 > 1
		int row = 0;
		for (int i = midN; i < N; i++, row++) {
			for (int j = 0; j < midM; j++) {
				result[row][j] = data[i][j];
			}
		}
		
		data = result;
	}
	
	// 1 > 4, 4 > 3 ... 순으로 이동
	private static void rotate6() {
		int[][] result = new int[N][M];
		
		int midN = N / 2;
		int midM = M / 2;
		
		// 1 > 4
		for (int i = 0; i < midN; i++) {
			for (int j = 0; j < midM; j++) {
				result[midN + i][j] = data[i][j];
			}
		}
		
		// 4 > 3
		for (int i = midN; i < N; i++) {
			for (int j = 0; j < midM; j++) {
				result[i][midM + j] = data[i][j];
			}
		}
		
		// 3 > 2
		int row = 0;
		for (int i = midN; i < N; i++, row++) {
			for (int j = midM; j < M; j++) {
				result[row][j] = data[i][j];
			}
		}
		
		// 2 > 1
		for (int i = 0; i < midN; i++) {
			int col = 0;
			for (int j = midM; j < M; j++, col++) {
				result[i][col] = data[i][j];
			}
		}
		
		data = result;
	}
}









