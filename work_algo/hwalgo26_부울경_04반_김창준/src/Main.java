import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 백준 9205 S1 맥주 마시면서 걸어가기
public class Main {
    
    int N, M;
    int[][] board;
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
    
    public void solution() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        bfs();
    }
    
    private void bfs() {
        boolean[][] visited = new boolean[N][M];
        ArrayDeque<int[]> airs = new ArrayDeque<>();
        
        airs.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        ArrayDeque<int[]> willMelt = new ArrayDeque<>();
        
        int hour = 0;
        int prev = 0;
        
        while (true) {
            
            while (!airs.isEmpty()) {
                int[] current = airs.poll();
                int curX = current[0];
                int curY = current[1];
                for (int d = 0; d < 4; d++) {
                    int nx = curX + dx[d];
                    int ny = curY + dy[d];
                    
                    if (isIn(nx, ny) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        // 공기면
                        if (board[nx][ny] == 0) {
                            airs.offer(new int[]{nx, ny});
                        } else {
                            willMelt.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            
            if (willMelt.isEmpty()) {
                break;
            } else {
                prev = willMelt.size();
                hour++;
                
                ArrayDeque<int[]> temp = airs;
                airs = willMelt;
                willMelt = temp;
            }
        }
        System.out.println(hour);
        System.out.println(prev);
    }
    
    private boolean isIn(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
    
}
