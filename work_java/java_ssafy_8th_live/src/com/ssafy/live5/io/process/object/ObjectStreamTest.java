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
        // @@TODOBLOCK: person을 target에 저장하시오. 
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target))) {
            // 객체 저장
            oos.writeObject(person);
            System.out.println("저정 완료!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // @@END:
    }
    
    private static void read() {
        // @@TODOBLOCK: target에서 person을 읽어서 내용을 출력하시오.
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target));) {
            // 객체 로딩
            Object readed = ois.readObject();

            if (readed != null && readed instanceof Person) {
                Person casted = (Person) readed;
                System.out.println("로딩 완료: "+casted);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // @@END:
    }
}
