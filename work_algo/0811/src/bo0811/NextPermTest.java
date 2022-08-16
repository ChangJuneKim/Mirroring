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
		int firstPeak = size;
		
		// 주어진 배열의 뒤부터 탐색하며, 증가하는 부분을 찾는다. (앞이 뒤보다 큰 부분)
		while(firstPeak > 0 && p[firstPeak - 1] >= p[firstPeak]) {
			firstPeak--;
		}
		
		// 정렬이 다 돼있어서 처음까지 와버렸으면 끝 -> 여기선 5 4 3 2 1 이 될때
		if(firstPeak == 0) {
			return false;
		}
		
		int gtBeforeFirstPeak = size;
		// 봉우리보다 왼쪽에 있는것 보다 큰걸 찾으러 간다
		while(p[firstPeak - 1] >= p[gtBeforeFirstPeak]) {
			gtBeforeFirstPeak--;
		}
		
		// swap
		int temp = p[firstPeak - 1];
		p[firstPeak - 1] = p[gtBeforeFirstPeak];
		p[gtBeforeFirstPeak] = temp;
		
		int k = size;
		while(firstPeak < k) {
			temp = p[firstPeak];
			p[firstPeak] = p[k];
			p[k] = temp;
			firstPeak++;
			k--;
		}
		
		return true;
	}



	public static void main(String[] args) {
		new NextPermTest().solution();
	}
}
