import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 백준 1600 (G3) 말이되고픈 원숭이
public class Main {

    int K;
    int H, W;
    int[][] board;
    boolean[][][] visited;

    int min = Integer.MAX_VALUE;

    int[] mx = {-1, 0, 1, 0};
    int[] my = {0, 1, 0, -1};

    int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(0, 0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);


    }

    private void bfs(int x, int y) {
        ArrayDeque<Monkey> queue = new ArrayDeque<Monkey>();
        queue.offer(new Monkey(x, y, 0, 0));
        visited[x][y][0] = true; // 원숭이 일 때 visited

        while (!queue.isEmpty()) {
            Monkey monkey = queue.poll();
            int curX = monkey.x;
            int curY = monkey.y;
            int horseJumpCount = monkey.k;
            int step = monkey.step;

            if (curX == H - 1 && curY == W - 1) {
                min = monkey.step;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curX + mx[i];
                int ny = curY + my[i];

                if (isIn(nx, ny) && board[nx][ny] == 0 && !visited[nx][ny][horseJumpCount]) {
                    queue.offer(new Monkey(nx, ny, horseJumpCount, step + 1));
                    visited[nx][ny][horseJumpCount] = true;
                }
            }

            if (horseJumpCount < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = curX + hx[i];
                    int ny = curY + hy[i];

                    if (isIn(nx, ny) && board[nx][ny] == 0 && !visited[nx][ny][horseJumpCount + 1]) {
                        queue.offer(new Monkey(nx, ny, horseJumpCount + 1, step + 1));
                        visited[nx][ny][horseJumpCount + 1] = true;
                    }
                }
            }
        }

    }


    private boolean isIn(int x, int y) {
        return 0 <= x && x < H && 0 <= y && y < W;
    }

    private class Monkey {
        int x;
        int y;
        int k; // 말처럼 움직일 수 있는 횟수

        int step;

        public Monkey(int x, int y, int k, int step) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.step = step;
        }


        @Override
        public String toString() {
            return "Monkey{" +
                    "x=" + x +
                    ", y=" + y +
                    ", k=" + k +
                    '}';
        }
    }
}
