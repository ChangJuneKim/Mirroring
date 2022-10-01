package bo0811;

import java.lang.Character.Subset;
import java.util.Arrays;

// nPr 3P2 = 3 * 2;
// 재귀
public class SubsetTest {

	int[] p = { 1, 2, 3, 4, 5 };
	int N = p.length;
	int count;
	boolean[] visited;

	public void solution() {
		visited = new boolean[N];
		subset(0,0);
		System.out.println(count);
	}

	void subset(int depth, int total) {
		if (depth == N) { // 선택한다 vs 안한다 합해서 N개
			count++;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					System.out.print(p[i] + " ");
				}
			}
			System.out.println();
			System.out.println("--->" + total);
			return;
		}

		visited[depth] = true; //선택했을 때
		subset(depth + 1, total + p[depth]);
		
		visited[depth] = false; //선택 안했을 때
		subset(depth + 1, total);

	}

	public static void main(String[] args) {
		new SubsetTest().solution();
	}
}

