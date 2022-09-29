package bo0811;

import java.util.Arrays;

// 재귀
public class PermTestBit {

	int[] p = { 1, 2, 3, 4, 5 };
	int N = p.length;
	int R;
	int count;
	int[] nums;

	// 11111 10101
	// subset 이용
	
	public void solution() {
		R = 3; // 뽑을 개수
		nums = new int[R]; // 내 결과

		npr(0, 0);
		System.out.println(count);
	}
	
	// dfs + 저장 <--> 원위치 + 가지치기(prunning) => 백트래킹
	// 순열은 백트래킹이다
	// + bit dp
	void npr(int depth, int flag) {
		if(depth == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag & (1<<i))!=0) {
				continue;
			}
			
			nums[depth] = p[i];
			npr(depth + 1, (flag | (1 << i)));
//			nums[depth] = 0;
			
		}
	}

	public static void main(String[] args) {
		new PermTestBit().solution();
	}
}
