package com.ssafy.live1.array;

// 2022. 07. 19 오프라인 수업 때 진행
public class ArrayTest_20 {
	public static void main(String[] args) {

		char[][] grid = { 
		        { '2', '3', '1', '4' }, 
		        { '1', 'X', '3', '2' }, 
		        { '3', '4', 'X', 'X' },
				{ 'X', '4', '1', '5' } };

		int sum = 0;
		
		// TODO: X로 표시된 항목의 상하좌우 숫자의 합을 구하시오.
		//  단 합을 구할 때 이미 더한 영역은 다시 더하지 않는다.
		int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				if (grid[r][c] == 'X') {
					for (int d = 0; d < 4; d++) {
						int nr = r + deltas[d][0];
						int nc = c + deltas[d][1];
						if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && grid[nr][nc] != 'X') {
							sum += grid[nr][nc] - '0';
							grid[nr][nc] = '0';
						}
					}
				}
			}
		}
		// END:
		System.out.println(sum);
	}
}
