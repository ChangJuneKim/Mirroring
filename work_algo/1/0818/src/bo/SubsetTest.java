package bo;

import java.util.Arrays;

// 1 << N (2의 N승) pow 쓰지말고~
// 선택한다? 안한다? 를 계속 곱하기때문에 2^n
public class SubsetTest {

	static int[] numbers = { 1, 2, 3, 4, 5 };
	static int N = numbers.length;
	static int count;
	static boolean[] visited;
	static int total;
	
	public static void main(String[] args) {
		visited = new boolean[N];

		subset(0, total);
		System.out.println(count);
		
		System.out.println("바이너리 카운팅을 이용한 부분집합 -> 사전순으로 볼 수 있다.");
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					System.out.print(numbers[j] + " ");
				}
			}
			System.out.println();
		}
	}

	private static void subset(int depth, int total) {
		if (depth == N) {
			count++;
			for (int i = 0; i < N; i++) {
				if(visited[i]) {
					System.out.print(numbers[i] + " ");
				}
			}
			System.out.println();
			System.out.println("------->" + total);
			return;
		}

		visited[depth] = true;
		subset(depth + 1, total + numbers[depth]);
		
		visited[depth] = false;
		subset(depth + 1, total);
	}
}
