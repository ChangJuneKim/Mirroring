package bo;

import java.util.ArrayList;
import java.util.Arrays;

// nPr 순서고려
// dfs -> dfs + 가지치기 + 저장 + 원위치
public class PermTestArrayList {

	static int[] p = { 1, 2, 3, 4, 5 };
	static int N = p.length;
	static int R;
	static int count;
	static ArrayList<String> numList;
	static boolean[] visited;

	public static void main(String[] args) {
		R = 3; // 3개 뽑자
		numList = new ArrayList<>(); // result
		visited = new boolean[N];

		nPr(0, numList);
		System.out.println(count);
	}

	private static void nPr(int depth, ArrayList<String> nums) {
		if (depth == R) {
			count++;
			System.out.println(nums);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			nums.add(p[i] + "");
			nPr(depth + 1, nums);
			nums.remove(p[i] + ""); // 지우면 어떻게 되는지 보자
			visited[i] = false;
		}
	}
}
