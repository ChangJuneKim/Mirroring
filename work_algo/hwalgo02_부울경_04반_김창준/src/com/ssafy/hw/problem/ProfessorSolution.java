package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProfessorSolution {

	public void solution() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		int T = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("# " + testCase + "\n");

			int N = Integer.valueOf(br.readLine()); // 달팽이 크기
			int[][] snailNumber = new int[N][N]; // 달팽이 2차원 배열

			// 우 하 좌 상
			int[] dx = { 0, 1, 0, -1 };
			int[] dy = { 1, 0, -1, 0 };
			
			int number = 1;
			int endNumber = N * N; // 끝 숫자
			
			// (0, 0) 부터 시작
			int curX = 0;
			int curY = 0;
			
			// 방향은 우측부터
			int dir = 0;
			
			// 배열에 저장
			snailNumber[curX][curY] = number;
			
			while(number < endNumber) {
				int testX = curX + dx[dir];
				int testY = curY + dy[dir];
				
				// 이동할 좌표 경계체크와 방문여부 확인
				if((0 <= testX && testX < N) && (0 <= testY && testY < N) && (snailNumber[testX][testY] == 0)) {
					// 현재 좌표 이동
					curX = testX;
					curY = testY;
					
					// 현재 좌표에 숫자 저장
					snailNumber[curX][curY] = ++number;
				} else {
					// 경계를 벗어나거나 이미 방문했을 경우 방향전환을 해준다
					dir = (dir + 1) % 4;
				}
			
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(snailNumber[i][j] + " ");
				}
				sb.append("\n");
			}

			System.out.println(sb);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution().solution();
	}
}
