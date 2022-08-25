import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrimTest_adjMatrix {
	
	public static void main(String[] args) throws Exception {
		
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
			
			// 1단계: 신장트리의 구성에 포함되지 않은 정점 중 최소비용 정점 선택
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int i = 0; i < N; i++) {
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
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		
		System.out.println(result);
	}
}
