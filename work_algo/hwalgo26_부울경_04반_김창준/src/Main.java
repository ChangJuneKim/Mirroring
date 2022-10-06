import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 9205 S1 맥주 마시면서 걸어가기
public class Main {
    
    int T, N;
    int beer;
    ArrayList<Point> points;
    ArrayList<ArrayList<Integer>> graph;
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
    
    public void solution() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(st.nextToken());
        
        for (int testCase = 0; testCase < T; testCase++) {
            N = Integer.parseInt(br.readLine());
            
            points = new ArrayList<>();
            
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            
            graph = new ArrayList<>();
            
            for (int i = 0; i < N + 2; i++) {
                graph.add(new ArrayList<>());
            }
            
            for (int i = 0; i < N + 2; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    if (getDistance(points.get(i), points.get(j)) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }
            
            int result = bfs();
            if (result == -1) {
                sb.append("sad\n");
            } else {
                sb.append("happy\n");
            }
        }
        System.out.println(sb);
    }
    
    private int bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        
        boolean[] visited = new boolean[N + 2];
        visited[0] = true;
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                if (current == N + 1) {
                    return count;
                }
                
                for (int neighbor : graph.get(current)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
            count++;
        }
        
        return -1;
    }
    
    private int getDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
    
    class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
