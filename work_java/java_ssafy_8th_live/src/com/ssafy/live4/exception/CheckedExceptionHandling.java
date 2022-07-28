package com.ssafy.live4.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckedExceptionHandling {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // TODO: 다음에서 발생하는 예외를 처리해보자.
        Class.forName("abc.Def"); // ClassNotFoundException
        new FileInputStream("Hello.java"); // FileNotFoundException
        DriverManager.getConnection("Hello"); // SQLException
        // END:
        System.out.println("프로그램 정상 종료");

    }
}
