import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
    int T;
    int ballCount, M, N;
    int[][] map;
    int[][] copy;
    int[] balls;
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    int count;
    int min;
    
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
    
    public void solution() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            
            ballCount = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            
            map = new int[N][M];
            copy = new int[N][M];
            
            balls = new int[ballCount];
            
            min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    copy[i][j] = value;
                    map[i][j] = value;
                    
                }
            }
            
            chooseDropIndex(0);
            sb.append("#").append(testCase).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }
    
    private void chooseDropIndex(int depth) {
        if (depth == ballCount) { // ballCount개 떨어트릴 위치 뽑았음
            dropBall();
            min = Math.min(min, countRemainBricks());
            return;
        }
        
        for (int i = 0; i < M; i++) {
            balls[depth] = i;
            chooseDropIndex(depth + 1);
        }
    }
    
    
    private void dropBall() {
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = copy[i][j];
            }
        }
        
        int h = N - 1;
        for (int i = 0; i < ballCount; i++) {
            int turn = balls[i]; // 구슬 떨어뜨릴 열을 하나씩 받아온다.
            for (int j = 0; j < N; j++) { // 열은 고정 행만 변한다.
                if (map[j][turn] > 0) { // 타격할 벽돌의 행이 정해짐.
                    h = j;
                    break;
                }
            }
            boom(h, turn); // 구슬 떨어뜨리기
            downBricks(); // 벽돌들 아래로 떨어뜨리기
        }
    }
    
    private void boom(int x, int y) {
        int power = map[x][y];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, power});
        map[x][y] = 0; // 방문 처리
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            int curPower = current[2];
            
            for (int p = 1; p < curPower; p++) { // power만큼 깊게 4방향
                for (int i = 0; i < 4; i++) {
                    int nx = curX + dx[i] * p;
                    int ny = curY + dy[i] * p;
                    
                    if (isIn(nx, ny) && map[nx][ny] != 0) {
                        queue.offer(new int[]{nx, ny, map[nx][ny]});
                        map[nx][ny] = 0;
                        continue;
                    }
                }
            }
        }
    }
    
    private void downBricks() {
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        for (int j = 0; j < M; j++) { // 열
            for (int i = 0; i < N; i++) { // 행 채우고
                if (map[i][j] > 0) {
                    deque.add(map[i][j]);
                }
            }
            for (int i = N - 1; i >= 0; i--) { // 비우고
                if (deque.isEmpty()) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = deque.pollLast();
                }
            }
        }
    }
    
    private int countRemainBricks() {
        int bricks = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    bricks++;
                }
            }
        }
        return bricks;
    }
    
    private boolean isIn(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
    
    
}
