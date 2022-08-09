package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProfessorSolution {

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		String[] input = br.readLine().split(" ");
		int N = Integer.valueOf(input[0]);
		int K = Integer.valueOf(input[1]);

		List<Integer> list = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			list.add(i);
		}
		
		sb.append("<");
		
		int index = 0;
		
		while(!(list.size() == 1)) {
			// K번째 사람 인덱스 번호 구하기
			index = (index + K - 1) % list.size();
			
			// K번째 사람의 인덱스 번호를 이용하여, 그 사람의 번호를 구하고 출력
			int no = list.get(index);
			sb.append(no).append(", ");
			
			// K번째 사람 리스트에서 제거
			list.remove(index);
		}
		
		sb.append(list.get(0)).append(">");
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}
