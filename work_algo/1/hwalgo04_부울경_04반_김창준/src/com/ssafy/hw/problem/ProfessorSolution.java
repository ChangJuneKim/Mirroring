package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class ProfessorSolution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		// 카드 개수
		int N = Integer.valueOf(br.readLine());
		
		// 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 놓는다.
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		// 마지막 한 장이 남을 때까지 반복
		while(queue.size() > 1) {
			// 제일 위에 있는 카드는 버린다.
			queue.poll(); 
			
			// 그 다음, 제일 위에 있는 카드는 제일 아래로 옮긴다.
			int topCard = queue.poll();
			queue.offer(topCard); 
		}
		
		System.out.println(queue.peek());
	}
}
