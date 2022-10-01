import java.util.Arrays;
import java.util.Scanner;

public class DP1_Fibo_MemoTest {

	private static long[] calls1, calls2, memo;
	private static long callCnt1, callCnt2;
	private static int N;
	
	// 메모하지 않는 버전 (재귀함수 이용)
	public static long fibo1(int n) {
		callCnt1++;
		calls1[n]++;
		
		if (n <= 1) {
			return n;  // 1항이면 1, 0항이면 0
		}
		
		return fibo1(n - 1) + fibo1(n - 2); // 전체적으로 중복되는 호출이 많아져서 시간이 오래 걸리는 문제점.
	}
	
	// 메모버전 
	public static long fibo2(int n) {
		callCnt2++;
		calls2[n]++;
		
		if (memo[n] == -1) {  // 메모안되어 있음.
			memo[n] = fibo2(n - 1) + fibo2(n - 2);  // 계산 후 메모
		}
		
		return memo[n];  // 메모된 값 리턴
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  // 45 정도로 테스트
		
		calls1 = new long[N + 1];  // 각 항을 계산하기 위한 수행횟수
		calls2 = new long[N + 1];
		
		callCnt1 = callCnt2 = 0;  // 총 수행횟수
		
		memo = new long[N + 1];  // 0으로 자동 초기화
		Arrays.fill(memo, -1);  // -1로 초기화
		
		// 처음부터 계산이 가능한 값 초기화
		memo[0] = 0;
		memo[1] = 1;
		
		System.out.println("======================================");
		
		System.out.println("ans : " + fibo2(N));
		System.out.println(callCnt2);
		for (int i = 0; i <= N; i++) {
			System.out.println("fibo2(" + i + ") : " + calls2[i]);
		}
		
		System.out.println("======================================");
		
		System.out.println("ans : " + fibo1(N));
		System.out.println(callCnt1);
		for (int i = 0; i <= N; i++) {
			System.out.println("fibo1(" + i + ") : " + calls1[i]);
		}
	}

}
