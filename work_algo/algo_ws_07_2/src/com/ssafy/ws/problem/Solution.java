package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	int[] kyuyung = new int[9];
	int[] result = new int[9];

	int winCount;
	int loseCount;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		int TC = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			sb.append("#").append(testCase).append(" ");
			winCount = 0;
			loseCount = 0;
			boolean[] check = new boolean[19];
			boolean[] used = new boolean[9];
			int[] inyung = new int[9];
			// 규영이의 카드
			kyuyung = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

			for (int i = 0; i < 9; i++) {
				check[kyuyung[i]] = true;
			}

			// 인영이의 카드
			for (int i = 1, j = 0; j < 9; i++) {
				if (!check[i])
					inyung[j++] = i;
			}

			permutaition(inyung, result, used, 0, 9);
			sb.append(winCount + " " + loseCount + "\n");
		}
		System.out.println(sb);
	}

	private void permutaition(int[] inyung, int[] result, boolean[] used, int depth, int r) {
		
		// 기저 부분 (순열이 완성 되었으므로 카드 비교를 시작)
		if (depth == r) {
			int kSum = 0; // 규영이 점수의 합
			int iSum = 0; // 인영이 점수의 합

			for (int i = 0; i < 9; i++) {
				if (kyuyung[i] > result[i]) {
					kSum += (kyuyung[i] + result[i]);
				} else {
					iSum += (kyuyung[i] + result[i]);
				}
			}

			if (kSum > iSum) {
				winCount++;
			} else {
				loseCount++;
			}
			return;
		}
		
		for (int i = 0; i < inyung.length; i++) {
			if (used[i]) {
				continue;
			}
			used[i] = true;
			result[depth] = inyung[i];
			permutaition(inyung, result, used, depth + 1, 9);
			used[i] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}
