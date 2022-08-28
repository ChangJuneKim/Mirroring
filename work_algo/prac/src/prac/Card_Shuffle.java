package prac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 	중복 순열을 이용하여 모든 경우의 수 탐색
 */
public class Card_Shuffle {

	private static int N, result;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("shuffle_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= 2; test_case++) {
			sb.append("#" + test_case + " ");

			N = Integer.parseInt(in.readLine());

			int[] cards = new int[N];

			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++)
				cards[i] = Integer.parseInt(st.nextToken());

			// 6까지 도달하면 안되기 때문에 초기 값을 6으로
			result = 6;

			find(0, cards);

			if (result == 6)
				result = -1;

			sb.append(result)
				.append("\n");
		}

		out.write(sb.toString());
		out.flush();
	}

	// 중복 순열을 돌리면서 카드가 오름차순이거나 내림차순 정렬되면 최솟값 갱신
	private static void find(int step, int[] cards) {
		System.out.println(Arrays.toString(cards));
		if (step >= result)
			return;

		if (check(cards)) {
			result = Math.min(result, step);
			return;
		}

		for (int i = 1; i < N; i++) {
			find(step + 1, shuffle(cards, i));
		}
	}

	// 카드를 섞는 함수, x 가 N/2 보다 작을 때는 왼쪽 카드를 harf-x 만큼 넣고 오른쪽, 왼쪽 하나씩 넣는
	private static int[] shuffle(int[] cards, int x) {
		int[] result = new int[N];

		int harf = N / 2;

		// x 가 N/2 보다 작을 때
		if (x < harf) {
			// result 에 저장할 index
			int index = 0;
			// 왼쪽 카드에서 harf - x 만큼 먼저 넣음
			for (; index < harf - x; index++)
				result[index] = cards[index];

			// 왼쪽 카드 중 다음 넣어야 할 카드
			int left = harf - x;
			// 오른쪽 카드 중 다음 넣어야 할 카드 ( 오른쪽의 첫번째 카드 )
			int right = harf;

			// x 만큼 오른쪽카드, 왼쪽카드를 반복해서 넣음
			for (int i = 0; i < x; i++) {
				result[index++] = cards[right++];
				result[index++] = cards[left++];
			}

			// 남은 오른쪽 카드를 모두 넣음
			for (; index < N; index++)
				result[index] = cards[index];
		}

		// x 가 N/2 보다 클 때 ( 위의 과정을 반대로 수행 )
		else {
			int index = 0;
			// 오른쪽 카드를 먼저 넣음
			for (; index <= x - harf; index++)
				result[index] = cards[harf + index];

			int left = 0;
			int right = index + harf;

			// 왼쪽 카드, 오른쪽 카드를 반복해서 넣음
			for (int i = 0; i < N - 1 - x; i++) {
				result[index++] = cards[left++];
				result[index++] = cards[right++];
			}

			// 남은 왼쪽 카드를 다 넣음
			for (; index < N; index++)
				result[index] = cards[index - harf];
		}

		return result;
	}

	// 카드들이 오름차순 혹은 내림차순 정렬되어 있는지 확인
	private static boolean check(int[] cards) {
		boolean asc = true;
		boolean desc = true;

		for (int i = 0; i < N - 1; i++) {
			if (cards[i] > cards[i + 1])
				asc = false;

			if (cards[i] < cards[i + 1])
				desc = false;
		}

		return asc | desc;
	}
}