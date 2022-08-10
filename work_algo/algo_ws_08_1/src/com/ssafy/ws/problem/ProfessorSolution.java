package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProfessorSolution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		String[] NMR = br.readLine().split(" ");

		int N = Integer.valueOf(NMR[0]);
		int M = Integer.valueOf(NMR[1]);
		int R = Integer.valueOf(NMR[2]);
		int[][] matrix = new int[N][];
		
		// 배열 입력 완료
		for (int i = 0; i < N; i++) {
			matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
		}
		
		for (int k = 0; k < R; k++) {
			for (int i = 0; i < Math.min(N, M) / 2; i++) {
				// 시작 지점 설정
				int startX = 0 + i;
				int startY = 0 + i;

				// 끝 지점 설정
				int endX = N - 1 - i;
				int endY = M - 1 - i;

				int temp = matrix[startX][startY];
//				int temp2 = matrix[endX][endY];

				// 윗변 : 오른쪽에서 왼쪽으로 이동
				for (int j = startY; j < endY; j++) {
					matrix[startX][j] = matrix[startX][j + 1];
				}

				// 우변 : 아래에서 위로
				for (int j = startX; j < endX; j++) {
					matrix[j][endY] = matrix[j + 1][endY];
				}

				// 아랫변 : 왼쪽에서 오른쪽으로
				for (int j = endY; j > startX; j--) {
					matrix[endX][j] = matrix[endX][j - 1];
				}

				// 좌변 : 위에서 아래로
				for (int j = endX; j > startX; j--) {
					matrix[j][startY] = matrix[j - 1][startY];
				}

				// 처음 빼낸 값을 다시 넣기
				matrix[startX + 1][startY] = temp;
			}	
		}
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	
}
