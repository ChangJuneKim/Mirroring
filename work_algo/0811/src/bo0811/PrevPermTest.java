package bo0811;

import java.util.Arrays;

//nPn 3p3= 3*2*1
// 재귀
public class PrevPermTest {

	static int[] p = { 5, 4, 3, 2, 1 };
	static int N = p.length;
	static int count;

	public static void main(String[] args) {

		do {
			count++;
			System.out.println(Arrays.toString(p));
		} while (pp(N - 1));

		System.out.println(count);
	}

	private static boolean pp(int size) {
		int i = size;
		while (i > 0 && p[i - 1] < p[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (p[i - 1] < p[j])
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
