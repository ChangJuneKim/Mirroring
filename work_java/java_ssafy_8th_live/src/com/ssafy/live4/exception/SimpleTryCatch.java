// ##DELETE_FILE:
package com.ssafy.live4.exception;


public class SimpleTryCatch {
    public static void main(String[] args) {
        int[] intArray = {10};
        try {
            System.out.println(intArray[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("예외가 발생했지만 처리함:%s%n", e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램 종료합니다.");
    }
}
