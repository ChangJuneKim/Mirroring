package bo0811;

import java.util.Arrays;

// nPn 3P3 = 3 * 2 * 1;
// 무조건 다 선택해야 함
// 재귀
public class NextPermTest {

	int[] p = { 1, 2, 3, 4, 5 };
	int N = p.length;
	int count;

	public void solution() {
		do {
			count++;
			System.out.println(Arrays.toString(p));
		} while (np(N - 1));
		
		System.out.println(count);
	}
	


	boolean np(int size) {
		int i = size;
		
		// 뒤에서부터 봉우리 찾기 
		while(i > 0 && p[i - 1] > p[i]) {
			i--;
		}
		
		// 정렬이 다 돼있어서 처음까지 와버렸으면 끝
		if(i == 0) {
			return false;
		}
		
		int j = size;
		// 봉우리보다 왼쪽에 있는것 보다 큰걸 찾으러 간다
		while(p[i - 1] > p[j]) {
			j--;
		}
		
		// swap
		int temp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = temp;
		
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



	public static void main(String[] args) {
		new NextPermTest().solution();
	}
}
