package com.ssafy.offline2.array;

public class ZigZag {
	
	public static void main(String[] args) {
		
		int[][] arr = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }};
		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//		}
//		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = arr[i].length - 1; j >= 0; j--) {
//				System.out.print(arr[i][j] + " ");
//			}
//		}
		
		// 지그재그
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {  // 순방향
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
			}
			else {  // 역방향
				for (int j = arr[i].length - 1; j >= 0; j--) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}
		
	}
}
