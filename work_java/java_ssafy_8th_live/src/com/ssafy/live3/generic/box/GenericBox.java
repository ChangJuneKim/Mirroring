package com.ssafy.live3.generic.box;

public class GenericBox<T> { // T는 무언가 타입이다.!!!
	private T some;
	
	public GenericBox() {}
	
	public GenericBox(T some) {
		super();
		this.some = some;
	}


	public T getSome() {
		return some;
	}

	public void setSome(T some) {
		this.some = some;
	}
	
	
}
