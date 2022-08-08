package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public void solution() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		int N = Integer.valueOf(br.readLine());
		
		Stack<int[]> top = new Stack<>(); //Stack에 int형 배열 저장 가능!!
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			while(!top.isEmpty()) {
				if(top.peek()[0] < n) 
					top.pop();
				else { 
					System.out.print(top.peek()[1] + " ");
					break;
				}
			}
			
			if(top.empty()) //탑이 비었다면 0을 출력한다.
				System.out.print("0 ");
			top.push(new int[] {n, i+1}); //탑의 높이와 탑의 번호 배열을 저장
		}
			
	
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().solution();
	}
}
