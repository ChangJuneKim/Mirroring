package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	int n;
	int[] visit;
	
	Pos[] total;
	Pos[] cus;
	
	int answer;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.valueOf(br.readLine());
			total = new Pos[n + 2];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			total[0] = new Pos(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
			total[n + 1] = new Pos(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
			
			cus = new Pos[n];
			
			for (int i = 0; i < n; i++) {
				cus[i] = new Pos(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
			}
			
			visit = new int[n];
			answer = Integer.MAX_VALUE;
			dfs(1, 0);

			System.out.printf("#%d %d\n", tc, answer);
		}
	}

	public void dfs(int size, int sum) {
		if (sum > answer) {
			return;			
		}
		if (size == n + 1) {
			sum += Math.abs(total[size - 1].x - total[size].x) + Math.abs(total[size - 1].y - total[size].y);
			answer = Math.min(answer, sum);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i] == 0) {
				visit[i] = 1;
				total[size] = cus[i];
				int nsum = sum + Math.abs(total[size - 1].x - total[size].x)
						+ Math.abs(total[size - 1].y - total[size].y);
				dfs(size + 1, nsum);
				visit[i] = 0;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}