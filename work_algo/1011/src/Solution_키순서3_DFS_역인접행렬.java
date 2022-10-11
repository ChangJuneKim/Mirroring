import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 인접행렬 + 역인접행렬 + DFS
public class Solution_키순서3_DFS_역인접행렬 {

	private static int N, M;
	private static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());

			int[][] adjMatrix = new int[N + 1][N + 1];  // 학생번호 1부터 처리, 자신보다 큰 학생정보
			int[][] radjMatrix = new int[N + 1][N + 1];  // 학생번호 1부터 처리, 자신보다 작은 학생정보

			StringTokenizer st = null;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				radjMatrix[b][a] = adjMatrix[a][b] = 1;  // a보다 b가 키가 크다, b보다 a가 키가 작다
			}

			int answer = 0;

			for (int i = 1; i <= N; i++) {  // 모든 학생을 탐색의 시작점으로 하여 반복
				cnt = 0;  // 초기화
				dfs(i, adjMatrix, new boolean[N + 1]);
				dfs(i, radjMatrix, new boolean[N + 1]);
				if (cnt == N - 1) answer++;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void dfs(int cur, int[][] adjMatrix, boolean[] visited) {  // cur 학생보다 키가 큰 학생따라 탐색

		visited[cur] = true;

		for (int i = 1; i <= N; i++) {  // 자신의 인접행렬 들여다보기
			if (adjMatrix[i][cur] == 1 && !visited[i]) {  // adjMatrix 전달대상에 따라 
														  // i가 cur보다 키가 큰 경우(i가 cur보다 키가 작은 경우) 아직 탐색되지 않았다면
				cnt++;  // adjMatrix 전달대상에 따라 나보다 큰(작은) 학생 카운트
				dfs(i, adjMatrix, visited);
			}
		}
	}

}
