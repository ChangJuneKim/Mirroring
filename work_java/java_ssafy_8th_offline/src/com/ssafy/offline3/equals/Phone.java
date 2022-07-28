package com.ssafy.offline3.equals;

public class Phone {

	public String number;

	public Phone(String number) {
		// TODO Auto-generated constructor stub
		this.number = number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Phone) {
			Phone casted = (Phone) obj;
			
			return number.equals(casted.number);
		}
		return false;
	}
}
