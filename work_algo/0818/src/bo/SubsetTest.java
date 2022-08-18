package bo;

import java.util.Arrays;

// 1 << N (2의 N승) pow 쓰지말고~
// 선택한다? 안한다? 를 계속 곱하기때문에 2^n
public class SubsetTest {

	static int[] p = { 1, 2, 3, 4, 5 };
	static int N = p.length;
	static int count;
	static boolean[] visited;
	static int total;
	
	public static void main(String[] args) {
		visited = new boolean[N];

		subset(0, total);
		System.out.println(count);
	}

	private static void subset(int depth, int total) {
		if (depth == N) {
			count++;
			for (int i = 0; i < N; i++) {
				if(visited[i]) {
					System.out.print(p[i] + " ");
				}
			}
			System.out.println();
			System.out.println("------->" + total);
			return;
		}

		visited[depth] = true;
		subset(depth + 1, total + p[depth]);
		visited[depth] = false;
		subset(depth + 1, total);
	}
}
