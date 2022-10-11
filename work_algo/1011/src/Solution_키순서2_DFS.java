import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 인접행렬 + DFS
public class Solution_키순서2_DFS {

	private static int N, M, adjMatrix[][];
	private static int gtCnt, ltCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());

			adjMatrix = new int[N + 1][N + 1];  // 학생번호 1부터 처리

			StringTokenizer st = null;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;  // a보다 b가 키가 크다
			}

			int answer = 0;

			for (int i = 1; i <= N; i++) {  // 모든 학생을 탐색의 시작점으로 하여 반복
				gtCnt = ltCnt = 0;  // 초기화
				gtDFS(i, new boolean[N + 1]);
				ltDFS(i, new boolean[N + 1]);
				if (gtCnt + ltCnt == N - 1) answer++;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void gtDFS(int cur, boolean[] visited) {  // cur 학생보다 키가 큰 학생따라 탐색

		visited[cur] = true;

		for (int i = 1; i <= N; i++) {  // 자신의 인접행렬 들여다보기
			if (adjMatrix[cur][i] == 1 && !visited[i]) {  // i가 cur보다 키가 크고 아직 탐색되지 않았다면
				gtCnt++;  // 나보다 큰 학생 카운트
				gtDFS(i, visited);
			}
		}
	}

	private static void ltDFS(int cur, boolean[] visited) {  // cur 학생보다 키가 작은 학생따라 탐색

		visited[cur] = true;

		for (int i = 1; i <= N; i++) {  // 인접행렬에서 자신의 열로 간선정보를 갖고 있는 정점 들여다보기
			if (adjMatrix[i][cur] == 1 && !visited[i]) {  // i가 cur보다 키가 작고 아직 탐색되지 않았다면
				ltCnt++;  // 나보다 작은 학생 카운트
				ltDFS(i, visited);
			}
		}
	}

}
