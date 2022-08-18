package bo;

import java.util.Arrays;

// nPr 순서고려
// dfs -> dfs + 가지치기 + 저장 + 원위치
public class PermTest {

	static int[] p = { 1, 2, 3, 4, 5 };
	static int N = p.length;
	static int R;
	static int count;
	static int[] nums;
	static boolean[] visited;

	public static void main(String[] args) {
		R = 3; // 3개 뽑자
		nums = new int[R]; // result
		visited = new boolean[N];

		nPr(0);
		System.out.println(count);
	}

	private static void nPr(int depth) {
		if (depth == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			nums[depth] = p[i];
			nPr(depth + 1);
			nums[depth] = 0;
			visited[i] = false;
		}
	}
}
