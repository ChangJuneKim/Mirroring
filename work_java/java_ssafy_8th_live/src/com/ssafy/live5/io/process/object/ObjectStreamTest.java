package com.ssafy.live5.io.process.object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
    public static void main(String[] args) {
        write();
        read();
    }
    
    private static File target = new File("c:/Temp/objPerson.dat");
    
    private static void write() {
        Person person = new Person("홍길동2", "pass1234", "123-456", "seoul");
        // TODO: person을 target에 저장하시오. 
        // END:
    }
    
    private static void read() {
        // TODO: target에서 person을 읽어서 내용을 출력하시오.
        // END:
    }
}
