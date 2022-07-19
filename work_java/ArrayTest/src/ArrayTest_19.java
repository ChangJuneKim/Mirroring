
public class ArrayTest_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {
				{'2', '3', '1', '4'},
				{'1', 'X', '3', '2'},
				{'3', '4', 'X', 'X'},
				{'X', '4', '1', '5'}};
		
		int sum = 0;
		
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				if(grid[r][c] == 'X') {
				if(c - 1 >= 0 && grid[r][c - 1] != 'X')
					sum += grid[r][c - 1] - '0';
				if(c + 1 < 4 && grid[r][c + 1] != 'X')
					sum += grid[r][c + 1] - '0';
				}
			}
				
		}
		System.out.println(sum);
	}

}
