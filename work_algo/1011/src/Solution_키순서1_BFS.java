import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 인접행렬 + BFS
public class Solution_키순서1_BFS {

	private static int N, M, adjMatrix[][];

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
				if (gtBFS(i) + ltBFS(i) == N - 1) answer++;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static int gtBFS(int start) {  // start 학생부터 자신보다 키가 큰 학생따라 탐색

		int cnt = 0;  // 나보다 큰 학생 수
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N + 1];

		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 1; i <= N; i++) {  // 자신의 인접행렬 들여다보기
				if (adjMatrix[cur][i] == 1 && !visited[i]) {  // i가 cur보다 키가 크고 아직 탐색되지 않았다면
					cnt++;  // 나보다 큰 학생 카운트
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		
		return cnt;
	}
	
	private static int ltBFS(int start) {  // start 학생부터 자신보다 키가 작은 학생따라 탐색

		int cnt = 0;  // 나보다 작은 학생 수
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N + 1];

		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 1; i <= N; i++) {  // 인접행렬에서 자신의 열로 간선정보를 갖고 있는 정점 들여다보기
				if (adjMatrix[i][cur] == 1 && !visited[i]) {  // i가 cur보다 키가 작고 아직 탐색되지 않았다면
					cnt++;  // 나보다 작은 학생 카운트
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		
		return cnt;
	}

}
