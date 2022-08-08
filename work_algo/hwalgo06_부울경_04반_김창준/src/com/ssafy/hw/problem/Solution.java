import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Solution {
	int N;
	int M;
	int[] snackWeights;
	int max;

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			String[] NM = br.readLine().split(" ");
			N = Integer.valueOf(NM[0]);
			M = Integer.valueOf(NM[1]);

			snackWeights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			
			max = -1;
			pick(0, 0, 0);
			if (max == -1)
				max = -1;

			System.out.println("#" + testCase + " " + max);
		}
	}

	public void pick(int count, int index, int sum) {
		if (sum > M)
			return;
		if (count == 2) {
			if (max < sum)
				max = sum;
			return;
		}
		if (index == N)
			return;

		pick(count + 1, index + 1, sum + snackWeights[index]);
		pick(count, index + 1, sum);
	}

	public static void main(String[] args) throws Exception {
		new Solution().solution();
	}
}