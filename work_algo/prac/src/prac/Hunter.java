package prac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 	순열을 통해 모든 경우의 수를 다 구해본다.
 * 	이 때 고객들에겐 초기에 갈 수 없다고 표시 해놓고 해당 고객이 요청한 몬스터에게 가면 해당 고객에게 갈 수 있다고 나타낸다.
 */
public class Hunter {
	
	private static class Point{
		int y;
		int x;
		
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		// 좌표간의 거리를 구함
		public int getDistance(Point other) {
			return Math.abs(this.y - other.y) + Math.abs(this.x - other.x);
		}
	}

	private static int N, K, result;
	private static Point[] points;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("hunter_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			N = Integer.parseInt(in.readLine());
			
			// 몬스터의 위치들
			Point[] monsters = new Point[5];
			// 고객의 위치들
			Point[] clients = new Point[5];
			
			// 몬스터, 고객의 수 K
			K = 0;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 0; j < N; j++) {
					int value = Integer.parseInt(st.nextToken());
					if(value > 0) {
						monsters[value] = new Point(i, j);
						K++;
					}
					else if(value < 0)
						clients[-value] = new Point(i, j);
				}
			}
			
			// 몬스터, 고객의 위치를 하나의 배열에 저장
			points = new Point[K*2 + 1];
			// 해당 위치에 현재 방문이 가능한지 여부를 저장한다.
			// 모든 몬스터의 위치는 처음에 true로 해놓고 고객의 위치는 해당 몬스터에게 접근하면 true로 설정해준다.
			boolean[] canVisit = new boolean[K*2 + 1];
			
			// 초기 설정, 1~K = 몬스터, K+1~2K = 고객
			// 몬스터의 위치만 방문할 수 있음을 표시함
			for(int i = 1; i <= K; i++) {
				canVisit[i] = true;
				points[i] = monsters[i];
				points[K+i] = clients[i];
			}
			
			result = Integer.MAX_VALUE;
			
			find(new Point(0, 0), 0, 0, canVisit);
			
			sb.append(result).append("\n");
		}

		out.write(sb.toString());
		out.flush();
	}
	
	// 순열을 이용한 탐색, now = 탐색을 시작하는 현재 위치, length = 지금까지의 거리
	private static void find(Point now, int step, int length, boolean[] canVisit) {
		System.out.println(length);
		if(step == K*2) {
			result = Math.min(result, length);
			return;
		}
		
		for(int i = 1; i <= K * 2; i++) {
			// 현재위치를 방문할 수 있다면
			if(canVisit[i]) {
				
				// 이미 방문한 것으로 표시한다.
				canVisit[i] = false;
				// 몬스터를 방문했다면 해당 몬스터에 맞는 고객의 위치를 방문할 수 있다고 표시
				if(i <= K)
					canVisit[K + i] = true;
				
				// 현재 length에 다음 위치까지의 거리를 더해서 다음 단계로, 다음 단계의 시작 위치는 현재 방문한 위치
				find(points[i], step+1, length + now.getDistance(points[i]), canVisit);
				
				// 다시 방문 표시 초기화
				canVisit[i] = true;
				if(i <= K)
					canVisit[K + i] = false;
			}
		}
	}
}
