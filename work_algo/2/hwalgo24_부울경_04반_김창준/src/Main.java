import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    
    int[][] map;
    boolean end;
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
    
    public void solution() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력
        map = new int[9][9];
        for (int i = 0; i < 9; ++i) {
            String input = br.readLine();
            for (int j = 0; j < 9; ++j) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        
        // dfs
        dfs(0);
        
        
        // 출력
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    
    private void dfs(int depth) {
        if (depth == 81) {
            end = true;
            return;
        }
        
        int x = depth / 9;
        int y = depth % 9;
        // (0,0) ~ (0,8)
        // (1,0) ~ (1,8)
        //      ...
        // (8,0) ~ (8,8)
        
        // 숫자가 박혀있으면 그냥 넘어감
        if (map[x][y] != 0) {
            dfs(depth + 1);
        }
        // 비어있으면
        else {
            // 1~9 까지
            for (int i = 1; i <= 9; ++i) {
                // 스도쿠 검증 하고
                if (!isValid(x, y, i)) {
                    continue;
                }
                // 넣음
                map[x][y] = i;
                dfs(depth + 1);
                
                if (end) {
                    return;
                }
                
                // 다시 뺌
                map[x][y] = 0;
            }
        }
    }
    
    public boolean isValid(int x, int y, int n) {
        for (int i = 0; i < 9; ++i) {
            if (map[x][i] == n || map[i][y] == n) return false;
        }
        
        int xx = x / 3 * 3;
        int yy = y / 3 * 3;
        for (int i = xx; i < xx + 3; ++i) {
            for (int j = yy; j < yy + 3; ++j) {
                if (map[i][j] == n) return false;
            }
        }
        return true;
    }
    
}
