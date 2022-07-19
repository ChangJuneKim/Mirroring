package com.ssafy.startcamp.day02.operators;

public class BP_15 {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        System.out.println((a > b) & (b > 0)); // f & t 
        
        System.out.println((a += 10) > 15 | (b -= 10) > 15);  // t | f
        System.out.println("a = " + a + ", b = " + b); // a 20    b 10 

        a = 10;
        b = 20;
        System.out.println((a += 10) > 15 || (b -= 10) > 15); // t || <-- 어차피 true라 뒤에 평가 안됨
        System.out.println("a = " + a + ", b = " + b);// a 20     b 20
    }
}