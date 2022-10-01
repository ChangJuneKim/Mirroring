package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 15683 감시 -> 브루트포스
public class Main {
	// 입력받은 배열
	static int[][] arr;
	// 1~5번 cctv회전할 수 있는 경우의 수
	static int[] cctvCase = { 0, 4, 2, 4, 4, 1 };
	static int answer = 0, n, m;
	// cctv수, cctv x,y값, cctv타입 번호
	static int cctvCount = 0, cctv[][] = new int[8][3];

	static void search(int depth) {
		// 모든 cctv감시구역을 체크했을 때
		if (depth == cctvCount) {
			answer = Math.min(answer, getCount());
			return;
		}
		// cctv의 타입에 맞게 회전시킴
		for (int d = 0; d < cctvCase[cctv[depth][2]]; d++) {
			find(cctv[depth][0], cctv[depth][1], cctv[depth][2], d, 0);
			search(depth + 1);
			find(cctv[depth][0], cctv[depth][1], cctv[depth][2], d, 1);
		}
	}

	// 각 방향으로 cctv감시구역 체크(x값,y값,cctv타입,방향,back 0:감시구역 탐색, 1:탐색했던 구역 되돌리기)
	static void check(int x, int y, int d, int back) {
		switch (d) {
		// 하
		case 0:
			for (int i = x + 1; i < n; i++) {
				if (back == 0 && arr[i][y] <= 0)
					arr[i][y] -= 1;
				else if (back == 1 && arr[i][y] < 0)
					arr[i][y] += 1;
				else if (arr[i][y] == 6)
					break;
			}
			break;
		// 우
		case 1:
			for (int i = y + 1; i < m; i++) {
				if (back == 0 && arr[x][i] <= 0)
					arr[x][i] -= 1;
				else if (back == 1 && arr[x][i] < 0)
					arr[x][i] += 1;
				else if (arr[x][i] == 6)
					break;
			}
			break;
		// 상
		case 2:
			for (int i = x - 1; i >= 0; i--) {
				if (back == 0 && arr[i][y] <= 0)
					arr[i][y] -= 1;
				else if (back == 1 && arr[i][y] < 0)
					arr[i][y] += 1;
				else if (arr[i][y] == 6)
					break;
			}
			break;
		// 좌
		default:
			for (int i = y - 1; i >= 0; i--) {
				if (back == 0 && arr[x][i] <= 0)
					arr[x][i] -= 1;
				else if (back == 1 && arr[x][i] < 0)
					arr[x][i] += 1;
				else if (arr[x][i] == 6)
					break;
			}
			break;
		}
	}

	// cctv 타입에 맞게 감시구역 탐색
	static void find(int x, int y, int type, int d, int back) {
		switch (type) {
		// 1번 cctv
		case 1:
			switch (d) {
			// 하
			case 0:
				check(x, y, 0, back);
				break;
			// 우
			case 1:
				check(x, y, 1, back);
				break;
			// 상
			case 2:
				check(x, y, 2, back);
				break;
			// 좌
			case 3:
				check(x, y, 3, back);
				break;
			}
			break;
		// 2번 cctv
		case 2:
			switch (d) {
			// 상하
			case 0:
				check(x, y, 0, back);
				check(x, y, 2, back);
				break;
			// 좌우
			case 1:
				check(x, y, 1, back);
				check(x, y, 3, back);
				break;
			}
			break;
		// 3번 cctv
		case 3:
			switch (d) {
			// 하우
			case 0:
				check(x, y, 0, back);
				check(x, y, 1, back);
				break;
			// 상우
			case 1:
				check(x, y, 1, back);
				check(x, y, 2, back);
				break;
			// 상좌
			case 2:
				check(x, y, 2, back);
				check(x, y, 3, back);
				break;
			// 하좌
			case 3:
				check(x, y, 3, back);
				check(x, y, 0, back);
				break;
			}
			break;
		// 4번 cctv
		case 4:
			switch (d) {
			// 하우상
			case 0:
				check(x, y, 0, back);
				check(x, y, 1, back);
				check(x, y, 2, back);
				break;
			// 우상좌
			case 1:
				check(x, y, 1, back);
				check(x, y, 2, back);
				check(x, y, 3, back);
				break;
			// 상우하
			case 2:
				check(x, y, 2, back);
				check(x, y, 3, back);
				check(x, y, 0, back);
				break;
			// 우하좌
			case 3:
				check(x, y, 3, back);
				check(x, y, 0, back);
				check(x, y, 1, back);
				break;
			}
			break;
		// 5번 cctv
		case 5:
			// 상하좌우
			for (int i = 0; i < 4; i++) {
				check(x, y, i, back);
			}
			break;
		}
	}

	// 사각지대 수 return
	static int getCount() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = temp;
				// cctv가 설치되지 않았을 때의 값을 answer의 시작값으로
				if (temp == 0)
					answer++;
				else if (temp > 0 && temp < 6) {
					cctv[cctvCount][0] = i;
					cctv[cctvCount][1] = j;
					cctv[cctvCount++][2] = temp;
				}
			}
		}
		// cctv가 없는 경우 cctv가 설치되지 않았을 때의 값 그대로 print
		if (cctvCount == 0)
			System.out.println(answer);
		else {
			search(0);
			System.out.println(answer);
		}
	}
}