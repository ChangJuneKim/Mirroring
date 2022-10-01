import java.util.Scanner;

/*
5 21
5 30 40 6 10

10 25
25 1 3 4 5 6 7 8 9 11 12
 */
// n개의 자연수를 입력받고 목표 합이 주어지면 목표 합에 해당하는 부분집합을 출력
public class SubSetSumTest {

	static int N, S, totalCount, callCount;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  // 집합의 크기
		S = sc.nextInt();  // 목표 합
		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		subset(0);
		System.out.println("총 호출의 수 : " + callCount);
		System.out.println("총 경우의 수 : " + totalCount);

		totalCount = callCount = 0;

		subset2(0, 0);
		System.out.println("총 호출의 수 : " + callCount);
		System.out.println("총 경우의 수 : " + totalCount);
	}

	// 5 0
	// -7, -3, -2, 5, 8
	// index: 현재까지 고려한 원소 수
	private static void subset(int index) {
		++callCount;

		if (index == N) {  // 마지막 원소까지 부분집합에 다 고려된 상황
			int sum = 0;
			int elementCnt = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sum += input[i];
					elementCnt++;
				}
			}

			if (sum == S && elementCnt > 0) {
				++totalCount;
				for (int i = 0; i < N; i++) {
					if (isSelected[i]) {
						System.out.print(input[i] + " ");
					}
				}
				System.out.println();
			}
			return;
		}

		isSelected[index] = true;
		subset(index + 1);
		isSelected[index] = false;
		subset(index + 1);
	}

	// 6 21
	// 5 21 11 16 6 10
	// index: 현재까지 고려한 원소 수, sum: 직전까지의 합
	private static void subset2(int index, int sum) {
		++callCount;

		// 기저부분 (종료조건)
		if (sum == S) {
			++totalCount;
			for (int i = 0; i < index; i++) {
				if (isSelected[i]) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		// 가지치기
		if (sum > S) {
			return;
		}

		// 기저부분 (종료조건)
		// 원하는 합은 구하지 못했지만 끝에 도달한 경우
		if (index == N) {
			return;
		}

		// 유도부분
		isSelected[index] = true;
		subset2(index + 1, sum + input[index]);
		isSelected[index] = false;
		subset2(index + 1, sum);
	}

}
