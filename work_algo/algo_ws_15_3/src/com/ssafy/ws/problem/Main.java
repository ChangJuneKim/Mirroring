package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

		while (castle > 0) { // 모든 궁수가 예외가 될 때까지
			
			ArrayList<Integer[]> enemy = new ArrayList<>(); // 공격할 적이 들어가는 배열
			
			for (int k = 0; k < archer.length; k++) { // 모든 궁수는 가장 가까운 적을 찾는다
				
				int min = Integer.MAX_VALUE;
				int[] near = new int[2]; // 현재 궁수에서 가장 가까운 적의 위치 담는 배열
				
				for (int j = 0; j < M; j++) {
					for (int i = castle - 1; i >= 0; i--) {
						int diff = Math.abs(castle - i) + Math.abs(archer[k] - j);// 적과의 거리(맨하탄 거리)

						if (newMap[i][j] == 1 && diff <= D) { // 공격할 수 있는 거리에 적이 있다면
							if (diff < min) { // 새로운 적이 더 가까이 있다면 거리와 위치 갱신
								min = diff;
								near[0] = i;
								near[1] = j;
							}
							break;
						}
					}
				}
				if (min != Integer.MAX_VALUE) { // 만약 공격할 수 있는 적이 있다면 enemy에 추가
					enemy.add(new Integer[] { near[0], near[1] });
				}
			}
			for (int i = 0; i < enemy.size(); i++) { // 모든 궁수가 공격할 수 있는 enemy배열
				if (newMap[enemy.get(i)[0]][enemy.get(i)[1]] != 0) { // 중복되는 적은 0처리해준다.
					temp += 1;
					newMap[enemy.get(i)[0]][enemy.get(i)[1]] = 0;
				}
			}
			castle -= 1; // 성이 위로 올라감

		}

		if (temp > ans)
			ans = temp; // 전체 적의 수 갱신
	}

	// 궁수를 놓을 수 있는 경우의 수
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