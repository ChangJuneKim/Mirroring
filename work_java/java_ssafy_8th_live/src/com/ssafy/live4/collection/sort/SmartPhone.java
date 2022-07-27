package com.ssafy.live4.collection.sort;

public class SmartPhone implements Comparable<SmartPhone>{
	private String number;
	
	public SmartPhone(String number) {
		this.number = number;
	}

	@Override
	public int compareTo(SmartPhone o) {
		// String 클래스의 compareTo 메서드를 재사용
		// 폰 번호 기준으로 오름차순 정렬이 된다.
		return this.number.compareTo(o.number);
	}

	@Override
	public String toString() {
		return "전화번호 : " +  this.number;
	}
	
	
}
