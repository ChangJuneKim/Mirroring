package com.ssafy.offline1.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 교수님 풀이
public class ArrayTest_32 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("ArrayTest_32_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine()); // 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");

			// 여기서부터 알고리즘 작성

			String[] split = in.readLine().split(" "); // 첫번째 줄 읽어들이기
			int N = Integer.parseInt(split[0]); // 배열의 크기
			int x = Integer.parseInt(split[1]); // 출발점 행
			int y = Integer.parseInt(split[2]); // 출발점 열
			int J = Integer.parseInt(split[3]); // 점퍼의 개수

			int[] jX = new int[J]; // 점퍼의 행 모음
			int[] jY = new int[J]; // 점퍼의 열 모음

			split = in.readLine().split(" "); // 두번째 줄 읽어들이기
			for (int i = 0, j = 0; i < split.length / 2; i++, j = j + 2) {
				jX[i] = Integer.parseInt(split[j]);
				jY[i] = Integer.parseInt(split[j + 1]);
			}

			int d = Integer.parseInt(in.readLine()); // 세번째 줄 읽어들이기 (방향 지시의 개수)

			int[] dDirection = new int[d]; // 방향 모음
			int[] dMove = new int[d]; // 이동 칸 수 모음

			split = in.readLine().split(" "); // 네번째 줄 읽어들이기
			for (int i = 0, j = 0; i < split.length / 2; i++, j = j + 2) {
				dDirection[i] = Integer.parseInt(split[j]);
				dMove[i] = Integer.parseInt(split[j + 1]);
			}

			// 미로의 좌표는 (1, 1) 부터 시작이므로 더하기 1을 한다.
			// 인덱스 0은 벽으로 처리 (경계 체크 시, 주의한다.)
			int[][] map = new int[N + 1][N + 1];

			// 2차원 배열에 점퍼를 표시 (-1)
			for (int i = 0; i < J; i++) {
				int testX = jX[i];
				int testY = jY[i];

				map[testX][testY] = -1;
			}

			int answerX = 0;
			int answerY = 0;

			// 현재 위치가 점퍼이면 (0, 0)
			if (map[x][y] == -1) {
				answerX = 0;
				answerY = 0;

				System.out.println(answerX + " " + answerY);
				continue; // 결과 출력 후, 다음 테스트 케이스로 넘어감
			}

			// 델타 활용 (0: X, 1: 상, 2: 우, 3: 하, 4: 좌)
			int[] dx = { 0, -1, 0, 1, 0 };
			int[] dy = { 0, 0, 1, 0, -1 };

			int testX = x;
			int testY = y;

			// 방향 지시의 개수만큼 반복
			external: for (int i = 0; i < d; i++) {
				for (int j = 0; j < dMove[i]; j++) {
					testX = testX + dx[dDirection[i]];
					testY = testY + dy[dDirection[i]];

					// 이동 후 경계 안쪽이면 현재 위치 저장
					if ((1 <= testX && testX < N + 1) && (1 <= testY && testY < N + 1)) {
						answerX = testX;
						answerY = testY;
					}
					// 경계 밖 혹은 그 외의 경우는 (0, 0)
					else {
						answerX = 0;
						answerY = 0;
						break external;
					}

					// 이동 후 위치가 점퍼이면 (0, 0)
					if (map[testX][testY] == -1) {
						answerX = 0;
						answerY = 0;
						break external;
					}
				}
			}

			System.out.println(answerX + " " + answerY);
		}
	}

}

//public class ArrayTest_32 {
//	public static void print2d(int[][] map) {
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
//		// N x N 미로에 (1,1) 시작
//		// 점퍼에 도착(스쳐도)하면 밖으로 이동 가능
//		// 점퍼로 밖으로 나왔거나, 이동 시 N x N을 벗어나면 (0,0)
//
//		// 1 북 2 동 3 남 4 서
//
//		System.setIn(new FileInputStream("ArrayTest_32_input.txt")); // 입력 파일 받아오기
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//		int T = Integer.parseInt(in.readLine()); // testcase
//
//		for (int i = 1; i <= T; i++) {
//			System.out.print("#" + i + " ");
//			String[] split = in.readLine().split(" ");
//			int N = Integer.parseInt(split[0]); // 미로 칸 수
//			int startX = Integer.parseInt(split[1]); // 시작점 x
//			int startY = Integer.parseInt(split[2]); // 시작점 y
//			int countOfJumper = Integer.parseInt(split[3]); // 점퍼의 개수
//
//			int[][] matrix = new int[N + 2][N + 2];
//
//			String[] jumperCoords = in.readLine().split(" ");
//
//			// 점퍼 좌표를 1으로 표시
//			for (int j = 0; j < countOfJumper * 2; j += 2) {
//				int jumperX = Integer.parseInt(jumperCoords[j]);
//				int jumperY = Integer.parseInt(jumperCoords[j + 1]);
//				matrix[jumperX][jumperY] = 1;
//			}
//
//			int countOfmoveBehaviors = Integer.parseInt(in.readLine());
//			String[] moveBehaviors = in.readLine().split(" ");
//			
//			int x = startX;
//			int y = startY;
//			
//			int[] dx = {0, -1, 0, 1, 0};
//			int[] dy = {0, 0, 1, 0, -1};
//			
//			for (int j = 0; j < countOfmoveBehaviors * 2; j += 2) {
//				int direction = Integer.parseInt(moveBehaviors[j]); // 방향
//				int moveCount = Integer.parseInt(moveBehaviors[j + 1]); // 몇 칸?
//				
//				for (int k = 1; k <= moveCount; k++) {
//					
//					x += dx[direction];
//					y += dy[direction];
//					
//					if(x < 1 || y < 1 || x >= N || y >= N || matrix[x][y] == 1) {
//						x = 0;
//						y = 0;
//						break;
//					}
//				}
//			}
//			System.out.printf("%d %d\n", x, y);
////			print2d(matrix);
//			
//		}
//
//	}
//
//}
