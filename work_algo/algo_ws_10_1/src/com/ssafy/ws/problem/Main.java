package com.ssafy.ws.problem;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	int min = Integer.MAX_VALUE;
	int N;
	int M;
	int[][] survivedChicken;
	int[][] city;
	int[][] chicken;
	int[][] house;

	public void solution() throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken()); // 도시 크기
		M = Integer.valueOf(st.nextToken()); // 남길 치킨집 개수

		// 1. 도시 정보 입력
		city = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				city[i][j] = Integer.valueOf(st.nextToken());
			}
		}

		// 2. 치킨집, 집 수 세기
		int chickenCount = 0;
		int houseCount = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (city[i][j] == 2) {
					chickenCount++;
				}
				if (city[i][j] == 1) {
					houseCount++;
				}
			}
		}

		// 3. 치킨집, 집 좌표 입력
		chicken = new int[chickenCount][2];
		house = new int[houseCount][2];
		int cIdx = 0;
		int hIdx = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (city[i][j] == 2) {
					chicken[cIdx++] = new int[] { i, j };
				}
				if (city[i][j] == 1) {
					house[hIdx++] = new int[] { i, j };
				}
			}
		}
		survivedChicken = new int[M][2];
		
		// 조합
		combination(0, 0, chickenCount, M);

		System.out.println(min);

	}

	private void combination(int depth, int start, int n, int r) {
		if (depth == r) {
			int sum = 0;
			for (int i = 0; i < house.length; i++) {
				int houseX = house[i][0];
				int houseY = house[i][1];
				int minDistance = Integer.MAX_VALUE;
				for (int j = 0; j < survivedChicken.length; j++) {
					int chickenX = survivedChicken[j][0];
					int chickenY = survivedChicken[j][1];

					int chickenDistance = Math.abs(houseX - chickenX) + Math.abs(houseY - chickenY);
					if(chickenDistance < minDistance) {
						minDistance = chickenDistance;
					}
				}
				sum += minDistance;
			}
			if (min > sum) {
				min = sum;
			}
			return;
		}

		for (int i = start; i < n; i++) {
			survivedChicken[depth] = chicken[i];
			combination(depth + 1, i + 1, n, r);
		}

	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}