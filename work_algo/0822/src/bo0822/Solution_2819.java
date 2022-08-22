package bo0822;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_2819 {

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
					nPr(i, j, 0, new int[] { map[i][j], 0, 0, 0, 0, 0, 0 });
				}
			}

			System.out.println("#" + testCase + " " + treeSet.size() + "\n");
		}

	}

	private void nPr(int x, int y, int depth, int[] nums) {
		if (depth == 6) {		
			treeSet.add(Arrays.toString(nums));
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (isIn(nx, ny)) {
				nums[depth + 1] = map[nx][ny];
				nPr(nx, ny, depth + 1, nums);
			}
		}
	}

	private boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}

	public static void main(String[] args) throws IOException {
		new Solution_2819().solution();
	}
}
