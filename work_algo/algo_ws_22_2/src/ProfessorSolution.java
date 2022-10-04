import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

// 백준 1463(S3) 1로 만들기 교수님 풀이
public class ProfessorSolution {
	
	public void solution() throws IOException {
		System.setIn(Files.newInputStream(Paths.get("input.txt")));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	   
	    int number = Integer.parseInt(br.readLine());
	    
	    // 1. 동적테이블 생성
	    int[] dp = new int[number + 1];
	    
	    
	    // 2. 베이스 값 채우기
	    dp[0] = 0; // 변환 x
	    dp[1] = 0; // 변환 x
	    dp[2] = 1; // 2를 1로는 1번만 연산
	    dp[3] = 1; // 3을 1로 1번만 연산
	    dp[4] = 2; // 4를 1으로는 2번 연산
	    
	    // 3. 점화식을 이용하여 상향식으로 동적테이블 채우기
	    
	    for (int i = 5; i <= number; i++) {
	    	int min = Integer.MAX_VALUE;
	    	min = Math.min(min, dp[i - 1] + 1); // 1을 빼면 연산 횟수에 1증가
			
			if(i % 2 == 0) { // 2로 나눠지는 경우
				min = Math.min(min, dp[i / 2] + 1); // 2로 나누어지면 2로 나눈 수의 연산 횟수에 1 증가 
			}
			
			if(i % 3 == 0) { // 3으로 나눠지는 경우
				min = Math.min(min, dp[i / 3] + 1); // 3으로 나누어지면 3으로 나눈 수의 연산 횟수에 1 증가
			}
			
			dp[i] = min;
		}
	    
	    System.out.println(dp[number]);
	    
	}
	
	public static void main(String[] args) throws IOException {
		new ProfessorSolution().solution();
	}
}
