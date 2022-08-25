

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraTest_PQ {

	private static class Vertex implements Comparable<Vertex> {
		public int no;  // 정점 번호
		public int minD;  // 출발지에서 자신으로의 최소비용

		public Vertex(int no, int minDistance) {
			this.no = no;
			this.minD = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minD - o.minD;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());  // 정점 개수

		int[][] adjMatrix = new int[V][V];
		int start = 0;
		int end = V - 1;

		StringTokenizer st = null;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] D = new int[V];  // 출발지에서 자신으로의 최소(최단) 비용(거리) => 최단 경로 구성 가중치 합
		boolean[] visited = new boolean[V];  // 최소비용 확정여부
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>();

		Arrays.fill(D, Integer.MAX_VALUE);
		D[start] = 0;  // 시작점 최소 비용을 0으로 설정
		pQueue.offer(new Vertex(start, D[start]));

		while (!pQueue.isEmpty()) {

			// 1단계 : 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
			// 방문 해야하는 나머지 정점 중 출발지에서 가장 가까운 정점 찾기
			Vertex minVertex = pQueue.poll();

			// 이미 처리된 정점이 큐에서 또 나오면 무시
			if (visited[minVertex.no]) {
				continue;
			}

			// 2단계: 방문처리
			visited[minVertex.no] = true;  // 선택 정점 방문 처리
			
			// 문제가 start -> end로의 최단이면 탈출
			/*if (minVertex.no == end) {
				break;
			}*/

			// 3단계 : 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 갱신
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjMatrix[minVertex.no][j] != 0 && 
						D[j] > D[minVertex.no] + adjMatrix[minVertex.no][j]) {
					D[j] = D[minVertex.no] + adjMatrix[minVertex.no][j];
					pQueue.offer(new Vertex(j, D[j]));
				}
			}
		}

		System.out.println(Arrays.toString(D));
		System.out.println(D[end]);
	}

}
