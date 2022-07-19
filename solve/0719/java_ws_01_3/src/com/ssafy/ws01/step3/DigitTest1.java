package com.ssafy.ws01.step3;

// 내 풀이

//public class DigitTest1 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int cnt = 1;
//		for(int i = 1; i<=5; i++) {
//			
//			//공백
//			for (int j = 0; j < i - 1; j++) {
//				System.out.printf("%3s", " ");
//			}
//			
//			//숫자
//			for(int j=5; j>=i;j--) {	
//				System.out.printf("%3d",cnt);  
//				cnt++;
//			}
//			System.out.println();
//		}
//	}
//
//}

/*--------------------------------------------------------------*/

// 교수님 풀이
public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		
		for (int i = 0; i < 5; ++i) {
			
			for (int j = 0; j < 5; ++j) {
				
				if (j < i) {
					System.out.printf("%3s", " "); // 3칸 너비로 공백 출력  _ _ 출력
				} else {
					System.out.printf("%3d", ++count);
				}
			}
			
			System.out.println();
		}
	}

}