package bo0811;

import java.util.Arrays;

// nPr 3P2 = 3 * 2;
// 재귀
public class PermTest {

	int[] p = { 1, 2, 3, 4, 5 };
	int N = p.length;
	int R;
	int count;
	int[] nums;
	boolean[] visited;

	public void solution() {
		R = 3; // 뽑을 개수
		nums = new int[R]; // 내 결과
		visited = new boolean[N];

		npr(0);
		System.out.println(count);
	}
	
	// dfs + 저장 <--> 원위치 + 가지치기(prunning) => 백트래킹
	// 순열은 백트래킹이다
	void npr(int depth) {
		if(depth == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			nums[depth] = p[i];
			npr(depth + 1);
			nums[depth] = 0;
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		new PermTest().solution();
	}
}
