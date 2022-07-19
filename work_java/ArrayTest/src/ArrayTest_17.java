
public class ArrayTest_17 {
	public static void main(String[] args) {
		int[][] grid = {
				{2, 3, 1, 4, 7},
				{2, 3, 1, 4, 7},
				{2, 3, 1, 4, 7},
				{2, 3, 1, 4, 7},
				{2, 3, 1, 4, 7},
		};
		
		int count = 0;
		int sum = 0;
		
		for (int [] row : grid) {
			for (int num : row) {
				if(num % 3 == 0) {
					count++;
					sum += num;
				}
			}
		}
		System.out.printf("개수: %d, 총합 : %d%n", count, sum);
	}
	
}
