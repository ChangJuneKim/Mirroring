import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    int R, C, M;
    Shark[][] map;
    
    int total = 0;
    
    // 1상, 2하, 3우, 4좌
    int[] dx = {-1, 0, 1, 0}; //상 좌 하 우 순
    int[] dy = {0, -1, 0, 1};
    
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
    
    public void solution() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 상어 수
        
        map = new Shark[R][C];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            
            
            if (dir == 1) {
                dir = 0;
            } else if (dir == 4) {
                dir = 1;
            }
            
            map[x - 1][y - 1] = new Shark(x - 1, y - 1, speed, dir, size);
        }
        
        gameStart();
        
        System.out.println(total);
    }
    
    private void gameStart() {
        // 낚시왕 오른쪽으로 한칸씩 이동해서 상어잡기
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                // 상어를 만나면
                if (map[j][i] != null) {
                    catchShark(j, i);
                    break;
                }
            }
            // 상어 이동
            moveSharks();
            
        }
    }
    
    private void moveSharks() {
        PriorityQueue<Shark> sharks = new PriorityQueue<>();
        // pq에 남아 있는 상어를 다 넣고
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != null) {
                    sharks.offer(new Shark(i, j, map[i][j].speed, map[i][j].direction, map[i][j].size));
                }
            }
        }
        
        map = new Shark[R][C];
        
        while (!sharks.isEmpty()) {
            Shark current = sharks.poll();
            int speed = current.speed;
            
            // 상,하 일 경우
            if (current.direction == 0 || current.direction == 2) {
                speed %= (R - 1) * 2;
                // 좌,우 일경우
            } else if (current.direction == 1 || current.direction == 3) {
                speed %= (C - 1) * 2;
            }
            
            for (int i = 0; i < speed; i++) {
                int nx = current.x + dx[current.direction];
                int ny = current.y + dy[current.direction];
                
                // 이동할 위치가 범위를 벗어나 벽에 박으면
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    current.x -= dx[current.direction];
                    current.y -= dy[current.direction];
                    
                    current.direction = (current.direction + 2) % 4; // 역방향
                    continue;
                }
                
                current.x = nx;
                current.y = ny;
            }
            map[current.x][current.y] = new Shark(current.x, current.y, current.speed, current.direction, current.size);
        }
    }
    
    private void catchShark(int x, int y) {
        total += map[x][y].size;
        map[x][y] = null;
    }
    
    class Shark implements Comparable<Shark> {
        int x, y;
        int speed, direction, size;
        
        public Shark(int x, int y, int speed, int direction, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }
        
        @Override
        public String toString() {
            return "Shark{" +
                "x=" + x +
                ", y=" + y +
                ", speed=" + speed +
                ", direction=" + direction +
                ", size=" + size +
                '}';
        }
        
        @Override
        public int compareTo(Shark o) {
            return this.size - o.size;
        }
    }
    
}
