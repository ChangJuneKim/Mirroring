package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ProfessorSolution {

	static int N;
	static int sharkSize, eat;
	static int map[][];

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Shark implements Comparable<Shark> {
		int x, y, depth;

		public Shark(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", depth=" + depth + "]";
		}

		@Override
		public int compareTo(Shark o) {
			// 1. 가장 위에 있는 물고기
			int compare = Integer.compare(this.x, o.x);

			// 만약 1번과 같은 물고기가 많다면
			if (compare == 0) {
				// 2. 가장 왼쪽에 있는 물고기
				compare = Integer.compare(this.y, o.y);
			}
			return compare;
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		map = new int[N][N];
		sharkSize = 2;
		eat = 0;
		int seconds = 0;

		int curSharkX = -1;
		int curSharkY = -1;

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine()
					.split(" ");
			for (int j = 0; j < split.length; j++) {
				map[i][j] = Integer.valueOf(split[j]);

				switch (map[i][j]) {
				case 9:
					curSharkX = i;
					curSharkY = j;
					map[i][j] = 0;
					break;
				}
			}
		}

		while (true) {
			// 아기 상어와 가장 가까운 물고기 찾기
			Shark shark = bfs(curSharkX, curSharkY);

			// 물고기를 먹을 수 있는 아기 상어가 있다면
			if (shark != null) {
				seconds += shark.depth;
				eat++;
				map[shark.x][shark.y] = 0;

				if (sharkSize == eat) {
					sharkSize++;
					eat = 0;
				}

				curSharkX = shark.x;
				curSharkY = shark.y;
			} else {
				break;
			}
		}
		
		System.out.println(seconds);
	}

	/**
	 * 
	 * @param x 현재 출발할 상어의 x좌표
	 * @param y 현재 출발할 상어의 y좌표
	 */
	private static Shark bfs(int x, int y) {
		Queue<Shark> queue = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[N][N];
		int depth = 0;

		queue.offer(new Shark(x, y));
		isVisited[x][y] = true;

		while (!queue.isEmpty()) {
			// 깊이 증가
			depth++;

			// 큐 크기 확인(동일 너비 대상 개수)
			int size = queue.size();

			// 아래 while 문에서 발견된 물고기들은 모두 같은 거리의 물고기들이다.
			// 물고기를 먹을 수 있는 아기 상어를 리스트에 담는다.
			List<Shark> candidate = new ArrayList<>();

			while (--size >= 0) {
				// 현재 아기 상어 꺼내기
				Shark curShark = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nx = curShark.x + dx[i];
					int ny = curShark.y + dy[i];

					if (isIn(nx, ny) && !isVisited[nx][ny]) {
						isVisited[nx][ny] = true;

						// 물고기 발견
						if (1 <= map[nx][ny] && map[nx][ny] <= 6) {
							// 자기보다 크면 지나갈 수 없음
							if (sharkSize < map[nx][ny]) {
								continue;
							}
							// 크기가 같으면 지나갈 순 있지만 먹을 수 없음
							else if (sharkSize == map[nx][ny]) {
								// 다음 칸 이동
								queue.offer(new Shark(nx, ny));
							}
							// 크기가 작은 물고기는 먹을 수 있음
							else if (sharkSize > map[nx][ny]) {
								// 물고기를 먹을 수 있는 아기 상어 등록
								candidate.add(new Shark(nx, ny));
							}

						}
						// 빈칸이면
						else if (map[nx][ny] == 0) {
							// 다음 칸 이동
							queue.offer(new Shark(nx, ny));
						}
					}
				}
			}
			// 물고기를 먹을 수 있는 아기 상어가 있다면
			if (!candidate.isEmpty()) {
				// 거리가 가까운 물고기가 많다면, 가장 위에, 가장 왼쪽에 있는 물고기를 먹는다
				Collections.sort(candidate);
				Shark shark = candidate.get(0);
				shark.depth = depth;

				return shark;
			}
		}
		return null;
	}

	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}
}
