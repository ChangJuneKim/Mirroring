import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

// 백준 1463(S3) 1로 만들기
public class Main {
	
	public void solution() throws IOException {
		System.setIn(Files.newInputStream(Paths.get("input.txt")));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int number = Integer.parseInt(br.readLine());
	    int[] dp = new int[number + 1];
	    
	    dp[0] = 0; // 변환 x
	    dp[1] = 0; // 변환 x
	    
	    for (int i = 2; i <= number; i++) {
			dp[i] = dp[i - 1] + 1;
			
			if(i % 2 == 0) { // 2로 나눠지는 경우
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			
			if(i % 3 == 0) { // 3으로 나눠지는 경우
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}
	    
	    System.out.println(dp[number]);
	    
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}
