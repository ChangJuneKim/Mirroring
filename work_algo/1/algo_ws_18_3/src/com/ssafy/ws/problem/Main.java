package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int x, y;
	int day;

	public Tomato(int x, int y, int day) {
		super();
		this.x = x;
		this.y = y;
		this.day = day;
	}

	@Override
	public String toString() {
		return "Tomato [x=" + x + ", y=" + y + ", day=" + day + "]";
	}

}

public class Main {

	int N, M;
	boolean[][] visited;
	int[][] box;

	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };

	Queue<Tomato> queue = new ArrayDeque<Tomato>();

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		box = new int[N][M];

		for (int i = 0; i < N; i++) {
			box[i] = Arrays.stream(br.readLine()
					.split(" "))
					.mapToInt(Integer::valueOf)
					.toArray();
		}

		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1) {
					queue.offer(new Tomato(i, j, 0));
				}
			}
		}

		bfs();

	}

	private void bfs() {
		int day = 0;

		while (!queue.isEmpty()) {
			Tomato current = queue.poll();
			int x = current.x;
			int y = current.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (isIn(nx, ny)) {
					if (box[nx][ny] == 0) {
						queue.offer(new Tomato(nx, ny, current.day + 1));
						box[nx][ny] = 1;
					}
				}
			}

			day = current.day;
//			for (int i = 0; i < box.length; i++) {
//				System.out.println(Arrays.toString(box[i]));
//			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(day);
	}

	private boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}