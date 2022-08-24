package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	int N;
	char[][] grid;
	boolean[][] visited;

	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };

	int count;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.valueOf(br.readLine());

		grid = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			grid[i] = br.readLine()
					.toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		System.out.print(count + " ");

		visited = new boolean[N][N];
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfsRG(i, j);
					count++;
				}
			}
		}

		System.out.println(count);

	}

	private void dfsRG(int x, int y) {
		visited[x][y] = true;

		char currentColor = grid[x][y];

		if (currentColor == 'B') {
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isIn(nx, ny) && !visited[nx][ny]) {
					if (grid[nx][ny] == 'B') {
						dfsRG(nx, ny);
					}
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isIn(nx, ny) && !visited[nx][ny]) {
					if (grid[nx][ny] == 'G' || grid[nx][ny] == 'R') {
						dfsRG(nx, ny);
					}
				}
			}
		}

	}

	private void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isIn(nx, ny) && !visited[nx][ny]) {
				if (grid[x][y] == grid[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}

	}

	private boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
