package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ProfessorSolution {
	int N, M; // 봉지 개수 N, 무게 합 제한 M
	int[] snackWeights; // 봉지들의 무게

	int R = 2; // N개 중 R개뽑기(두개 뽑기)
	int[] numbers; // 선택한 과자 봉지들의 무게
	int answer; // 과자 봉지들의 무게 합 최댓값

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			sb.append("#" + testCase + " ");
			
			// 전역변수를 사용할때는 항상 반복문의 처음에 초기화를 해준다!
			answer = - 1;
			numbers = new int[R];
			
			// 과자 봉지의 개수 N, 무게 합 제한 M
			String[] NM = br.readLine().split(" ");
			N = Integer.valueOf(NM[0]);
			M = Integer.valueOf(NM[1]);

			// 과자 무게들
			snackWeights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			
			// N개의 과자 봉지 중 2개의 봉지를 택하는 경우의 수 : nC2
			comb(0,0);
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}

	// cnt + 1 번째 해당하는 수를 뽑기
	// cnt : 직전까지 뽑은 조합에 포함된 수의 개수, start : 시도할 수의 시작 위치
	private void comb(int cnt, int start) {
		// 기저 조건(종료 조건)
		if(cnt == R) {
			// 선택한 봉지들의 무게 합
			int sum = 0;
			for (int i = 0; i < R; i++) {
				sum += numbers[i];
			}
			
			// 무게 합 제한을 초과하지 않는다면
			if(sum <= M) {
				
				// 무게 합 최대값 갱신
				if(sum > answer) {
					answer = sum;
				}
			}
			return;
		}
		
		// 가능한 모든 수에 대해 시도
		// start 부터 처리 시 중복 수 추출 방지 및 순서가 다른 조합 추출 방지
		for (int i = start; i < N; i++) {
			// start 위치부터 처리했으므로 중복체크 필요 없음
			// 앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = snackWeights[i];
			
			// 다음 수 뽑으러 가기
			comb(cnt + 1, i + 1);
		}
		
	}

	public static void main(String[] args) throws IOException {
		new ProfessorSolution().solution();
	}
}
