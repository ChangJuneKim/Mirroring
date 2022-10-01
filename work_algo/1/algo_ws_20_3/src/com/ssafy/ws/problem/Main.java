package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Dust {
	int x, y, quantity;

	public Dust(int x, int y, int quantity) {
		super();
		this.x = x;
		this.y = y;
		this.quantity = quantity;
	}

}

public class Main {

	int R, C, T;
	int[][] room;

	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };

	Queue<Dust> queue = new ArrayDeque<Dust>();
	int cleaner = -1;

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		T = Integer.valueOf(st.nextToken());

		room = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.valueOf(st.nextToken());
				if (cleaner == -1 && room[i][j] == -1) {
					cleaner = i;
				}
			}
		}

		for (int t = 0; t < T; t++) {
			checkDust();
			bfs();
			operate();
		}

		int result = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] == -1) {
					continue;
				}
				result += room[i][j];
			}
		}
		System.out.println(result);
	}

	private void checkDust() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] != 0 && room[i][j] != -1) {
					queue.offer(new Dust(i, j, room[i][j]));
				}
			}
		}

	}

	private void bfs() {
		while (!queue.isEmpty()) {
			Dust current = queue.poll();
			if (current.quantity < 5) {
				continue;
			}
			int curX = current.x;
			int curY = current.y;
			int spreadQuantity = current.quantity / 5;

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (isIn(nx, ny) && room[nx][ny] != -1) {
					room[curX][curY] -= spreadQuantity;
					current.quantity = room[curX][curY];
					room[nx][ny] += spreadQuantity;
				}
			}
		}

	}

	void operate() {
		int topX = cleaner;
		int bottomX = cleaner + 1;

		for (int x = topX - 1; x > 0; x--) {
			room[x][0] = room[x - 1][0];
		}

		for (int y = 0; y < C - 1; y++) {
			room[0][y] = room[0][y + 1];
		}

		for (int x = 0; x < topX; x++) {
			room[x][C - 1] = room[x + 1][C - 1];
		}

		for (int y = C - 1; y > 1; y--) {
			room[topX][y] = room[topX][y - 1];
		}

		room[topX][1] = 0;

		for (int x = bottomX + 1; x < R - 1; x++) {
			room[x][0] = room[x + 1][0];
		}

		for (int y = 0; y < C - 1; y++) {
			room[R - 1][y] = room[R - 1][y + 1];
		}

		for (int x = R - 1; x > bottomX; x--) {
			room[x][C - 1] = room[x - 1][C - 1];
		}

		for (int y = C - 1; y > 1; y--) {
			room[bottomX][y] = room[bottomX][y - 1];
		}

		room[bottomX][1] = 0;

	}

	private boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < R && 0 <= ny && ny < C;
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}