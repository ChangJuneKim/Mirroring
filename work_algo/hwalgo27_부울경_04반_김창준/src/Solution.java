import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int INF = 1000;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int answer = 0;

			// graph[i][j] != INF: i가 j보다 키가 작다는 것
			// graph[j][i] != INF: i가 j보다 키가 크다는 것
			int[][] graph = new int[N + 1][N + 1];

			// gragh 큰 값으로 초기화
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					graph[i][j] = INF;
				}
			}

			// 주어진 정보 받기
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph[from][to] = 1;
			}

			// Floyd-Warshall(: 다른 학생을 통해 현재 학생의 정보를 알 수 있는지 확인)
			for (int k = 1; k <= N; k++) { 			// 경유지
				for (int i = 1; i <= N; i++) { 		// 출발지
					for (int j = 1; j <= N; j++) { 	// 도착지
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}

			// 자신의 키가 몇 번째인지 알 수 있는 학생들이 모두 몇 명인지 계산
			for (int i = 1; i <= N; i++) {
				boolean flag = true;
				for (int j = 1; j <= N; j++) {
					// 하나라도 INF라는 것은 i와 j의 키를 비교할 수 없다는 것을 의미함
					// -> 자신의 키가 몇 번째인지 알 수 없음
					if (i != j && graph[i][j] == INF && graph[j][i] == INF) {
						flag = false;
						break;
					}
				}
				if (flag) {
					answer++;
				}
			}

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}