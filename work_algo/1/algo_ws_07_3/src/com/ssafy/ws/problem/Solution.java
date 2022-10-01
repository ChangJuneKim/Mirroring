package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	int N;
	public boolean isValidCoords(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		int TC = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			sb.append("#").append(testCase).append(" ");
			N = Integer.valueOf(br.readLine());

			int[][] rooms = new int[N][];
			
			for (int i = 0; i < N; i++) {
				rooms[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			}

			int maxCount = 0;
			int maxStart = 0;
			
			// 상하좌우
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };
			
			
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					int sx = x; // startx
					int sy = y; // starty
					
					int moveCount = 1; // 제자리도 1 카운트
					int moveStart = rooms[sx][sy]; // 출발점의 값
					
					boolean flag = true;
					while(flag) {
						flag = false;
						// 사방탐색
						for (int i = 0; i < 4; i++) {
							int nx = sx + dx[i];
							int ny = sy + dy[i];
							
							if(isValidCoords(nx, ny) && rooms[sx][sy] + 1 == rooms[nx][ny]) {
								flag = true;
								moveCount++;
								sx = nx;
								sy = ny;
								break;
							}
						}
					}
					if(moveCount > maxCount) {
						maxCount = moveCount;
						maxStart = moveStart;
					} else if(maxCount == moveCount){
						maxStart = Math.min(maxStart, moveStart);
					}
				}
			}
			sb.append(maxStart).append(" ").append(maxCount).append("\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}
