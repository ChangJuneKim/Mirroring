package com.ssafy.live3.generic.wild;

import com.ssafy.live3.generic.box.GenericBox;

public class UseWildCardTest2 {

    public void useWildCardTypeMethod() {
        GenericBox<Double> dBox = new GenericBox<>();
        dBox.setSome(3.14);
        printInfo(dBox);


        GenericBox<Integer> iBox = new GenericBox<>();
        iBox.setSome(3);
        printInfo(iBox);
        
    }
    
    // @@TODOBLOCK:GenericBox<Double>과 GenericBox<Integer>의 내용을 확인하는 메서드를 작성해보자.
    // @@KEEPR: public void printInfo(Object wild){}
    //public void printInfo(GenericBox wild) { 
    //public void printInfo(GenericBox<?> wild) {
    public void printInfo(GenericBox<? extends Number> wild) {
        // 최소한 Number 이하의 것들이므로 Number의 getXX 가능
        System.out.printf("정수? %d, 실수? %f%n",wild.getSome().intValue(), wild.getSome().doubleValue());
        // 하지만 set과정에서 어떤 타입이 들어갈지 알수 없으므로 설정하는 메서드 호출은 불가능 
        // wild.setSome(3.14);
        // wild.setSome(123);
    }
    // @@END:


    public static void main(String[] args) {
        UseWildCardTest2 test = new UseWildCardTest2();
        test.useWildCardTypeMethod();
    }
}
