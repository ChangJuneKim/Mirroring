package samsung02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	int N;
	int[][] map;
	boolean[][] visited;
	int count;
	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };
	int min;
	
	public void solution() throws IOException {
		System.setIn(new FileInputStream("input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.valueOf(st.nextToken());

		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.valueOf(br.readLine());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = Arrays.stream(br.readLine()
					.split(" "))
					.mapToInt(Integer::valueOf)
					.toArray();
			}

			count = 0; // 가장자리를 제외한 코어 수
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (i != 0 && j != 0 && map[i][j] == 1) {
						count++;
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			
			System.out.println(min);
			
		}

	}

	private void dfs(int x, int y, int depth) {
		if(depth == count) {
			return;
		}
		
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
		}
		
		
	}

	private boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}