package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public void solution() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		final int T = 10;
		final int LADDER_SIZE = 100;

		for (int testCase = 1; testCase <= T; testCase++) {
			int testCaseNumber = Integer.valueOf(br.readLine());
			sb.append("#" + testCaseNumber + " ");
			int[][] ladder = new int[LADDER_SIZE][LADDER_SIZE];

			// 사다리 입력
			for (int i = 0; i < LADDER_SIZE; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < LADDER_SIZE; j++) {
					ladder[i][j] = Integer.valueOf(st.nextToken());
				}
			}

			// solve
			// "도착지"인 2에서 부터 올라감 좌, 우
			int dir = -1;
			for (int x = 0; x < LADDER_SIZE; x++) {
				if (ladder[99][x] == 2) {
					dir = x;
				}
			}


			for (int x = LADDER_SIZE - 2; x >= 0; x--) {
				// 왼쪽으로 갈 수 있으면
				if (dir - 1 > 0 && ladder[x][dir - 1] == 1) {
					while (ladder[x][dir - 1] == 1) {
						dir--;
						if(dir - 1 < 0) break;
					}
				} else if (dir < LADDER_SIZE - 1 && ladder[x][dir+1] == 1) {
					while (ladder[x][dir + 1] == 1) {
						dir++;
						if(dir+1 > LADDER_SIZE - 1) break;
					}
				}
			}
			sb.append(dir + "\n");

		}
		System.out.println(sb);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution().solution();
	}
}
