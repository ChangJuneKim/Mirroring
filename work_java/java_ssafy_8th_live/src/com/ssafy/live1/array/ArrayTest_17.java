package com.ssafy.live1.array;

// 2022. 07. 19 오프라인 수업 때 진행
public class ArrayTest_17 {
    public static void main(String[] args) {

        int[][] grid = {
        		{2, 3, 1, 4, 7},
        		{8, 13, 3, 33, 1},
                {7, 4, 5, 80, 12},
                {17, 9, 11, 5, 4},
                {4, 5, 91, 27, 7}};

        int count = 0;
        int sum = 0;
        // TODO: 각 항의 숫자 중 3의 배수의 개수와 그들의 합을 출력하시오.
        for (int[] row : grid) {
        	for (int num : row) {
        		if (num % 3 == 0) {
        			count++;
        			sum += num;
        		}
        	}
        }
        
        // END:
        System.out.printf("개수: %d, 총합: %d%n", count, sum);
    }
}
