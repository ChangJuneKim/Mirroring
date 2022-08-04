package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int testCaseNumber = Integer.valueOf(br.readLine());
			sb.append("#" + testCaseNumber + " ");
			int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			
			Queue<Integer> queue = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				queue.offer(numbers[i]);
			}
			
			int reduce = 1;
			while(true) {
				int dequeueNumber = queue.poll(); // 하나 빼서
				dequeueNumber -= reduce; // 감소량 적용 후
				
				int enqueueNumber = dequeueNumber; // 넣을 숫자
				
				// 넣을 숫자가 0보다 크면
				if(enqueueNumber > 0) {
					queue.offer(enqueueNumber); // 꼬리에 숫자를 넣고
					reduce = reduce % 5 + 1; // 감소량 1~5 사이클 돌림
				} else {
					enqueueNumber = 0;
					queue.offer(enqueueNumber); // 0을 넣어주고 종료					
					break;
				}
				
			}
			
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}
