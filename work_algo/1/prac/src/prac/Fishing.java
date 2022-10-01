package prac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 	순열을 통해 다 비교함 
 * 	이 때 낚시터의 마지막 사람이 갈 수 있는 곳이 두 군데 라면 왼쪽을 간 경우, 오른쪽을 간 경우 모두 해본다.
 */
public class Fishing {

	private static int result, N;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("fishing_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			N = Integer.parseInt(in.readLine());
			
			int[][] door = new int[3][2];
			
			for(int i = 0; i < 3; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				door[i][0] = Integer.parseInt(st.nextToken());
				door[i][1] = Integer.parseInt(st.nextToken());
			}
			
//			for (int i = 0; i < door.length; i++) {
//				System.out.println(Arrays.toString(door[i]));
//			}
			
			result = 10000;
			
			find(0, new boolean[3], new boolean[N+1], 0, door);

			sb.append(result).append("\n");
		}

		out.write(sb.toString());
		out.flush();
	}
	
	// 순열을 통해 모든 경우의 수 계산, visited = 해당 출입구 방문 여부, isUsed = 해당 자리 사용 여부
	private static void find(int step, boolean[] visited, boolean[] isUsed, int sum, int[][] door) {
		if (step == 3) {
			result = Math.min(result, sum);
			return;
		}

		// 현재 단계에 가능한 모든 출입구를 넣어본다.
		for (int i = 0; i < 3; i++) {
			if (!visited[i]) {
				visited[i] = true;
				// start = 출입구 위치, count = 출입구에 대기 중인 사람 수
				int start = door[i][0];
				int count = door[i][1];
				
				// 현재 단계에 자리 사용을 표시하고 다음 단계로 가기 위해 새로운 배열
				boolean[] nextUsed = Arrays.copyOf(isUsed, N+1);

				// cnt = 현재 출입구에서 사람들이 자리를 잡는 거리의 합, d = 현재 출입구 부터의 거리
				int cnt = 0;
				int d = 0;
				// 현재 출입구에 위치하는 사람들을 1명빼고 모두 자리 잡게 한다.
				while (count > 1) {
					
					// 다음 왼쪽, 오른쪽
					int nextL = start + d;
					int nextR = start - d;

					// 왼쪽을 갈 수 있다면 그곳에 자리잡았다고 표시
					if (isInBound(nextL) && !nextUsed[nextL]) {
						nextUsed[nextL] = true;
						count--;
						cnt += d + 1;
					}

					// 오른쪽을 갈 수 있다면 그곳에 자리잡았다고 표시
					else if (isInBound(nextR) && !nextUsed[nextR]) {
						nextUsed[nextR] = true;
						count--;
						cnt += d + 1;
						d++;
					}
					
					// 오른쪽 왼쪽 모두 갈 수 없다면 다음 자리 탐색
					else
						d++;
				}
				
				// 마지막 사람의 자리를 찾기 위해
				int left = start - d;
				int right = start + d;
				
				// 가장 가까운 왼쪽 자리
				while(isInBound(left) && nextUsed[left])
					left--;
				
				// 가장 가까운 오른쪽 자리
				while(isInBound(right) && nextUsed[right])
					right++;

				// 오른쪽 자리가 더 가깝거나 오른쪽 자리만 갈 수 있다면 오른쪽 자리로 간다.
				if(isInBound(right) && (!isInBound(left) || right - start < start - left)) {
					nextUsed[right] = true;
					find(step+1, visited, nextUsed, sum + cnt + (right - start + 1), door);
				}
				
				// 왼쪽 자리가 더 가깝거나 왼쪽 자리만 갈 수 있다면 왼쪽 자리로 간다.
				else if(isInBound(left) && (!isInBound(right) || right - start > start - left)) {
					nextUsed[left] = true;
					find(step+1, visited, nextUsed, sum + cnt + (start - left + 1), door);
				}
				
				// 양쪽 자리까지 가는 거리가 같다면 각각의 경우를 다 해본다.
				else if(isInBound(left) && isInBound(right) && right - start == start - left) {
					nextUsed[left] = true;
					find(step+1, visited, nextUsed, sum + cnt + (right - start + 1), door);
					nextUsed[left] = false;
					nextUsed[right] = true;
					find(step+1, visited, nextUsed, sum + cnt + (start - left + 1), door);
				}
				
				visited[i] = false;
			}
		}
	}

	private static boolean isInBound(int p) {
		return p > 0 && p <= N;
	}
}
