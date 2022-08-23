package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	int[] parents;
	
	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.valueOf(st.nextToken());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			st= new StringTokenizer(br.readLine());
			int N = Integer.valueOf(st.nextToken());
			int M = Integer.valueOf(st.nextToken());
			
			parents = new int[N + 1];
			Arrays.fill(parents, 1, N + 1, -1);
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.valueOf(st.nextToken());
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				
				if(command == 0) {
					merge(a, b);
				}
				
				if(command == 1) {
					int rootA = find(a);
					int rootB = find(b);
					
					if(rootA == rootB) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private void merge(int a, int b) {
		int pA = find(a);
		int pB = find(b);
		
		if(pA == pB) { // 부모가 같다면 union 할 수 없다
			return;
		}
		
		int temp = parents[pA] + parents[pB]; // 합친 가족 수 temp
		
		// 구성원이 작은 그룹이 큰 그룹으로 간다
		if(parents[pA] > parents[pB]) { // A가 B보다 크다면(절대값이 작다면, !! 가족구성원이 적다는 뜻 낮은 rank를 의미한다!!) 
			parents[pA] = pB; // A의 대장은 B가 된다. A가 B 밑으로 들어감
			parents[pB] = temp; // 합친 가족 수 를 대장인 B에 넣음 
		} else { // A가 B보다 작거나 같다면(절대값이 크거나 같다면, A의 가족구성원이 같거나 더 많다는 뜻)
			parents[pB] = pA; // B가 A밑으로 들어감
			parents[pA] = temp; 
		}	
	}

	private int find(int a) {
		if(parents[a] < 0) { // 음수이면 그게 대장
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

}