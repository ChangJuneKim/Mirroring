package com.ssafy.ws01.step3;

// 내 풀이

//public class DigitTest2 {
//	public static void main(String[] args) {
//		int cnt = 1;
//		
//		for(int i = 0; i < 5; i++) {
//			// 공백
//			for(int j = 0; j < 5 / 2 - Math.abs(i -(5 / 2)); j++) {
//				System.out.printf("%3s", " ");
//			}
//			
//			// 숫자
//			for(int j = 0; j < 5 - (5/2 - Math.abs(5/2 - i)) * 2; j++) {
//				System.out.printf("%3d", cnt);
//				cnt++;
//			}
//			
//			System.out.println();
//		}
//	}
//}


/*------------------------------------------------------------------------*/

//교수님 풀이

public class DigitTest2 {
	public static void main(String[] args) {
		int target = 5 / 2; //모양이 반전되는 목표개수 변수
		int blank = 0; // 공백 출력 카운트 변수
		boolean isIncrease = true; // 공백 증가 여부 변수
		int no = 1; // 출력 숫자 변수
		
		// 마지막 숫자 출력까지 반복
		while (no <= 17) { // 17은 마지막 숫자
			
			// 숫자 앞쪽 공백 출력 부분
			for(int j = 0; j < blank; j++) {		
				//3칸의 너비로 공백 출력
				System.out.printf("%3s", " ");
			}
			
			//숫자 출력 부분
			for(int j = 0; j < 5 - 2 * blank; j++) {
				//3칸의 너비로 숫자 출력
				System.out.printf("%3d", no++);
			}
			System.out.println();
			
			// 공백 증가 모드이면 카운트 증가 아니면 카운트 감소  처리
			if(isIncrease) {
				++blank;
			}else {
				--blank;
			}
			
			if (blank == target) { // 공백 카운트가 반전이 되는 목표개수와 일치하면 공백 감소여부로 변경
				isIncrease = false;
			}
		}
		
		
	}
}