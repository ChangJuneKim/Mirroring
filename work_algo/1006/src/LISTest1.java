import java.util.Arrays;
import java.util.Scanner;

public class LISTest1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];  // 수열의 수들
		int[] LIS = new int[N];  // 동적테이블 : 각 원소를 끝으로 하는 LIS 값
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;  // 해당 수열의 LIS 최장길이
		for (int i = 0; i < N; i++) {  // 앞쪽부터 모든 원소기준으로 자신을 끝으로 하는 LIS 계산
			LIS[i] = 1;  // 자신 혼자 LIS 구성할 때의 길이 1로 초기화
			for (int j = 0; j < i; j++) {  // 첫 원소부터 i원소 직전까지 비교
				if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {  // arr[j] < arr[i] : 증가수열의 모습   
					LIS[i] = LIS[j] + 1;  // 최대값 갱신
				}
			}  // 결국, LIS[i]에는 자신을 끝으로 하는 최댓값이 저장되어 있음
			
			// 최장 길이 최댓값 갱신
			max = Math.max(max, LIS[i]);
		}

		System.out.println(Arrays.toString(LIS));
		System.out.println(max);
	}

}