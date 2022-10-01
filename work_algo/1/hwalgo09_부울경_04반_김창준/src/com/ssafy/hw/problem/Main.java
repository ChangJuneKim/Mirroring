package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	StringBuilder sb = new StringBuilder();

	int[] sevenDwarfs;

	public void solution() throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] nineDwarfs = new int[9]; // 입력
		sevenDwarfs = new int[7]; // 정답

		for (int i = 0; i < 9; i++) {
			nineDwarfs[i] = Integer.valueOf(br.readLine());
		}

		combination(0, 0, nineDwarfs); // 아홉난쟁이 중에서, 일곱난쟁이 뽑기, depth,
		System.out.println(sb);

	}

	public void combination(int depth, int start, int[] nineDwarfs) {
		if (depth == 7) {
			int sum = 0;
			for (int i = 0; i < sevenDwarfs.length; i++) {
				sum += sevenDwarfs[i];
				if(sum > 100) {
					break;
				}
			}

			if (sum == 100) {
				for (int i = 0; i < sevenDwarfs.length; i++) {
					sb.append(sevenDwarfs[i]).append("\n");
				}
				return;
			}

			return;
		}

		for (int i = start; i < nineDwarfs.length; i++) {
			sevenDwarfs[depth] = nineDwarfs[i];
			combination(depth + 1, i + 1, nineDwarfs);
		}
	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
