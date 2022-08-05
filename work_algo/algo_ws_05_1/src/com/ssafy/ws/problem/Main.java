package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.text.DefaultEditorKit.CutAction;

public class Main {

	public void solution() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int S = Integer.valueOf(st.nextToken());
		int P = Integer.valueOf(st.nextToken());

		String dnaString = br.readLine();

		st = new StringTokenizer(br.readLine());
		// A C G T count
		int[] ACGTcounts = new int[4];

		for (int i = 0; i < 4; i++) {
			ACGTcounts[i] = Integer.valueOf(st.nextToken()); // 1 0 0 1
		}

		int answer = 0;
		
		int count = 0;
		
		for (int i = 0; i < P; i++) {
			if(dnaString.charAt(i) == 'A') {
				ACGTcounts[0]--;
			} else if (dnaString.charAt(i) == 'C') {
				ACGTcounts[1]--;
			} else if (dnaString.charAt(i) == 'G') {
				ACGTcounts[2]--;
			} else if (dnaString.charAt(i) == 'T') {
				ACGTcounts[3]--;
			}
		}
		
		// 0 0 -1 1
//		System.out.println(Arrays.toString(ACGTcounts));
		for (int j = 0; j < 4; j++) {
			if (ACGTcounts[j] <= 0) {
				count++;
			}
		}
		
		if(count == 4) {
			answer++;
		}
		
		for (int i = 0; i < S - P; i++) {
			
			if(dnaString.charAt(i) == 'A') {
				ACGTcounts[0]++;
			} else if (dnaString.charAt(i) == 'C') {
				ACGTcounts[1]++;
			} else if (dnaString.charAt(i) == 'G') {
				ACGTcounts[2]++;
			} else if (dnaString.charAt(i) == 'T') {
				ACGTcounts[3]++;
			}
			// 0 0 0 1
//			System.out.println(Arrays.toString(ACGTcounts));
			// S 9  P 8
			if(dnaString.charAt(P + i) == 'A') {
				ACGTcounts[0]--;
			} else if (dnaString.charAt(P + i) == 'C') {
				ACGTcounts[1]--;
			} else if (dnaString.charAt(P + i) == 'G') {
				ACGTcounts[2]--;
			} else if (dnaString.charAt(P + i) == 'T') {
				ACGTcounts[3]--;
			}
			// 0 0 0 0
//			System.out.println(Arrays.toString(ACGTcounts));
			count = 0;
			for (int j = 0; j < 4; j++) {
				if (ACGTcounts[j] <= 0) {
					count++;
				}
			}
			if(count == 4) {
				answer++;
			}
		}
		System.out.println(answer);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().solution();
	}
}
