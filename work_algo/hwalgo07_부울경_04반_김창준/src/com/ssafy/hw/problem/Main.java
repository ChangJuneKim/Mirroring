package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		int N = Integer.valueOf(br.readLine());
		int[][] paper = new int[100][100];
		int count = 0;
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			int x = Integer.valueOf(split[0]);
			int y = Integer.valueOf(split[1]);
			
			for (int xx = x; xx < x + 10; xx++) {
				for (int yy = y; yy < y + 10; yy++) {
					paper[xx][yy] = 1;
				}
			}			
		}
		
		for (int k = 0; k < 100; k++) {
			for (int j = 0; j < 100; j++) {
				if(paper[k][j] == 1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}