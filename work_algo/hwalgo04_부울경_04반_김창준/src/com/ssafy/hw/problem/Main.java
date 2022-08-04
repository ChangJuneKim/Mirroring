package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.InputStreamReader;

public class Main {

	public void solution() throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		Queue<Integer> queue = new LinkedList<>();
		
		int N = Integer.valueOf(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while(queue.size() > 1) {
			queue.poll(); // 하나 버리고
			queue.add(queue.poll()); // 위에꺼 꺼내서 뒤에 추가하고
		}
		
		System.out.println(queue.peek());
	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}