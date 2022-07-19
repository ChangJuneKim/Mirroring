package com.ssafy.live4.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HierachyException {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        String src = "./.project";
        // TODO: 상속 관계를 고려하여 다음에서 예외를 처리해보자.
        FileInputStream input = new FileInputStream(src);
        int readData = -1;
        while ((readData = input.read()) != -1) {
                 System.out.print((char) readData);
        }
        // END:

        System.out.println("파일 읽음 완료!");
    }

}
