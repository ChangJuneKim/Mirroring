import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Dust {
	int x, y, quantity;
	int origin;

	public Dust(int x, int y, int quantity) {
		super();
		this.x = x;
		this.y = y;
		this.quantity = quantity;
		this.origin = quantity;
	}

	@Override
	public String toString() {
		return "Dust [x=" + x + ", y=" + y + ", quantity=" + quantity + ", origin=" + origin + "]";
	}

}

class AirCleaner {
	String type;
	int x, y;

	public AirCleaner(String type, int x, int y) {
		super();
		this.type = type;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "AirCleaner [type=" + type + ", x=" + x + ", y=" + y + "]";
	}

}

public class Main {

	int N, M, T;
	int[][] room;

	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };

	Queue<Dust> queue = new ArrayDeque<Dust>();

	AirCleaner top, bottom;

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		T = Integer.valueOf(st.nextToken());

		room = new int[N][M];

		boolean isTop = true;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.valueOf(st.nextToken());
				if (room[i][j] == -1) {
					if (isTop) {
						top = new AirCleaner("top", i, j);
						isTop = false;
					} else {
						bottom = new AirCleaner("bottom", i, j);
					}
				}

				if (room[i][j] != 0 && room[i][j] != -1) {
					queue.offer(new Dust(i, j, room[i][j]));
				}
			}
		}

		for (int t = 0; t < T; t++) {
			bfs();
		}

		int result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (room[i][j] != -1) {
					result += room[i][j];
				}
			}
		}
		System.out.println(result);
	}

	private void bfs() {
		while (!queue.isEmpty()) {
			Dust current = queue.poll();
			int curX = current.x;
			int curY = current.y;
			int spreadQuantity = current.quantity / 5;

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (isIn(nx, ny) && room[nx][ny] != -1) {
					room[curX][curY] -= spreadQuantity;
					current.quantity = room[curX][curY];
					room[nx][ny] += spreadQuantity;
				}
			}
		}
		// 공기 청정기 가동
		rotateTop();
		rotateBottom();

		boolean isTop = true;
		// 다시 큐에 넣음
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (room[i][j] == -1) {
					if (isTop) {
						top = new AirCleaner("top", i, j);
						isTop = false;
					} else {
						bottom = new AirCleaner("bottom", i, j);
					}
				}

				if (room[i][j] != 0 && room[i][j] != -1) {
					queue.offer(new Dust(i, j, room[i][j]));
				}
			}
		}

	}

	void rotateTop() {
		for (int i = 0; i < 1; i++) {
			// 돌려야 할 사각형 기준점 변경
			int startX = 0;
			int startY = 0;
			int endX = top.x;
			int endY = M - 1;

			// 좌변 : 위에서 아래로
			for (int x = endX - 1; x > startX; x--) {
				room[x][startY] = room[x - 1][startY];
			}

			// 윗변 : 오른쪽에서 왼쪽으로
			for (int y = startY; y < endY; y++) {
				room[startX][y] = room[startX][y + 1];
			}

			// 우변 : 밑에서 위로
			for (int x = startX; x < endX; x++) {
				room[x][endY] = room[x + 1][endY];
			}
			
			// 밑변 : 왼쪽에서 오른쪽으로
			for (int y = endY; y > 1; y--) {
				room[endX][y] = room[endX][y - 1];
			}

			// 임시 값 다시 넣기
			room[endX][startY + 1] = 0;
			room[endX][startY] = -1;
		}
	}

	void rotateBottom() {
		for (int i = 0; i < 1; i++) {
			// 돌려야 할 사각형 기준점 변경
			int startX = bottom.x;
			int startY = 0;
			int endX = N - 1;
			int endY = M - 1;

			// 좌변 : 아래에서 위로 이동
			for (int x = startX; x < endX; x++) {
				room[x][startY] = room[x + 1][startY];
			}

			// 아랫변 : 오른쪽에서 왼쪽 이동
			for (int y = startY; y < endY; y++) {
				room[endX][y] = room[endX][y + 1];
			}

			// 우변 : 위에서 아래로 이동
			for (int x = endX; x > startX; x--) {
				room[x][endY] = room[x - 1][endY];
			}

			// 윗변 : 왼쪽에서 오른쪽 이동
			for (int y = endY; y > startY; y--) {
				room[startX][y] = room[startX][y - 1];
			}

			room[startX][startY] = -1;
			room[startX][startY + 1] = 0;
		}
	}

	private boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}