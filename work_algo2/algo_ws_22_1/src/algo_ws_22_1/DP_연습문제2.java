package algo_ws_22_1;

import java.util.Scanner;

public class DP_연습문제2 {

	public void solution() {
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt(); 

		// 1. 동적 테이블 생성
		int[] D = new int[N + 1];
		
		
		// 2. 베이스 값 채우기 (재귀에서 기저조건)
		D[0] = 1;
		D[1] = 2;
		D[2] = 5;
		
		// 3. 점화식을 이용하여 상향식으로 동적테이블 채우기
		for (int i = 3; i <= N; i++) {
			D[i] = 2 * D[i - 1] + D[i - 2];
		}
		
		System.out.println(D[N]);
	}

	public static void main(String[] args) {
		new DP_연습문제2().solution();
	}
}

