import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {
	
	private static int[][] adjMatrix;
	private static int N;
	private static boolean[] visited;  // DFS에서 사용할 방문여부 체크 배열
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  // 정점 수
		int E = sc.nextInt();  // 간선 수
		
		adjMatrix = new int[N][N];  // 정점 수 크기로 생성, 0으로 자동 초기화
		
		for (int i = 0; i < E; i++) {  // 간선정보에 해당하는 부분만 덮어씀
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			// 무향이므로 간선 하나로 양방향 처리
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		
		bfs(0);
		
		visited = new boolean[N]; 
		dfs(0);
		visited = new boolean[N];
	}
	
	private static void dfs(int current) {

		visited[current] = true;
		System.out.println((char) (current + 'A'));

		// current 정점의 인접정점들 처리
		for (int i = 0; i < N; i++) {
			if (!visited[i] && adjMatrix[current][i] != 0) {  // 방문하지 않았으며 인접한 경우
				dfs(i);
			}
		}
	}

	// start: 시작 정점 번호 (인덱스 번호)
	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean visited[] = new boolean[N];

		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			
			int current = queue.poll();
			System.out.println((char) (current + 'A'));

			// current 정점의 인접정점들에 큐에 넣어서 차후 탐색하도록 만들기
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjMatrix[current][i] != 0) {  // 방문하지 않았으며 인접한 경우
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		System.out.println();
	}

}
