package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	int R, C;
	char[][] board;
	boolean[] used = new boolean[26];
	int answer;
	
	// 상 부터 시계방향
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	
	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.valueOf(st.nextToken()); // row
		C = Integer.valueOf(st.nextToken()); // column
		
		board = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		answer = Integer.MIN_VALUE;
		
		dfs(0,0,0);
		
		System.out.println(answer);
	}

	private void dfs(int x, int y, int count) {
		if(used[board[x][y] - 'A']) {
			answer = Math.max(answer, count);
			return;
		}else {
			used[board[x][y] - 'A'] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(isIn(nx, ny)) {
					dfs(nx, ny, count + 1);
				}
			}
			
			used[board[x][y] - 'A'] = false;
		}
	}

	private boolean isIn(int x, int y) {
		return  0 <= x && x < R && 0 <= y && y < C;
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}