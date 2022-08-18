import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AdjListTest {

	private static class Node {

		int to;  // 정점의 번호
		Node next;  // 다음 노드

		public Node(int vertex, Node next) {
			this.to = vertex;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node[to=" + to + ", next=" + next + "]";
		}

	}

	private static Node[] adjList;
	private static int N;
	private static boolean[] visited;  // DFS에서 사용할 방문여부 체크 배열

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  // 정점 수
		int E = sc.nextInt();  // 간선 수

		// 정점 수 크기로 생성
		adjList = new Node[N];

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			// 무향이므로 간선 하나로 양방향 처리
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}

		bfs(0);

		/*visited = new boolean[N]; 
		dfs(0);
		visited = new boolean[N];*/
	}

	private static void dfs(int current) {

		visited[current] = true;
		System.out.println((char) (current + 'A'));

		// current 정점의 인접정점들 처리
		for (Node temp = adjList[current]; temp != null; temp = temp.next) {
			if (!visited[temp.to]) {  // 방문하지 않았으며 인접한 경우
				dfs(temp.to);
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
			for (Node temp = adjList[current]; temp != null; temp = temp.next) {
				if (!visited[temp.to]) {  // 방문하지 않았으며 인접한 경우
					visited[temp.to] = true;
					queue.offer(temp.to);
				}
			}
		}
		System.out.println();
	}

}
