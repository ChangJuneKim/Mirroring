package bo0822;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2819_bfs {

	static int T;
	static int N = 4;
	static int[][] map;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static HashSet<String> ts;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			map = new int[N][N];
			ts = new HashSet<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scann.nextInt();
				}
			}
		
			// 로직
			// 4x4 (i,j)위치에서 6번 4방 이동해보자.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}
			System.out.println("#" + t + " " + ts.size());
		}

	}

	// 중복순열 cnt==6까지 반복하자
	private static void bfs(int r, int c) {
		// que와 nums를 같이 6번 작업하면 된다.
		Queue<int[]> que = new LinkedList<>();
		Queue<String> nums = new LinkedList<>();
		
		que.offer(new int[] { r, c, 1 });
		nums.offer((map[r][c]) + "");
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			String curs = nums.poll();//
			
			int cr = cur[0];
			int cc = cur[1];
			int cnt = cur[2];
			
			if (cnt == 7) {
				ts.add(curs);
				continue;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (!check(nr, nc))
					continue;
				
				que.offer(new int[] { nr, nc, cnt + 1 });
				nums.offer(curs + (map[nr][nc]) + "");
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
