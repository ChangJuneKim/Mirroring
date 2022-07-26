package com.ssafy.offline3.single;

public class SingletonClass {
	
	// 4. getInstance 메서드 내부에서 사용해야 하므로 static 키워드를 붙여준다.
	static private SingletonClass instance;
	
	// 1. 외부에서 객체 생성을 막자!
	private SingletonClass() {
		
	}
	
	// 2. 외부에서 Singleton 객체를 사용할 수 있도록
	// Singleton 객체를 리턴하는 getter를 만들자!
	static public SingletonClass getInstance() {
		
		// 3. 객체를 하나만 생성하도록 조건문 추가
		if (instance == null) {
			instance = new SingletonClass();
		}
		
		return instance;
	}
}
