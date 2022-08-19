package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	int[][] map;
	int N, M, D;
	int ans = 0;
	int[] archer;
	
	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		D = Integer.valueOf(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		// 입력 완료
		archer = new int[3];
		
		combination(0, 0);
		System.out.println(ans);
	}

	// 궁수의 위치가 정해지면 공격을 한다
	private void attack() {
		int temp = 0;
		int castle = N; // 초기 성의 위치
		int[][] newMap = new int[N][M]; // 방문된 곳은 0으로 표시하기 위해 다른 배열 만듦
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, newMap[i], 0, M);
		}

		while (castle > 0) { // castle이 0보다 클때까지(한 턴이 지날때 마다 성벽 라인을 한줄씩 올림)
			
			ArrayList<int[]> enemy = new ArrayList<>(); // 공격할 적이 들어가는 배열
			
			for (int i = 0; i < 3; i++) { // 모든 궁수는 가장 가까운 적을 찾는다
				
				int min = Integer.MAX_VALUE;
				int[] near = new int[2]; // 현재 궁수에서 가장 가까운 적의 위치 담는 배열
				
				for (int j = 0; j < M; j++) {
					for (int k = castle - 1; k >= 0; k--) {
						int distance = Math.abs(castle - k) + Math.abs(archer[i] - j);// 적과의 거리(맨하탄 거리)
						
						if (newMap[k][j] == 1 && distance <= D) { // 공격할 수 있는 거리에 적이 있다면
							if (distance < min) { // 새로운 적이 더 가까이 있다면 거리와 위치 갱신
								min = distance;
								near[0] = k;
								near[1] = j;
							}
							break;
						}
					}
				}
				
				if (min != Integer.MAX_VALUE) { // 만약 공격할 수 있는 적이 있다면 enemy에 추가
					enemy.add(new int[] { near[0], near[1] });
				}
			}
			
			for (int i = 0; i < enemy.size(); i++) { // 모든 궁수가 공격할 수 있는 enemy배열
				int x = enemy.get(i)[0];
				int y = enemy.get(i)[1];
				
				if (newMap[x][y] != 0) { // 중복되는 적은 0처리해준다.
					temp += 1;
					newMap[x][y] = 0;
				}
			}
			castle -= 1; // 성을 위로 한칸 밀어 올린다
		}

		if (temp > ans) {
			ans = temp; // 전체 적의 수 갱신			
		}
	}

	// 궁수 배치 조합
	private void combination(int cnt, int start) {
		if (cnt == 3) {
			attack();
//			System.out.println(Arrays.toString(archer));
			return;
		}
		for (int i = start; i < M; i++) {
			archer[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}