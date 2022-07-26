package com.ssafy.live4.exception;

public class ThrowsTest {
    // @@TODOINLINE: 1. methodCall2()에서 uncheckedExceptionMethod()를 호출할 때 발생하는 예외를 throws로 처리하세요.
    // @@TODOINLINE: 2. methodCall2()에서 checkedExceptionMethod()를 호출할 때 발생하는 예외를 throws로 처리하세요.
    // @@REPLACE: public static void main(String[] args){
    public static void main(String[] args) {
    	try {
    		methodCall1();
    	}
    	catch (ArithmeticException e) {
    		System.out.println("연산 오류 : " + e.getMessage());
    	}
    	/*catch (ClassNotFoundException e) {
    		System.out.println("클래스를 찾을 수 없습니다 : " + e.getMessage());
    	}*/
        System.out.println("done");
    }

    // @@REPLACE: private static void methodCall1(){
    private static void methodCall1() {
        methodCall2();
    }

    // @@REPLACE: private static void methodCall2(){
    private static void methodCall2() {
        uncheckedExceptionMethod();
        //checkedExceptionMethod();
    }

    // @@REPLACE: private static void checkedExceptionMethod() {
    @SuppressWarnings("unused")
    private static void checkedExceptionMethod() throws ClassNotFoundException {
        Class.forName("Hello");
    }

    @SuppressWarnings("unused")
    private static void uncheckedExceptionMethod() {
        int i = 1 / 0;
    }

}
