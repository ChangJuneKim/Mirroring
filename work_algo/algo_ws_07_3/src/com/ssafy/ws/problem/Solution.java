//package com.ssafy.ws.problem;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class Solution {
//	public void solution() throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder("");
//
//		int TC = Integer.valueOf(br.readLine());
//
//		for (int testCase = 1; testCase <= TC; testCase++) {
//			sb.append("#").append(testCase).append(" ");
//			int N = Integer.valueOf(br.readLine());
//
//			int[][] rooms = new int[N][];
//			int[][] counts = new int[N][N];
//			
//			for (int i = 0; i < N; i++) {
//				rooms[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
//			}
//
//			// 상하좌우
//			int[] dx = { -1, 1, 0, 0 };
//			int[] dy = { 0, 0, -1, 1 };
//			int count = 1;
//			for (int x = 0; x < N; x++) {
//				for (int y = 0; y < N; y++) {
//					
//					int nx = x;
//					int ny = y;
//					int max = -1;
//					for (int i = 0; i < 4; i++) {
//						nx = x + dx[i];
//						ny = y + dy[i];
//						if (0 <= nx && nx < N && 0 <= ny && ny < N) {
//							if (rooms[x][y] == rooms[nx][ny] - 1) {
//								count++;
//								while(true) {
//									for (int j = 0; j < 4; j++) {
//										if (rooms[x][y] == rooms[nx][ny] - 1) {
//											count++;
//										}
//									}
//								}
//								if (max < count) {
//									max = count;
//								}
//							}
//						} else {
//							continue;
//						}
//					}
//					System.out.println(max);
//
//				}
//			}
//		}
//	}
//
//	public static void main(String[] args) throws IOException {
//		new Solution().solution();
//	}
//}
