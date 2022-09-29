import java.util.Arrays;
import java.util.Scanner;

public class DP2_ChangeMinCoinTest {

	
	// 1, 4, 6원 고정
	public void solution() {
		Scanner scanner = new Scanner(System.in);
		int money = scanner.nextInt(); // 목표 금액 
		
		int[] D = new int[money + 1]; // D[i] : i 금액을 만드는 최소 동전 수
		
		int INF = Integer.MAX_VALUE;
		D[0] = 0;
		
		System.out.println(D[money]);
		
		for (int i = 1; i <= money; i++) {
			int min = INF;
			
			min = Math.min(min, D[i - 1] + 1); // 1원
			
			if(i >= 4) {
				min = Math.min(min, D[i - 4] + 1); // 4원
			}
			
			if(i >= 6) {
				min = Math.min(min, D[i - 6] + 1); // 6원
			}
			D[i] = min;
		}
		
		System.out.println(Arrays.toString(D));
		System.out.println(D[money]);
	}
	
	
	

	public static void main(String[] args) {
		new DP2_ChangeMinCoinTest().solution();
	}
}
