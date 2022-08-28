package bo;

import java.util.Arrays;

public class NextComb {

	static int[] p = { 0, 1, 1, 1, 1 };
	static int[] A = { 1, 2, 3, 4, 5 };
	static int N = p.length;
	static int count;

	public static void main(String[] args) {

		do {
			count++;
			for (int i = 0; i < N; i++) {
				if (p[i] == 1)
					System.out.print(A[i] + " ");
			}
			System.out.println(Arrays.toString(p));
		} while (np(N - 1));
		System.out.println(count);

	}

	private static boolean np(int size) {
		int firstPeak = size;
		// 최초의 하향 변곡점을 찾는다(앞이 뒤보다 작은부분을 찾는 것) ex) 6 2 "1" "5" 4 3 0
		// (firtPeak - 1) (firstPeak)
		while (firstPeak > 0 && p[firstPeak - 1] >= p[firstPeak]) {
			firstPeak--;
		}

		// 다 내림차순으로 정렬 돼 있다면 마지막 순열이라는 뜻.
		if (firstPeak == 0) {
			return false;
		}

		// 하향 변곡점 앞에 있는 요소와 위치를 바꿀 녀석을 찾기 p[firstPeak - 1] 보다는 큰값이어야 한다
		// ex) 6 2 "1" 5 4 3 0 -> 여기서는 3이다
		int gtBeforeFirstPeak = size;
		while (p[firstPeak - 1] >= p[gtBeforeFirstPeak]) {
			gtBeforeFirstPeak--;
		}

		swap(firstPeak - 1, gtBeforeFirstPeak);

		// 3.
//		for (int left = firstPeak, right = size; left < right; left++, right--) {
//			swap(left, right);
//		}

		// firstPeak(left) 부터 마지막(size)(right) 까지 뒤집는다
		int right = size;
		int left = firstPeak;
		while (left < right) {
			swap(left, right);
			left++;
			right--;
		}

		return true;
	}

	static void swap(int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;

	}

}