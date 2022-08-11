package bo0811;

import java.util.Arrays;

// nCr 3C2 = 3 * 2 / 2;
// 재귀
public class Combination {

	int[] p = { 1, 2, 3, 4, 5 };
	int N = p.length;
	int R;
	int count;
	int[] nums;
	boolean[] visited;

	public void solution() {
		R = 3; // 뽑을 개수
		nums = new int[R]; // 내 결과

		ncr(0, 0);
		System.out.println(count);
	}
	
	void ncr(int depth, int start) {
		if(depth == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = start; i < N; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true; // <- 선택한건 누구고 선택 안한건 누구다 라는걸 알 수 있음 visited가 있으면
			nums[depth] = p[i];
			ncr(depth + 1, i+1);
			nums[depth] = 0;
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		new Combination().solution();
	}
}
