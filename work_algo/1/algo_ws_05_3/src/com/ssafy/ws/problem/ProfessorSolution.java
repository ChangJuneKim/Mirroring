package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ProfessorSolution {
	public class Tower {
		int number;
		int height;
		public Tower(int number, int height) {
			this.number = number;
			this.height = height;
		}
		@Override
		public String toString() {
			return "Tower [number=" + number + ", height=" + height + "]";
		}
		
		
	}
	
	public void solution() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.valueOf(br.readLine());
		
		String[] split = br.readLine().split(" ");
		int[] towers = new int[N];
		for (int i = 0; i < N; i++) {
			towers[i] = Integer.valueOf(split[i]);
		}
		
		Stack<Tower> stack = new Stack<>();
		
		for (int i = 1; i <= N; i++) {
			while(!stack.isEmpty()) {
				// 스택의 top이 현재 입력 값(높이)보다 크면, 신호 수신 가능
				if(stack.peek().height > towers[i-1]) {
					sb.append(stack.peek().number).append(" ");
					break;
				}
				
				// 스택의 top이 현재 입력 값보다 작으면, 신호 수신 불가능
				stack.pop();
			}
			
			// 스택이 비었다는 뜻은 신호 수신 가능한 탑이 없다는 뜻이므로 0을 출력
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			
			// 현재 입력 값을 가지고 탑을 생성하여 스택에 push
			stack.push(new Tower(i, towers[i - 1]));
			
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new ProfessorSolution().solution();
	}
}
