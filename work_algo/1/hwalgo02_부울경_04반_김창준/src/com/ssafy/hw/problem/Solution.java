package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public void solution() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		int T = Integer.valueOf(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.valueOf(br.readLine());
			
			int[][] snailNumber = new int[N][N];
			
			int number = 1;
			// 좌표
			int x = 0;
			int y = 0;
			int f = N;
			
			for (int i = 0; i < 2 * N - 1; i++) {
				switch (i % 4) {
				case 0: // 오른쪽으로 가기
					for (int j = 0; j < f; j++) {
						snailNumber[x][y] = number;
						y++;
						number++;
					}
					y--;
					x++;
					f--;
					break;
				case 1: // 밑으로 가기
					for (int j = 0; j < f; j++) {
						snailNumber[x][y] = number;
						x++;
						number++;
					}
					x--;
					y--;
					break;
				case 2: // 왼쪽으로 가기
					for (int j = 0; j < f; j++) {
						snailNumber[x][y] = number;
						y--;
						number++;
					}
					y++;
					x--;
					f--;
					break;
				case 3: // 위로 가기
					for (int j = 0; j < f; j++) {
						snailNumber[x][y] = number;
						x--;
						number++;
					}
					x++;
					y++;
					break;
				}
			}
			sb.append("#" + testCase + "\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(snailNumber[i][j] + " ");
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
