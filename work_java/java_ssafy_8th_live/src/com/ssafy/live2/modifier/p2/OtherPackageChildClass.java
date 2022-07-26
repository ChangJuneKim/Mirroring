package com.ssafy.live2.modifier.p2;

import com.ssafy.live2.modifier.p1.Parent;
//@@TODOBLOCK: Parent를 상속받고 Parent의 member들에 접근해보세요.
//@@KEEPR: public class OtherPackageChildClass{
public class OtherPackageChildClass extends Parent {
    public void useMember() {
        this.publicVar = 10;
        this.protectVar = 10;
        // The field Parent.privVar is not visible
        //this.defaultVar = 10;
        // this.privVar = 10;
    }

    public void method() {
        Parent p = new Parent();
        p.publicVar = 10;
        //The field Parent.privVar is not visible
        // p.protectVar = 10;
        //p.defaultVar = 10;
        //p.privVar = 10;
    }
    // @@END:
}
