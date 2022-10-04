package algo_ws_22_1;

import java.util.Scanner;

public class DP_연습문제1 {

	public void solution() {
		Scanner sc = new Scanner(System.in); // 몇층까지 칠할건지 받아오기
		int N = sc.nextInt(); // N은 아파트 층 수

		// 1. 동적 테이블 생성
		int[][] D = new int[N + 1][2];
		
		// D[N][0] = N층을 노란색으로 칠했을 때
		// D[N][1] = N층을 파란색으로 칠했을 때
		
		// 2. 베이스 값 채우기 (재귀에서 기저조건)
		D[1][0] = 1;
		D[1][1] = 1;
		
		D[2][0] = 2;
		D[2][1] = 1;
		
		// 3. 점화식을 이용하여 상향식으로 동적테이블 채우기
		for (int i = 3; i <= N; i++) {
			D[i][0] = D[i - 1][0] + D[i - 1][1]; // 현재층 노랑 = 이전층 노랑 + 이전층 파랑
			D[i][1] = D[i - 1][0]; // 현재층 파랑 = 이전층 노랑
		}
		
		System.out.println(D[N][0] + D[N][1]);
	}

	public static void main(String[] args) {
		new DP_연습문제1().solution();
	}
}

