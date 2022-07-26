package com.ssafy.offline3.equals;

public class Phone {

	String number = "전화번호";
	
	public Phone(String number) {
		this.number = number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Phone) {
			Phone casted = (Phone) obj;
			return number.equals(casted.number);
		}
		
		return false;
	}

}
