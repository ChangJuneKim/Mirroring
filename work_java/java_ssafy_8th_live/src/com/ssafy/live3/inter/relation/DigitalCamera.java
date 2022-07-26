package com.ssafy.live3.inter.relation;


// @@TODOINLINE: DigitalCamera를 충전 가능하게 설정하시오.
// @@REPLACE:public class DigitalCamera extends Camera{ 
public class DigitalCamera extends Camera implements Chargeable{
    // @@TODOBLOCK: Chargeable을 구현하시오.
    @Override
    public void charge() {
        System.out.println("디카 충전");
    }    
    // @@END:
}
