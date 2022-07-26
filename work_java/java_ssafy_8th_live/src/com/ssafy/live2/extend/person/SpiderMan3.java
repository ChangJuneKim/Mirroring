// ##DELETE_FILE:
package com.ssafy.live2.extend.person;

class Person2 {
    String name;

    Person2(String name) {
        // super(); // --> Object의 기본 생성자 호출
        this.name = name;
        System.out.println("Person2(String name) 끝");
    }
}


public class SpiderMan3 extends Person2 {
    Spider spider;
    boolean isSpider;

    SpiderMan3(String name, Spider spider, boolean isSpider) {
        super(name);
        this.spider = spider;
        this.isSpider = isSpider;
        System.out.println("SpiderMan3(String name, Spider spider, boolean isSpider) 끝");
    }

    SpiderMan3(String name) {
        this(name, new Spider(), true);
        System.out.println("SpiderMan3(String name) 끝");
    }

    public static void main(String[] args) {
        new SpiderMan3("피터 파커");
    }
}
