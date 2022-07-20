package com.ssafy.offline1.array;

public class Zigzag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// 정방향
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		
		
		System.out.println("-------------------------------------------");
		// 역방향
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[i].length - 1; j > -1; j--) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		System.out.println("-------------------------------------------");
		// 지그재그
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
				
			} else {
				for (int j = arr[i].length - 1; j > -1; j--) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

		}
	}

}
