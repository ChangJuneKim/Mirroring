package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProfessorSolution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#" + testCase + " ");
			
			int N = Integer.parseInt(br.readLine());
			
			String[] split = br.readLine().split(" ");
			List<String> answer = new ArrayList<>(split.length);
			for (int i = 0; i < split.length; i++) {
				answer.add(split[i]);
			}
			
			int CN = Integer.parseInt(br.readLine());
			
			split = br.readLine().split(" ");
			List<String> commands = new ArrayList<>(split.length);
			for (int i = 0; i < split.length; i++) {
				commands.add(split[i]);
			}
			
			int cursor = -1;
			for (int i = 0; i < CN; i++) {
				String type = commands.get(++cursor);
				switch (type) {
				case "I":
					int x = Integer.parseInt(commands.get(++cursor));
					int y = Integer.parseInt(commands.get(++cursor));
					++cursor;
					
					// y개의 숫자를 x위치 바로 다음에 삽입
					List<String> subList = commands.subList(cursor, cursor + y);
					answer.addAll(x, subList);
					cursor += y - 1;
				}
			}
			
			for (int i = 0; i < 10; i++) {
				sb.append(answer.get(i) + " ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
