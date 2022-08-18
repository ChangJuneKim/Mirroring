package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProfessorSolution {

	private static int N;  // 세로 크기
	private static int M;  // 가로 크기
	private static int[][] data;  // 원본
	private static List<Cctv> cctvs;  // CCTV 좌표들
	private static int[] directions;  // 각 CCTV의 회전 각도 인덱스 번호 (0: 0도, 1: 90도, 2: 180도, 3: 270도)
	private static int answer;  // 사각 지대의 최소 크기

	// 우, 하, 좌, 상
	private static final int[] dx = { 0, 1, 0, -1 };
	private static final int[] dy = { 1, 0, -1, 0 };

	public static void main(String args[]) throws Exception {

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
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		cctvs = new ArrayList<Cctv>();
		data = new int[N][M];
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(split[j]);

				// CCTV일 경우 좌표 저장
				if (1 <= data[i][j] && data[i][j] <= 5) {
					cctvs.add(new Cctv(data[i][j], i, j));
				}
			}
		}

		// 각 CCTV의 회전 각도 인덱스 번호
		directions = new int[cctvs.size()];
		
		// 최솟값 초기화
		answer = Integer.MAX_VALUE;

		/**
		 * 2. 알고리즘 풀기
		 */
		perm(0);

		/**
		 * 3. 정답 출력
		 */
		sb.append(answer);

		System.out.println(sb);
	}

	private static void perm(int cnt) {

		// 중복순열 (기저부분)
		if (cnt == cctvs.size()) {
			
			// (디버깅) 중복순열 경우의 수
			//System.out.println(Arrays.toString(directions));

			// 사본 만들기 (각 경우의 수 수행 후 처음상태로 돌리기 위해)
			int[][] temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = data[i][j];
				}
			}

			// CCTV 하나씩 꺼내서 DFS 탐색 방법으로 감시영역 data 배열에 표시
			for (int cctvIndex = 0; cctvIndex < cctvs.size(); cctvIndex++) {

				// CCTV 하나를 선택
				Cctv cctv = cctvs.get(cctvIndex);

				// 선택한 CCTV 위치에서 4방향 탐색
				switch (cctv.type) {
				case 1:
					// 회전각도 인덱스 번호 0 기준 오른쪽 탐색
					dfs(cctv.x, cctv.y, directions[cctvIndex]);
					break;

				case 2:
					// 회전각도 인덱스 번호 0 기준 오른쪽, 왼쪽 탐색
					dfs(cctv.x, cctv.y, directions[cctvIndex]);
					dfs(cctv.x, cctv.y, directions[cctvIndex] + 2);
					break;

				case 3:
					// 회전각도 인덱스 번호 0 기준 오른쪽, 위쪽 탐색
					dfs(cctv.x, cctv.y, directions[cctvIndex]);
					dfs(cctv.x, cctv.y, directions[cctvIndex] + 3);
					break;

				case 4:
					// 회전각도 인덱스 번호 0 기준 오른쪽, 왼쪽, 위쪽 탐색
					dfs(cctv.x, cctv.y, directions[cctvIndex]);
					dfs(cctv.x, cctv.y, directions[cctvIndex] + 2);
					dfs(cctv.x, cctv.y, directions[cctvIndex] + 3);
					break;

				case 5:
					// 회전각도 인덱스 번호 0 기준 오른쪽, 아래쪽, 왼쪽, 위쪽 탐색
					dfs(cctv.x, cctv.y, directions[cctvIndex]);
					dfs(cctv.x, cctv.y, directions[cctvIndex] + 1);
					dfs(cctv.x, cctv.y, directions[cctvIndex] + 2);
					dfs(cctv.x, cctv.y, directions[cctvIndex] + 3);
					break;
				}
				
			}
			
			// (디버깅) 각 경우의 수에 의해 표시된 감시영역 출력해보기 
			/*for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(data[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();*/
			
			// 사각 지대 크기 구하기 
			int sumOfBlank = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (data[i][j] == 0) {
						sumOfBlank++;
					}
				}
			}
			
			// 최소 크기 갱신
			if (sumOfBlank < answer) {
				answer = sumOfBlank;
			}
			
			// 원본 복구
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					data[i][j] = temp[i][j];
				}
			}
			return;
		}

		// 중복순열 (유도부분)
		for (int i = 0; i <= 3; i++) {  // 회전 방향이 총 4방향 (0 ~ 3)
			directions[cnt] = i;

			// 현재 회전 각도 인덱스 번호와 같은 번호부터 처리하도록 전달
			perm(cnt + 1);
		}
	}

	private static void dfs(int x, int y, int direction) {
		direction %= 4;  // 0: 우, 1: 하, 2: 좌, 3: 상
		
		int testX = x + dx[direction];
		int testY = y + dy[direction];
		
		// 경계 체크
		if ((0 <= testX && testX < N) && (0 <= testY && testY < M)) {
			if (data[testX][testY] == 0) {  // 빈 칸이면
				data[testX][testY] = 9;  // 감시영역 표기하고
				dfs(testX, testY, direction);  // 다음 칸으로 이동
			}
			// CCTV일 경우 혹은 이미 감시하고 있는 영역일 경우
			else if ((1 <= data[testX][testY] && data[testX][testY] <= 5) || data[testX][testY] == 9) {
				dfs(testX, testY, direction);  // 감시영역 표기 안하고, 다음 칸으로 이동
			}
			
		}
		
		// 기저 조건은
		// 경계를 벗어나거나
		// 벽 (6)을 만났을 경우 종료
		return;
	}
}

class Cctv {
	public int type;  // CCTV 종류
	public int x;
	public int y;

	public Cctv(int type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}
}
