package com.ssafy.live2.poly;

import com.ssafy.live2.extend.person.Person;
import com.ssafy.live2.extend.person.SpiderMan;

public class AppropriateParameter {
    public void useJump1(Object obj) {
        if (obj instanceof Person) {
            Person casted = (Person) obj;
            casted.jump();
        }
    }

    public void useJump2(Person person) {
        person.jump();
    }

    public void useJump3(SpiderMan spiderMan) {
        spiderMan.jump();
    }

    public static void main(String[] args) {
        Object obj = new Object();
        Person person = new Person();
        SpiderMan sman = new SpiderMan();

        AppropriateParameter ap = new AppropriateParameter();
        // TODO:ap의 useJumpX를 obj, person, sman으로 호출해보세요.
        // END:

    }

}
