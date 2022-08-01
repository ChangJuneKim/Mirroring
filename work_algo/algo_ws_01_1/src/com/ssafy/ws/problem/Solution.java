package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 0801 원재의 메모리 복구하기 D3
public class Solution {
	
	public void solution() throws NumberFormatException, IOException{
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.valueOf(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#"+ tc + " ");
			
			String memory = br.readLine();
			int count = 0; // 수정 횟수
			
			if(memory.charAt(0) == '1') {
				count++;
			}
			
			for (int i = 0; i < memory.length() - 1; i++) {
				if(memory.charAt(i) != memory.charAt(i + 1)) {
					count++;
				}
			}

			sb.append(count + "\n");
		}
		System.out.println(sb);
		
	}
	
	public static void main(String[] args) throws  NumberFormatException ,IOException{
		new Solution().solution();
	}
}
