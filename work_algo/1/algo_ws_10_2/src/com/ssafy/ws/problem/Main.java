package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class NumData {
	public int number;
	public int abs;

	public NumData(int number, int abs) {
		super();
		this.number = number;
		this.abs = abs;
	}

}

public class Main {
	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Queue<NumData> queue = new PriorityQueue<>(new Comparator<NumData>() {
			@Override
			public int compare(NumData o1, NumData o2) {
				if(o1.abs == o2.abs) {
					return o1.number - o2.number;
				}
				return o1.abs - o2.abs;
			}
		});
		
		int N = Integer.valueOf(br.readLine()); // 도시 크기
		
		for (int i = 0; i < N; i++) {
			int data = Integer.valueOf(br.readLine());
			
			// 0이 아니라면 데이터를 추가하는 연산
			if (data != 0) {
				queue.offer(new NumData(data, Math.abs(data)));
			}
			
			// 0이라면 절댓값이 가장 작은 값을 출력하고, 절댓값이 같은경우 작은 수를 출력한다
			if(data == 0) {
				if(queue.isEmpty()) {
					sb.append(0 + "\n");
				}else {
					sb.append(queue.poll().number + "\n");
				}
			}
			
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}