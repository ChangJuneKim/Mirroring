import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class PrimTest {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input3.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		// 인접 행렬
		int[][] adjMatrix = new int[N][N];
		int[] minEdge = new int[N];  // 타 정점에서 자신으로의 간선 비용 중 최소 비용
		boolean[] visited = new boolean[N];  // 신장트리에 선택된 여부
		
		// input 파일에 주어진 인접 행렬 데이터를 adjMatrix에 담기
		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(split[j]);
			}
			minEdge[i] = Integer.MAX_VALUE;  // 최솟값 초기화
		}
		
		int result = 0;  // MST 비용
		minEdge[0] = 0;  // 임의의 시작점 비용 0 설정
		
		// 모든 정점 수 만큼 반복
		for (int count = 0; count < N; count++) {
			
			// 신장트리에 연결되지 않은 정점 중 가장 유리한 비용의 정점을 선택
			int min = Integer.MAX_VALUE;  // 초기값으로 정수의 최대치를 주고 시작
			int minVertex = 0;
			
			// 1단계
			for (int i = 0; i < N; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			// 선택된 정점을 신장트리에 포함시킴
			visited[minVertex] = true;
			result += min;
			
			// 2단계: 선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선비용을 따져보고
			// 최솟값 갱신
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		
		System.out.println(result);
	}
}

//public static class Edge implements Comparable<Edge>{
//	int v; // 진입하는 정점
//	int w; // 가중치
//	Edge(int vertex, int weight) {
//		this.v = vertex;
//		this.w = weigth;
//	}
//	@Override
//	public int compareTo(Edge e) {
//		return this.w - e.w;
//	}
//}
//static Edge eList[] = new Edge[vNum+1];
//public static int prim(int sV) {
//	PriorityQueue<Edge> pQ = new PriorityQueue<>();
//	pQ.add(new Edge(sV, 0)); // 시작 정점 저장
//	boolean visited[] = new boolean[vNum+1]; // 해당 정점을 간선으로 연결해줬는지 확인
//	Edge e;
//	int totW = 0;
//	while(!pQ.isEmpty()) {
//		e = pQ.remove(); // 간선
//		if(!visited[e.v]) { // 방문 유무에 따라 그래프에 사이클이 생기는지가 결정
//			visited[e.v] = true;
//			totW += e.w;
//			for(Edge next : eList[e.v])
//				if(!visited[next.v])
//					pQ.add(next); // 방문하지 않은 해당 정점으로 부속된 간선 큐에 저장
//		}
//	}
//	return totW; // MST 가중치 합
//}