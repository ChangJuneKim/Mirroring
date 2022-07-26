package com.ssafy.live4.collection.set;

// @@TODOBLOCK: SmartPhone이 다른 SmartPhone과 번호를 기준으로 비교가능하게 처리하시오.
// @@KEEPR: public class SmartPhone {
public class SmartPhone implements Comparable<SmartPhone> {
    @Override
    public int compareTo(SmartPhone o) {
        // 사전에 비교 가능한 기준이 있다면 그것들을 재사용하기
        return this.number.compareTo(o.number);
    }
    // @@END:

    String number;

    public SmartPhone(String number) {
        this.number = number;
    }

    public String toString() {
        return "전화 번호: " + number;
    }

    // @@TODOBLOCK: 동일한 번호의 SmartPhone이면 하나만 추가될 수 있도록 처리하시오.
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj instanceof SmartPhone) {
            SmartPhone param = (SmartPhone) obj;
            result = (this.number.equals(param.number));
        }
        return result;
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
    // @@END:

}
