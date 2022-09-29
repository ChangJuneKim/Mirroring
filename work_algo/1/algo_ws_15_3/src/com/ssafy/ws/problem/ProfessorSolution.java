package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ProfessorSolution {
	class Enemy implements Comparable<Enemy> {
		int x; // 행
		int y; // 열
		int damage; // 화살 맞은 횟수

		public Enemy(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Enemy [x=" + x + ", y=" + y + ", damage=" + damage + "]";
		}

		@Override
		public int compareTo(Enemy o) {
			// 열 기준 오름차순 정렬(왼쪽 적부터 제거해야 하므로)
			return this.y - o.y;
		}
	}

	class Archer {
		int x;
		int y;

		public Archer(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Archer [x=" + x + ", y=" + y + "]";
		}

	}

	int N, M, D;// 행, 열, 궁수사거리
	List<Enemy> enemies; // 적들의 정보 저장
	int[] numbers; // 궁수가 위치할 열 인덱스 번호를 저장하는 배열
	int max; // 제거할 수 있는 적의 최대 수

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		D = Integer.valueOf(st.nextToken());

		// 적들의 정보 저장
		enemies = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine()
				.split(" ");
			for (int j = 0; j < M; j++) {
				if (split[j].equals("1")) {
					enemies.add(new Enemy(i, j));
				}
			}
		}

		numbers = new int[3]; // 궁수 3명으로 고정
		max = 0;

		comb(0, 0);

		sb.append(max);

		System.out.println(sb);
	}

	private void comb(int depth, int start) {
		if (depth == 3) { // 궁수 3명 위치 선정 완료
			// 적들의 정보 백업
			List<Enemy> temp = new ArrayList<>();
			for (Enemy enemy : enemies) {
				temp.add(new Enemy(enemy.x, enemy.y));
			}

			// 궁수 3명 생성하고 위치 저장
			List<Archer> archers = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				archers.add(new Archer(N, numbers[i]));
			}

			// 제거한 적들의 수
			int killCount = 0;

			do {
				// 궁수와 가까운 거리의 적을 찾아 제거하기
				for (Archer a : archers) {
					// 궁수와 가장 가까운 적을 찾는다.
					for (int i = 1; i <= D; i++) { // 사격거리를 1부터 1씩 늘리면서 탐색
						// 사거리에 들어오는 모든 적들을 리스트에 담기
						List<Enemy> targets = new ArrayList<>();
						for (Enemy enemy : enemies) {
							// 적과 궁수 간의 거리 구하기
							int distance = Math.abs(enemy.x - a.x) + Math.abs(enemy.y - a.y);
							if (distance == i) {
								targets.add(enemy);
							}
						}

						// 가까운 적을 발견하면
						if (!targets.isEmpty()) {
							// 가장 왼쪽 적부터 제거하기 위해 정렬
							Collections.sort(targets);

							// 가장 가까운 적에게 데미지를 준다. (바로 제거하지 않는다.)
							targets.get(0).damage++;
							break;
						}
					}
				}

				// 적들을 순회하면서 제거 혹은 이동 수행
				for (int i = enemies.size() - 1; i >= 0; i--) {// 제거되는 적이 있기 때문에 뒤에서 탐색
					Enemy enemy = enemies.get(i);

					if (enemy.damage > 0) {
						enemies.remove(enemy);
						killCount++;
						continue;
					}

					// 해당 적을 한칸 아래로 이동
					enemy.x += 1;

					// 만약 적이 격자판 밖으로 나가면
					if (enemy.x >= N) {
						// 제거
						enemies.remove(enemy);
					}
				}
			} while (!enemies.isEmpty());

			// 최대값 갱신
			if (killCount > max) {
				max = killCount;
			}

			// 백업했던 적들의 정보 복원
			enemies = new ArrayList<>();
			for (Enemy e : temp) {
				enemies.add(e);
			}

			return;
		}

		for (int i = start; i < M; i++) {
			numbers[depth] = i;
			comb(depth + 1, i + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		new ProfessorSolution().solution();
	}

}