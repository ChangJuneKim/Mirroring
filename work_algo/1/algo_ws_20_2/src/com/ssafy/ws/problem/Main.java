package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int x, y, weight;

	public Node(int x, int y, int weight) {
		super();
		this.x = x;
		this.y = y;
		this.weight = weight;
	}

}

public class Main {

	final int INF = Integer.MAX_VALUE;

	int N;
	int[][] cave;
	int[][] weights;
	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };
	int tc = 1;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			String input = br.readLine();
			if (input.equals("0")) {
				break;
			}
			N = Integer.valueOf(input);
			cave = new int[N][N];
			weights = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.valueOf(st.nextToken());
					weights[i][j] = INF;
				}
			}

			dijkstra(0, 0);
//			
//			for (int i = 0; i < weights.length; i++) {
//				System.out.println(Arrays.toString(weights[i]));
//			}
			sb.append("Problem ")
					.append(tc++)
					.append(": ")
					.append(weights[N - 1][N - 1])
					.append("\n");

		}
		System.out.println(sb);

	}

	private void dijkstra(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		weights[x][y] = cave[x][y];
		pq.offer(new Node(x, y, weights[x][y]));

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int curX = current.x;
			int curY = current.y;
			int weight = current.weight;

			if(weight > weights[curX][curY]) {
				continue;
			}

			for (int i = 0; i < 4; i++) {

				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (isIn(nx, ny)) {
					if (weights[nx][ny] > weight + cave[nx][ny]) {
						weights[nx][ny] = weight + cave[nx][ny];
						pq.offer(new Node(nx, ny, weights[nx][ny]));
					}
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