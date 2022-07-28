package com.ssafy.live1.array;

public class ArrayTest_19 {

    public static void main(String[] args) {


        char[][] grid = {{'2', '3', '1', '4'}, 
                         {'1', 'X', '3', '2'}, 
                         {'3', '4', 'X', 'X'}, 
                         {'X', '4', '1', '5'}};

        int sum = 0;
        // TODO: X로 표시된 항목의 좌우 숫자의 합을 구하시오.
        for(char[] row : grid) {
        	for(int i = 0; i < row.length; i++) {
        		if(row[i] == 'X') {
        			if(i - 1 >= 0 && row[i - 1] != 'X') {
        				sum += (row[i - 1] - '0');
        			}
        			if(i + 1 < row.length && row[i + 1] != 'X') {
        				sum += (row[i + 1] - '0');
        			}
        		
        		}
        	}
        }
        // END:
        System.out.println(sum);
    }
}
