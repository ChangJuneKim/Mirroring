// ##DELETE_FILE:
package com.ssafy.live3.inter.module;

public class LaserPrinter implements Printer{

    @Override
    public void print(String fileName) {
        System.out.printf("레이저 프린터로 프린트한다.");
    }

}
