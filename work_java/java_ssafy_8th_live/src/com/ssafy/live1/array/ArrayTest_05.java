package com.ssafy.live1.array;

import java.util.Arrays;

public class ArrayTest_05 {
    public static void main(String[] args) {
        String org = "1234567890";

        // TODO: String "1234567890" 의 자리 별 수를 1차원 배열에 저장하고 배열을 순회해서 그 합을 출력하시오.
        // END:
        
        char[] charsToInts = org.toCharArray();
        
        int sum = 0;
        
        for(int i = 0; i < charsToInts.length; i++) {
        	sum += (charsToInts[i] - '0');
        }
        
        System.out.println(Arrays.toString(charsToInts));
        System.out.println(sum);
        
        
    }
}
