import java.util.Scanner;

public class FloydWarshall {
	
	private static final int INF = 99999;
	private static int N;  // 정점의 수
	private static int[][] D;  // 동적테이블 (출발지에서 도착지까지 가는 최단 경로를 저장하는 배열)
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		D = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				D[i][j] = sc.nextInt();
				
				// 자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
				if (i != j && D[i][j] == 0) {
					D[i][j] = INF;
				}
			}
		}
		
		// 플로이드 워샬 알고리즘 적용
		// 경유지 -> 출발지 -> 도착지 순으로 삼중 for문 작성 (경! 출! 도!)
		for (int k = 0; k < N; k++) {  // 경유지
			for (int i = 0; i < N; i++) {  // 출발지
				
				if (i == k) {  // 출발지와 경유지가 같다면 다음 출발지로 탐색
					continue;
				}
				
				for (int j = 0; j < N; j++) {  // 도착지
					
					if (k == j || i == j) {  // 경유지와 도착지가 같거나 출발지가 도착지와 같으면 다음 도착지 탐색
						continue;
					}
					
					// i에서 j로 바로 가는 거리보다 k 경유지를 거쳐서 가는 거리가 더 짧다면
					if (D[i][j] > D[i][k] + D[k][j]) {  // 여기서 오버플로우 발생하니까! INF를 적당히...
						D[i][j] = D[i][k] + D[k][j];  // 최단거리 갱신
					}
				}
			}
		}
		
		// 최적화 된 거리 값을 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}
	}
}
