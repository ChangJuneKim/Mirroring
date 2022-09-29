package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import javax.print.attribute.standard.NumberUpSupported;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class ProfessorSolution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		while (true) {
			String testCase = br.readLine();
			if(testCase == null) break;
			sb.append("#" + testCase + " ");
			
			String[] split = br.readLine().split(" ");
			Queue<Integer> queue = new ArrayDeque<>();
			
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(split[i]));
			}
			
			int cnt = 1;
			while(true) {
				// 큐에서 맨 앞의 요소 하나를 꺼낸다
				int poll = queue.poll();
				int result = poll - cnt;
				
				// 계산 후 큐에 다시 입력
				if(result > 0) {
					queue.offer(result);
					cnt = cnt % 5 + 1;
					
				}else {
					// 종료 조건
					result = 0;
					queue.offer(result);
					break;
				}
			}
			
			while(!queue.isEmpty()) {
				int poll = queue.poll();
				sb.append(poll);
				sb.append(" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
