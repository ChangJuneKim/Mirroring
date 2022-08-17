package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	int m, a;
	int[] moveA, moveB;
	BC[] bcList;
	Index A, B;
	int[] dx = { 0, -1, 0, 1, 0 };
	int[] dy = { 0, 0, 1, 0, -1 };

	// 좌표
	class Index {
		int x;
		int y;

		public Index(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void setIndex(int dir) {
			this.x = x + dx[dir];
			this.y = y + dy[dir];
		}

		@Override
		public String toString() {
			return "Index [x=" + x + ", y=" + y + "]";
		}
		
		
	}

	// Battery Charger
	class BC {
		Index index;
		int range;
		int power;

		public BC(int x, int y, int range, int power) {
			this.index = new Index(x, y);
			this.range = range;
			this.power = power;
		}
	}

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");

		int T = Integer.valueOf(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			m = Integer.valueOf(st.nextToken());
			a = Integer.valueOf(st.nextToken());

			bcList = new BC[a];

			// A,B 의 이동 정보
			moveA = new int[m + 1];
			moveB = new int[m + 1];
			moveA[0] = 0;
			moveB[0] = 0;

			A = new Index(0, 0); // 왼쪽 위 끝
			B = new Index(9, 9); // 오른쪽 아래 끝

			// 사용자 A의 이동 정보 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				moveA[i] = Integer.valueOf(st.nextToken());
			}

			// 사용자 B의 이동 정보 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				moveB[i] = Integer.valueOf(st.nextToken());
			}

			// 배터리 충전기의 정보 입력
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				// 좌표
				int x = Integer.valueOf(st.nextToken());
				int y = Integer.valueOf(st.nextToken());
				// 범위
				int C = Integer.valueOf(st.nextToken());
				// 파워
				int P = Integer.valueOf(st.nextToken());

				bcList[i] = new BC(y - 1, x - 1, C, P);
			}

			int sum = 0;
			
			// (0, 0) 에서도 체크 해야한다!
			for (int i = 0; i <= m; i++) {
				A.setIndex(moveA[i]); // A, B 이동(방향)
				B.setIndex(moveB[i]);
				
				System.out.println(A + " " +  B);
				boolean[][] check = new boolean[2][a];
				// 범위 안에 들어오는지 체크
				for (int j = 0; j < a; j++) {
					BC bc = bcList[j];
					if (getDistance(A, bc.index) <= bc.range) {
						check[0][j] = true;
					}
					if (getDistance(B, bc.index) <= bc.range) {
						check[1][j] = true;
					}
				}
				
				for (int j = 0; j < check.length; j++) {
					System.out.println(Arrays.toString(check[j]));
				}
				System.out.println();
				
				sum += getMax(check);
			}

			int answer = sum;

			sb.append("#")
					.append(t)
					.append(" ")
					.append(answer)
					.append("\n");
		}
		System.out.println(sb);

	}

	public int getMax(boolean[][] check) { // 해당 위치에서의 최대 양 반환
		int max = 0;
		int value;
		boolean checkA;
		boolean checkB;

		for (int i = 0; i < a; i++) {
			checkA = check[0][i];
			for (int j = 0; j < a; j++) {
				checkB = check[1][j];
				value = 0;

				// 같은 범위에 있는 경우
				if (i == j && checkA && checkB) {
					value = bcList[i].power;
				} else {
					if (checkA) {
						value += bcList[i].power;
					}
					if (checkB) {
						value += bcList[j].power;
					}
				}
				max = Math.max(max, value);
			}
		}
		return max;
	}

	// 맨하탄 거리 구하기
	public int getDistance(Index a, Index b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}