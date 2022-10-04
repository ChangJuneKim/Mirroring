import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

// 백준 17070 (G5) 파이프 옮기기 1
public class Main {

    int N;
    int[][] map;
    int answer = 0;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0 가로
        pipe(0, 1, 0);
        System.out.println(answer);
    }

    /**
     * @param x         x좌표
     * @param y         y좌표
     * @param direction 0가로 1세로 2대각
     */
    private void pipe(int x, int y, int direction) {
        if (x == N - 1 && y == N - 1 && map[x][y] == 0) {
            answer++;
            return;
        }

        // 가로
        if (direction == 0) {
            // 가로(오른쪽)
            if (isIn(x, y + 1) && map[x][y + 1] == 0) {
                pipe(x, y + 1, 0);
            }

            if (isIn(x, y + 1) && isIn(x + 1, y) && isIn(x + 1, y + 1)
                    && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
                pipe(x + 1, y + 1, 2);
            }
        } else if (direction == 1) { // 세로
            // 세로
            if (isIn(x + 1, y) && map[x + 1][y] == 0) {
                pipe(x + 1, y, 1);
            }

            // 대각
            if (isIn(x, y + 1) && isIn(x + 1, y) && isIn(x + 1, y + 1) && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
                pipe(x + 1, y + 1, 2);
            }
        } else if (direction == 2) { // 대각
            // 가로(오른쪽)
            if (isIn(x, y + 1) && map[x][y + 1] == 0) {
                pipe(x, y + 1, 0);
            }

            // 세로
            if (isIn(x + 1, y) && map[x + 1][y] == 0) {
                pipe(x + 1, y, 1);
            }

            // 대각
            if (isIn(x, y + 1) && isIn(x + 1, y) && isIn(x + 1, y + 1)
                    && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
                pipe(x + 1, y + 1, 2);
            }
        }
    }

    private boolean isIn(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

}
