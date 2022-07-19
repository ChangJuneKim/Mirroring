package com.ssafy.offline1.array;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.InputStreamReader;

public class ArrayTest_31 {
	public static void print2d(int[][] lake) {
		int m = lake.length;
		int n = lake[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(lake[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("ArrayTest_31_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine()); // 테스트 케이스

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");

			// 여기서부터 알고리즘 작성
			String[] input = in.readLine().split(" "); // 공간의 한 변 길이

			int N = Integer.parseInt(input[0]);
			int numOfBug = Integer.parseInt(input[1]);

			int[][] lake = new int[N][N]; // 공간 정보를 담을 2차원 배열

			int count = 0;
			boolean flag = true;
			
			for (int i = 0; i < numOfBug; i++) {
				
				String[] bugData = in.readLine().split(" ");
				int x = Integer.parseInt(bugData[0]);
				int y = Integer.parseInt(bugData[1]);
				int dir = Integer.parseInt(bugData[2]);

				int[] dx = {}; // 델타 x
				int[] dy = {}; // 델타 y

				if (dir == 2) {
					// 우
					dx = new int[] { 0 };
					dy = new int[] { 1 };
				} else {
					// 하
					dx = new int[] { 1 };
					dy = new int[] { 0 };
				}

				lake[x][y]++;
				int nx = x;
				int ny = y;
				count++;
				
				for (int j = 3; j > 0; j--) {
					nx += (dx[0] * j);
					ny += (dy[0] * j);
					if ((0 <= nx && nx < N) && (0 <= ny && ny < N)) {
						lake[nx][ny]++;
						if (lake[nx][ny] == 2) {
							System.out.println(count);
							flag = false;
							break;
						}
					}
					
				}
				
			}
			
			if(flag) {
				System.out.println(0);
			}
			

		}
	}

}
