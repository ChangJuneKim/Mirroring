package com.ssafy.live4.exception.install;


public class InstallApp {
    void copy() {
        System.out.println("파일 복사");
    }

    void install() throws Exception {
        System.out.println("설치");
        if (Math.random() > 0.5) {
            throw new Exception();
        }
    }

    void delete() {
        System.out.println("파일 삭제");
    }
}
