package com.ssafy.offline1.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 교수님 풀이
public class ArrayTest_30 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test30_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());  // 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");

			// 여기서부터 알고리즘 작성
			int N = Integer.parseInt(in.readLine());  // 공간의 한 변 길이
			char[][] map = new char[N][N];  // 공간 정보를 담을 2차원 배열

			// 파일로부터 공간 정보를 불러와 2차원 배열에 담는다.
			for (int i = 0; i < N; i++) {
				String[] split = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = split[j].charAt(0);
				}
			}

			int answer = 0;
			
			// 이차원배열 완전탐색
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					char robot = map[x][y];

					int[] dx = {};  // 델타 x
					int[] dy = {};  // 델타 y
					
					// 로봇마다 델타 값을 초기화 시켜준다
					if (robot == 'A') {  // 우
						dx = new int[] {0};
						dy = new int[] {1};
					}
					else if (robot == 'B') {  // 좌우
						dx = new int[] {0, 0};
						dy = new int[] {-1, 1};
					}
					else if (robot == 'C') {  // 좌우상하
						dx = new int[] {0, 0, -1, 1};
						dy = new int[] {-1, 1, 0, 0};
					}

					for (int i = 0; i < dx.length; i++) {
						int testX = x + dx[i];
						int testY = y + dy[i];

						// 이동 후 위치가 경계 안쪽이면 계속 반복실행
						while ((0 <= testX && testX < N)
								&& (0 <= testY && testY < N)) {
							
							
							// 길
							if (map[testX][testY] == 'S') {
								answer++;
							}
							// 다른 로봇이나 벽
							else {
								break;
							}

							testX = testX + dx[i];
							testY = testY + dy[i];
						}
					}
				}
			}

			System.out.println(answer);
		}
	}
}

//public class ArrayTest_30 {
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
//		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("test30_input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int T = Integer.parseInt(br.readLine()); // 3
//
//		for (int testCase = 1; testCase <= T; testCase++) {
//			System.out.print("#" + testCase + " ");
//
//			int N = Integer.parseInt(br.readLine());
//			char[][] map = new char[N][N];
//
//			for (int i = 0; i < N; i++) {
//				String[] split = br.readLine().split(" ");
//				for (int j = 0; j < N; j++) {
//					map[i][j] = split[j].charAt(0);
//				}
//			}
//
//			int count = 0;
//			// 로봇은 벽이나 마찬가지, A는 우측으로만 / B는 좌우 / C는 4방
//			for (int x = 0; x < N; x++) {
//				for (int y = 0; y < N; y++) {
//					// A일 경우
//					/* A 시작 */
//					if (map[x][y] == 'A') {
//						// S 말고 다른걸 만날때 까지 우측 탐색
//
//						int k = y + 1;
//						while (k < N && map[x][k] == 'S') {
//							count++;
//							k++;
//						}
//
//					}
//					/* A 끝 */
//					
//					
//					/* B 시작 */
//					// B일 경우
//					if (map[x][y] == 'B') {
//						// S 말고 다른걸 만날때 까지 우측 탐색
//
//						int k = y + 1;
//						while (k < N && map[x][k] == 'S') {
//							count++;
//							k++;
//						}
//					// S 말고 다른걸 만날때 까지 좌측 탐색
//						k = y - 1;
//						while (k >= 0 && map[x][k] == 'S') {
//							count++;
//							k--;
//						}
//
//					}
//					/* B 끝*/
//					
//					/* C 시작 */
//					// C일 경우 4방향 탐색
//					if (map[x][y] == 'C') {
//						// S 말고 다른걸 만날때 까지 우측 탐색
//						int k = y + 1;
//						while (k < N && map[x][k] == 'S') {
//							count++;
//							k++;
//						}
//					// S 말고 다른걸 만날때 까지 좌측 탐색
//						k = y - 1;
//						while (k >= 0 && map[x][k] == 'S') {
//							count++;
//							k--;
//						}
//						
//						// 상향 탐색
//						k = x - 1;
//						while (k >= 0 && map[k][y] == 'S') {
//							count++;
//							k--;
//						}
//						
//						// 하향 탐색
//						k = x + 1;
//						while (k < N && map[k][y] == 'S') {
//							count++;
//							k++;
//						}
//					}
//					/* C 끝 */
//
//				}
//			}
//			
//			System.out.println(count);
//		}
//
//	}
//
//}
