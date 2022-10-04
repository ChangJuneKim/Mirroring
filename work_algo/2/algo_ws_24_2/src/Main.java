import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    
    final char VIRUS = '2';
    final char EMPTY = '0';
    final char WALL = '1';
    int M, N;
    char[][] map;
    char[][] copy;
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    int max;
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
    
    public void solution() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        copy = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                char value = st.nextToken().charAt(0);
                map[i][j] = value;
                copy[i][j] = value;
            }
        }
        
        max = Integer.MIN_VALUE;
        dfs(0);
        System.out.println(max);
    }
    
    private void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            max = Math.max(max, getSafeArea());
            return;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == EMPTY) {
                    map[i][j] = WALL;
                    dfs(wallCount + 1);
                    map[i][j] = EMPTY;
                }
            }
        }
        
    }
    
    private int getSafeArea() {
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == EMPTY) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private void bfs() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == VIRUS) {
                    queue.offer(new int[]{i, j});
                    copy[i][j] = VIRUS;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (isIn(nx, ny) && copy[nx][ny] == EMPTY) {
                    queue.offer(new int[]{nx, ny});
                    copy[nx][ny] = VIRUS;
                }
            }
        }
        
    }
    
    private boolean isIn(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
    
    
}
