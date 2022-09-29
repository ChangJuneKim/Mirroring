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

public class Main {
	final char WATER = '*';
	final char BEAVER = 'D';
	final char HEDGEHOG = 'S';
	final char EMPTY = '.';
	final char ROCK = 'X';

	int R, C;
	boolean[][] visited;
	char[][] forest;
	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };

	Queue<Point> queue = new ArrayDeque<>();
	Point hedgeHog, beaver;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());

		forest = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			forest[i] = br.readLine()
					.toCharArray();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (forest[i][j] == HEDGEHOG) {
					hedgeHog = new Point(i, j, 0);
				}

				if (forest[i][j] == WATER) {
					queue.offer(new Point(i, j, 0)); // 물부터 퍼트리자
//					visited[i][j] = true;
				}

				if (forest[i][j] == BEAVER) {
					beaver = new Point(i, j, 0);
				}
			}
		}

		bfs(hedgeHog);
		for (int i = 0; i < forest.length; i++) {
			System.out.println(Arrays.toString(forest[i]));
		}
		
		for (int i = 0; i < visited.length; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
	}

	private void bfs(Point start) {
		queue.offer(start);
		visited[start.x][start.y] = true;

		while (!queue.isEmpty()) {

			Point current = queue.poll();

			if (current.x == beaver.x && current.y == beaver.y) {
				System.out.println(current.cnt);
				return;
			}

			if (forest[current.x][current.y] == WATER) {
				for (int i = 0; i < 4; i++) {
					int nx = current.x + dx[i];
					int ny = current.y + dy[i];

					if (!isIn(nx, ny))
						continue;
					if (visited[nx][ny])
						continue;
					if (forest[nx][ny] == ROCK || forest[nx][ny] == BEAVER)
						continue;
					forest[nx][ny] = WATER;
					queue.offer(new Point(nx, ny, current.cnt));
					visited[nx][ny] = true;
				}
			} else {

				for (int i = 0; i < 4; i++) {
					int nx = current.x + dx[i];
					int ny = current.y + dy[i];

					if (!isIn(nx, ny))
						continue;
					if (visited[nx][ny])
						continue;
					if (forest[nx][ny] == ROCK || forest[nx][ny] == WATER)
						continue;

					forest[nx][ny] = HEDGEHOG;
					queue.offer(new Point(nx, ny, current.cnt + 1));
					visited[nx][ny] = true;
				}
			}

		}
		System.out.println("KAKTUS");

	}

	private boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < R && 0 <= ny && ny < C;
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}

class Point {
	int x, y, cnt;

	public Point(int x, int y, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}