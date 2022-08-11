package bo0811.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {
	int N, M;
	int[][] map;
	int[][] visit;
	int[] dr = { -1, 0, 1, 0 };
	int[] dc = { 0, 1, 0, -1 };

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M]; // int로 만든 이유 숫자를 쌓으면서 거리를 구하려고

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			char[] cs = s.toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = cs[j] - '0';
			}
		}
		// 읽기 끝

		bfs();
		System.out.println(visit[N - 1][M - 1]);
	}

	private void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0 });
		visit[0][0] = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];

			if (r == N - 1 && c == M - 1) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (!check(nr, nc)) {
					continue;
				}
				if (map[nr][nc] == 1 && visit[nr][nc] == 0) {
					queue.offer(new int[] { nr, nc });
					visit[nr][nc] = visit[r][c] + 1;
				}
			}
		}

	}

	private boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	public static void main(String[] args) throws IOException {
		new Boj2178().solution();
	}
}
