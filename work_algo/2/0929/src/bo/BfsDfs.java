package bo;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BfsDfs {

	int[] dx = { -1, 0, 0, 1 };
	int[] dy = { 0, -1, 1, 0 };

	String[] type = { null, "0312", "03", "12", "02", "32", "31", "01" };
	int N, M; // 맵 크기
	int R, C; // 맨홀 위치
	int L; // 소요된 시간

	int[][] map;
	boolean[][] visited;

	public void solution() throws IOException {
		System.setIn(Files.newInputStream(Paths.get("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}

			sb.append("#").append(testCase).append(" ").append(bfs(R, C, 1)).append("\n");
		}
		System.out.println(sb);

	}

	private Object bfs(int x, int y, int time) {
		int answer = 0;

		ArrayDeque<int[]> queue = new ArrayDeque<>();
		visited[x][y] = true;
		queue.offer(new int[] { x, y, time });
		answer++;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];
			int curTime = current[2];

			if (curTime == L)
				break;

			String cur = type[map[curX][curY]]; // 파이프가 무슨타입인지?

			for (int i = 0; i < cur.length(); i++) {
				int d = cur.charAt(i) - '0'; // 파이프 타입에 따라 방향 정하기 4방일수도 2방일수도
				int nx = curX + dx[d];
				int ny = curY + dy[d];

				if (isIn(nx, ny) && map[nx][ny] != 0 && !visited[nx][ny]
						&& type[map[nx][ny]].contains(""+ (3 - d))) { // 다음에 갈 곳에 
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny, time + 1});
					answer++;
				}
			}
		}
		return answer;
	}

	private boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}

	public static void main(String[] args) throws IOException {
		new BfsDfs().solution();
	}
}
