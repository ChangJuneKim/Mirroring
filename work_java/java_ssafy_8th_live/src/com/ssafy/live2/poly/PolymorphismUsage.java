package com.ssafy.live2.poly;

import com.ssafy.live2.extend.person.Person;
import com.ssafy.live2.extend.person.SpiderMan;

public class PolymorphismUsage {
    public void useObjectArray() {
        // @@TODOBLOCK:Object []을 선언하고 다양한 객체를 저장하고 저장된 클래스 타입을 출력하세요.
        Object [] objs = new Object[3];
        objs[0] = new SpiderMan();
        objs[1] = new Person();
        objs[2] = 1; // auto boxing
        
        for(Object obj: objs) {
            System.out.println(obj+" : "+obj.getClass().getName());
        }
        // @@END:
    }
    
    public void useObjectParam() {
        System.out.println(1);
        System.out.println("Hello");
        System.out.println(new Person());
        System.out.println(new SpiderMan());
    }
    
    
    
    public static void main(String[] args) {
        PolymorphismUsage usage = new PolymorphismUsage();
        usage.useObjectArray();
        usage.useObjectParam();
    }
}
