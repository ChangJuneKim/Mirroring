package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	public boolean isOpenBracket(char token) {
		return token == '(' || token == '[' || token == '{' || token == '<';
	}

	public boolean isPair(char token, char peek) {
		return peek == '(' && token == ')' || peek == '[' && token == ']' || peek == '{' && token == '}'
				|| peek == '<' && token == '>';
	}

	public void solution() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		for (int testCase = 1; testCase <= 10; testCase++) {

			int N = Integer.valueOf(br.readLine());
			String brackets = br.readLine();

			Stack<Character> bracketsStack = new Stack<>();

			for (int i = 0; i < N; i++) {
				char ch = brackets.charAt(i);
				// 여는 괄호면 스택에 넣고
				if (isOpenBracket(ch)) {
					bracketsStack.push(ch);
					// 닫는 괄호 일때는
				} else {
					// 스택이 비어 있거나, 스택의 가장 위와 다음 괄호가 쌍이 안맞는 경우
					if (bracketsStack.size() == 0 || !isPair(ch, bracketsStack.peek())) {
						bracketsStack.push(ch);
						break;
					} else {
						bracketsStack.pop();
					}
				}
			}
			if (bracketsStack.size() > 0) {
				sb.append(String.format("#%d %d\n", testCase, 0));
			} else {
				sb.append(String.format("#%d %d\n", testCase, 1));
			}

		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution().solution();
	}
}
