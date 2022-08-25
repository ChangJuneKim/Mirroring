
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
public class TopologySort_BFS {

	private static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}

	private static int V, E;
	private static Node[] adjList;
	private static int[] inDegree;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new Node[V + 1];  // 각 정점별 인접 리스트
		inDegree = new int[V + 1];  // 각 정점별 진입차수
		
		// input 파일에 주어진 인접 행렬 데이터를 adjMatrix에 담기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			// 무향이므로 간선 하나로 양방향 처리
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}
		
		ArrayList<Integer> list = topologySort();
		if (list.size() == V) {  // 위상정렬 완성
			
			StringBuilder sb = new StringBuilder();
			for (int o : list) {
				sb.append(o).append(" ");
			}
			System.out.println(sb);
			
		}
		else {
			System.out.println("cycle..");
		}

	}
	
	private static ArrayList<Integer> topologySort() {
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		
		// 진입차수가 0인 정점 큐에 넣기
		for (int i = 1; i <= V; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		// BFS
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			list.add(cur);

			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (--inDegree[temp.vertex] == 0) {
					queue.offer(temp.vertex);
				}
			}
		}
		return list;
	}
}