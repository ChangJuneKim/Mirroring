package com.ssafy.ws02.step3;

/**
 * B구획의 빌딩 최고 높이 구하기
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

//public class Solution {
//
//	// 위부터 시계방향 8방향
//	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
//	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
//
//	public static void print2d(char[][] map) {
//		int m = map.length;
//		int n = map[0].length;
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(map[i][j] + "  ");
//			}
//			System.out.println();
//		}
//		System.out.println("----------------------");
//	}
//
//	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//		int T = Integer.parseInt(in.readLine()); // 테스트 케이스
//		int max=Integer.MIN_VALUE;	
//		
//		for (int test_case = 1; test_case <= T; test_case++) {
//			// 알고리즘 작성
//			int N = Integer.parseInt(in.readLine()); // 부지의 한 변 길이
//			char[][] map = new char[N][N]; // 부지 정보를 담을 2차원 배열
//			// 파일로부터 부지 정보를 불러와 2차원 배열에 담는다.
//			for (int i = 0; i < N; i++) {
//				String[] split = in.readLine().split(" ");
//				for (int j = 0; j < N; j++) {
//					map[i][j] = split[j].charAt(0);
//				}
//			}
//
////			print2d(map);
//			int result = 0;
//			for (int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					// 그린벨트가 아닌지역이면
//					if(map[i][j] == 'B') {
//						int foundB = 0;
//						for(int k = 0; k < 8; k++) {
//							int nx = i + dx[k];
//							int ny = j + dy[k];
//							
//							// 범위를 벗어난 경우 G가 없으니까 B라 치고 
//							if(nx < 0 || nx >= N || ny < 0 || ny >= N){
//								foundB++;
//								continue;
//							}				
//							// B인 경우
//							if(map[nx][ny] == 'B') {
//								foundB++;
//							}
//						}
//						
//						// G가 없으면 (8방향 다 B)
//						if(foundB == 8) {
//							result = 0;
//						
//							for (int r = 0; r < N; r++) {
//								if(map[i][r] == 'B') {
//									result++;
//								}
//								if(map[r][j] == 'B') {
//									result++;
//								}
//							}
//							
//							result -= 1;
//							if(max < result) {
//								max = result;
//							}
//						}
//					}
//				}
//			}
//			System.out.println("#" + test_case + " " + max);
//			max = 0;
//		}
//	}
//}

public class Solution {

	// 위부터 시계방향 8방향
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt")); // 문제에서 주어진 input 데이터 파일명 작성
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine()); // 테스트 케이스

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");

			// 여기서 부터 알고리즘 작성
			int N = Integer.parseInt(in.readLine()); // 부지의 한 변 길이
			char[][] map = new char[N][N]; // 부지 정보를 담을 2차원 배열

			// 파일로부터 부지 정보를 불러와 2차원 배열에 담는다.
			for (int i = 0; i < N; i++) {
				String[] split = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = split[j].charAt(0);
				}
			}

			int max = 0; // 가장 높이 세울 수 있는 빌딩 층수를 저장하는 변수

			// 2차원 배열 완전 탐색
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					int flag = 0; // 공원이 존재하면 1

					// 현 위치에서 주변 8방 탐색하여 공원이 있는지 여부 확인
					for (int i = 0; i < 8; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];

						if (0 <= nx && nx < N && 0 <= ny && ny < N) {

							// 주변에 공원이 있다면 탐색 중단
							if (map[nx][ny] == 'G') {
								flag = 1;
								break;
							}
						}
					}

					if (flag == 1) { // 인접 구획에 공원이 존재하면 2층
						if (max < 2) {
							max = 2;
						}
					} else if (flag == 0) { // 공원이 존재하지 않을 경우
						int cnt = 0;

						// 가로 빌딩 합
						for (int i = 0; i < N; i++) {
							if (map[x][i] == 'B') {
								cnt++;
							}
						}

						// 세로 빌딩 합
						for (int i = 0; i < N; i++) {
							if (map[i][y] == 'B') {
								cnt++;
							}
						}

						// 중복 하나 빼기
						cnt--;

						if (max < cnt) {
							max = cnt;
						}
					}
				}
			}
			System.out.println(max);
		}
	}
}