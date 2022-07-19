package com.ssafy.live1.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest_03 {
    public static void main(String[] args) {   	
        int N = 6;
        Random rand = new Random();
        // TODO: 1~6까지의 random 정수 5개를 저장할 배열을 만들고 값을 저장하시오.
        // END: 
        int[] numbers = new int[5];
        
        for (int i = 0; i < numbers.length; i++) {
        	numbers[i] = rand.nextInt(6) + 1;
        }
        
        System.out.println(Arrays.toString(numbers));
        // TODO: 위 배열에 저장된 요소 중 짝수만 더해서 합을 출력하시오.
        // END:
        
        int sum = 0;
        
        for (int i = 0; i < numbers.length; i++) {
        	if(numbers[i] % 2 == 0) {
        		sum += numbers[i];
        	}
        }
        
        System.out.println(sum);
    }
}
