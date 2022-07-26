package com.ssafy.live3.inter.staticdefault;

interface Aircon {
    void makeCool();
    
    // @@TODOBLOCK: 2. 건조기능을 추가해보자.
    default void dry() {
        System.out.println("말려야하지 않을까?");
    }
    // @@END:
    
    // @@TODOBLOCK: 3.Aircon이 동작 방식에 대해 설명해보자.
    static void howto() {
        System.out.println("뜨거운 공기를 차갑게 만든다.");
    }
    // @@END:
    
}

class OldisButGoodies1 implements Aircon{
    @Override
    public void makeCool() {
        System.out.println("전체 냉각해줘");
    }
}

class OldisButGoodies2 implements Aircon{
    @Override
    public void makeCool() {
        System.out.println("집중 냉각해줘");
    }
}

// @@TODOBLOCK: 1. 무풍 에어컨을 구현해보자.
class NoWind1 implements Aircon {
	
    @Override
    public void makeCool() {
        System.out.println("바람은 없지만 시원해~~");
    }
    
    @Override
    public void dry() {
        System.out.println("건조 버튼 클릭");
    }
}

class NoWind2 implements Aircon{
    @Override
    public void makeCool() {
        System.out.println("집중 냉각해줘");
    }
    
    @Override
    public void dry() {
        System.out.println("종료 시키면 자동 건조");
    }
}
// @@END:

public class StaticDefaultMethod {
    public static void main(String[] args) {
    	
    	Aircon.howto();
    	
        Aircon [] aircons = {new OldisButGoodies1(), new OldisButGoodies2()};
        for(Aircon aircon: aircons) {
            if(aircon==null) {
                continue;
            }
            aircon.makeCool();
        }
    }
}
