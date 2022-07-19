package com.ssafy.live1.array;


public class ArrayTest_20 {
	public static void main(String[] args) {

		char[][] grid = { 
		        { '2', '3', '1', '4' }, 
		        { '1', 'X', '3', '2' }, 
		        { '3', '4', 'X', 'X' },
				{ 'X', '4', '1', '5' } };

		int[][] deltas = {
				{-1, 0},
				{1, 0},
				{0, -1},
				{0, 1}};
		
		int sum = 0;
		
		// TODO: X로 표시된 항목의 상좌우 숫자의 합을 구하시오.
		//  단 합을 구할 때 이미 더한 영역은 다시 더하지 않는다.
		
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				
				// X를 만났을 때
				if(grid[i][j] == 'X') {
					// 4방향 체크
					 
				}
			}
		}
		// END:
		System.out.println(sum);
	}
}
