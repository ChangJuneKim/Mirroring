package bo;

import java.util.Arrays;

// nPr 순서고려
// dfs -> dfs + 가지치기 + 저장 + 원위치
public class CombiTest {

	static int[] p = { 1, 2, 3, 4, 5 };
	static int N = p.length;
	static int R;
	static int count;
	static int[] nums;

	public static void main(String[] args) {
		R = 3; // 3개 뽑자
		nums = new int[R]; // result

		nCr(0, 0);
		System.out.println(count);
	}

	private static void nCr(int depth, int start) {
		if (depth == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}

		for (int i = start; i < N; i++) {
			nums[depth] = p[i];
			nCr(depth + 1, i + 1);
			nums[depth] = 0;
		}
	}
}
