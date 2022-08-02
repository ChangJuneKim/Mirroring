package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// [S/W 문제해결 기본] 1일차 - Flatten D3
public class Solution {

	public void solution() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#" + tc + " ");
			int dump = Integer.valueOf(br.readLine());
			int[] boxesHeight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			
			int diff = 0;
			for (int i = 0; i < dump; i++) {
				Arrays.sort(boxesHeight);
				diff = boxesHeight[99] - boxesHeight[0]; 
				
				if(diff == 1 || diff == 0) break;
				boxesHeight[0]++;
				boxesHeight[99]--;
			}
			Arrays.sort(boxesHeight);
			
			sb.append(boxesHeight[99] - boxesHeight[0] + "\n");
		}
		System.out.print(sb);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		new Solution().solution();
	}
}
