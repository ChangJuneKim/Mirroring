package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProfessorSolution {
	
	private static int M;               // 치킨집 중 M개의 치킨집을 뽑기
	private static List<Pair> house;    // 모든 집의 좌표를 저장
	private static List<Pair> chicken;  // 모든 치킨집의 좌표를 저장
	private static Pair[] pick;         // 조합을 이용해서 M개의 치킨집을 저장
	
	private static int answer;          // 가장 작은 치킨 거리 값들의 합 중 최소값
	
	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		// 도시 크기 N, 치킨집의 최대 개수 M
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		/**
		 * 2. 알고리즘 풀기
		 */
		// 전역변수 초기화
		house = new ArrayList<>();    // 집들의 좌표 저장
		chicken = new ArrayList<>();  // 치킨집들의 좌표 저장
		pick = new Pair[M];           // 뽑힌 M개의 치킨집들의 좌표 저장
		answer = Integer.MAX_VALUE;   // 도시의 치킨 거리의 최소값
		
		for (int i = 1; i < N + 1; i++) {
			split = in.readLine().split(" ");
			for (int j = 1; j < N + 1; j++) {
				
				switch (split[j - 1]) {
				case "1":  // 집일 경우
					house.add(new Pair(i, j));
					break;
					
				case "2":  // 치킨집일 경우
					chicken.add(new Pair(i, j));
					break;
				}
			}
		}
		
		/*System.out.println(house);
		System.out.println(chicken);*/
		
		// 치킨집 M개를 뽑아서 (조합)
		// 도시의 치킨 거리를 구한다. (기저조건)
		// 구한 치킨 거리 중 가장 작은 값을 출력한다. (기저조건)
		comb(0, 0);

		/**
		 * 3. 정답 출력
		 */
		sb.append(answer);
		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {
		
		// 기저 부분 (종료 조건)
		if (cnt == M) {
			
			// 치킨 거리의 합
			int sum = 0;
			
			// 뽑힌 치킨집들 중 하나를 꺼내어
			// 모든 집과의 거리를 구해 가장 가까운 거리를 구한다.
			for (int i = 0; i < house.size(); i++) {
				
				// 최소값 초기화
				int min = Integer.MAX_VALUE;
				
				for (int j = 0; j < M; j++) {
					Pair pickedHouse = house.get(i);
					Pair pickedChicken = pick[j];
					
					int dist = Math.abs(pickedHouse.r - pickedChicken.r) + Math.abs(pickedHouse.c - pickedChicken.c);
					if (dist < min) {
						min = dist;
					}
				}
				
				// 가장 작은 치킨 거리 값들의 합을 구한다.
				sum += min;
			}
			
			// 답을 구한다.
			if (sum < answer) {
				answer = sum;
			}
			return;
		}
		
		// 유도 부분
		for (int i = start; i < chicken.size(); i++) {
			
			pick[cnt] = chicken.get(i);
			
			comb(cnt + 1, i + 1);
		}
	}
}

class Pair {
	public int r;
	public int c;
	
	public Pair(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	// 아래 toString은 디버깅 용도로 사용
	@Override
	public String toString() {
		return "(" + r + ", " + c + ")";
	}
}




