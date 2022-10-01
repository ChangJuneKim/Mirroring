package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ProfessorSolution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		int T = 11;
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#" + testCase + " ");

			int N = Integer.parseInt(br.readLine());
			String brackets = br.readLine();

			int answer = 0; // 1: 유효함, 0: 유효하지 않음

			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < N; i++) {
				// 입력 받은 괄호들 중에서 index 번호에 해당하는 문자 하나를 꺼낸다
				char bracket = brackets.charAt(i);

				// 만약 열린 괄호면 스택에 담기
				if (bracket == '(' || bracket == '{' || bracket == '[' || bracket == '<') {
					stack.push(bracket);
				}
				// 만약 닫힌 괄호면 스택에서 꺼내서 괄호 종류를 비교함
				else if (bracket == ')' || bracket == '}' || bracket == ']' || bracket == '>') {
					if (!stack.isEmpty()) {
						char pop = stack.pop();

						if (pop == '(' && bracket == ')') {
							answer = 1;
						} else if (pop == '{' && bracket == '}') {
							answer = 1;
						} else if (pop == '[' && bracket == ']') {
							answer = 1;
						} else if (pop == '<' && bracket == '>') {
							answer = 1;
						} else {
							answer = 0;
							break;
						}
					} else {
						answer = 0;
						break;
					}
				}
			}
			
			if(!stack.isEmpty()) {
				answer = 0;
			}
			
			sb.append(answer + "\n");
			
			
		}
		System.out.println(sb);
	}
}
