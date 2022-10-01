package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		String[] input = br.readLine().split(" ");

		int N = Integer.valueOf(input[0]);
		int K = Integer.valueOf(input[1]);

		Deque<Integer> josephus = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			josephus.offer(i);
		}

		int[] answer = new int[N];
		int index = 0;
		int count = 0;
		while (!josephus.isEmpty()) {
			count++;

			if (count == K) {
				answer[index++] = josephus.poll();
				count = 0;
			} else {
				josephus.offer(josephus.poll());
			}

		}

		sb.append("<");
		for (int i = 0; i < answer.length; i++) {
			if (i == answer.length - 1) {
				sb.append(answer[i]);

			} else {
				sb.append(answer[i] + ", ");
			}
		}
		sb.append(">");
		
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}
