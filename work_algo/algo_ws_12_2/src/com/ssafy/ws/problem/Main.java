package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	int N, R, C, ans = 0;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		int size = (int) Math.pow(2, N);

		solve(0, 0, size);

	}

	private void solve(int r, int c, int size) {
		if (size == 1) {
			System.out.println(ans);
			return;
		}

		int newSize = size / 2;

		if (R < r + newSize && C < c + newSize) {
			solve(r, c, newSize);
		}

		if (R < r + newSize && C >= c + newSize) {
			ans += (size * size) / 4;
			solve(r, c + newSize, newSize);
		}

		if (R >= r + newSize && C < c + newSize) {
			ans += ((size * size) / 4) * 2;
			solve(r + newSize, c, newSize);
		}

		if (R >= r + newSize && C >= c + newSize) {
			ans += ((size * size) / 4) * 3;
			solve(r + newSize, c + newSize, newSize);
		}

	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}