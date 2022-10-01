import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Solution {
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};
  int n;
  int[][] map;

  public static void main(String[] args) throws IOException {
    new Solution().solution();
  }

  public void solution() throws IOException {
    System.setIn(Files.newInputStream(Paths.get("input.txt")));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int testCase = 1; testCase <= T; testCase++) {
      n = Integer.parseInt(br.readLine());

      map = new int[n][n];

      for (int i = 0; i < n; i++) {
        String line = br.readLine();
        for (int j = 0; j < n; j++) {
          map[i][j] = line.charAt(j) - '0';
        }
      }

      dijkstra(testCase, 0, 0);
    }
  }

  private void dijkstra(int testCase, int x, int y) {
    boolean[][] visited;
    int[][] distance;

    visited = new boolean[n][n];
    distance = new int[n][n];

    // distance 초기화
    for (int i = 0; i < n; i++) {
      Arrays.fill(distance[i], Integer.MAX_VALUE);
    }

    distance[x][y] = 0;
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (isIn(nx, ny) && !visited[nx][ny]) {
        distance[nx][ny] = map[nx][ny];
      }
    }

    for (int i = 0; i < n * n - 2; i++) {
      int min = Integer.MAX_VALUE;
      int minX = -1;
      int minY = -1;

      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (!visited[j][k] && distance[j][k] != Integer.MAX_VALUE) {
            if (distance[j][k] < min) {
              min = distance[j][k];
              minX = j;
              minY = k;
            }
          }
        }
      }

      visited[minX][minY] = true;

      for (int j = 0; j < 4; j++) {
        int nx = minX + dx[j];
        int ny = minY + dy[j];

        if (isIn(nx, ny) && !visited[nx][ny]) {
          if (distance[nx][ny] > distance[minX][minY] + map[nx][ny]) {
            distance[nx][ny] = distance[minX][minY] + map[nx][ny];
          }
        }
      }
    }

    System.out.println("#" + testCase + " " + distance[n - 1][n - 1]);
  }

  private boolean isIn(int nx, int ny) {
    return 0 <= nx && nx < n && 0 <= ny && ny < n;
  }

}

