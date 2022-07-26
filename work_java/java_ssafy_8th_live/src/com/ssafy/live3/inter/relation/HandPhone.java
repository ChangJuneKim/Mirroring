package com.ssafy.live3.inter.relation;

//@@TODOINLINE: HandPhone를 충전 가능하게 설정하시오.
//@@REPLACE:public class HandPhone extends Phone{ 
public class HandPhone extends Phone implements Chargeable {
    // @@TODOBLOCK: Chargeable을 구현하시오.
    @Override
    public void charge() {
        System.out.println("헨펀 충전!!");
    }    
    // @@END:
}
