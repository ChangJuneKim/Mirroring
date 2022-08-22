package bo0822;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class bfs_2819_doing {

	int T;
	int N;
	int[][] map;
	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };

	TreeSet<String> treeSet;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.valueOf(br.readLine());
		N = 4;

		for (int testCase = 1; testCase <= T; testCase++) {
			map = new int[N][N];
			treeSet = new TreeSet<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.valueOf(st.nextToken());
				}
			} // 읽기

//			for (int i = 0; i < map.length; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}

			// 로직
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					nPr(i, j, 0, new int[] { map[i][j], 0, 0, 0, 0, 0, 0 });
					bfs(i, j);
				}
			}

			System.out.println("#" + testCase + " " + treeSet.size() + "\n");
		}

	}

	private void bfs(int x, int y) {
		int[] nums = { map[x][y], 0, 0, 0, 0, 0, 0 };
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { x, y });
		int index = 1;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];

			if (index == 7) {
				System.out.println(Arrays.toString(nums));
				treeSet.add(Arrays.toString(nums));
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (isIn(nx, ny)) {
					queue.add(new int[] { nx, ny });
					nums[index++] = map[nx][ny];
					if(index == 7) break ;
				}
			}

		}
	}

//	private void nPr(int x, int y, int depth, int[] nums) {
//		if (depth == 6) {		
//			treeSet.add(Arrays.toString(nums));
//			return;
//		}
//
//		for (int d = 0; d < 4; d++) {
//			int nx = x + dx[d];
//			int ny = y + dy[d];
//
//			if (isIn(nx, ny)) {
//				nums[depth + 1] = map[nx][ny];
//				nPr(nx, ny, depth + 1, nums);
//			}
//		}
//	}

	private boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}

	public static void main(String[] args) throws IOException {
		new bfs_2819_doing().solution();
	}
}
