package com.ssafy.offline1.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 교수님 풀이

public class ArrayTest_31 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("ArrayTest_31_input.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());  // 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");
			
			// 여기서부터 알고리즘 작성
			
			String[] NW = in.readLine().split(" ");
			int N = Integer.parseInt(NW[0]);  // 연못의 한 변 길이
			int W = Integer.parseInt(NW[1]);  // 소금쟁이(Water Strider) 수
			int[][] map = new int[N][N];  // 연못 정보를 담을 2차원 배열
			
			int[][] waterStrider = new int[W][3];
			for (int i = 0; i < W; i++) {
				String[] split = in.readLine().split(" ");
				
				waterStrider[i][0] = Integer.parseInt(split[0]);  // 행
				waterStrider[i][1] = Integer.parseInt(split[1]);  // 열
				waterStrider[i][2] = Integer.parseInt(split[2]);  // 방향(1: 하, 2: 우)
			}

			int answer = 0;
			int i = 0;  // 소금쟁이 인덱스 번호
			
			external:
			for (i = 0; i < W; i++) {
				int x = waterStrider[i][0];  // 시작 위치 i
				int y = waterStrider[i][1];  // 시작 위치 j
				int direction = waterStrider[i][2];  // 방향
				
				// 델타 (X, 하, 우)
				int[] dx = {0, 1, 0};
				int[] dy = {0, 0, 1};
				
				// 현재위치 확인
				if (map[x][y] == 1) {  // 이미 누가 뛴 자리면
					break;
				}
				else {
					map[x][y] = 1;  // 아니면 흔적 남기기
				}
				
				// 3칸, 2칸, 1칸씩 뛴다.
				int testX = x;
				int testY = y;
				for (int jump = 3; jump >= 1; jump--) {
					testX = testX + dx[direction] * jump;
					testY = testY + dy[direction] * jump;
					
					if ((0 <= testX && testX < N)
							&& (0 <= testY && testY < N)) {
						if (map[testX][testY] == 1) {  // 이미 누가 뛴 자리면
							break external;
						}
						else {
							map[testX][testY] = 1;  // 아니면 흔적 남기기
						}
					}
					else {
						break;
					}
				}
			}
			
			answer = i + 1;  // 소금쟁이 번호는 1부터 시작이므로 1 더해준다.
//			System.out.println("현재 소금쟁이 인덱스 번호 : " + i);
			// 만약 소금쟁이 수 보다 소금쟁이 번호가 크다면 같은 자리를 뛴 소금쟁이가 하나도 없다는 뜻
			if (answer > W) {
				answer = 0;
			}
			
			System.out.println(answer);
		}
	}
}

//public class ArrayTest_31 {
//	public static void print2d(int[][] lake) {
//		int m = lake.length;
//		int n = lake[0].length;
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(lake[i][j] + "  ");
//			}
//			System.out.println();
//		}
//		System.out.println("----------------------");
//	}
//
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("ArrayTest_31_input.txt"));
//
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(in.readLine()); // 테스트 케이스
//
//		for (int test_case = 1; test_case <= T; test_case++) {
//			System.out.print("#" + test_case + " ");
//
//			// 여기서부터 알고리즘 작성
//			String[] input = in.readLine().split(" "); // 공간의 한 변 길이
//
//			int N = Integer.parseInt(input[0]); // 연못 크기
//			int numOfBug = Integer.parseInt(input[1]); // 소금쟁이 수
//
//			int[][] lake = new int[N][N]; // 공간 정보를 담을 2차원 배열
//
//			int count = 0;
//			boolean flag = true;
//			
//			for (int i = 0; i < numOfBug; i++) {
//				
//				String[] bugData = in.readLine().split(" ");
//				
//				int x = Integer.parseInt(bugData[0]); // 행	
//				int y = Integer.parseInt(bugData[1]); // 열
//				int dir = Integer.parseInt(bugData[2]); // 소금쟁이 점프 방향
//
//				int[] dx = {}; // 델타 x
//				int[] dy = {}; // 델타 y
//
//				if (dir == 2) {
//					// 우
//					dx = new int[] { 0 };
//					dy = new int[] { 1 };
//				} else {
//					// 하
//					dx = new int[] { 1 };
//					dy = new int[] { 0 };
//				}
//
//				lake[x][y]++;
//				int nx = x;
//				int ny = y;
//				count++;
//				
//				for (int j = 3; j > 0; j--) {
//					nx += (dx[0] * j);
//					ny += (dy[0] * j);
//					if ((0 <= nx && nx < N) && (0 <= ny && ny < N)) {
//						lake[nx][ny]++;
//						if (lake[nx][ny] == 2) {
//							System.out.println(count);
//							flag = false;
//							break;
//						}
//					}
//					
//				}
//				
//			}
//			
//			if(flag) {
//				System.out.println(0);
//			}
//			
//
//		}
//	}
//
//}
