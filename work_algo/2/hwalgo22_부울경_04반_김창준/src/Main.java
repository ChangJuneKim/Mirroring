import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1463(S3) 1로 만들기
public class Main {

	final int RED = 0;
	final int GREEN = 1;
	final int BLUE = 2;

	public void solution() throws IOException {
		System.setIn(Files.newInputStream(Paths.get("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[n + 1][3];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			dp[i][RED] += Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]);
			dp[i][GREEN] += Math.min(dp[i - 1][RED], dp[i - 1][BLUE]);
			dp[i][BLUE] += Math.min(dp[i - 1][RED], dp[i - 1][GREEN]);
		}

		System.out.println(Math.min(Math.min(dp[n][RED], dp[n][GREEN]), dp[n][BLUE]));
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}
