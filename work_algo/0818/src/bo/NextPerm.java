package bo;

import java.util.Arrays;

public class NextPerm {
	
	static int[] p = {1,2,3,3,5};
	static int N = p.length;
	static int count;
	
	public static void main(String[] args) {
		do {
			count++;
			System.out.println(Arrays.toString(p));
		} while (np(N - 1));
		System.out.println(count);
	}
	
	private static boolean np(int size) {
		// 1.
		int i = size;
		while(i > 0 && p[i - 1] >= p[i]) {
			i--;
		}
		// 다 정렬 돼 있다면
		if(i == 0) {
			return false;
		}
		
		// 2.
		int j = size;
		while(p[i - 1] >= p[j]) {
			j--;
		}
		
		int temp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = temp;
		
		// 3.
		int k = size;
		while(i < k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			
			i++;
			k--;
		}
		
		return true;
	}
}
