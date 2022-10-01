package bo0811;

import java.util.Arrays;

public class NextCombiTest {
	static int[] p = { 0, 0, 1, 1, 1, 1 }; // 6C4
	static int[] A = { 1, 2, 3, 4, 5, 6 };
	static int N = p.length;
	static int count;

	public static void main(String[] args) {
		do {
			count++;
			for (int i = 0; i < N; i++) {
				if (p[i] == 1)
					System.out.print(A[i] + " ");
			}
			System.out.println();
		} while (np(N - 1));

		System.out.println(count);
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && p[i - 1] >= p[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (p[i - 1] >= p[j])
			j--;
		int temp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = temp;
		int k = size;
		while (i < k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			i++;
			k--;
		}
		return true;
	}

}