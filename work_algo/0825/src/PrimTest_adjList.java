import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimTest_adjList {
	
	private static class Node {
		int vertex;
		int weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		// 인접 리스트
		Node[] adjList = new Node[V];  // 각 정점별 인접 리스트
		
		// input 파일에 주어진 인접 행렬 데이터를 adjMatrix에 담기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			// 무향이므로 간선 하나로 양방향 처리
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		// 프림 알고리즘에 필요한 자료구조
		int[] minEdge = new int[V];  // 각 정점 입장에서 신장트리에 포함된 정점과의 간선 비용 중 최소비용
		boolean[] visited = new boolean[V];  // 신장트리에 선택된 여부
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);  // 최솟값 관리하기 위해 큰 값 세팅
		
		// 1. 임의의 시작점 처리, 0번 정점을 신장트리의 구성의 시작점
		minEdge[0] = 0;
		int result = 0;  // 최소신장트리 비용 누적
		
		for (int c = 0; c < V; c++) {  // V개의 정점 처리하면 끝
			
			// 1단계: 신장트리의 구성에 포함되지 않은 정점 중 최소비용 정점 선택
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int i = 0; i < V; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			// 2단계: 신장트리에 추가
			visited[minVertex] = true;
			result += min;
			
			// 3단계: 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소비용과 비교해서 갱신
			// 신장트리에 새롭게 추가되는 정점의 모든 인접정점 들여다보며 처리
			for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
				}
			}
		}
		
		System.out.println(result);
	}
}