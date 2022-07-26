package com.ssafy.live1.array;

// 2022. 07. 19 오프라인 수업 때 진행
public class ArrayTest_19 {

    public static void main(String[] args) {


        char[][] grid = {{'2', '3', '1', '4'}, 
                         {'1', 'X', '3', '2'}, 
                         {'3', '4', 'X', 'X'}, 
                         {'X', '4', '1', '5'}};

        int sum = 0;
        // TODO: X로 표시된 항목의 좌우 숫자의 합을 구하시오.
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (grid[r][c] == 'X') {
                    // 왼쪽 살펴보기
                    if (c - 1 >= 0 && grid[r][c - 1] != 'X') {
                        sum += grid[r][c - 1] - '0';
                    }
                    // 오른쪽 살펴보기
                    if (c + 1 < 4 && grid[r][c + 1] != 'X') {
                        sum += grid[r][c + 1] - '0';
                    }
                }
            }
        }
        // END:
        System.out.println(sum);
    }
}
