package samsung01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 1번 문제
public class Solution {

	class House {
		int x, y, distance;

		public House(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "House [x=" + x + ", y=" + y + ", distance=" + distance + "]";
		}

	}

	final int CHARGER_LIMIT = 2;

	int count;
	int N;
	int[][] village;
	boolean[][] visited;
	int max;
	int minDis;
	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };
	Queue<int[]> queue = new ArrayDeque<>();
	House[] houseList;
	ArrayList<House> chargeList = new ArrayList<>();

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.valueOf(st.nextToken());

		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.valueOf(br.readLine()
				.trim());
			village = new int[31][31]; // -15~15

			count = 0;
			houseList = new House[N];

			int cnt = 0; // 겹치는 부분 수
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.valueOf(st.nextToken()) + 15;
				int y = Integer.valueOf(st.nextToken()) + 15;
				int d = Integer.valueOf(st.nextToken());
				visited = new boolean[31][31];
				bfs(x, y, d);
				houseList[i] = new House(x, y, d);
			}

			max = 0; // 최대로 겹치는 지점의 집 수
			for (int i = 0; i < 31; i++) {
				for (int j = 0; j < 31; j++) {
					if (max < village[i][j]) {
						max = village[i][j];
					}
				}
			}

			// 충전소를 2개 지어도 다 커버할 수 없으면
			if (N - max > CHARGER_LIMIT) {
				System.out.println("#" + testCase + " " + -1);
			}

			int needCount = 0;
			if (N == max) {
				needCount = 1;
			} else if (N - max == 1) {
				needCount = 2;
			}

			minDis = Integer.MAX_VALUE;

			int sum = 0;
			
			// asdadas
			for (int i = 0; i < village.length; i++) {
				System.out.println(Arrays.toString(village[i]));
			}
			
			if (needCount == 1) {
				for (int i = 0; i < 31; i++) {
					for (int j = 0; j < 31; j++) {
						if (village[i][j] == max) {
							sum = 0;
							for (int k = 0; k < houseList.length; k++) {
								sum += getDistance(i, houseList[k].x, j, houseList[k].y);
							}
						}

						if (sum != 0 && minDis > sum) {
							minDis = sum;
						}

					}
				}
				System.out.println("#" + testCase + " " + minDis);
			} else if (needCount == 2) {
				if (N == 2) {
					System.out.println("#" + testCase + " " + 2);
				} else {
					chargeList = new ArrayList<>();
					visited = new boolean[31][31];

					minDis = Integer.MAX_VALUE;
					comb(0, 0, 0);
					System.out.println("#" + testCase + " " + minDis);
				}

			}

		}

	}

	private void comb(int i, int j, int depth) {
		if (depth == 2) {
			int sum = 0;
			for (int k = 0; k < houseList.length; k++) {
				for (int k2 = 0; k2 < chargeList.size(); k2++) {
					sum += getDistance(chargeList.get(k2).x, houseList[k].x, chargeList.get(k2).y, houseList[k].y);
				}
				if (sum != 0 && minDis > sum) {
					minDis = sum;
				}

			}
			
			return;
		}

		for (int x = 0; x < 31; x++) {
			for (int y = 0; y < 31; y++) {
				if (village[x][y] >= max && !visited[x][y]) {
					chargeList.add(new House(x, y, 0));
					visited[x][y] = true;
					comb(x, y, depth + 1);
					visited[x][y] = false;
					if (chargeList.size() > 1) {
						chargeList.remove(1);
					}
				}
			}
		}
	}

	private void bfs(int x, int y, int d) {
		queue.offer(new int[] { x, y });
		visited[x][y] = true;
		village[x][y] = -1;

		while (!queue.isEmpty()) {

			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (getDistance(x, nx, y, ny) > d) {
					continue;
				}
				if (isIn(nx, ny) && !visited[nx][ny] && village[nx][ny] != -1) {
					village[nx][ny] += 1;
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
				}

			}
		}
	}

	private boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < 31 && 0 <= ny && ny < 31;
	}

	private int getDistance(int x, int nx, int y, int ny) {
		return Math.abs(x - nx) + Math.abs(y - ny);
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}
