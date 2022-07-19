package com.ssafy.live4.exception;

public class ThrowsTest {
    // TODO: 1. methodCall2()에서 uncheckedExceptionMethod()를 호출할 때 발생하는 예외를 throws로 처리하세요.
    // TODO: 2. methodCall2()에서 checkedExceptionMethod()를 호출할 때 발생하는 예외를 throws로 처리하세요.
     public static void main(String[] args){
        methodCall1();
        System.out.println("done");
    }

     private static void methodCall1(){
        methodCall2();
    }

     private static void methodCall2(){
        uncheckedExceptionMethod();
        //checkedExceptionMethod();
    }

     private static void checkedExceptionMethod() {
        //Class.forName("Hello");
    }

    @SuppressWarnings("unused")
    private static void uncheckedExceptionMethod() {
        int i = 1 / 0;
    }

}
