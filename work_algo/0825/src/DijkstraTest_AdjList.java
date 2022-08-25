

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
10 17
0 1 4
0 2 6
1 3 9
1 4 8
2 1 3
2 4 2
2 5 3
3 6 6
4 3 2
4 5 1
4 6 3
4 7 7
5 7 4
5 8 8
6 9 13
7 9 9
8 9 4

output ==>21
 */
/**
 * @author taeheekim
 */
public class DijkstraTest_AdjList {

	private static class Node {

		int vertex;
		int weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", next=" + next + "]";
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());  // 정점의 개수
		int E = Integer.parseInt(st.nextToken());  // 간선의 개수

		Node[] adjList = new Node[V];
		int start = 0;
		int end = V - 1;  // 도착점 인덱스

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, weight, adjList[from]);
		}

		int[] D = new int[V];  // 출발지에서 자신으로의 최소(최단) 비용(거리) => 최단 경로 구성 가중치 합
		boolean[] visited = new boolean[V];  // 최소비용 확정여부

		Arrays.fill(D, Integer.MAX_VALUE);
		D[start] = 0;  // 시작점 최소 비용을 0으로 설정

		for (int i = 0; i < V; i++) {

			// 1단계 : 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
			// 방문 해야하는 나머지 정점 중 출발지에서 가장 가까운 정점 찾기
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > D[j]) {
					min = D[j];
					minVertex = j;
				}
			}

			// 2단계: 방문처리
			visited[minVertex] = true;  // 선택 정점 방문 처리
			
			// 문제가 start -> end로의 최단이면 탈출
			/*if (minVertex == end) {
				break;  // current가 도착지라면 끝냄
			}*/

			// 3단계 : 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 갱신
			for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] &&
						D[temp.vertex] > D[minVertex] + temp.weight) {
					D[temp.vertex] = D[minVertex] + temp.weight;
				}
			}
		}

		System.out.println(Arrays.toString(D));
		System.out.println(D[end]);
	}

}
