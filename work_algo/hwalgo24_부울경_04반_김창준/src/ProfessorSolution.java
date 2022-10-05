import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProfessorSolution {
    
	final int BLANK = 0; // 빈칸
	
    int[][] board; // 게임판
    StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        new ProfessorSolution().solution();
    }
    
    public void solution() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력
        board = new int[9][9];
        for (int i = 0; i < 9; ++i) {
            String input = br.readLine();
            for (int j = 0; j < 9; ++j) {
            	board[i][j] = input.charAt(j) - '0';
            }
        }
        
        // 0은 DFS 호출 횟수 
        dfs(0);
        
        System.out.println(sb);
    }
    
    private void dfs(int depth) {
        if (depth == 81) {
        	// 기저 조건을 만났다면, 빈칸을 모두 채웠으므로 출력
        	// 출력
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                	sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            return;
        }
        
        int x = depth / 9;
        int y = depth % 9;
        
        // 숫자가 박혀있으면 그냥 넘어감
        if (board[x][y] != BLANK) {
            dfs(depth + 1);
        }
        
        // 비어있으면
        else {
            // 1~9 까지
            for (int i = 1; i <= 9; ++i) {
                // 스도쿠 검증 하고
                if (isValid(x, y, i)) {
                	// 넣음
                    board[x][y] = i; // 숫자 작성 후
                    dfs(depth + 1); // 다음으로
                    
                    if(sb.length() != 0) {
                    	return;
                    }
                    
                    board[x][y] = 0; // visited false 처리
                }     
            }
        }
    }
    
    public boolean isValid(int x, int y, int number) {
    	
    	// (x, y) 에서 가로, 세로에 number 사용 유무 확인
        for (int i = 0; i < 9; ++i) {
            if (board[x][i] == number || board[i][y] == number) {
            	return false;            	
            }
        }
        
        // 3 X 3 사각형에 number숫자 사용 유무 확인
        int xx = x / 3 * 3; // 사각형의 좌측 상단 x좌표
        int yy = y / 3 * 3; // 사각형의 좌측 상단 y좌표
        
        // 좌상단 지점에서 3개씩만큼 for문
        for (int i = xx; i < xx + 3; ++i) {
            for (int j = yy; j < yy + 3; ++j) {
                if (board[i][j] == number) {
                	return false;
                }
            }
        }
        
        // 위 조건 모두 통과시 true
        return true;
    }
    
}
