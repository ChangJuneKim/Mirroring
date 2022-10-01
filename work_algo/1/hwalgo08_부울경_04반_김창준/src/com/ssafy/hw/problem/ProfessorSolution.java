package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProfessorSolution {
	int N, M, K;

	int[][] input; // 회전 연산들을 저장하는 배열
	int[][] RCS; // 선택된 회전 연산을 저장하는 배열
	boolean[] isSelected; // 순열에서 사용할 flag

	int[][] A; // 문제에서 주어진 2차원 배열
	int min; // 각 행의 합 중에서 최솟값

	public void solution() throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		// 배열 크기 N, M, 회전 연산 수 K
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 회전 횟수

		A = new int[N + 1][M + 1]; // 1번 인덱스 부터 사용

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		input = new int[K][3];
		// 회전 연산의 정보 r c s 배열
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int[] temp = new int[3];
			temp[0] = Integer.parseInt(st.nextToken());
			temp[1] = Integer.parseInt(st.nextToken());
			temp[2] = Integer.parseInt(st.nextToken());

			input[i] = temp;
		}

		// 초기화
		RCS = new int[K][3];
		isSelected = new boolean[K];
		min = 100 * 50; // 한 칸에 들어갈 수 있는 최댓값 * 최대 열 수

		perm(0);

		System.out.println(min);
	}

	private void perm(int depth) {
		if (depth == K) {
			// A 배열을 B 배열로 복사
			int[][] B = new int[N + 1][M + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					B[i][j] = A[i][j];
				}
			}
			// 순열에 의해 RCS에 입력된 회전 연산 순서대로 실행
			for (int k = 0; k < K; k++) {
				// 모든 연산 중 하나를 선택하여 RCS 배열에 담는다.
				// 선택된 연산을 RCS 배열을 이용하여 수행한다.
				// RCS[0] = input[1];

				// 회전 연산의 정보 r, c, s
				int r = RCS[k][0];
				int c = RCS[k][1];
				int s = RCS[k][2];

				// 가장 왼쪽 윗칸
				int startX = r - s;
				int startY = c - s;

				// 가장 오른쪽 아랫칸
				int endX = r + s;
				int endY = c + s;

				// 돌려야 할 사각형 개수
				int rectCount = Math.min(endX - startX + 1, endY - startY + 1) / 2;

				for (int i = 0; i < rectCount; i++) {

					// 돌려야 할 사각형 기준점 변경
					startX = r - s + i;
					startY = c - s + i;
					endX = r + s - i;
					endY = c + s - i;

					int temp = A[startX][startY]; // 사각형 좌측 상단의 값을 임시저장

					// 좌변 : 아래에서 위로 이동
					for (int x = startX; x < endX; x++) {
						A[x][startY] = A[x + 1][startY];
					}

					// 아랫변 : 오른쪽에서 왼쪽 이동
					for (int y = startY; y < endY; y++) {
						A[endX][y] = A[endX][y + 1];
					}

					// 우변 : 위에서 아래로 이동
					for (int x = endX; x > startX; x--) {
						A[x][endY] = A[x - 1][endY];
					}

					// 윗변 : 왼쪽에서 오른쪽 이동
					for (int y = endY; y > startY; y--) {
						A[startX][y] = A[startX][y - 1];
					}

					// 임시 값 다시 넣기
					A[startX][startY + 1] = temp;
				}

			}
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= M; j++) {
					sum += A[i][j];
				}

				if (sum < min) {
					min = sum;
				}
			}

			A = B; // 배열 초기화
			return;

		}

		for (int i = 0; i < isSelected.length; i++) {
			if (isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			RCS[depth] = input[i];
			perm(depth + 1);
			isSelected[i] = false;
		}

	}

	public static void main(String[] args) throws Exception {
		new ProfessorSolution().solution();
	}
}
