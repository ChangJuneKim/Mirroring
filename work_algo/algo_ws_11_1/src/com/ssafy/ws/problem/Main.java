package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	int min = Integer.MAX_VALUE;
	int N;
	int[][] ingredients;

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.valueOf(br.readLine());
		int bag = 0;;
		
		while(N >= 0) {
			if(N % 5 == 0) {
				bag += Math.floor(N / 5);
				System.out.println(bag);
				return;
			}
			N -= 3;
			bag++;
		}
		System.out.println(-1);
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}