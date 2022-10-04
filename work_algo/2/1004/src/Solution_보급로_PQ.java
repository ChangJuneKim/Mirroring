import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_보급로_PQ {

	static int N = 0, INF = Integer.MAX_VALUE;
	static int map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= TC; ++tc) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];

			for(int i=0; i<N; ++i) {
				char[] ch = in.readLine().toCharArray();
				for(int j=0; j<N; ++j) {
					map[i][j] = ch[j] - '0';
				}
			}

			System.out.println("#"+tc+" "+dijkstra(0, 0));
		}
	}

	private static int dijkstra(int startR, int startC) {
		
		// int[] : { r, c, minTime }
		PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
			
		});
		
		// 출발지에서 자신으로의 최소비용을 저장할 배열 생성 후 초기화
		int[][] minCost = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minCost[i][j] = INF;
			}
		}
		
		// 출발지에서 출발지로의 최소비용 0 처리
		minCost[startR][startC] = 0;
		pQueue.offer(new int[] { startR, startC, minCost[startR][startC] });
		
		int r = 0, c = 0, nr, nc, minTime;
		while (!pQueue.isEmpty()) {
			
			// step1. 미방문 정점 중 최소비용 정점 찾기
			int[] current = pQueue.poll();
			r = current[0];
			c = current[1];
			minTime = current[2];
			
			if (visited[r][c]) continue;
			
			visited[r][c] = true;
			if (r == N - 1 && c == N - 1) return minTime;
			
			// step2. 현재 정점 기준으로 인접한 정점들 들여다보며 경유비용이 유리한지 계산
			for (int d = 0; d < 4; d++) {  // 인접정점 : 4방
				nr = r + dr[d];
				nc = c + dc[d];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && 
						minCost[nr][nc] > minTime + map[nr][nc]) {
					
					minCost[nr][nc] = minTime + map[nr][nc];
					pQueue.offer(new int[] { nr, nc, minCost[nr][nc] });
				}
			}
		}
		
		return -1;
	}

}
