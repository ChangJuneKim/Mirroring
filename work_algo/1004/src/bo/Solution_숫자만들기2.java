package bo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Solution_숫자만들기2 {
	int T, N;
	int[] operator;
	int[] numbers;
	int min, max;

	public static void main(String[] args) throws IOException {
		new Solution_숫자만들기2().solution();
	}

	private void subset(int depth, int total, int add, int sub, int mul, int div) {
		if (depth == N) {
			min = Math.min(min, total);
			max = Math.max(max, total);
			return;
		}

		if (add > 0) {
			subset(depth + 1, total + numbers[depth], add - 1, sub, mul, div);
		}
		if (sub > 0) {
			subset(depth + 1, total - numbers[depth], add, sub - 1, mul, div);
		}
		if (mul > 0) {
			subset(depth + 1, total * numbers[depth], add, sub, mul - 1, div);
		}
		if (div > 0) {
			subset(depth + 1, total / numbers[depth], add, sub, mul, div - 1);
		}
	}

	public void solution() throws IOException {
		System.setIn(Files.newInputStream(Paths.get("input_bo.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			operator = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}

			numbers = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;

			subset(1, numbers[0], operator[0], operator[1], operator[2], operator[3]);

			sb.append("#").append(testCase).append(" ").append(max - min).append("\n");
		}
		System.out.println(sb);
	}

}
