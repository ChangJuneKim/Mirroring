package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	int N;
	boolean[][] visited;
	int[][] map;
	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };
	int sharkSize = 2;
	int time = 0;
	
	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
		}
		
		dfs();
	}

	private void dfs() {
		
	}

	private boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}