package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	StringBuilder sb = new StringBuilder();
	int L, C;
	char[] chars;
	char[] result;
	char[] aeiou = { 'a', 'e', 'i', 'o', 'u' };
	boolean[] visited;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());

		result = new char[L];
		chars = new char[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			chars[i] = st.nextToken()
				.charAt(0);
		}
		
		Arrays.sort(chars);
		visited = new boolean[C];
		combination(0, 0);

		System.out.println(sb);
	}

	private void combination(int depth, int start) {
		if (depth == L) {
			int count = 0; // 모음 개수
			for (int i = 0; i < result.length; i++) {
				if(isAeiou(result[i])) {
					count++;
				}
			}
			
			// 최소 한 개의 모음 && 최소 두 개의 자음
			if(count > 0 && L - count > 1) {
				for (int i = 0; i < result.length; i++) {
					sb.append(result[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {
			result[depth] = chars[i];
			combination(depth + 1, i + 1);
		}
	}

	private boolean isAeiou(char ch) {
		return ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u';
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}