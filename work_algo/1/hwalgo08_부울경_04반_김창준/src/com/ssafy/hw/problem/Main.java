package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	int N, M, R;
	int[][] matrix;
	int[][] arr;
	List<int[]> list = new ArrayList<>(); // (r,c,s) 담기
	int min;

	public void solution() throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken()); // 회전 횟수

		matrix = new int[N][M];
		arr = new int[N][M]; // matrix의 복사본

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = matrix[i][j];
			}
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1; // 0 base index
			int c = Integer.parseInt(st.nextToken()) - 1; // 0 base index
			int s = Integer.parseInt(st.nextToken());

			list.add(new int[] { r, c, s }); // list에 저장
		}

		min = Integer.MAX_VALUE;
		
		perm(0, new int[R], new boolean[R]);
		
		System.out.println(min);
	}

	public void perm(int depth, int[] selected, boolean[] visited) {
		if (depth == R) {
			for (int i = 0; i < R; i++) {
				int idx = selected[i];
				rotate(list.get(idx)); // 만들어진 명령 순서에 따라 회전하기
			}
			
			// 행렬의 각 행의 합 구해서 최소 합 구하기
			for (int i = 0; i < N; i++) {
				int sum = 0;
				
				for (int j = 0; j < M; j++) {
					sum += arr[i][j];
				}
				
				min = Math.min(min, sum);
			}
			return;
		}

		for (int i = 0; i < R; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[depth] = i;
				
				perm(depth + 1, selected, visited);
				
				visited[i] = false;
			}
		}
	}

	// 시계방향 회전
	public void rotate(int[] info) {
		int r = info[0];
		int c = info[1];
		int s = info[2];

		int sx = r - s, sy = c - s;
		int ex = r + s, ey = c + s;

		int group = s;

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int i = 0; i < group; i++) {
			int x = sx + i;
			int y = sy + i;
			int d = 0;
			int tmp = arr[x][y];
			
			while (d < 4) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx >= sx + i && nx <= ex - i && ny >= sy + i && ny <= ey - i) {
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				} else {
					d++;
				}
			}
			
			arr[x][y + 1] = tmp;
		}

	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}