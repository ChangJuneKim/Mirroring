package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProfessorSolution {

	private static int[] ACGT; // 파일로부터 입력받은 ACGT 최소 개수
	private static int[] count = new int[4]; // 부분 문자열에서 ACGT 개수 카운팅
	private static int satisfiedCount = 0; // 조건 만족 카운트
	
	private static void add(char input) {
		switch (input) {
		case 'A':
			count[0]++;
			if (ACGT[0] == count[0]) {
				satisfiedCount++;
			}
			break;
		case 'C':
			count[1]++;
			if (ACGT[1] == count[1]) {
				satisfiedCount++;
			}
			break;
		case 'G':
			count[2]++;
			if (ACGT[2] == count[2]) {
				satisfiedCount++;
			}
			break;
		case 'T':
			count[3]++;
			if (ACGT[3] == count[3]) {
				satisfiedCount++;
			}
			break;
		}
	}
	private static void remove(char output) {
		// TODO Auto-generated method stub
		switch (output) {
		case 'A':
//			count[0]--; // 주의 : 먼저 빼고 if문을 수행하면 문제가 있음!!
			if (ACGT[0] == count[0]) {
				satisfiedCount--;
			}
			count[0]--; // 주의 : 먼저 빼고 if문을 수행하면 문제가 있으니 밑에서
			break;
		case 'C':
			if (ACGT[1] == count[1]) {
				satisfiedCount--;
			}
			count[1]--;
			break;
		case 'G':
			if (ACGT[2] == count[2]) {
				satisfiedCount--;
			}
			count[2]--;
			break;
		case 'T':
			if (ACGT[3] == count[3]) {
				satisfiedCount--;
			}
			count[3]--;
			break;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		String[] split = br.readLine().split(" ");
		int S = Integer.valueOf(split[0]);
		int P = Integer.valueOf(split[1]);

		String dna = br.readLine();

		split = br.readLine().split(" ");
		ACGT = Arrays.stream(split).mapToInt(Integer::valueOf).toArray();

		int answer = 0;
		
		if (ACGT[0] == 0) {
			satisfiedCount++;
		}
		if (ACGT[1] == 0) {
			satisfiedCount++;
		}
		if (ACGT[2] == 0) {
			satisfiedCount++;
		}
		if (ACGT[3] == 0) {
			satisfiedCount++;
		}
		
		String subString = dna.substring(0, P);
		for (int i = 0; i < P; i++) {
			add(subString.charAt(i));
		}
		if(satisfiedCount == 4) {
			answer++;
		}
		// 최초 부분문자열에 대한 조건만족 판단 끝
		
		// 슬라이딩 윈도우 적용(한칸씩 이동하면서 비밀번호 조건만족 여부 확인)
		// (i는 새로 들어갈 문자의 인덱스 번호, j는 빠져나갈 문자의 인덱스 번호)
		for (int i = P; i < S; i++) {
			int j = i - P;
			add(dna.charAt(i));
			remove(dna.charAt(j));
			
			if(satisfiedCount == 4) {
				answer++;
			}
		}
			
		sb.append(answer + "\n");
		System.out.println(sb);
	}
	
}
