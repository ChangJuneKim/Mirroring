package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProfessorSolution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#" + testCase + " ");

			int N = Integer.valueOf(br.readLine());

			int answer = 1;
			
			for (int i = 1; i <= N; i++) {
				String[] split = br.readLine().split(" ");
				char data = split[1].charAt(0);

				// 1. 각행의 두번째 데이터가 연산자일 경우는 자식 노드 2개를 반드시 가져야한다
				if (data == '+' || data == '-' || data == '*' || data == '/') {
					if(split.length != 4) { // 연산자 노드의 자식노드가 2개라면 길이가 4
						answer = 0; // 유효하지 않음
						
						// 나머지 입력 데이터 건너뛰기
						while(i < N) {
							i++;
							br.readLine();
						}
					}
				}else { // 피연산자 노드는 자식노드가 없어야 하고, 숫자이어야 한다.
					if(split.length != 2) {
						answer = 0;
						
						// 나머지 입력 데이터 건너뛰기
						while(i < N) {
							i++;
							br.readLine();
						}
					}
				}
			}
			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}

}
