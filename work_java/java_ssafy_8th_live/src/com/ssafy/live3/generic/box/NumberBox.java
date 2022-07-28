package com.ssafy.live3.generic.box;

public class NumberBox<T extends Number> {
	
	// T는 최소한 Number의 기능은 사용할 수 있다~
	public void addSome(T...ts) {
		double sum = 0;
		
		for (T t : ts) {
			sum += t.doubleValue();
		}
		
		System.out.println(sum);
	}
}
