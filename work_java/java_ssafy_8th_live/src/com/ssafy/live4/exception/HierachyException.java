package com.ssafy.live4.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HierachyException {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        String src = "./.project";
        // @@TODOBLOCK: 상속 관계를 고려하여 다음에서 예외를 처리해보자.
        // @@KEEPR:FileInputStream input = new FileInputStream(src);
        // @@KEEPR:int readData = -1;

        // @@KEEPR:while ((readData = input.read()) != -1) {
        // @@KEEPR:         System.out.print((char) readData);
        // @@KEEPR:}
        try {
            FileInputStream input = new FileInputStream(src);
            int readData = -1;

            while ((readData = input.read()) != -1) {
                System.out.print((char) readData);
            }

        } catch (FileNotFoundException e) {
            System.out.printf("읽으려는 파일이 없습니다.: %s%n", e.getMessage());
        } catch (IOException e) {
            System.out.printf("파일 읽기에 실패했습니다.: %s%n", e.getMessage());
        }
        // @@END:

        System.out.println("파일 읽음 완료!");
    }

}
