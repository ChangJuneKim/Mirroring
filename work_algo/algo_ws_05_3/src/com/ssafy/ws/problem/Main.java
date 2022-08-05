package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public class Tower {
		int number;
		int height;
		public Tower(int number, int height) {
			super();
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
		StringBuilder sb = new StringBuilder("");
		
		int N = Integer.valueOf(br.readLine());
		
		Stack<Tower> stack = new Stack<>();
		Tower[] towers = new Tower[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			towers[i] = new Tower(i + 1, Integer.valueOf(st.nextToken()));
			
			if(stack.size() == 0) {
				stack.push(towers[i]);
				sb.append(0 + " ");
				
			} else if(stack.size() > 0 && stack.peek().height < towers[i].height) {
				stack.pop();
			} else if(stack.size() > 0 && stack.peek().height > towers[i].height) {
				sb.append(stack.peek().number + " ");
				stack.push(towers[i]);
			}
			
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().solution();
	}
}
