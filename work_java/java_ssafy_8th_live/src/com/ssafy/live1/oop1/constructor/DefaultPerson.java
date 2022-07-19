package com.ssafy.live1.oop1.constructor;

public class DefaultPerson {
    String name;
    int age ;
    boolean isHungry;

    //public DefaultPerson() {} -- 생략된 기본 생성자

    public static void main(String[] args) {
      DefaultPerson person = new DefaultPerson();
      person.name = "홍길동";
      person.age = 10;
      person.isHungry = false;
    }
  }


