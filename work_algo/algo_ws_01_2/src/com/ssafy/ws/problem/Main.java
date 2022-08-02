package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 0801 오후 실습 백준 17478 재귀함수가 뭔가요?
public class Main {
	StringBuilder sb = new StringBuilder("");
	String underline = "";

	public void whatIsRecursiveFn(int n) {
		if (n == 0) {
			sb.append(underline + "\"재귀함수가 뭔가요?\"\n");
			sb.append(underline + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(underline + "라고 답변하였지.\n");
			return;
		}

		sb.append(underline + "\"재귀함수가 뭔가요?\"\n");
		sb.append(underline + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		sb.append(underline + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		sb.append(underline + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

		underline += "____";

		whatIsRecursiveFn(n - 1);
		// 재귀 끝 찍고 돌아오면 ____ 4개씩 줄이기
		underline = underline.substring(0, underline.length() - 4);

		sb.append(underline + "라고 답변하였지.\n");
	}

	public void solution() throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine()); // 반복횟수

		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		whatIsRecursiveFn(n);

		System.out.print(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().solution();
	}
}
