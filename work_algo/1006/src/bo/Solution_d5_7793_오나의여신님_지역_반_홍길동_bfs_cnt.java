package bo;

import java.io.*;
import java.util.*;

public class Solution_d5_7793_오나의여신님_지역_반_홍길동_bfs_cnt {
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());

		next: for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] map = new char[N][M];
			Queue<int[]> q = new ArrayDeque<>();
			int[] S = null;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) { // i,j,수연,시간
					if (map[i][j] == 'S')
						S = new int[] { i, j, 1, 1 };// 수연
					else if (map[i][j] == '*')
						q.offer(new int[] { i, j, 0, 1 });// 악마
				} // i,j,악마,시간
			}
			q.offer(S);
			while (!q.isEmpty()) {
				int[] ij = q.poll();
				for (int d = 0; d < 4; d++) {
					int ni = ij[0] + di[d];
					int nj = ij[1] + dj[d];
					if (ni < 0 || N <= ni || nj < 0 || M <= nj || map[ni][nj] == 'X' || map[ni][nj] == '*')
						continue;
					if (ij[2] == 0) {// 악마
						if (map[ni][nj] == 'D')
							continue;
						map[ni][nj] = '*';
						q.offer(new int[] { ni, nj, 0, ij[3] + 1 });
					} else {// 수연
						if (map[ni][nj] == 'S')
							continue;
						if (map[ni][nj] == 'D') {
							sb.append("#").append(tc).append(" ").append(ij[3]).append("\n");
							continue next;
						}
						map[ni][nj] = 'S';
						q.offer(new int[] { ni, nj, 1, ij[3] + 1 });
					}
				}
			}
			sb.append("#").append(tc).append(" GAME OVER").append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
